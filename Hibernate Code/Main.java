package test;

import javax.persistence.*;
import java.security.acl.Owner;
import java.util.List;
import java.util.Scanner;
import java.util.Date;

// Had to talk and discuss hibernate with several people to produce this code
public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("NewPersistenceUnit");

        Scanner input = new Scanner(System.in);

        String userInput;


        String action = null;
        while(action != "0") {
            System.out.println("\nWhat is your command?");
            System.out.println("1 - See list of Books\n");
            System.out.println("2 - Add a Book\n");
            System.out.println("3 - See list owners and their Books\n");
            System.out.println("4 - Add an Author\n");
            System.out.println("5 - Add an Author to a Book\n");
            System.out.println("6 - Remove a Book\n");
            System.out.println("7 - Remove an owner\n");
            System.out.println("8 - Remove an owner from a Book\n");
            System.out.println("0 - Quit\n");

            userInput = input.nextLine();
            switch(userInput){
                case "1":
                    selectBook(emf);
                    break;

                case "2":
                    addBook(emf, input);
                    break;

                case "3":
                    listAuthorAndBooks(emf);
                    break;

                case "4":
                    addAuthor(emf, input);
                    break;

                case "5":
                    addAuthorToBook(emf, input);
                    break;

                case "6":
                    removeBook(emf, input);
                    break;

                case "7":
                    removeAuthor(emf, input);
                    break;

                case "8":
                    removeBook(emf, input);
                    break;

                case "0":
                    return;

                default:
                    break;
            }
        }


    }

    public static void selectBook(EntityManagerFactory emf){

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        System.out.println("All books currently available:");

        List<BookObject> BookE = em.createQuery("from BookObject").getResultList();
        for (BookObject temp : BookE) {
            System.out.println(temp.getgenre() + " " + temp.getauthor() + " " + temp.getbookName() + " " + temp.getreleaseYear());
        }

        em.close();

    }

    public static void addBook(EntityManagerFactory emf, Scanner input){

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        String[]userInput = input.nextLine().split(" ");
        BookObject newBook = new BookObject();

        newBook.setgenre(userInput[0]);
        newBook.setreleaseYear(Integer.parseInt(userInput[1]));
        newBook.setcoverArtist(userInput[2]);
        newBook.setbookName(userInput[3]);

        em.persist(newBook);
        em.flush();
        em.getTransaction().commit();
        System.out.println("Book Successfully Added");
        em.close();


    }

    public static void listAuthorAndBooks(EntityManagerFactory emf){
    	
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        List<BookInformationObject> BookOwners = em.createQuery("from BookInformationObject ").getResultList();
        for (BookInformationObject BookOwner: BookOwners) {
            System.out.println(BookOwner.getBookObject().getgenre() + " " + BookOwner.getBookObject().getauthor() + "\t" + BookOwner.getBookObject().getreleaseYear() +
                                " " + BookOwner.getBookObject().getauthor() + " " + BookOwner.getBookObject().getgenre() + " " + BookOwner.getBookObject().getcoverArtist());
        }
        em.close();
    }

    public static void addAuthor(EntityManagerFactory emf, Scanner input){

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();


        System.out.println("Please enter the Author's first and last name:");

        String[] name = input.nextLine().split(" ");
        BookObject newSet = new BookObject();
        newSet.setgenre(name[0]);
        newSet.setbookName(name[1]);

        em.persist(newSet);
        em.flush();

        em.getTransaction().commit();
        System.out.println("Author Successfully Added");
        em.close();
    }

    public static void addAuthorToBook(EntityManagerFactory emf, Scanner input){

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        System.out.println("Please select an Author from the list");

        List<BookObject> bookList = em.createQuery("from BookObject ").getResultList();
        int count = 0;
        for (BookObject temp : bookList) {
            System.out.println(count + ". " +temp.getgenre() + " " + temp.getbookName());
            count++;
        }

        int ownerNum = input.nextInt();
        BookObject newSet = new BookObject();
        newSet = bookList.get(ownerNum);

        List<BookObject> newbookList = em.createQuery("from BookObject").getResultList();
        System.out.println("Which book would you like to add an author to?");
        count = 0;
        for (BookObject temp : bookList) {
            System.out.println(count + ". " + temp.getgenre() + " " + temp.getreleaseYear() + " " + temp.getauthor() + " " + temp.getcoverArtist());
            count++;
        }

        int bookNum = input.nextInt();
        BookObject bookOwner = new BookObject();
        bookOwner = bookList.get(bookNum);
        BookInformationObject newBookInformationObject = new BookInformationObject();

        newBookInformationObject.setBookObject(newSet); 
        newBookInformationObject.setBookObject(bookOwner); 
        newBookInformationObject.setIsCurrentOwner(1);
        Date date = new Date();
        newBookInformationObject.setPurchaseDate(date.toString());
     
        em.persist(newBookInformationObject);
        em.flush();
        em.getTransaction().commit();
        System.out.println("Successfully added new Owner to Book");
        em.close();
    }


    public static void  removeBook(EntityManagerFactory emf, Scanner input){

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        List<BookObject> bookList = em.createQuery("from BookObject").getResultList();
        System.out.println("Please select the book you would like to remove:");

        int count = 0;
        for (BookObject temp : bookList) {
            System.out.println(count + ". " + temp.getbookName() + " " + temp.getgenre() + " " + temp.getauthor() + " " + temp.getreleaseYear());
            count++;
        }

        int bookNum = input.nextInt();
        Query q = em.createQuery("delete BookInformationObject where BookObject.id=:p").setParameter("p", bookList.get(bookNum).getId());


        Query query = em.createQuery( "DELETE BookObject c WHERE c.id = :p").setParameter("p", bookList.get(bookNum).getId());
        q.executeUpdate();
        query.executeUpdate();

        em.getTransaction().commit();
        System.out.println("Book is GOOOOOOOOOONNNNNNNNNNNEEEEEEEEEEE");
    }

    public static void  removeAuthor(EntityManagerFactory emf, Scanner input){

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        List<BookObject> bookList = em.createQuery("from BookObject").getResultList();
        System.out.println("Please select the owner you would like to remove:");

        int count = 0;
        for (BookObject temp : bookList) {
            System.out.println(count + ". " + temp.getbookName() + " " + temp.getgenre());
            count++;
        }

        int ownerNum = input.nextInt();
        Query q = em.createQuery("delete BookInformationObject where BookObject.id=:p").setParameter("p", bookList.get(ownerNum).getId());
        Query query = em.createQuery( "DELETE BookObject c WHERE c.id = :p").setParameter("p", bookList.get(ownerNum).getId());
        q.executeUpdate();
        query.executeUpdate();
        em.getTransaction().commit();
        System.out.println("Successfully deleted Author");
        em.close();
    }

    public static void  removecoverArtist(EntityManagerFactory emf, Scanner input){

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        List<BookObject> bookList = em.createQuery("from BookObject").getResultList();

        System.out.println("Please select the Book:");

        int count = 0;
        for (BookObject temp : bookList) {
            System.out.println(count + ". " + temp.getbookName() + " " + temp.getgenre());
            count++;
        }

        int ownerNum = input.nextInt();
        System.out.println("Which book would you like to tranfer");


        count = 0;
        List<BookInformationObject> AuthorBookList = em.createQuery("from BookInformationObject WHERE BookObject.id=:p").setParameter("p",bookList.get(ownerNum).getId()).getResultList();

        for (BookInformationObject temp : AuthorBookList) {
            System.out.println(count + ". " + temp.getBookObject().getgenre() + " " + temp.getBookObject().getauthor() + " " + temp.getBookObject().getbookName() + " " + temp.getBookObject().getgenre());
            count++;
        }

        int bookNum = input.nextInt();
        Query query = em.createQuery("delete BookInformationObject where BookObject.id=:p AND BookObject.id=:q").setParameter("p", bookList.get(ownerNum).getId()).setParameter("q", AuthorBookList.get(bookNum).getBookObject().getId());

        query.executeUpdate();
        em.getTransaction().commit();
        System.out.println("Successfully remove owner from Book");
        em.close();
    }

}




