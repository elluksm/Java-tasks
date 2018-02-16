//8.mâjasdarbs - Elîna Mûrniece

class Istaba {
   double platums;
   double garums; 

		 Istaba (double a, double b) {
			platums = a;
			garums = b;
	    }
		 
		 Istaba () {
			platums = 0;
			garums = 0;
	    }
		 
		 Istaba (double d) {
			platums = d;
			garums = d;
	    }
		 
		 Istaba (Istaba ob) {
			 platums = ob.platums;
			 garums = ob.garums;
		  }
		   
		//Final tipa metode
	    final double area() {
		      return platums * garums; 
	    }

		 void info(){
		   	  System.out.println("Istabas platums ir " + platums + "m un garums " + garums + "m.");
		      return;
		   }
}

class gulamIstaba extends Istaba {
	double gultasPlatums; //gultas platums - jaunu mainîgo pievienoðana apakðklasçs
	
	//Atslçgas vârda super izmantoðana, lai grieztos pie superklases konstruktora
	gulamIstaba (double a, double b, double c) {
		  super (a, b);
		  gultasPlatums = c;
	    }
	
	gulamIstaba () {
		  super ();
		  gultasPlatums = 0;
	    }
	
	gulamIstaba (double d, double c) {
		  super (d);
		  
		  gultasPlatums = c;
	    }
	
	gulamIstaba (gulamIstaba ob) {
		  super (ob);
		  gultasPlatums = ob.gultasPlatums;
	    }
	
	//Metoþu pârdefinçðana (override) apakðklasçs
	 void info(){
	   	  System.out.println("Guïamistabas platums / garums ir " + platums + "m un " + garums + "m. Gultas platums: " + gultasPlatums);
	      return;
	   }
		//Final tipa metodi nav iespçjams pârdefinçt (override)
	    // double area () {
		// return 2 * platums * garums;
        //	 }
}
	
//final tipa klase
final class vannasIstaba extends Istaba {
	String flizuKrasa; //sienas flîþu krâsa  - jaunu mainîgo pievienoðana apakðklasçs
	
	vannasIstaba (double a, double b, String c) {
		super (a, b);
		flizuKrasa = c;
	}
	
	//Atslçgas vârda super izmantoðana, lai grieztos pie superklases metodes
	   void info() {
		      super.info();
		      System.out.println("Vannasistabas sienas flîþu krâsa ir: " + flizuKrasa);
		   }
}

  //final tipa klasei nevar bût apakðklases
  //class tualete extends vannasIstaba {
  //}

//Abstraktas klases un metodes
abstract class Logs {
	   double platiba;
	   double montazasCena;
	   String krasa;

	   Logs (double a, double b, String c) {
	      platiba = a;
	      montazasCena = b;
	      krasa = c;
	   }

	    abstract double cena();
	}

class PvcLogs extends Logs {
	PvcLogs (double a, double b, String c) {
	      super(a,b,c);
	   }

	// Pârdefinçta abstraktâ metode
	   double cena() {
	      return platiba*48 + montazasCena;
	   }
	   
	   //Pârdefinçta metode toString
	   public String toString() { 
		   return "PVC loga parametri: Platîba - " + platiba + "m2, krâsa: " + krasa;
	   }
	}

//	Atslçgas vârda super izmantoðana, lai grieztos pie superklases mainîgâ
class TestSuper {
	  int i;
}

class Test extends TestSuper {
	   int i;                 

	   Test (int a1, int a2) {
	     super.i = a1;          
	     i = a2;                
	   }

	   void superpiem() {
	     System.out.println("i no superklases TestSuper: " + super.i);
	     System.out.println("i no apaksklases Test: " + i);
	   }
}

//superklases private mainîgo aktualizâcija, piekïûðana pie superklases private mainîgajiem
class A {
	private int z;
	
  public void setz(int x) {
	z = x;
  }
	  
	public int getz() {
		return z;
	}
}

class B extends A {
	 B (int v) {
		 super.setz(v);
	 }
	int getw (){
		int i = super.getz();
		return i;
	}

}

public class Md_istaba {
  
	public static void main(String[] args) {
	      
		gulamIstaba A = new gulamIstaba (3.10, 4.25, 1.60);
		gulamIstaba B = new gulamIstaba ();
		gulamIstaba C = new gulamIstaba (3.10, 1.80);
		gulamIstaba D = new gulamIstaba (A);
		vannasIstaba F = new vannasIstaba (2.55, 3.00, "zila");
	      
		double platiba;
	    
		  A.info();
	      platiba = A.area();
	      System.out.println("Guïamistabas platîba ir  " + platiba + "m2");
	      System.out.println();
	      
		  B.info();
	      platiba = B.area();
	      System.out.println("Guïamistabas platîba ir  " + platiba + "m2");
	      System.out.println();
	      
		  C.info();
	      platiba = C.area();
	      System.out.println("Guïamistabas platîba ir  " + platiba + "m2");
	      System.out.println();
	      
		  D.info();
	      platiba = D.area();
	      System.out.println("Guïamistabas platîba ir  " + platiba + "m2");
	      System.out.println();
	      
	   //dinamisku metoþu izsaukðana, izmantojot vienu references mainîgo
	      vannasIstaba w;               
	      w = F;           
	      w.info();        

	      platiba = F.area();
	      System.out.println("Vannasistabas platîba ir  " + platiba + "m2");
	      System.out.println();
	      
	      PvcLogs p = new PvcLogs(3.5, 70,  "balts");
	      
	      System.out.println(p.toString());
	      
	      double PvcCena;
	      PvcCena = p.cena();
	      System.out.println("Cena PVC logam ir " + PvcCena);
	      System.out.println();
	      
	   //Object klases metode
	      Boolean a1, a2, a3;
			a1 = new Boolean(true);
			a2 = new Boolean(true);
			a3 = new Boolean(false);
					
			boolean res;
			res = a1.equals(a2);
			System.out.println("Boolean a1 == a2: " + res);
			
			res = a1.equals(a3);
			System.out.println("Boolean a1 == a3: " + res);
		    System.out.println();
			
			Test t = new Test(13, 26);
		    t.superpiem();
		    System.out.println();
		    
		 //   superklases private mainîgo aktualizâcija, piekïûðana pie superklases private mainîgajiem
		    B piem = new B (49);
		    System.out.println("Superklases private mainîgais: "+ piem.getw());
		    
	        System.out.println("Programmas beigas. ");

	}
}



