//10.m�jasdarbs - El�na M�rniece

 //sava iz��muma nodefin��ana	
class MansIznemums extends Exception {
   private int detail;

   MansIznemums (int v) {
      detail = v;
   }

   public String toString() {
      return "Mans Iz��mums ar parametru: [" + detail + "]. V�rt�ba ir maz�ka par 49!";
   }
}

public class Md_10 {
	   static void min_vertiba_49 (int v) throws MansIznemums {
		      System.out.println("Izsaukta min_vertiba_49(" + v + ")");
		      if (v<49)
		         throw new MansIznemums(v);
		      System.out.println("V�rt�ba ir liel�ka par 49 - viss k�rt�b�!");
		   }
	   
	   
	public static void main(String[] args) {
		
		  //sava iz��muma realiz��ana		    
	    try {
	    	min_vertiba_49(55);
	    	min_vertiba_49(13);
	      } catch (MansIznemums e) {
	        System.out.println ("Izdodam iz��mumu: " + e);
	      }
        System.out.println();
        
		//3 nekontrol�jamo iz��mumu (exceptions) apstr�de
		
		int x, y, z;
	      try{
	         x = 49;
	         y = 49;
	         z = 107 / (x-y);
	         System.out.println("Bez k��d�m! ");
	      } 
	      catch (ArithmeticException A) {
	         System.out.println("Iz��mums: " + A);
	         System.out.println("Dal�t ar nulli nedr�kst!");
	         System.out.println();
	      }
	      
		 int tabula [] = new int [3];
		      try{
		         tabula [0] = 0;
		         tabula [1] = 1;
		         tabula [2] = 2;
		         tabula [3] = 3;
		         System.out.println("Viss k�rt�b�! ");
		      } 
		      catch (ArrayIndexOutOfBoundsException Arr) {
		         System.out.println("Iz��mums: " + Arr);
		         System.out.println("Mas�va indekss atrodas �rpus defin�ta mas�va robe��m!");
		         System.out.println();
		      }
		      
		      
			    try{
					 int tabulaex [] = new int [-2];
			         System.out.println("Viss k�rt�b�! ");
			      } 
			      catch (NegativeArraySizeException Neg) {
			         System.out.println("Iz��mums: " + Neg);
			         System.out.println("Tiek veidots mas�vs ar negat�viem izm�riem!");
			      }	     finally {
			          System.out.println("Finally bloks - Piem�rs Nr.1."); 		  //finally bloka pielietojums
			      }
			    System.out.println();
			    
		  //v�l 2 finally bloka pielietojumi
			    
			    try{
					 int tabulaex2 [] = new int [3];
			         System.out.println("Viss k�rt�b�! ");
			      } 
			      catch (NegativeArraySizeException Neg) {
			         System.out.println("Iz��mums: " + Neg);
			         System.out.println("Tiek veidots mas�vs ar negat�viem izm�riem!");
			      }	     finally {
			          System.out.println("Finally bloks - Piem�rs Nr.2."); 		
			      }
			    System.out.println();
			    
			    
			    try {
			          System.out.println("Finally bloks - ar return");
			          return;
			       } finally {
			         System.out.println("Finally bloks - Piem�rs Nr.3");
			       } 		     
	      }
	   }

	

