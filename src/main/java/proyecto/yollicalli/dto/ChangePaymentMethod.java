package proyecto.yollicalli.dto;

public class ChangePaymentMethod {
	private String paymentMethod;
	private String nPaymentMethod;
	
	public ChangePaymentMethod(String paymentMethod, String nPaymentMethod) {
		super();
		this.paymentMethod = paymentMethod;
		this.nPaymentMethod = nPaymentMethod;
	}
	
	public ChangePaymentMethod() {
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getnPaymentMethod() {
		return nPaymentMethod;
	}

	public void setnPaymentMethod(String nPaymentMethod) {
		this.nPaymentMethod = nPaymentMethod;
	}

	@Override
	public String toString() {
		return "ChangePaymentMethod [paymentMethod=" + paymentMethod + ", nPaymentMethod=" + nPaymentMethod + "]";
	}
	
}
