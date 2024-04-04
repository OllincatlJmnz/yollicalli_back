package proyecto.yollicalli.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="resumen_pedido")
public class ResumenPedido {
	/*Propiedades*/
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="idResumen", unique=true, nullable=false)
	private Long idResumen;
	
	@Column(name="fechaPedido", nullable=false)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
	private Date fechaPedido;
	
	@Column(name="estadoPedido", length=20, nullable=false)
	private String estadoPedido;
	
	/*Constructores*/
	public ResumenPedido(Date fechaPedido, String estadoPedido) {
		this.fechaPedido = fechaPedido;
		this.estadoPedido = estadoPedido;
	}
	public ResumenPedido() {}

	public Date getFecha() {
		return fechaPedido;
	}

	/*public void setFecha(Date fecha) {
		this.date = fecha;
	}*/

	public String getEstado() {
		return estadoPedido;
	}

	public void setEstado(String estado) {
		this.estadoPedido = estado;
	}

	public Long getId() {
		return idResumen;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + idResumen + ", fecha=" + fechaPedido + ", estado=" + estadoPedido + "]";
	}	
	
	
}
