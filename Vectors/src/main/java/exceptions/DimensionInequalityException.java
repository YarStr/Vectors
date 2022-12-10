package exceptions;

public class DimensionInequalityException extends RuntimeException {
    public DimensionInequalityException(){
        super("Количество переданных координат не соответствует размерности вектора.");
    }
}
