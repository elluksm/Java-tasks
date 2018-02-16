//18. mâjasdarbs - Elîna Mûrniece

import java.awt.*;
import java.awt.event.*;
import java.applet.*;
/*
   <applet code="Md_18_Frame" width=500 height=250>
   <param name=message value="Elina Murniece">
   </applet>
*/

//Frame apakðklases izveidoðana
class FrameF extends Frame {

	FrameF (String title) {
		      super(title);
		      MyWindowAdapter adapter = new MyWindowAdapter(this);
		      addWindowListener(adapter);
		   }
	
	int i;
	   public void paint (Graphics g) {
	      g.drawString("Frame logs", 10, 40);
	      
	    //piecas daþâdas figûras
	      g.drawRect (125, 125, 75, 75);
	      
	      g.fillRoundRect (50, 50, 90, 90, 30, 50);
	      
	      g.setColor(Color.blue);
	      g.fillOval (150, 50, 120, 90);
	      
	      g.setColor(Color.magenta);
	      int x2[] = {150, 220, 190};
	      int y2[] = {150, 220, 160};
	      g.drawPolygon (x2, y2, 3);
	      
	      g.setColor(Color.green);
	      int x[] = {50, 75, 100, 110, 150, 170};
	      int y[] = {150, 170, 190, 220, 230, 260};
	      g.drawPolygon (x, y, 6);
	   }
	}
	
class MyWindowAdapter extends WindowAdapter {
		FrameF FrameFr;
	   public MyWindowAdapter(FrameF FrameFr) {
	      this.FrameFr = FrameFr;
	   }
	   public void windowClosing (WindowEvent we) {
		   FrameFr.setVisible(false);
	   }
	}   
	   
//Frame loga izveidoðana
public class Md_18_Frame extends Applet implements Runnable {

	   String m;
	   Thread t = null;
	   int state;
	   boolean stopFlag;
	      
	   Frame f;
	   public void init() {
	      f = new FrameF (" Md_18_Frame ");
	      f.setSize(250, 250);
	      f.setVisible(true);
	      
	    //fona krâsas maiòa
	      Color c1 = new Color(189, 193, 201);
	      f.setBackground(c1);
	      
	    //fonta krâsas maiòa
	      f.setForeground(Color.white);
	   }
	   
	   public void start() {
		
		   //paziòojuma teksts caur HTML parametriem
		      m = getParameter("message");
		      if (m == null)
		         m = " Paziòojums";
		      m = " " + m;
		      t = new Thread(this);
		      stopFlag = false;
		      t.start();
		   }
	   
	 //banner tipa paziòojums
	   public void run() {
		      char c;
		      for(;;) {
		         try {
		            repaint();
		            Thread.sleep(150);
		            c = m.charAt(0);
		            m = m.substring(1, m.length());
		            m += c;
		            if (stopFlag)
		               break;
		         } catch(InterruptedException e) {}
		      }
		   }
	   
	   public void stop() {
	      f.setVisible(false);
	      stopFlag = true;
	      t = null;
	   }
	   public void paint (Graphics g) {
	      g.drawString(m, 10, 20);
	      
	    //komentâra izvads statusa rindiòâ
	      showStatus("Komentârs statusa rindiòâ!");
	   }
  
	}

