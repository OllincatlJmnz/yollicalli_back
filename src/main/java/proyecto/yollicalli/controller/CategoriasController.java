package proyecto.yollicalli.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import proyecto.yollicalli.model.Categorias;
import proyecto.yollicalli.service.CategoriasService;
@CrossOrigin(origins="https://dhyanaixchelverjanvargas.github.io")
@RestController
@RequestMapping(path = "/api/categorias/")
public class CategoriasController {

    private final CategoriasService categoriasService;

    @Autowired
    public CategoriasController(CategoriasService categoriasService) {
        this.categoriasService = categoriasService;
    }

    @GetMapping
    public List<Categorias> getCategorias() {
        return categoriasService.getAllCategorias();
       }
    @GetMapping(path="{catId}")
    public Categorias getCategoria(@PathVariable("catId") Long catId) {
    	return categoriasService.getCategoriaById(catId);
    }
    @PostMapping
    public Categorias addCategoria(@RequestBody Categorias categoria) {
    return categoriasService.addCategoria(categoria);
    }
   }
