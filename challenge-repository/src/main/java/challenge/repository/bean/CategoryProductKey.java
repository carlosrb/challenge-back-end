/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenge.repository.bean;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 *
 * @author carlos
 */
@Embeddable
public class CategoryProductKey implements Serializable {

    @Column(name = "category_id")
    private Long categoryId;

    @Column(name = "product_id")
    private Long productId;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof CategoryProductKey) {
            final CategoryProductKey key = (CategoryProductKey) o;
            return Objects.equals(categoryId, key.getCategoryId())
                    && Objects.equals(productId, key.getProductId());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.categoryId, this.productId);
    }

    /**
     * @return the categoryId
     */
    public Long getCategoryId() {
        return categoryId;
    }

    /**
     * @param categoryId the categoryId to set
     */
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * @return the productId
     */
    public Long getProductId() {
        return productId;
    }

    /**
     * @param productId the productId to set
     */
    public void setProductId(Long productId) {
        this.productId = productId;
    }

}
