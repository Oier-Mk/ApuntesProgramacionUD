package EjerciciosDeClase.Herencia;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VentanaUsuario extends JFrame{
	static JLabel nom = new JLabel("Nombre");
	static JLabel con = new JLabel("Contraseña");
	static 	JPanel pan = new JPanel();
	static 	JTextField nomb = new JTextField();
	static 	JTextField cont = new JTextField();
	static 	JButton mue = new JButton("Muestra usuario");
	static 	JPanel botonera = new JPanel();

	public VentanaUsuario(Usuario u) {
		setSize(600, 400);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		add(pan);
		pan.setLayout(null);
		nom.setBounds(200, 120, 80, 20);
		pan.add(nom);
		con.setBounds(200, 160, 80, 20);
		pan.add(con);
		nomb.setBounds(280, 120, 80, 20);
		pan.add(nomb);
		cont.setBounds(280, 160, 80, 20);
		pan.add(cont);
		botonera.setBounds(0, 330, 600, 50);
		botonera.setBackground(Color.black);
		pan.add(botonera);
		botonera.add(mue);
		mue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				muestraUsuario(u);
			}
		});
		actionlistener(u);
		
	}
	
	public void actionlistener(Usuario u) {
		addWindowListener(new WindowAdapter() {
			public void windowClosed(WindowEvent e) {
				u.setNombre(nomb.getText());
				u.setContraseña(cont.getText());
				System.out.println("qqqUsuario al final del programa "+u.toString());
			}
		});		
	}

	private void muestraUsuario(Usuario u) {
		nomb.setText(u.getNombre());
		cont.setText(u.getContraseña());

	}
}
