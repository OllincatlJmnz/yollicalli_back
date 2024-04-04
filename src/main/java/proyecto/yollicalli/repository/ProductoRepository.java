package proyecto.yollicalli.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import proyecto.yollicalli.model.Producto;

@Repository
public interface ProductoRepository extends  JpaRepository<Producto, Long>{
	Optional<Producto> findByNombreProducto(String nombreProducto);
}
