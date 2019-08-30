package modelo;

import java.sql.Date;

public class Antecedente {
	
	private Date fecha;
	private String descripcion;
	private String [] tipoAntecedente;
	
	public Antecedente(Date pFecha, String pDescripcion) {
	
		fecha = pFecha;
		descripcion = pDescripcion;
		tipoAntecedente = new String[2];
		tipoAntecedente[0]= "Embargado";
		tipoAntecedente[1]= "Prestamo";
		tipoAntecedente[2]= "Reportado";
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String[] getTipoAntecedente() {
		return tipoAntecedente;
	}

	public void setTipoAntecedente(String[] tipoAntecedente) {
		this.tipoAntecedente = tipoAntecedente;
	}
}
