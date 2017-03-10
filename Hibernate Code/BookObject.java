package test;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "book", schema = "hibernateDB", catalog = "")
public class BookObject {

    private String genre;
    private String author;
    private int releaseYear;
    private String coverArtist;
    private String bookName;

    @Id
    @Column(name = "id")
    private int id;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @OneToMany(mappedBy = "BookObject")
    private List<BookInformationObject> BookInformationObject;

    public List<BookInformationObject> getBookInformationObject() {
        return BookInformationObject;
    }

    public void setBookInformationObject(List<BookInformationObject> BookInformationObject) {
        this.BookInformationObject = BookInformationObject;
    }

    @Basic
    @Column(name = "genre")
    public String getgenre() {
        return genre;
    }

    public void setgenre(String genre) {
        this.genre = genre;
    }

    @Basic
    @Column(name = "author")
    public String getauthor() {
        return author;
    }

    public void setauthor(String author) {
        this.author = author;
    }

    @Basic
    @Column(name = "releaseYear")
    public int getreleaseYear() {
        return releaseYear;
    }

    public void setreleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    @Basic
    @Column(name = "coverArtist")
    public String getcoverArtist() {
        return coverArtist;
    }

    public void setcoverArtist(String coverArtist) {
        this.coverArtist = coverArtist;
    }

    @Basic
    @Column(name = "bookName")
    public String getbookName() {
        return bookName;
    }

    public void setbookName(String bookName) {
        this.bookName = bookName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookObject BookObject = (BookObject) o;

        if (id != BookObject.id) return false;
        if (releaseYear != BookObject.releaseYear) return false;
        if (genre != null ? !genre.equals(BookObject.genre) : BookObject.genre != null) return false;
        if (author != null ? !author.equals(BookObject.author) : BookObject.author != null) return false;
        if (coverArtist != null ? !coverArtist.equals(BookObject.coverArtist) : BookObject.coverArtist != null) return false;
        if (bookName != null ? !bookName.equals(BookObject.bookName) : BookObject.bookName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (genre != null ? genre.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + releaseYear;
        result = 31 * result + (coverArtist != null ? coverArtist.hashCode() : 0);
        result = 31 * result + (bookName != null ? bookName.hashCode() : 0);
        return result;
    }
}
