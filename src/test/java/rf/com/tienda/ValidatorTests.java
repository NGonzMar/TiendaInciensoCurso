package rf.com.tienda;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;

import rf.com.tienda.util.Validator;

class ValidatorTest {

	@Test
	void testIsAlfanumeric() {
		assertAll (() -> 		assertTrue(Validator.isAlfanumeric("Prueba123")),
				() -> assertFalse(Validator.isAlfanumeric("Prueba con texto")),
				() -> assertFalse(Validator.isAlfanumeric("Pru!eba##"))
				);
		

		assertFalse(Validator.isAlfanumeric("Texto con espacios"));

		assertFalse(Validator.isAlfanumeric("Texto#ConCaracteres!Especiales"));
	}

	@Test
	void testIsEmpty() {
		assertAll (() -> assertTrue(Validator.isVacio("")),
				() -> assertFalse(Validator.isVacio("Texto de prueba"))
				);
		
	}

	@Test
	void testPhoneNumber() {
		assertAll (() -> assertTrue(Validator.cumplePhoneNumber("123456789")),
				() -> assertFalse(Validator.cumplePhoneNumber("123456789101112131415")),
				() -> assertFalse(Validator.cumplePhoneNumber("Prueba")),
				() -> assertFalse(Validator.cumplePhoneNumber("12345"))
				);
	}

	@Test
	void testIsValidEmail() {
		assertAll (() -> assertTrue(Validator.isEmailValido("prueba@prueba.com")),
				() -> assertFalse(Validator.isEmailValido("prueba")),
				() -> assertFalse(Validator.isEmailValido("prueba@")),
				() -> assertFalse(Validator.isEmailValido("Pruebaprueba.com")),
				() -> assertFalse(Validator.isEmailValido("Prueba.com"))
				);
	}

	@Test
	void testDNI() {
		assertAll (() -> assertTrue(Validator.cumpleDNI("11.123.123-L")),
				() -> assertFalse(Validator.cumpleDNI("1111111111L")),
				() -> assertFalse(Validator.cumpleDNI("123L")),
				() -> assertFalse(Validator.cumpleDNI("LLLLLLLLL"))
				);
	}

	@Test
	void testRangoIntIntInt() {
		assertAll (() -> assertTrue(Validator.cumpleRango(5, 1, 10)),
				() -> assertFalse(Validator.cumpleRango(1, 2, 3)),
				() -> assertFalse(Validator.cumpleRango(10, 4, 5))
				);
	}

	@Test
	void testRangoDoubleIntInt() {
		assertAll (() -> assertTrue(Validator.cumpleRango(5.5, 1, 10)),
				() -> assertFalse(Validator.cumpleRango(1.8, 2, 3)),
				() -> assertFalse(Validator.cumpleRango(10.23, 4, 5))
				);
	}

	@Test
	void testLenghtMin() {
		assertAll (() -> assertTrue(Validator.cumpleLongitudMin("Prueba", 5)),
				() -> assertFalse(Validator.cumpleLongitudMin("Prueba", 20))
				);
	}

	@Test
	void testLenghtMax() {
		assertAll (() -> assertTrue(Validator.cumpleLongitudMax("Prueba", 20)),
				() -> assertFalse(Validator.cumpleLongitudMax("Prueba", 3))
				);
	}

	@Test
	void testLenght() {
		assertAll (() -> assertTrue(Validator.cumpleLongitud("Prueba", 3, 10)),
				() -> assertFalse(Validator.cumpleLongitud("Prueba", 10, 20)),
				() -> assertFalse(Validator.cumpleLongitud("Prueba", 3, 4))
				);
	}

	@Test
	void testValDateMin() {
		
		assertAll (() -> assertTrue(Validator.valDateMin(LocalDate.parse("2023-04-12"), LocalDate.parse("2001-12-29"))),
				() -> assertFalse(Validator.valDateMin(LocalDate.parse("2001-12-29"), LocalDate.parse("2023-04-12")))
				);
		
	}

	@Test
	void testValDateMax() {
		
		assertAll (() -> assertTrue(Validator.valDateMax(LocalDate.parse("2023-04-12"), LocalDate.parse("2077-01-01"))),
				() -> assertFalse(Validator.valDateMax(LocalDate.parse("2023-04-12"), LocalDate.parse("2001-12-29")))
				);
		
	}

	@Test
	void testIsValidDate() {

		assertAll (() -> assertTrue(Validator.esFechaValida("2022-04-12")),
				() ->assertTrue(Validator.esFechaValida("2001-12-29")),
				() -> assertTrue(Validator.esFechaValida("2077-01-01")),
				() -> assertFalse(Validator.esFechaValida("12-04-2023")),
				() -> assertFalse(Validator.esFechaValida("2023/04/12")),
				() -> assertFalse(Validator.esFechaValida("2023-04-100")),
				() -> assertFalse(Validator.esFechaValida("2022-100-12")),
				() -> assertFalse(Validator.esFechaValida("100000-04-12"))
				);

	}

	@Test
	void testIsValidPassword() {
		assertAll (() -> assertTrue(Validator.esPasswordValida("Prueba1234#")),
				() -> assertFalse(Validator.esPasswordValida("prueba")),
				() -> assertFalse(Validator.esPasswordValida("Prueba1234")),
				() -> assertFalse(Validator.esPasswordValida("Prueba.")),
				() -> assertFalse(Validator.esPasswordValida("1234#")),
				() -> assertFalse(Validator.esPasswordValida("PruebasPruebas123456789.")),
				() -> assertFalse(Validator.esPasswordValida("Pr1."))
				);
	}

}
