import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DecimalFormat;

import javafx.scene.control.CheckBox;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class Factura extends JFrame implements ActionListener, ItemListener
{
	JComboBox combo1;
	ButtonGroup g1;
	JRadioButton r1, r2;
	JCheckBox ch1, ch2, ch3;
	JLabel l1, l2;
	JTextField e1;
	JButton b1, b2;

	
	Factura ()
	{
		setLayout (null);
				
		combo1 = new JComboBox();
		combo1.setBounds(30,30,200,30);
		combo1.addItem("SELECCIONE LA CARRERA");
		combo1.addItem("Analista de sistemas  ($1000)");
		combo1.addItem("Telecomunicaciones  ($800)");
		combo1.addItem("Desarrollo de software  ($700)");
		combo1.addItemListener(this);
		add(combo1);
				
		Font f1 = new Font ("Serif",2,15);
		
		l1 = new JLabel("Seleccione las materias a cursar:",JLabel.CENTER);
		l1.setBounds(30,160,200,30);
		l1.setForeground(Color.blue);
		add(l1);
		
		ch1 = new JCheckBox("Matematica  ($200)");
		ch1.setBounds(30,210,200,30);
		ch1.addItemListener(this);
		add(ch1);
		
		ch2 = new JCheckBox("Programacion  ($300)");
		ch2.setBounds(30,260,200,30);
		ch2.addItemListener(this);
		add(ch2);
		
		ch3 = new JCheckBox("Ingles  ($100)");
		ch3.setBounds(30,310,200,30);
		ch3.addItemListener(this);
		add(ch3);
		
		g1 = new ButtonGroup();
		
		r1 = new JRadioButton("Abona de contado  (-10%)");
		r1.setBounds(30,370,200,30);
		r1.setSelected(true);
		r1.addItemListener(this);
		g1.add(r1);
		add(r1);
		
		r2 = new JRadioButton("Abona con tarjeta  (lista)");
		r2.setBounds(30,420,200,30);
		r2.addItemListener(this);
		g1.add(r2);
		add(r2);
																				
		b1 = new JButton ("Importe");
		b1.setBounds(30,480,100,40);
		b1.addActionListener(this);
		add(b1);
						
		l2=new JLabel ("$ 0.00",JLabel.CENTER);
		l2.setBounds(150,480,80,40);
		l2.setFont(f1);
		l2.setForeground(Color.blue);
		l2.setBackground(Color.yellow);
		l2.setOpaque(true);
		add(l2);
		
		b2=new JButton("Ver factura");
		b2.setBounds(30,540,200,40);
		b2.addActionListener(this);
		add(b2);
							
	}
	
	
			
	public void calculo()
	{

		int indice = combo1.getSelectedIndex();
		
		double carrera = 0;
	
		if(indice==0)
			JOptionPane.showMessageDialog(null, "Falta seleccionar la carrera");
			else
			{		
				
		switch (indice)
		{
		case 1: carrera = 1000; break;
		case 2: carrera = 800; break;
		case 3: carrera = 700; break;				
		}
								
		double materias = 0;
		
		if(ch1.isSelected())
		materias = materias+200;
		
		if(ch2.isSelected())
		materias = materias+300;
		
		if(ch3.isSelected())
		materias = materias+100;
		
		double parcial = carrera+materias; 
		
		double modo = 0;
		
		if(r1.isSelected())
			modo=parcial*0.1;
		else
			if(r2.isSelected())
				modo = 0;

		double total = parcial-modo; 
							
		DecimalFormat f = new DecimalFormat("0.00");
			
		l2.setText("$ "+f.format(total));
		
			}
	}
	
	
	
	public void actionPerformed (ActionEvent e)
		{
					
			if(e.getSource()==b1)
			{				
				calculo();
			}
			
			
			if(e.getSource()==b2)
			{
				String carreras = "";
				int indice = combo1.getSelectedIndex();
				switch (indice)
				{
				case 1: carreras = "Analista de sistemas"; break;
				case 2: carreras = "Telecomunicaciones"; break;
				case 3: carreras = "Desarrollo de software"; break;
				}
				
				String materias = "";
				if(ch1.isSelected())
					materias = "Matematica";
				if(ch2.isSelected())
					materias = materias+" "+"Programacion";
				if(ch3.isSelected())
					materias = materias+" "+"Ingles";
				
				String imp = l2.getText();
				
				PopUp p = new PopUp(carreras,materias,imp);
				p.setBounds(300,300,390,320);
				p.setTitle("***Factura***");
				p.setModal(true); //Modal significa que la ventana en primer plano obliga a trabajar solamente en esa ventana
				p.setResizable(false);
				p.setVisible(true);
			}
			
		}
		
				
		
	public void itemStateChanged (ItemEvent e)
		{
			calculo();
		}
									
				
		
	public static void main(String[] args)
		{
		Factura f = new Factura ();
			f.setBounds (50,50,280,650);
			f.setTitle("Factura de inscripcion");
			f.setVisible(true);
			f.setResizable(true);
		}

}