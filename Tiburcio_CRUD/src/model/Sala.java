package model;
import java.util.ArrayList;
import java.util.List;

public class Sala {
	
	//Objeto Sala
	private int num;
	private String escola;
	
	
	public String getEscola() {
		return escola;
	}
	public void setEscola(String escola) {
		this.escola = escola;
	}
	public int getnum() {
		return num;
	}
	public void setnum(int sala) {
		num = sala;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return  String.valueOf(getnum());
	}
	
}
