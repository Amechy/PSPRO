/**
 * @author Alejandro Mechiné

 *
 */
import java.util.concurrent.atomic.AtomicInteger;

class Contador {
	public static AtomicInteger cuenta =  new AtomicInteger(0);
}

class Sumador extends Thread{
	@Override
	public void run() {
		for (int i = 0; i < 100000; i++) {
			//Contador.cuenta++;
			Contador.cuenta.incrementAndGet();
			
		}
		
	}
}

class Restador extends Thread{
	@Override
	public void run() {
		for (int i = 0; i < 50000; i++) {
			//Contador.cuenta--;
			Contador.cuenta.decrementAndGet();
			
		}
	}
}

public class condicionCarrera {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sumador s = new Sumador();
		Restador r = new Restador();
		r.start();
		s.start();
		
		try {
			s.join();
			r.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Valor final del contador: "+Contador.cuenta);
	}
	

}
