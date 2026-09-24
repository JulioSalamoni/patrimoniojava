package br.com.patrimonio.janela;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.com.exemplo.dao.DAOLocais;
import br.com.exemplo.dao.DAOUsuario;
import br.com.exemplo.pojo.Usuarios;

public class Locais extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNomeLocal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Locais frame = new Locais();
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
	public Locais() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Locais.class.getResource("/br/com/imagemcadastro/janela/carcosaicon4.png")));
		setForeground(new Color(0, 0, 0));
		setTitle("Cadastrar Local");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 404, 498);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 128, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea txtDescricaoLocal = new JTextArea();
		txtDescricaoLocal.setFont(new Font("Monospaced", Font.PLAIN, 15));
		txtDescricaoLocal.setForeground(new Color(255, 255, 242));
		txtDescricaoLocal.setBackground(new Color(51, 0, 1));
		txtDescricaoLocal.setBounds(10, 79, 368, 104);
		contentPane.add(txtDescricaoLocal);
		
		JButton btnCadastrar3 = new JButton("CADASTRAR");
		
		
		btnCadastrar3.setIcon(null);
		btnCadastrar3.setForeground(new Color(252, 248, 218));
		btnCadastrar3.setBackground(new Color(55, 0, 1));
		btnCadastrar3.setBounds(10, 334, 368, 52);
		contentPane.add(btnCadastrar3);
		
		JLabel lblNewLabel = new JLabel("Nome Local:");
		lblNewLabel.setForeground(new Color(255, 255, 242));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 11, 128, 14);
		contentPane.add(lblNewLabel);
		
		txtNomeLocal = new JTextField();
		txtNomeLocal.setBackground(new Color(55, 0, 1));
		txtNomeLocal.setForeground(new Color(252, 248, 218));
		txtNomeLocal.setBounds(10, 30, 368, 20);
		contentPane.add(txtNomeLocal);
		txtNomeLocal.setColumns(10);
		
		JLabel lblDescrioLocal = new JLabel("Descrição Local:");
		lblDescrioLocal.setForeground(new Color(252, 248, 218));
		lblDescrioLocal.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDescrioLocal.setBounds(10, 61, 128, 14);
		contentPane.add(lblDescrioLocal);
		
		JLabel lblCriadoPor = new JLabel("Criado Por:");
		lblCriadoPor.setForeground(new Color(252, 248, 218));
		lblCriadoPor.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCriadoPor.setBounds(10, 204, 128, 14);
		contentPane.add(lblCriadoPor);
		
		
// ----------------------------------------------------------------------------------------------------------------
		DAOUsuario dau = new DAOUsuario();
		
		//A JComboBox foi tipada como Usuarios para
		//receber apenas objeto usuarios completo com
		//todos os seus dados.
		JComboBox<Usuarios> cbxCriadoPor = new JComboBox();
		cbxCriadoPor.setForeground(new Color(252, 248, 218));
		cbxCriadoPor.setBackground(new Color(55, 0, 1));
		cbxCriadoPor.setBounds(10, 222, 368, 20);
		contentPane.add(cbxCriadoPor);
		
		//Criamos uma lista de usuários que retorna do método
		//listaAtivos da classe DAOUsuario. Aqui estamos passado
		//todos os usuários retornados para a lista lst que
		//está tipada como Usuarios, assim ela recebe apenas
		//dadso de usuários
		List<Usuarios> lst = dau.listaAtivos();
		//A estrutura for está pegando um item por vez dentro de um lst
		//e passa para a variável us. O item que está sendo passado
		//é um usuário completo. Depois de passado para a variável
		//us, estamos adicionando a JComboBox o usuário com todos os seus dados
		for(Usuarios us : lst) {
			cbxCriadoPor.addItem(us);

		}	

// -------------------------------------------------------------------------------------------------------------------	
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(Locais.class.getResource("/br/com/imagemcadastro/janela/carcosaicon9.jpg")));
		lblNewLabel_1.setBounds(-53, -143, 470, 630);
		contentPane.add(lblNewLabel_1);
		
		
// -------------------------------------------------------------------------------------------------------------------------
		
		btnCadastrar3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Instância da classe Locais e Instância da classe DAO
				br.com.exemplo.pojo.Locais lo = new br.com.exemplo.pojo.Locais();
				DAOLocais dl = new DAOLocais();
				
				lo.setNome(txtNomeLocal.getText());
				lo.setDescricao(txtDescricaoLocal.getText());
				
				Usuarios u = (Usuarios)cbxCriadoPor.getSelectedItem();
				lo.setCriado_por(u.getId());
				
				String m = dl.cadastrar(lo);
				JOptionPane.showMessageDialog(null, m);
				
			}
		});

	}
}

