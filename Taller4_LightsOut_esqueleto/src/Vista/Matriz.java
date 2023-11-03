package Vista;
import uniandes.dpoo.taller4.modelo.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;

public class Matriz extends JPanel {
	private int rows;
	private int width;
	private Tablero matrizn;
	private int dificultad;

    
    public Matriz(int rows, int width,int dificultad) {
    	this.rows=rows;
    	this.width=width;
    	this.setPreferredSize(new Dimension(500,500));
    	matrizn =new Tablero(rows);
    	matrizn.desordenar(dificultad);
}
    public void paint(Graphics g)
    {
    	
    	
    	
    	Graphics2D g2D = (Graphics2D) g;
    	int valor= 500/rows;
    	for (int val=0; val<rows; val++)
        {
    		for(int val1=0; val1<rows; val1++)
    		{
    		boolean color=matrizn.darTablero()[val][val1];
    		if(color)
    		g2D.setPaint(Color.yellow);
    		else
    		g2D.setPaint(Color.black);	
    		
            g2D.fillRect(val*valor, val1*valor, valor, valor);
            g2D.setPaint(Color.white);
            g2D.drawRect(val*valor, val1*valor, valor, valor);

            }
    
        }
    	
    }
    public void update(int rows, int width)
    {
    	this.rows=rows;
    	this.width=width;
    	repaint();
    	
    }
    public void jugar(int x, int y)
    {
    	matrizn.jugar(x, y);
    	repaint();
    	
    }
    public String jugadas()
    {
    	return String.valueOf(matrizn.darJugadas());
    }
    public boolean gano()
    {
    	return matrizn.tableroIluminado();
    }
    public void reiniciar()
    {
    	matrizn.reiniciar();
    	repaint();
    }
    
    
    
}