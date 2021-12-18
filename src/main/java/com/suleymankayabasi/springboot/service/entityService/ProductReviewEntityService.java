package com.suleymankayabasi.springboot.service.entityService;

import com.suleymankayabasi.springboot.dao.ProductReviewDao;
import com.suleymankayabasi.springboot.entity.ProductReview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductReviewEntityService {

    @Autowired
    private ProductReviewDao productReviewDao;

    public void deleteById(Long id){
        productReviewDao.deleteById(id);
    }

    public ProductReview save(ProductReview productReview){
        productReview = productReviewDao.save(productReview);
        return productReview;
    }

    public List<ProductReview> findProductReviewsByUser_Id(Long id){
        return productReviewDao.findProductReviewsByUser_Id(id);
    }

    public List<ProductReview> findProductReviewsByProductId(Long id){
        return productReviewDao.findProductReviewsByProductId(id);
    }

}
