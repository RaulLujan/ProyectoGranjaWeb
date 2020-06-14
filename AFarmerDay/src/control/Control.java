package control;

import java.util.ArrayList;


import dominio.Animal;
import dominio.Campo;
import dominio.Cooperativa;
import dominio.Espacio;
import dominio.Granja;
import dominio.Infraestructura;
import dominio.Precio;
import dominio.Recurso;
import dominio.TiposInfraestructura;
import dominio.Usuario;

public class Control {
	
	
	 public final int DINERO = 1;
	 public final int AGUA = 2;
	 public final int CARNE = 3;
	 public final int LECHE = 4;
	 public final int HUEVOS = 5;
	 public final int ABONO = 6;
	 public final int HERBICIDA = 7;
	 public final int PATATA = 8;
	 public final int MAIZ = 9;
	 public final int FRESA = 10;
	 public final int VACA = 11;
	 public final int CERDO = 12;
	 public final int GALLINA = 13;
	

	private Granja granjaOb;
	private Cooperativa cooperativaOb;
	private Usuario usuarioOb;
	private ArrayList<Granja> ListaGranjas = new ArrayList<>();
	private ArrayList<Cooperativa> ListaCooperativas = new ArrayList<>();
	private ArrayList<Usuario> ListaUsuarios = new ArrayList<>();
	private ArrayList<Espacio> ListaEspacios = new ArrayList<>();
	private ArrayList<Animal> ListaAnimales = new ArrayList<>();
	private ArrayList<TiposInfraestructura> ListaTiposInfraestructura = new ArrayList<>();
	private ArrayList<Infraestructura> ListaInfraestructuras = new ArrayList<>();
	private ArrayList<Precio> ListaPrecios = new ArrayList<>();
	private ArrayList<Campo> ListaCampos = new ArrayList<>();
	private ArrayList<Recurso> ListaRecursos = new ArrayList<>();
	
		
	
	public Granja getGranjaOb() {
		return granjaOb;
	}
	public void setGranjaOb(Granja granjaOb) {
		this.granjaOb = granjaOb;
	}
	public Cooperativa getCooperativaOb() {
		return cooperativaOb;
	}
	public void setCooperativaOb(Cooperativa cooperativaOb) {
		this.cooperativaOb = cooperativaOb;
	}
	public Usuario getUsuarioOb() {
		return usuarioOb;
	}
	public void setUsuarioOb(Usuario usuarioOb) {
		this.usuarioOb = usuarioOb;
	}
	public ArrayList<Usuario> getListaUsuarios() {
		return ListaUsuarios;
	}
	public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
		ListaUsuarios = listaUsuarios;
	}
	public ArrayList<Granja> getListaGranjas() {
		return ListaGranjas;
	}
	public void setListaGranjas(ArrayList<Granja> listaGranjas) {
		ListaGranjas = listaGranjas;
	}
	public ArrayList<Cooperativa> getListaCooperativas() {
		return ListaCooperativas;
	}
	public void setListaCooperativas(ArrayList<Cooperativa> listaCooperativas) {
		ListaCooperativas = listaCooperativas;
	}
	public ArrayList<Espacio> getListaEspacios() {
		return ListaEspacios;
	}
	public void setListaEspacios(ArrayList<Espacio> listaEspacios) {
		ListaEspacios = listaEspacios;
	}
	public ArrayList<Animal> getListaAnimales() {
		return ListaAnimales;
	}
	public void setListaAnimales(ArrayList<Animal> listaAnimales) {
		ListaAnimales = listaAnimales;
	}
	public ArrayList<TiposInfraestructura> getListaTiposInfraestructura() {
		return ListaTiposInfraestructura;
	}
	public void setListaTiposInfraestructura(ArrayList<TiposInfraestructura> listaTiposInfraestructura) {
		ListaTiposInfraestructura = listaTiposInfraestructura;
	}
	public ArrayList<Infraestructura> getListaInfraestructuras() {
		return ListaInfraestructuras;
	}
	public void setListaInfraestructuras(ArrayList<Infraestructura> listaInfraestructuras) {
		ListaInfraestructuras = listaInfraestructuras;
	}
	public ArrayList<Precio> getListaPrecios() {
		return ListaPrecios;
	}
	public void setListaPrecios(ArrayList<Precio> listaPrecios) {
		ListaPrecios = listaPrecios;
	}
	public ArrayList<Campo> getListaCampos() {
		return ListaCampos;
	}
	public void setListaCampos(ArrayList<Campo> listaCampos) {
		ListaCampos = listaCampos;
	}
	public ArrayList<Recurso> getListaRecursos() {
		return ListaRecursos;
	}
	public void setListaRecursos(ArrayList<Recurso> arrayList) {
		ListaRecursos = arrayList;
	}
	

}
