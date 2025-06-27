package br.edu.ufam.icomp.lab_encapsulamento;

public class GISMain {

	public static void main(String[] args) {
		
		Celular c1 = new Celular(10,20,30);
		Celular c2 = new Celular(100,200,300);
		CarroLuxuoso carro1 = new CarroLuxuoso("ABC-1234");
		CarroLuxuoso carro2 = new CarroLuxuoso("XYZ-5678");
		
		Localizavel vet[] = {c1, c2, carro1,carro2};
		
		for(int i=0; i < vet.length; i++) {
			System.out.println(vet[i].getPosicao());
		}
	}

}
