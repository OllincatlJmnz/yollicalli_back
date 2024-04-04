package proyecto.yollicalli.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import proyecto.yollicalli.model.Direccion;

@Repository
public interface DireccionRepository extends JpaRepository<Direccion, Long>{

}
