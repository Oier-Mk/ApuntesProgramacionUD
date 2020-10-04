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

import EjerciciosDeClase.JLabelGrafico;

@SuppressWarnings("serial")
public class VentanaFoto extends VentanaUsuario{
	JLabelGrafico foto;
	JTextField path = new JTextField();
	public VentanaFoto(UsuarioFoto u) {
		super(u);
		foto = new JLabelGrafico(u.getFoto(), 225*0.5, 225*0.5);
		foto.setBounds(400, 80, (int)(225*0.5), (int)(225*0.5));
		pan.add(foto);
		path.setBounds(400, (int)(255*0.5)+80, (int)(255*0.5), 20);
		pan.add(path);
		mue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nomb.setText(u.getNombre());
				cont.setText(u.getContraseña());
				path.setText(u.getFoto());
			}
		});
	}
	public void actionlistener(Usuario u) {
		addWindowListener(new WindowAdapter() {
			public void windowClosed(WindowEvent e) {
				u.setNombre(nomb.getText());
				u.setContraseña(cont.getText());
				((UsuarioFoto) u).setFoto(path.getText());
				System.out.println("Usuario al final del programa "+u.toString());
			}
		});		
	}
}
