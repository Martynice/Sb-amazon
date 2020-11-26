package com.spring.amazon.mapper;

import com.spring.amazon.dto.ReviewDto;
import com.spring.amazon.model.Product;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class ProductMapperTest {
    private static ProductMapper productMapper;
    private static ReviewDto okReviewDto;
    private static ReviewDto emptyReviewDto;

    @BeforeClass
    public static void beforeClass() {
        productMapper = new ProductMapper();
        emptyReviewDto = new ReviewDto();
        okReviewDto = new ReviewDto();
        okReviewDto.setId(1);
        okReviewDto.setProductId("B001E4KFG0");
        okReviewDto.setUserId("A3SGXH7AUHU8GW");
        okReviewDto.setProfileName("delmartian");
        okReviewDto.setHelpfulnessNumerator(1);
        okReviewDto.setHelpfulnessDenominator(1);
        okReviewDto.setScore(5);
        okReviewDto.setTime(1);
        okReviewDto.setSummary("Good Quality Dog Food");
        okReviewDto.setText("I have bought several of the Vitality canned dog food products");
    }

    @Test
    public void mapToProductOk() {
        Product actual = productMapper.mapToProduct(okReviewDto);
        Assert.assertEquals(okReviewDto.getProductId(), actual.getExternalId());
    }

    @Test
    public void mapEmptyReviewDto() {
        Product actualProduct = productMapper.mapToProduct(emptyReviewDto);
        Product expectedProduct = new Product();
        Assert.assertEquals(expectedProduct, actualProduct);
    }
}
