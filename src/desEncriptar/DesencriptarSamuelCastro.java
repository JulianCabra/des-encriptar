package desEncriptar;
import herramientas.herramientaSamuelCastro;
import java.util.Scanner;

public class DesencriptarSamuelCastro {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner conexion= new Scanner(System.in);
		String palabra= conexion.next();
		String palabranueva= herramientaSamuelCastro.samuelCastro(palabra);
		System.out.println(palabranueva);
		System.out.println(herramientaSamuelCastro.desencriptar(palabranueva));
		conexion.close();
	}
}
