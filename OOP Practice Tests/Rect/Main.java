import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame {
    int mx, my;
    Rect [] rList = new Rect[50];
    
    double rand(double a, double b){
		return Math.random()*(b-a) + a;
    }
    
    public Main(){
		super ("Fun with Boxes");

		for(int i=0; i<50; i++){
		    rList[i] = new Rect(rand(0,450),rand(30,450),rand(10,50),rand(10,50));
		}        
			
		setSize (500, 500);
		setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		setVisible (true);
    }

    public boolean overlaps(Rect r){
		int c=0;
			
		// Uncomment if overlap works
	for(int i=0; i<50; i++){
		   if(r.overlaps(rList[i]))
			c++;
		}
		return c==1? false: true;
    }
    
    public void draw(){
		Graphics g=getGraphics();
		Point mouse = MouseInfo.getPointerInfo().getLocation();
		Point offset = getLocationOnScreen();
		mx = mouse.x-offset.x;
		my = mouse.y-offset.y;
		
        for(int i=0; i<50; i++){			
			    if(overlaps(rList[i]))
					g.setColor(Color.red);
			    else
					g.setColor(Color.green);
			    
			    g.fillRect((int)rList[i].getX(),(int)rList[i].getY(),(int)rList[i].getWidth(),(int)rList[i].getHeight());
		
			
			// Uncomment if contains and centre work
			    if(rList[i].contains(mx,my)){
					int x = (int)rList[i].centre()[0]-2;
					int y = (int)rList[i].centre()[1]-2;
					g.setColor(Color.black);
					g.fillOval(x,y,4,4);
			    }
			
		}
		// If union works, comment the for loop and uncomment this
		
        // Rect r1 = new Rect(200.0,100.0,50.0,20.0);
        // Rect r2 = new Rect(400,300,10,20);
        // r1.union(r2); 
        // g.fillRect((int)r1.getX(),(int)r1.getY(),(int)r1.getWidth(),(int)r1.getHeight());
    
		
	     
    }
    
    public static void delay (long len){
		try{
		    Thread.sleep (len);
		}
		catch (InterruptedException ex){
		    System.out.println("I hate when my sleep is interrupted");
		}
    }

    public static void main (String[] args){
		Main shapes = new Main();
		
		while(true){
		    delay(50);
		    // Uncomment if translate works
		    shapes.rList[0].translate(2,2);
	
		    // Uncomment if resize works
		    shapes.rList[1].resize(1.1);
		    
		    shapes.draw();
		}
    } 
} 

