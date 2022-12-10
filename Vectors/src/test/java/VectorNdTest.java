import exceptions.DimensionInequalityException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Тестирование класса N-мерных векторов
 */
class VectorNdTest {
    /**
     * Экземпляры векторов для использования в дальнейших тестах
     */
    VectorNd vector4d1 = new VectorNd(1, 2, 3, 4);
    VectorNd vector4d2 = new VectorNd(4, 3, 2, 1);
    VectorNd vector6d = new VectorNd(1, 2, 3, 4, 5, 6);

    /**
     * Ожидаемое сообщения ошибки при применении методов к векторам разной размерности
     */
    String expectedExceptionMessage = "Количество переданных координат не соответствует размерности вектора.";

    /**
     * Тестирование стандартного сценария использования метода add -
     * сложение одного N-мерного вектора с другим
     */
    @Test
    void testAddTwoVectors() {
        Integer[] realCoordinates = vector4d1.add(vector4d2).getCoordinates();
        Integer[] expectedCoordinates = new VectorNd(5, 5, 5, 5).getCoordinates();
        assertArrayEquals(realCoordinates, expectedCoordinates);
    }

    /**
     * Тестирование сценария последовательного использования метода add -
     * сложение посредством него трёх векторов
     */
    @Test
    void testAddThreeVectors() {
        Integer[] realCoordinates = vector4d1.add(vector4d2).add(vector4d1).getCoordinates();
        Integer[] expectedCoordinates = new VectorNd(6, 7, 8, 9).getCoordinates();
        assertArrayEquals(realCoordinates, expectedCoordinates);
    }

    /**
     * Тестирование сценария передачи вектора другой размерности при сложении векторов
     */
    @Test
    void testAddVectorsWithDifferentDimensions() {
        Exception exception = assertThrows(DimensionInequalityException.class, () -> vector4d1.add(vector6d));
        assertEquals(expectedExceptionMessage, exception.getMessage());
    }

    /**
     * Тестирование стандартного сценария использования метода sub -
     * вычитание одного N-мерного вектора из другого
     */
    @Test
    void testSubTwoVectors() {
        Integer[] realCoordinates = vector4d1.sub(vector4d2).getCoordinates();
        Integer[] expectedCoordinates = new VectorNd(-3, -1, 1, 3).getCoordinates();
        assertArrayEquals(realCoordinates, expectedCoordinates);
    }

    /**
     * Тестирование сценария последовательного использования метода sub -
     * вычитание посредством него трёх векторов
     */
    @Test
    void testSubThreeVectors() {
        Integer[] realCoordinates = vector4d1.sub(vector4d2).sub(vector4d2).getCoordinates();
        Integer[] expectedCoordinates = new VectorNd(-7, -4, -1, 2).getCoordinates();
        assertArrayEquals(realCoordinates, expectedCoordinates);
    }

    /**
     * Тестирование сценария передачи вектора другой размерности при вычитании векторов
     */
    @Test
    void testSubVectorsWithDifferentDimensions() {
        Exception exception = assertThrows(DimensionInequalityException.class, () -> vector4d1.sub(vector6d));
        assertEquals(expectedExceptionMessage, exception.getMessage());
    }

    /**
     * Тестирование метода умножения векторов - mul
     */
    @Test
    void testMulTwoVectors() {
        Integer realResult = vector4d1.mul(vector4d2);
        Integer expectedResult = 20;
        assertEquals(realResult, expectedResult);
    }

    /**
     * Тестирование метода покоординатного сравнения векторов в случае равенства векторов
     */
    @Test
    void testEqualsWithEqualVectors() {
        VectorNd equalToVector1 = new VectorNd(1, 2, 3, 4);
        Boolean realResult = vector4d1.equals(equalToVector1);
        Boolean expectedResult = true;
        assertEquals(realResult, expectedResult);
    }

    /**
     * Тестирование метода покоординатного сравнения векторов в случае неравенства векторов
     */
    @Test
    void testEqualsWithNotEqualVectors() {
        Boolean realResult = vector4d1.equals(vector4d2);
        Boolean expectedResult = false;
        assertEquals(realResult, expectedResult);
    }

    /**
     * Тестирование метода представления вектора в виде строки - toStringValue
     */
    @Test
    void testToStringValue() {
        String realResult4d = vector4d1.toStringValue();
        String expectedResult4d = "(1, 2, 3, 4)";

        String realResult6d = vector6d.toStringValue();
        String expectedResult6d = "(1, 2, 3, 4, 5, 6)";

        assertEquals(realResult4d, expectedResult4d);
        assertEquals(realResult6d, expectedResult6d);
    }
}