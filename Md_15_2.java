//15.2 mâjasdarbs - Elîna Mûrniece

import java.util.*;

class Noverotajs implements Observer {
	   public void update(Observable obj, Object arg) {
	      System.out.println(" Metode update(), rezultats ir " + ((Integer)arg).intValue());
	   }
	}

class Noverojamais extends Observable {
	   void counter(int z) {
	      for (; z>=0; z = z-3) {
	         setChanged();
	         notifyObservers(new Integer(z));
	         try {
	            Thread.sleep(300);
	         } catch (InterruptedException e) {
	           System.out.println(e);
	         }
	      }
	   }
	}

// java.util pakotnes servisa klases metodes


public class Md_15_2 {

	public static void main(String[] args) {

		//StringTokenizer klase
		StringTokenizer x1 = new StringTokenizer("Ab Bc Cd Ef Gh");
		
		System.out.println("Analizejamo leksemu skaits:  " + x1.countTokens());

	      while(x1.hasMoreTokens()) {
	         String val = x1.nextToken();
	         System.out.println(val + "\t");
	      }
	      
	     //BitSet klase
	      BitSet x2 = new BitSet(10);
	      for (int i=0; i<10; i++) {
	          if ((i%3) == 0) x2.set(i);
	       }
	      System.out.println(" Bitset saturs: " + x2);
	      System.out.println(" Bitset length: " + x2.length());
	      System.out.println(" Bitset size: " + x2.size());

	      x2.clear(3);
	      System.out.println(" Bitset saturs: " + x2);
	      
	     //Date klase
	      Date x3 = new Date();
	      Date x4 = new Date(475798357);
	      System.out.println(x3);
	      System.out.println(x4);
	      System.out.println("Milisekundes no 1970.gada 1.janvara -> " + x3.getTime());
	      System.out.println("After metode -> " + x3.after(x4));
	      System.out.println("CompareTo metode -> " + x4.compareTo(x3));
	      
	     //Calendar klase
	      Calendar x5 = Calendar.getInstance();
	      System.out.println("Time: " + x5.getTime());
	      System.out.println("TimeZone: " + x5.getTimeZone());
	      System.out.println("Gads: "+ x5.get(Calendar.YEAR));
	      
	     //GregorianCalendar klase
	      GregorianCalendar x6 = new GregorianCalendar();
	      System.out.println("Datums: "+ x6.get(Calendar.DATE));
	      System.out.println("Mçnesis: "+ x6.get(Calendar.MONTH));
	      System.out.println("Laiks: " + x6.get(Calendar.HOUR) + ":" +  x6.get(Calendar.MINUTE));
	      System.out.println("Garais gads -> "+ x6.isLeapYear(Calendar.MONTH));
	      
	     //TimeZone klase
	      TimeZone x7 = TimeZone.getDefault();
	      System.out.println(x7);
	      System.out.println("Nobide no GMT milisekundes: "+ x7.getRawOffset());
	      System.out.println("Vasaras laiks -> "+ x7.observesDaylightTime());
	      System.out.println("ID: "+ x7.getID());
	      
	     //SimpleTimeZone klase
	      SimpleTimeZone x8 = new SimpleTimeZone(0, "Portugal");
	      System.out.println("Nobide no GMT milisekundes: "+ x8.getRawOffset());
	      System.out.println("ID: "+ x8.getID());
	      
	      String[] y = TimeZone.getAvailableIDs(0);      
	      System.out.println("Id 0 : ");
	      for (int i=0; i<y.length; i++){
	      System.out.println(y[i]);
	      } 
	      
	     //Locale klase
	      Locale x9 = Locale.getDefault();
	      System.out.println("Country: "+ x9.getDisplayCountry());
	      System.out.println("Name: "+ x9.getDisplayName());
	      System.out.println("Language: "+ x9.getDisplayLanguage());
	      
	     //Random klase
	      Random x10 = new Random();
	      System.out.println("Random - nextFloat metode -> "+ x10.nextFloat());
	      System.out.println("Random - nextInt metode -> "+ x10.nextInt());
	      System.out.println("Random - nextBoolean metode -> "+ x10.nextBoolean());
	      
	     //Observable klase
	      	  Noverojamais observed = new Noverojamais();
	          Noverotajs observing = new Noverotajs();
	          observed.addObserver(observing);
	          observed.counter(15);
	      
	}
}
