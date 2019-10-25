package lambdas;

@FunctionalInterface
public interface Sumador {
	
	public int sumar(int a, int b);
	
	public static int usarSumador(Sumador s, int a, int b) {
		return s.sumar(a, b);
	}
}
