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
public class Article extends Reference {
    
    String journal;

    public String getJournal() {
        return journal;
    }

    public void setJournal(String journal) {
        this.journal = journal;
    }
    
     public String toBibtex() {
        return "@article"+super.toBibtex()+ ", \n "
                + "journal = " + '"' + journal + '"' + " }";
    }
    
}
