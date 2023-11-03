package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import uniandes.dpoo.taller4.modelo.*;

import javax.swing.JOptionPane;





public class LightsOut implements ActionListener,MouseListener {
	private PanelEste PanelJava2D;

	private JFrame frmMinecraft;
	private JTextField txtJugadas;
	private JTextField textField_1;
	private final Top10 top10=new Top10();
	private JTextField txtJugador;
	private JTextField textField_3;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_1_1;
	private JButton btnNewButton_1_1_1;
	JRadioButton rdbtnNewRadioButton = new JRadioButton("F\u00E1cil");
	JRadioButton rdbtnMedia = new JRadioButton("Media");
	JRadioButton rdbtnNewRadioButton_1_1 = new JRadioButton("D\u00EDficil");
	private int tamano=5;
	JComboBox<String> comboBox = new JComboBox<>();
	JPanel panel = new JPanel();
	JPanel panel_1 = new JPanel();
	Matriz Matrizp= new Matriz(5,5,5);

	String itemsel;
	
	


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LightsOut window = new LightsOut();
					window.frmMinecraft.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}



	public LightsOut() {
		top10.cargarRecords(new File("./data/top10.csv"));
		
		
		initialize();
		frmMinecraft.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
//Realizo todos los botones, no me gusta borderLayout limita el espacio por ende lo deje como null
	
	

	private void initialize() {
		
		
	
		frmMinecraft = new JFrame();
		frmMinecraft.setTitle("Minecraft");
		frmMinecraft.setBounds(100, 100, 878, 652);
		frmMinecraft.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMinecraft.getContentPane().setLayout(null);
		
		
		
		
		panel.setBounds(0, 0, 862, 33);
		panel.setBackground(new Color(0, 128, 255));
		frmMinecraft.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("Tama\u00F1o :");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Cooper Black", Font.PLAIN, 18));
		panel.add(lblNewLabel);
		
		
		
		panel.add(comboBox);
		comboBox.addItem("5x5");
		comboBox.addItem("10x10");
		
		
		
		
				
		
		JLabel lblDificultad = new JLabel("Dificultad :");
		lblDificultad.setForeground(Color.WHITE);
		lblDificultad.setFont(new Font("Cooper Black", Font.PLAIN, 18));
		panel.add(lblDificultad);
		
		ButtonGroup boton= new ButtonGroup(); 
		
		rdbtnNewRadioButton.setForeground(new Color(255, 255, 255));
		rdbtnNewRadioButton.setBackground(new Color(0, 128, 255));
		boton.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setSelected(true);
		panel.add(rdbtnNewRadioButton);
		
		
		rdbtnMedia.setForeground(new Color(255, 255, 255));
		rdbtnMedia.setBackground(new Color(0, 128, 255));
		boton.add(rdbtnMedia);
		panel.add(rdbtnMedia);
		
		
		rdbtnNewRadioButton_1_1.setForeground(new Color(255, 255, 255));
		rdbtnNewRadioButton_1_1.setBackground(new Color(0, 128, 255));
		boton.add(rdbtnNewRadioButton_1_1);
		panel.add(rdbtnNewRadioButton_1_1);
		
		
		btnNewButton = new JButton("Nuevo ");
		itemsel= (String)comboBox.getSelectedItem();
		btnNewButton.addActionListener(this);
		btnNewButton.setFont(new Font("Cooper Black", Font.PLAIN, 14));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBackground(new Color(0, 128, 255));
		btnNewButton.setBounds(581, 195, 259, 33);
		
		frmMinecraft.getContentPane().add(btnNewButton);
		
		btnNewButton_1 = new JButton("Reiniciar");
		btnNewButton_1.addActionListener(this);
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("Cooper Black", Font.PLAIN, 14));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(581, 239, 259, 33);
		btnNewButton_1.setBackground(new Color(0, 128, 255));
		frmMinecraft.getContentPane().add(btnNewButton_1);
		
		btnNewButton_1_1 = new JButton("TOP 10");
		btnNewButton_1_1.addActionListener(this);
		btnNewButton_1_1.setFont(new Font("Cooper Black", Font.PLAIN, 14));
		btnNewButton_1_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1_1.setBackground(new Color(0, 128, 255));
		btnNewButton_1_1.setBounds(581, 283, 259, 33);
		frmMinecraft.getContentPane().add(btnNewButton_1_1);
		
		btnNewButton_1_1_1 = new JButton("Cambiar Jugador");
		btnNewButton_1_1_1.setFont(new Font("Cooper Black", Font.PLAIN, 14));
		btnNewButton_1_1_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1_1_1.setBackground(new Color(0, 128, 255));
		btnNewButton_1_1_1.setBounds(581, 326, 259, 33);
		frmMinecraft.getContentPane().add(btnNewButton_1_1_1);
		
		
		panel_1.setBounds(40, 85, 499, 490);
		frmMinecraft.getContentPane().add(panel_1);
		panel_1.add(Matrizp);
		
		

		
		txtJugadas = new JTextField();
		txtJugadas.setEditable(false);
		txtJugadas.setText("Jugadas:");
		txtJugadas.setBounds(0, 593, 184, 20);
		frmMinecraft.getContentPane().add(txtJugadas);
		txtJugadas.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setText("0");
		textField_1.setColumns(10);
		textField_1.setBounds(183, 593, 233, 20);
		frmMinecraft.getContentPane().add(textField_1);
		
		txtJugador = new JTextField();
		txtJugador.setEditable(false);
		txtJugador.setText("Jugador");
		txtJugador.setColumns(10);
		txtJugador.setBounds(414, 593, 250, 20);
		frmMinecraft.getContentPane().add(txtJugador);
		
		textField_3 = new JTextField();
		textField_3.setEditable(true);
		textField_3.setColumns(10);
		textField_3.setBounds(664, 593, 198, 20);
		frmMinecraft.getContentPane().add(textField_3);
		frmMinecraft.addMouseListener(this);
	
	}
	
public void actionPerformed(ActionEvent event)
{ 
    int temp;
	if (rdbtnNewRadioButton.isSelected())
    	temp=5;
	else if (rdbtnMedia.isSelected())
    	temp=10;
	else if(rdbtnNewRadioButton_1_1.isSelected())
		temp=15;
	else {
		temp=1;
	}
		
		
	if (event.getSource()== btnNewButton)
	{
		if (textField_3.getText().equals("") || textField_3.getText().length()!=3)
			JOptionPane.showMessageDialog(frmMinecraft, "Ole ponga bien el nombre 3 letras solamente", "AHHH CUIDADO", JOptionPane.WARNING_MESSAGE);
		else
		{
			
			if (Matrizp.gano())
			{
			  top10.agregarRegistro(textField_3.getText(), Integer.parseInt(textField_1.getText()));	
			}
			panel_1.remove(Matrizp);
			
			if (comboBox.getSelectedIndex()==0)
			{
				Matriz matrizp1= new Matriz(5,5,temp);
				Matrizp=matrizp1;
				panel_1.add(Matrizp);
				tamano=5;
				
				
			}
			else if (comboBox.getSelectedIndex()==1)
			{
				Matriz matrizp1= new Matriz(10,10,temp);
				Matrizp=matrizp1;
				panel_1.add(Matrizp);
				tamano=10;
				
			}
			
		}	
	}

	else if(event.getSource()==btnNewButton_1_1)
	{
	 JFrame topframe= new JFrame();
	 ArrayList<RegistroTop10> top = new ArrayList<>(top10.darRegistros());
	 String[] tops= new String[10];
	 for  (int ind=0; ind<tops.length; ind++)
	 {
		 if(ind>=top.size())
			 tops[ind]="No hay jugadores";
		 else
			 tops[ind]=ind+". "+top.get(ind).darNombre()+ "___"+top.get(ind).darPuntos();
	 }
	 JList<String> list=new JList<>(tops);
	 topframe.getContentPane().add(list);
	 topframe.setSize(100,200);
	 topframe.setVisible(true);
	 
	}
	else if(event.getSource()==btnNewButton_1)
	{
		Matrizp.reiniciar();
		textField_1.setText("0");
		
	}
	
}
public void mouseClicked(MouseEvent e)
	
{
	if(tamano==5)
	{int x= e.getX();
	int y=e.getY();
	int xr= x-47;
	int yr= y-121;
	int xrs= xr/100;
	int yrs= yr/100;
	
	Matrizp.jugar(xrs, yrs);
	System.out.println(xrs+" "+yrs);
	
	}
	else if (tamano==10)
	{
		int x= e.getX();
		int y=e.getY();
		int xr= x-47;
		int yr= y-121;
		int xrs= xr/50;
		int yrs= yr/50;
		
		Matrizp.jugar(xrs, yrs);
		System.out.println(xrs+" "+yrs);
	}
	textField_1.setText(Matrizp.jugadas());
	
	
	
	}



@Override
public void mousePressed(MouseEvent e) {
	// TODO Auto-generated method stub
	
}



@Override
public void mouseReleased(MouseEvent e) {
	// TODO Auto-generated method stub
	
}



@Override
public void mouseEntered(MouseEvent e) {
	// TODO Auto-generated method stub
	
}



@Override
public void mouseExited(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
}
