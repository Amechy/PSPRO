package pspro;


public class GestionClientes {
	
	public GestionClientes(Caja[] cajas) {
		super();
		this.cajas = cajas;
	}
	
	
	Caja[] cajas;
	
	
	
	public static synchronized Caja asignarCaja(Caja[] cajas) {
		int i = 0;
		while (cajas[i].ocupada) {
			
			i++;
		}
		return cajas[i];
		
	}
}
