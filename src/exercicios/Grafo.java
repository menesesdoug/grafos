package exercicios;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

@Data
@AllArgsConstructor
public class Grafo {
	private ArrayList<Vertice> vertices;
	private ArrayList<Aresta> arestas;

	public Grafo(){
		vertices = new ArrayList<>();
		arestas = new ArrayList<>();

	}
	public void addVertice(Vertice vertice){
		vertices.add(vertice);
	}
	public void addAresta(Aresta aresta){
		arestas.add(aresta);
	}
	public boolean isDigrafo(){
		for (Aresta a : arestas){ //for-each
			if (a.getOrigem() == a.getDestino()) {
				System.out.println("É Digrafo");
				return true;
			}
			for (Aresta b : arestas){
				if (a != b && a.getOrigem() == b.getDestino() && a.getDestino() == b.getOrigem()) {
						System.out.println("É digrafo");
						return true;
					}
			}
		}
		return false;
	}

}
