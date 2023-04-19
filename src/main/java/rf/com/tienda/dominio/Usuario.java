package rf.com.tienda.dominio;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embedded;
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
	private int id_usuario;					//identificador de usuario

	@Column(nullable = false, columnDefinition = "VARCHAR(100)", name = "nombre")
	private String user_nombre;				//nombre del usuario

	@Column(nullable = false, columnDefinition = "VARCHAR(100)", name = "email")
	private String user_email;				//email del usuario

	@Column(nullable = false, columnDefinition = "VARCHAR(20)", name = "password")
	private String user_pass;				//contraseña del usuario

	@Column(nullable = false, columnDefinition = "NUMERIC", name = "tipo")
	private int id_tipo; 					//tipo de usuario

	@Column(nullable = false, columnDefinition = "VARCHAR(12)", name = "dni")
	private String user_dni; 				//numero de dni del usuario

	@Column(nullable = false, columnDefinition = "DATE", name = "fecha_alta")
	private LocalDate user_fecAlta; 		//fecha de alta usuario 

	@Column(nullable = false, columnDefinition = "DATE", name = "fecha_confirmacion")
	private LocalDate user_fecConfirmacion;	//fecha confirmacion usuario

	@Embedded
	@Column
	//datos de pago y datos de direccion envio           
	private Direccion user_pago;

	@AttributeOverrides({
	    @AttributeOverride(name ="dir_nombre", column= @Column(name="dir_nombre_pago")),
	    @AttributeOverride(name ="dir_nombre", column= @Column(name="dir_nombre_envio")),
	});
}

