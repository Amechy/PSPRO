package pspro;



public class SuperModerno {

	public static void main(String[] args) {
		int nCajas;
		int nClientes;
		int dineroRecaudado = 0;
		Caja cajas[];
		Cliente clientes[];
		double mediaTiempoEspera=0;
		
		
		try {
			nCajas = Integer.parseInt(args[0]);//Número de cajas
			nClientes = Integer.parseInt(args[1]);//Número de clientes
			
			cajas = new Caja[nCajas];
			clientes = new Cliente[nClientes];
			
			//Inicializamos las cajas que hay
			for (int i = 0; i < cajas.length; i++) {
				cajas[i]=new Caja(i);
			}
			//Inicializamos y lanzamos los clientes
			for (int i = 0; i < clientes.length; i++) {
				clientes[i] = new Cliente(i,cajas);
				clientes[i].start();
			}
			
			/**
			 * Esperamos que terminen todos los clientes de comprar
			 */
			for (int i = 0; i < clientes.length; i++) {
				
				try {
					clientes[i].join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			/**
			 * Calculamos el dinero recaudado de todas las cajas
			 */
			for (int i = 0; i < cajas.length; i++) {
				dineroRecaudado += cajas[i].totalAcumulado;
			}
		
			
			/**
			 * Calculamos la media de espera de los clientes
			 * 
			 */
			for (int i = 0; i < clientes.length; i++) {
				mediaTiempoEspera += clientes[i].tiempoEspera;
			}
			mediaTiempoEspera = mediaTiempoEspera / clientes.length;
			
			
			
			
			System.out.println("\n\nEl dinero recaudado del dia ha sido: "+dineroRecaudado+ " €");			
			System.out.println("\n\nLa media de espera de los clientes para conseguir una caja libre es de: "+mediaTiempoEspera);			
			System.out.println("Termina el hilo principal");
		} catch (Exception e) {
			System.out.println("Debe introducir al menos dos parámetros que sean números, \nel primero el número de cajas y el segundo el número de clientes");
		}
		
		
		

	}

}
