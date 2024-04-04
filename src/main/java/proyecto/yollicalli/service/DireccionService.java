package proyecto.yollicalli.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import proyecto.yollicalli.model.Direccion;
import proyecto.yollicalli.repository.DireccionRepository;

@Service
public class DireccionService {
	
	public final DireccionRepository direccionRepository;
	@Autowired
	public DireccionService(DireccionRepository direccionRepository) {
		this.direccionRepository = direccionRepository;
	}//DireccionService

	public List<Direccion> getAllDirecciones() {
		return direccionRepository.findAll();
	}//getAllDirecciones

	public Direccion getDireccion(Long direccionId) {
		return direccionRepository.findById(direccionId).orElseThrow(
				()-> new IllegalArgumentException("La dirección con el id [" +
		direccionId + "] no existe"));
	}//getDireccion

	public Direccion addDireccion(Direccion direccion) {
		Direccion tmpDireccion = null;
		tmpDireccion = direccionRepository.save(direccion);
			return tmpDireccion;
		
	}//addDireccion

	public Direccion deleteDireccion(Long direccionId) {
		Direccion tmpDireccion = null;
		if(direccionRepository.existsById(direccionId)) {
		tmpDireccion = direccionRepository.findById(direccionId).get();
		direccionRepository.deleteById(Long.valueOf(direccionId));
		}//if
		return tmpDireccion;
	}//deleteDireccion

	
}//class DireccionService
