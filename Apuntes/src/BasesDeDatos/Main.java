package BasesDeDatos;

import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.Array;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.*;

@SuppressWarnings("serial")
public class Main extends JFrame{

	private static Main ventana;
	public static void main(String[] args) {
		ventana = new Main();
		ventana.setVisible( true );
	}

	private JTextArea taDatos;
	private ArrayList<Producto> listaProds;

	public Main() {
		// Punto 7
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		setSize( 1000, 500 );
		setLocationRelativeTo(null);
		setTitle( "Ejercicio 3.6 de base de datos" );
		taDatos = new JTextArea();
		taDatos.setFont( new Font( "Arial", Font.PLAIN, 18 ) );
		JPanel pBotonera = new JPanel();
		getContentPane().add( new JScrollPane(taDatos), BorderLayout.CENTER );
		getContentPane().add( pBotonera, BorderLayout.SOUTH );

		// Punto 8
		this.addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent e) {
				BaseDatos.abrirConexion("MiniMarket.db");
			}
			public void windowClosed(WindowEvent e) {
				BaseDatos.cerrarConexion();
			}
		});

		// Punto 9
		JButton b = new JButton( "Ver productos" );
		b.setFont( new Font( "Arial", Font.PLAIN, 16 ) );
		pBotonera.add( b );
		b.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clickVerProductos();
			}
		});

		// Punto 10
		b = new JButton( "Compra" );
		b.setFont( new Font( "Arial", Font.PLAIN, 16 ) );
		pBotonera.add( b );
		b.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clickComprar();
			}
		});

		// Punto 12
		b = new JButton( "Anular compra" );
		b.setFont( new Font( "Arial", Font.PLAIN, 16 ) );
		pBotonera.add( b );
		b.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clickAnular();
			}
		});

	}

	// 9
	private void clickVerProductos() {
		ArrayList<Producto> lista = BaseDatos.getProductos();
		taDatos.setText("Id\tNombre\tCantidad");
		try {
			for(int i = 0; i< lista.size();i++) {
				taDatos.setText(taDatos.getText() +"\n"+ lista.get(i).toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 10
	private void clickComprar() {
		ArrayList<Producto> lista = BaseDatos.getProductos();
		String txt = "Los productos disponibles son los siguientes:\nSeleccione un número\n";
		for (int i = 0; i<lista.size();i++) {
			txt+=(i+1)+" "+lista.get(i).getNombre()+"\n";
		}
		Producto P1 = primerParametro(txt,lista);
		
		int P2 = segundoParametro("indica la cantidad de "+P1.getNombre()+"s que quieres:");

		//añadir a compra
		System.out.println(BaseDatos.getCompras().size()+1);
		Compra compra = new Compra(BaseDatos.getCompras().size()+1, System.currentTimeMillis(), P2, P1);
		BaseDatos.insertarCompra(compra);
		
		
		//mostrar
		clickComprar();
	}

	private int segundoParametro(String txt) {
		String ans = JOptionPane.showInputDialog(txt);
		int ansN = 0;
		try {
			ansN = Integer.parseInt(ans);
		}catch(Exception e){
			ans = JOptionPane.showInputDialog(txt);
		}	
		return ansN;
	}

	private Producto primerParametro(String txt, ArrayList<Producto> lista) {
		String ans = JOptionPane.showInputDialog(txt);
		int ansN = 0;
		try {
			ansN = Integer.parseInt(ans);
			if (ansN < 1 || ansN > lista.size()) {
				ans = JOptionPane.showInputDialog(txt);
				ansN = Integer.parseInt(ans);
			}
		}catch(Exception e) {
			ans = JOptionPane.showInputDialog(txt);
		}
		return lista.get(ansN-1);
	}

	// 12
	private void clickAnular() {
		// TODO
	}
	private static SimpleDateFormat sdf = new SimpleDateFormat( "dd/MM/yy HH:mm:ss" );

}
