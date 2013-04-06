/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author annisall
 */
@Entity
@Table
public class Book extends Reference {

    String publisher;

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    
    public String toBibtex() {
        return "@book"+super.toBibtex()+ ", \n "
                + "publisher = " + '"' + publisher + '"' + " }";
    }
    


}
