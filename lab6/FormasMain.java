package br.edu.icomp.ufam.lab_heranca;
import java.util.ArrayList;

public class FormasMain {
	public static void main(String args[]) {
		Circulo circ = new Circulo(7,9,5);
		Retangulo retang = new Retangulo(10,4, 4,6);
		Quadrado quadrad = new Quadrado(1,1,3);
		
		ArrayList<FormaGeometrica> vetFormas = new ArrayList<FormaGeometrica>();
		vetFormas.add(circ);
		vetFormas.add(quadrad);
		vetFormas.add(retang);
		
		for(FormaGeometrica forma : vetFormas) {
			System.out.println(forma.toString() + "\n");
		}
		
	}
}
