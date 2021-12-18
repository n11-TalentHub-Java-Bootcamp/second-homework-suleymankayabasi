package com.suleymankayabasi.springboot.converter;

import com.suleymankayabasi.springboot.dto.ProductDetailDto;
import com.suleymankayabasi.springboot.dto.ProductDto;
import com.suleymankayabasi.springboot.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ProductConverter  {

    ProductConverter INSTANCE = Mappers.getMapper(ProductConverter.class);

    @Mapping(target="category.id",source="categoryId")
    Product convertProductDtoToProduct(ProductDto productDto);

    @Mapping(target="categoryId",source="category.id")
    ProductDto convertProductToProductDto(Product product);

    @Mapping(source="price",target = "productPrice")
    @Mapping(source="name",target = "productName")
    @Mapping(source="category.name",target = "categoryName")
    ProductDetailDto convertProductToProductDetailDto(Product product);


    @Mapping(source="price",target = "productPrice")
    @Mapping(source="name",target = "productName")
    @Mapping(source="category.name",target = "categoryName")
    List<ProductDetailDto> convertAllProductListToProductDetailDtoList(List<Product> productList);

}
