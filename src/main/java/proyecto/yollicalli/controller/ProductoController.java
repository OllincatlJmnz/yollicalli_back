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

import proyecto.yollicalli.model.Producto;
import proyecto.yollicalli.service.ProductoService;

@CrossOrigin(origins="https://dhyanaixchelverjanvargas.github.io/Proyecto-YolliCalli/")
@RestController
@RequestMapping(path="/api/products/")
public class ProductoController {
	private final ProductoService productoService;
	@Autowired
	public ProductoController(ProductoService productoService) {
		this.productoService = productoService;
	}
	
	@GetMapping
	public List<Producto> getProducts() {
		return productoService.getAllProductos();
	}
	
	//GET
	@GetMapping(path="{prodId}")
	public Producto getProduto(@PathVariable("prodId") Long prodId) {
		return productoService.getProducto(prodId);
	}
	
	@GetMapping(path="destacados")
	public List<Producto> getProductsDestacados() {
		List<Producto> tmpProductos =  null;
		tmpProductos = productoService.getAllProductos();
		return productoService.getProductsDestacados(tmpProductos);
	}
	
	//Post
	@PostMapping
	public Producto addProducto(@RequestBody Producto producto) {
		return productoService.addProducto(producto);
	}
	
	//PUT
	@PutMapping(path="{prodID}")
	public Producto updateProducto(@PathVariable("prodID") Long prodID,
			@RequestBody Producto producto) {
		return productoService.updateProducto(prodID, producto.getNombreProducto(),producto.getIdCategoria(), producto.getDescripcion(), 
											  producto.getPrecio(),producto.getImagen(),producto.getDestacado(), producto.getCantidad(),
											  producto.getTalla());
	}
	
	//DELETE
	@DeleteMapping(path="{prodID}")
	public Producto deleteProducto(@PathVariable("prodID") Long prodID) {
		return productoService.deleteProducto(prodID);
	}
}
