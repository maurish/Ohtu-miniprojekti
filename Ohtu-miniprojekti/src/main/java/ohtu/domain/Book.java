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

    public Book(String publisher, String author, String title, Integer pubYear, String refId) {
        super(author, title, pubYear, refId);
        this.publisher = publisher;
    }

    public Book() {
    }
    

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


    @Override
    public Map<String, Object> getAttributes() {
        final Map<String, Object> attributes = super.getAttributes();
        attributes.put("editor", editor);
        attributes.put("publisher", publisher);
        return attributes;
    }
}
