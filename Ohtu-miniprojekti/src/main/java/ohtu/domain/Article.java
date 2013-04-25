/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.domain;

import java.util.Map;
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

    public String getPubMonth() {
        return pubMonth;
    }

    public void setPubMonth(String pubMonth) {
        this.pubMonth = pubMonth;
    }
    
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
     
      @Override
    public Map<String, Object> getAttributes() {
        final Map<String, Object> attributes = super.getAttributes();
        attributes.put("journal", journal);
        attributes.put("publisher", publisher);
        attributes.put("volume", volume);
        attributes.put("number", number);
        attributes.put("month", pubMonth);
        attributes.put("pages", pages);
        attributes.put("address", address);
        return attributes;
    }
    
}
