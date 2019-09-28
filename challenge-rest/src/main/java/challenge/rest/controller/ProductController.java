/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenge.rest.controller;

import challenge.repository.bean.Product;
import challenge.repository.dao.CategoryProductRepository;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Carlos Roberto B. Meneghette
 *
 * @date 2019-09-28
 *
 */
@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private CategoryProductRepository categoryProductRepository;

    @GetMapping("listByCategory/{categoryId}")
    public ResponseEntity<Iterable<Product>> getByCategory(
            @PathVariable("categoryId") long categoryId) {

        return new ResponseEntity<>(StreamSupport.stream(
                categoryProductRepository.findByCategoryId(categoryId)
                        .spliterator(), false).map(cp -> cp.getProduct())
                .collect(Collectors.toList()),
                HttpStatus.OK);
    }

}
