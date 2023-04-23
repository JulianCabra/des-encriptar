package desEncriptar;
import herramientas.herramienta;
import java.util.Scanner;
public class DesencriptarSamuelCamargo {
	public static void main(String[] args) {
		Scanner Lectura = new Scanner(System.in);
		String palabraE= Lectura.next();
		String encriptada= herramienta.encriptarPalabra(palabraE);
		System.out.println(encriptada);
		System.out.println(herramienta.desencriptar(encriptada));
		Lectura.close();
	}
}
