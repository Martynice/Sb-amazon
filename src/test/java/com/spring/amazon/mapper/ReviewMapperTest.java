package com.spring.amazon.mapper;

import com.spring.amazon.dto.ReviewDto;
import com.spring.amazon.model.Review;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class ReviewMapperTest {
    private static ReviewMapper reviewMapper = new ReviewMapper();
    private static ReviewDto emptyDto = new ReviewDto();
    private static ReviewDto reviewDtoOk = new ReviewDto();

    @BeforeClass
    public static void beforeClass() {
        reviewMapper = new ReviewMapper();
        reviewDtoOk = new ReviewDto();
        reviewDtoOk.setId(1);
        reviewDtoOk.setProductId("B001E4KFG0");
        reviewDtoOk.setUserId("A3SGXH7AUHU8GW");
        reviewDtoOk.setProfileName("delmartian");
        reviewDtoOk.setHelpfulnessNumerator(1);
        reviewDtoOk.setHelpfulnessDenominator(1);
        reviewDtoOk.setScore(5);
        reviewDtoOk.setTime(1);
        reviewDtoOk.setSummary("Good Quality Dog Food");
        reviewDtoOk.setText("I have bought several of the Vitality canned dog food products");
    }

    @Test
    public void mapDtoOk() {
        Review expected = new Review();
        expected.setHelpfulnessNumerator(1);
        expected.setHelpfulnessDenominator(1);
        expected.setScore(5);
        expected.setTime(1);
        expected.setSummary("Good Quality Dog Food");
        expected.setText("I have bought several of the Vitality canned dog food products");
        Review actual = reviewMapper.mapToReview(reviewDtoOk);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void mapEmptyOk() {
        Review expected = new Review();
        Review actual = reviewMapper.mapToReview(emptyDto);
        Assert.assertEquals(expected, actual);
    }
}
