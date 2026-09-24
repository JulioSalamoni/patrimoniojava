package br.com.patrimonio.janela;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.BevelBorder;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JRadioButton;

import br.com.exemplo.dao.DAOUsuario;
import br.com.exemplo.pojo.Perfil;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class patrimoniojanela extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JTextField txtEmail;
	private JPasswordField txtSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					patrimoniojanela frame = new patrimoniojanela();
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
	public patrimoniojanela() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(patrimoniojanela.class.getResource("/br/com/imagemcadastro/janela/produicon.png")));
		setResizable(false);
		setTitle("Cadastrar Usuário");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 515);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 204, 0));
		contentPane.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 0, 0), new Color(255, 102, 51), new Color(255, 153, 0), new Color(255, 255, 51)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtSenha = new JPasswordField();
		txtSenha.setBackground(new Color(0, 0, 0));
		txtSenha.setForeground(new Color(255, 255, 255));
		txtSenha.setBounds(8, 150, 407, 20);
		contentPane.add(txtSenha);
		
		JRadioButton chkAtivo = new JRadioButton("Usuário Ativo?");
		chkAtivo.setBackground(new Color(0, 0, 0));
		chkAtivo.setForeground(new Color(255, 255, 255));
		chkAtivo.setSelected(true);
		chkAtivo.setBounds(8, 251, 235, 23);
		contentPane.add(chkAtivo);
		
		JLabel lblNomeUsuario = new JLabel("Nome Usuário:");
		lblNomeUsuario.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		lblNomeUsuario.setBounds(8, 4, 191, 34);
		contentPane.add(lblNomeUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setToolTipText("Coloque o nome do usuário");
		txtUsuario.setBackground(new Color(0, 0, 0));
		txtUsuario.setForeground(new Color(255, 255, 255));
		txtUsuario.setBounds(11, 32, 407, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblEmailUsuario = new JLabel("Email Usuário:");
		lblEmailUsuario.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		lblEmailUsuario.setBounds(8, 60, 191, 34);
		contentPane.add(lblEmailUsuario);
		
		txtEmail = new JTextField();
		txtEmail.setToolTipText("Digite o email do usuário");
		txtEmail.setForeground(new Color(255, 255, 255));
		txtEmail.setBackground(new Color(0, 0, 0));
		txtEmail.setColumns(10);
		txtEmail.setBounds(11, 90, 407, 20);
		contentPane.add(txtEmail);
		
		JLabel lblSenhaUsuario = new JLabel("Senha Usuário:");
		lblSenhaUsuario.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		lblSenhaUsuario.setBounds(8, 121, 191, 34);
		contentPane.add(lblSenhaUsuario);
		
		JLabel lblPerfilUsuario = new JLabel("Perfil Usuário");
		lblPerfilUsuario.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		lblPerfilUsuario.setBounds(8, 181, 191, 34);
		contentPane.add(lblPerfilUsuario);
		
		JComboBox cbxPerfil = new JComboBox();
		cbxPerfil.setForeground(new Color(255, 255, 255));
		cbxPerfil.setBackground(new Color(0, 0, 0));
		cbxPerfil.setModel(new DefaultComboBoxModel(Perfil.values()));
		cbxPerfil.setBounds(8, 212, 410, 22);
		contentPane.add(cbxPerfil);
		
		JButton btnCadastrar = new JButton("CADASTRAR");
		
		btnCadastrar.setBackground(new Color(0, 0, 0));
		btnCadastrar.setForeground(new Color(255, 255, 255));
		btnCadastrar.setBounds(8, 423, 410, 42);
		contentPane.add(btnCadastrar);
		
		JLabel lblImagem = new JLabel("New label");
		lblImagem.setIcon(new ImageIcon(patrimoniojanela.class.getResource("/br/com/imagemcadastro/janela/carcosaicon.jpg")));
		lblImagem.setBounds(8, -71, 416, 744);
		contentPane.add(lblImagem);
		
		
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				//Vamos instânciar a camada Pojo e passar os dados
				//para o usuário por meio do comando set.
 
				br.com.exemplo.pojo.Usuarios us = new br.com.exemplo.pojo.Usuarios();
				
				us.setNome(txtUsuario.getText());
				us.setEmail(txtEmail.getText());
				us.setSenha_hash(txtSenha.getText());
				us.setPerfil((Perfil)cbxPerfil.getSelectedItem());
				us.setAtivo(chkAtivo.isSelected());
				
				DAOUsuario dau = new DAOUsuario();
				String rs = dau.cadastrar(us);
				
				
				JOptionPane.showMessageDialog(null, rs, "Aviso",JOptionPane.WARNING_MESSAGE);
				
			}
		});

	}
}
