/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenge.repository.dao;

import challenge.repository.bean.Category;
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
    CategoryRepositoryTest.ContextConfig.class
})
@DataJpaTest
@EnableAutoConfiguration
@EntityScan(basePackages = "challenge.repository.bean")
public class CategoryRepositoryTest {

    private static final Logger LOGGER
            = LoggerFactory.getLogger(CategoryRepositoryTest.class);

    @Configuration
    public static class ContextConfig {

    }

    @Autowired
    private CategoryRepository instance;

    public CategoryRepositoryTest() {
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
    public void testFindAll() {
        LOGGER.debug("findAll");

        List<Category> result = StreamSupport.stream(
                instance.findAll().spliterator(), false)
                .collect(Collectors.toList());

        result.stream().forEach(entry -> {
            LOGGER.debug("{}", entry);
        });
        
        assertFalse(result.isEmpty());
    }

}
