package model;
import java.util.ArrayList;
import java.util.List;

public class Materia {

	//Objeto Materia
	private String nome;
	private float pesoN1;
	private float pesoN2;
	private String codigo;
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public float getPesoN2() {
		return pesoN2;
	}
	public void setPesoN2(float pesoN2) {
		this.pesoN2 = pesoN2;
	}
	public float getPesoN1() {
		return pesoN1;
	}
	public void setPesoN1(float pesoN1) {
		this.pesoN1 = pesoN1;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	//ToString retorna o codigo da materia
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getCodigo();
	}
	
}
