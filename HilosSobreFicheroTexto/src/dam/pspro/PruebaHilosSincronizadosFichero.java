package dam.pspro;

public class PruebaHilosSincronizadosFichero {

	public static void main(String[] args) throws InterruptedException{
		ControladorFicheros cf = new ControladorFicheros("Problemas.txt");
		
		String parrafo1 ="¡Supercalifragidisimoespialidoso! JEJEJEJE vamoooo";
		String parrafo2 ="Todo aquel que coja el cuaderno morirá jajaj, o no";
		
		Escritor cervantes = new Escritor(cf);
		Escritor shakespeare = new Escritor(cf);
		
		cervantes.fraseAdd(parrafo1);
		shakespeare.fraseAdd(parrafo2);
		
		cervantes.start();
		shakespeare.start();
		
		cervantes.join();
		shakespeare.join();
		
		cf.close();
		System.out.println("Los datos han sido escritos correctamente");	
	}
}
