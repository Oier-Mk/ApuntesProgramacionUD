package EjerciciosDeClase;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.TreeSet;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

public class informacionPersonal extends JFrame{
	protected JPanel p, pSuperior, pCentral, pInferior;
	protected JButton bExaminar, bAceptar;
	protected JLabel lMensaje;
	protected JLabel lNombre, lApellidos, lGrado, lUniversidad, lDni;
	protected JTextField tfNombre, tfApellidos, tfGrado, tfUniversidad;
	protected JFileChooser fc;
	Usuario u1;

	public informacionPersonal () {
		p = new JPanel(new BorderLayout());
		pSuperior = new JPanel();
		pCentral = new JPanel(new GridLayout(5, 5));
		pInferior = new JPanel();

		bExaminar = new JButton("Examinar");
		bAceptar = new JButton("Aceptar");
		lMensaje = new JLabel("Introduce tus datos:");

		lNombre = new JLabel("Nombre:");
		lApellidos = new JLabel("Apellidos:");
		lGrado = new JLabel("Grado:");
		lUniversidad = new JLabel("Universidad:");
		lDni = new JLabel("DNI:");

		tfNombre = new JTextField();
		tfApellidos = new JTextField();
		tfGrado = new JTextField();
		tfUniversidad = new JTextField();

		setSize(400, 400);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		this.add(p);

		p.add(pSuperior, BorderLayout.NORTH);
		p.add(pCentral, BorderLayout.CENTER);
		p.add(pInferior, BorderLayout.SOUTH);

		pSuperior.add(lMensaje);

		pCentral.add(lNombre);
		pCentral.add(tfNombre);
		pCentral.add(lApellidos);
		pCentral.add(tfApellidos);
		pCentral.add(lGrado);
		pCentral.add(tfGrado);
		pCentral.add(lUniversidad);
		pCentral.add(tfUniversidad);
		pCentral.add(lDni);
		pCentral.add(bExaminar);

		pInferior.add(bAceptar);

		//Decoraciones
		lNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lApellidos.setHorizontalAlignment(SwingConstants.RIGHT);
		lGrado.setHorizontalAlignment(SwingConstants.RIGHT);
		lUniversidad.setHorizontalAlignment(SwingConstants.RIGHT);
		lDni.setHorizontalAlignment(SwingConstants.RIGHT);

		//Preguntar TODO NO funciona por el layout?
		//		bExaminar.setMaximumSize(new Dimension(100, 100));
		//		bExaminar.setPreferredSize(new Dimension(100, 100));
		//		bExaminar.setMaximumSize(new Dimension(100, 100));

		//

		//Eventos
		bExaminar.addActionListener(new ActionListener() { //TODO

			@Override
			public void actionPerformed(ActionEvent e) {
				fc = new JFileChooser();
				File directorio = new File("imagen"); //Imagen --> Nombre del String donde se va a guardar la ruta con la que vamos a estar operando. No estamos poniendo C:/... porque cuando no lo ponemos estamos indicando que la ruta por defecto esta en la carpeta donde estamos almacenando todo nuestro proyecto  
				fc.setCurrentDirectory(directorio); //No entiendo esto TODO
				fc.setFileFilter(new FileNameExtensionFilter("Tipo JPG", "jpg")); //Establecemos que tipo de extension acepta
				fc.setFileFilter(new FileNameExtensionFilter("Tipo PNG", "png"));
				int sel = fc.showOpenDialog(bExaminar); //nos devolverá un int, para saber que opción realiza el usuario. Cada numero hace referencia a una accion.
				File ficheroSeleccionado = fc.getSelectedFile(); //Nos devuelve el fichero seleccionado
				
				if (sel == JFileChooser.APPROVE_OPTION) {

				}

				if (sel == JFileChooser.CANCEL_OPTION) {

				}

				if (sel == JFileChooser.ERROR_OPTION) {

				}

			}
		});

		bAceptar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//				u1.setNombre(lNombre.getText);
				//				u1.setApellidos(lApellidos.getText);
				//				u1.setGrado (lGrado.getText);
				//				u1.setUniversidad(lUniversidad.getText);
				//				u1.setPathDni();

			}
		});
	}


	//Escribiendo en un fichero binario
	public void escribirFicheroBinario() {
		ObjectOutputStream oos = null; //Sirve para poder escribir (output) (controla el flujo)
		try {
			oos = new ObjectOutputStream(new FileOutputStream("Usuarios.dat"));
			oos.writeObject(u1); //Escribimos 
		} catch (FileNotFoundException e) {
			JOptionPane mensaje = new JOptionPane("No se ha encontrado el archivo"); //TODO pero si lo esta creando o ya hay uno no lo sobre escribe?
			e.printStackTrace();
		} catch (IOException e) {
			JOptionPane mensaje = new JOptionPane("Error de escritura de archivo");
			e.printStackTrace();
		} finally {
			try {
				if(oos!=null) {
					oos.flush(); 
					oos.close(); 
					}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void leyendoFicheroBinario() {
		ObjectInputStream ois = null; 
		try {
			ois = new ObjectInputStream(new FileInputStream("Coches.dat"));
			u1 = (Usuario) ois.readObject(); 
		} catch (FileNotFoundException e) {
			JOptionPane mensaje = new JOptionPane("No se ha encontrado el archivo");
			e.printStackTrace();
		} catch (IOException e) {
			JOptionPane mensaje = new JOptionPane("Error de lectura de archivo");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if(ois!=null) {
				try {
					ois.close(); 
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	//Escribir en un fichero de texto
	public void escribiendoFicheroTexto() {
		PrintWriter pw = null; //TODO ¿?
		try {
			pw = new PrintWriter("Ejemplo.txt"); 
			pw.println(u1.toString()); 
		} catch (FileNotFoundException e) {
			JOptionPane mensaje = new JOptionPane("Error. No se encuentra archivo de escritura");
			e.printStackTrace(); 
		} finally {
			if(pw!=null) {
				pw.flush();
				pw.close();
			}
		}
	}

	//Leyendo un fichero de texto
	public void leyendoFicheroTexto() {
		BufferedReader br = null; //Objeto para leer 

		try {
			br = new BufferedReader(new FileReader("Ejemplo.txt")); //Para leer el archivo que esta entre comillas
			String linea = br.readLine(); 
			while(linea!=null) {
				System.out.println(linea);
				linea = br.readLine();
			}
		} catch (FileNotFoundException e) {
			JOptionPane mensaje = new JOptionPane("Error. No se encuentra archivo de lectura");
			e.printStackTrace();
		} catch (IOException e) {
			JOptionPane mensaje = new JOptionPane("Error de lectura");
			e.printStackTrace();
		} finally {
			try {
				if(br!=null)
					br.close();
			} catch (IOException e) {
				JOptionPane mensaje = new JOptionPane("Si no se consigue cerrar de forma adecuada");
				e.printStackTrace();
			}
		}


	}


	public static void main(String[] args) {
		//		u1 = new Usuario(null, null, null, null); //Suponemos que solo tenemos un usuario y que operamos siem pre sobre él.
		informacionPersonal v = new informacionPersonal();
		v.setVisible(true);
	}
}
