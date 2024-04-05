package proyecto.yollicalli.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import proyecto.yollicalli.dto.CambiarContrasenia;
import proyecto.yollicalli.model.Usuario;
import proyecto.yollicalli.service.UserService;

@CrossOrigin(origins="https://dhyanaixchelverjanvargas.github.io/Proyecto-YolliCalli/")
@RestController
@RequestMapping(path="/api/usuarios/") // Cambio de users a usuarios
public class UserController {

	private final UserService userService;
	@Autowired
	public UserController(UserService userService) {
		this.userService=userService;
	}
	
	@GetMapping
	public List<Usuario> getUsers() {
		return userService.getAllUsers();	
	}
	
	@GetMapping(path="{userId}")
	public Usuario getUser(@PathVariable("userId") Long userId) {
		return userService.getUser(userId);
	}
	
	@PostMapping
	public Usuario addUser(@RequestBody Usuario usuario) {
		return userService.addUser(usuario);
	}
	
	@DeleteMapping(path="{userId}")
	public Usuario deleteUser(@PathVariable("userId") Long userId) {
		return userService.deleteUser(userId);
	}
	
	@PutMapping(path="{userId}")
	public Usuario updateUser(@PathVariable("userId") Long userId,
			@RequestBody Usuario usuario) {
		return userService.updateUser(userId, usuario.getNombre(), usuario.getTelefono(), usuario.getFoto());
	}
	@PutMapping(path="password/{userId}")
	public Usuario updateUserPassword(@PathVariable ("userId") Long userId, @RequestBody CambiarContrasenia changePassword) {
		return userService.updateUserPassword(userId, changePassword);
	}
}