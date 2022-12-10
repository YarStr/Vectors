/**
 * Абстрактный класс математических векторов, реализующий математических операций над ними
 */
public abstract class Vector implements VectorInterface {
    /**
     * Размерность вектора
     */
    protected final Integer dimension;
    /**
     * Координаты вектора
     */
    protected final Integer[] coordinates;

    /**
     * Метод создания вектора по набору координат
     *
     * @param coordinates координаты вектора
     * @return вектор с заданными координатами
     */
    protected abstract Vector createVector(Integer[] coordinates);

    /**
     * Геттер координат вектора
     *
     * @return координаты данного вектора
     */
    protected Integer[] getCoordinates() {
        return coordinates;
    }

    /**
     * Конструктор класса
     *
     * @param coordinates координаты вектора
     */
    protected Vector(Integer... coordinates) {
        this.coordinates = coordinates;
        this.dimension = coordinates.length;
    }

    public Vector add(Vector vector) {
        Integer[] resultCoordinates = new Integer[dimension];
        Integer[] anotherVectorCoordinates = vector.getCoordinates();
        for (int i = 0; i < dimension; i++)
            resultCoordinates[i] = coordinates[i] + anotherVectorCoordinates[i];

        return createVector(resultCoordinates);
    }

    public Vector sub(Vector vector) {
        Integer[] resultCoordinates = new Integer[dimension];
        Integer[] anotherVectorCoordinates = vector.getCoordinates();
        for (int i = 0; i < dimension; i++)
            resultCoordinates[i] = coordinates[i] - anotherVectorCoordinates[i];

        return createVector(resultCoordinates);
    }

    public Integer mul(Vector vector) {
        int result = 0;
        Integer[] anotherVectorCoordinates = vector.getCoordinates();
        for (int i = 0; i < dimension; i++)
            result += coordinates[i] * anotherVectorCoordinates[i];

        return result;
    }

    @Override
    public Boolean equals(Vector vector) {
        Integer[] anotherVectorCoordinates = vector.getCoordinates();
        for (int i = 0; i < dimension; i++)
            if (!coordinates[i].equals(anotherVectorCoordinates[i]))
                return false;
        return true;
    }

    public String toStringValue() {
        StringBuilder stringValue = new StringBuilder();

        stringValue.append('(');
        for (Integer coordinate : coordinates) {
            stringValue.append(coordinate).append(", ");
        }
        stringValue.setLength(stringValue.length() - 2);
        stringValue.append(')');

        return stringValue.toString();
    }
}
