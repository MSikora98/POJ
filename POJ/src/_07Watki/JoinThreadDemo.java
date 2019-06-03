package _07Watki;

// przyklad uzycia join do oczekiwania na zakonczenie watku

class NewThread3 implements Runnable {
	int czas;
	String name;
	Thread t;

	NewThread3(String threadName, int c) {
		czas = c;
		name = threadName;
		t = new Thread(this, name);
		System.out.println("Nowy watek      > " + t);
		t.start();
	}

	public void run() {
		try {
			for (int i = 5; i > 0; i--) {
				System.out.println(name + "      > " + i);
				Thread.sleep(1 + czas);
			}
		} catch (InterruptedException e) {
			System.out.println("Watek " + name + " przerwany");
		}
		System.out.println("Koniec watku " + name);
	}
}

class JoinThreadDemo {
	public static void main(String args[]) {
		NewThread3 ob1 = new NewThread3("Pierwszy", 4);
		NewThread3 ob2 = new NewThread3("Drugi   ", 5);
		NewThread3 ob3 = new NewThread3("Trzeci  ", 6);
		NewThread3 ob4 = new NewThread3("Czwarty ", 6);

		System.out
				.println("Watek " + ob1.name + " dziala : " + ob1.t.isAlive());
		System.out
				.println("Watek " + ob2.name + " dziala : " + ob2.t.isAlive());
		System.out
				.println("Watek " + ob3.name + " dziala : " + ob3.t.isAlive());
		System.out
				.println("Watek " + ob4.name + " dziala : " + ob4.t.isAlive());
		// oczekiwanie na zakonczenie dzialania watkow
		try {
			System.out.println("Czekamy na zakonczenie dzialania watkow");
			ob1.t.join();
			System.out.println("Pierwszy: koniec");
			ob2.t.join();
			System.out.println("Drugi   : koniec");
			ob3.t.join();
			System.out.println("Trzeci  : koniec");
			//ob4.t.join();
		} catch (InterruptedException e) {
			System.out.println("Watek glowny przerwany");
		}
		System.out
				.println("Watek " + ob1.name + " dziala : " + ob1.t.isAlive());
		System.out
				.println("Watek " + ob2.name + " dziala : " + ob2.t.isAlive());
		System.out
				.println("Watek " + ob3.name + " dziala : " + ob3.t.isAlive());
		System.out
				.println("Watek " + ob4.name + " dziala : " + ob4.t.isAlive());
		System.out.println("Koniec watku glownego");
	}
}
