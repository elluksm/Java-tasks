//19_1 m�jasdarbs - El�na M�rniece
//Notikumu apstr�de bez adapteriem

import java.awt.*;
import java.awt.event.*;
import java.applet.*;

/*
<applet code="Md_19_1" width=300 height=100>
</applet>
*/

public class Md_19_1 extends Applet implements MouseListener, KeyListener {

	   String m = "";

	   public void init() {
		      addMouseListener(this);	
		      addKeyListener(this);
		      requestFocus();
	   } 				

		//peles notikumu apstr�de
	   public void mouseClicked(MouseEvent me) {
		      setBackground(Color.blue);
		      setForeground(Color.white);
		      m = "Peles klik��u skaits:" + me.getClickCount();
		      repaint();
	   }
	
	   public void mouseEntered(MouseEvent me) {
		   	   setBackground(Color.gray);
		       m = "Peles ievads";
		       repaint();
	   }      
	   
	   public void mouseExited(MouseEvent me) {
		   	  setBackground(Color.lightGray);
		       m = "";
		       repaint();
		    }
	   
	   public void mousePressed(MouseEvent me) {
		       m = "Peles poga ir nospiesta";
		       repaint();
		    }
	   
	   public void mouseReleased(MouseEvent me) {
		    }
	   
		//klaviat�ras notikumu apstr�de	   
	   public void keyPressed(KeyEvent ke) {
		   setBackground(Color.red);
		   }

	   public void keyReleased(KeyEvent ke) {
		   }

	   public void keyTyped(KeyEvent ke) {
		      m = "Tika nospiests tausti��: " + ke.getKeyChar();
		      repaint();
		   }
	   
	   public void paint (Graphics g) {
		      g.drawString(m, 20, 40);
		   }   
}
