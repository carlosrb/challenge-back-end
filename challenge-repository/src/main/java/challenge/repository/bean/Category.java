/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenge.repository.bean;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 *
 * @author Carlos Roberto B. Meneghette
 *
 * @date 2019-09-28
 *
 */
@Entity
public class Category implements Serializable {

    @Id
    private Long id;
    
    @Column(name = "name", length = 80)
    private String name;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

}
