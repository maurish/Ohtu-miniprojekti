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
public class Article extends Reference {
    
    @NotBlank
    @Length(max=35, min=1)
    private String journal;
    @NotBlank
    @Length(max=4, min=3)
    private int pubYear;
    private int volume;
    private int number;
    private String pubMonth;
    private String pages;
    private String publisher;
    private String address;

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

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
    
    
    public int getpubYear() {
        return this.pubYear;
    }
    
    public void setpubYear(int year) {
        this.pubYear = year;
    }
    

    public String getJournal() {
        return journal;
    }

    public void setJournal(String journal) {
        this.journal = journal;
    }
    
//     public String toBibtex() {
//        return "@article"+super.toBibtex()+ ", \n "
//                + "journal = " + '"' + journal + '"' + " }";
//    }
    
}
