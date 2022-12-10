import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Тестирование класса пятимерных векторов
 */
class Vector5dTest {
    /**
     * Экземпляры векторов для использования в дальнейших тестах
     */
    Vector5d vector1 = new Vector5d(1, 2, 3, 4, 5);
    Vector5d vector2 = new Vector5d(5, 4, 3, 2, 1);

    /**
     * Тестирование стандартного сценария использования метода add -
     * сложение одного пятимерного вектора с другим
     */
    @Test
    void testAddTwoVectors() {
        Integer[] realCoordinates = vector1.add(vector2).getCoordinates();
        Integer[] expectedCoordinates = new Vector5d(6, 6, 6, 6, 6).getCoordinates();
        assertArrayEquals(realCoordinates, expectedCoordinates);
    }

    /**
     * Тестирование сценария последовательного использования метода add -
     * сложение посредством него трёх векторов
     */
    @Test
    void testAddThreeVectors() {
        Integer[] realCoordinates = vector1.add(vector2).add(vector1).getCoordinates();
        Integer[] expectedCoordinates = new Vector5d(7, 8, 9, 10, 11).getCoordinates();
        assertArrayEquals(realCoordinates, expectedCoordinates);
    }

    /**
     * Тестирование стандартного сценария использования метода sub -
     * вычитание одного пятимерного вектора из другого
     */
    @Test
    void testSubTwoVectors() {
        Integer[] realCoordinates = vector1.sub(vector2).getCoordinates();
        Integer[] expectedCoordinates = new Vector5d(-4, -2, 0, 2, 4).getCoordinates();
        assertArrayEquals(realCoordinates, expectedCoordinates);
    }

    /**
     * Тестирование сценария последовательного использования метода sub -
     * вычитание посредством него трёх векторов
     */
    @Test
    void testSubThreeVectors() {
        Integer[] realCoordinates = vector1.sub(vector2).sub(vector1).getCoordinates();
        Integer[] expectedCoordinates = new Vector5d(-5, -4, -3, -2, -1).getCoordinates();
        assertArrayEquals(realCoordinates, expectedCoordinates);
    }

    /**
     * Тестирование метода умножения векторов - mul
     */
    @Test
    void testMulTwoVectors() {
        Integer realResult = vector1.mul(vector2);
        Integer expectedResult = 35;
        assertEquals(realResult, expectedResult);
    }

    /**
     * Тестирование метода покоординатного сравнения векторов в случае равенства векторов
     */
    @Test
    void testEqualsWithEqualVectors() {
        Vector5d equalToVector1 = new Vector5d(1, 2, 3, 4, 5);
        Boolean realResult = vector1.equals(equalToVector1);
        Boolean expectedResult = true;
        assertEquals(realResult, expectedResult);
    }

    /**
     * Тестирование метода покоординатного сравнения векторов в случае неравенства векторов
     */
    @Test
    void testEqualsWithNotEqualVectors() {
        Boolean realResult = vector1.equals(vector2);
        Boolean expectedResult = false;
        assertEquals(realResult, expectedResult);
    }

    /**
     * Тестирование метода представления вектора в виде строки - toStringValue
     */
    @Test
    void testToStringValue() {
        String realResult = vector1.toStringValue();
        String expectedResult = "(1, 2, 3, 4, 5)";
        assertEquals(realResult, expectedResult);
    }
}