package control;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import dominio.Campo;
import dominio.Cooperativa;
import dominio.Granja;
import dominio.Usuario;
import modelo.Modelo;

public class CUsuarios extends Control {

	private Modelo modelo;
	private String login, pass, pass2, nombre, apellidos, correo, telefono, fecha, nombreGranja, nombreCooperativa;
	private boolean activo = false;
	private String regisOmod;

	public String validarDatos() {
		setListaUsuarios((ArrayList<Usuario>) modelo.consultaUsuarios());
		for (Usuario usuarios : getListaUsuarios()) {
			if (login.equals(usuarios.getLogin()) && pass.equals(usuarios.getPass())) {
				setUsuarioOb(usuarios);
				nombre = usuarios.getNombre();
				apellidos = usuarios.getApellidos();
				fecha = usuarios.getFecha();
				correo = usuarios.getCorrero();
				telefono = usuarios.getTelefono();
				nombreGranja = usuarios.getGranja().getNombre();
				if (usuarios.getCooperativa() != null)
					nombreCooperativa = usuarios.getCooperativa().getNombre();
				else
					nombreCooperativa = "N/A";
				activo = true;
				regisOmod = "Modificar";
				return "registro.xhtml";
			}
		}

		return "error.xhtml";
	}

	public String registrar() {
		setListaCooperativas((ArrayList<Cooperativa>) modelo.consultaCooperativas());
		setCooperativaOb(null);
		for (Cooperativa coop : getListaCooperativas()) {
			if (nombreCooperativa.equals(coop.getNombre())) {
				setCooperativaOb(coop);
				getCooperativaOb().setNumero_Miembros(getCooperativaOb().getNumero_Miembros() + 1);
				modelo.modificacion(getCooperativaOb());
			}
		}
		if (getCooperativaOb() == null) {
			setCooperativaOb(new Cooperativa(nombreCooperativa, " ", 0, 1));
			modelo.alta(getCooperativaOb());
		}
		if (regisOmod.equals("Resgistrar")) {
			setUsuarioOb(new Usuario(login, pass, nombre, apellidos, telefono, correo, fecha, 0, new Granja(nombreGranja),
					getCooperativaOb()));
			if (pass.equals(pass2)) {
				setGranjaOb(new Granja(nombreGranja));
				modelo.alta(getGranjaOb());
				setListaGranjas((ArrayList<Granja>) modelo.consultaGranjas());
				for (Granja granja : getListaGranjas()) {
					if (getGranjaOb().getNombre().equals(granja.getNombre())) {
						getUsuarioOb().setGranja(granja);
						setGranjaOb(granja);
					}
				}
				modelo.alta(getUsuarioOb());
				modelo.alta(new Campo(null, null, getGranjaOb()));
			} else
				return "error.xhtml";
		} else {
			getUsuarioOb().setNombre(nombre);
			getUsuarioOb().setApellidos(apellidos);
			getUsuarioOb().setCorrero(correo);
			getUsuarioOb().setFecha(fecha);
			getUsuarioOb().setTelefono(telefono);
			getUsuarioOb().setCooperativa(getCooperativaOb());
			modelo.modificacion(getUsuarioOb());
		}
		return "index.xhtml";

	}

	public String prepareRegistrar() {
		login = "";
		pass = "";
		nombre = "";
		apellidos = "";
		fecha = "";
		correo = "";
		telefono = "";
		nombreCooperativa = "";
		nombreGranja = "";
		activo = false;
		regisOmod = "Resgistrar";
		return "registro.xhtml";
	}

	public String formatoFecha(GregorianCalendar fecha) {
		String fomateada = fecha.toInstant().toString();
		fomateada = fomateada.substring(0, fomateada.indexOf("T"));
		return fomateada;
	}

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public String getRegisOmod() {
		return regisOmod;
	}

	public void setRegisOmod(String regisOmod) {
		this.regisOmod = regisOmod;
	}

	public String getPass2() {
		return pass2;
	}

	public void setPass2(String pass2) {
		this.pass2 = pass2;
	}

	public String getNombreGranja() {
		return nombreGranja;
	}

	public void setNombreGranja(String nombreGranja) {
		this.nombreGranja = nombreGranja;
	}

	public String getNombreCooperativa() {
		return nombreCooperativa;
	}

	public void setNombreCooperativa(String nombreCooperativa) {
		this.nombreCooperativa = nombreCooperativa;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getFecha() {
		return fecha;
	}

}
