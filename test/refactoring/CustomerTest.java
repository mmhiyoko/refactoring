package refactoring;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {
    @Test
    public void testStatementIfRentalIsEmpty() {
        Customer sut = new Customer("Alice");
        String expected = "Rental Record for Alice\n"
        + "Amount owed is 0.0\n"
        + "You earned 0 frequent renter points";
        assertEquals(expected, sut.statement());
    }
}