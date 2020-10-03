package EjerciciosDeClase;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

/*
Crea una ventana con una JTable (inicialmente de 2 filas y 2 columnas) y dos componentes
inferiores:
    ● Un JComboBox que permita elegir entre cuatro opciones: “2x2, 3x3, 4x4 y 5x5”.
         Según se elija, la tabla tiene que cambiar para tener el número de filas y columnas
         correspondiente a la elección.
    ● Un JButton (“¡Aleatorio!”) que vaya calculando números aleatorios del 1 al 1000 para
         cada una de las celdas de la tabla, de manera que los números vayan cambiando a
         toda velocidad durante 3 segundos. Al pasar los tres segundos, se quedan los
		 últimos números aleatorios en cada una de las celdas.

 */

public class ventanaAleatoria extends JFrame{

	private static final long serialVersionUID = 1L;
	@SuppressWarnings("rawtypes")
	public JComboBox cbOpciones;    
	public String[] cabecera;
	public Object[][] tabla;
	public JTable t;
	public String opciones[] = {"2x2","3x3","4x4","5x5"}; 
	public JPanel p;
	public JPanel panelTabla;
	public JPanel panelCombo;
	public JButton aleatorio;
	public JLabel explicacion;
	public Random r = new Random();


	public static void main(String[] args) {
		ventanaAleatoria v = new ventanaAleatoria();
		v.setVisible(true);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ventanaAleatoria() {
		setSize(500, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		p = new JPanel();
		p.setLayout(new BorderLayout());
		add(p);

		panelTabla = new JPanel();
		panelTabla.setLayout(new GridBagLayout());;
		p.add(panelTabla, BorderLayout.CENTER);

		panelCombo = new JPanel();
		p.add(panelCombo, BorderLayout.SOUTH);

		explicacion = new JLabel("Selecciona la opción de tabla mas adecuada");
		panelCombo.add(explicacion);

		cbOpciones = new JComboBox(opciones);
		panelCombo.add(cbOpciones);

		aleatorio = new JButton("“¡Aleatorio!”");
		panelCombo.add(aleatorio);

		aleatorio.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				numerosAleatorios();
			}

		});

		cbOpciones.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				creaTabla();
			}
		});

		creaTabla();

	}

	private void creaTabla() {
		int n = 0;
		switch (cbOpciones.getSelectedIndex()) {
		case 0:
			n = 2;
			break;
		case 1:
			n = 3;
			break;
		case 2:
			n = 4;
			break;
		case 3:
			n = 5;
			break;
		}
		panelTabla.removeAll();
		tabla = new Object[n][n];
		cabecera = new String[n];
		for (int i = 0; i<n; i++) {
			cabecera[i] = "";
		}
		t = new JTable(tabla,cabecera);
		panelTabla.add(t);
		//comprobacion();
		panelTabla.revalidate();
	}

	private void numerosAleatorios() {
		(new Thread() {
			public void run() {
				long empieza = System.currentTimeMillis(); 
				while((System.currentTimeMillis()-empieza)<2000) {

					for (int i = 0; i<tabla.length; i++) {
						for (int j = 0; j<tabla.length; j++) {
							int numero = (int) (r.nextInt(1000));
							tabla[i][j] = numero;
						}
					}
					//comprobacion();
					t = new JTable(tabla,cabecera);
					panelTabla.repaint();
					try {sleep(15);} catch (InterruptedException e) {e.printStackTrace();}
				}
			}
		}
				).start();
	}

	@SuppressWarnings("unused")
	private void comprobacion() {
		System.out.println("\n"+cbOpciones.getSelectedItem()+"\n");
		for (int i = 0; i<tabla.length; i++) {
			for (int j = 0; j<tabla.length; j++) {
				System.out.print(tabla[i][j] + "\t");
			}
			System.out.println("\n");
		}	
	}
}
