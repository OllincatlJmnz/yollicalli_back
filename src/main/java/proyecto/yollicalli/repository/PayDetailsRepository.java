package proyecto.yollicalli.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import proyecto.yollicalli.model.PayDetails;

@Repository
public interface PayDetailsRepository extends JpaRepository<PayDetails, Long> {
	Optional<PayDetails> findByAmount(Double amount);
}
