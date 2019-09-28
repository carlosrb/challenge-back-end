/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenge.repository.bean;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 *
 * @author Carlos Roberto B. Meneghette
 *
 * @date 2019-09-28
 *
 */
@Entity
public class CategoryProduct implements Serializable {

    @EmbeddedId
    private CategoryProductKey id;

    @ManyToOne
    @MapsId("category_id")
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @MapsId("product_id")
    @JoinColumn(name = "product_id")
    private Product product;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
    
    /**
     * @return the id
     */
    public CategoryProductKey getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(CategoryProductKey id) {
        this.id = id;
    }

    /**
     * @return the category
     */
    public Category getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     * @return the product
     */
    public Product getProduct() {
        return product;
    }

    /**
     * @param product the product to set
     */
    public void setProduct(Product product) {
        this.product = product;
    }

}
