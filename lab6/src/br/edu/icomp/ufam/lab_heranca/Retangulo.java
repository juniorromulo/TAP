package br.edu.icomp.ufam.lab_heranca;

public class Retangulo extends FormaGeometrica{
	public double largura, altura;
	
	public Retangulo(int posX, int posY, double largura, double altura) {
		super(posX, posY);
		this.altura = altura;
		this.largura = largura;
	}
	
	public double getArea() {
		return this.largura * this.altura;
	}
	
	public double getPerimetro() {
		return 2 * (this.largura + this.altura);
	}
	
	public String toString() {
		return "Retângulo na " + getPosString() + " com largura de " + this.largura + "cm e altura de " + this.altura + "cm (área=" + getArea() + "cm2, perímetro=" + getPerimetro() + "cm)";
	}

}
