/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenge.repository.dao;

import challenge.repository.bean.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Carlos Roberto B. Meneghette
 *
 * @date 2019-09-28
 *
 */
@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer> {

}
