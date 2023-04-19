package rf.com.tienda.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import rf.com.tienda.exception.DomainException;
import rf.com.tienda.util.ErrorMessages;
import rf.com.tienda.util.Validator;

@Entity
@Table(schema = "NGM_alumno", name = "CATEGORIA")
public class Categoria {
	
	//Atributos de la clase con sus anotaciones correspondientes
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int id_categoria;			//identificador categoria
	
	@Column(nullable = false, columnDefinition = "VARCHAR(50)")
	private String cat_nombre;          //nombre de la categoria
	
	@Column(nullable = false, columnDefinition = "VARCHAR(200) DEFAULT NULL")
	private String cat_descripcion;		//descripcion de la categoria
	
	
	//Constructor vacío de la clase
	public Categoria(){
		
	}
	
	
	/**
	 * Getter para identificador de categoria
	 * @return Integer con el id de la categoria
	 */
	public int getId_categoria() {
		return id_categoria;
	}
	
	/**
	 * Setter para identificador de categoria
	 * 
	 */
	public void setId_categoria(int id_categoria) {
		if (id_categoria > 0) {
			this.id_categoria = id_categoria;
		}
	}
	
	/**
	 * Getter para el nombre de categoria
	 * @return cadena con el nombre de la categoria
	 */
	public String getCat_nombre() {
		return cat_nombre;
		
	}
	
	/**
	 * Setter para el nombre de categoria
	 * 
	 */
	public void setCat_nombre(String cat_nombre) throws DomainException{
		if (Validator.cumpleLongitud(cat_nombre, 5, 50)) {
			this.cat_nombre = cat_nombre;
		}else {
			throw new DomainException(ErrorMessages.CATERR_001);
		}
		
	}
	
	/**
	 * Getter para la descripcion de categoria
	 * @return cadena con la descripcion de la categoria
	 */
	public String getCat_descripcion() {
		return cat_descripcion;
	}
	
	/**
	 * setter para la descripcion de categoria
	 * @throws DomainException 
	 * 
	 */
	public void setCat_descripcion(String cat_descripcion) throws DomainException {
		if (Validator.cumpleLongitudMax(cat_descripcion, 200)) {
			this.cat_descripcion = cat_descripcion;

		}else {
			throw new DomainException(ErrorMessages.CATERR_001);
		}
	}
	
	/**
	 * Método para validar si la instancia de la clase es válida
	 * @return true si la instancia es válida, false en caso contrario
	 */
	public boolean isValid(){	
		return !Validator.isVacio(cat_nombre) &&
				id_categoria > 0;
	}

	@Override
	public int hashCode() {
	    final int prime = 31; // número primo utilizado en la fórmula hash
	    int result = 1; // valor inicial del código hash
	    
	    // Se calcula el valor hash de cada campo, utilizando 0 si el campo es nulo
	    result = prime * result + ((cat_descripcion == null) ? 0 : cat_descripcion.hashCode());
	    result = prime * result + ((cat_nombre == null) ? 0 : cat_nombre.hashCode());
	    result = prime * result + id_categoria;
	    
	    // Se devuelve el valor final del código hash
	    return result;
	}


	@Override
	public boolean equals(Object obj) {
	    if (this == obj) return true;

	    if (obj == null) return false;

	    //Verifica si el objeto que se está comparando es una instancia de la clase Categoria
	    if (getClass() != obj.getClass()) return false;

	    //Convierte el objeto a una instancia de la clase Categoria
	    Categoria other = (Categoria) obj;

	    //Compara los valores de los atributos id_categoria, cat_nombre y cat_descripcion
	    if (cat_descripcion == null) {
	        if (other.cat_descripcion != null)
	            return false;

	    } else if (!cat_descripcion.equals(other.cat_descripcion))
	        return false;

	    if (cat_nombre == null) {
	        if (other.cat_nombre != null)
	            return false;

	    } else if (!cat_nombre.equals(other.cat_nombre))
	        return false;

	    if (id_categoria != other.id_categoria)
	        return false;

	    //Si los valores de todos los atributos son iguales, devuelve true
	    return true;
	}


	/**
	 * Retorna una cadena que representa la categoría, con el formato "Categoria [id_categoria=XXX, cat_nombre=XXX, cat_descripcion=XXX]"
	 * @return una cadena que representa la categoría
	 */
	@Override
	public String toString() {
		return "Categoria [id_categoria=" + id_categoria + ", cat_nombre=" + cat_nombre + ", cat_descripcion="
				+ cat_descripcion + "]";
	}
		
}
