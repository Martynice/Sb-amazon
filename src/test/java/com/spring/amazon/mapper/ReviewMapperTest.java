package com.spring.amazon.mapper;

import com.spring.amazon.dto.ReviewDto;
import com.spring.amazon.model.Review;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
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
        reviewDtoOk.setId(1L);
        reviewDtoOk.setProductId("B001E4KFG0");
        reviewDtoOk.setUserId("A3SGXH7AUHU8GW");
        reviewDtoOk.setProfileName("delmartian");
        reviewDtoOk.setHelpfulnessNumerator(1L);
        reviewDtoOk.setHelpfulnessDenominator(1L);
        reviewDtoOk.setScore(5L);
        reviewDtoOk.setTime(LocalDateTime.ofInstant(Instant.ofEpochSecond(1L),
                ZoneId.systemDefault()));
        reviewDtoOk.setSummary("Good Quality Dog Food");
        reviewDtoOk.setText("I have bought several of the Vitality canned dog food products");
    }

    @Test
    public void mapDtoOk() {
        Review expected = new Review();
        expected.setHelpfulnessNumerator(1L);
        expected.setHelpfulnessDenominator(1L);
        expected.setScore(5L);
        expected.setTime(LocalDateTime.ofInstant(Instant.ofEpochSecond(1),
                ZoneId.systemDefault()));
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
