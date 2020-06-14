package control;


import java.util.ArrayList;

import dominio.Espacio;
import dominio.Infraestructura;
import dominio.Usuario;


public class PuestoGranjas extends Control implements Comparable<PuestoGranjas> {

	private int puesto;
	private int puntos;
	private Usuario usu;
	private String usuario;
	private String cooperativa;
	private String granja;
	private ArrayList<Infraestructura> listaInfraestructuras ;
	private ArrayList<Espacio> listaEspacios;

	public PuestoGranjas(int puesto, int puntos, Usuario usuario) {
		super();
		this.puesto = puesto;
		this.puntos = 0;
		this.usu = usuario;
		this.usuario = usu.getNombre();
		this.granja = usu.getGranja().getNombre();
		if (usu.getCooperativa() != null)
			this.cooperativa = usu.getCooperativa().getNombre();
		else
			this.cooperativa = "N/A";

	}

	public PuestoGranjas(int puntos, Usuario usuario,ArrayList<Infraestructura> listaInfraestructuras, ArrayList<Espacio> listaEspacios) {
		super();
		this.puntos = 0;
		this.usu = usuario;
		this.listaInfraestructuras= listaInfraestructuras;
		this.listaEspacios = listaEspacios;
		this.usuario = usu.getNombre();
		this.granja = usu.getGranja().getNombre();
		if (usu.getCooperativa() != null)
			this.cooperativa = usu.getCooperativa().getNombre();
		else
			this.cooperativa = "N/A";

	}

	public int getPuesto() {
		return puesto;
	}

	public void setPuesto(int puesto) {
		this.puesto = puesto;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public Usuario getUsu() {
		return usu;
	}

	public void setUsu(Usuario usu) {
		this.usu = usu;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getCooperativa() {
		return cooperativa;
	}

	public void setCooperativa(String cooperativa) {
		this.cooperativa = cooperativa;
	}

	public String getGranja() {
		return granja;
	}

	public void setGranja(String granja) {
		this.granja = granja;
	}


	public ArrayList<Infraestructura> getListaInfraestructuras() {
		return listaInfraestructuras;
	}

	public void setListaInfraestructuras(ArrayList<Infraestructura> listaInfraestructuras) {
		this.listaInfraestructuras = listaInfraestructuras;
	}

	public ArrayList<Espacio> getListaEspacios() {
		return listaEspacios;
	}

	public void setListaEspacios(ArrayList<Espacio> listaEspacios) {
		this.listaEspacios = listaEspacios;
	}

	@Override
	public int compareTo(PuestoGranjas o) {
		if (this.getPuntos() > o.getPuntos())
			return -1;
		if (this.getPuntos() < o.getPuntos())
			return 1;
		return 0;
	}

	
	public int obterPuntos() {
		for (Infraestructura infraestructura : this.listaInfraestructuras) {
			if (infraestructura.getNombre().equals("Almacen") && infraestructura.getGranja().getId() == usu.getId()) {
				for (Espacio espa : this.listaEspacios) {
					if (espa.getInfraestructura().getId() == infraestructura.getId()) {
						switch (espa.getRecurso().getId()) {
						case DINERO:
						case AGUA:
							this.puntos += espa.getOcupacion_actual();
							break;
						case CARNE:
							this.puntos += espa.getOcupacion_actual() *100;
							break;
						case HUEVOS:
						case LECHE:
							this.puntos += espa.getOcupacion_actual() *100;
							break;
						case CERDO:
							this.puntos += espa.getOcupacion_actual() *500;
							break;
						case VACA:
							this.puntos += espa.getOcupacion_actual() *250;
							break;
						case GALLINA:
							this.puntos += espa.getOcupacion_actual() *100;
							break;
						case ABONO:
						case HERBICIDA:
							this.puntos += espa.getOcupacion_actual() *20;
							break;
						case FRESA:
						case MAIZ:
						case PATATA:
							this.puntos += espa.getOcupacion_actual();
							break;
						}
					}
				}
			}
		}
		return this.puntos;
	}

	
}
