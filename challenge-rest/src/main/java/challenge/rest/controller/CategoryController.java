/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenge.rest.controller;

import challenge.repository.bean.Category;
import challenge.repository.dao.CategoryRepository;
import java.util.Collections;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.apache.commons.lang3.StringUtils;
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
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("listAll")
    public ResponseEntity<Iterable<Category>> getAll() {
        return new ResponseEntity<>(categoryRepository.findAll(),
                HttpStatus.OK);
    }

    @GetMapping("listWith/{letter}")
    public ResponseEntity<List<Category>> getWith(
            @PathVariable("letter") String letter) {

        final List<Category> categories
                = StreamSupport.stream(categoryRepository.findAll()
                        .spliterator(), false).collect(Collectors.toList());

        final OptionalInt max = categories.stream()
                .mapToInt(entry -> StringUtils.countMatches(
                entry.getName().toLowerCase(), letter.toLowerCase())).max();

        final List<Category> result;
        if (max.isPresent() && max.getAsInt() > 0) {
            result = categories.stream()
                    .filter(entry -> StringUtils.countMatches(
                    entry.getName().toLowerCase(),
                    letter.toLowerCase()) == max.getAsInt())
                    .collect(Collectors.toList());
        } else {
            result = Collections.emptyList();
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
