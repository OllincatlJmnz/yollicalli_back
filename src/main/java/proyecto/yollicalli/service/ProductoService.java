package proyecto.yollicalli.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyecto.yollicalli.dto.ProductosResponse;
import proyecto.yollicalli.model.Producto;
import proyecto.yollicalli.repository.ProductoRepository;

@Service
public class ProductoService {
	private final ProductoRepository productoRepository;
	
	@Autowired
	public ProductoService(ProductoRepository productoRepository) {
		this.productoRepository = productoRepository;
	}
	
	public Producto getProducto(Long prodId) {
		return productoRepository.findById(prodId).orElseThrow(
				()-> new IllegalArgumentException("El producto con el Id ["+
						prodId + "] no existe")
				);
	}//getProducto
	
	public List<Producto> getAllProductos(){
		return productoRepository.findAll();
	}//getAllProductos
	
	public List<Producto> ordenProductosPrecio(List<Producto> productos, String orden) {
		
		if (orden.equals("ASC")) {
	        Collections.sort(productos, Comparator.comparingDouble(Producto::getPrecio));
	    } else if (orden.equals("DESC")) {
	        Collections.sort(productos, Comparator.comparingDouble(Producto::getPrecio).reversed());
	    }
	    return productos;
    }//ordenProductosPrecio
	

	public List<Producto> ordenProductosNombre(List<Producto> productos, String orden) {

		if (orden.equals("ASC")) {
	        Collections.sort(productos, Comparator.comparing(Producto::getNombreProducto));
	    } else if (orden.equals("DESC")) {
	        Collections.sort(productos, Comparator.comparing(Producto::getNombreProducto).reversed());
	    }
	    return productos;
    }//ordenProductosNombre
	
	public List<Producto> filtrarCategorias(List<Producto> productos, String categorias) {
        String[] categoriasArray = categorias.split("_");
        int[] categoriasInt = new int[categoriasArray.length];
        List<Producto> productosFiltrados = new ArrayList<>();

        for (int i = 0; i < categoriasArray.length; i++) {
            categoriasInt[i] = Integer.parseInt(categoriasArray[i]);
        }
        
        if(categoriasInt.length == 1 && categoriasInt[0]==0) {
        	return productos;
        }

        for (Producto producto : productos) {
            boolean perteneceACategoria = false;
            for (int idCategoria : categoriasInt) {
                if (idCategoria == producto.getIdCategoria()) {
                    perteneceACategoria = true;
                    break;
                }
            }
            if (perteneceACategoria) {
                productosFiltrados.add(producto);
            }
        }

        return productosFiltrados;
    }//filtrarCategorias
	
	public List<Producto> filtrarPrecios(List<Producto> productos, Double precioMenor, Double precioMayor) {
        List<Producto> productosFiltrados = new ArrayList<>();

        for (Producto producto : productos) {
            if (producto.getPrecio() >= precioMenor && producto.getPrecio() <= precioMayor) {
                productosFiltrados.add(producto);
            }
        }

        return productosFiltrados;
    }//filtrarPrecios
	
	public List<Producto> getProductosBuscar(List<Producto> productos, String buscar) {
        String[] palabrasClave = buscar.split("_");
        List<Producto> productosCoincidentes = new ArrayList<>();
        
        for (Producto producto : productos) {
            for (String palabra : palabrasClave) {
                if (producto.getNombreProducto().toLowerCase().contains(palabra.toLowerCase())) {
                	productosCoincidentes.add(producto);
                    break;
                }
            }
        }
        return productosCoincidentes;
    }//getProductosBuscar
    
	public ProductosResponse productosPaginacion(List<Producto> productos,int pagina) {
		int tamanio = productos.size();
        int productosPorPagina = 12;
        int inicio = (pagina - 1) * productosPorPagina;
        int fin = Math.min(inicio + productosPorPagina, productos.size());
        List<Producto> productosPagina = new ArrayList<Producto>(productos.subList(inicio, fin));
        int paginas = (int) Math.ceil((double) tamanio / productosPorPagina);
        return new ProductosResponse(productosPagina, tamanio, paginas);
	}//productosPaginacion
	
    public Producto addProducto(Producto producto) {
    	Optional<Producto> tmpProducto= productoRepository.findByNombreProducto(producto.getNombreProducto());
    	if(tmpProducto.isEmpty()) {
    		return productoRepository.save(producto);
    	}else {
    		System.out.println("Ya "
    				+ "existe el producto con el nombre ["
    				+producto.getNombreProducto() + "]");
    		return null;
    	}
    }//addProducto
    
    public Producto updateProducto(Long prodID, String nombre, Long idCategoria,String descripcion, Double precio,
    								String urlImgen, int destacado, int cantidad, String talla) {
    	Producto tmpProd = null;
    	if(productoRepository.existsById(Long.valueOf(prodID))) {
    		tmpProd = productoRepository.findById(Long.valueOf(prodID)).get();
    		if(nombre.length() != 0 ) tmpProd.setNombreProducto(nombre);
    		if(idCategoria.longValue() > 0 ) tmpProd.setIdCategoria(idCategoria);
    		if(descripcion.length() != 0 ) tmpProd.setDescripcion(descripcion);
    		if(precio.doubleValue() > 0 ) tmpProd.setPrecio(precio);
    		if(urlImgen.length() > 0) tmpProd.setImagen(urlImgen);
    		tmpProd.setDestacado(destacado);
    		if(cantidad > 0) tmpProd.setCantidad(cantidad);
    		if(talla.length() > 0 ) tmpProd.setTalla(talla);
    		productoRepository.save(tmpProd);
    	}
    	return tmpProd;
    }
    
    public Producto deleteProducto(Long prodId) {
    	Producto tmpProd = null;
    	if(productoRepository.existsById(prodId)) {
    		tmpProd = productoRepository.findById(prodId).get();
    		productoRepository.deleteById(prodId);
    	}
    	return tmpProd;
    }// deleteProducto
    
    public List<Producto> getProductsDestacados(List<Producto> productos) {
        List<Producto> productosDestacados = new ArrayList<>();

        for (Producto producto : productos) {
            if(producto.getDestacado() == 1) {
            	productosDestacados.add(producto);
            }
        }

        return productosDestacados;
    }//filtrarDestacados

}
