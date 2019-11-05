package entidades;

import java.util.Arrays;
import java.util.List;

public class Empleado implements Comparable<Empleado>{

	private int id;
	private String nombre;
	private int salario;
	private int edad;
	private String sector;
	private Genero genero;
	
	public static enum Genero {
		HOMBRE {
			@Override
			public String toString() {
				return "Hombre";
			}
		}, MUJER {
			@Override
			public String toString() {
				return "Mujer";
			}
		}
	}

	public Empleado() {
	}

	/**
	 * Crea un empleado
	 * @param id
	 * @param nombre
	 * @param salario
	 * @param edad
	 * @param sector
	 * @param genero
	 */
	public Empleado(int id, String nombre, int salario, int edad, String sector, Genero genero) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.salario = salario;
		this.edad = edad;
		this.sector = sector;
		this.genero = genero;
	}
	
	public static int compararPorSector(Empleado a, Empleado b) {
		return a.getSector().compareTo(b.getSector());
	}
	
	@Override
	public int compareTo(Empleado o) {
		return Integer.compare(getId(), o.getId());
	}
		
	@Override
	public String toString() {
		return "ID: " + getId()
		+ " Nombre " + getNombre() 
		+ " Salario: " + getSalario()
		+ " Edad: " + getEdad()
		+ " Sector: " + getSector()
		+ " Genero: " + getGenero()
		+ "\n";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getSalario() {
		return salario;
	}

	public void setSalario(int salario) {
		this.salario = salario;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	
	public boolean isHombre() {
		return this.genero.equals(Genero.HOMBRE);
	}
	
	public boolean isMujer() {
		return this.genero.equals(Genero.MUJER);
	}
	
	public static List<Empleado> empleadosParaTest() {
		return Arrays.asList(
		new Empleado(1, "Nico", 2200, 34, "Senior", Genero.HOMBRE),
		new Empleado(2, "Ana", 1800, 32, "Senior", Genero.MUJER), 
		new Empleado(3, "Jose", 2000, 30, "SemiS", Genero.HOMBRE),
		new Empleado(4, "Seba", 1600, 28, "SemiS", Genero.HOMBRE),
		new Empleado(66, "Seba", 1666, 66, "SemiS", Genero.HOMBRE), 
		new Empleado(5, "Mauro", 1400, 26, "SemiS", Genero.HOMBRE),
		new Empleado(6, "Diego", 1200, 24, "Trainee", Genero.HOMBRE),
		new Empleado(7, "Juli", 1000, 22, "Trainee", Genero.HOMBRE),
		new Empleado(0, "Pepe", 30000, 72, "Boss", Genero.HOMBRE),
		new Empleado(8, "Janet", 1000, 22, "Trainee", Genero.MUJER),
		new Empleado(9, "Noelia", 1100, 23, "Trainee", Genero.MUJER),
		new Empleado(10, "Adriana", 2300, 42, "SemiS", Genero.MUJER),
		new Empleado(11, "Erika", 2600, 38, "Senior", Genero.MUJER)		
		);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleado other = (Empleado) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
