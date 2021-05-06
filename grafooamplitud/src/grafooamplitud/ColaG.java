
package grafooamplitud;

public class ColaG { 
    NodoColaG principio; 
    NodoColaG fin;
    public ColaG () { 
        principio = null; 
        fin = null; 
    } 
   
    public void inicializarCola () {
        principio = null; 
        fin = null; } 
  
    public boolean colaVacia () { 
        return principio==null; 
    } 
    
    // Encolar un nodo o vertice adyacente
    public void encolar (int x)
    { NodoColaG aux = new NodoColaG(x,null); 
    if (principio == null) { 
        principio = aux; 
        fin = aux; 
    } else { 
        fin.siguiente = aux; 
        fin = aux; 
    } 
    } 
   
    // Desencolar un nodo o vertice adyacente
    public int desencolar () { 
        int resultado; 
        if (colaVacia ()) 
            System.out.println ("La cola esta vacia");
        resultado = principio.dato; 
        principio = principio.siguiente; 
        if (principio == null) 
            fin = null; 
        return resultado; 
    }    
}
