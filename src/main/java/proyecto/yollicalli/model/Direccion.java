package proyecto.yollicalli.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="direcciones")
public class Direccion {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id", unique=true, nullable=false)
	private Long id;
	@Column(nullable=false)
	private String calle;
	@Column(nullable=false)
	private String municipio_alcaldia;
	@Column(nullable=false)
	private String estado;
	@Column(nullable=true)
	private String ciudad;
	@Column(nullable=false)
	private String cp;
	
	public Direccion(String calle, String municipio_alcaldia, String estado, String ciudad, String cp) {
		super();
		this.calle = calle;
		this.municipio_alcaldia = municipio_alcaldia;
		this.estado = estado;
		this.ciudad = ciudad;
		this.cp = cp;
	}//Constructor
	
	public Direccion() {}//constructor vacío
	
	public Long getId() {
		return id;
	}//getId

	public String getCalle() {
		return calle;
	}//getCalle

	public void setCalle(String calle) {
		this.calle = calle;
	}//setCalle

	public String getMunicipio_alcaldia() {
		return municipio_alcaldia;
	}//getMunicipio_Alcaldia

	public void setMunicipio_alcaldia(String municipio_alcaldia) {
		this.municipio_alcaldia = municipio_alcaldia;
	}//setMunicipio_Alcaldia

	public String getEstado() {
		return estado;
	}//getEstado

	public void setEstado(String estado) {
		this.estado = estado;
	}//setEstado

	public String getCiudad() {
		return ciudad;
	}//getCiudad

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}//setCiudad

	public String getCp() {
		return cp;
	}//getCp

	public void setCp(String cp) {
		this.cp = cp;
	}//setCp

	@Override
	public String toString() {
		return "Direccion [id=" + id + ", calle=" + calle + ", municipio_alcaldia=" + municipio_alcaldia + ", estado="
				+ estado + ", ciudad=" + ciudad + ", cp=" + cp + "]";
	}//toString
	
}//class Direccion
