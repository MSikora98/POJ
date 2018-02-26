package _07Watki;

// przyklad tworzenia wielu nowych watkow 

class NewThread11 implements Runnable {
	String name; // nazwa watku
	Thread t;

	NewThread11(String threadName) {
		name = threadName;
		t = new Thread(this, name);
		System.out.println("Nowy watek ("+ name +")    > " + t);
		// uruchom watek
		t.start();
	}

	final double f(double x){
		return Math.sin(Math.E * x) -1.5;
	}
	// kod nowego watku
	public void run() {
		long time1 = System.currentTimeMillis(), 
				time2;
		double a = 1.0;
		try {
			for (int i = 10000000; i > 0; i--) {
				//System.out.println(name + "      > " + i);
				//Thread.sleep(10);
				a+= Math.sin(Math.E * i) +1.5 ;//f(i);//1 ;//Math.sin(Math.E * i) +1 ;
			}
		} catch (Exception e)//InterruptedException e) 
				{
			System.out.println("Watek " + name + " przerwany");
		}
		time2 = System.currentTimeMillis();
		System.out.println("Koniec watku " + name + a 
				+" ["+(time2-time1)+"]");
	}
}

class MultiThreadDemo {
	public static void main(String args[]) {
		new NewThread11("Pierwszy");
		new NewThread11("Drugi   ");
		new NewThread11("Trzeci  ");
		new NewThread11("Czwarty ");
		new NewThread11("Piaty   ");
		new NewThread11("---6--- ");
		new NewThread11("---7--- ");
		new NewThread11("---8--- ");

		try { // czekaj na zakonczenie wszystkich watkow
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println("Watek glowny przerwany");
		}
		System.out.println("Koniec watku glownego");
	}
}
