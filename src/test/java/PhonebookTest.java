import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class PhoneBookTest {
    PhoneBook phoneBook;

    @BeforeEach
    void setUp() {
        System.out.println("Начало теста");
        phoneBook = new PhoneBook();
    }

    @AfterEach
    void tearDown() {
        System.out.println("Окончание теста");
        phoneBook = null;
    }

    public static Stream<Arguments> sourceAdd() {
        return Stream.of(
                Arguments.of(2, "Ivan", "461379", "Olya", "461379"),
                Arguments.of(1, "Ivan", "461379", "Ivan", "461379")
        );
    }

    @ParameterizedTest
    @MethodSource("sourceAdd")
    void add_test(int expected, String name1, String number1, String name2, String number2) {
        phoneBook.add(name1, name2);
        Assertions.assertEquals(expected, phoneBook.add(name2, number2));
    }
}