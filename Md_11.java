//11.mâjasdarbs - Elîna Mûrniece

//class x implement Runnable
class JaunsPavediensR implements Runnable {
    String name;
	Thread t;

	JaunsPavediensR(String threadname) {
	  name = threadname; 
      t = new Thread(this, name);
      System.out.println(" Jauns pavediens: " + t);
      t.start();		
   }

   public void run() {
      try {
         for (int i = 5; i>0; i--) {
             System.out.println( name + ":" + i);
             Thread.sleep(1000);
         }
      }  catch (InterruptedException e) {
          System.out.println(" Iznemums " + name);
      }
      System.out.println( name + ": pavediena beigas. ");
   }
}

//subclass extends Thread
class JaunsPavediensT extends Thread {
       String name;
    
       JaunsPavediensT(String threadname) {
	      super("Demo Pavediens");
	      name = threadname; 
	      System.out.println(" Jauns pavediens:  " + this);
	      start();		
	   }

	   public void run() {
	      try {
	         for (int i = 5; i>0; i--) {
	            System.out.println( name + ":" + i);
	            Thread.sleep(500);
	         }
	      }  catch (InterruptedException e) {
	         System.out.println(" Iznemums " + name);
	      }
	      System.out.println( name + ": pavediena beigas. ");
	   }
	}

//Nesinhronizçti pavedieni
class NesinhrPaved {
   void call (String m) {
      System.out.print("[" + m);
      try {
      Thread.sleep(500);
   }  catch (InterruptedException e ) {
      System.out.println("Pârtraukðana");
   }
   System.out.println("]");
}
}

class PavedPiemers implements Runnable {
   String m;
   NesinhrPaved target;
   Thread t;

public PavedPiemers (NesinhrPaved targ, String s) {
   target = targ;
   m = s;
   t = new Thread(this);
   t.start();
}

public void run() {
   target.call (m);
}
}

//Sinhronizçti pavedieni
class SinhrPaved {
  synchronized void call (String m) {
      System.out.print("[" + m);
      try {
      Thread.sleep(500);
   }  catch (InterruptedException e ) {
      System.out.println("Pârtraukðana");
 }
  System.out.println("]");
 }
}

class SinhrPavedPiemers implements Runnable {
   String m;
   SinhrPaved target2;
   Thread t;

public SinhrPavedPiemers (SinhrPaved targ, String s) {
    target2 = targ;
    m = s;
    t = new Thread(this);
    t.start();
}

public void run() {
	   target2.call (m);
   }
}


public class Md_11 {

	public static void main(String[] args) {
		//meitas pavedienu (thread) izveidoðana, izmantojot class x implement Runnable
		JaunsPavediensR P1 = new JaunsPavediensR("Pirmais pavediens - implement Runnable");		
		JaunsPavediensR P2 = new JaunsPavediensR("Otrais pavediens - implement Runnable");
		JaunsPavediensR P3 = new JaunsPavediensR("Treðais pavediens  - implement Runnable");
		
		//metodes isAlive() izmantoðana
	      System.out.println(" Izpildas pirmais pavediens - implement Runnable: " + P1.t.isAlive());
	      System.out.println(" Izpildas otrais pavediens - implement Runnable: " + P2.t.isAlive());
	      System.out.println(" Izpildas tresais pavediens - implement Runnable:  " + P3.t.isAlive());
	     
	   //meitas pavedienu (thread) izveidoðana, izmantojot subclass extends Thread
		JaunsPavediensT P4 =  new JaunsPavediensT("Pirmais pavediens - extends Thread");	
		JaunsPavediensT P5 =  new JaunsPavediensT("Pirmais pavediens - extends Thread");
		JaunsPavediensT P6 =  new JaunsPavediensT("Pirmais pavediens - extends Thread");
		 
		//metodes join() izmantoðana
	      try {
	          System.out.println(" Gaidam pavediena beigas ");
	          P1.t.join();
	          P2.t.join();
	          P3.t.join();
	          P4.join();
	          P5.join();
	          P6.join();
	        }  catch (InterruptedException e) {
	    	   System.out.println(" Izòçmums galvenajâ pavedienâ. ");
	        }
	      
			//metodes isAlive() izmantoðana
	      System.out.println(" Izpildas pirmais pavediens - implement Runnable: " + P1.t.isAlive());
	      System.out.println(" Izpildas otrais pavediens - implement Runnable: " + P2.t.isAlive());
	      System.out.println(" Izpildas tresais pavediens - implement Runnable:  " + P3.t.isAlive());
	           
	    	   System.out.println(" Galvenais pavediens ir beidzies.");
	    	   
	    	   
	    	 //Nesinhronizçti pavedieni	    	   
	    	      NesinhrPaved target = new NesinhrPaved();
	    	      PavedPiemers PP1 = new PavedPiemers (target, "Nesinhronizçtu");
	    	      PavedPiemers PP2 = new PavedPiemers (target, "pavedienu");
	    	      PavedPiemers PP3 = new PavedPiemers (target, "piemçrs");

	    	      try {
	    	         PP1.t.join();
	    	         PP2.t.join();
	    	         PP3.t.join();
	    	      }  catch(InterruptedException e) {
	    	         System.out.println(" Pârtraukums ");
	    	      }
	    	      
	    	      //Sinhronizçti pavedieni	    	   
	    	      SinhrPaved target2 = new SinhrPaved();
	    	      SinhrPavedPiemers PP4 = new SinhrPavedPiemers (target2, "Sinhronizçtu");
	    	      SinhrPavedPiemers PP5 = new SinhrPavedPiemers (target2, "pavedienu");
	    	      SinhrPavedPiemers PP6 = new SinhrPavedPiemers (target2, "piemçrs");

	    	      try {
	    	         PP4.t.join();
	    	         PP5.t.join();
	    	         PP6.t.join();
	    	      }  catch(InterruptedException e) {
	    	         System.out.println(" Pârtraukums ");
	    	      }
	}

}
