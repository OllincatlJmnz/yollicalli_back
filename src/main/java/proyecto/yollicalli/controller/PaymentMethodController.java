package proyecto.yollicalli.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import proyecto.yollicalli.model.PaymentMethod;
import proyecto.yollicalli.service.PayMethodsService;

@CrossOrigin(origins="https://dhyanaixchelverjanvargas.github.io/Proyecto-YolliCalli/")
@RestController
@RequestMapping(path="/api/metodoDePago")
public class PaymentMethodController {

private final PayMethodsService payMethodsService;
	
	@Autowired
	public PaymentMethodController(PayMethodsService payMethodsService) {
		this.payMethodsService = payMethodsService;
	}

	@GetMapping
	public List<PaymentMethod> getAllPayMethods() {
		return payMethodsService.getAllPayMethods();
	}
	
	@GetMapping (path="{purchaseId}")
	public PaymentMethod getPaymentMethod(@PathVariable ("purchaseId") Long purchaseId) {
		return payMethodsService.getPaymentMethod(purchaseId);
	}
	
	//POST
	@PostMapping
	public PaymentMethod addPaymentMethod(@RequestBody PaymentMethod payDetails){
		return payMethodsService.addPaymentMethod(payDetails);
	}
	
	//PUT
	@PutMapping (path="{purchaseId}")
	public PaymentMethod updatePaymentMethod(@PathVariable ("purchaseId") Long purchaseId, 
			@RequestBody PaymentMethod payMethods){
		return payMethodsService.updatePaymentMethod(purchaseId, payMethods.getNombreMetodo());	
	}
		
	//DELETE
	@DeleteMapping (path="{purchaseId}")
	public PaymentMethod deletePaymentMethod(@PathVariable ("purchaseId") Long purchaseId){
		return payMethodsService.deletePaymentMethod(purchaseId);
	}
	
}
