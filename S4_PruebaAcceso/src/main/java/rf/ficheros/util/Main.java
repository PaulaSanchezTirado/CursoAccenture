package rf.ficheros.util;

import java.util.List;

import rf.ficheros.controller.CountryController;
import rf.ficheros.modelos.Country;

public class Main {

	public static void main(String[] args) throws Exception {
		
		CountryController countryControl = new CountryController();
		List<Country> listCountry = countryControl.leerTodos();
		listarCtr(listCountry);
		System.out.println("------------------------------------------------------------------");
		System.out.println(countryControl.leerUno("BR"));
		System.out.println("------------------------------------------------------------------");
		Country country = countryControl.leerUno("BR");
		country.setCountry_id("BR");
		country.setCountry_name("El nombre ha variado");
		country.setRegion_id("69");
		countryControl.actualizar(country);
		System.out.println(countryControl.leerUno("BR"));
		System.out.println("------------------------------------------------------------------");
		Country countryDelete = countryControl.leerUno("BR");
		System.out.println(countryControl.delete(countryDelete));
		
	}
	
	public static void listarCtr(List<Country> ctr) {
		ctr.stream().forEach(System.out::println);
	}

}
