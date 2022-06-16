package lesson7.junit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class SimpleTestClass {

    @Test
    public void test1() {
        Assertions.assertTrue( 3 > 2);
    }

    @Test
    public void test2() {
        Assertions.assertTrue( 3 < 2);
    }

    @Test
    public void test3() {
        throw new RuntimeException("Просто другой эксепшн");
    }

    @BeforeAll
    public void beforeAll() {

    }

    @AfterAll
    public void afterAll() {

    }
}
