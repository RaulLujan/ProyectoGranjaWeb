package control;

import java.util.ArrayList;

import dominio.Cooperativa;
import dominio.Usuario;

public class PuestoCooperativas implements Comparable<PuestoCooperativas> {

	private int puesto;
	private int puntos;
	private Cooperativa cooperativa;
	private ArrayList<Usuario> listaUsuarios;

	public PuestoCooperativas(int puesto, int puntos, Cooperativa cooperativa) {
		super();
		this.puesto = puesto;
		this.puntos = 0; //cooperativa.getPuntos();
		this.cooperativa = cooperativa;
	}

	public PuestoCooperativas(int puntos, Cooperativa cooperativa) {
		super();
		this.puntos = 0; //cooperativa.getPuntos();
		this.cooperativa = cooperativa;
	}

	public PuestoCooperativas(Cooperativa cooperativa, ArrayList<Usuario> listaUsuarios) {
		super();
		this.cooperativa = cooperativa;
		this.puntos = cooperativa.getPuntos();
		this.listaUsuarios = listaUsuarios;
	}

	public int getPuesto() {
		return puesto;
	}

	public void setPuesto(int puesto) {
		this.puesto = puesto;
	}

	public Cooperativa getCooperativa() {
		return cooperativa;
	}

	public void setCooperativa(Cooperativa cooperativa) {
		this.cooperativa = cooperativa;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	@Override
	public int compareTo(PuestoCooperativas o) {
		if (this.puntos > o.getPuntos())
			return -1;
		if (this.puntos < o.getPuntos())
			return 1;
		return 0;
	}

	public int obterPuntos() {
		for (Usuario usu : listaUsuarios) {
			this.puntos+= usu.getPuntos();
		}
		return this.puntos;
			
	}

}
