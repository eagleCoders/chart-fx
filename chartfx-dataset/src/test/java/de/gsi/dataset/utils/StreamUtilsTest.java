package de.gsi.dataset.utils;

import static org.junit.jupiter.api.Assertions.*;

import static de.gsi.dataset.utils.StreamUtils.CLASSPATH_PREFIX;
import static de.gsi.dataset.utils.StreamUtils.ZIP_PREFIX;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;

class StreamUtilsTest {
    @Test
    void getInputStream() throws FileNotFoundException {
        StreamUtils.getInputStream(CLASSPATH_PREFIX + "junit-platform.properties");
        StreamUtils.getInputStream(CLASSPATH_PREFIX + "null");
        StreamUtils.getInputStream("target/test-classes/junit-platform.properties");
        assertThrows(FileNotFoundException.class, () -> StreamUtils.getInputStream(ZIP_PREFIX + "target/test-classes/junit-platform.zip/test/javafile.txt"));
        assertThrows(FileNotFoundException.class, () -> StreamUtils.getInputStream(ZIP_PREFIX + "/target/test-classes/junit-platform.ziptest/javafile.txt"));
    }
}