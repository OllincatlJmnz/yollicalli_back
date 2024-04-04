package proyecto.yollicalli.dto;

public class CambiarContrasenia {
	private String contrasenia;
	private String ncontrasenia;
	
	public CambiarContrasenia(String contrasenia, String ncontrasenia) {
		super();
		this.contrasenia = contrasenia;
		this.ncontrasenia = ncontrasenia;
	}

	public CambiarContrasenia() {
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public String getNcontrasenia() {
		return ncontrasenia;
	}

	public void setNcontrasenia(String ncontrasenia) {
		this.ncontrasenia = ncontrasenia;
	}

	@Override
	public String toString() {
		return "CambiarContrasenia [contrasenia=" + contrasenia + ", ncontrasenia=" + ncontrasenia + "]";
	}
}
