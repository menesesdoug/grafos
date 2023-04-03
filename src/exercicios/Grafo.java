package exercicios;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class Grafo {
	private ArrayList<Vertice> vertices;
	private ArrayList<Aresta> arestas;
	private boolean isDigrafo;
	private int ordem;
	private int tamanho;

	public Grafo(boolean isDigrafo) {
		vertices = new ArrayList<>();
		arestas = new ArrayList<>();
		this.isDigrafo = isDigrafo;
	}

	public Grafo() {
		vertices = new ArrayList<>();
		arestas = new ArrayList<>();
	}

	public void addVertice(Vertice vertice){
		vertices.add(vertice);
		ordem++;
	}
	public void addAresta(Aresta aresta){
		arestas.add(aresta);
		tamanho++;
		if (isDigrafo){
			aresta.getOrigem().setGrauOut(aresta.getOrigem().getGrauOut() + 1);
			aresta.getDestino().setGrauIn(aresta.getDestino().getGrauIn() + 1);
		} else {
			aresta.getOrigem().setGrau(aresta.getOrigem().getGrau() + 1);
			aresta.getDestino().setGrau(aresta.getDestino().getGrau() + 1);
		}
	}
	public boolean descobreSeDigrafo(){
		for (Aresta a : arestas){ //for-each
			if (a.getOrigem() == a.getDestino()) {
				System.out.println("É Digrafo");
				isDigrafo = true;
				return true;
			}
			for (Aresta b : arestas){
				if (a != b && a.getOrigem() == b.getDestino() && a.getDestino() == b.getOrigem()) {
						System.out.println("É digrafo");
						isDigrafo = true;
						return true;
					}
			}
		}
		return false;
	}
	public String toString(){
		StringBuilder infoGrafo = new StringBuilder();

		if (isDigrafo){
			infoGrafo.append("Dígrafo -> Vértices:\n");
			for (Vertice vertice : vertices){
				infoGrafo
						.append("\n")
						.append(vertice.getNome())
						.append(" (grauIn: ")
						.append(vertice.getGrauIn())
						.append(", grauOut: ")
						.append(vertice.getGrauOut())
						.append(")");
			}
		} else {
			infoGrafo.append("Grafo Ñ direcionado -> Vértices:\n");
			infoGrafo.append(vertices.stream()
					.map(vertice -> "\n" + vertice.getNome() + " (grau: " + vertice.getGrau() + ")")
					.collect(Collectors.joining()));
		}
		infoGrafo.append("\n\nArestas: ").append(arestas);
		return infoGrafo.toString();
	}

	public List<Vertice> obtemAdjacencias(Vertice vertice){
		ArrayList<Vertice> adjacencias = new ArrayList<>();
			for (Aresta aresta: arestas){
				if (aresta.getDestino() == vertice && !adjacencias.contains(aresta.getOrigem()))
					adjacencias.add(aresta.getOrigem());
				if (!isDigrafo && aresta.getOrigem() == vertice && !adjacencias.contains(aresta.getDestino()))
					adjacencias.add(aresta.getDestino());
			}
		return adjacencias;
	}
}
