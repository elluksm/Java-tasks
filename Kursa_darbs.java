import java.util.Scanner;

//superklase t�m klas�m, kuras atbild�gas par izv�li Nr. 1, 2, 3
class Zemesgabals {
	double Zemesgab_platiba; //Zemesgabala plat�ba
	final int i = 100; //konstante, kura tiek izmantota formul�s	
}
	
//klase, kas apr��ina apb�ves r�d�t�jus, t.i., izv�le Nr.1
class ApbuvesRaditaji extends Zemesgabals  {
	double Celu_lauk; //Ce�i un autost�vvietas - laukums
	double Apbuves_lauk; //�ku apb�ves laukums
	double Stavu_plat; //St�vu plat�ba

	ApbuvesRaditaji (double a, double b, double c, double d) {
		Zemesgab_platiba = a;
		Apbuves_lauk = b;
		Celu_lauk = c;
		Stavu_plat = d;
    }
	
    double ApbBlivums() {
	      return Apbuves_lauk * i / Zemesgab_platiba;  //Apr��ina Apb�ves bl�vumu zemesgabalam
    }
    
    double ApbIntens() {
	      return Stavu_plat * i / Zemesgab_platiba;  //Apr��ina Apb�ves intensit�ti zemesgabalam
    }
	
    double BrivTerit() {
	      return (Zemesgab_platiba - Apbuves_lauk - Celu_lauk) * i / Stavu_plat ;  //Apr��ina zemesgabala br�vo teritoriju
    }
    
    double Celi() {
	      return Celu_lauk * i / Zemesgab_platiba ;  //Apr��ina %, ko aiz�em ce�i zemesgabal�
    }
    
    double Apzalumojums() {
	      return Zemesgab_platiba - Apbuves_lauk -  Celu_lauk;  //Apr��ina m2, ko aiz�em apza�umojums zemesgabal�
  }
    
    double ZalTerit() {
	      return (Zemesgab_platiba - Apbuves_lauk -  Celu_lauk) * i / Zemesgab_platiba ;  //Apr��ina %, ko aiz�em apza�umojums zemesgabal�
    }
    
    
}

//klase, kas apr��ina max apb�ves laukumu, t.i. izv�le Nr.2
class MaxApbuvesLauk extends Zemesgabals {
	double Apbuv_blivums; //Apb�ves bl�vums
	
    MaxApbuvesLauk (double a, double f) {
		Zemesgab_platiba = a;
		Apbuv_blivums = f;
    }
    
    double ApbLauk() {
	      return Apbuv_blivums * Zemesgab_platiba / i;  //Apr��ina maksim�lo apb�ves laukumu, ja dots zemesgabala maksim�lais apb�ves bl�vums
    }
	void info(){
	   	  System.out.println("Dotie parametri: Zemesgabala plat�ba -  " + Zemesgab_platiba + "m2;   Apb�ves bl�vums - " + Apbuv_blivums + "%" );
	      return;
	 }
}

//klase, kas apr��ina max st�vu plat�bu, t.i. izv�le Nr.3
class MaxStavuPlat extends Zemesgabals {
	double Apb_intens; //Apb�ves intensit�te
	
	MaxStavuPlat (double a, double g) {
			Zemesgab_platiba = a;
			Apb_intens = g;
	  }
	
    double StavPlat() {
	      return Apb_intens * Zemesgab_platiba / i;  //Apr��ina  maksim�lo st�vu plat�bu, ja dota zemesgabala maksim�l� apb�ves intensit�te
  }
  
	void info(){
	   	  System.out.println("Dotie parametri: Zemesgabala plat�ba -  " + Zemesgab_platiba + "m2; Apb�ves intensit�te - " + Apb_intens + "%" );
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

//apak�klase taisnst�rveida telpu apr��inam, t.i. izv�le Nr.4
class TaisnTelpa extends Telpa implements SienasPlat{
	double platums;
	double garums;

	TaisnTelpa (double i, double j, double k, double l, double m) {
		super (k, l, m);
		platums = i;
		garums = j;
    }
	
	double Perimetrs () {
		return 2* (platums + garums);  //apr��ina telpas perimetru
	}
	
	public double SienuPlat () {
		return (2 * platums * Griestu_H) + (2 * garums * Griestu_H) - Logu_Plat - Durvju_Plat;  //apr��ina telpas sienu plat�bu
	}
}

//apak�klase neregul�ru telpu apr��inam, t.i. izv�le Nr.5
class NeregTelpa extends Telpa implements SienasPlat {
	double perimetrs;
	
	NeregTelpa (double i, double k, double l, double m) {
		super (k, l, m);
		perimetrs = i;
    }
	
	public double SienuPlat () {
		return (perimetrs * Griestu_H)- Logu_Plat - Durvju_Plat;  //apr��ina telpas sienu plat�bu
	}
}


public class Kursa_darbs {

	public static void main(String[] args) {

		System.out.println("L�dzu izv�lieties nepiecie�amo apr��inu, ievadot attiec�go ciparu! ");
		System.out.println("1 - Apr��in�t apb�ves tehniskos r�d�t�jus ");
		System.out.println("2 - Apr��in�t maksim�lo apb�ves laukumu, ja dots zemesgabala maksim�lais apb�ves bl�vums");
		System.out.println("3 - Apr��in�t maksim�lo st�vu plat�bu, ja dota zemesgabala maksim�l� apb�ves intensit�te");
		System.out.println("4 - Apr��in�t taisnst�rveida telpas sienas apdares materi�la plat�bu un telpas perimetru");
		System.out.println("5 - Apr��in�t neregul�ras telpas vai telpas da�as sienas apdares materi�la plat�bu un perimetru");
				
		// Datu ievade no klaviat�ras
		Scanner dati = new Scanner(System.in);
		int Izvele;
		Izvele = dati.nextInt();
		
	    while (Izvele > 5 || Izvele < 1 ){  //p�rbaude, vai izv�l�ts viens no apr��iniem
			System.out.println("L�dzu izv�lieties nepiecie�amo apr��inu, ievadot attiec�go ciparu no 1 l�dz 5! ");
		    Izvele = dati.nextInt();
		    }
		
		switch (Izvele) {
			case 1: 	  //Izv�le Nr.1

				System.out.println("L�dzu ievadiet zemesgabala plat�bu (m2)!");
			    double A1;
			    A1 = dati.nextDouble();
			    
				System.out.println("L�dzu ievadiet apb�ves laukumu (m2)!");
			    double A2;
			    A2 = dati.nextDouble();
			    
				System.out.println("L�dzu ievadiet m2, ko aiz�em ce�i un autost�vvietas!");
			    double A3;
			    A3 = dati.nextDouble();
			    
				System.out.println("L�dzu ievadiet st�vu plat�bu (m2)!");
			    double A4;
			    A4 = dati.nextDouble();
				
				ApbuvesRaditaji A = new ApbuvesRaditaji (A1, A2, A3, A4);
				
				System.out.println("Zemesgabala plat�ba: "+ A1 + "m2");
				System.out.println("Apb�ves laukums: "+ A2 + "m2        " + A.ApbBlivums() + "%");
				System.out.println("Ce�i un autost�vvietas: "+ A3 + "m2        " + A.Celi() + "%");
				System.out.println("Apza�umojums: " + A.Apzalumojums() + "m2        " + A.ZalTerit() + "%");
				System.out.println("St�vu plat�ba: " + A4 + "m2");
				System.out.println();
				
			    System.out.println("Apb�ves bl�vums ir:  " + A.ApbBlivums() + "%");
			    System.out.println("Apb�ves intensit�te ir:  " + A.ApbIntens() + "%");
			    System.out.println("Br�v� teritorija ir:  " + A.BrivTerit() + "%");
				break;
			
			case 2:		  //Izv�le Nr.2
			    System.out.println("L�dzu ievadiet zemesgabala plat�bu (m2)!");
			    double B1;
			    B1 = dati.nextDouble();
			    
			    System.out.println("L�dzu ievadiet maksim�lo at�auto zemesgabala apb�ves b�vumu (%)!");
			    double B2;
			    B2 = dati.nextDouble();
			    
			    MaxApbuvesLauk B = new MaxApbuvesLauk (B1, B2);
			    
			    B.info(); //izsaucam metodi info no apak�klases MaxApbuvesLauk
			    System.out.println("Apr��in�tais Max apb�ves laukums ir:  " + B.ApbLauk() + "m2");
				break;
			
			case 3:		  //Izv�le Nr.3
			    System.out.println("L�dzu ievadiet zemesgabala plat�bu!");
			    double C1;
			    C1 = dati.nextDouble();
			    
			    System.out.println("L�dzu ievadiet maksim�lo at�auto zemesgabala apb�ves intensit�ti (%)!");
			    double C2;
			    C2 = dati.nextDouble();
			    
			    MaxStavuPlat C = new MaxStavuPlat (C1, C2);
			    
			    C.info(); //izsaucam metodi info no apak�klases MaxStavuPlat
			    System.out.println("Apr��in�t� Max st�vu plat�ba ir:  " + C.StavPlat() + "m2");
				break;
			
			case 4:			  //Izv�le Nr.4
			    System.out.println("L�dzu ievadiet telpas platumu (m)!");
			    double D1;
			    D1 = dati.nextDouble();
			    
			    System.out.println("L�dzu ievadiet telpas garumu (m)!");
			    double D2;
			    D2 = dati.nextDouble();
			    
			    System.out.println("L�dzu ievadiet telpas griestu augstumu (m)!");
			    double D3;
			    D3 = dati.nextDouble();
			    
			    int Logu_sk;
			    System.out.println("L�dzu ievadiet logu skaitu!");
			    Logu_sk = dati.nextInt();
				System.out.println("Logu skaits:  " + Logu_sk);
				
				//Logu plat�bas apr��ins
				double Logi[][]= new double [Logu_sk][2]; //mas�vs ar logu izm�riem
				for (int x=0; x<Logu_sk; x++) {
					System.out.println("L�dzu ievadiet " + (x+1) +". loga platumu (m): ");
					Logi[x][0] = dati.nextDouble();
					System.out.println("L�dzu ievadiet " + (x+1) +". loga augstumu (m): ");
					Logi[x][1] = dati.nextDouble();
				}
				double L_plat=0;
				for (int x=0; x<Logu_sk; x++) {
					L_plat = L_plat + (Logi[x][0]*Logi[x][1]);
				}
			    System.out.println("Logu plat�ba: " + L_plat + "m2");
				    
				//Durvju plat�bas apr��ins
			    int Durvju_sk;
			    System.out.println("L�dzu ievadiet durvju skaitu!");
			    Durvju_sk = dati.nextInt();
			    while (Durvju_sk<= 0){  //p�rbaude, vai ievad�tais durvju skaits ir vismaz 1
				    System.out.println("L�dzu ievadiet durvju skaitu - telp� j�b�t vismaz vien�m durv�m!"); 
				    Durvju_sk = dati.nextInt();
				    }

				System.out.println("Durvju skaits:  " + Durvju_sk);
				
				double Durvis[][]= new double [Durvju_sk][2]; //mas�vs ar durvju izm�riem
				for (int x=0; x<Durvju_sk; x++) {
					System.out.println("L�dzu ievadiet " + (x+1) +". durvju platumu (m): ");
					Durvis[x][0] = dati.nextDouble();
					System.out.println("L�dzu ievadiet " + (x+1) +". durvju augstumu (m): ");
					Durvis[x][1] = dati.nextDouble();
				}
					
				double D_plat=0;
				for (int x=0; x<Durvju_sk; x++) {
					D_plat = D_plat + (Durvis[x][0]*Durvis[x][1]);
				}
			    System.out.println("Durvju plat�ba: " + D_plat + "m2");
			    
			    TaisnTelpa D = new TaisnTelpa (D1, D2, D3, L_plat,D_plat);
			    System.out.println("Telpas perimetrs ir:  " + D.Perimetrs());
			    System.out.println("Telpas sienu plat�ba ir:  " + D.SienuPlat());
				break;
			
			case 5:		  //Izv�le Nr.5
			    System.out.println("L�dzu ievadiet sienu fragmentu skaitu!");
			    int Frag_sk;
			    Frag_sk = dati.nextInt();
			    
				double Sienas[]= new double [Frag_sk]; //mas�vs ar sienu fragmentu garumiem
				for (int x=0; x<Frag_sk; x++) {
					System.out.println("L�dzu ievadiet " + (x+1) +". sienas fragmenta garumu (m): ");
					Sienas[x] = dati.nextDouble();
				}
				
				double E1=0;
				for (int x=0; x<Frag_sk; x++) {
					E1 = E1 + Sienas[x];
				}
			    
			    System.out.println("L�dzu ievadiet telpas griestu augstumu (m)!");
			    double E2;
			    E2 = dati.nextDouble();
			    
			    int Logu_sk2;
			    System.out.println("L�dzu ievadiet logu skaitu!");
			    Logu_sk2 = dati.nextInt();
				System.out.println("Logu skaits:  " + Logu_sk2);
				
				//Logu plat�bas apr��ins
				double Logi2[][]= new double [Logu_sk2][2]; //mas�vs ar logu izm�riem
				for (int x=0; x<Logu_sk2; x++) {
					System.out.println("L�dzu ievadiet " + (x+1) +". loga platumu (m): ");
					Logi2[x][0] = dati.nextDouble();
					System.out.println("L�dzu ievadiet " + (x+1) +". loga augstumu (m): ");
					Logi2[x][1] = dati.nextDouble();
				}
				double E3=0;
				for (int x=0; x<Logu_sk2; x++) {
					E3 = E3 + (Logi2[x][0]*Logi2[x][1]);
				}
			    System.out.println("Logu plat�ba: " + E3 + "m2");
				    
				//Durvju plat�bas apr��ins
			    int Durvju_sk2;
			    System.out.println("L�dzu ievadiet durvju skaitu!");
			    Durvju_sk2 = dati.nextInt();
				System.out.println("Durvju skaits:  " + Durvju_sk2);
				
				double Durvis2[][]= new double [Durvju_sk2][2]; //mas�vs ar durvju izm�riem
				for (int x=0; x<Durvju_sk2; x++) {
					System.out.println("L�dzu ievadiet " + (x+1) +". durvju platumu (m): ");
					Durvis2[x][0] = dati.nextDouble();
					System.out.println("L�dzu ievadiet " + (x+1) +". durvju augstumu (m): ");
					Durvis2[x][1] = dati.nextDouble();
				}
					
				double E4=0;
				for (int x=0; x<Durvju_sk2; x++) {
					E4 = E4 + (Durvis2[x][0]*Durvis2[x][1]);
				}
			    System.out.println("Durvju plat�ba: " + E4 + "m2");
			    
			    NeregTelpa E = new NeregTelpa (E1, E2, E3, E4);
			    System.out.println("Telpas perimetrs ir:  " + E1);
			    System.out.println("Telpas sienu plat�ba ir:  " + E.SienuPlat());
				break;
		}
        
		dati.close();
	    System.out.println();
        System.out.println("Programmas beigas. ");
	}
}
