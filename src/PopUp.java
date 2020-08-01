import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class PopUp extends JDialog implements ActionListener
{
JLabel l1, l2, l3, l4, l5, l6;
JButton b1;


PopUp(String carreras, String materias, String imp)
{
	
	setLayout (null);
	
	l1 = new JLabel ("Carrera: ");
	l1.setBounds(30,30,100,30);
	add(l1);
	
	l2 = new JLabel (carreras);
	l2.setBounds(140,30,300,30);
	add(l2);
	
	l3 = new JLabel ("Materia/s: ");
	l3.setBounds(30,80,100,30);
	add(l3);
		
	l4 = new JLabel (materias);
	l4.setBounds(140,80,300,30);
	add(l4);
	
	l5 = new JLabel ("Importe: ");
	l5.setBounds(30,150,100,40);
	add(l5);
	
	Font f1 = new Font ("Serif",1,25);
		
	l6 = new JLabel (imp,JLabel.CENTER);
	l6.setBounds(140,150,150,40);
	l6.setBackground(Color.blue);
	l6.setForeground(Color.cyan);
	l6.setOpaque(true);
	l6.setFont(f1);
	add(l6);
	
	b1 = new JButton("Cerrar factura");
	b1.setBounds(30,220,150,40);
	b1.addActionListener(this);
	add(b1);
	
}


	public void actionPerformed (ActionEvent e)
	{
		if(e.getSource()==b1)
		{				
			dispose();
		}
		
	}
		

}
