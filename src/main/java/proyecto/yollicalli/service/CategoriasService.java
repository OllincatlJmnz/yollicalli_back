package proyecto.yollicalli.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyecto.yollicalli.model.Categorias;
import proyecto.yollicalli.repository.CategoriasRepository;

@Service
public class CategoriasService {

    private final CategoriasRepository categoriasRepository;

    @Autowired
    public CategoriasService(CategoriasRepository categoriasRepository) {
        this.categoriasRepository = categoriasRepository;
    }

    public List<Categorias> getAllCategorias() {
        return categoriasRepository.findAll();
    }

    public Categorias getCategoriaById(Long id) {
        return categoriasRepository.findById(id).orElseThrow(
        		()->new IllegalArgumentException("El producto con el Id ["+
						id + "] no existe")
        		);
    }

    public Categorias addCategoria(Categorias categoria) {
    	Optional<Categorias> tmpCategorias=categoriasRepository.findByNombreCategoria(categoria.getNombreCategoria());
    	if (tmpCategorias.isEmpty()) {
    		return categoriasRepository.save(categoria);
    	}
    	
    	else {
    		System.out.println("Ya existe el producto con el nombre ["
    				+categoria.getNombreCategoria() + "]");
    		return null;
    	}
    }

    public void deleteCategoria(Long id) {
        categoriasRepository.deleteById(id);
    }

   }

