//10.mâjasdarbs - Elîna Mûrniece

 //sava izòçmuma nodefinçðana	
class MansIznemums extends Exception {
   private int detail;

   MansIznemums (int v) {
      detail = v;
   }

   public String toString() {
      return "Mans Izòçmums ar parametru: [" + detail + "]. Vçrtîba ir mazâka par 49!";
   }
}

public class Md_10 {
	   static void min_vertiba_49 (int v) throws MansIznemums {
		      System.out.println("Izsaukta min_vertiba_49(" + v + ")");
		      if (v<49)
		         throw new MansIznemums(v);
		      System.out.println("Vçrtîba ir lielâka par 49 - viss kârtîbâ!");
		   }
	   
	   
	public static void main(String[] args) {
		
		  //sava izòçmuma realizçðana		    
	    try {
	    	min_vertiba_49(55);
	    	min_vertiba_49(13);
	      } catch (MansIznemums e) {
	        System.out.println ("Izdodam izòçmumu: " + e);
	      }
        System.out.println();
        
		//3 nekontrolçjamo izòçmumu (exceptions) apstrâde
		
		int x, y, z;
	      try{
	         x = 49;
	         y = 49;
	         z = 107 / (x-y);
	         System.out.println("Bez kïûdâm! ");
	      } 
	      catch (ArithmeticException A) {
	         System.out.println("Izòçmums: " + A);
	         System.out.println("Dalît ar nulli nedrîkst!");
	         System.out.println();
	      }
	      
		 int tabula [] = new int [3];
		      try{
		         tabula [0] = 0;
		         tabula [1] = 1;
		         tabula [2] = 2;
		         tabula [3] = 3;
		         System.out.println("Viss kârtîbâ! ");
		      } 
		      catch (ArrayIndexOutOfBoundsException Arr) {
		         System.out.println("Izòçmums: " + Arr);
		         System.out.println("Masîva indekss atrodas ârpus definçta masîva robeþâm!");
		         System.out.println();
		      }
		      
		      
			    try{
					 int tabulaex [] = new int [-2];
			         System.out.println("Viss kârtîbâ! ");
			      } 
			      catch (NegativeArraySizeException Neg) {
			         System.out.println("Izòçmums: " + Neg);
			         System.out.println("Tiek veidots masîvs ar negatîviem izmçriem!");
			      }	     finally {
			          System.out.println("Finally bloks - Piemçrs Nr.1."); 		  //finally bloka pielietojums
			      }
			    System.out.println();
			    
		  //vçl 2 finally bloka pielietojumi
			    
			    try{
					 int tabulaex2 [] = new int [3];
			         System.out.println("Viss kârtîbâ! ");
			      } 
			      catch (NegativeArraySizeException Neg) {
			         System.out.println("Izòçmums: " + Neg);
			         System.out.println("Tiek veidots masîvs ar negatîviem izmçriem!");
			      }	     finally {
			          System.out.println("Finally bloks - Piemçrs Nr.2."); 		
			      }
			    System.out.println();
			    
			    
			    try {
			          System.out.println("Finally bloks - ar return");
			          return;
			       } finally {
			         System.out.println("Finally bloks - Piemçrs Nr.3");
			       } 		     
	      }
	   }

	

