package ohtu.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

@Entity
@Table
public class Reference {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @NotBlank(message = "author must be defined")
    @Length(max = 250, min = 1)
    private String author;
    @NotBlank(message = "title must be defined")
    private String title;
    @NotNull
    @NumberFormat(style = Style.NUMBER)
    @Min(1900)
    @Max(2013)
    private Integer pubYear;

    public Integer getPubYear() {
        return pubYear;
    }

    public void setPubYear(Integer pubYear) {
        this.pubYear = pubYear;
    }

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

    public String toBibtex() {
        return "{ \n"
                + "  author = \"" + author+ "\" ,\n"
                + "  title = \"" +title + "\" \n"
                + "  publish year = \"" + pubYear + "\"\n ";
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
