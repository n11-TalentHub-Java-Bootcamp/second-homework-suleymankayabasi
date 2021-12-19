package com.suleymankayabasi.springboot.dao;

import com.suleymankayabasi.springboot.entity.ProductReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductReviewDao extends JpaRepository<ProductReview,Long> {

    List<ProductReview> findProductReviewsByUser_Id(Long id);

    List<ProductReview> findProductReviewsByProductId(Long id);


}

