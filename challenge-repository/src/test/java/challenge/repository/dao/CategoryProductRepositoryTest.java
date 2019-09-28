/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenge.repository.dao;

import challenge.repository.bean.CategoryProduct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author carlos
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {
    CategoryProductRepositoryTest.ContextConfig.class
})
@DataJpaTest
@EnableAutoConfiguration
@EntityScan(basePackages = "challenge.repository.bean")
public class CategoryProductRepositoryTest {

    private static final Logger LOGGER
            = LoggerFactory.getLogger(CategoryProductRepositoryTest.class);

    @Configuration
    public static class ContextConfig {

    }

    @Autowired
    private CategoryProductRepository instance;

    public CategoryProductRepositoryTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void tetFindAll() {
        LOGGER.debug("findAll");

        List<CategoryProduct> result = StreamSupport.stream(
                instance.findAll().spliterator(), false)
                .collect(Collectors.toList());

        result.stream().forEach(entry -> {
            LOGGER.debug("{}", entry);
        });
        
        assertFalse(result.isEmpty());
    }
    
    @Test
    public void testFindByCategoryId() {
        LOGGER.debug("findByCategoryId");

        List<CategoryProduct> result = StreamSupport.stream(
                instance.findByCategoryId(1L).spliterator(), false)
                .collect(Collectors.toList());

        result.stream().forEach(entry -> {
            LOGGER.debug("{}", entry);
        });
        
        assertFalse(result.isEmpty());
    }

}
