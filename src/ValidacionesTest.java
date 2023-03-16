/*Implemente en Junit  pruebas de caja negra de valores límite sobre la clase Validaciones. Se desea probar los siguientes métodos:
    • El método validarEdad. La edad debe estar entre  12 y 30 años inclusive.
    • El método validarContrasenna. La contraseña tiene que ser mayor a 5 caracteres.
Al menos uno  de los métodos debe usar pruebas parametrizadas:
(@ParameterizedTest @ValueSource)
Documentar en esta tabla los resultados del test:*/

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class ValidacionesTest {

	@ParameterizedTest
	@CsvSource({"1,false","9,false","31,false","20,false","12,false","14,true"})
	void test1(int num, boolean resultado) {
		assertEquals(resultado,Validaciones.validarEdad(num));
	}
	

	@ParameterizedTest
	@ValueSource(ints={1,6,31,12,17,27})
	void test2(int num) {
		assertEquals(false,Validaciones.validarEdad(num));
	}
	
	@ParameterizedTest
	@ValueSource(strings={"asd","eyweqiwuiq","ywegddgywgedgwgdgq","y","sgguidgaiugd","ytrua"})
	void  test3(String cadena) {
		assertEquals(true,Validaciones.validarContrasenna(cadena));
		
	}
	
	@Test
	void test4() {
		int num=4;
		assertEquals(false,Validaciones.validarEdad(num));
	}
	
	@Test
	void test5() {
		int num=34;
		assertEquals(false,Validaciones.validarEdad(num));
	}
	
	@Test
	void test6() {
		int num=24;
		assertEquals(true,Validaciones.validarEdad(num));
	}
	
	@Test
	void  test7() {
		String cadena="Yusuf";
		assertEquals(true,Validaciones.validarContrasenna(cadena));
		
	}
	
	@Test
	void  test8() {
		String cadena="Yf";
		assertEquals(false,Validaciones.validarContrasenna(cadena));
		
	}
	
	

}
