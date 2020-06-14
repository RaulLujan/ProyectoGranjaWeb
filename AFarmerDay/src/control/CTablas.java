package control;

import java.util.ArrayList;
import java.util.Collections;

import dominio.Cooperativa;
import dominio.Espacio;

import dominio.Infraestructura;

import dominio.Usuario;
import modelo.Modelo;

public class CTablas extends Control {

	private Modelo modelo;
	private ArrayList<PuestoGranjas> listaPuestoGranjas;
	private ArrayList<PuestoCooperativas> listaPuestoCooperativas;

	public String preparaTablaGranjas() {
		setListaUsuarios((ArrayList<Usuario>) modelo.consultaUsuarios());
		setListaInfraestructuras((ArrayList<Infraestructura>) modelo.consultaInfraestructuras());
		setListaEspacios((ArrayList<Espacio>) modelo.consultaEspacios());

		int cont = 1;
		listaPuestoGranjas = new ArrayList<PuestoGranjas>(getListaGranjas().size());
		for (Usuario u : getListaUsuarios()) {
			PuestoGranjas puesto = new PuestoGranjas(u.getPuntos(), u, getListaInfraestructuras(), getListaEspacios());
			setUsuarioOb(u);
			getUsuarioOb().setPuntos(puesto.obterPuntos());
			modelo.modificacion(getUsuarioOb());
			listaPuestoGranjas.add(puesto);
		}

		Collections.sort(listaPuestoGranjas);
		for (PuestoGranjas puestoGranjas : listaPuestoGranjas) {
			puestoGranjas.setPuesto(cont);
			cont++;
		}
		return "tablaGranjas";
	}

	public String preparaTablaCooperativas() {
		setListaCooperativas((ArrayList<Cooperativa>) modelo.consultaCooperativas());
		setListaUsuarios((ArrayList<Usuario>) modelo.consultaUsuarios());
		int i = 1;
		listaPuestoCooperativas = new ArrayList<PuestoCooperativas>(getListaCooperativas().size());
		for (Cooperativa c : getListaCooperativas()) {
			PuestoCooperativas puesto = new PuestoCooperativas(c, getListaUsuarios());
			setCooperativaOb(c);
			getCooperativaOb().setPuntos(puesto.obterPuntos());
			modelo.modificacion(c);
			listaPuestoCooperativas.add(puesto);
		}
		Collections.sort(listaPuestoCooperativas);
		for (PuestoCooperativas puestoCooperativas : listaPuestoCooperativas) {
			puestoCooperativas.setPuesto(i);
			i++;
		}
		return "tablaCooperativas";

	}

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	public ArrayList<PuestoGranjas> getListaPuestoGranjas() {
		return listaPuestoGranjas;
	}

	public void setListaPuestoGranjas(ArrayList<PuestoGranjas> listaPuestoGranjas) {
		this.listaPuestoGranjas = listaPuestoGranjas;
	}

	public ArrayList<PuestoCooperativas> getListaPuestoCooperativas() {
		return listaPuestoCooperativas;
	}

	public void setListaPuestoCooperativas(ArrayList<PuestoCooperativas> listaPuestoCooperativas) {
		this.listaPuestoCooperativas = listaPuestoCooperativas;
	}

}
