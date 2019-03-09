package _01Klasy;

// Definicja prostej klasy z metodami i konstruktorami

class Box3{
    double width;
    double height;
    double depth;

    // konstruktor bez parametrow
    Box3() {
    	width  = 0; 
    	height = 0; 
    	depth  = 0;
//    	this.setDim(0, 0, 0); // DRY
    }
    // konstruktor z jednym parametrem
    Box3(int n) {
    	width  = n; // tu konwersja int do double
    	height = n; 
    	depth  = n;
    }
    // konstruktor z parametrami
    Box3(int w, int h, int d) {
    	width  = 2*w; 
    	height = 3*h; 
    	depth  = 4*d;
    }
    // konstruktor z parametrami
    Box3(double width, double height, double depth) {
    	this.width  = width; 
    	this.height = height; 
    	this.depth  = depth;
    }
    
    Box3(int w, double h, double d) {
    	this.setDim(w, h, d);
    }
//    Box3(double w, int h, double d) {
//    	width  = -w; 
//    	height = -h; 
//    	depth  = -d;
//    }
    // metoda zmieniajaca zawartosc obiektu
    // ale nie bedaca konstruktorem
    // nic nie zwraca, wiec typ wynikowy to void
    void setDim(double w, double h, double d) {
    	width  = w; 
    	height = h; 
    	depth  = d;
    }
    // metoda obliczajaca objetosc
    double volume() {
	// tu metoda oddaje obietosc
    	return width * height * depth;
    }
}

// definicja klasy demonstrujacej uzycie klasy Box 
class BoxDemo3{
    public static void main (String args[]) {
	// utworzenie instancji klasy Box
	Box3 myBox1 = new Box3();
	Box3 myBox2 = new Box3(2);
	Box3 myBox3 = new Box3(3, 4, 5.0);
	Box3 myBox4 = new Box3(1.0, 1.0, 1.0);

	// wypisujemy objetosci 
	System.out.println("\nObjetosc myBox1 = " + myBox1.volume());
	System.out.println(  "Objetosc myBox2 = " + myBox2.volume());
	System.out.println(  "Objetosc myBox3 = " + myBox3.volume());
	System.out.println(  "Objetosc myBox4 = " + myBox4.volume());

	// zmieniamy zawartosc obiektu myBox1
	myBox1.setDim(2, 3, 2);
	// raz jeszcze jego objetosc
	System.out.println("\nObjetosc myBox1 = " + myBox1.volume() + "\n");
    }
}
