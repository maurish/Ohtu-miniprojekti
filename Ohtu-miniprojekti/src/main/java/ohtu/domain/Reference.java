package ohtu.domain;

public class Reference {

    private String author;
    private String name;

    public Reference(String author, String name) {
        this.author = author;
        this.name = name;
    }

    public Reference() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
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
