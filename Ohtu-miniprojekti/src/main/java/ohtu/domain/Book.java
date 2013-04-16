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
 * @author annisall
 */
@Entity
@Table
public class Book extends Reference {

    @NotBlank
    @Length(max = 35, min = 1)
    private String publisher;
    private String editor;

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

//    public String toBibtex() {
//        return "@book" + super.toBibtex() + ""
//                + " publisher = \"" + publisher + "\",\n"
//                + " editor = \"" + editor + "\"}\n";
//    }

    @Override
    public Map<String, Object> attributes() {
        final Map<String, Object> attributes = super.attributes();
        attributes.put("editor", editor);
        attributes.put("publisher", publisher);
        return attributes;
    }
}
