package proyecto.yollicalli.dto;

public class ChangePayDetails {
	private Double amount;
	private Double namount;
	
	public ChangePayDetails(Double amount, Double namount) {
		super();
		this.amount = amount;
		this.namount = namount;
	}
	
	public ChangePayDetails() {
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Double getNamount() {
		return namount;
	}

	public void setNamount(Double namount) {
		this.namount = namount;
	}

	@Override
	public String toString() {
		return "ChangePayDetails [amount=" + amount + ", namount=" + namount + "]";
	}
}
