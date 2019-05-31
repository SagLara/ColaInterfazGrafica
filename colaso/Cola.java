
package colaso;

/**
 *
 * @author USUARIO
 */
public class Cola extends Nodo{
    public Cola(){
        raiz=null;
        fondo=null;
    }
    public boolean vacia(){
        if(raiz==null){
            return true;
        }else{
            return false;
        }            
    }
    public void mover(int servicios,String nombre){
        Nodo nuevo;
        nuevo = new Nodo();
        nuevo.servicios=servicios;
        nuevo.nombre=nombre;
        nuevo.siguiente=null;
        if(vacia()){
            raiz=nuevo;
            fondo=nuevo;
        }else{
            fondo.siguiente=nuevo;
            fondo=nuevo;
        }
    }
    public void insertar(int servicios, String nombre){
        Nodo nuevo;
        nuevo = new Nodo();
        nuevo.setServicios(servicios);;
        nuevo.setNombre(nombre);
        nuevo.setSiguiente(null);
        if(vacia()){
            raiz=nuevo;
            fondo=nuevo;
        }else{
            fondo.siguiente=nuevo;
            fondo=nuevo;
        }
    }
    public String extraer(){
        if(!vacia()){
            String nom=raiz.nombre;
            if(raiz==fondo){
                raiz=null;
                fondo=null;
            }else{
                raiz=raiz.siguiente;
            }
            return nom;
        }else{
            return null;
        }
    }
    public void imprimir(){
        Nodo aux=raiz;
        System.out.println("Cola: ");
        while(aux!=null){
            System.out.println(aux.nombre+" con "+aux.servicios+" servicios.");
            aux=aux.siguiente;
        }
        System.out.println();
    }
}
