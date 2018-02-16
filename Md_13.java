//13.m�jasdarbs - El�na M�rniece

public class Md_13 {

	public static void main(String[] args) {
		
		//vismaz 10 da��das metodes no String klases
	      char X[] = {'X', 'y', 'z', 'v', 'Q'};
	      String Test =new String(X);
	      String str =new String("ghhstkkuskr");
	      String str2 =new String("GhHstkKuskr");
	      
	      System.out.println(Test);
	      System.out.println("Length metode: "+ Test.length());
	      System.out.println(str.length());
	      
	      System.out.println("charAt metode: " + str.charAt(3));
	      
	      System.out.println("Izmantojot equals metodi: "+ str + " = " + str2 + "->" + str.equals(str2));
	      System.out.println("Izmantojot equalsIgnoreCase metodi: "+ str + " = " + str2 + "->" + str.equalsIgnoreCase(str2));
	      
	      System.out.println("Izmantojot startsWidth metodi: " + Test.startsWith("yz", 1));
	      System.out.println("Izmantojot endsWidth metodi: " + str.endsWith("Skr"));
	      
	      System.out.println("Izmantojot compareTo metodi: " + Test.compareTo(str));
	      System.out.println("Izmantojot compareTo metodi: " + str.compareTo(str2));
	      
	      System.out.println("IndexOf metode ar parametru s: "+ str.indexOf("s"));
	      System.out.println("LastIndexOf metode ar parametru s: "+ str.lastIndexOf("s"));
	      
	      String c = Test.concat(str);
	      System.out.println("Concat metode: "+ Test + " + " + str +  " -> " + c);
	      
	      System.out.println("Replace metode -  aizvietot k ar Q: " + str2 +  " -> " + str2.replace("k", "Q"));
	      
	      String str3 =new String(" GhH stkKus kr ");
	      String str4 = str3.trim();
	      System.out.println("Trim metode:" + str3 +  "->" + str4);
	      
	      String strL = str2.toLowerCase();
	      System.out.println("toLowerCase metode: " + str2 +  " -> " + strL);
		
	      String strU = str.toUpperCase();
	      System.out.println("toUpperCase metode: " + str +  " -> " + strU);
	      System.out.println();
	      
		//vismaz 10 da��das metodes no StringBuffer klases
	      StringBuffer sb = new StringBuffer("Labdien!!!");
	      System.out.println("Length metode: "+ sb.length());
	      System.out.println("Capacity metode: "+ sb.capacity());
	      
	      sb.ensureCapacity(35);
	      System.out.println("Capacity p�c ensureCapacity metodes: "+ sb.capacity());
	      
	      sb.setLength(8);
	      System.out.println(sb);
	      System.out.println("Length metode p�c setLength metodes: "+ sb.length());
	      System.out.println("Capacity metode p�c setLength metodes: "+ sb.capacity());
	      
	      System.out.println("charAt metode: "+ sb.charAt(3));
	      sb.setCharAt(3, 'Q');
	      System.out.println("charAt metode p�c setCharAt metodes: "+ sb.charAt(3));
	      System.out.println(sb);
	      
	      sb.insert(4, "ddd");
	      System.out.println("p�c Insert metodes: " + sb);
	      
	      sb.reverse();
	      System.out.println("p�c Reverse metodes: " + sb);
	      
	      sb.delete(5,8);
	      System.out.println("p�c Delete metodes: " + sb);
	      
	      StringBuffer sb2 = new StringBuffer("Rezult�ts nav ok.");
	      System.out.println("pirms replace metodes: " + sb2);
	      sb2.replace(10, 13, "ir");
	      System.out.println("p�c replace metodes: " + sb2);
	      
	      System.out.println("substring metode: "+ sb2.substring(13,15));
			
	}
}
