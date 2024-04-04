package proyecto.yollicalli.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//POJO Plain Old Java Object

@Entity
@Table(name="metodo_pago")
public class PaymentMethod {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id", unique=true, nullable=false)
	private Long id;
	@Column(nullable=false)
	private String nombreMetodo;
	private static Long total = (long) 0;
	
	public PaymentMethod(String nombreMetodo) {
		this.nombreMetodo = nombreMetodo;
		PaymentMethod.total++;
		id= PaymentMethod.total;
	}
	
	public PaymentMethod() {
		PaymentMethod.total++;
		id= PaymentMethod.total;
	}

	public String getNombreMetodo() {
		return nombreMetodo;
	}

	public void setNombreMetodo(String nombreMetodo) {
		this.nombreMetodo = nombreMetodo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public static Long getTotal() {
		return total;
	}

	public static void setTotal(Long total) {
		PaymentMethod.total = total;
	}

	@Override
	public String toString() {
		return "paymentMethod [id=" + id + ", nombreMetodo=" + nombreMetodo + "]";
	}
	
	
}
