package desEncriptar;
import java.util.Scanner;
import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.FileSystems;
public class yaider {

	// Declaro de dominio publico el array del abecedaio ya que lo usaré en repetidas ocaciones
    public static String[] abc = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p",
                                    "q","r", "s", "t", "u", "v", "w", "x", "y", "z" };

    //Esta es la funcion principal donde correra todo el programa
    public static void main(String[] args) throws InterruptedException, IOException {

        // Inicio un escaner y un ciclo while donde se repetira el programa
        Scanner sc = new Scanner(System.in);
        boolean sigue = true;
        final int SALIR =0;
        final int ENCRIPTAR=1;

        while (sigue) {

            //Le pregunto si quiere salir o continuer el programa
            System.out.println("-----------Encriptador--------\n1 para encriptar\n0 para salir");
            int des = sc.nextInt();

            // En base a la desicion se sale o continua con el programa
            switch(des){
                case SALIR:

                    sigue = false;
                    break;

                // Pido la palabra a encriptar para luego ejecutar la funcion que la encripta
                case ENCRIPTAR:
                    sc.nextLine();
                    System.out.println("Dé la palabra");
                    String palabra = sc.nextLine();
                    String palabraEncriptada = encriptador(palabra);
                    String almacenamiento=obtenerAlmacenamiento();

                    //Imprimo el resultado
                    System.out.println("Tu alamacenamiento es de "+almacenamiento+"\nEl resultado es "+palabraEncriptada);
                    resolver(palabraEncriptada);
                    break;
            }
        }
        //Cierro el ciclo 
        sc.close();
    }

    
    // Aqui es donde se encripta la palabra, donde ocurre la "Magia"
    public static String encriptador(String palabra) throws InterruptedException, IOException{

        // Declaro la palabra ya desencriptada para luego retornarla
        String palabraEncriptada = "";

        // Aqui agrego un poco de dinamismo al agregar un timer de espera(No aporta en mucho)
        System.out.println("Espere un momento");
        for (int i = 0; i < 3; i++) {
            String puntos = "...";
            Thread.sleep(500);
            System.out.println(puntos.charAt(i));
        }


        /* Declaro la variable almacenamiento que se obtendra en base a una funcion que obtiene el
        Alamacenamiento restante del dispositivo, obteniendo solo los primero 3 digitos de este
        (El Integer.parseInt es solo para convertir de String a int para hacer los calculos)*/

        int almacenamiento= Integer.parseInt(obtenerAlmacenamiento());

        // Inicializo un for que recorrera desde 0 hasta la longitud de la palabra para recorrer cada una de sus letras
        for (int i = 0; i < palabra.length(); i++) {
            // Obtengo la letra 
            String letra=palabra.substring(i, i+1);
            
            // con la funcion posicion obtengo la posicion de la letra en el abecedario
            int posicion = obtenerPosicion(letra);
            
            // A esta le sumo el valor del alamacenamiento disponible en el dispositivo
            posicion+=almacenamiento;

            // Ejecuto una funcion que recrea el movimiento en el abecedario que debe hacer la letra 
            int mov = movimiento(posicion);

            // Finalmente a la palabra encriptada le concateno la letra ubicada en la posicion final en ele abecedario
            palabraEncriptada+=abc[mov];
        }
        // Retorno la palabra
        return palabraEncriptada;
    }

    // Uso esta funcion para obtener la posicion en el abecedario de la letra ingresada
    public static int obtenerPosicion(String letra) {

        // Declaro la posicion que sera la que retorne
        int pos = 0;

        // Este for recorre hasta la longitud del abecedario
        for (int i = 0; i < abc.length; i++) {
            
            /* Pregunto qué posicion del abecedario coincide con la letra ingresada y si llega a coincidir
               esa posicion será la de mi variable, y se cierra el ciclo*/
            if (abc[i].equals(letra)) {
                pos = i;
                break;
            }
        }

        // Retorno la posicion
        return pos;
    }
    
    // Esta funcion es para hacer el movimiento en el abecedario de la letra
    public static int movimiento(int posicion) {

        /* Uso dos while que sirven para que si la longitud de la posicion es mayor a la longitud del abecedario,
           esta disminuya la misma longitud del abecedario. Y si por el contrario es menor a cero, 
           hace lo contrario, sumar la longitud del abecedario*/

        while (posicion > abc.length - 1) {
            posicion -= abc.length;
        }
        while (posicion < 0) {
            posicion += abc.length;
        }

        // Retorno la nueva posicion que será la que se moverá en el abecedario 
        return posicion;
    }

    // Con esta funcion obtengo el almacenamiento restante en el disco del pc

    public static String obtenerAlmacenamiento() throws IOException{

        // Creo una variable long donde se almacenara el almacenamiento disponible
        long storageAvailable = 0L;

        // Aqui obtengo ubico donde está mi carpeta en la que buscare la longitud
        FileStore fileStore = FileSystems.getDefault().getFileStores().iterator().next();
        
        // Esta parte obtiene la cantidad de almacenamiento disponible de la variable anterior
        storageAvailable = fileStore.getUsableSpace();
        
        // Lo convierto a string y luego cojo solo los primero 3 digitos que seran los que usaré 
        String espacio = Long.toString(storageAvailable);
        espacio = espacio.substring(0, 3);
        
        // retorno el espacio
        return espacio;
    }
    public static void resolver (String palabraEncriptada ) throws NumberFormatException, IOException {
    	int almacenamiento= Integer.parseInt(obtenerAlmacenamiento());
    	
    	for (int i = 0; i < palabraEncriptada.length(); i++) {
    		int posicionLetra=0;
    		for (int j = 0; j < abc.length; j++) {
    			if(palabraEncriptada.substring(i, i+1).equals(abc[j])) {
    				System.out.println(abc[j]);
    				System.out.println(palabraEncriptada.substring(i, i+1));
    				posicionLetra =almacenamiento-j;
    				System.out.println(posicionLetra);
    				while (posicionLetra>abc.length-1) {
    					posicionLetra-=abc.length;
					}
    				while (posicionLetra<0) {
    					posicionLetra+=abc.length;
					}
    				System.out.println(posicionLetra);
				}
    		}
		}
    	
    }

}
