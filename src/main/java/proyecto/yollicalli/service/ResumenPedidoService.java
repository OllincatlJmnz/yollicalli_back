package proyecto.yollicalli.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyecto.yollicalli.model.ResumenPedido;
import proyecto.yollicalli.repository.ResumenPedidoRepository;

@Service
public class ResumenPedidoService {
private final ResumenPedidoRepository resumenPedidoRepository;
	
	@Autowired
	public ResumenPedidoService(ResumenPedidoRepository resumenPedidoRepository) {
		this.resumenPedidoRepository = resumenPedidoRepository;
	}//constructor
	
	public List<ResumenPedido> getResumenes() {
		return resumenPedidoRepository.findAll();
	}

	public ResumenPedido getResumen(Long pedidoId) {
		return resumenPedidoRepository.findById(pedidoId).orElseThrow(
				() -> new IllegalArgumentException("El resumen de pedido con el id [" +
						pedidoId + "] no existe")
			);
	}

	public ResumenPedido addResumen(ResumenPedido resumenPedido) {
		ResumenPedido resumenTemporal = null;
		resumenTemporal = resumenPedidoRepository.save(resumenPedido);
			
		return resumenTemporal;
	}

	public ResumenPedido updateResumen(Long pedidoId, String estadoPedido) {
		ResumenPedido resumenPedido = null;
		if(resumenPedidoRepository.existsById(pedidoId)) {
			resumenPedido = resumenPedidoRepository.findById(pedidoId).get();
			if(estadoPedido.length() != 0) resumenPedido.setEstado(estadoPedido);
			resumenPedidoRepository.save(resumenPedido);
		}
		return resumenPedido;
	}

	public ResumenPedido deleteResumen(Long pedidoId) {
		ResumenPedido resumenTemporal = null;
		if(resumenPedidoRepository.existsById(pedidoId)) {
			resumenTemporal = resumenPedidoRepository.findById(pedidoId).get();
			resumenPedidoRepository.deleteById(pedidoId);
		}
		return resumenTemporal;
		
	}

	
}
