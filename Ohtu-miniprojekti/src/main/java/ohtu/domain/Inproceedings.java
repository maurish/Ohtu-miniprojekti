package ohtu.domain;

import java.util.Map;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table
public class Inproceedings extends Reference {

    @NotBlank
    @Length(max = 35, min = 1)
    private String bookTitle;
    private String pubMonth;
    private String organisation;

    public String getPubMonth() {
        return pubMonth;
    }

    public void setPubMonth(String pubMonth) {
        this.pubMonth = pubMonth;
    }

    public String getOrganisation() {
        return organisation;
    }

    public void setOrganisation(String organisation) {
        this.organisation = organisation;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }



    @Override
    public Map<String, Object> getAttributes() {
        Map<String, Object> attributes = super.getAttributes();
        attributes.put("pubMonth", pubMonth);
        attributes.put("booktitle", bookTitle);
        attributes.put("organisation", organisation);
        return attributes;
    }

    @Override
    public String toString() {
        return "Inproceedings{" + "bookTitle=" + bookTitle + ", pubMonth=" + pubMonth + ", organisation=" + organisation + '}';
    }

    
}
