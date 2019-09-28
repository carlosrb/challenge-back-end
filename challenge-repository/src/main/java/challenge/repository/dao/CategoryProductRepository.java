/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenge.repository.dao;

import challenge.repository.bean.CategoryProduct;
import challenge.repository.bean.CategoryProductKey;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author carlos
 */
@Repository
public interface CategoryProductRepository
        extends CrudRepository<CategoryProduct, CategoryProductKey> {

    public Iterable<CategoryProduct> findByCategoryId(Long categoryId);
    
}
