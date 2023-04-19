package rf.com.tienda.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import rf.com.tienda.exception.DomainException;
import rf.com.tienda.util.ErrorMessages;
import rf.com.tienda.util.Validator;

@Entity
@Table(schema = "NGM_alumno", name = "USUARIO")
public class Usuario{
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@JsonProperty("id")
	private int id_usuario;					//identificador de usuario

	@Column(nullable = false, columnDefinition = "VARCHAR(100)")
	@JsonProperty("nombre")
	private String user_nombre;				//nombre del usuario

	@Column(nullable = false, columnDefinition = "VARCHAR(100)")
	@JsonProperty("email")
	private String user_email;				//email del usuario

	@Column(nullable = false, columnDefinition = "VARCHAR(20)")
	@JsonProperty("password")
	private String user_pass;				//contraseña del usuario

	@Column(nullable = false, columnDefinition = "NUMERIC")
	private int id_tipo; 					//tipo de usuario

	@Column(name = "user_dni")
	private String user_dni; //numero_dni;

	@Column(name = "user_fecAlta")
	private LocalDate user_fecAlta; //user fecha de alta 

	@Column(name = "user_fecConfirmacion")
	private LocalDate user_fecConfirmacion;

	@Embedded
	@Column
	//datos de pago y datos de direccion envio           
	private Direccion user_pago;

	@AttributeOverrides({
	    @AttributeOverride(name ="dir_nombre", column= @Column(name="dir_nombre_pago")),
	    @AttributeOverride(name ="dir_nombre", column= @Column(name="dir_nombre_envio")),
	});
}

