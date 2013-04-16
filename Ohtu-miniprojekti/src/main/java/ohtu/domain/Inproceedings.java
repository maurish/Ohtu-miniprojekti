/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author svanteha
 */
@Entity
@Table
public class Inproceedings extends Reference {
    @NotBlank
    @Length(max=35, min=1)
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
     public String toBibtex() {
        return "@inproceeding"+super.toBibtex()+ ", \n "
                + "book title =  \"" + bookTitle + "\" \n"
                + "publish month = \"" + pubMonth + "\" "
                + "organisation = \"" + organisation + "\"}\n";
    }
}
