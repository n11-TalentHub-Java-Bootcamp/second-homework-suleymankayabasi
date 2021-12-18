package com.suleymankayabasi.springboot.controller;

import com.suleymankayabasi.springboot.converter.CategoryConverter;
import com.suleymankayabasi.springboot.converter.ProductConverter;
import com.suleymankayabasi.springboot.dto.CategoryDto;
import com.suleymankayabasi.springboot.dto.ProductDetailDto;
import com.suleymankayabasi.springboot.entity.Category;
import com.suleymankayabasi.springboot.entity.Product;
import com.suleymankayabasi.springboot.service.entityService.CategoryEntityService;
import com.suleymankayabasi.springboot.service.entityService.ProductEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/categories/")
public class CategoryController {

    @Autowired
    private CategoryEntityService categoryEntityService;

    @Autowired
    private ProductEntityService productEntityService;

    @GetMapping("")
    public List<CategoryDto> findAll(){

        List<Category> categoryList = categoryEntityService.findAll();
        List<CategoryDto> categoryDtoList = CategoryConverter.INSTANCE.convertAllCategoryListToCategoryDtoList(categoryList);

        return categoryDtoList;
    }

    @GetMapping("/{id}")
    public Category findById(Long id){
        Category category = categoryEntityService.findById(id);
        return category;

    }
    // localhost:8080/api/categories/{id}/products
    @GetMapping("/{id}/products")
    public List<ProductDetailDto> findAllProductByCategoryId(@PathVariable Long id){

        List<Product> productList = productEntityService.findAllByCategoryOrderByIdDesc(id);

        List<ProductDetailDto> productDetailDtoList = ProductConverter.INSTANCE.convertAllProductListToProductDetailDtoList(productList);

        return productDetailDtoList;
    }

    @PostMapping("")
    public ResponseEntity<Object> save(@RequestBody CategoryDto categoryDto){

       Category category =  CategoryConverter.INSTANCE.convertCategoryDtoToCategory(categoryDto);

       if(category.getTopCategory() != null && category.getTopCategory().getId() == null){
           category.setTopCategory(null);
       }

       category  = categoryEntityService.save(category);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(category.getId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping("")
    public CategoryDto update(@RequestBody CategoryDto categoryDto){

        Category category = CategoryConverter.INSTANCE.convertCategoryDtoToCategory(categoryDto);
        if(category.getTopCategory() != null && category.getTopCategory().getId() == null){
            category.setTopCategory(null);
        }

      category =  categoryEntityService.save(category);

      CategoryDto categoryDtoResult = CategoryConverter.INSTANCE.convertCategoryToCategoryDto(category);

      return categoryDtoResult;
    }

    @DeleteMapping("/{id}")
    public void deleteById(Long id){
         categoryEntityService.deleteById(id);
    }

}
