package proyecto.yollicalli.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import proyecto.yollicalli.dto.CambiarContrasenia;
import proyecto.yollicalli.model.Usuario;
import proyecto.yollicalli.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class UserService {
    private final UserRepository userRepository;
    private  PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }
    public List<Usuario> getAllUsers() {
        return userRepository.findAll();
    }
    public Usuario getUser(Long userId) {
        return userRepository.findById(userId).orElseThrow(
                () -> new IllegalArgumentException("El usuario con el id[" + userId + "] no se encuentra registrado ")
        );
    }
    public Usuario addUser(Usuario usuario) {
    	Usuario tmpUsuario= null;
		if(userRepository.findByCorreo(usuario.getCorreo()).isEmpty()) {
			usuario.setContrasenia(passwordEncoder.encode(usuario.getContrasenia()));
			tmpUsuario = userRepository.save(usuario);
		}else {
			System.out.println("Ya existe el correo [" +
					usuario.getCorreo() + "]");
			
	}
		return tmpUsuario;
}//addUser
    public Usuario deleteUser(Long userId) {
        Usuario tmpUsuario = null;
        if (userRepository.existsById(userId)) {
            tmpUsuario = userRepository.findById(userId).get();
            userRepository.deleteById(userId);
        }
        return tmpUsuario;
    }

   

    public Usuario updateUser(Long userId, String nombre, String telefono, String foto) {
        Usuario tmpUsuario = null;
        if (userRepository.existsById(userId)) {
            tmpUsuario = userRepository.findById(userId).get();
            if (nombre.length() != 0) tmpUsuario.setNombre(nombre);
            if (telefono.length() != 0) tmpUsuario.setTelefono(telefono);
            if (foto.length() != 0) tmpUsuario.setFoto(foto);
            userRepository.save(tmpUsuario);
        }
        return tmpUsuario;
    }

    public Usuario updateUserPassword(Long userId, CambiarContrasenia changePassword) {
        Usuario tmpUsuario = null;
        if (userRepository.existsById(userId)) {
            tmpUsuario = userRepository.findById(userId).get();
            if (tmpUsuario.getContrasenia().equals(changePassword.getContrasenia())) {
                tmpUsuario.setContrasenia(changePassword.getNcontrasenia());
                userRepository.save(tmpUsuario);
            } else {
                System.out.println("UpdateUser - la contraseña del usuario [" + tmpUsuario.getId() + "] no coincide");
            }
        }
        return tmpUsuario;
    }

    public boolean validateUser(Usuario usuario) {
        Optional<Usuario> userByEmail = userRepository.findByCorreo(usuario.getCorreo());
        if (userByEmail.isPresent()) {
            Usuario tmpUsuario = userByEmail.get();
            // Verificar si la contraseña coincide en texto plano o cifrada
            if (usuario.getContrasenia().equals(tmpUsuario.getContrasenia()) || 
                passwordEncoder.matches(usuario.getContrasenia(), tmpUsuario.getContrasenia())) {
                return true;
            }
        }
        return false;
    }
}