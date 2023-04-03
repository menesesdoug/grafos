package exercicios;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Vertice {
	private String nome;

	public String toString(){
		return nome;
	}
}
