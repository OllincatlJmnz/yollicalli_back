package proyecto.yollicalli.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUsuario", unique = true, nullable = false)
    private Long id;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String correo;
    @Column(nullable = false)
    private String telefono;
    @Column(nullable = true)
    private String foto;
    @Column(nullable = false)
    private String contrasenia;
   //private static int total = 0;
    public Usuario(String nombre, String correo, String telefono, String foto, String contrasenia) {
        super();
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.foto = foto;
        this.contrasenia = contrasenia;
      //  Usuario.total++;
       // id = Usuario.total;
    }
    public Usuario() {
    //    Usuario.total++;
      //  id = Usuario.total;
    }
    public Long getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getContrasenia() {
        return contrasenia;
    }
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", correo=" + correo + ", telefono=" + telefono + ", foto="
				+ foto + ", contrasenia=" + contrasenia + "]";
	}
}
