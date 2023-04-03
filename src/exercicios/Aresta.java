package exercicios;

import lombok.*;

@Data
@AllArgsConstructor
public class Aresta {
	private Vertice origem;
	private Vertice destino;


	public String toString(){
		return "("+ origem + "," + destino + ")";
	}

}
