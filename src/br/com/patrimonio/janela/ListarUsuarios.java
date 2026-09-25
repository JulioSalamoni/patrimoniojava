package br.com.patrimonio.janela;

import java.awt.EventQueue;
import java.awt.Font;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import br.com.exemplo.dao.DAOUsuario;

import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListarUsuarios extends JFrame {



	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTextField txtIdUsuario;
	private JTable tableUsuarios;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarUsuarios frame = new ListarUsuarios();
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
	public ListarUsuarios() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ListarUsuarios.class.getResource("/br/com/imagemcadastro/janela/cadicon4.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 529, 377);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Listar Usuarios");
		lblNewLabel.setForeground(new Color(209, 227, 149));
		lblNewLabel.setFont(new Font("Sylfaen", Font.PLAIN, 24));
		lblNewLabel.setBounds(63, 11, 154, 31);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 53, 513, 2);
		contentPane.add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("Código do Usuario:");
		lblNewLabel_1.setForeground(new Color(209, 227, 149));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(59, 66, 112, 21);
		contentPane.add(lblNewLabel_1);
		
		txtIdUsuario = new JTextField();
		txtIdUsuario.setForeground(new Color(255, 255, 255));
		txtIdUsuario.setBackground(new Color(0, 0, 0));
		txtIdUsuario.setBounds(169, 66, 154, 21);
		contentPane.add(txtIdUsuario);
		txtIdUsuario.setColumns(10);
		
		
		
		JButton btnListarUsuarios = new JButton("Listar Usuarios");
		btnListarUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String cx = txtIdUsuario.getText();
				if(cx.equals("")|| cx==null) {
					carregarUsuarios(0);
				}
				else {
					carregarUsuarios(Integer.parseInt(cx));
				}
				
			}
		});
		btnListarUsuarios.setBackground(new Color(209, 227, 149));
		btnListarUsuarios.setFont(new Font("Tempus Sans ITC", Font.BOLD, 16));
		btnListarUsuarios.setBounds(333, 61, 170, 29);
		contentPane.add(btnListarUsuarios);

		carregarUsuarios(0);
		
	}
	
	public void carregarUsuarios(Integer id) {
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 98, 493, 229);
		contentPane.add(scrollPane);
		//Montar o cabeçalho da tabela
		String colunas[] = {"Id", "Nome do Usuario", "Email Usuario", "Perfil"};
	
		//Vamos criar um modelo de dados para apresentar as colunas e os dados do banco
		//de dadis ba bissa JTable. O Modelo de dados organiza as informações que
		//serão apresentadas
		DefaultTableModel model = new DefaultTableModel(colunas,0);
		
		//Instância da classe DAOUsuario
		DAOUsuario dc = new DAOUsuario();
		//Receber a lista de todos os usuarios do banco de dados em uma lista
		List<br.com.exemplo.pojo.Usuarios> lc = dc.listar();
		br.com.exemplo.pojo.Usuarios cs;
		
		if( id == 0) {
			lc = dc.listaAtivos();
			for(br.com.exemplo.pojo.Usuarios cr : lc) {
				Object[] dados = {
						cr.getId(),
						cr.getNome(),
						cr.getEmail(),
						cr.getPerfil()
						
				};
				model.addRow(dados);
			}
		}
		else {
			cs = dc.listarID(id);
			Object[] dados = {
					cs.getId(),
					cs.getNome(),
					cs.getEmail(),
					cs.getPerfil()
			};
			model.addRow(dados);
		}
		
		
		
		
		
		//adicionar o modelo de dados com colunas a JTable
		tableUsuarios = new JTable(model);
		scrollPane.setViewportView(tableUsuarios);
		
		
		
		
// IMAGEM ----------------------------------------------------------------------------
		JLabel imagem = new JLabel("");
		imagem.setIcon(new ImageIcon(ListarUsuarios.class.getResource("/br/com/imagemcadastro/janela/carcosaicon4.jpg")));
		imagem.setBounds(-66, -54, 647, 671);
		contentPane.add(imagem);
	}
}
