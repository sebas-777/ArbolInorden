
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
                    arb.recorreEnOrden();
                     System.out.println("el recorrido en PREORDEN es : ");
                    arb.recorreEnPreOrden();
                     System.out.println("el recorrido en POSORDEN es : ");
                    arb.recorreEnPosOrden();
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
    
    // metodo para encontrar duplicados 
    
    public boolean existe( int NuevoNodo){
     Nodo reco =raiz;
     while (reco != null){ 
            if (NuevoNodo == reco.info){
                    return true;
            } else {
                  if (NuevoNodo  > reco.info)
                      reco = reco.der;
                  else
                      reco = reco.izq;
                 }
        } 
     
        return false;
    
         }
         
    private void recorreEnOrden(Nodo reco){
                  if(reco !=null){
                  recorreEnOrden(reco.izq);
                      System.out.println(reco.info + "  ");
                  recorreEnOrden(reco.der);
                  }
    }
    
    public void recorreEnOrden(){
    
                  recorreEnOrden(raiz);
                  System.out.println();
    }

     private void recorreEnPreOrden(Nodo reco){
                  if(reco !=null){ 
                   System.out.println(reco.info + "  ");
                  recorreEnPreOrden(reco.izq);
                  recorreEnPreOrden(reco.der);
                  }
    }
    
    public void recorreEnPreOrden(){
    
                  recorreEnPreOrden(raiz);
                  System.out.println();
    }
    
     private void recorreEnPosOrden(Nodo reco){
                  if(reco !=null){ 
                   recorreEnPosOrden(reco.izq);
                  recorreEnPosOrden(reco.der);
                  System.out.println(reco.info + "  ");
                  }
    }
    
    public void recorreEnPosOrden(){
    
                  recorreEnPosOrden(raiz);
                  System.out.println();
    }
}  
// 24 45 22 32 16 65 12 18 0