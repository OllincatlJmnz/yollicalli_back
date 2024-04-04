package proyecto.yollicalli.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyecto.yollicalli.dto.ChangePayDetails;
import proyecto.yollicalli.model.PayDetails;
import proyecto.yollicalli.repository.PayDetailsRepository;

@Service
public class PayDetailsService {

	public final PayDetailsRepository payDetailsRepository;
	
	@Autowired
	public PayDetailsService(PayDetailsRepository payDetailsRepository) {
		this.payDetailsRepository = payDetailsRepository;
	}
	
	public List<PayDetails> getAllPayDetails() {
		// TODO Auto-generated method stub
		return payDetailsRepository.findAll();
	}//getAllPayDetails

	public PayDetails getPayDetails(Long purchaseId) {
		// TODO Auto-generated method stub
		return payDetailsRepository.findById(purchaseId).orElseThrow(
				()-> new IllegalArgumentException("El pago con el id ["+purchaseId+"] no existe.")
				);
	}//getPayDetails(Single)
	
	public PayDetails addPayDetails(PayDetails payDetails) {
		// TODO Auto-generated method stub
		Optional<PayDetails> tmpPayment = payDetailsRepository.findById(payDetails.getId());
		if (tmpPayment.isEmpty()) {
			return payDetailsRepository.save(payDetails);
		}else {
			System.out.println("Ya existe el pago con la id ["+payDetails.getId()+"]");
			return null;
		}
	}//addPayDetails
	
	public PayDetails deletePayDetails(Long purchaseId) {
		// TODO Auto-generated method stub
		PayDetails tmpPayment = null;
		if (payDetailsRepository.existsById(purchaseId)) {
			tmpPayment =  payDetailsRepository.findById(purchaseId).get();
			payDetailsRepository.deleteById(purchaseId);
		}
		return tmpPayment;
	}//deleteProduct

	public PayDetails updatePayDetails(Long purchaseId, Double amount) {
		// TODO Auto-generated method stub
		PayDetails payment = null;
		if (payDetailsRepository.existsById(purchaseId)) {
			payment =  payDetailsRepository.findById(purchaseId).get();
				if(amount.doubleValue() >0) payment.setAmount(amount);
				payment = payDetailsRepository.save(payment);
		}//foreach
		return payment;
	}
	
	public PayDetails updatePayDetails(Long purchaseId, ChangePayDetails changePayDetails) {
		// TODO Auto-generated method stub
		PayDetails tmpPayment=null;
		if(payDetailsRepository.existsById(purchaseId)) {
			tmpPayment= payDetailsRepository.findById(purchaseId).get();
			if(tmpPayment.getAmount()==changePayDetails.getAmount()) 
			{
				tmpPayment.setAmount(changePayDetails.getNamount());
				payDetailsRepository.save(tmpPayment);
			} else{
				System.out.println("updatePayDetails - La cantidad del pago ["+ tmpPayment.getId() +"] no coincide");
				tmpPayment = null;
			};
		}
		return tmpPayment;
	}
}
