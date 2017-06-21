package util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Util {

	/**
	 * Genera un archivo de texto con caracteres aleatorios.
	 * 
	 * @param nLineas cantidad de lineas de caracteres aleatorios en el fichero de texto
	 * @param opcion para elegir entre las diferentes probabilidades
	 * @return un string con la ruta del archivo de texto
	 */
	public static String generaPortadora(int nLineas, int opcion, String ruta) {
		
		HashMap<String, Double> caracteres = new HashMap<String, Double>();
		
		caracteres.put("a", 12.53);
		caracteres.put("b", 1.42);
		caracteres.put("c", 4.68);
		caracteres.put("d", 5.86);
		caracteres.put("e", 13.68);
		caracteres.put("f", 0.69);
		caracteres.put("g", 1.01);
		caracteres.put("h", 0.7);
		caracteres.put("i", 6.25);
		caracteres.put("j", 0.44);
		caracteres.put("k", 0.01);
		caracteres.put("l", 4.97);
		caracteres.put("m", 3.15);
		caracteres.put("n", 6.71);
		caracteres.put("ñ", 0.31);
		caracteres.put("o", 8.68);
		caracteres.put("p", 2.51);
		caracteres.put("q", 0.88);
		caracteres.put("r", 6.87);
		caracteres.put("s", 7.98);
		caracteres.put("t", 4.63);
		caracteres.put("u", 3.93);
		caracteres.put("v", 0.9);
		caracteres.put("w", 0.02);
		caracteres.put("x", 0.22);
		caracteres.put("y", 0.9);
		caracteres.put("z", 0.52);
		
		String rutaFinal;
		if (ruta.endsWith("\\")) {
			rutaFinal = ruta+"portadora.txt";
		} else {
			rutaFinal = "error";
		}
		
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(rutaFinal));
		
			String linea = "";
			double caracteresRandom;
			boolean salir = false;
			
			for (int i = 0; i < nLineas; i++) {
				linea = "";
				salir = false;
				for (int j = 0; j < 80 && !salir; j++) {
					switch (opcion) {
					case 0:
						switch ((int)(Math.random()*10)) {
						case 0:
						case 1:
						case 2:
						case 3:
						case 4:
						case 5:
						case 6:
							caracteresRandom = Math.random()*100;
							for (Map.Entry caracter : caracteres.entrySet()) {
								caracteresRandom -= (double)caracter.getValue();
								if (caracteresRandom <= 0.0d) {
									linea += caracter.getKey();
									break;
								}
							}
							break;
						case 7:
							linea += " ";
							break;
						case 8:
							linea += "\r\n";
							i++;
							salir = true;
							break;
						case 9:
							switch ((int)(Math.random()*4)) {
							case 0:
								linea += ",";
								break;
							case 1:
								linea += ".";
								break;
							case 2:
								linea += ";";
								break;
							case 3:
								linea += ":";
								break;
							default:
							}
							break;
						default:
						}
						break;
					case 1:
						switch ((int)(Math.random()*5)) {
						case 0:
						case 1:
							caracteresRandom = Math.random()*100;
							for (Map.Entry caracter : caracteres.entrySet()) {
								caracteresRandom -= (double)caracter.getValue();
								if (caracteresRandom <= 0.0d) {
									linea += caracter.getKey();
									break;
								}
							}
							break;
						case 2:
							linea += " ";
							break;
						case 3:
							linea += "\r\n";
							i++;
							salir = true;
							break;
						case 4:
							switch ((int)(Math.random()*4)) {
							case 0:
								linea += ",";
								break;
							case 1:
								linea += ".";
								break;
							case 2:
								linea += ";";
								break;
							case 3:
								linea += ":";
								break;
							default:
							}
							break;
						default:
						}
						break;
					case 2:
						switch ((int)(Math.random()*4)) {
						case 0:
							caracteresRandom = Math.random()*100;
							for (Map.Entry caracter : caracteres.entrySet()) {
								caracteresRandom -= (double)caracter.getValue();
								if (caracteresRandom <= 0.0d) {
									linea += caracter.getKey();
									break;
								}
							}
							break;
						case 1:
							linea += " ";
							break;
						case 2:
							linea += "\r\n";
							i++;
							salir = true;
							break;
						case 3:
							switch ((int)(Math.random()*4)) {
							case 0:
								linea += ",";
								break;
							case 1:
								linea += ".";
								break;
							case 2:
								linea += ";";
								break;
							case 3:
								linea += ":";
								break;
							default:
							}
							break;
						default:
						}
						break;
					case 3:
						switch ((int)(Math.random()*7)) {
						case 0:
						case 1:
						case 2:
						case 3:
						case 4:
							caracteresRandom = Math.random()*100;
							for (Map.Entry caracter : caracteres.entrySet()) {
								caracteresRandom -= (double)caracter.getValue();
								if (caracteresRandom <= 0.0d) {
									linea += caracter.getKey();
									break;
								}
							}
							break;
						case 5:
							linea += " ";
							break;
						case 6:
							switch ((int)(Math.random()*2)) {
							case 0:
								linea += ",";
								break;
							case 1:
								linea += ".";
								break;
							default:
							}
							break;
						default:
						}
						break;
					default:
					}
				}
				if (!salir) {
					bw.write(linea+"\r\n");
				} else {
					bw.write(linea);
				}
			}
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rutaFinal;
	}
	
	/**
	 * Genera un archivo de texto con caracteres y números aleatorios.
	 * 
	 * @param nLineas cantidad de lineas de caracteres aleatorios en el fichero de texto
	 * @param opcion para elegir entre las diferentes probabilidades
	 * @return un string con la ruta del archivo de texto
	 */
	public static String generaPortadoraLn(int nLineas, int opcion, String ruta) {
		
		String[] letrasNumeros = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","ñ","o","p","q","r","s","t","v",
				"w","x","y","z","0","1","2","3","4","5","6","7","8","9"};
		
		String rutaFinal;
		if (ruta.endsWith("\\")) {
			rutaFinal = ruta+"portadora.txt";
		} else {
			rutaFinal = "error";
		}
		
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(rutaFinal));
			
			String linea = "";
			int caracterAleatorio;
			boolean salir = false;
			
			for (int i = 0; i < nLineas; i++) {
				linea = "";
				salir = false;
				for (int j = 0; j < 80 && !salir; j++) {
					switch (opcion) {
					case 0:
						switch ((int)(Math.random()*10)) {
						case 0:
						case 1:
						case 2:
						case 3:
						case 4:
						case 5:
						case 6:
							caracterAleatorio = (int)(Math.random()*36);
							linea += letrasNumeros[caracterAleatorio];
							break;
						case 7:
							linea += " ";
							break;
						case 8:
							linea += "\r\n";
							i++;
							salir = true;
							break;
						case 9:
							switch ((int)(Math.random()*4)) {
							case 0:
								linea += ",";
								break;
							case 1:
								linea += ".";
								break;
							case 2:
								linea += ";";
								break;
							case 3:
								linea += ":";
								break;
							default:
							}
							break;
						default:
						}
						break;
					case 1:
						switch ((int)(Math.random()*5)) {
						case 0:
						case 1:
							caracterAleatorio = (int)(Math.random()*36);
							linea += letrasNumeros[caracterAleatorio];
							break;
						case 2:
							linea += " ";
							break;
						case 3:
							linea += "\r\n";
							i++;
							salir = true;
							break;
						case 4:
							switch ((int)(Math.random()*4)) {
							case 0:
								linea += ",";
								break;
							case 1:
								linea += ".";
								break;
							case 2:
								linea += ";";
								break;
							case 3:
								linea += ":";
								break;
							default:
							}
							break;
						default:
						}
						break;
					case 2:
						switch ((int)(Math.random()*4)) {
						case 0:
							caracterAleatorio = (int)(Math.random()*36);
							linea += letrasNumeros[caracterAleatorio];
							break;
						case 1:
							linea += " ";
							break;
						case 2:
							linea += "\r\n";
							i++;
							salir = true;
							break;
						case 3:
							switch ((int)(Math.random()*4)) {
							case 0:
								linea += ",";
								break;
							case 1:
								linea += ".";
								break;
							case 2:
								linea += ";";
								break;
							case 3:
								linea += ":";
								break;
							default:
							}
							break;
						default:
						}
						break;
					case 3:
						switch ((int)(Math.random()*7)) {
						case 0:
						case 1:
						case 2:
						case 3:
						case 4:
							caracterAleatorio = (int)(Math.random()*36);
							linea += letrasNumeros[caracterAleatorio];
							break;
						case 5:
							linea += " ";
							break;
						case 6:
							switch ((int)(Math.random()*2)) {
							case 0:
								linea += ",";
								break;
							case 1:
								linea += ".";
								break;
							default:
							}
							break;
						default:
						}
						break;
					default:
					}
				}
				if (!salir) {
					bw.write(linea+"\r\n");
				} else {
					bw.write(linea);
				}
			}
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rutaFinal;
	}
}
