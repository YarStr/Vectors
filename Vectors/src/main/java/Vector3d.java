/**
 * Класс трёхмерных векторов
 */
public class Vector3d extends Vector {
    public Vector3d(Integer x1, Integer x2, Integer x3) {
        super(x1, x2, x3);
    }

    @Override
    protected Vector createVector(Integer[] coordinates) {
        return new Vector3d(coordinates[0], coordinates[1], coordinates[2]);
    }

    public Vector3d add(Vector3d vector) {
        return (Vector3d) super.add(vector);
    }

    public Vector3d sub(Vector3d vector) {
        return (Vector3d) super.sub(vector);
    }

    public Integer mul(Vector3d vector) {
        return super.mul(vector);
    }

    public Boolean equals(Vector3d vector) {
        return super.equals(vector);
    }
}
