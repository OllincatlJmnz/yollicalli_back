package proyecto.yollicalli.controller;

import java.util.List;

import proyecto.yollicalli.model.ResumenPedido;
import proyecto.yollicalli.service.ResumenPedidoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api/resumen_pedido/")
public class ResumenPedidoController {
	
	@Autowired
	private final ResumenPedidoService resumenPedidoService;
	public ResumenPedidoController(ResumenPedidoService resumenPedidoService) {
		this.resumenPedidoService = resumenPedidoService;
	}//resumen-pedido controller
	
	//GET
	@GetMapping 
	public List<ResumenPedido> getResumenes() {
		return resumenPedidoService.getResumenes();
	}
	
	//GET
	@GetMapping(path="{pedidoId}") //http://localhost:8080/api/resumen-pedido/id variable
	public ResumenPedido getResumen(@PathVariable("pedidoId") Long pedidoId) {
		return resumenPedidoService.getResumen(pedidoId);
	}
	
	//POST
	@PostMapping
	public ResumenPedido addResumen(@RequestBody ResumenPedido resumenPedido) {
		return resumenPedidoService.addResumen(resumenPedido);
	}
	/*Los post se hacen así por ahora:
	 * {
	 *	"fechaPedido": "yyyy-MM-dd HH:mm:ss",
	 * 	"estado": "Aquí va cualquier estado como Pagado o Entregado",
	 * 	"fecha": ""
	 * }
	 */
	
	//PUT
	@PutMapping(path="{pedidoId}")
	public ResumenPedido updateResumen(@PathVariable("pedidoId") Long pedidoId,
			@RequestParam String estadoPedido) {
		return resumenPedidoService.updateResumen(pedidoId, estadoPedido);
	}
	
	//DELET
	@DeleteMapping(path="{pedidoId}")
	public ResumenPedido deletePedido(@PathVariable("pedidoId") Long pedidoId) {
		return resumenPedidoService.deleteResumen(pedidoId);
	}
	
}
