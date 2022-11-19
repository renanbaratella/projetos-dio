package exceptions;

public class DivisaoNaoExataException extends Exception{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int numerador;
    private int denominador;

    public DivisaoNaoExataException(String message, int numerador, int denominador) {
        super(message);
        this.numerador = numerador;
        this.denominador = denominador;
    }
}