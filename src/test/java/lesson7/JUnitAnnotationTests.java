package lesson7;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
@DisplayName("JUnit tests")
public class JUnitAnnotationTests {

    @Disabled("TICKET-34524")
    @Test
    public void disabledTest() {
        System.out.println("Disabled test");
    }

    @DisplayName("Checking possibility to give readable names to tests")
    @Test
    public void displayNameTest() {
        System.out.println("DisplayName test");
    }

    @DisplayName("Test")
    @Test
    void simpleTest(){
        System.out.println("simple test");
    }
}
