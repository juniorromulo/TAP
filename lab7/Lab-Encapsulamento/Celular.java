package br.edu.ufam.icomp.lab_encapsulamento;
import java.util.*;

public class Celular implements Localizavel {
	private int codPais, codArea, numero;
	
	public Celular(int codPais, int codArea, int numero) {
		if(codPais<1 || codPais > 1999) {
			this.codPais = -1;
			
		}
		else {
			this.codPais = codPais;
		}
		
		if(codArea < 10 || codArea > 99) {
			this.codArea = -1;
		}
		else {
			this.codArea = codArea;
		}
		
		if(numero < 10000000 || numero > 999999999 ) {
			this.numero = -1;
		}
		else {
			this.numero = numero;
		}
	}
	
	public final void setCodPais(int codPais){
		if(codPais<1 || codPais > 1999) {
			this.codPais = -1;
			
		}
		else {
			this.codPais = codPais;
		}
		
	}
	
	public int getCodPais() {
		return this.codPais;
	}
	
	public final void setCodArea(int codArea) {
		if(codArea < 10 || codArea > 99) {
			this.codArea = -1;
		}
		else {
			this.codArea = codArea;
		}
	}
	
	public int getCodArea() {
		return this.codArea;
	}
	
	public final void setNumero(int numero) {
		if(numero < 10000000 || numero > 999999999 ) {
			this.numero = -1;
		}
		else {
			this.numero = numero;
		}
	}
	
	public int getNumero() {
		return this.numero;
	}
	
	public Posicao getPosicao() {
		Random r = new Random();
		double latitude = -3.160000 + (( -2.960000) - (-3.160000)) * r.nextDouble();
		double longitude = -60.120000 + ((-59.820000) - (-60.120000)) * r.nextDouble();	
		double altitude = 15.0 + (100.0 - 15.0) * r.nextDouble();
		
		Posicao posAtual = new Posicao(latitude, longitude, altitude);
		
		return posAtual;
	}
	
	public double getErroLocalizacao() {
		return 50.0;
	}
	
}
