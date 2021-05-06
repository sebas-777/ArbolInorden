package grafooamplitud;

// Programa para crear u  grado y recorrerlo en amplitud y profundidad
//
import java.util.Scanner;

public class GrafoAmplitud {
	boolean dirigido; 
	int maxNodos;             
	int numVertices; 
	Lista listaAdy [ ]; 


public GrafoAmplitud (int n, boolean d) { 
   dirigido = d;	 
   maxNodos = n;
   numVertices = 0;
// Se crea un vector llamado listaAdy
   listaAdy = new Lista [n];
}
// Metodo para insertar vertices en un vector y crear las listas de adyacencia
// Se crea una lista por cada vertice
public void insertaVertice (int v) {
 if ( v > maxNodos - numVertices )
        System.out.println("Error, se supera el número de nodos máximo del grafo");
   else {
         for (int i = numVertices; i < numVertices + v; i++)
               listaAdy [i] = new Lista ();
   }
   numVertices += v;
}
// Metodo para insertar una arista
public void insertaArista (int i, int j) {
if ( i >= numVertices )
    	System.out.println ("Error, no existe el vértice en el grafo");
else {
		listaAdy [i].insertar (j);
		if (!dirigido)
	   		listaAdy [j].insertar (i);
}
}

// Imprimir un grafo
public void imprimirGrafo () {
   System.out.println ("Tamaño máximo del grafo: " + maxNodos + "\n");
   System.out.println ("El grafo contiene " + numVertices + " vértices: \n");
   for (int i = 0; i < numVertices; i++) {
         System.out.print ("vértice " + i + ": ");
         escribir (listaAdy [i]);
         }
}
static void escribir (Lista lista) { 
    NodoLista aux; 
    aux = lista.inicio; 
    while (aux != null) { 
        System.out.print (aux.clave +", "); 
        aux = aux.sig;
    } 
    System.out.println ("FIN"); 
}
public int [] encontrarAdy (GrafoAmplitud g, int origen, Lista lista) { 
    int vecady [] = new int [g.numVertices];
    NodoLista aux; 
    aux = lista.inicio; 
    int k=0;
    while (aux != null) { 
         
        vecady [k]= aux.clave;
        k++;
        aux = aux.sig;
    } 
    return vecady;
}

// Devuelve true si existe una arista que una los vértices i y j.
public  boolean existeArista(int v, int i){
if (listaAdy[v].buscar(i))
    return true;
else
return false;
} 
public void amplitud (GrafoAmplitud g) { 
// Se crea un objeto de la clase TadCola
    ColaG cola = new ColaG();
    boolean visitados [ ] = new boolean [g.numVertices];
    int v; //vértice actual 
//Se inicializa el vector visitados [] con false 
    for (int i = 0; i < g.numVertices; i++) 
         visitados [i] = false; 
//El recorrido en amplitud se inicia en cada vértice no visitado 
    for (int i = 0; i < g.numVertices; i++) { 
//se pone en la cola el vértice de partida y se marca como visitado 
    if (!visitados [i]){ 
    cola.encolar (i);
    visitados [i] = true; 
while (!cola.colaVacia()) { 
    v = cola.desencolar ();
//desencolar y tratar el vértice 
    System.out.println (v); 
//Encolo los nodos adyacentes a v. 
for (int j = 0; j < g.numVertices; j++){ 
    if ((v !=j) && (g.existeArista (v, j) && (!visitados [j]))) { 
        cola.encolar ( j ); 
        visitados [j] = true; 
    } 
}
} 
} 
} 
} 

// Programa Principal 
public static void main (String[] args) { 
        int   i1;
        int j1;
        int max;
        int vert;
        boolean dir;
        dir = true;
        
    Scanner Tec = new Scanner(System.in);
    
    System.out.print ("Número máximo de nodos del  grafo): ");
    max = Tec.nextInt();
    System.out.print ("Número de vertices): ");
    vert  = Tec.nextInt();
    GrafoAmplitud g = new GrafoAmplitud(max,dir); 
    g.insertaVertice(vert);

// Se crea grafo con las aristas
do {
    System.out.print ("Nodo origen de la arista  (99 -> Fin): ");
    i1 = Tec.nextInt();
    System.out.print ("Nodo destino de la arista  (99 -> Fin): ");
    j1 = Tec.nextInt();
    if (i1 != 99)
    {
          g.insertaArista(i1,j1); 
             } 
}while(i1 != 99);
        System.out.println ("Imprimir grafo vertices y adyacencias ");
        g.imprimirGrafo ();
        System.out.println ("Recorrido en Amplitud ");
        g.amplitud(g);
       
}
}
