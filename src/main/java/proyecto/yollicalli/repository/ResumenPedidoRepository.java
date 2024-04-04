package proyecto.yollicalli.repository;

import org.springframework.stereotype.Repository;

import proyecto.yollicalli.model.ResumenPedido;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ResumenPedidoRepository extends JpaRepository<ResumenPedido, Long>{
}
