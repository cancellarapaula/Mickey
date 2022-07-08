package org.unlam.cripto.interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.unlam.cripto.CipherRunner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import org.springframework.boot.autoconfigure.SpringBootApplication;
public class Ventana extends JFrame {

	public static String rutaInput;
	private JPanel contentPane;
	private JTextField textNombreImagen;
	private JButton btnNewButton_1;
	public static  String key = "ab8322676fd1333f160f";
	public static BigInteger binaryKey  = new BigInteger(key,16);
	public static  String iv = "a7a36548a932c54a0cfc";
	public static BigInteger binaryIv  = new BigInteger(iv,16);
	public static String imageEncrypted = "C:\\Users\\cance\\OneDrive\\Escritorio\\MICKEY---CIPHER\\imagenes\\encrypted.bmp";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana frame = new Ventana();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public Ventana() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 504, 296);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textNombreImagen = new JTextField();
		textNombreImagen.setBounds(113, 68, 263, 20);
		contentPane.add(textNombreImagen);
		textNombreImagen.setColumns(10);
		
		JButton btnNewButton = new JButton("Cargar imagen a encriptar/desencriptar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String Ruta = "";
				JFileChooser jFileChooser = new JFileChooser();
				FileNameExtensionFilter filtrado = new FileNameExtensionFilter("BMP, JPG","bmp", "jpg");
				jFileChooser.setFileFilter(filtrado);
				
				int respuesta = jFileChooser.showOpenDialog(Ventana.this);
				if(respuesta == JFileChooser.APPROVE_OPTION) {
					Ruta = jFileChooser.getSelectedFile().getPath();
					textNombreImagen.setText(jFileChooser.getSelectedFile().getName());
					rutaInput = Ruta;
					System.out.print(Ruta);
					
				}
			}
		});
		btnNewButton.setBounds(87, 23, 320, 23);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("ENCRIPTAR/DESENCRIPTAR");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SpringApplication.run(CipherRunner.class,  binaryKey.toString(2),binaryIv.toString(2),rutaInput,imageEncrypted);
				}
			
		});
		btnNewButton_1.setBounds(87, 142, 320, 73);
		contentPane.add(btnNewButton_1);
		
		
		
		
	}
}
