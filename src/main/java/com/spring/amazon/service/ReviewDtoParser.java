package com.spring.amazon.service;

import com.opencsv.CSVParser;
import com.spring.amazon.dto.ReviewDto;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import org.springframework.stereotype.Service;

@Service
public class ReviewDtoParser implements CsvParser<ReviewDto> {
    private static final int ID = 0;
    private static final int PRODUCT_ID = 1;
    private static final int USER_ID = 2;
    private static final int PROFILE_NAME = 3;
    private static final int NUMERATOR = 4;
    private static final int DENOMINATOR = 5;
    private static final int SCORE = 6;
    private static final int TIME = 7;
    private static final int SUMMARY = 8;
    private static final int TEXT = 9;
    private CSVParser csvParser = new CSVParser();

    @Override
    public ReviewDto parse(String line) {
        ReviewDto reviewDto = new ReviewDto();
        try {
            String[] parsedLine = csvParser.parseLine(line);
            reviewDto.setId(Long.parseLong(parsedLine[ID].trim()));
            reviewDto.setProductId(parsedLine[PRODUCT_ID].trim());
            reviewDto.setUserId(parsedLine[USER_ID].trim());
            reviewDto.setProfileName(parsedLine[PROFILE_NAME].trim());
            reviewDto.setHelpfulnessNumerator(Long.parseLong(parsedLine[NUMERATOR].trim()));
            reviewDto.setHelpfulnessDenominator(Long.parseLong(parsedLine[DENOMINATOR].trim()));
            reviewDto.setScore(Long.parseLong(parsedLine[SCORE].trim()));
            reviewDto.setTime(LocalDateTime.ofInstant(Instant.ofEpochSecond(
                    Long.parseLong(parsedLine[SCORE].trim())), ZoneId.systemDefault()));
            reviewDto.setSummary(parsedLine[SUMMARY].trim());
            reviewDto.setText(parsedLine[TEXT].trim());
            return reviewDto;
        } catch (IOException e) {
            throw new RuntimeException("Cannot parse the line " + line, e);
        }
    }
}
