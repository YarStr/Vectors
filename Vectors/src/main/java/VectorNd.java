import exceptions.DimensionInequalityException;

import java.util.Objects;

/**
 * Класс N-мерных векторов
 */
public class VectorNd extends Vector {
    private final Integer dimension;

    /**
     * Геттер размерности вектора
     *
     * @return размерность данного вектора
     */
    protected Integer getDimension() {
        return dimension;
    }

    public VectorNd(Integer... coordinates) {
        super(coordinates);
        dimension = coordinates.length;
    }

    protected VectorNd createVector(Integer[] coordinates) {
        return new VectorNd(coordinates);
    }

    public VectorNd add(VectorNd vector) {
        if (Objects.equals(this.dimension, vector.getDimension()))
            return (VectorNd) super.add(vector);
        throw new DimensionInequalityException();
    }

    public VectorNd sub(VectorNd vector) {
        if (Objects.equals(this.dimension, vector.getDimension()))
            return (VectorNd) super.sub(vector);
        throw new DimensionInequalityException();
    }

    public Integer mul(VectorNd vector) {
        if (Objects.equals(this.dimension, vector.getDimension()))
            return super.mul(vector);
        throw new DimensionInequalityException();
    }

    public Boolean equals(VectorNd vector) {
        if (Objects.equals(this.dimension, vector.getDimension()))
            return super.equals(vector);
        throw new DimensionInequalityException();
    }
}
