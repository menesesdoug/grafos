package exercicios;

import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		Grafo g = new Grafo(false);
		Vertice v1 = new Vertice("1");
		Vertice v2 = new Vertice("2");
		Vertice v3 = new Vertice("3");
		g.addVertice(v1);
		g.addVertice(v2);
		g.addVertice(v3);
		Aresta a1 = new Aresta(v1,v2);
		Aresta a2 = new Aresta(v2,v1);
		Aresta a3 = new Aresta(v1,v3);
		g.addAresta(a1);
		g.addAresta(a2);
		g.addAresta(a3);

		System.out.println(g);
		System.out.println("Adjacências: " + g.obtemAdjacencias(v1).stream().map(Vertice::getNome).collect(Collectors.joining(", ")));

	}
}