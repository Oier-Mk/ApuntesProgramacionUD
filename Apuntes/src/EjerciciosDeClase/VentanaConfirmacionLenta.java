package EjerciciosDeClase;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;

/** Ejercicio de hilos con ventanas. Programa esta clase para que se cree una ventana
 * que pida un dato de texto al usuario y un botón de confirmar para que se confirme.
 * Haz que al pulsar el botón de confirmación se llame al procesoConfirmar()
 * que simula un proceso de almacenamiento externo que tarda unos segundos.
 * Observa que hasta que ocurre esta confirmación la ventana no responde.
 * 1. Arréglalo para que la ventana no se quede "frita" hasta que se acabe de confirmar.
 * 2. Haz que el botón de "confirmar" no se pueda pulsar dos veces mientras el proceso
 * de confirmación se esté realizando
 * @author andoni.eguiluz @ ingenieria.deusto.es
 */
public class VentanaConfirmacionLenta {

	private static Random r = new Random();
	// Este método simula un proceso que tarda un tiempo en hacerse (entre 5 y 10 segundos)
	private static void procesoConfirmar() {
		try {
			Thread.sleep( 5000 + 1000*r.nextInt(6) );
		} catch (InterruptedException e) {}
	}

	public static void main(String[] args) {
		// TODO Desarrollar la clase de acuerdo a los comentarios de la cabecera
		JFrame f = new JFrame();
		f.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );   
		f.setVisible(true);
		f.setLocationRelativeTo(null);
		f.setSize(300	, 200);
		f.setTitle("Ejercicio 2");
		JButton b = new JButton("Confirmar");
		f.add(b);
		b.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				(new Thread() {
					public void run() {
						System.out.println("antes de confirmar");
						procesoConfirmar(); 
						System.out.println("despues de confirmar");
					}
				}).start();
			}
		});
	}

}
