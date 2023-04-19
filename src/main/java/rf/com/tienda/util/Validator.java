package rf.com.tienda.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
	
	private static final String ALFANUMERIC_PATTERN = "^[0-9a-zA-Z]+$";
	
	private static final String PASSWORD_PATTERN = 
            "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";
	/**
	 * Patr�n para validar el email, evitando puntos finales antes de la @ y que solo contenga
	 * car�cteres alfanum�ricos		 
	 */
	private final static String EMAIL_PATTERN = 
			"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		
	/**
	 * Permite verificar que un DNI cumple con el patr�n XX.XXX.XXX-L
	 */
	private final static String DNI_PATTERN = "^\\d{2}\\.\\d{3}\\.\\d{3}-[A-HJ-NP-TV-Z]$";
		
	/**
	 * Permite validar un tel�fono, el cual debe contener de 10 a 20 d�gitos
	 * y donde los espacios est�n permitidos
	 */
	private final static String PHONE_PATTERN =  "^[0-9]{9,20}$";
	
	/**
	 * Orden de las letras con las cuales se comprobar� la validez del DNI
	 */
	private final static String LETRA_DNI = "TRWAGMYFPDXBNJZSQVHLCKE";
	
	/**
	 * Longitud que debe tener todo DNI pasado a la aplicaci�n.
	 */
	private final static int LONGITUD_DNI = 12;

	public static boolean isAlfanumeric(String texto){
		Pattern miPattern = Pattern.compile(ALFANUMERIC_PATTERN);
		Matcher matcher = miPattern.matcher(texto);

		if (matcher.find()) {
			return true;
		}

		return false;
	}
	
	public static boolean isVacio( String prueba ){
		if (prueba.isEmpty()) {
			return true;
		}

		return false;
	}
	
	
	public static boolean cumplePhoneNumber(String phoneNumber){
		Pattern miPattern = Pattern.compile(PHONE_PATTERN);
		Matcher matcher = miPattern.matcher(phoneNumber);

		if (matcher.find()) {
			return true;
		}

		return false;
	}

	public static boolean isEmailValido(String email){
		Pattern miPattern = Pattern.compile(EMAIL_PATTERN);
		Matcher matcher = miPattern.matcher(email);

		if (matcher.find()) {
			return true;
		}

		return false;
	}

	public static boolean cumpleDNI(String dni){
		Pattern miPattern = Pattern.compile(DNI_PATTERN);
		Matcher matcher = miPattern.matcher(dni);

		if (matcher.find()) {
			return true;
		}

		return false;
		
	}
	
	
	public static boolean cumpleRango(
			int valor, 
			int valorMinimo,
			int valorMaximo){
		
		if(valor >= valorMinimo && valor <= valorMaximo) {
			return true;
		}
		
		return false;
		
	}
	
	public static boolean cumpleRango(
			double valor, 
			int valorMinimo,
			int valorMaximo){
		
		if(valor >= valorMinimo && valor <= valorMaximo) {
			return true;
		}
		
		return false;
		
	}

	public static boolean cumpleLongitudMin(
			String texto, 
			int longitudMinima){
		
		if(texto.length() >= longitudMinima) {
			return true;
		}
		
		return false;
	}


	public static boolean cumpleLongitudMax(
			String texto, 
			int longitudMaxima){

		if(texto.length() <= longitudMaxima) {
			return true;
		}
		
		return false;
		
	}


	public static boolean cumpleLongitud(
			String texto, 
			int longitudMinima, 
			int longitudMaxima){

		if(texto.length() >= longitudMinima && texto.length() <= longitudMaxima) {
			return true;
		}
		
		return false;
		

	}
	
	/**
	 * Valida una fecha calendar con m�nimo min
	 * @param fecha
	 * @param min
	 * @return
	 */
	public static boolean valDateMin(LocalDate fecha, LocalDate min){
		return fecha.compareTo(min) > 0;
		
	}
	
	/**
	 * Valida una fecha calendar con m�ximo max
	 * @param fecha
	 * @param max
	 * @return
	 */
	public static boolean valDateMax(LocalDate fecha, LocalDate max){
		return fecha.compareTo(max) < 0;
		
	}	
	
	/**
	 * esFechaValida
	 * Recibe una string con formato fecha dd/mm/aaaa y comprueba el formato
	 * @param fecha
	 * @return
	 */
	public static boolean esFechaValida(String fecha){
		
		try {
			LocalDate fechaValida = LocalDate.parse(fecha, DateTimeFormatter.ISO_DATE);
		}catch(DateTimeParseException e) {
			return false;
		}
		
		return true;
		
	}
	
	/**
	 * Nombre esPasswordValida
	 * Descripcion Comprueba que la cadena recibida cumpla con lasnormas de contrase�a
	 * @param password string con la contrase�a introducida
	 * @return true si cumple con las especificaciones
	 */
	public static boolean esPasswordValida(String password){
		Pattern miPattern = Pattern.compile(PASSWORD_PATTERN);
		Matcher matcher = miPattern.matcher(password);

		if (matcher.find()) {
			return true;
		}

		return false;

	}
}