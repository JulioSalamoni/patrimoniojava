package br.com.patrimonio.janela;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.com.exemplo.dao.DAOCategorias;
import br.com.exemplo.pojo.Usuarios;

public class Categorias extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNomeCategoria;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Categorias frame = new Categorias();
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
	public Categorias() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Categorias.class.getResource("/br/com/imagemcadastro/janela/cadicon2.png")));
		setResizable(false);
		setTitle("Cadastrar Categorias");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 302, 428);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome Categoria:");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Sylfaen", Font.BOLD, 16));
		lblNewLabel.setBounds(20, 11, 144, 24);
		contentPane.add(lblNewLabel);
		
		txtNomeCategoria = new JTextField();
		txtNomeCategoria.setForeground(new Color(255, 255, 255));
		txtNomeCategoria.setBackground(new Color(0, 0, 0));
		txtNomeCategoria.setBounds(20, 38, 244, 20);
		contentPane.add(txtNomeCategoria);
		txtNomeCategoria.setColumns(10);
		
		JLabel lblDescricaoCategoria = new JLabel("Descricao Categoria:");
		lblDescricaoCategoria.setForeground(new Color(255, 255, 255));
		lblDescricaoCategoria.setFont(new Font("Sylfaen", Font.BOLD, 16));
		lblDescricaoCategoria.setBounds(20, 125, 185, 24);
		contentPane.add(lblDescricaoCategoria);
		
		JTextArea txtDescricaoCategoria = new JTextArea();
		txtDescricaoCategoria.setBackground(new Color(0, 0, 0));
		txtDescricaoCategoria.setForeground(new Color(255, 255, 255));
		txtDescricaoCategoria.setBounds(20, 149, 244, 58);
		contentPane.add(txtDescricaoCategoria);
		
		JButton btnCadastrar = new JButton("CADASTRAR");

		btnCadastrar.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		btnCadastrar.setBackground(new Color(0, 0, 0));
		btnCadastrar.setForeground(new Color(255, 255, 255));
		btnCadastrar.setBounds(10, 336, 266, 42);
		contentPane.add(btnCadastrar);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(Categorias.class.getResource("/br/com/imagemcadastro/janela/carcosaicon1.jpg")));
		lblNewLabel_1.setBounds(-192, -194, 507, 959);
		contentPane.add(lblNewLabel_1);
		
		
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				//Instância da classe Locais e Instância da classe DAO
				br.com.exemplo.pojo.Categorias ca = new br.com.exemplo.pojo.Categorias();
				DAOCategorias dc = new DAOCategorias();
				
				ca.setNome(txtNomeCategoria.getText());
				ca.setDescricao(txtDescricaoCategoria.getText());
				
				
				String m = dc.cadastrar(ca);
				JOptionPane.showMessageDialog(null, m);		
				
			}
		});

	}
}
