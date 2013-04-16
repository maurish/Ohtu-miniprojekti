/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author svanteha
 */
@Entity
@Table
public class Article extends Reference {
    
    @NotBlank
    @Length(max=35, min=1)
    private String journal;
    private Integer volume;
    private Integer number;
    private String pubMonth;
    private String pages;
    private String publisher;
    private String address;


    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getJournal() {
        return journal;
    }

    public void setJournal(String journal) {
        this.journal = journal;
    }
    
     public String toBibtex() {
        return "@article"+super.toBibtex()+ ", \n "
                + "journal =  \"" + journal + "\" \n"
                + "number = \"" + number + "\" "
                + "publish month = \"" + pubMonth + "\" "
                + "pages = \"" + pages + "\" "
                + "publisher = \"" + publisher + "\" "
                + "address = \"" + address + "\" "
                + "volume = \"" + volume + "\"}\n";
    }
    
}
