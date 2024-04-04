package proyecto.yollicalli.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="compras")
public class Compra {
	// Atributos
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id", unique=true, nullable=false)
	private Long idCompra;
	@Column(nullable=false)
	private double subtotal;
	@Column(nullable=false)
	private double envio;
	private double total;
	//private static int totalId = 0;
	
	// Constructores
	public Compra(double subtotal, double envio) {
		this.subtotal = subtotal;
		this.envio = envio;
		this.total = subtotal + envio;
		//Compra.totalId++;
		//idCompra = Compra.totalId;
	}
	public Compra() {
		/*
		Compra.totalId++;
		idCompra = Compra.totalId;
		*/
	}
	
	// Métodos
	public Long getId() {
		return idCompra;
	}
	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	public double getEnvio() {
		return envio;
	}
	public void setEnvio(double envio) {
		this.envio = envio;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = subtotal + envio;
	}
	
	@Override
	public String toString() {
		return "Compra [subtotal=" + subtotal + ", envio=" + envio + ", total=" + total + ", idCompra=" + idCompra + "]";
	}
	
	
	
}
