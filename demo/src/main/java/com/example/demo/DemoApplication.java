package com.example.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		// creacion lista con tallas de calcetines
		List<String> listCacetin = new ArrayList<>();
		listCacetin.add("9");
		listCacetin.add("10");
		listCacetin.add("20");
		listCacetin.add("20");
		listCacetin.add("10");
		listCacetin.add("10");
		listCacetin.add("30");
		listCacetin.add("50");
		listCacetin.add("10");
		listCacetin.add("20");

		System.out.println("Ejercicion numero 1");
		System.out.println("El numero de pares es: " + comercianteCalceltines(listCacetin));
		System.out.println("=============================================================");

		List<String> listNumeros = new ArrayList<>();
		listNumeros.add("1");
		listNumeros.add("3");
		listNumeros.add("5");
		listNumeros.add("7");
		listNumeros.add("9");
		System.out.println("Ejercicion numero 2");
		System.out.println("suma minima - suma maxima : "+sumaNumeros(listNumeros));
		System.out.println("=============================================================");

		List<String> listVelas = new ArrayList<>();
		listVelas.add("3");
		listVelas.add("2");
		listVelas.add("1");
		listVelas.add("3");
		System.out.println("Ejercicion numero 3");
		System.out.println("El numero de vealas apagadas es: " + velasCumpleanos(listVelas));
		System.out.println("=============================================================");

	}

//	entrada:
//		calcetines: lista con tallas de calcetines
//	metodo para contar catidad de pares de calcetin
	public static int comercianteCalceltines(List<String> calcetines) {
		Map<String, Integer> cuentaPares = new HashMap<String, Integer>();
		for (String calcetin : calcetines) {
			if (cuentaPares.containsKey(calcetin)) {
				cuentaPares.put(calcetin, cuentaPares.get(calcetin) + 1);
			} else {
				cuentaPares.put(calcetin, 1);
			}

		}

		return contarPares(cuentaPares);
	}

//	Entrada :
//		calcetines: map numero de calcetil y cantidad por talla
//	
//	Salida
//		numPares:suma de todos los pares
//	
//	recibe arreglo de calcetines por talla y cantidad
//	y se suma la cantidad de pares por cada talla hasta optener la cantidad total de pares
// nota: para proximos cambios ya que estos estan ordenados por cantidad y talla se podria sacar la cantidad de pares por talla
	public static int contarPares(Map<String, Integer> calcetines) {
		int numPares = 0;
		for (Map.Entry<String, Integer> calcetin : calcetines.entrySet()) {
			if (calcetin.getValue() > 1) {
				numPares += calcetin.getValue() / 2;
			}

		}
		return numPares;
	}

//	entrada:
//		numeros: lista con numeros
//
//	salida:
//		sumatoria de todos los valores menos el mayor  y sumatoria de todos los valores menos el menor
//	
//	metodo para sumar lista ordenada omitiendo primer valor para suma maxima y ultimo valor para suma minima 
	public static String sumaNumeros(List<String> numeros) {
		Collections.sort(numeros);
		
		obtenerMayor(numeros);
		obtenerMenor(numeros);
		
		return  obtenerMenor(numeros)+ " - " +obtenerMayor(numeros) ;
	}

//metodo para sumar lista ordenada omitiendo primer valor para suma maxima 

	public static String obtenerMayor(List<String> numeros) {
		int sumatoria = 0 ;
		for(int i = 1; i < numeros.size(); i++) {
			sumatoria +=	Integer.parseInt(numeros.get(i)) ;
		}
		
		return Integer.toString(sumatoria);
	}
	
//	metodo para sumar lista ordenada omitiendo ultimo valor para suma minima 

	public static String obtenerMenor(List<String> numeros) {
		int sumatoria = 0 ;
		for(int i = 0; i < numeros.size()-1; i++) {
			sumatoria +=	Integer.parseInt(numeros.get(i)) ;
		}
		return Integer.toString(sumatoria);
	}

//	entrada:
//		velas: lista con velas
//	
//	salida:
//		respuesta del metodo contarVelas
//		
//	metodo para contar catidad de velas por nivel
	public static int velasCumpleanos(List<String> velas) {
		Map<String, Integer> cuentaPares = new TreeMap<String, Integer>();
		for (String vela : velas) {
			if (cuentaPares.containsKey(vela)) {
				cuentaPares.put(vela, cuentaPares.get(vela) + 1);
			} else {
				cuentaPares.put(vela, 1);
			}

		}

		return contarVelas(cuentaPares);
	}

//	Entrada :
//		velas: map ordenado con numero de velas y cantidad por tama??o
//
//	Salida
//		numvelas: retorna la catidad de velas de mayor tama??o
//
//	recibe arreglo ordenado de velas tama??o y cantidad
//	guarda en numvelas el valor hasta llegar a la ultima posicion del map (posicion con la vela de mayor tama??o)
	public static int contarVelas(Map<String, Integer> velas) {
		int numvelas = 0;
		for (Map.Entry<String, Integer> vela : velas.entrySet()) {
			numvelas = vela.getValue();
		}
		return numvelas;
	}
}
