//22. mâjasdarbs - Elîna Mûrniece

enum Month {
    JANVARIS, FEBRUARIS, MARTS, APRILIS, MAIJS, JUNIJS, JULIJS, AUGUSTS, 
    SEPTEMBRIS, OKTOBRIS, NOVEMBRIS, DECEMBRIS
}

class EnumPiemers {
	Month month;
    
    public EnumPiemers (Month month) {
        this.month = month;
    }
    
    public void findSeason() {
        switch (month) {
            case JANVARIS: case FEBRUARIS: case DECEMBRIS:
                System.out.println("Ziema..");
                break;
                    
            case MARTS: case APRILIS: case MAIJS:
                System.out.println("Pavasaris ir burvîgs gadalaiks!");
                break;
                         
            case JUNIJS: case JULIJS: case AUGUSTS:
                System.out.println("Apsveicu - beidzot ir sâkusies vasara!");
                break;
                        
            default:
                System.out.println("Rudens jau ir sâcies..");
                break;
        }
    }
    
}



class Gener<T> {
    final Class<T> typeParameterClass;

    public Gener(Class<T> typeParameterClass) {
        this.typeParameterClass = typeParameterClass;
    }

    public String bar() {
    	String z = typeParameterClass.toGenericString();
    	System.out.println(z);
    	return z;
    }
}

class MansTips{
	
}

public class Md_22 {

	public static void main(String[] args) {
		
		 EnumPiemers x1 = new EnumPiemers(Month.MARTS);
	     x1.findSeason();
	     EnumPiemers x2 = new EnumPiemers(Month.JUNIJS);
	     x2.findSeason();
	     EnumPiemers x3 = new EnumPiemers(Month.OKTOBRIS);
	     x3.findSeason();
	     EnumPiemers x4 = new EnumPiemers(Month.JANVARIS);
	     x4.findSeason();
	     EnumPiemers x5 = new EnumPiemers(Month.MAIJS);
	     x5.findSeason();
		
		
		Gener<String> t = new Gener<String>(String.class);
		t.bar();
		
		
		MansTips mt = new MansTips();
		Gener<MansTips> t2 = new Gener<MansTips>(MansTips.class);
		t2.bar();
			
	}

}
