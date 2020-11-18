package com.spring.amazon.service;

import static org.junit.jupiter.api.Assertions.assertThrows;

import com.spring.amazon.dto.ReviewDto;
import org.junit.Assert;
import org.junit.Test;

public class ReviewDtoParserTest {
    private static final String INPUT_TEXT = "1, p1, u1, user, 1, 1, 1, 1, summary, text";
    private static final String NON_CSV = "Default line";
    private static final String WRONG_TYPE_PARAMS = "one, two";
    private final CsvParser<ReviewDto> csvParser = new ReviewDtoParser();

    @Test
    public void parseOk() {
        ReviewDto result = csvParser.parse(INPUT_TEXT);
        ReviewDto expected = new ReviewDto(1, "p1", "u1", "user",
                1, 1, 1, 1, "summary", "text");
        Assert.assertEquals(expected, result);
    }

    @Test
    public void parseNonScvLine() {
        assertThrows(RuntimeException.class, () -> csvParser.parse(NON_CSV));
    }

    @Test
    public void parseWrongTypeCsv() {
        assertThrows(RuntimeException.class, () -> csvParser.parse(
                WRONG_TYPE_PARAMS + INPUT_TEXT.substring(2)));
    }
}
