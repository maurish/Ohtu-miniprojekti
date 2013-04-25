package ohtu.domain;

import java.util.HashMap;
import java.util.Map;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import ohtu.validator.WhiteSpaceless;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

@Entity
@Table
public class Reference {

    @Id
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
    @WhiteSpaceless
    @NotBlank
    private String refId;

    public Integer getPubYear() {
        return pubYear;
    }

    public void setPubYear(Integer pubYear) {
        this.pubYear = pubYear;
    }

    public Reference(String author, String title, Integer pubYear, String refId) {
        this.author = author;
        this.title = title;
        this.pubYear = pubYear;
        this.refId = refId;
    }



    public Reference() {
    }

    public String getRefId() {
        return refId;
    }

    public void setRefId(String refId) {
        this.refId = refId;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Map<String, Object> getAttributes() {
        HashMap<String, Object> ret = new HashMap<String, Object>();
        ret.put("title", title);
        ret.put("author", author);
        ret.put("pubYear", pubYear);
        return ret;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 67 * hash + (this.author != null ? this.author.hashCode() : 0);
        hash = 67 * hash + (this.title != null ? this.title.hashCode() : 0);
        hash = 67 * hash + (this.pubYear != null ? this.pubYear.hashCode() : 0);
        hash = 67 * hash + (this.refId != null ? this.refId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Reference other = (Reference) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        if ((this.author == null) ? (other.author != null) : !this.author.equals(other.author)) {
            return false;
        }
        if ((this.title == null) ? (other.title != null) : !this.title.equals(other.title)) {
            return false;
        }
        if (this.pubYear != other.pubYear && (this.pubYear == null || !this.pubYear.equals(other.pubYear))) {
            return false;
        }
        if ((this.refId == null) ? (other.refId != null) : !this.refId.equals(other.refId)) {
            return false;
        }
        return true;
    }

    
 
}
