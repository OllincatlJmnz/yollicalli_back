package proyecto.yollicalli.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyecto.yollicalli.dto.ChangePaymentMethod;
import proyecto.yollicalli.model.PaymentMethod;
import proyecto.yollicalli.repository.PaymentMethodRepository;

@Service
public class PayMethodsService {

	private final PaymentMethodRepository paymentMethodRepository;
	
	@Autowired
	public PayMethodsService(PaymentMethodRepository paymentMethodRepository) {
			this.paymentMethodRepository = paymentMethodRepository;
		}
	
	public List<PaymentMethod> getAllPayMethods() {
		// TODO Auto-generated method stub
		return paymentMethodRepository.findAll();
	}//getAll

	public PaymentMethod getPaymentMethod(Long purchaseId) {
		// TODO Auto-generated method stub
		return paymentMethodRepository.findById(purchaseId).orElseThrow(
				()-> new IllegalArgumentException("El método de pago con el id ["+purchaseId+"] no existe.")
				);
	}//get(Single)
	
	public PaymentMethod addPaymentMethod(PaymentMethod paymentMethod) {
		// TODO Auto-generated method stub
		Optional<PaymentMethod> tmpPayment = paymentMethodRepository.findById(paymentMethod.getId());
		if (tmpPayment.isEmpty()) {
			return paymentMethodRepository.save(paymentMethod);
		}else {
			System.out.println("Ya existe el método de pago con la id ["+paymentMethod.getId()+"]");
			return null;
		}
	}//addPaymentMethod

	public PaymentMethod deletePaymentMethod(Long purchaseId) {
		// TODO Auto-generated method stub
		PaymentMethod tmpMethod = null;
		if (paymentMethodRepository.existsById(purchaseId)) {
			tmpMethod =  paymentMethodRepository.findById(purchaseId).get();
			paymentMethodRepository.deleteById(purchaseId);
		}
		return tmpMethod;
	}//deletePaymentMethod

	public PaymentMethod updatePaymentMethod(Long purchaseId, String method) {
		// TODO Auto-generated method stub
		PaymentMethod tmpMethod = null;
		if (paymentMethodRepository.existsById(purchaseId)) {
			tmpMethod =  paymentMethodRepository.findById(purchaseId).get();
				if(method != "") tmpMethod.setNombreMetodo(method);
				tmpMethod = paymentMethodRepository.save(tmpMethod);
		}//foreach
		return tmpMethod;
	}
	
	public PaymentMethod updatePaymentMethod(Long purchaseId, ChangePaymentMethod changePaymentMethod) {
		// TODO Auto-generated method stub
		PaymentMethod tmpMethod=null;
		if(paymentMethodRepository.existsById(purchaseId)) {
			tmpMethod= paymentMethodRepository.findById(purchaseId).get();
			if(tmpMethod.getNombreMetodo()==changePaymentMethod.getPaymentMethod()) 
			{
				tmpMethod.setNombreMetodo(changePaymentMethod.getnPaymentMethod());
				paymentMethodRepository.save(tmpMethod);
			} else{
				System.out.println("updatePaymentMethod - El método de pago ["+ tmpMethod.getId() +"] no coincide");
				tmpMethod = null;
			};
		}
		return tmpMethod;
	}
}
