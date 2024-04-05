package proyecto.yollicalli.controller;

import javax.servlet.ServletException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Calendar;
import java.util.Date;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import proyecto.yollicalli.model.Usuario;
import proyecto.yollicalli.service.UserService;
import proyecto.yollicalli.config.JwtFilter;
import proyecto.yollicalli.dto.Token;
@CrossOrigin(origins="https://dhyanaixchelverjanvargas.github.io/")
@RestController
@RequestMapping(path="/api/login/")
public class LoginController {
	
	private final UserService userService;
	@Autowired
	public LoginController(UserService userService) {
		super();
		this.userService = userService;
	}//constructor
	
	@PostMapping
	public Token loginUser(@RequestBody Usuario usuario) throws ServletException {
		if (userService.validateUser(usuario)) {
			System.out.println("Usuario valido "+ usuario.getCorreo());
			return new Token(generateToken(usuario.getCorreo()));
		}//if
		throw new ServletException("Nombre de usuario o contraseña incorrectos"+ usuario.getCorreo());
		
	}//login User
	private String generateToken(String username) {
		Calendar calendar = Calendar.getInstance();//Fecha hora actual
		calendar.add(Calendar.HOUR, 10); // Pruebas
		//calendar.add(Calendar.MINUTE, 30);// Producción
		return Jwts.builder().setSubject(username).claim("role", "user")
		.setIssuedAt(new Date())
		.setExpiration(calendar.getTime())
		.signWith(SignatureAlgorithm.HS256, JwtFilter.secret)
		.compact();
	}//generateToken
	

}//class LoginController