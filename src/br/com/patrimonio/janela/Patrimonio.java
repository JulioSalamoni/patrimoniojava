package br.com.patrimonio.janela;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
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

import br.com.exemplo.dao.DAOCategorias;
import br.com.exemplo.dao.DAOCurso;
import br.com.exemplo.dao.DAOLocais;
import br.com.exemplo.dao.DAOPatrimonio;
import br.com.exemplo.dao.DAOUsuario;
import br.com.exemplo.pojo.Usuarios;
import javax.swing.DefaultComboBoxModel;
import br.com.exemplo.pojo.Status;

public class Patrimonio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNumeroTombamento;
	private JTextField txtNomePatrimonio;
	private JTextArea txtDescricaoPatrimonio;
	private JTextField txtValorAquisicao;
	private JTextField txtDataAquisicao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Patrimonio frame = new Patrimonio();
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
	public Patrimonio() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Patrimonio.class.getResource("/br/com/imagemcadastro/janela/cadicon3.png")));
		setTitle("Cadastrar Patrimonio");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 523, 404);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
// -----------------------------------------------------------------------------------		
		JComboBox cbxStatus = new JComboBox();
		cbxStatus.setModel(new DefaultComboBoxModel(Status.values()));
		cbxStatus.setBackground(new Color(255, 240, 193));
		cbxStatus.setBounds(311, 9, 186, 21);
		contentPane.add(cbxStatus);
// -----------------------------------------------------------------------------------		
		JLabel lblNewLabel = new JLabel("Número Tombamento:");
		lblNewLabel.setForeground(new Color(255, 240, 193));
		lblNewLabel.setFont(new Font("Sylfaen", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 11, 151, 21);
		contentPane.add(lblNewLabel);
		
		txtNumeroTombamento = new JTextField();
		txtNumeroTombamento.setForeground(new Color(255, 240, 193));
		txtNumeroTombamento.setBackground(new Color(0, 0, 0));
		txtNumeroTombamento.setBounds(10, 26, 207, 21);
		contentPane.add(txtNumeroTombamento);
		txtNumeroTombamento.setColumns(10);
		
		txtNomePatrimonio = new JTextField();
		txtNomePatrimonio.setBackground(new Color(0, 0, 0));
		txtNomePatrimonio.setForeground(new Color(255, 240, 193));
		txtNomePatrimonio.setColumns(10);
		txtNomePatrimonio.setBounds(10, 70, 207, 21);
		contentPane.add(txtNomePatrimonio);
		
		JLabel lblNomePatrimnio = new JLabel("Nome Patrimônio:");
		lblNomePatrimnio.setForeground(new Color(255, 240, 193));
		lblNomePatrimnio.setFont(new Font("Sylfaen", Font.BOLD, 15));
		lblNomePatrimnio.setBounds(10, 55, 151, 21);
		contentPane.add(lblNomePatrimnio);
		
		JLabel lblNomePatrimnio_1 = new JLabel("Descricao Patrimônio:");
		lblNomePatrimnio_1.setForeground(new Color(255, 240, 193));
		lblNomePatrimnio_1.setFont(new Font("Sylfaen", Font.BOLD, 15));
		lblNomePatrimnio_1.setBounds(11, 98, 151, 21);
		contentPane.add(lblNomePatrimnio_1);
		
		txtDescricaoPatrimonio = new JTextArea();
		txtDescricaoPatrimonio.setForeground(new Color(255, 240, 193));
		txtDescricaoPatrimonio.setBackground(new Color(0, 0, 0));
		txtDescricaoPatrimonio.setBounds(10, 117, 224, 54);
		contentPane.add(txtDescricaoPatrimonio);
		
		JLabel lblNomePatrimnio_1_1 = new JLabel("Curso\r\n:");
		lblNomePatrimnio_1_1.setForeground(new Color(255, 240, 193));
		lblNomePatrimnio_1_1.setFont(new Font("Sylfaen", Font.BOLD, 15));
		lblNomePatrimnio_1_1.setBounds(10, 179, 151, 21);
		contentPane.add(lblNomePatrimnio_1_1);
// -----------------------------------------------------------------------------------	
		DAOCurso dauCurso = new DAOCurso();		
		
		JComboBox<br.com.exemplo.pojo.Cursos> cbxCurso = new JComboBox();
		cbxCurso.setForeground(new Color(255, 240, 193));
		cbxCurso.setBackground(new Color(0, 0, 0));
		cbxCurso.setBounds(10, 199, 207, 21);
		contentPane.add(cbxCurso);
		
		List<br.com.exemplo.pojo.Cursos> lstc = dauCurso.listar();
		for(br.com.exemplo.pojo.Cursos cu : lstc) {
			cbxCurso.addItem(cu);
		}
// -----------------------------------------------------------------------------------		
		DAOLocais dauLocais = new DAOLocais();
		
		JComboBox cbxLocal = new JComboBox();
		cbxLocal.setForeground(new Color(255, 240, 193));
		cbxLocal.setBackground(new Color(0, 0, 0));
		cbxLocal.setBounds(10, 244, 207, 21);
		contentPane.add(cbxLocal);
		
		List<br.com.exemplo.pojo.Locais> lstl = dauLocais.listar();
		for(br.com.exemplo.pojo.Locais lo : lstl) {
			cbxLocal.addItem(lo);
		}	
// -----------------------------------------------------------------------------------		
		JLabel lblNomePatrimnio_1_1_1 = new JLabel("Local\r\n:");
		lblNomePatrimnio_1_1_1.setForeground(new Color(255, 240, 193));
		lblNomePatrimnio_1_1_1.setFont(new Font("Sylfaen", Font.BOLD, 15));
		lblNomePatrimnio_1_1_1.setBounds(10, 224, 151, 21);
		contentPane.add(lblNomePatrimnio_1_1_1);
		
		JLabel lblNomePatrimnio_1_1_1_1 = new JLabel("Categoria\r\n:");
		lblNomePatrimnio_1_1_1_1.setForeground(new Color(255, 240, 193));
		lblNomePatrimnio_1_1_1_1.setFont(new Font("Sylfaen", Font.BOLD, 15));
		lblNomePatrimnio_1_1_1_1.setBounds(10, 268, 151, 21);
		contentPane.add(lblNomePatrimnio_1_1_1_1);
// -----------------------------------------------------------------------------------
		DAOCategorias dauCategorias = new DAOCategorias();
		
		JComboBox cbxCategoria = new JComboBox();
		cbxCategoria.setForeground(new Color(255, 240, 193));
		cbxCategoria.setBackground(new Color(0, 0, 0));
		cbxCategoria.setBounds(10, 288, 207, 21);
		contentPane.add(cbxCategoria);
		
		List<br.com.exemplo.pojo.Categorias> lstca = dauCategorias.listar();
		for(br.com.exemplo.pojo.Categorias lo : lstca) {
			cbxCategoria.addItem(lo);
		}	
// -----------------------------------------------------------------------------------
		JLabel lblNomePatrimnio_1_1_1_1_1 = new JLabel("Status\n:");
		lblNomePatrimnio_1_1_1_1_1.setFont(new Font("Sylfaen", Font.BOLD, 15));
		lblNomePatrimnio_1_1_1_1_1.setBounds(257, 11, 44, 21);
		contentPane.add(lblNomePatrimnio_1_1_1_1_1);
		
		txtValorAquisicao = new JTextField();
		txtValorAquisicao.setBackground(new Color(255, 240, 193));
		txtValorAquisicao.setColumns(10);
		txtValorAquisicao.setBounds(258, 70, 207, 21);
		contentPane.add(txtValorAquisicao);
		
		JLabel lblValorAquisio = new JLabel("Valor Aquisição:");
		lblValorAquisio.setFont(new Font("Sylfaen", Font.BOLD, 15));
		lblValorAquisio.setBounds(258, 55, 151, 21);
		contentPane.add(lblValorAquisio);
		
		txtDataAquisicao = new JTextField();
		txtDataAquisicao.setBackground(new Color(255, 240, 193));
		txtDataAquisicao.setColumns(10);
		txtDataAquisicao.setBounds(258, 113, 207, 21);
		contentPane.add(txtDataAquisicao);
		
		JLabel lblDataAquisio = new JLabel("Data Aquisição:");
		lblDataAquisio.setFont(new Font("Sylfaen", Font.BOLD, 15));
		lblDataAquisio.setBounds(258, 98, 151, 21);
		contentPane.add(lblDataAquisio);
		
		JLabel lblNomePatrimnio_1_1_1_1_2 = new JLabel("Criado Por\r\n:");
		lblNomePatrimnio_1_1_1_1_2.setFont(new Font("Sylfaen", Font.BOLD, 15));
		lblNomePatrimnio_1_1_1_1_2.setBounds(258, 150, 151, 21);
		contentPane.add(lblNomePatrimnio_1_1_1_1_2);
		
		
// ----------------------------------------------------------------------------
		DAOUsuario dauUsuario = new DAOUsuario();
		

		JComboBox<Usuarios> cbxCriadoPor = new JComboBox();
		cbxCriadoPor.setForeground(new Color(252, 248, 218));
		cbxCriadoPor.setBackground(new Color(0, 0, 0));
		cbxCriadoPor.setBounds(257, 166, 240, 20);
		contentPane.add(cbxCriadoPor);
		
		List<Usuarios> lstu = dauUsuario.listaAtivos();
		for(Usuarios us : lstu) {
			cbxCriadoPor.addItem(us);

		}	
// -----------------------------------------------------------------------------------
		
		JButton btnCadastrar = new JButton("CADASTRAR");

		
		btnCadastrar.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		btnCadastrar.setForeground(new Color(255, 240, 193));
		btnCadastrar.setBackground(new Color(0, 0, 0));
		btnCadastrar.setBounds(10, 320, 487, 34);
		contentPane.add(btnCadastrar);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(Patrimonio.class.getResource("/br/com/imagemcadastro/janela/carcosaicon11.png")));
		lblNewLabel_1.setBounds(-240, -144, 779, 707);
		contentPane.add(lblNewLabel_1);
		
		
		
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Instância da classe Patrimonio e Instância da classe DAO
				br.com.exemplo.pojo.Patrimonio pa = new br.com.exemplo.pojo.Patrimonio();
				DAOPatrimonio dp = new DAOPatrimonio();
				
				pa.setNumero_tombamento(txtNumeroTombamento.getText());
				pa.setNome(txtNomePatrimonio.getText());
				pa.setDescricao(txtDescricaoPatrimonio.getText());
				
				
				br.com.exemplo.pojo.Cursos c = (br.com.exemplo.pojo.Cursos)cbxCurso.getSelectedItem();
				pa.setCurso_id(c.getId());
				
				br.com.exemplo.pojo.Locais l = (br.com.exemplo.pojo.Locais)cbxLocal.getSelectedItem();
				pa.setLocal_id(l.getId());
				
				br.com.exemplo.pojo.Categorias cat = (br.com.exemplo.pojo.Categorias)cbxCategoria.getSelectedItem();
				pa.setCategoria_id(cat.getId());
				
				pa.setStatus((br.com.exemplo.pojo.Status)cbxStatus.getSelectedItem());
				
				pa.setValor_aquisicao(Double.parseDouble(txtValorAquisicao.getText()));
				
				pa.setData_aquisicao(Date.valueOf(txtDataAquisicao.getText()));
				
				Usuarios u = (Usuarios)cbxCriadoPor.getSelectedItem();
				pa.setCriado_por(u.getId());
				
				
				String m = dp.cadastrar(pa);
				JOptionPane.showMessageDialog(null, m,  "Aviso",JOptionPane.WARNING_MESSAGE);
				
				
			}
		});

	}
}
