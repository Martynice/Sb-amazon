package com.spring.amazon.service.impl;

import com.spring.amazon.service.FileReaderService;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class FileReaderServiceImpl implements FileReaderService {
    @Override
    public List<String> read(String path) {
        List<String> result = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            while (br.ready()) {
                result.add(br.readLine());
            }
        } catch (IOException e) {
            throw new RuntimeException("Couldn't read file " + path, e);
        }
        return result;
    }
}
