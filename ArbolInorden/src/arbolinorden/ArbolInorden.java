/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolinorden;

/**
 *
 * @author Shebas
 */
import java.util.Scanner;
public class ArbolInorden {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner Tec = new Scanner(System.in);
        int nm;
        ArbolInorden arb = new ArbolInorden();
        
        do{
            System.out.println("Digite el valor del nodo y el numero 0 para terminas : ");
            nm = Tec.nextInt();
            if (nm != 0)   {
                arb.insertar(nm);
            }        
            
                }while(nm != 0);
                    System.out.println("el recorrido en INORDEN es : ");
        
        //arb.RecorridoEntre();
    }
    
    class Nodo{
      int info;
      Nodo izq, der;
        
    }
    
    Nodo raiz;
    
    public ArbolInorden(){
            raiz =null;
    }
    
    public void insertar(int NuevoNodo){
                if(!existe(NuevoNodo) ){
                    Nodo nuevo;
                    nuevo = new Nodo();
                    nuevo.info = NuevoNodo;
                    nuevo.izq = null;
                    nuevo.der = null;
                    if(raiz == null){
                        raiz =nuevo;
                    }else{
                    
                    Nodo anterior = null,reco;
                    reco = raiz;
                    while (reco != null){
                            anterior = reco;
                            if (NuevoNodo < reco.info){
                                reco = reco.izq;
                            } else{
                                reco = reco.der;
                            }
                       
                        }
                            if (NuevoNodo < anterior.info){
                                anterior.izq = nuevo;
                            }else{
                            
                                anterior.der =nuevo;
                            }
                    }
                }
    }
}
