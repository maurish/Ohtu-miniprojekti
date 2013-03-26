package ohtu.domain;

public class Reference {
    
    private String author;
    private String refName;

    public Reference(String author, String name) {
        this.author = author;
        this.refName = name;
    }

    public void setName(String name) {
        this.refName = name;
    }

    public String getName() {
        return refName;
    }

    @Override
    public String toString() {
        return "Reference{" + "author=" + author + '}';
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
