import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFileChooser;

public class Persistencia 
{
	
	public static ArrayList<Persona> personas = new ArrayList<Persona>();
	
	public static void leerArchivo()
	{
		JFileChooser fc = new JFileChooser();
		fc.showOpenDialog(null);
		File file = fc.getSelectedFile();
		try 
		{
			BufferedReader br = new BufferedReader(new FileReader(file));
			String linea = "";
			try 
			{
				String valorActual;
				ArrayList antecedentes = new ArrayList();
				
				String nombre = "";
				String cedula = "";
				String genero = "";
				int edad = 0;
				String fecha = "8/30/2019";
				
				while ((linea = br.readLine()) != null)
				{
					String[] valores = linea.split("=");
					ArrayList antecedentes_actuales = new ArrayList();
					for (int i = 0; i < valores.length; i++) 
					{
						if(i == 1)
						{
							valorActual = valores[i];
							
							if(valores[0].equalsIgnoreCase("Nombre"))
							{
								nombre = valores[1];
							}
							
							if(valores[0].equalsIgnoreCase("Cedula"))
							{
								cedula = valores[1];
							}
							
							if(valores[0].equalsIgnoreCase("Genero"))
							{
								genero = valores[1];
							}
							
							if(valores[0].equalsIgnoreCase("Edad"))
							{
								edad = Integer.parseInt(valores[i]);
							}
							
							if(valores[0].equalsIgnoreCase("Antecedentes"))
							{
								String[] valores_antecedentes = valorActual.split(",");
								for (int j = 0; j < valores_antecedentes.length; j++) 
								{
									antecedentes.add(valores_antecedentes[j]);
								}
								agregarPersona(nombre, cedula, genero, edad, antecedentes);
							}
							antecedentes.clear();
						}
					}
				}
				
				imprimirPersonas(personas);
			} 
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	private static void agregarPersona(String nombre, String cedula, String genero, int edad, ArrayList antecedentes) 
	{
		Persona persona_actual = new Persona(nombre, cedula, genero,edad, antecedentes);
		personas.add(persona_actual);
	}


	public static void imprimirPersonas(ArrayList<Persona> pPersonas)
	{
		for (int i = 0; i < pPersonas.size(); i++) 
		{
			Persona actual = pPersonas.get(i);
			System.out.println(actual.getNombre());
			System.out.println(actual.getCedula());
			System.out.println(actual.getGenero());
			System.out.println(actual.getEdad());
			System.out.println("\n");
		}
	}
	
	public static void main(String[] args) 
	{
		
		leerArchivo();
		
	}

}
