package br.com.patrimonio.janela;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Window.Type;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JProgressBar;

public class TelaSplash extends JFrame {
	public TelaSplash() {
	}

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
					JFrame frame = new JFrame();


					
					frame.setResizable(false);
					frame.setType(Type.UTILITY);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setBounds(100, 100, 550, 550);
		JPanel contentPane = new JPanel();
		contentPane.setBackground(new Color(21, 21, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		frame.setLocationRelativeTo(null);//Isso fará a tela abrir no centro do monitor
		frame.setUndecorated(true);
		
		JLabel lblNewLabel_2_1 = new JLabel("Carcosa - Gestão de Patrimônio");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setForeground(new Color(255, 255, 108));
		lblNewLabel_2_1.setFont(new Font("Sylfaen", Font.BOLD, 30));
		lblNewLabel_2_1.setBounds(11, 333, 530, 40);
		contentPane.add(lblNewLabel_2_1);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setStringPainted(true);
		progressBar.setBackground(new Color(0, 0, 0));
		progressBar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		progressBar.setValue(0);
		progressBar.setForeground(new Color(255, 255, 108));
		progressBar.setBounds(30, 504, 481, 22);
		contentPane.add(progressBar);
		
		JLabel lblLegenda = new JLabel("...");
		lblLegenda.setForeground(new Color(255, 255, 145));
		lblLegenda.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		lblLegenda.setHorizontalAlignment(SwingConstants.CENTER);
		lblLegenda.setBounds(188, 350, 170, 40);
		contentPane.add(lblLegenda);
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaSplash.class.getResource("/br/com/imagemcadastro/janela/CarcosaSplashFundo.jpg")));
		lblNewLabel.setBounds(20, -59, 602, 726);
		contentPane.add(lblNewLabel);
		
		frame.setBackground(new Color(0.0f,0.0f,0.0f,0.0f));
		//Setar o fundo da tela como transparente. O comando new Color
		//aplica uma nova cor em três posições e a quarta é a opacidade,
		//onde opacidade é o nivel de transparência. Portanto,
		//os valores 0.0f são aplicados nas posições RGB.
		//com seus respectivos valores variando entre 0.0 até 255.0
		//São valores com casas decimais, por este motivo estamos usando
		//os números como float(f), então poderiamos ter, por exemplo
		//as cores (10.56f, 45.80f, 14.0f)
		
		
		frame.setVisible(true);
		try {
			
		
			// progress bar carregando
		for(int i = 0 ; i <= 110; i++) {
			Thread.sleep(100);
			progressBar.setValue(i);
			
			if( i < 6) {
				lblLegenda.setText("Along the shore the cloud waves break,");
			}
			else if( i < 13) {
				lblLegenda.setText("The twin suns sink behind* the lake,.");
			}
			else if( i < 18) {
				lblLegenda.setText("The shadows lengthen");
			}
			else if( i < 25) {
				lblLegenda.setText("In Carcosa.");
			}
			else if( i < 32) {
				lblLegenda.setText("Strange is the night where black stars rise,");
			}
			else if( i < 38) {
				lblLegenda.setText("And strange moons circle through the skies");
			}
			else if( i < 44) {
				lblLegenda.setText("But stranger still is");
			}
			else if( i < 51) {
				lblLegenda.setText("Lost Carcosa.");
			}
			else if( i < 56) {
				lblLegenda.setText("Songs that the Hyades shall sing,");
			}
			else if( i < 64) {
				lblLegenda.setText("Where flap the tatters of the King,");
			}
			else if( i < 71) {
				lblLegenda.setText("Must die unheard in");
			}
			else if( i < 77) {
				lblLegenda.setText("Dim Carcosa.");
			}
			else if( i < 84) {
				lblLegenda.setText("Song of my soul, my voice is dead;");
			}
			else if( i < 90) {
				lblLegenda.setText("Die thou, unsung, as tears unshed");
			}
			else if( i < 95) {
				lblLegenda.setText("Shall dry and die in");
			}
			else {
				lblLegenda.setText("Lost Carcosa.");
			}
			
		}
	}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		frame.dispose();
		CarcosaPrincipal cp = new CarcosaPrincipal();
		cp.setVisible(true);

	}
}
