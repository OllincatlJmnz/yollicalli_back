package proyecto.yollicalli.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;


import proyecto.yollicalli.model.Direccion;
import proyecto.yollicalli.service.DireccionService;

@CrossOrigin(origins="https://dhyanaixchelverjanvargas.github.io")
@RestController
@RequestMapping (path="/api/direcciones/")
public class DireccionController {

	private final DireccionService direccionService;
	@Autowired 
	public DireccionController(DireccionService direccionService) {
		this.direccionService=direccionService;
	}
	
	//GET
	@GetMapping
	public List<Direccion> getDirecciones(){
		return direccionService.getAllDirecciones();
	}//getDirecciones
	
	@GetMapping (path="{direccionId}")
	public Direccion getDireccion(@PathVariable("direccionId") Long direccionId) {
		return direccionService.getDireccion(direccionId);
	}//getDireccion
	
	//POST
	@PostMapping
	public Direccion addDireccion(@RequestBody Direccion direccion) {
		return direccionService.addDireccion(direccion);
	}//adduser
	
	//DELETE
	@DeleteMapping (path="{direccionId}")
	public Direccion deleteDireccion(@PathVariable("direccionId") Long direccionId) {
		return direccionService.deleteDireccion(direccionId);
	}//delete
	
}//DireccionController
