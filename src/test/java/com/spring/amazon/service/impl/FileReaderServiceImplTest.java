package com.spring.amazon.service.impl;

import com.spring.amazon.service.FileReaderService;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class FileReaderServiceImplTest {
    private static final String FILE = "src/main/resources/file.csv";
    private static final String EMPTY_FILE = "src/main/resources/empty.csv";
    private final FileReaderService reader = new FileReaderServiceImpl();

    @Test
    public void read_Ok() {
        List<String> expected = List.of("Parse file");
        List<String> actual = reader.read(FILE);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void readEmpty_Ok() {
        List<String> expected = List.of();
        List<String> actual = reader.read(EMPTY_FILE);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void read_invalidPath() {
        Assert.assertThrows(RuntimeException.class, () -> reader.read(""));
    }
}
