package com.suleymankayabasi.springboot.controller;

import com.suleymankayabasi.springboot.converter.ProductReviewConverter;
import com.suleymankayabasi.springboot.dto.ProductReviewDto;
import com.suleymankayabasi.springboot.entity.ProductReview;
import com.suleymankayabasi.springboot.exception.ProductNotFoundException;
import com.suleymankayabasi.springboot.exception.ProductReviewNotFoundException;
import com.suleymankayabasi.springboot.exception.UserNotFoundException;
import com.suleymankayabasi.springboot.service.entityService.ProductReviewEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/productReviews/")
public class ProductReviewController {

    @Autowired
    private ProductReviewEntityService productReviewEntityService;

    // A service that can delete comments
    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Long id){
        productReviewEntityService.deleteById(id);
    }

    //A service that can comment a new it.
    @PostMapping("")
    public ResponseEntity<Object> createProductReview(@RequestBody ProductReviewDto productReviewDto){

        ProductReview productReview = ProductReviewConverter
                .INSTANCE.convertProductReviewDtoToProductReview(productReviewDto);

        productReview = productReviewEntityService.save(productReview);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(productReview.getId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }

    //A service that returns all reviews for a product.
    @GetMapping("product/{id}")
    public List<ProductReviewDto> findProductReviewsByProductId(@PathVariable Long id){

        List<ProductReview> productReviewList = productReviewEntityService.findProductReviewsByProductId(id);

        List<ProductReviewDto> productReviewDtoList = ProductReviewConverter
                .INSTANCE.convertProductReviewListToProductReviewDtoList(productReviewList);

        if(productReviewList.size() == 0){
            throw new ProductReviewNotFoundException
                    ("Ürün id: numarası "+ id +"olan ürüne henüz bir yorum yazılmamıştır.");
        }
        return productReviewDtoList;
    }

    //A service that returns comments made by a user.
    @GetMapping("user/{id}")
    public List<ProductReviewDto> findProductReviewsByUser_Id(@PathVariable Long id){
        List<ProductReview> productReviewList = productReviewEntityService.findProductReviewsByUser_Id(id);

        if(productReviewList.size() == 0 ){
            throw new ProductReviewNotFoundException
                    ("Kullanıcı id: numarası "+id+" olan kullanıcı henüz bir yorum yazmamıştır.");
        }

        List<ProductReviewDto> productReviewDtoList = ProductReviewConverter
                .INSTANCE.convertProductReviewListToProductReviewDtoList(productReviewList);

        return productReviewDtoList;
    }

}
