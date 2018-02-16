//9.mâjasdarbs - Elîna Mûrniece

interface Istaba {
	double area();	
	double perim();
	void info();
}

interface Logs {
    double cena();
    void info2 ();
    double montazasCena = 70;
}

class GulamIstaba implements Istaba{
	   double platums;
	   double garums; 

	   GulamIstaba (double a, double b) {
				platums = a;
				garums = b;
		    }
			 
	   GulamIstaba () {
				platums = 0;
				garums = 0;
		    }
			 
	   GulamIstaba (GulamIstaba ob) {
				 platums = ob.platums;
				 garums = ob.garums;
			  }
			   
		public double area() {
			      return platums * garums; 
		    }
		
	    public double perim() {
		      return 2 * (platums + garums); 
		      
	    }
	    public void info(){
			   	  System.out.println("Guïamistabas platums ir " + platums + "m un garums " + garums + "m.");
			      return;
			   }
	}

class PvcLogs implements Logs {
	   double platiba;
	   double Cena_m2;
	   String krasa;
	
	   PvcLogs (double a, double b, String c) {
		      platiba = a;
		      Cena_m2 = b;
		      krasa = c;
		   }
	   
	   public double cena() {
	      return platiba*Cena_m2 + montazasCena;
	   }
	   
	   public void info2 (){
		   System.out.println("PVC loga parametri: Platîba - " + platiba + " m2, krâsa: " + krasa);
		   return;
	   }
	}


public class Md_9 {

	public static void main(String[] args) {
		Istaba ref;
		GulamIstaba A = new GulamIstaba (3.10, 4.25);
		GulamIstaba B = new GulamIstaba ();
		GulamIstaba C = new GulamIstaba (2.55, 3.00);

		//interfeisa references mainîgo izmantoðana
	      ref=A;
	      ref.info();
		  System.out.println("Guïamistabas platîba ir  " + A.area() + "m2 un perimetrs: " + A.perim() + " m");
	      System.out.println();
	      
	      ref=B;
	      ref.info();
		  System.out.println("Guïamistabas platîba ir  " + B.area() + "m2 un perimetrs: " + B.perim() + " m");
	      System.out.println();
	      
	      ref=C;
	      ref.info();
		  System.out.println("Guïamistabas platîba ir  " + C.area() + "m2 un perimetrs: " + C.perim() + " m");
	      System.out.println();
	     
        PvcLogs p = new PvcLogs(3.5, 48,  "balts");
	      
          p.info2();
	      
	      double PvcCena;
	      PvcCena = p.cena();
	      System.out.println("Cena PVC logam ir " + PvcCena);
	      System.out.println();
	      
	      System.out.println("Programmas beigas. ");
	}

}
