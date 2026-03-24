/**
 * @author Ozkar Trejo
 * Implementacion de la clase cancion 
 */
public class Cancion{
    private String titulo;
    private String artista;
    private int duracion; 

    //Metodo constructor de la cancion 
    public Cancion(String titulo, String artista, int duracion){
        this.titulo = titulo; 
        this.artista = artista; 
        this.duracion = duracion; 
    }

    //Getters de la clase titulo
    public String obtenerTitulo(){
        return titulo;
    }

    public String obtenerArtista(){
        return artista;
    }

    public int obtenerDuracion(){
        return duracion;
    }

    //Metodo toString para mostrar la cancion
    public String mostarCancion(){
        return titulo + " - " + artista + " (" + duracion + " seg)";
    }
}