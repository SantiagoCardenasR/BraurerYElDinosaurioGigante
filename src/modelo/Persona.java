
	package modelo;

import java.sql.Date;
import java.util.ArrayList;

public class Persona {

	//---------------------------------------------
	// Atributos de la clase persona
	//---------------------------------------------
	private String Nombre;
	private String Cedula;
	private String Edad;
	private String Genero;
	private Date Fecha;
	private ArrayList<String> Antecedentes = new ArrayList<String>();
	private String[] Descripcion = new String[10];

	//----------------------------------------------
	// Constructor de la clase persona
	//----------------------------------------------
	
	/**
	 * Este es el metodo constructor de la clase persona
	 * <b>pre:</b> Los atributos de la clase personan deben estar previamente declarados<br>
	 * <b>post:</b> Se inicializa la clase persona
	 * @param Nombre Es el nombre de la persona que se quiere afiliar al banco. Nombre != null, Nombre != ""
	 * @param Cedula Es la cedula de la persona que se quiere afiliar al banco. Cedula != null, Cedula != ""
	 * @param Edad Es la edad de la cedula que se quiere afiliar al banco. Edad != null, Edad != ""
	 * @param Genero Es el genero de la persona que se quiere afilizar al banco. Genero != null, Genero != ""
	 * @param Antecedentes Son los antecedentes que tiene la persona que se afilia al banco. Antecedente != null, Antecedente != ""
	 * @param Descripcion Es la descripcion que tiene el antecedente de la persona. Descripcion != null, Descripcion != "" 
	 * @param Fecha Es la fecha en la que se genero el antecedente. Fecha != null, Fecha != ""
	 * 
	 */
	
	public Persona(String Nombre, String Cedula, String Edad, String Genero, ArrayList<String> Antecedentes,
			String Descripcion, Date Fecha) {

		this.Nombre = Nombre;
		this.Cedula = Cedula;
		this.Edad = Edad;
		this.Genero = Genero;
		this.Fecha = Fecha;
	}
	
	//-----------------------------------------------
	// Get's & Set's
	//-----------------------------------------------
	
	/**
	 * 
	 * @return
	 */
	public String getNombre() {
		return Nombre;
	}
	
	/**
	 * 
	 * @param nombre
	 */

	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	
	/**
	 * 
	 * @return
	 */

	public String getCedula() {
		return Cedula;
	}
	
	/**
	 * 
	 * @return
	 */

	public String getEdad() {
		return Edad;
	}
	
	/**
	 * 
	 * @param edad
	 */

	public void setEdad(String edad) {
		Edad = edad;
	}
	
	/**
	 * 
	 * @return
	 */

	public String getGenero() {
		return Genero;
	}
	
	/**
	 * 
	 * @param genero
	 */

	public void setGenero(String genero) {
		Genero = genero;
	}
	
	/**
	 * 
	 * @return
	 */

	public Date getFecha() {
		return Fecha;
	}
	
	/**
	 * 
	 * @param fecha
	 */

	public void setFecha(Date fecha) {
		Fecha = fecha;
	}
	
	/**
	 * 
	 * @return
	 */

	public ArrayList<String> getAntecedentes() {
		return Antecedentes;
	}
	
	/**
	 * 
	 * @param antecedentes
	 */

	public void setAntecedentes(ArrayList<String> antecedentes) {
		Antecedentes = antecedentes;
	}
	
	/**
	 * 
	 * @return
	 */

	public String[] getDescripcion() {
		return Descripcion;
	}
	
	/**
	 * 
	 * @param descripcion
	 */

	public void setDescripcion(String[] descripcion) {
		Descripcion = descripcion;
	}
}
