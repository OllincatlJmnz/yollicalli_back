package proyecto.yollicalli.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


// POJO Plain Old Java Object

@Entity
@Table(name="detalle_pago")
public class PayDetails {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id", unique=true, nullable=false)
	private Long id;
	@Column(nullable=false)
	private double amount;
	private static Long total = (long) 0;
	
	public PayDetails(double amount) {
		this.amount = amount;
		PayDetails.total++;
		id= PayDetails.total;
	}
	
	public PayDetails() {
		PayDetails.total++;
		id= PayDetails.total;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
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
		PayDetails.total = total;
	}

	@Override
	public String toString() {
		return "PayDetails [id=" + id + ", amount=" + amount + "]";
	}
}
