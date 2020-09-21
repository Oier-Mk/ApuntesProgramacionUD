package PulsandoTeclas;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Ventana extends JFrame{

	public static void main(String[] args) {
		Ventana v = new Ventana();
		v.setVisible(true);
	}
	public Ventana() {
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );   
		setSize(500,70);
		setLocationRelativeTo(null);
		JPanel p = new JPanel();
		add(p);
		JLabel texto = new JLabel("La tecla presionada es la siguiente:");
		p.add(texto);
		JLabel textoVariable = new JLabel("___");
		p.add(textoVariable);
		addKeyListener(new KeyAdapter() {


			@Override
			public void keyPressed(KeyEvent e) {
				textoVariable.setText(e.getKeyChar()+"");
				System.out.println("Pressed "+e.getKeyCode());

			}
		});
	}
}
