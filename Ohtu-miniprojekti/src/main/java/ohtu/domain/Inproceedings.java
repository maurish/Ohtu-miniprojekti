/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author svanteha
 */
@Entity
@Table
public class Inproceedings extends Reference {
    
    private String bookTitle;
    private int pubYear;
    
     public int getpubYear() {
        return this.pubYear;
    }
    
    public void setpubYear(int year) {
        this.pubYear=year;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }
//     public String toBibtex() {
//        return "@inproceeding"+super.toBibtex()+ ", \n "
//                + "book title = " + '"' + bookTitle + '"' + " }";
//    }
}
