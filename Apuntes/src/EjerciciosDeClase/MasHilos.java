package EjerciciosDeClase;
/*
 * Habéis visto que si a una función de fibonacci recursiva se le pide un número un poco elevado (40, 50…)
 *  tarda mucho tiempo, dada la cantidad exponencial de llamadas recursivas. Programa una ventana que calcule 
 *  números de fibonacci que, pidiendo el número al usuario, utilice un hilo para sacar una barra de progreso 
 *  cuando ese cálculo tarde un tiempo, de manera que la barra de progreso se vaya actualizando según pase el tiempo.
 *  Puedes ir contando el número de llamadas y partir de la estimación previa del número de llamadas que van a 
 *  ocurrir para mostrar esa barra de progreso. Tendrás que utilizar un hilo para ello.
 *  TODO cincronizar hilo con Recursividad
 */
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class MasHilos extends JFrame {
	public static void main(String[] args) {
		MasHilos v = new MasHilos(42);
		v.setVisible(true);
	}
	private static final long serialVersionUID = 1L;
	JProgressBar p;
	JButton b;
	JPanel pCentro;
	JLabel creado,l;
	int i=0;
	private long cont;
	public MasHilos(int numero) {
		int altura =  200;
		int anchura = 400;
		setSize(anchura, altura);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);		
		setUndecorated(true);

		pCentro = new JPanel();
		pCentro.setLayout(null);
		add(pCentro);

		l = new JLabel("El número fibonaci del "+numero+" es el siguiente:");
		l.setFont(new Font("Arial",Font.PLAIN,20));
		l.setBounds(110, 10, 200, 20);
		pCentro.add(l);

		b =new JButton("Aceptar");
		b.setEnabled(false);
		b.setBounds(314, 175, 80, 20);
		pCentro.add(b);



		creado = new JLabel("");
		creado.setFont(new Font("Arial",Font.PLAIN,20));
		creado.setBounds(169, 125, 80, 20);
		creado.setVisible(false);
		pCentro.add(creado);

		b.addActionListener( e -> dispose() );

		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowOpened(WindowEvent e) {
				Thread t = new Thread() { 
					public void run() {
						fibIt(numero);
						p = new JProgressBar(0,(int) cont);
						p.setStringPainted(true);
						p.setBounds(100, 90, 200, 20);
						p.setValue(0);
						pCentro.add(p);
						i=0;
						while(i<cont){
							System.out.println(i + "   " + cont);
							p.setValue(i=i+1); 
							repaint();
							try{Thread.sleep(25);}catch(Exception ex){} //ritmo de la barra

						}

						b.setEnabled(true);
						creado.setVisible(true);
					}
				};
				t.start(); 
				(new Thread() { 
					public void run() {
						creado.setText(fib(numero)+"");
					}
				}).start();
			}
		});


	}
	public long fib( int n ) {
		if (n==1) {
			return 1;
		} else if (n==2) {
			return 1;
		} else {
			return fib(n-1) + fib(n-2);
		}
	}
	public void fibIt(int n) {
		int fibo1 = 1;
		int fibo2 = 1;

		for(i=2;i<=n;i++){
			cont +=1 ;
			fibo2 = fibo1 + fibo2;
			fibo1 = fibo2 - fibo1;
		}
	}
}
