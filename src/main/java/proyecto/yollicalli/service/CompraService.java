package proyecto.yollicalli.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyecto.yollicalli.model.Compra;
import proyecto.yollicalli.repository.CompraRepository;

@Service
public class CompraService {
	//public final ArrayList<Compra> list = new ArrayList<Compra>();
	
	public final CompraRepository compraRepository;
	@Autowired
	public CompraService(CompraRepository compraRepository) {
		this.compraRepository = compraRepository;
		/*
		list.add(new Compra(1250.35, 180.00));
		list.add(new Compra(256.00, 180.00));
		list.add(new Compra(380.50, 180.00));
		list.add(new Compra(450.87, 180.00));
		*/
	}
	
	public List<Compra> getAllCompras(){
		return compraRepository.findAll();
	}// getAllCompras

	
	public Compra getCompra(Long compraId) {
		return compraRepository.findById(compraId).orElseThrow(
				() -> new IllegalArgumentException("La Compra con el id [" +
						compraId + "] no existe")
				);
		/*
		Compra tmpCompra = null;
		for (Compra compra : list) {
			if(compra.getId() == compraId) {
				tmpCompra = compra;
				break;
			}
		}
		return tmpCompra;
		*/
	}// getCompra
	
	public Compra deleteCompra(Long compraId) {
		Compra tmpCompra = null;
		if(compraRepository.existsById(compraId)) {
			tmpCompra = compraRepository.findById(compraId).get();
			compraRepository.deleteById(compraId);
		}
		/*
		for (Compra compra : list) {
			if(compra.getId() == compraId) {
				tmpCompra = compra;
				list.remove(tmpCompra);
				break;
			}
		}
		*/
		return tmpCompra;
	}

	public Compra addCompra(Compra compra) {
		/*
		Compra tmpCompra = null;
		if(list.add(compra)) {
			tmpCompra = compra;
		}
		return tmpCompra;
		*/
		return compraRepository.save(compra);
	}
	
	public Compra updateCompra(Long compraId, Double subtotal, Double envio) {
		Compra compra = null;
		//for (Compra compra : list) {
			//if(compra.getId() == compraId) {
			if(compraRepository.existsById(compraId)) {
				compra = compraRepository.findById(compraId).get();
				if(subtotal.doubleValue() > 0) compra.setSubtotal(subtotal);
				if(envio.doubleValue() > 0) compra.setEnvio(envio);
				compra.setTotal(compra.getSubtotal() + compra.getEnvio());
				compraRepository.save(compra);
				//tmpCompra = compra;
				//break;
			}
			//}
		//}//foreach
		return compra;
	}
	
	/*
	public Compra updateCompra(int compraId, Double subtotal, Double envio) {
		Compra tmpCompra = null;
		for (Compra compra : list) {
			if(compra.getId() == compraId) {
				if(subtotal != null) compra.setSubtotal(subtotal);
				if(envio != null) compra.setEnvio(envio);
				compra.setTotal(compra.getSubtotal() + compra.getEnvio());
				tmpCompra = compra;
				break;
			}
		}
		return tmpCompra;
	}
	*/

}
