package controlador;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Date;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Persona;

public class Banco {
	
	//---------------------------------------------
	//Atributos de la clase Banco 
	//---------------------------------------------
	
	private ArrayList<Persona> Personas;
	private ObjectInputStream in;
	private ObjectOutputStream out;
	private File archivo = new File("data/datos.dat");
	
	//----------------------------------------------
	//Constructor de la clase Banco 
	//----------------------------------------------
	
	public Banco() {

		Personas = new ArrayList<Persona>();

		if (archivo.exists()) {
			JOptionPane.showMessageDialog(null, "El archivo fue creado");
		} else {
			try {
				archivo.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (archivo.length() != 0) {
			try {
				in = new ObjectInputStream(new FileInputStream(archivo));
				Personas = (ArrayList<Persona>) in.readObject();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
	
	public ArrayList<Persona> getPersonas() {
		return Personas;
	}
	
	/**
	 * 
	 * @param persona
	 */
	
	public void escribirArchivo(Persona persona) {
		try {
			out = new ObjectOutputStream(new FileOutputStream(archivo));
			out.writeObject(Personas);
			out.close();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	//-------------------------------------------------
	//CRUD
	//-------------------------------------------------
	
	
	/**
	 * Busca la persona por su cedula comparando la cedula que ingresa el usuario con las de el ArrayList.
	 * <b>pre:</b> La clase persona debe estar inicializada. (no es null)<br>
	 * <b>post:</b> Se buscara a la persona por su cedula. 
	 * @param cedula
	 * @return Retorna al empleado encontrado
	 */
	
	public Persona buscarPersonas(String Cedula) {
		Persona encontrado = null;
		if(!Personas.isEmpty()) {
			System.out.println("Personas");
			for(int i = 0; i<Personas.size(); i++) {
				if(Personas.get(i).getCedula().equals(Cedula)) {
					encontrado = Personas.get(i);
				}
			}
		}
		
		return encontrado;
	}
	
	/**
	 * Este metodo agrega ala persona con los parametros de la clase persona.
	 * <b>pre:</b> La persona debe estar inicializada (no es null)<br>.
	 * <b>post:</b> La persona se agregara a la lista de personas<br>.
	 * @param Nombre Es el nombre de la persona que se quiere afiliar al banco. Nombre != null, Nombre != ""
	 * @param Cedula Es la cedula de la persona que se quiere afiliar al banco. Cedula != null, Cedula != ""
	 * @param Edad Es la edad de la cedula que se quiere afiliar al banco. Edad != null, Edad != ""
	 * @param Genero Es el genero de la persona que se quiere afilizar al banco. Genero != null, Genero != ""
	 * @param Antecedentes Son los antecedentes que tiene la persona que se afilia al banco. Antecedente != null, Antecedente != ""
	 * @param Descripcion Es la descripcion que tiene el antecedente de la persona. Descripcion != null, Descripcion != "" 
	 * @param Fecha Es la fecha en la que se genero el antecedente. Fecha != null, Fecha != ""
	 * @return Retorna true si se agrego la persona o retorna false si la persona ya se encuentra en el sistema
	 * @exception Lanza una excepcion que lanza un cuadro de texto que informa del error cometido.
	 */
	
	public boolean agregarPersona(String Nombre, String Cedula, String Edad, String Genero, ArrayList<String>Antecedentes, String Descripcion, Date Fecha)throws Exception{
		
		Persona nueva = new Persona(Nombre, Cedula, Edad, Genero, Antecedentes, Descripcion, Fecha);
		if(buscarPersonas(Cedula)==null) {
			Personas.add(nueva);
			System.out.println("Se ha agregado la persona con la cedula: "+Cedula);
			System.out.println(Personas);
			escribirArchivo(nueva);
			return true;
		}
		else {
			 throw new Exception("La persona con la cedula "+Cedula+" ya se encuentra agregado");
		}
	}
	
	/**
	 * Este metodo elimina a la persona mediante su cedula aparte tambien lo borra del archivo de texto
	 *<b>pre:</b> La persona que se quiere eliminar debe estar ya inizializada<br>
	 *<b>post:</b> Se ha eliminado la persona del Arraylist 
	 * @param Cedula Es la cedula de la personas afiliada. cedula != null
	 * @return Retorna true si se ha logrado eliminar la persona del sistema o retorna false si la cedula
	 *  de la persona que se quiere eliminar no existe 
	 */
	
	public boolean eliminarPersona(String Cedula) {
		
		Persona e = buscarPersonas(Cedula);
		
		if(e != null) {
			Personas.remove(e);
			System.out.println("Se ha eliminado el empleado con la cedula: "+Cedula);
			archivo.delete();
			try {
				archivo.createNewFile();
				for(int i = 0; i < Personas.size(); i++) {
					escribirArchivo(Personas.get(i));
				}
			}catch(IOException e1) {
				e1.printStackTrace();
			}
			return true;
		}
		System.out.println("La persona con la cedula: "+Cedula+" NO existe para la eliminacion");
		return false;
	}
}
