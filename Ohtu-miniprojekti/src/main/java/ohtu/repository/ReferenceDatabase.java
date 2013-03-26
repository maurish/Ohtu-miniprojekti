/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.repository;

import java.sql.SQLException;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;


/**
 *
 * @author svanteha
 */
@Component
public class ReferenceDatabase {

    private JdbcTemplate jdbcTemplate;
    
    @Autowired
    public final void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
   
}
