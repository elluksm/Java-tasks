import java.util.Scanner;

//superklase tâm klasçm, kuras atbildîgas par izvçli Nr. 1, 2, 3
class Zemesgabals {
	double Zemesgab_platiba; //Zemesgabala platîba
	final int i = 100; //konstante, kura tiek izmantota formulâs	
}
	
//klase, kas aprçíina apbûves râdîtâjus, t.i., izvçle Nr.1
class ApbuvesRaditaji extends Zemesgabals  {
	double Celu_lauk; //Ceïi un autostâvvietas - laukums
	double Apbuves_lauk; //Çku apbûves laukums
	double Stavu_plat; //Stâvu platîba

	ApbuvesRaditaji (double a, double b, double c, double d) {
		Zemesgab_platiba = a;
		Apbuves_lauk = b;
		Celu_lauk = c;
		Stavu_plat = d;
    }
	
    double ApbBlivums() {
	      return Apbuves_lauk * i / Zemesgab_platiba;  //Aprçíina Apbûves blîvumu zemesgabalam
    }
    
    double ApbIntens() {
	      return Stavu_plat * i / Zemesgab_platiba;  //Aprçíina Apbûves intensitâti zemesgabalam
    }
	
    double BrivTerit() {
	      return (Zemesgab_platiba - Apbuves_lauk - Celu_lauk) * i / Stavu_plat ;  //Aprçíina zemesgabala brîvo teritoriju
    }
    
    double Celi() {
	      return Celu_lauk * i / Zemesgab_platiba ;  //Aprçíina %, ko aizòem ceïi zemesgabalâ
    }
    
    double Apzalumojums() {
	      return Zemesgab_platiba - Apbuves_lauk -  Celu_lauk;  //Aprçíina m2, ko aizòem apzaïumojums zemesgabalâ
  }
    
    double ZalTerit() {
	      return (Zemesgab_platiba - Apbuves_lauk -  Celu_lauk) * i / Zemesgab_platiba ;  //Aprçíina %, ko aizòem apzaïumojums zemesgabalâ
    }
    
    
}

//klase, kas aprçíina max apbûves laukumu, t.i. izvçle Nr.2
class MaxApbuvesLauk extends Zemesgabals {
	double Apbuv_blivums; //Apbûves blîvums
	
    MaxApbuvesLauk (double a, double f) {
		Zemesgab_platiba = a;
		Apbuv_blivums = f;
    }
    
    double ApbLauk() {
	      return Apbuv_blivums * Zemesgab_platiba / i;  //Aprçíina maksimâlo apbûves laukumu, ja dots zemesgabala maksimâlais apbûves blîvums
    }
	void info(){
	   	  System.out.println("Dotie parametri: Zemesgabala platîba -  " + Zemesgab_platiba + "m2;   Apbûves blîvums - " + Apbuv_blivums + "%" );
	      return;
	 }
}

//klase, kas aprçíina max stâvu platîbu, t.i. izvçle Nr.3
class MaxStavuPlat extends Zemesgabals {
	double Apb_intens; //Apbûves intensitâte
	
	MaxStavuPlat (double a, double g) {
			Zemesgab_platiba = a;
			Apb_intens = g;
	  }
	
    double StavPlat() {
	      return Apb_intens * Zemesgab_platiba / i;  //Aprçíina  maksimâlo stâvu platîbu, ja dota zemesgabala maksimâlâ apbûves intensitâte
  }
  
	void info(){
	   	  System.out.println("Dotie parametri: Zemesgabala platîba -  " + Zemesgab_platiba + "m2; Apbûves intensitâte - " + Apb_intens + "%" );
	      return;
  }
}

interface SienasPlat {
	double SienuPlat ();
}

class Telpa{
	double Griestu_H;
	double Logu_Plat;
	double Durvju_Plat;
	
	Telpa (double k, double l, double m) {
		Griestu_H = k;
		Logu_Plat = l;
		Durvju_Plat = m;
}
} 

//apakðklase taisnstûrveida telpu aprçíinam, t.i. izvçle Nr.4
class TaisnTelpa extends Telpa implements SienasPlat{
	double platums;
	double garums;

	TaisnTelpa (double i, double j, double k, double l, double m) {
		super (k, l, m);
		platums = i;
		garums = j;
    }
	
	double Perimetrs () {
		return 2* (platums + garums);  //aprçíina telpas perimetru
	}
	
	public double SienuPlat () {
		return (2 * platums * Griestu_H) + (2 * garums * Griestu_H) - Logu_Plat - Durvju_Plat;  //aprçíina telpas sienu platîbu
	}
}

//apakðklase neregulâru telpu aprçíinam, t.i. izvçle Nr.5
class NeregTelpa extends Telpa implements SienasPlat {
	double perimetrs;
	
	NeregTelpa (double i, double k, double l, double m) {
		super (k, l, m);
		perimetrs = i;
    }
	
	public double SienuPlat () {
		return (perimetrs * Griestu_H)- Logu_Plat - Durvju_Plat;  //aprçíina telpas sienu platîbu
	}
}


public class Kursa_darbs {

	public static void main(String[] args) {

		System.out.println("Lûdzu izvçlieties nepiecieðamo aprçíinu, ievadot attiecîgo ciparu! ");
		System.out.println("1 - Aprçíinât apbûves tehniskos râdîtâjus ");
		System.out.println("2 - Aprçíinât maksimâlo apbûves laukumu, ja dots zemesgabala maksimâlais apbûves blîvums");
		System.out.println("3 - Aprçíinât maksimâlo stâvu platîbu, ja dota zemesgabala maksimâlâ apbûves intensitâte");
		System.out.println("4 - Aprçíinât taisnstûrveida telpas sienas apdares materiâla platîbu un telpas perimetru");
		System.out.println("5 - Aprçíinât neregulâras telpas vai telpas daïas sienas apdares materiâla platîbu un perimetru");
				
		// Datu ievade no klaviatûras
		Scanner dati = new Scanner(System.in);
		int Izvele;
		Izvele = dati.nextInt();
		
	    while (Izvele > 5 || Izvele < 1 ){  //pârbaude, vai izvçlçts viens no aprçíiniem
			System.out.println("Lûdzu izvçlieties nepiecieðamo aprçíinu, ievadot attiecîgo ciparu no 1 lîdz 5! ");
		    Izvele = dati.nextInt();
		    }
		
		switch (Izvele) {
			case 1: 	  //Izvçle Nr.1

				System.out.println("Lûdzu ievadiet zemesgabala platîbu (m2)!");
			    double A1;
			    A1 = dati.nextDouble();
			    
				System.out.println("Lûdzu ievadiet apbûves laukumu (m2)!");
			    double A2;
			    A2 = dati.nextDouble();
			    
				System.out.println("Lûdzu ievadiet m2, ko aizòem ceïi un autostâvvietas!");
			    double A3;
			    A3 = dati.nextDouble();
			    
				System.out.println("Lûdzu ievadiet stâvu platîbu (m2)!");
			    double A4;
			    A4 = dati.nextDouble();
				
				ApbuvesRaditaji A = new ApbuvesRaditaji (A1, A2, A3, A4);
				
				System.out.println("Zemesgabala platîba: "+ A1 + "m2");
				System.out.println("Apbûves laukums: "+ A2 + "m2        " + A.ApbBlivums() + "%");
				System.out.println("Ceïi un autostâvvietas: "+ A3 + "m2        " + A.Celi() + "%");
				System.out.println("Apzaïumojums: " + A.Apzalumojums() + "m2        " + A.ZalTerit() + "%");
				System.out.println("Stâvu platîba: " + A4 + "m2");
				System.out.println();
				
			    System.out.println("Apbûves blîvums ir:  " + A.ApbBlivums() + "%");
			    System.out.println("Apbûves intensitâte ir:  " + A.ApbIntens() + "%");
			    System.out.println("Brîvâ teritorija ir:  " + A.BrivTerit() + "%");
				break;
			
			case 2:		  //Izvçle Nr.2
			    System.out.println("Lûdzu ievadiet zemesgabala platîbu (m2)!");
			    double B1;
			    B1 = dati.nextDouble();
			    
			    System.out.println("Lûdzu ievadiet maksimâlo atïauto zemesgabala apbûves bîvumu (%)!");
			    double B2;
			    B2 = dati.nextDouble();
			    
			    MaxApbuvesLauk B = new MaxApbuvesLauk (B1, B2);
			    
			    B.info(); //izsaucam metodi info no apakðklases MaxApbuvesLauk
			    System.out.println("Aprçíinâtais Max apbûves laukums ir:  " + B.ApbLauk() + "m2");
				break;
			
			case 3:		  //Izvçle Nr.3
			    System.out.println("Lûdzu ievadiet zemesgabala platîbu!");
			    double C1;
			    C1 = dati.nextDouble();
			    
			    System.out.println("Lûdzu ievadiet maksimâlo atïauto zemesgabala apbûves intensitâti (%)!");
			    double C2;
			    C2 = dati.nextDouble();
			    
			    MaxStavuPlat C = new MaxStavuPlat (C1, C2);
			    
			    C.info(); //izsaucam metodi info no apakðklases MaxStavuPlat
			    System.out.println("Aprçíinâtâ Max stâvu platîba ir:  " + C.StavPlat() + "m2");
				break;
			
			case 4:			  //Izvçle Nr.4
			    System.out.println("Lûdzu ievadiet telpas platumu (m)!");
			    double D1;
			    D1 = dati.nextDouble();
			    
			    System.out.println("Lûdzu ievadiet telpas garumu (m)!");
			    double D2;
			    D2 = dati.nextDouble();
			    
			    System.out.println("Lûdzu ievadiet telpas griestu augstumu (m)!");
			    double D3;
			    D3 = dati.nextDouble();
			    
			    int Logu_sk;
			    System.out.println("Lûdzu ievadiet logu skaitu!");
			    Logu_sk = dati.nextInt();
				System.out.println("Logu skaits:  " + Logu_sk);
				
				//Logu platîbas aprçíins
				double Logi[][]= new double [Logu_sk][2]; //masîvs ar logu izmçriem
				for (int x=0; x<Logu_sk; x++) {
					System.out.println("Lûdzu ievadiet " + (x+1) +". loga platumu (m): ");
					Logi[x][0] = dati.nextDouble();
					System.out.println("Lûdzu ievadiet " + (x+1) +". loga augstumu (m): ");
					Logi[x][1] = dati.nextDouble();
				}
				double L_plat=0;
				for (int x=0; x<Logu_sk; x++) {
					L_plat = L_plat + (Logi[x][0]*Logi[x][1]);
				}
			    System.out.println("Logu platîba: " + L_plat + "m2");
				    
				//Durvju platîbas aprçíins
			    int Durvju_sk;
			    System.out.println("Lûdzu ievadiet durvju skaitu!");
			    Durvju_sk = dati.nextInt();
			    while (Durvju_sk<= 0){  //pârbaude, vai ievadîtais durvju skaits ir vismaz 1
				    System.out.println("Lûdzu ievadiet durvju skaitu - telpâ jâbût vismaz vienâm durvîm!"); 
				    Durvju_sk = dati.nextInt();
				    }

				System.out.println("Durvju skaits:  " + Durvju_sk);
				
				double Durvis[][]= new double [Durvju_sk][2]; //masîvs ar durvju izmçriem
				for (int x=0; x<Durvju_sk; x++) {
					System.out.println("Lûdzu ievadiet " + (x+1) +". durvju platumu (m): ");
					Durvis[x][0] = dati.nextDouble();
					System.out.println("Lûdzu ievadiet " + (x+1) +". durvju augstumu (m): ");
					Durvis[x][1] = dati.nextDouble();
				}
					
				double D_plat=0;
				for (int x=0; x<Durvju_sk; x++) {
					D_plat = D_plat + (Durvis[x][0]*Durvis[x][1]);
				}
			    System.out.println("Durvju platîba: " + D_plat + "m2");
			    
			    TaisnTelpa D = new TaisnTelpa (D1, D2, D3, L_plat,D_plat);
			    System.out.println("Telpas perimetrs ir:  " + D.Perimetrs());
			    System.out.println("Telpas sienu platîba ir:  " + D.SienuPlat());
				break;
			
			case 5:		  //Izvçle Nr.5
			    System.out.println("Lûdzu ievadiet sienu fragmentu skaitu!");
			    int Frag_sk;
			    Frag_sk = dati.nextInt();
			    
				double Sienas[]= new double [Frag_sk]; //masîvs ar sienu fragmentu garumiem
				for (int x=0; x<Frag_sk; x++) {
					System.out.println("Lûdzu ievadiet " + (x+1) +". sienas fragmenta garumu (m): ");
					Sienas[x] = dati.nextDouble();
				}
				
				double E1=0;
				for (int x=0; x<Frag_sk; x++) {
					E1 = E1 + Sienas[x];
				}
			    
			    System.out.println("Lûdzu ievadiet telpas griestu augstumu (m)!");
			    double E2;
			    E2 = dati.nextDouble();
			    
			    int Logu_sk2;
			    System.out.println("Lûdzu ievadiet logu skaitu!");
			    Logu_sk2 = dati.nextInt();
				System.out.println("Logu skaits:  " + Logu_sk2);
				
				//Logu platîbas aprçíins
				double Logi2[][]= new double [Logu_sk2][2]; //masîvs ar logu izmçriem
				for (int x=0; x<Logu_sk2; x++) {
					System.out.println("Lûdzu ievadiet " + (x+1) +". loga platumu (m): ");
					Logi2[x][0] = dati.nextDouble();
					System.out.println("Lûdzu ievadiet " + (x+1) +". loga augstumu (m): ");
					Logi2[x][1] = dati.nextDouble();
				}
				double E3=0;
				for (int x=0; x<Logu_sk2; x++) {
					E3 = E3 + (Logi2[x][0]*Logi2[x][1]);
				}
			    System.out.println("Logu platîba: " + E3 + "m2");
				    
				//Durvju platîbas aprçíins
			    int Durvju_sk2;
			    System.out.println("Lûdzu ievadiet durvju skaitu!");
			    Durvju_sk2 = dati.nextInt();
				System.out.println("Durvju skaits:  " + Durvju_sk2);
				
				double Durvis2[][]= new double [Durvju_sk2][2]; //masîvs ar durvju izmçriem
				for (int x=0; x<Durvju_sk2; x++) {
					System.out.println("Lûdzu ievadiet " + (x+1) +". durvju platumu (m): ");
					Durvis2[x][0] = dati.nextDouble();
					System.out.println("Lûdzu ievadiet " + (x+1) +". durvju augstumu (m): ");
					Durvis2[x][1] = dati.nextDouble();
				}
					
				double E4=0;
				for (int x=0; x<Durvju_sk2; x++) {
					E4 = E4 + (Durvis2[x][0]*Durvis2[x][1]);
				}
			    System.out.println("Durvju platîba: " + E4 + "m2");
			    
			    NeregTelpa E = new NeregTelpa (E1, E2, E3, E4);
			    System.out.println("Telpas perimetrs ir:  " + E1);
			    System.out.println("Telpas sienu platîba ir:  " + E.SienuPlat());
				break;
		}
        
		dati.close();
	    System.out.println();
        System.out.println("Programmas beigas. ");
	}
}
