package Vista;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class PanelEste extends JPanel implements ActionListener
{
    private LightsOut principal;
    private JButton[] btnCalificacion;
    
    public PanelEste(LightsOut ventanaMuseo)
    {
        principal=ventanaMuseo;
        setLayout( new GridLayout( 13,1 ) );
        setBorder( new TitledBorder( "Calificaciones" ) );
        add(new JLabel( ));
        btnCalificacion=new JButton[6];
        for( int i = 0; i < btnCalificacion.length; i++ )
        {
            btnCalificacion[i]= new JButton( );
            btnCalificacion[i].addActionListener( this );
            btnCalificacion[i].setActionCommand( i+"" );
            add(btnCalificacion[i]);
            add(new JLabel( ));
        }
    }

    @Override
    public void actionPerformed( ActionEvent e )
    {
        String comando = e.getActionCommand( );
        JOptionPane.showMessageDialog( this, "se presiono el boton "+comando );
        
        
    }
}