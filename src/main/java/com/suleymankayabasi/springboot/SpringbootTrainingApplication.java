package com.suleymankayabasi.springboot;

import com.suleymankayabasi.springboot.entity.Category;
import com.suleymankayabasi.springboot.entity.Product;
import com.suleymankayabasi.springboot.service.entityService.CategoryEntityService;
import com.suleymankayabasi.springboot.service.entityService.ProductEntityService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


@SpringBootApplication
public class  SpringbootTrainingApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringbootTrainingApplication.class, args);
        CategoryEntityService categoryEntityService = applicationContext.getBean(CategoryEntityService.class);
        ProductEntityService productEntityService = applicationContext.getBean(ProductEntityService.class);

    }

    private static void saveBookandBook1(CategoryEntityService categoryEntityService){
        Category book = new Category();
        book.setName("Kitap");
        book.setBreakDown(1L);
        book = categoryEntityService.save(book);

        Category book1 = new Category();
        book1.setName("Kitap1");
        book1.setBreakDown(2L);
        book1.setTopCategory(book);

        categoryEntityService.save(book1);
    }

    private static void saveSportsAndFitnessCategory(CategoryEntityService categoryEntityService){
        Category sport = new Category();
        sport.setName("Spor");
        sport.setBreakDown(1L);
        categoryEntityService.save(sport);

        Category fitness = new Category();
        fitness.setName("Fitness");
        fitness.setBreakDown(2L);
        fitness.setTopCategory(sport);
        categoryEntityService.save(fitness);
    }

    private static void findAllCategoryList(CategoryEntityService categoryEntityService){
        List<Category> categoryList = categoryEntityService.findAll();

        for(Category category:categoryList){
            System.out.println(category.getName());
        }
    }

    private static void findAllProductList(ProductEntityService productEntityService){
        List<Product> productList = productEntityService.findAll();

        for(Product product:productList){
            System.out.println(product.getName());
        }
    }

    public static void  deletepProductListById(ProductEntityService productEntityService){
        List<Long> deleteList = Arrays.asList(102L,152L);

        for(Long productId: deleteList){
            productEntityService.deleteById(productId);
        }
    }

    public static void  getSamsungM31(CategoryEntityService categoryEntityService,ProductEntityService productEntityService){
        Category category = categoryEntityService.findById(502L);

        Product product = new Product();
        product.setName("Samsung M31");
        product.setPrice(new BigDecimal("3000"));
        product.setRegistrationDate(new Date());
        product.setCategory(category);

        product = productEntityService.save(product);
        System.out.println(product.toString());
    }

    public static Category getPhoneCategory(CategoryEntityService categoryEntityService){

        Category topCategory = categoryEntityService.findById(2L);
        System.out.println(topCategory);

        Category category = new Category();
        category.setName("Telefon");
        category.setBreakDown(2L);
        category.setTopCategory(topCategory);
        category = categoryEntityService.save(category);
        System.out.println(category);
        return  category;
    }
}
