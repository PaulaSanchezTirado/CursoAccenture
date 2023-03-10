package es.rf.tienda.util;

/**
 * Proyecto Tienda
 */

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ValidatorTest {
	
	/**
	 * Clase para validaciones de test
	 */
	
	final String NUMBER1 = "7483920 384758";
	final String NUMBER2 = "333";
	final String NUMBER3 = "867392045626248012345";
	final String NUMBER4 = "722636309 w";
	final String NUMBER5 = "";
	
	final int VALOR_MIN = 4;
	final int VALOR = 6;
	final int VALOR_MAX = 10;
	final double VALOR_MAL_INFERIOR = 2;
	final double VALOR_MAL_SUPERIOR = 11; 
	
	final String TEXTO1 = "12345678";
	final String TEXTO2 = "123";
	final String TEXTO3 = "12345678910";
	
	final LocalDate FECHA1 = LocalDate.of(2023, 02, 12);
	final LocalDate FECHA2 = LocalDate.of(2020, 02, 12);
	final LocalDate FECHA3 = LocalDate.now();
	
	final String FECHA_STRING_CORRECTA = "12/02/2023";
	final String FECHA_STRING_INCORRECTA1 = "12/12";
	final String FECHA_STRING_INCORRECTA2 = "02/2023";
	final String FECHA_STRING_INCORRECTA3 = "aa/bb/cc";
	final String FECHA_STRING_INCORRECTA4 = "12122023";
	final String FECHA_STRING_INCORRECTA5 = "12/12/23";
	final String FECHA_STRING_INCORRECTA6 = "12-12-2023";
	final String FECHA_STRING_INCORRECTA7 = "";
	
	final String PASSWORD_VALIDA = "letra1-A%";
	final String PASSWORD_INVALIDA1 = "23456";
	final String PASSWORD_INVALIDA2 = "stexto4%";
	final String PASSWORD_INVALIDA3 = "texto1-";
	final String PASSWORD_INVALIDA4 = "AAAAAAA%-";
	final String PASSWORD_INVALIDA5 = "";
	
	final String DNI_VALIDO = "77.391.895-T";
	final String DNI_INVALIDO1 =  "77391895-T";
	final String DNI_INVALIDO2 = "77.391.895T";
	final String DNI_INVALIDO3 = "77.391.895-A";
	final String DNI_INVALIDO4 = "";
	
	final String ALFANUMERICO1 = "2345.6";
	final String ALFANUMERICO2 = "srt tf4";
	final String ALFANUMERICO3 = "fjt??ri";
	final String ALFANUMERICO4 = "{{{";
	final String ALFANUMERICO5 = "--f";
	final String ALFANUMERICO6 = "??6";
	final String ALFANUMERICO7 = "";
	
	final String CORREO1 = "texto1@texto2.es";
	final String CORREO2 = "texto1@teXto2.com";
	final String CORREO3 = "texto1_texto2@texto3.com";
	final String CORREO4 = "tex@to1@texto2.es";
	final String CORREO5 = "texto1@texto2";
	final String CORREO6 = "-texto1@texto2.com";
	final String CORREO7 = "@texto2.com";
	final String CORREO8 = "t@t2.c";
	final String CORREO9 = "";
	
	final String CODIGO_VALIDO = "AJ088";
	final String CODIGO_INVALIDO1 = "A0P45";
	final String CODIGO_INVALIDO2 = "ab999";
	final String CODIGO_INVALIDO3 = "9LM66";
	final String CODIGO_INVALIDO4 = "";

	/**
	 * Comprueba que el texto introducido es alfanum??rico
	 * @param param
	 */
	@ParameterizedTest
	@ValueSource(strings = {ALFANUMERICO1, ALFANUMERICO2, ALFANUMERICO3})
	void testIsAlfanumericCorrecto(String param){
		assertTrue(Validator.isAlfanumeric(param));
	}
	
	/**
	 * Comprueba que el texto introducido no es alfanum??rico
	 * @param param
	 */
	@ParameterizedTest
	@ValueSource(strings = {ALFANUMERICO4, ALFANUMERICO5, ALFANUMERICO6, ALFANUMERICO7})
	void testIsAlfanumericIncorrecto(String param){
		assertFalse(Validator.isAlfanumeric(param));
	}
	
	/**
	 * Comprueba que el n??mero de tel??fono introducido es correcto
	 * @return 
	 */
	@Test
	public void testCumplePhoneNumberCorrecto() {
		assertTrue(Validator.cumplePhoneNumber(NUMBER1));
	}
	
	/**
	 * Comprueba que los n??meros de tel??fono introducidos no son correctos
	 * @param param
	 */
	@ParameterizedTest
	@ValueSource(strings = {NUMBER2, NUMBER3, NUMBER4, NUMBER5})
	void testCumplePhoneNumberIncorrecto(String param){
		assertFalse(Validator.cumplePhoneNumber(param));
	}
	
	/**
	 * Comprueba que los emails introducidos son correctos
	 * @param param
	 */
	@ParameterizedTest
	@ValueSource(strings = {CORREO1, CORREO2, CORREO3})
	void testIsEmailValidoCorrecto(String param) {
		assertTrue(Validator.isEmailValido(param));
	}
	
	/**
	 * Comprueba que el DNI introducido es correcto
	 */
	@Test
	public void testCumpleDNICorrecto() {
		assertTrue(Validator.cumpleDNI(DNI_VALIDO));
	}
	
	/**
	 * Comprueba que el DNI introducido no es correcto
	 * @param param
	 */
	@ParameterizedTest
	@ValueSource(strings = {DNI_INVALIDO1, DNI_INVALIDO2, DNI_INVALIDO3, DNI_INVALIDO4})
	void testCumpleDNIIncorrecto(String param) {
		assertFalse(Validator.cumpleDNI(param));
	}
	
	/**
	 * Comprueba que los emails introducidos no son correctos
	 * @param param
	 */
	@ParameterizedTest
	@ValueSource(strings = {CORREO4, CORREO5, CORREO6, CORREO7, CORREO8, CORREO9})
	void testIsEmailValidoInCorrecto(String param){
		assertFalse(Validator.cumplePhoneNumber(param));
	}
	
	/**
	 * Comprueba que el valor introducido se encuentra en el rango deseado
	 */
	@Test
	public void testCumpleRangoCorrecto() {
		assertTrue(Validator.cumpleRango(VALOR, VALOR_MIN, VALOR_MAX));
	}
	
	/**
	 * Comprueba que el valor introducido no se encuentra en el rango deseado siendo este menor
	 */
	@Test
	public void testCumpleRangoIncorrecto1(){
		assertFalse(Validator.cumpleRango(VALOR_MAL_INFERIOR,VALOR_MIN, VALOR_MAX));
	}
	
	/**
	 * Comprueba que el valor introducido no se encuentra en el rango deseado siendo este mayor
	 */
	@Test
	public void testCumpleRangoIncorrecto2(){
		assertFalse(Validator.cumpleRango(VALOR_MAL_SUPERIOR,VALOR_MIN, VALOR_MAX));
	}
	
	/**
	 * Comprueba que la longitud del texto introducido es mayor o igual que el valor deseado 
	 */
	@Test
	public void testCumpleLongitudMinCorrecta() {
		assertTrue(Validator.cumpleLongitudMin(TEXTO1, VALOR));
	}
	
	/**
	 * Comprueba que la longitud del texto introducido no es mayor o igual que el valor deseado siendo esta menor
	 */
	@Test
	public void testCumpleLongitudMinIncorrecta() {
		assertFalse(Validator.cumpleLongitudMin(TEXTO2, VALOR));
	}
	
	/**
	 * Comprueba que la longitud del texto introducido es menor o igual que el valor deseado
	 */
	@Test
	public void testCumpleLongitudMaxCorrecta() {
		assertTrue(Validator.cumpleLongitudMax(TEXTO2, VALOR));
	}
	
	/**
	 * Comprueba que la longitud del texto introducido no es menor o igual que el valor deseado siendo esta mayor
	 */
	@Test
	public void testCumpleLongitudMaxIncorrecta() {
		assertFalse(Validator.cumpleLongitudMax(TEXTO3, VALOR));
	}
	
	/**
	 * Comprueba que la longitud del texto introducido se encuentra entre los valores deseados
	 */
	@Test
	public void testCumpleLongitudCorrecta() {
		assertTrue(Validator.cumpleLongitud(TEXTO1, VALOR_MIN, VALOR_MAX));
	}
	
	/**
	 * Comprueba que la longitud del texto introducido no se encuentra entre los valores deseados siendo
	 * esta menor que el m??nimo
	 */
	@Test
	public void testCumpleLongitudIncorrecta1() {
		assertFalse(Validator.cumpleLongitud(TEXTO2, VALOR_MIN, VALOR_MAX));
	}
	
	/**
	 * Comprueba que la longitud del texto introducido no se encuentra entre los valores deseados siendo
	 * esta mayor que el m??ximo
	 */
	@Test
	public void testCumpleLongitudIncorrecta2() {
		assertFalse(Validator.cumpleLongitud(TEXTO3, VALOR_MIN, VALOR_MAX));
	}
	
	/**
	 * Comprueba que la fecha dada es como m??nimo la propuesta
	 */
	@Test
	public void testValDateMinCorrecto() {
		assertTrue(Validator.valDateMin(FECHA1, FECHA2));
		assertTrue(Validator.valDateMin(FECHA3, FECHA3));
	}
	
	/**
	 * Comprueba que la fecha dada es menor que la propuesta
	 */
	@Test
	public void testValDateMinIncorrecto() {
		assertFalse(Validator.valDateMin(FECHA2, FECHA1));
	}
	
	
	
	/**
	 * Comprueba que la fecha dada es como m??ximo la propuesta
	 */
	@Test
	public void testValDateMaxCorrecto() {
		assertTrue(Validator.valDateMax(FECHA2, FECHA1));
		assertTrue(Validator.valDateMin(FECHA3, FECHA3));
	}
	
	/**
	 * Comprueba que la fecha dada es mayor que la propuesta como m??xima
	 */
	@Test
	public void testValDateMaxIncorrecto() {
		assertFalse(Validator.valDateMax(FECHA1, FECHA2));
	}
	
	/**
	 * Comprueba que la fecha dada es igual a la actual
	 */
	@Test
	public void testValDateEqual() {
		assertTrue(Validator.valDateEqual(FECHA3, FECHA3));
	}
	
	/**
	 * Comprueba que la fecha dada no es igual a la actual
	 */
	@Test
	public void testValDateEqualIncorrecta() {
		assertFalse(Validator.valDateEqual(FECHA3, FECHA2));
	}
	
	/**
	 * Comprueba que la fecha introducida tiene el formato correcto
	 */
	@Test
	public void testEsFechaValidaCorrecta() {
		assertTrue(Validator.esFechaValida(FECHA_STRING_CORRECTA));
	}
	
	/**
	 * Comprueba que la fecha introducida no tiene el formato correcto
	 * @param param
	 */
	@ParameterizedTest
	@ValueSource(strings = {FECHA_STRING_INCORRECTA1, FECHA_STRING_INCORRECTA2, FECHA_STRING_INCORRECTA3, FECHA_STRING_INCORRECTA4,
			FECHA_STRING_INCORRECTA5, FECHA_STRING_INCORRECTA6, FECHA_STRING_INCORRECTA7})
	void testEsFechaValidaIncorrecta(String param){
		assertFalse(Validator.esFechaValida(param));
	}
	
	/**
	 * Comprueba que la contrase??a es correcta (n??meros, letras may??culas y min??sculas y caracteres especiales)
	 */
	@Test
	public void testEsPasswordValidaCorrecta() {
		assertTrue(Validator.esPasswordValida(PASSWORD_VALIDA));
	}
	
	/**
	 * Comprueba que la contrase??a no es correcta
	 * @param param
	 */
	@ParameterizedTest
	@ValueSource(strings = {PASSWORD_INVALIDA1, PASSWORD_INVALIDA2, PASSWORD_INVALIDA3, PASSWORD_INVALIDA4, PASSWORD_INVALIDA5})
	void testEsPasswordValidaIncorrecta(String param){
		assertFalse(Validator.esPasswordValida(param));
	}
	
	/**
	 * Comprueba que el c??digo del producto sea correcto
	 */
	
	@Test
	public void testCodigoProductoValidoCorrecto() {
		assertTrue(Validator.codigoProductoValido(CODIGO_VALIDO));
	}
	
	/**
	 * Comprueba que c??digos introducidos no son correctos
	 * @param param
	 */
	@ParameterizedTest
	@ValueSource(strings = {CODIGO_INVALIDO1, CODIGO_INVALIDO2, CODIGO_INVALIDO3, CODIGO_INVALIDO4})
	void testCodigoProductoValidoIncorrecto(String param){
		assertFalse(Validator.codigoProductoValido(param));
	}
}
