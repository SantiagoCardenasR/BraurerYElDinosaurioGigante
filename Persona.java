import java.util.ArrayList;

public class Persona 
{
	String nombre;
	String cedula;
	int edad;
	String genero;
	ArrayList antecedentes;
	
	
	public Persona(String pNombre, String pCedula, String pGenero, int pEdad, ArrayList pAntecedentes)
	{
		nombre = pNombre;
		cedula = pCedula;
		genero = pGenero;
		edad = pEdad;
		antecedentes = pAntecedentes;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getCedula() {
		return cedula;
	}


	public void setCedula(String cedula) {
		this.cedula = cedula;
	}


	public int getEdad() {
		return edad;
	}


	public void setEdad(int edad) {
		this.edad = edad;
	}


	public String getGenero() {
		return genero;
	}


	public void setGenero(String genero) {
		this.genero = genero;
	}


	public ArrayList getAntecedentes() {
		return antecedentes;
	}


	public void setAntecedentes(ArrayList antecedentes) {
		this.antecedentes = antecedentes;
	}
	
	
	

}
