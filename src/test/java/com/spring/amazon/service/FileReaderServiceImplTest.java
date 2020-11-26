package com.spring.amazon.service;

import com.spring.amazon.service.impl.FileReaderServiceImpl;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class FileReaderServiceImplTest {
    private static final String FILE = "src/main/resources/file.csv";
    private static final String EMPTY_FILE = "src/main/resources/empty.csv";
    private final FileReaderService reader = new FileReaderServiceImpl();

    @Test
    public void readOk() {
        List<String> expected = List.of("Parse file");
        List<String> actual = reader.read(FILE);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void readEmptyOk() {
        List<String> expected = List.of();
        List<String> actual = reader.read(EMPTY_FILE);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void readInvalidPath() {
        Assert.assertThrows(RuntimeException.class, () -> reader.read(""));
    }
}
