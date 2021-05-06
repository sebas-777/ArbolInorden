package grafooamplitud;

//En esta clase se define el nodocola: 
public class NodoColaG { 
    int dato;
// Constructor 
    NodoColaG (int elemento, NodoColaG n) { 
        dato = elemento; 
        siguiente = n; 
    } 
// Atributos accesibles desde otras rutinas del paquete int dato; 
    NodoColaG siguiente; 
}
