package Windows;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;
public class MiniAhorcado extends JFrame implements KeyListener {
    GridLayout layout = new GridLayout(3,1);
    JLabel bienvenida = new JLabel("Adivina la Palabra:", JLabel.CENTER);
    JPanel panel = new JPanel(new FlowLayout());
    JLabel h = new JLabel("?", JLabel.CENTER);
    JLabel o1 = new JLabel("?", JLabel.CENTER);
    JLabel l = new JLabel("?", JLabel.CENTER);
    JLabel a = new JLabel("?", JLabel.CENTER);
    JLabel m = new JLabel("?", JLabel.CENTER);
    JLabel u = new JLabel("?", JLabel.CENTER);
    JLabel n= new JLabel("?", JLabel.CENTER);
    JLabel d = new JLabel("?", JLabel.CENTER);
    JLabel o2 = new JLabel("?", JLabel.CENTER);
    JLabel tecla = new JLabel("", JLabel.CENTER);
    char[] palabras = {'h','o','l','a'};
    public MiniAhorcado(){
        super("Bienvenidos al juego del ahorcado");
        setSize(380,110);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(layout);
        add(bienvenida);
        panel.add(h);panel.add(o1);panel.add(l);panel.add(a);
        panel.add(m);panel.add(u);panel.add(n);panel.add(d);panel.add(o2);
        add(panel);
        add(tecla);
        addKeyListener(this);
        setVisible(true);
    }
   
    public void keyTyped(KeyEvent e) {
        char caracter = e.getKeyChar();
        tecla.setText("Tecla Pulsada = '" + caracter +"'");
        adivina(caracter);
    }

    public static void main(String[] args) {
        new MiniAhorcado();
    }
    public void adivina(char c){
        switch(c){
        case 'h':
            h.setText("H");
            break;
        case 'o':
            o1.setText("O");
            o2.setText("O");
            break;
        case 'l':
            l.setText("L");
            break;
        case 'a':
            a.setText("A ");
            break;
        case 'm':
            m.setText(" M");
            break;
        case 'u':
            u.setText("U");
            break;
        case 'n':
            n.setText("N");
            break;
        case 'd':
            d.setText("D");
            break;
        }
    }

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}