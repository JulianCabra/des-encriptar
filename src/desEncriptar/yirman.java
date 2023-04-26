package desEncriptar;
import java.util.Scanner;
public class yirman {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		* esta funcion recibe una palabra para encriptar a su vez recibe un año 
		* y un mes (prferiblemente año y ,es de nacimiento)que mediente operaciones matematicas basica
		* genera un numero personal, el cual sera el numero de veces que avanza  de la posicion original a la nueva posicion
		* s
		String palabra="";// recibe la palbra a encriptar
		int año=0;// recibe un valor numerico
		int mes=0;//recibe valor numerico
		/*
		 * array que contiene una palabra que inicia  por cada letra del abecedario
		 */
		Scanner entrada=new Scanner(System.in);
		String[] abc = {"array","bucle","cadena","definir","enlace","funcion","gato","hijo","incremento","java","kilo","lamento","matriz","nada","ñandu","operador","patron","quizz","raton","sistema","terminal","ubicacion","vida","wilslson","xilofon","yuca","zzz"};
		System.out.println("ingrese la palabra que desee encriptar");
		String palabra= entrada.next();
		System.out.println("para iniciar la encriptacion unico y personalizado por favor ingrese su año de nacimiento");
		int año= entrada.nextInt();
		System.out.println("para continuar: ingrese su mes de nacimiento");
		int mes=entrada.nextInt();
		/*
		 * el siguiente proceso se hace para tener un numero personalizado depentienndo el año y mes de nacimiento
		 */
		int codigo=(año*mes)/(mes+(año/2));//genera un numero realizando operaciones matematicas basado en los datos recibidos 
		int codigoA=codigo/10; // divide el resultado anterior y saca la parte parte entera
		int codigoB=codigo %10; //divide el resultado anterior y saca la parte decimalparte decimal
		int codigoF= codigoA+ codigoB; // suma la parte entera y la parte decimal para que sea un solo numero  
		String encriptado=""; // almacena las palabras que componen la encriptacion 
		/*
		* for que sirve para aumentar la variable dependiendo el numero de las letras de la palabra ingresada
		* para poder recorrer cada letra de la palabra
		*/
		for(int incremento=0;incremento<= palabra.length()-1;incremento++) { 
			for(int posicion=0; posicion<= abc.length-1; posicion++) { // for para recorrer el arreglo
				/*
				 * el string me toma la primera letra de cada palabara del arreglo
				 * para despues compararla con cada letra de la palabra
				 */
				String letra= abc[posicion].substring(0, 1); 
				/*
				 *  condicional para comparar cada una de  las letras de la palabra 
				 *  con la primera de la palbra de cada palabra del arreglo 
				 */
				if( palabra.substring(incremento, incremento+1).equals(letra)) { 
					/*
					 * esta condicion sirve para que cuando la letra encriptada supere el tamaño del arreglo esta
					* continue ahora desde el inico del arreglo
					*/
					if(posicion+codigoF>abc.length) { 
						/*
						 * con esta operacion lo que hago es sumar la posicion de la letra en el arreglo
						 * con el codigo que cree anteriormente que es el que me dice las veces que avanzo de legtra 
						 * en el arreglo, luego lo resto con la longitud del arreglo y el resultado es el 
						 * numero que veces que avnzara ahora desde el primer caracter del arreglo
						 */
						int volver = ( posicion + codigoF)-abc.length ;
						/*
						 * agrega palabras a las ya guardadas, ademas de un "/" para distinguir mejor cada palabra
						 */
						encriptado=encriptado+"/"+abc[volver]; 
					}else {
						/*
						 * agrega palabras a las ya guardadas, ademas de un "/" para distinguir mejor cada palabras
						 */
						encriptado=encriptado+"/"+abc[posicion+codigoF];
					}
				}
			}
		}
		System.out.println(encriptado);
		int codigo1=(año*mes)/(mes+(año/2));
		int codigoAA=codigo/10;
		int codigoBB=codigo %10;
		int codigoFF= codigoA+ codigoB;
	}

}
