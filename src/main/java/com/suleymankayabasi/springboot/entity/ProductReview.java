package com.suleymankayabasi.springboot.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PRODUCT_REVIEW")
public class ProductReview {

    @SequenceGenerator(name = "generator",sequenceName = "PRODUCT_REVIEW_ID_SEQ")
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "ID",nullable = false)
    private Long id;

    @Column(length = 500,name = "PRODUCT_REVIEW")
    private String review;

    @Column(name = "REVIEW_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date reviewDate;

    // A Product can have a lot of Product Reviews
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PRODUCT_REVIEW",foreignKey = @ForeignKey(name = "FK_PRODUCT__REVIEW_PRODUCT_ID"))
    private Product product;

    // A User can write a lot of Product Reviews
    // TODO USER SİLİNCE YORUMUDA SİLİNMELİ
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_USERS",foreignKey = @ForeignKey(name = "FK_PRODUCT_REVIEW_USER_ID"))
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public Date getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(Date reviewDate) {
        this.reviewDate = reviewDate;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product productId) {
        this.product = productId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User userId) {
        this.user = userId;
    }

    @Override
    public String toString() {
        return "ProductReview{" +
                "id=" + id +
                ", review='" + review + '\'' +
                ", reviewDate=" + reviewDate +
                ", productId=" + product +
                ", userId=" + user +
                '}';
    }
}
