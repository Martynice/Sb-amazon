package com.spring.amazon.mapper;

import com.spring.amazon.dto.ReviewDto;
import com.spring.amazon.model.Role;
import com.spring.amazon.model.User;
import java.util.Set;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class UserMapperTest {
    private static UserMapper userMapper;
    private static ReviewDto okReviewDto;
    private static ReviewDto emptyReviewDto;

    @BeforeClass
    public static void beforeClass() {
        userMapper = new UserMapper();
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
    public void mapToUserOk() {
        User user = userMapper.mapToUser(okReviewDto);
        Assert.assertEquals(okReviewDto.getUserId(), user.getExternalId());
        Assert.assertEquals(okReviewDto.getProfileName(), user.getProfileName());
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
