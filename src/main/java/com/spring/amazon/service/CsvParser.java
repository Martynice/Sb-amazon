package com.spring.amazon.service;

public interface CsvParser<T> {
    T parse(String path);
}
