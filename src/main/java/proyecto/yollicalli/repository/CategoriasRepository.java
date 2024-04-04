package proyecto.yollicalli.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import proyecto.yollicalli.model.Categorias;

@Repository
public interface CategoriasRepository extends JpaRepository <Categorias, Long> {
    Optional<Categorias> findByNombreCategoria(String nombreCategoria);

}
