/**
 * Clase para manejar la Playlist 
 * @author Ozkar Trejo Garcia 
 * @version 2026-2
 * */ 
public class Playlist <T extends Cancion> implements Listable <T>{

    //Clase interna Nodo
    private class Nodo{
        T dato; 
        Nodo siguiente; 
        Nodo anterior;

        Nodo(T dato){
            this.dato = dato; 
            this.siguiente = null; 
            this.anterior = null;
        }
    }

    private Nodo cabeza; 
    private Nodo cola; 
    private int tam;
    private Nodo actual;

    //Metodo constructor para manejar la playlist 
    public Playlist(){
        cabeza = null; 
        cola = null; 
        tam = 0;
    }

    /**
     * Verifica si la lista esta vacia 
     * 
     * @return true si la lista esta vacia de caso contrario false 
     */
    public boolean estaVacio(){
        return tam == 0;
    }


    /**
     * Metodo que agrega una cancion a la Playlist 
     * @param Cancion 
     */
    @Override
    public void agregar(T elem){
        Nodo nuevo = new Nodo(elem);

        if(estaVacio()){
            cabeza = cola = nuevo;
        }else{

            nuevo.siguiente = cabeza;
            cabeza.anterior = nuevo;
            cabeza = nuevo;
        }

        tam++;
    }

    /**
     * Meotodo que agrega una cancion al final de la playlist 
     * @param Cancion
     */
    @Override
    public void agregarFinal(T elem){
        Nodo nuevo = new Nodo(elem);

        if(estaVacio()){
            cabeza = cola = nuevo;
        } else{

            cola.siguiente = nuevo;
            nuevo.anterior = cola;
            cola = nuevo;
        }

        tam++;
    }

    /**
     * Metodo que elimina una cancion de la playlist
     * @param Cancion
     */
    @Override
    public void eliminarCancion(String titulo){

        if(titulo == null){
            System.out.println("El nombre de la cancion no puede ser nulo");
            return;
        }

        Nodo tmp = cabeza;

        while(tmp != null){

            if(tmp.dato.obtenerTitulo().equals(titulo)){
                System.out.println("Se elimino la cancion con el nombre " + titulo);
                eliminarNodo(tmp);
                return;
            }else{
                System.out.println("No se encontro la cancion");
            }
            tmp = tmp.siguiente;
        }
    }

    /**
     * Metodo que elimina el nodo de la lista ligada 
     * @param nodo
     */
    private void eliminarNodo(Nodo nodo){
        if(cabeza == cola){ 
        cabeza = cola = null;

        }else if(nodo == cabeza){
            cabeza = cabeza.siguiente;
            cabeza.anterior = null;

        }else if(nodo == cola){
            cola = cola.anterior;

            cola.siguiente = null;
        }else{
            nodo.anterior.siguiente = nodo.siguiente;
            nodo.siguiente.anterior = nodo.anterior;
        }
        tam--;
    }

    /**
     * Meotodo que busca una cancion de la lista
     */
    @Override
    public boolean buscar(String titulo){
        Nodo tmp = cabeza;

        while(tmp != null){

            if(tmp.dato.obtenerTitulo().equals(titulo)){
                System.out.println("Se encontro la cancion " + titulo + " en tu playlist");
                return true;
            }
            tmp = tmp.siguiente;

        }
        System.out.println("No se encontro la cancion en tu playlist" );
        return false;
    }

    /**
     * Metodo que muestra la playlist con la lista de canciones
     */
    public void mostrarPlaylist(){
        Nodo tmp = cabeza;
        int contador = 1;

        if(tmp == null){
            System.out.println("\n" +"No hay Playlist que mostar");
            return;
        }
        System.out.println("Playlist actual" + "\n");

        while(tmp != null){

            if(tmp == actual){
                System.out.println(">> " + contador + ". " + tmp.dato.mostarCancion());
            }else{
                System.out.println(contador + ". " + tmp.dato.mostarCancion());
            }

            tmp = tmp.siguiente;
            contador++;
        }
    }

    /**
     * Meotodo que muestra la duracion de la playlist
     * @return duracion total de la playlist 
     */
    public int duracionDeLaPlaylist(){
        Nodo tmp = cabeza;
        int duracionTotal = 0; 

        while(tmp!= null){
            duracionTotal += tmp.dato.obtenerDuracion();
            tmp = tmp.siguiente;

        }

        System.out.println("La duracion total de la playlist es: " + duracionTotal + " segundos");
        return duracionTotal; 
    }

    /**
     * Metodo que reproduce una cancion 
     * @param Cancion 
     */
    public void reproducirCancion(){

        if(cabeza == null){
            System.out.println("No hay canciones en la playlist");
            return;
        }

        if(actual == null){
            actual = cabeza;
        }

        System.out.println("Reproduciendo: " + actual.dato.obtenerTitulo() + "\n" + "Duracion: " + actual.dato.obtenerDuracion());
    }
    
    /**
     * Metodo que hace la accion de avanzar a la siguiente cancion de la Playlist
     */
    public void siguienteCancion(){
        if(actual.siguiente == null){

            System.out.println( "\n" +"No hay cancion siguiente");
        }else{
            actual = actual.siguiente;
        }
    
    }

    /**
     * Metodo que hace la accion de regresar a la cancion anterior de la Playli
     */
    public void anteriorCancion(){
        if(actual.anterior == null){
            System.out.println( "\n" + "No hay cancion antes");
        }else{
            actual = actual.anterior;
        }
    }
}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               