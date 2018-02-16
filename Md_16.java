//16.mâjasdarbs - Elîna Mûrniece

import java.io.*;

public class Md_16 {

	public static void main(String[] args) throws IOException, Exception {
		System.out.println("Lûdzu ievadiet tautasdziesmas tekstu (rindiòas atdalot ar Enter):");
		
		 //teksta ievada nolasisana
		  BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		  String tdzin[] = new String[4];
		  
	      for (int i=0; i<4; i++) {
	    	  tdzin [i] = br.readLine();
	       } 
	      
	      //teksta saglabasana faila
	      FileWriter  fw = new FileWriter("tautasdziesma.txt");
	      for (int i=0; i<4; i++) {
	    	  char buffer[] = new char[tdzin[i].length()];
	    	  tdzin[i].getChars(0, tdzin[i].length(), buffer, 0);
		      fw.write(buffer);
		      fw.write('\n');
	       } 

	      fw.close();
	      
	      //faila nolasisana
	      FileReader fr = new FileReader("tautasdziesma.txt");
	      BufferedReader br1 = new BufferedReader (fr);
	      String tdzout;

	      //teksta izvads
	      while ((tdzout = br1.readLine()) != null) {
	    	  PrintWriter pw = new PrintWriter(System.out, true);
	    	  pw.println(tdzout);
	      }

	      fr.close();
	     
	      //savas mapes izveide un 2 metodes, kas izvada informaciju par so mapi
		 
		File mape = new File("Elina_Murniece");

		if (!mape.exists()) {
		    boolean result = false;

		    try{
		    	mape.mkdir();
		        result = true;
		    } 
		    catch(SecurityException se){
		        System.out.println("Mape nav izveidota!"); 
		    }        
		    if(result) {    
		        System.out.println("Mape ir izveidota!");  
		    }
		}
		
		System.out.println("Mapes nosaukums: " + mape.getName());
		System.out.println("Iepriekseja limena katalogs: " + mape.getParent());
		System.out.println("Mape eksiste -> " + mape.exists());  
		System.out.println("Mape ir fails -> " + mape.isFile());  

	}
}

