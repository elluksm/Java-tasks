//19_2 m�jasdarbs - El�na M�rniece
//Notikumu apstr�de ar adapteriem

import java.awt.*;
import java.awt.event.*;
import java.applet.*;

/*
<applet code="Md_19_2" width=300 height=100>
</applet>
*/

public class Md_19_2 extends Applet {
	
	String s = "";
	   public void init() {
		      addMouseListener (new MyMouseAdapter(this));
		      addKeyListener (new MyKeyAdapter(this));
		   }
	   
	   public void paint (Graphics g) {
		      g.drawString(s, 20, 40);
	   }  	   		
}

class MyMouseAdapter extends MouseAdapter {

		//peles notikumu apstr�de
		Md_19_2 adapterApp;
	   public MyMouseAdapter(Md_19_2 adapterApp) {
	      this.adapterApp = adapterApp;
	   }

	   public void mouseClicked(MouseEvent me) {
		   adapterApp.setBackground(Color.blue);
		   adapterApp.setForeground(Color.white);
		   adapterApp.s = "Peles klik��u skaits:" + me.getClickCount();
		   adapterApp.repaint();
		}
	   
	   public void mouseEntered(MouseEvent me) {
		   adapterApp.setBackground(Color.gray);
		   adapterApp.s = "Peles ievads";
		   adapterApp.repaint();
	   }      

	   public void mouseExited(MouseEvent me) {
		   adapterApp.setBackground(Color.lightGray);
		   adapterApp.s = "";
		   adapterApp.repaint();
	  }	

	   public void mousePressed(MouseEvent me) {
		   adapterApp.s = "Peles poga ir nospiesta";
		   adapterApp.repaint();
	  }
	   
		}

class MyKeyAdapter extends KeyAdapter {
	   
		//klaviat�ras notikumu apstr�de
		Md_19_2 adapterApp;
	   public MyKeyAdapter(Md_19_2 adapterApp) {
	      this.adapterApp = adapterApp;
	   }

	   public void keyPressed(KeyEvent ke) {
		   adapterApp.setBackground(Color.red);
		   }

	   public void keyTyped(KeyEvent ke) {
		   adapterApp.s = "Tika nospiests tausti��: " + ke.getKeyChar();
		   adapterApp.repaint();
		   }	   	   
		}



