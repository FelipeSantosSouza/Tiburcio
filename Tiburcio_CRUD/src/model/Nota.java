package model;

public class Nota {

	
	//Objeto Nota
	private Aluno a;
	private Materia_Sala ms;
	private Materia m;
	private float n1;
	private float n2;
	private float media;
	
	public double getN1() {
		return n1;
	}
	public void setN1(float n1) {
		this.n1 = n1;
	}
	public double getN2() {
		return n2;
	}
	public void setN2(float n2) {
		this.n2 = n2;
	}
	public double getMedia() {
		return media;
	}
	public void setMedia(float media) {
		this.media = media;
	}
	public Aluno getA() {
		return a;
	}
	public void setA(Aluno a) {
		this.a = a;
	}
	public Materia getM() {
		return m;
	}
	public void setM(Materia m) {
		this.m = m;
	}
	public Materia_Sala getMs() {
		return ms;
	}
	public void setMs(Materia_Sala ms) {
		this.ms = ms;
	}
	
	
	
}
