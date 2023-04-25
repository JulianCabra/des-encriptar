package desEncriptar;
import java.util.Scanner;
public class DesencriptarSergioCalderon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    Scanner sc=new Scanner(System.in);
	    String[] vector={"a","b","c","d","e","f","g","h","i","j","k","l","m","n","ñ","o","p","q","r","s","t","u","v","w","x","y","z"," "};
	    System.out.println("Ingrese una palabra");
	    String palabra =sc.nextLine();
	    String resultado="";
	    for(int i=0;i<palabra.length();i++){//ciclo desde la primera letra hasta la ultima
	    	for(int x=0;x<28;x++){//ciclo de a hasta z
	             if(vector[x].equals(palabra.substring(i,i+1))){//comprueba si la letra es igual a la posicion en el vector
                      int y=x;
                        for(int z=16;z>=1;z=z/2){//comprueba la cuatro potencias para cada letra
	                        if(y/z>=1){//este ciclo prueba con las potencias de 2 y si es mayor que alguna de esta agrega un asterisco
                               resultado+="*";
                             }else{
                            	   resultado+=" ";//si no es divisible entonces me suma un espacio que es la opcion apagado
	                            }
	                            if(y/z>=1){//en este ciclo tambien prueba las potencias de 2 
	                               y=y%z;//con esto al agregar un * le saca el modulo del valor de esa potencia 
	                            } 
	                      }
	                      resultado+="/";//separa cada letra 
	                      x=27;//acaba con el ciclo
	              }
	        	}
	      }
	    System.out.println(resultado);//muestra la palabra codificada
	    
	    double guardar=0;
	    String[] letras = resultado.split("/");
	    int[] valoresPotencia = {16,8,4,2,1};
	    for (int i = 0; i < letras.length; i++) {
	    	int potencia=4;
	    	int suma=0;
			for (int j = 0; j < valoresPotencia.length; j++) {
				if (letras[i].substring(j, j+1) .equals("*")) {
					guardar= Math.pow(2, potencia);
				}else {
					guardar = 0;
				}
				potencia-=1;
				suma+=guardar;
			}
			System.out.println(vector[suma]);
		}
	    
	}
}