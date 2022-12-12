package exceptions;

public class DimensionInequalityException extends RuntimeException {
    public DimensionInequalityException(){
        super("Размерности векторов не совпадают.");
    }
}
