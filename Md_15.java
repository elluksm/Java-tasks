//15.1 mâjasdarbs - Elîna Mûrniece

//Darbs ar kolekcijâm

import java.util.*;
class Elina {
   private String name;
   private String country;
   private Double tempJuly;
   private Double seaTempJuly;

   Elina (String a, String b, Double c, Double d) {
      name = a;
      country = b;
      tempJuly = c;
      seaTempJuly = d;
   }
   
   public String toString() {
	      return name + "\n" + country + "\n" +
	    		  tempJuly + " " + seaTempJuly;
	   }

   public String Name() {
	   return name; }
   
   public Double TempJuly() {
	   return tempJuly; }

   public Double SeaTempJuly() {
	   return seaTempJuly; }	
}

public class Md_15 {

	public static void main(String[] args) {
		
		 LinkedList islands = new LinkedList();

		//metodes kolekcijas objektu apstradei
		 
		// Pievienojam sarakstam elementus
		 islands.add(new Elina("Malta", "Malta", 27.2, 22.6));
		 islands.add(new Elina("Sardinia", "Italy", 24.7, 24.3));
		 islands.add(new Elina("Mallorca", "Spain", 25.7, 24.9));
		 islands.add(new Elina("Crete", "Greece", 26.1, 25.4));
		 
		 islands.addFirst(new Elina("Madeira", "Portugal", 22.2, 21.8));

		      Iterator itr = islands.iterator();
		      while(itr.hasNext()) {
		         Object element = itr.next();
		         System.out.println(element + "\n");
		      }
		      System.out.println();
		
		
		      System.out.println(" LinkedList izmers ir " + islands.size());
		      
		      System.out.println(" Otrais elements ir " + islands.get(1));
		      
		      System.out.println(" Pirmais elements ir " + islands.getFirst());
		      
		      System.out.println(" Pedejais elements ir " + islands.getLast());
		      
		      islands.remove(2);
		      System.out.println(" LinkedList izmers ir " + islands.size());
		      
		      islands.removeFirst();
		      islands.removeLast();
		      System.out.println(" LinkedList izmers ir " + islands.size());
		      System.out.println(" LinkedList satur " + islands );
		      
		      islands.clear();
		      System.out.println(" LinkedList ir tukss -> " + islands.isEmpty());	    
		
		      //algoritmi kolekcijas apstradei
		      
		      	 islands.add(new Elina("Madeira", "Portugal", 22.1, 21.8));
				 islands.add(new Elina("Sardinia", "Italy", 24.7, 24.3));
				 islands.add(new Elina("Mallorca", "Spain", 25.7, 24.9));

				 
		      Elina x;
		      int i=0;
		      double t=0;
		      itr = islands.iterator();
		      while(itr.hasNext()) {
		          Object elements = itr.next();
		          x = (Elina)elements;
		          t=x.TempJuly() - x.SeaTempJuly();
			       System.out.println(x.Name() + " -> Temperaturas atskiriba starp gaisu un udeni ->  " + t); 
		          i++ ;}
 
		      
		      Elina y;
		      int i1=0;
		      double t2=0;
		      String n = "0";
		      itr = islands.iterator();
		      while(itr.hasNext()) {
		          Object elements = itr.next();
		          y = (Elina)elements;
		          if (t2<y.SeaTempJuly()){
		        	  t2=y.SeaTempJuly(); 
		        	  n =  y.Name();
		          }
		          i1++ ;}
		       System.out.println("Maksimala udens temp = " + t2 + " -> " + n); 

	}
}
