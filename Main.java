import java.util.Scanner;

public class Main {

    private static int verificaNum(String texto){
        if (texto == null) return 0;

        texto = texto.replaceAll("[^0-9]", "");

        if (texto.equals("")) return 0;
        
        return Integer.parseInt(texto);
    }

    public static void main(String[] args) {

        Playlist<Cancion> plist = new Playlist<>();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Lista de Repoduccion de canciones" + "\n");
            System.out.println("1. Agregar Cancion");
            System.out.println("2. Agregar Cancion al final");
            System.out.println("3. Eliminar Cancion");
            System.out.println("4. Buscar cancion");
            System.out.println("5. Mostar Playlist");
            System.out.println("6. Mostrar la duracion total de la playlist");
            System.out.println("7. Reproducir la playlist");
            System.out.println("8. Salir");
            System.out.print("Opcion: ");
            opcion = verificaNum(sc.nextLine());
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Agregar Cancion");
                    System.out.println("Introduce el nombre de la Cancion");
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();

                    System.out.println("Introduce el nombre del artista de la Cancion");
                    System.out.print("Nombre del artista: ");
                    String nArtista = sc.nextLine();

                    System.out.println("Introduce la duracion en segundos");
                    System.out.print("Duracion: ");
                    int dura = verificaNum(sc.nextLine());

                    if(nombre == null || nArtista == null || dura == 0){
                        System.out.println("\n" + "El nombre no puede ser nulo, ni el artista ");
                        break;
                    }else{
                        Cancion c = new Cancion(nombre, nArtista, dura);
                        plist.agregar(c);
                        sc.nextLine();
                        break;
                    }

        
                
                case 2:
                    System.out.println("Agregar Cancion al final de la playlist ");
                    System.out.println("Introduce el nombre de la Cancion");
                    System.out.print("Nombre: ");
                    String nombre2 = sc.nextLine();

                    System.out.println("Introduce el nombre del artista de la Cancion");
                    System.out.print("Nombre del artista: ");
                    String nArtista2 = sc.nextLine();

                    System.out.println("Introduce la duracion en segundos");
                    System.out.print("Duracion: ");
                    int dura2 = verificaNum(sc.nextLine());

                    if(nombre2 == null || nArtista2 == null || dura2 == 0){
                        System.out.println( "\n" +"El nombre no puede ser nullo, ni el artista");
                        break;
                    }else{
                        Cancion c2 = new Cancion(nombre2, nArtista2, dura2);
                        plist.agregarFinal(c2);
                        sc.nextLine();
                        break;
                    }

                case 3:
                    System.out.println("Eliminar Cancion de la Playlist");
                    System.out.println("Intrduzca el nombre de la cancion a eliminar");
                    System.out.print("Nombre: ");
                    String nCancion = sc.nextLine();
                    plist.eliminarCancion(nCancion);
                    sc.nextLine();
                    break;
                    

                case 4:
                    System.out.println("Buscar cancion");
                    System.out.println("Ingrese la cancion que desea buscar: ");
                    System.out.print("Nombre: ");

                    String nCan = sc.nextLine();
                    plist.buscar(nCan);
                    sc.nextLine();
                    break;

                case 5:
                    plist.mostrarPlaylist();
                    sc.nextLine();
                    break;

                case 6:
                    plist.duracionDeLaPlaylist();
                    sc.nextLine();
                    break;

                case 7:
                    System.out.println( "\n" +"Reproduciendo playlist");
                    plist.reproducirCancion();
                    plist.mostrarPlaylist();
                    int opcci;

                    do{
                        System.out.println("\n" + "1. Reproducir siguiente cancion");
                        System.out.println("2. Reproducir cancion anterior");
                        System.out.println("3. Salir al menu principal");
                        System.out.print("Opcion: ");
                        opcci = sc.nextInt();
                        sc.nextLine();

                        switch(opcci){

                            case 1:
                                
                                plist.siguienteCancion();
                                plist.reproducirCancion();
                                plist.mostrarPlaylist();
                                break;

                            case 2:
                                plist.anteriorCancion();;
                                plist.reproducirCancion();
                                plist.mostrarPlaylist();
                                sc.nextLine();
                                break;

                            case 3:
                                System.out.println("Saliendo al menu inicial");
                                break;

                            default:
                                System.out.println("Intento otra opcion");
                            }
                    }while (opcci !=3); 
                    break;

                case 8:
                    return;


                default:
                    System.out.println("Opcion invalida, intenta de nuevo");
                    break;
            }

        } while (opcion != 8);
    }
}  