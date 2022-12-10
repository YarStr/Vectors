/**
 * Класс пятимерных векторов
 */
public class Vector5d extends Vector {
    public Vector5d(Integer x1, Integer x2, Integer x3, Integer x4, Integer x5) {
        super(x1, x2, x3, x4, x5);
    }

    @Override
    protected Vector createVector(Integer[] coordinates) {
        return new Vector5d(coordinates[0], coordinates[1], coordinates[2], coordinates[3], coordinates[4]);
    }

    public Vector5d add(Vector5d vector) {
        return (Vector5d) super.add(vector);
    }

    public Vector5d sub(Vector5d vector) {
        return (Vector5d) super.sub(vector);
    }

    public Integer mul(Vector5d vector) {
        return super.mul(vector);
    }

    public Boolean equals(Vector5d vector) {
        return super.equals(vector);
    }
}
