package grafooamplitud;

public class Lista {
        public NodoLista inicio;
        
        public Lista() {
        inicio = null;
        }
// Buscar un Nodo o Vertice adyacente en la Lista
// Se utiliza un metodo recursivo que es buscar
public boolean buscar (int dato) {
    boolean resul= false;
    NodoLista aux; 
    aux = inicio; 
    while (aux != null) { 
         if (aux.clave == dato){
	     resul =true;
             return resul;
         }
         else {
             aux = aux.sig;
         }    
    } 
    return resul; 
}
public void insertar (int dato) {
    NodoLista nuevo, aux, anterior;
   
    aux = inicio; 
    if (aux == null){
	     nuevo = new NodoLista (dato, null);
             inicio = nuevo;
         }
    else {
    while (aux != null) {  
        anterior = aux;
         
         if (aux.clave == dato){
             System.out.println ("Error. Ese vertice ya existe");
             aux = null;
         }
         if (aux.clave > dato){
             nuevo = new NodoLista (dato, aux.sig);
             anterior.sig= nuevo;
             aux = null;
         }
         if (aux.clave < dato){
	     aux = aux.sig;
         }
         
    } 
    }
}
}
