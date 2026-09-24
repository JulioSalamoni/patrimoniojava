package br.com.patrimonio.janela;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.border.BevelBorder;

import br.com.exemplo.dao.DAOCurso;
import br.com.exemplo.dao.DAOUsuario;
import br.com.exemplo.pojo.Usuarios;

public class Cursos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNomeCurso;
	private JTextField txtSiglaCurso;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cursos frame = new Cursos();
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
	public Cursos() {
		setTitle("Cadastrar Curso");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Cursos.class.getResource("/br/com/imagemcadastro/janela/cadicon.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 436, 369);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(204, 0, 0), new Color(255, 0, 51), new Color(204, 0, 51), new Color(184, 134, 11)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		DAOUsuario dau = new DAOUsuario();
		
		//A JComboBox foi tipada como Usuarios para
		//receber apenas objeto usuarios completo com
		//todos os seus dados.
		JComboBox<Usuarios> cbxCriadoPor = new JComboBox();
		cbxCriadoPor.setBackground(new Color(0, 0, 0));
		cbxCriadoPor.setForeground(new Color(255, 255, 255));
		cbxCriadoPor.setBounds(127, 119, 283, 29);
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
		
		JToggleButton btnCadastrar2 = new JToggleButton("CADASTRAR");
		
		btnCadastrar2.setFont(new Font("WritersFont", Font.BOLD, 15));
		btnCadastrar2.setBackground(new Color(0, 0, 0));
		btnCadastrar2.setForeground(new Color(255, 255, 255));
		btnCadastrar2.setBounds(10, 272, 400, 48);
		contentPane.add(btnCadastrar2);
		
		JLabel lblNomeCurso = new JLabel("Nome Curso:");
		lblNomeCurso.setFont(new Font("Yu Gothic", Font.BOLD, 15));
		lblNomeCurso.setForeground(new Color(0, 0, 0));
		lblNomeCurso.setBounds(10, 11, 207, 39);
		contentPane.add(lblNomeCurso);
		
		txtNomeCurso = new JTextField();
		txtNomeCurso.setBackground(new Color(0, 0, 0));
		txtNomeCurso.setForeground(new Color(255, 255, 255));
		txtNomeCurso.setBounds(10, 41, 386, 29);
		contentPane.add(txtNomeCurso);
		txtNomeCurso.setColumns(10);
		
		txtSiglaCurso = new JTextField();
		txtSiglaCurso.setForeground(new Color(255, 255, 255));
		txtSiglaCurso.setBackground(new Color(0, 0, 0));
		txtSiglaCurso.setColumns(10);
		txtSiglaCurso.setBounds(10, 119, 107, 29);
		contentPane.add(txtSiglaCurso);
		
		JLabel lblSiglaCurso = new JLabel("Sigla Curso:");
		lblSiglaCurso.setForeground(new Color(0, 0, 0));
		lblSiglaCurso.setFont(new Font("Yu Gothic", Font.BOLD, 15));
		lblSiglaCurso.setBounds(10, 91, 107, 39);
		contentPane.add(lblSiglaCurso);
		
		JLabel lblCriadoPor = new JLabel("Criado Por:");
		lblCriadoPor.setBackground(new Color(255, 255, 255));
		lblCriadoPor.setForeground(new Color(0, 0, 0));
		lblCriadoPor.setFont(new Font("Yu Gothic", Font.BOLD, 15));
		lblCriadoPor.setBounds(127, 91, 207, 39);
		contentPane.add(lblCriadoPor);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon(Cursos.class.getResource("/br/com/imagemcadastro/janela/carcosaicon10.jpg")));
		lblNewLabel_3.setBounds(-41, -122, 491, 649);
		contentPane.add(lblNewLabel_3);
		
		
		
		btnCadastrar2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Instância da classe Cursos e Instância da classe DAO
				br.com.exemplo.pojo.Cursos cu = new br.com.exemplo.pojo.Cursos();
				DAOCurso dc = new DAOCurso();
				
				cu.setNome(txtNomeCurso.getText());
				cu.setSigla(txtSiglaCurso.getText());
				
				Usuarios u = (Usuarios)cbxCriadoPor.getSelectedItem();
				cu.setCriado_por(u.getId());
				
				String m = dc.cadastrar(cu);
				JOptionPane.showMessageDialog(null, m);
			}
		});

	}
}
