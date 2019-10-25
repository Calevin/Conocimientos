package lambdas;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestSumador {
	
	@Test
	public void uso_directo_de_la_implementacion_sumar() {
		//Uso directo de una implementacion
		//(No se suele usar asi)
		Sumador implementacionSumador = (a, b) -> { return a+b; };
		assertTrue(implementacionSumador.sumar(1, 2)==3);
	}
	
	@Test
	public void uso_implementacion_como_parametro() {
		//Uso de la implementacion como parametro
		//No se suele usar asi, pero es posible a veces...
		Sumador implementacionSumador = (a, b) -> { return a+b; };
		assertTrue(Sumador.usarSumador(implementacionSumador, 2, 3)==5);
	}

	@Test
	public void uso_clase_anonima_como_implementacion() {
		//Uso antiguo como clase anonima
		int resultadoSuma = Sumador.usarSumador(new Sumador() {

			@Override
			public int sumar(int a, int b) {

				return a + b;
			}
		}, 4, 5);
		
		assertTrue(resultadoSuma == 9);
	}
	
	@Test
	public void uso_lambda_como_parametro() {
		int resultadoSuma = 0;
		//Uso de una lambda como parametro
		//La  lambda implementa la interfaz
		//Uso de las lambdas esperado
		resultadoSuma = Sumador.usarSumador((x,  y)-> { return x+y;}, 5, 6);
		
		assertTrue(resultadoSuma == 11);
	}
	
	@Test
	public void uso_lambda_como_return() {
		int resultadoSuma = 0;
		//Uso de una lambda como return de un metodo
		resultadoSuma = Sumador.usarSumador(crearSumador(), 7 ,8);
		assertTrue(resultadoSuma == 15);
	}
	
	private Sumador crearSumador() {
		return (x,  y)-> { return x+y;};
	}
}
