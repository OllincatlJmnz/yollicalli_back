package proyecto.yollicalli.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="productos")
public class Producto {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idProducto", unique=true, nullable=false)
	private Long idProducto;
	@Column(nullable=false)
	private String nombreProducto;
	@Column(nullable=false)
	private Long idCategoria;
	@Column(nullable=false)
	private String descripcion;
	@Column(nullable=false)
	private double precio;
	@Column(nullable=false)
	private String imagen;
	@Column(nullable=false)
	private int destacado;
	@Column(nullable=false)
	private int cantidad;
	@Column(nullable=true)
	private String talla;
	
	public Producto(String nombreProducto, Long idCategoria, String descripcion, double precio, String imagen,
			int destacado,String talla ,int cantidad) {
		super();
		this.nombreProducto = nombreProducto;
		this.idCategoria = idCategoria;
		this.descripcion = descripcion;
		this.precio = precio;
		this.imagen = imagen;
		this.destacado = destacado;
		this.cantidad = cantidad;
		this.talla = talla; 
	}
	
	public Producto() {
	}
	
	public Long getIdProducto() {
		return idProducto;
	}

	public Long getIdCategoria() {
		return idCategoria;
	}
	
	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public int getDestacado() {
		return destacado;
	}

	public void setDestacado(int destacado) {
		this.destacado = destacado;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getTalla() {
		return talla;
	}

	public void setTalla(String talla) {
		this.talla = talla;
	}

	@Override
	public String toString() {
		return "Producto [idProducto=" + idProducto + ", nombreProducto=" + nombreProducto + ", idCategoria="
				+ idCategoria + ", descripcion=" + descripcion + ", precio=" + precio + ", imagen=" + imagen
				+ ", destacado=" + destacado + ", cantidad=" + cantidad + ", talla=" + talla + "]";
	}	
	
}

