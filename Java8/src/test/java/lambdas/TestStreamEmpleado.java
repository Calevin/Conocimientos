package lambdas;

import static org.junit.Assert.assertTrue;

import java.util.function.Predicate;

import org.junit.Test;

import entidades.Empleado;

public class TestStreamEmpleado {
	@Test
	public void operacion_intermedia_filter() {
		assertTrue(Empleado.empleadosParaTest()
		.stream()
		.filter(Empleado::isHombre)
		.count()==8);
		
		assertTrue(Empleado.empleadosParaTest()
				.stream()
				.filter(Empleado::isMujer)
				.count()==5);
		
		Predicate<Empleado> edadMayorTreinta = emp -> emp.getEdad()>30;
		Predicate<Empleado> sectorSemiS = emp -> emp.getSector().equalsIgnoreCase("SemiS");
		
		assertTrue(Empleado.empleadosParaTest()
				.stream()
				.filter((edadMayorTreinta).and(sectorSemiS))
				.count()==2);
	}
}
