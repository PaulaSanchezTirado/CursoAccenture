package rf.ficheros.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MontadorSQLTest {
	
	final String SALIDA = "Country_id = 'BR'";
	final String SALIDA_VACIA = "";
	final String NOMBRE_CAMPO = "Region_id";
	final String NOMBRE_CAMPO2 = "Country_id";
	final String VALOR_STRING = "BR";
	final String VALOR = "2";
	final int VALOR_INT = 2;
	final double VALOR_DOUBLE = 2.35;
	final long VALOR_LONG = 12345;
	final String SEPARADOR_COMA = ",";
	
	final String SALIDA_PRUEBA1 = "Country_id = 'BR', Region_id = '2'";
	final String SALIDA_PRUEBA2 = "Region_id = '2'";
	final String SALIDA_PRUEBA3 = "Country_id = 'BR', Region_id = 2";
	final String SALIDA_PRUEBA4 = "Country_id = 'BR', Region_id = 2.35";
	final String SALIDA_PRUEBA5 = "Country_id = 'BR', Region_id = 12345";
	final String SALIDA_PRUEBA6 = "Country_id = 'BR', Region_id = '2'";
	
	@Test
	void testAddSalidaStringStringStringString() {
		String salida = MontadorSQL.addSalida(SALIDA, NOMBRE_CAMPO, VALOR, SEPARADOR_COMA);
		assertEquals(salida.trim(), SALIDA_PRUEBA1.trim());
	}
	
	@Test
	void testAddSalidaStringStringStringString_SalidaVacia() {
		String salida = MontadorSQL.addSalida(SALIDA_VACIA, NOMBRE_CAMPO, VALOR, SEPARADOR_COMA);
		assertEquals(salida.trim(), SALIDA_PRUEBA2.trim());
	}
	
	@Test
	void testAddSalidaStringStringStringString_CONCAT() {
		String salida;
		salida = MontadorSQL.addSalida(SALIDA_VACIA, NOMBRE_CAMPO2, VALOR_STRING, SEPARADOR_COMA);
		salida = MontadorSQL.addSalida(salida, NOMBRE_CAMPO, VALOR, SEPARADOR_COMA);
		assertEquals(salida.trim(), SALIDA_PRUEBA6.trim());
	}
	
	@Test
	void testAddSalidaStringStringIntString() {
		String salida = MontadorSQL.addSalida(SALIDA, NOMBRE_CAMPO, VALOR_INT, SEPARADOR_COMA);
		assertEquals(salida.trim(), SALIDA_PRUEBA3.trim());
	}
	
	@Test
	void testAddSalidaStringStringDoubleString() {
		String salida = MontadorSQL.addSalida(SALIDA, NOMBRE_CAMPO, VALOR_DOUBLE, SEPARADOR_COMA);
		assertEquals(salida.trim(), SALIDA_PRUEBA4.trim());
	}
	
	@Test
	void testAddSalidaStringStringLongString() {
		String salida = MontadorSQL.addSalida(SALIDA, NOMBRE_CAMPO, VALOR_LONG, SEPARADOR_COMA);
		assertEquals(salida.trim(), SALIDA_PRUEBA5.trim());
	}

}
