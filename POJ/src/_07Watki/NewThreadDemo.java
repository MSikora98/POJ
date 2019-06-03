package _07Watki;

// przyklad tworzenia nowego watku 
// przez implementacje interfejsu Runnable
class NewThread4 implements Runnable {
	Thread t;

	NewThread4() {
		// tworzenie nowego watku
		t = new Thread(this, "Nowy watek");
		System.out.println("Nowy watek      > " + t);
		// uruchom watek
		t.start();
	}

	// kod nowego watku
	public void run() {
		long time1 = System.currentTimeMillis(), 
				time2;
		int a = 0;
		try {
			
			for (int i = 1000000; i > 0; i--) {
				//Thread.sleep(1);
				a++;
				//System.out.println("Nowy watek      > " + i);
			}
		} catch (//InterruptedException e
				Exception e) {
			System.out.println("Watek potomny przerwany");
		}
		time2 = System.currentTimeMillis();
		System.out.println("Koniec nowego watku: "+ a 
				+" ["+(time2-time1)+"]");
	}
}

class NewThreadDemo {
	public static void main(String args[]) {
		new NewThread4(); // utworz nowy watek
//		new NewThread4(); // utworz nowy watek
//		new NewThread4(); // utworz nowy watek
//		new NewThread4(); // utworz nowy watek
//		new NewThread4(); // utworz nowy watek
//		new NewThread4(); // utworz nowy watek
//		new NewThread4(); // utworz nowy watek
//		new NewThread4(); // utworz nowy watek
		Thread t = Thread.currentThread();
		long time1 = System.currentTimeMillis(), 
				time2, a = 0;
		t.setName("Watek glowny");
		System.out.println("Watek glowny    : " + t);
		try {
			for (int i = 100; i > 0; i--) {
				//System.out.println("Watek glowny    : " + i);
				a++;
				Thread.sleep(10);
			}
		} catch (InterruptedException e) {
			System.out.println("Watek glowny przerwany");
		}
		time2 = System.currentTimeMillis();
		System.out.println("Koniec watku glownego:"+"<"+(time2-time1)+">");
	}
}
