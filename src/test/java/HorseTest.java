import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class HorseTest {

    @Test
    public void nullNameException() {
        assertThrows(IllegalArgumentException.class, () -> new Horse(null, 2, 2));
    }

    @Test
    public void textOfNullException() {
        try {
            new Horse(null, 2, 2);
        } catch (IllegalArgumentException e) {
            assertEquals("Name cannot be null.", e.getMessage());
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "\t", "\s\s\s\s", "\n\n"})
    public void contextOfName(String name) {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new Horse(name, 2, 2));

        assertEquals("Name cannot be blank.", e.getMessage());
    }

    @Test
    public void secondParameterValueException() {
        assertThrows(IllegalArgumentException.class, () -> new Horse("First", -2, 2));
    }

    @Test
    public void speedLessThanZero() {
        try {
            new Horse("First", -1, 2);
        } catch (IllegalArgumentException e) {
            assertEquals("Speed cannot be negative.", e.getMessage());
        }
    }

    @Test
    public void thirdParameterValueException() {
        assertThrows(IllegalArgumentException.class, () -> new Horse("First", 2, -1));
    }

    @Test
    public void distanceLessThanZero() {
        try {
            new Horse("First", 4, -2);
        } catch (IllegalArgumentException e) {
            assertEquals("Distance cannot be negative.", e.getMessage());
        }
    }

    @Test
    public void getName() {
        String name = "SomeName";
        Horse horse = new Horse(name, 2, 2);
        assertEquals(name, horse.getName());
    }

    @Test
    public void getSpeed() {
        Double speed = 2d;
        Horse horse = new Horse("SomeName", speed, 3);
        assertEquals(speed, horse.getSpeed());
    }

    @Test
    public void getCorrectDistance() {
        Double distance = 3d;
        Horse horse = new Horse("SomeName", 2, distance);
        assertEquals(distance, horse.getDistance());
    }

    @Test
    public void getDistanceZero() {
        Horse horse = new Horse("SomeName", 5);
        assertEquals(0, horse.getDistance());
    }





    @Test
    void move() {
    }
}