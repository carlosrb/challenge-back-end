/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenge.rest.controller;

import challenge.repository.bean.Category;
import challenge.repository.dao.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("listAll")
    public ResponseEntity<Iterable<Category>> getAll() {
        return new ResponseEntity<>(categoryRepository.findAll(),
                HttpStatus.OK);
    }

}
