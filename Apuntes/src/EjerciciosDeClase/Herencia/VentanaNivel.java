package EjerciciosDeClase.Herencia;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JTextField;


@SuppressWarnings("serial")
public class VentanaNivel extends VentanaUsuario{
	JTextField niv = new JTextField();
	public VentanaNivel(UsuarioNivel u) {
		super(u);
		niv.setBounds(400, 120, 20, 20);
		pan.add(niv);
		mue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nomb.setText(u.getNombre());
				cont.setText(u.getContraseña());
				niv.setText(""+u.getNivel());
			}
		});
	}
	@Override
	public void actionlistener(Usuario u) {
		addWindowListener(new WindowAdapter() {
			public void windowClosed(WindowEvent e) {
				u.setNombre(nomb.getText());
				u.setContraseña(cont.getText());
				((UsuarioNivel) u).setNivel(Integer.parseInt(niv.getText()));
				System.out.println("Usuario al final del programa "+u.toString());
			}
		});		
	}
}
