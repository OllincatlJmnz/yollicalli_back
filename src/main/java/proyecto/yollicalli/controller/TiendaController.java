package proyecto.yollicalli.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import proyecto.yollicalli.dto.ProductosResponse;
import proyecto.yollicalli.model.Producto;
import proyecto.yollicalli.service.ProductoService;

@RestController
@RequestMapping(path = "/tienda")
public class TiendaController {
	private final ProductoService productoService;
	
	@Autowired
	public TiendaController(ProductoService productoService) {
		this.productoService = productoService;
	}
	
	@GetMapping(path = "/productos") //http://localhost:8080/tienda/productos?pagina=1 otro link seria http://localhost:8080/tienda/productos?categorias=1&pagina=1
	public ProductosResponse getProductos(
			@RequestParam (required=false) String buscar,
			@RequestParam (required=false) String ordenPrecio,
			@RequestParam (required=false) String ordenNombre,
			@RequestParam (required=false) String categorias,
			@RequestParam (required=false) Double precioMenor,
			@RequestParam (required=false) Double precioMayor,
			@RequestParam (required=true) int pagina){
		List<Producto> tmpProductos =  null;
		tmpProductos = productoService.getAllProductos();

		if(ordenPrecio != null) {
			tmpProductos=productoService.ordenProductosPrecio(tmpProductos,ordenPrecio);
		}else{
			System.out.println("no se aplico filtro de ordenar por precio");
		}
		
		if(ordenNombre != null) {
			tmpProductos=productoService.ordenProductosNombre(tmpProductos,ordenNombre);
		}else {
			System.out.println("no se aplico filtro de ordenar por nombre");
		}
		
		if(categorias != null) {
			tmpProductos = productoService.filtrarCategorias(tmpProductos, categorias);
		}else {
			System.out.println("no se aplico filtro de seleccionar por categorias");
		}
		
		if(precioMenor != null && precioMayor != null) {
			tmpProductos = productoService.filtrarPrecios(tmpProductos, precioMenor, precioMayor);
		}else {
			System.out.println("no se aplico filtro de rango de precio");
		}
		
		if(buscar != null) {
			tmpProductos = productoService.getProductosBuscar(tmpProductos,buscar);
		}
		
		return productoService.productosPaginacion(tmpProductos, pagina);
		
	}//getProductos

}

