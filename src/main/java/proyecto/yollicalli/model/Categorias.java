package proyecto.yollicalli.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity 
@Table (name="categorias")
public class Categorias {
	
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="idCategoria", unique=true, nullable=false)
        private Long idCategoria;
		@Column(nullable=false)
        private String nombreCategoria;
		public Categorias(Long idCategoria, String nombreCategoria) {
			super();
			this.idCategoria = idCategoria;
			this.nombreCategoria = nombreCategoria;
		}
        
        public Categorias() {
		}

		public String getNombreCategoria() {
			return nombreCategoria;
		}

		public void setNombreCategoria(String nombreCategoria) {
			this.nombreCategoria = nombreCategoria;
		}

		public Long getIdCategoria() {
			return idCategoria;
		}

		@Override
		public String toString() {
			return "Categorias [idCategoria=" + idCategoria + ", nombreCategoria=" + nombreCategoria + "]";
		}
    }



