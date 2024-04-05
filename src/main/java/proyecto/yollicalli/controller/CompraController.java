package proyecto.yollicalli.controller;

import java.util.ArrayList;
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

import proyecto.yollicalli.model.Compra;
import proyecto.yollicalli.service.CompraService;
@CrossOrigin(origins="https://dhyanaixchelverjanvargas.github.io")
@RestController
@RequestMapping (path="/api/compras/")
public class CompraController {
	
	private final CompraService compraService;
	@Autowired
	public CompraController(CompraService compraService) {
		this.compraService = compraService;
	}// CompraController
	
	//GET
	@GetMapping
	public List<Compra> getCompras() {
		return compraService.getAllCompras();
	}
	
	@GetMapping (path="{compraId}")
	public Compra getCompra(@PathVariable("compraId")Long compraId) {
		return compraService.getCompra(compraId);
	}
	
	//POST
	@PostMapping
	public Compra addCompra(@RequestBody Compra compra) {
		return compraService.addCompra(compra);
	}
	
	//DELETE
	@DeleteMapping (path="{compraId}")
	public Compra deleteCompra(@PathVariable("compraId") Long compraId) {
		return compraService.deleteCompra(compraId);
	}
	
	//PUT
	@PutMapping (path="{compraId}")
	public Compra updateCompra(@PathVariable("compraId") Long compraId,
			@RequestBody Compra compra) {
		return compraService.updateCompra(compraId, Double.valueOf(compra.getSubtotal()),Double.valueOf(compra.getEnvio()));
	}
	
	/*
	//PUT
	@PutMapping (path="{compraId}")
	public Compra updateCompra(@PathVariable("compraId") int compraId,
			@RequestParam (required=false)Double subtotal,
			@RequestParam (required=false)Double envio) {
		return compraService.updateCompra(compraId, subtotal, envio);
	}
	*/
	
}// CompraController
