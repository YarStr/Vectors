import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Тестирование класса трёхмерных векторов
 */
class Vector3dTest {
    /**
     * Экземпляры векторов для использования в дальнейших тестах
     */
    Vector3d vector1 = new Vector3d(1, 2, 3);
    Vector3d vector2 = new Vector3d(3, 2, 1);

    /**
     * Тестирование стандартного сценария использования метода add -
     * сложение одного трёхмерного вектора с другим
     */
    @Test
    void testAddTwoVectors() {
        Integer[] realCoordinates = vector1.add(vector2).getCoordinates();
        Integer[] expectedCoordinates = new Vector3d(4, 4, 4).getCoordinates();
        assertArrayEquals(realCoordinates, expectedCoordinates);
    }

    /**
     * Тестирование сценария последовательного использования метода add -
     * сложение посредством него трёх векторов
     */
    @Test
    void testAddThreeVectors() {
        Integer[] realCoordinates = vector1.add(vector2).add(vector1).getCoordinates();
        Integer[] expectedCoordinates = new Vector3d(5, 6, 7).getCoordinates();
        assertArrayEquals(realCoordinates, expectedCoordinates);
    }

    /**
     * Тестирование стандартного сценария использования метода sub -
     * вычитание одного трёхмерного вектора из другого
     */
    @Test
    void testSubTwoVectors() {
        Integer[] realCoordinates = vector1.sub(vector2).getCoordinates();
        Integer[] expectedCoordinates = new Vector3d(-2, 0, 2).getCoordinates();
        assertArrayEquals(realCoordinates, expectedCoordinates);
    }

    /**
     * Тестирование сценария последовательного использования метода sub -
     * вычитание посредством него трёх векторов
     */
    @Test
    void testSubThreeVectors() {
        Integer[] realCoordinates = vector1.sub(vector2).sub(vector2).getCoordinates();
        Integer[] expectedCoordinates = new Vector3d(-5, -2, 1).getCoordinates();
        assertArrayEquals(realCoordinates, expectedCoordinates);
    }

    /**
     * Тестирование метода умножения векторов - mul
     */
    @Test
    void testMulTwoVectors() {
        Integer realResult = vector1.mul(vector2);
        Integer expectedResult = 10;
        assertEquals(realResult, expectedResult);
    }

    /**
     * Тестирование метода покоординатного сравнения векторов в случае равенства векторов
     */
    @Test
    void testEqualsWithEqualVectors() {
        Vector3d equalToVector1 = new Vector3d(1, 2, 3);
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
        String expectedResult = "(1, 2, 3)";
        assertEquals(realResult, expectedResult);
    }
}