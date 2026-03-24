
/**
 * @author Trejo Garcia Ozkar Mauricio
 * @version 2026-2
 */
public interface Listable<T>{

    //Agregar Cancion al inicio de la playList 
    public void agregar(T elem);


    //Agrgar Cancion al final de la playlist
    public void agregarFinal(T elem);


    //Eliminar un cancion por titulo
    public void eliminarCancion(String titulo);
    

    //Buscar una cancion 
    public boolean buscar(String titulo);


    //Regresa toda la playlist completa
    public void mostrarPlaylist();


    //Mostrar la duracion total de la Playlist
    public int duracionDeLaPlaylist();


    //Reproducir cancion actual
    public void reproducirCancion();


    //Avanzar a la siguiente cancion 
    public void siguienteCancion();

    
    //Regresar a la siguiente cancion
    public void anteriorCancion();


}