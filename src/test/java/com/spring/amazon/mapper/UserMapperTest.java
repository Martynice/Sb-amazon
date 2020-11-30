package com.spring.amazon.mapper;

import com.spring.amazon.dto.ReviewDto;
import com.spring.amazon.model.Role;
import com.spring.amazon.model.User;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Set;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class UserMapperTest {
    private static UserMapper userMapper;
    private static ReviewDto reviewDtoOk;
    private static ReviewDto emptyReviewDto;

    @BeforeClass
    public static void beforeClass() {
        userMapper = new UserMapper();
        emptyReviewDto = new ReviewDto();
        reviewDtoOk = new ReviewDto();
        reviewDtoOk.setId(1L);
        reviewDtoOk.setProductId("B001E4KFG0");
        reviewDtoOk.setUserId("A3SGXH7AUHU8GW");
        reviewDtoOk.setProfileName("delmartian");
        reviewDtoOk.setHelpfulnessNumerator(1L);
        reviewDtoOk.setHelpfulnessDenominator(1L);
        reviewDtoOk.setScore(5L);
        reviewDtoOk.setTime(LocalDateTime.ofInstant(Instant.ofEpochSecond(1),
                ZoneId.systemDefault()));
        reviewDtoOk.setSummary("Good Quality Dog Food");
        reviewDtoOk.setText("I have bought several of the Vitality canned dog food products");
    }

    @Test
    public void mapToUserOk() {
        User user = userMapper.mapToUser(reviewDtoOk);
        Assert.assertEquals(reviewDtoOk.getUserId(), user.getExternalId());
        Assert.assertEquals(reviewDtoOk.getProfileName(), user.getProfileName());
    }

    @Test
    public void mapEmptyReviewDto() {
        User expected = new User();
        expected.setPassword("1111");
        expected.setRoles(Set.of(Role.of("USER")));
        User actual = userMapper.mapToUser(emptyReviewDto);
        Assert.assertEquals(expected, actual);
    }
}
