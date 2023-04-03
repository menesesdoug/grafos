package exercicios;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Vertice {
	private String nome;
	private int grau;
	private int grauIn;
	private int grauOut;

	public Vertice(String nome){
		this.nome = nome;
	}

	public String toString(){
		return nome + " (grau: " + grau + ")";
	}
}
