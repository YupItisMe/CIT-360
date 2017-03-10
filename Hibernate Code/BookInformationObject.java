package test;

import javax.persistence.*;


@Entity
@Table(name = "book_Condition", schema = "hibernateDB", catalog = "")
public class BookInformationObject {

    private String quality;
    private String purchaseDate;
    private int numericCondition; //A number based on 1-10 on the quality of the book

    @Id
    @Column(name = "id")
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id")
    private BookObject BookObject;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id")
    private AuthorObject AuthorObject;

    public BookObject getBookObject() {
        return BookObject;
    }

    public void setBookObject(BookObject BookObject) {
        this.BookObject = BookObject;
    }

    public AuthorObject getAuthorObject() {
        return AuthorObject;
    }

    public void setAuthorObject(AuthorObject AuthorObject) {
        this.AuthorObject = AuthorObject;
    }

    @Basic
    @Column(name = "quality")
    public String getquality() {
        return quality;
    }

    public void setquality(String quality) {
        this.quality = quality;
    }

    @Basic
    @Column(name = "purchaseDate")
    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    @Basic
    @Column(name = "numericCondition")
    public int getIsCurrentOwner() {
        return numericCondition;
    }

    public void setIsCurrentOwner(int isCurrentOwner) {
        this.numericCondition = isCurrentOwner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookInformationObject that = (BookInformationObject) o;

        if (id != that.id) return false;
        if (numericCondition != that.numericCondition) return false;
        if (quality != null ? !quality.equals(that.quality) : that.quality != null) return false;
        if (purchaseDate != null ? !purchaseDate.equals(that.purchaseDate) : that.purchaseDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (quality != null ? quality.hashCode() : 0);
        result = 31 * result + (purchaseDate != null ? purchaseDate.hashCode() : 0);
        result = 31 * result + numericCondition;
        return result;
    }
}
