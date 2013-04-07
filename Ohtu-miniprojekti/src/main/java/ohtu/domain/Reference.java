package ohtu.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table
public class Reference {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @NotBlank(message = "author must be defined")
    @Length(max = 250, min = 1)
    String author;
    @NotBlank(message = "title must be defined")
    String title;

    public Reference(String author, String title) {
        this.author = author;
        this.title = title;
    }

    public Reference() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Reference{" + "author=" + author + '}';
    }

    public String toBibtex() {
        return "{ \n"
                + "author = "+ '"' + author+ '"' + ",\n"
                + " title = " + '"' +title + '"' + " ";
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
