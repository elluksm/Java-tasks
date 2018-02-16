//14.mâjasdarbs - Elîna Mûrniece

class TestClass implements Cloneable {
   int a;
   TestClass cloneT() {
	      try {
	         return (TestClass) super.clone();
	      } catch(CloneNotSupportedException e) {
	         System.out.println("Nevar klonet.");
	         return this;
	      }
	   }
}
    
public class Md_14 {

	public static void main(String[] args) {
		
		//Double klases metodes
		Double db = new Double(79.38751);
		Double db2 = new Double(70.38751);
		System.out.println("isInfinite -> " + db.isInfinite());
		System.out.println("byteValue -> " +db.byteValue());
		System.out.println(db.compareTo(db2));
		
		//Integer klases metodes
	      int y = 331156789;
	      System.out.println(y + " -> toBinaryString metode: " + Integer.toBinaryString(y));
	      System.out.println(y + " -> toOctalString metode: " + Integer.toOctalString(y));
	      System.out.println(y + " -> toHexString metode: " + Integer.toHexString(y));
	      
	     //Character klases metodes
	      char c = 'f';
	      System.out.println(c + " ir Unicode simbols -> " + Character.isDefined(c));
	      System.out.println(c + " ir Uppercase -> " + Character.isUpperCase(c));
	      System.out.println(c + " Uppercase -> " + Character.toUpperCase(c));
	      
	    //Runtime klase
	      Runtime rt = Runtime.getRuntime();
	      System.out.println("free Memory baitos: " + rt.freeMemory());
	      System.out.println("total Memory baitos: " + rt.totalMemory());
	      
	      //System klase
	      System.out.println("currentTimeMillis metode: " + System.currentTimeMillis());
	      System.out.println("run-time sistemas ipasibas: " + System.getProperties());
	      
	      //Math klase
	      System.out.println("Funkcijas y^x vçrtîba (3^4): " + Math.pow(3,4));
	      System.out.println("Kvadrâtsaknes vçrtîba no 64: " + Math.sqrt(64));
	      System.out.println("Noapalosana: " + Math.round(64.879));
	      System.out.println("Random skaitlis no 0 lidz 1: " + Math.random());
	      
	      //Package klase
	      Package p[];
	      p = Package.getPackages();
	      for (int i = 0; i < p.length; i++)
	         System.out.println(p[i].getName() + " " + p[i].getImplementationTitle());
	      
	      //Class klase
	      TestClass z = new TestClass();
	      Class zObj;
	      zObj = z.getClass();
	      System.out.println(zObj.getName() + " tipa objekts");   
	      System.out.println(zObj.isInterface());  
	   
	      //Boolean klase
	      Boolean b = new Boolean (true);
	      System.out.println("Boolean vçrtîba: " + b.booleanValue()); 
	      System.out.println("Hash kods: " + b.hashCode());
	      System.out.println("boolString vçrtîba: " + Boolean.valueOf("False"));
	      
	      //Object klase
	      TestClass v;
	      v = (TestClass)z.cloneT();
	      System.out.println("Objekta apraksts: " + v.toString());
	      System.out.println("Hash kods: " + v.hashCode());
		
		// 4 metodes no interneta
	      System.out.println("Kuba saknes vçrtîba no 64: " + Math.cbrt(64));
	      System.out.println("nextUp metode: " + Math.nextUp(64));
	      System.out.println("sqrt(x^2 +y^2): " + Math.hypot(64, 3));
	      System.out.println("ex^-1.: " + Math.expm1(64));
		
	}
}
