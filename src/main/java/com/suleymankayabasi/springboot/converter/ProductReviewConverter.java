package com.suleymankayabasi.springboot.converter;

import com.suleymankayabasi.springboot.dto.ProductReviewDto;
import com.suleymankayabasi.springboot.entity.ProductReview;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ProductReviewConverter {

    ProductReviewConverter INSTANCE = Mappers.getMapper(ProductReviewConverter.class);

    @Mapping(target = "user.id",source = "userId")
    @Mapping(target = "product.id",source = "productId")
    ProductReview convertProductReviewDtoToProductReview(ProductReviewDto productReviewDto);

    @Mapping(target = "userId",source = "user.id")
    @Mapping(target = "productId",source = "product.id")
    ProductReviewDto convertProductReviewToProductReviewDto(ProductReview productReview);

    @Mapping(target = "user.id",source = "userId")
    @Mapping(target = "product.id",source = "productId")
    List<ProductReview> convertProductReviewDtoListToProductReviewList(List<ProductReviewDto> productReviewDtoList);

    @Mapping(target = "userId",source = "user.id")
    @Mapping(target = "productId",source = "product.id")
    List<ProductReviewDto> convertProductReviewListToProductReviewDtoList(List<ProductReview> productReviewList);

}
