package com.azmi.examples;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class WorkingWithStreams {

    @Test
    @Disabled
    void steams() {
        List<String> names = List.of("Azmi", "Alex", "Zara");
        Stream<String> stream = names.stream();

        Stream<String> namesStream = Stream.of("Azmi", "Alex", "Zara");

        long count = stream
                .limit(2).map(null).sorted(null).dropWhile(null)
                .count();

        String[] namesArray = {};
        Arrays.stream(namesArray);
    }
}
