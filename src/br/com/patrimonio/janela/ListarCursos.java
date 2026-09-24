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

import br.com.exemplo.dao.DAOCurso;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListarCursos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTextField txtIdCurso;
	private JTable tableCursos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarCursos frame = new ListarCursos();
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
	public ListarCursos() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ListarCursos.class.getResource("/br/com/imagemcadastro/janela/cadicon4.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 529, 377);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Listar Cursos");
		lblNewLabel.setFont(new Font("Sylfaen", Font.PLAIN, 24));
		lblNewLabel.setBounds(64, 11, 131, 31);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 53, 513, 2);
		contentPane.add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("Código do Curso:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(64, 66, 102, 21);
		contentPane.add(lblNewLabel_1);
		
		txtIdCurso = new JTextField();
		txtIdCurso.setForeground(new Color(255, 255, 255));
		txtIdCurso.setBackground(new Color(0, 0, 0));
		txtIdCurso.setBounds(169, 66, 154, 21);
		contentPane.add(txtIdCurso);
		txtIdCurso.setColumns(10);
		
		
		
		JButton btnListarCursos = new JButton("Listar Curso");
		btnListarCursos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String cx = txtIdCurso.getText();
				if(cx.equals("")|| cx==null) {
					carregarCursos(0);
				}
				else {
					carregarCursos(Integer.parseInt(cx));
				}
				
			}
		});
		btnListarCursos.setBackground(new Color(240, 186, 0));
		btnListarCursos.setFont(new Font("Tempus Sans ITC", Font.BOLD, 16));
		btnListarCursos.setBounds(333, 61, 170, 29);
		contentPane.add(btnListarCursos);

		carregarCursos(0);
		
	}
	
	public void carregarCursos(Integer id) {
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 98, 493, 229);
		contentPane.add(scrollPane);
		//Montar o cabeçalho da tabela
		String colunas[] = {"Id", "Nome do Curso", "Sigla do Curso", "Criado Por", "Criado Em"};
	
		//Vamos criar um modelo de dados para apresentar as colunas e os dados do banco
		//de dadis ba bissa JTable. O Modelo de dados organiza as informações que
		//serão apresentadas
		DefaultTableModel model = new DefaultTableModel(colunas,0);
		
		//Instância da classe DAOCurso
		DAOCurso dc = new DAOCurso();
		//Receber a lista de todos os cursos do banco de dados em uma lista
		List<br.com.exemplo.pojo.Cursos> lc = dc.listar();
		br.com.exemplo.pojo.Cursos cs;
		
		if( id == 0) {
			lc = dc.listar();
			for(br.com.exemplo.pojo.Cursos cr : lc) {
				Object[] dados = {
						cr.getId(),
						cr.getNome(),
						cr.getSigla(),
						cr.getCriado_por(),
						cr.getCriado_em()
				};
				model.addRow(dados);
			}
		}
		else {
			cs = dc.listarID(id);
			Object[] dados = {
					cs.getId(),
					cs.getNome(),
					cs.getSigla(),
					cs.getCriado_por(),
					cs.getCriado_em()
			};
			model.addRow(dados);
		}
		
		
		
		
		
		//adicionar o modelo de dados com colunas a JTable
		tableCursos = new JTable(model);
		scrollPane.setViewportView(tableCursos);
		
		
		
		
// IMAGEM ----------------------------------------------------------------------------
		JLabel imagem = new JLabel("");
		imagem.setIcon(new ImageIcon(ListarCursos.class.getResource("/br/com/imagemcadastro/janela/carcosaicon3.jpg")));
		imagem.setBounds(-69, -78, 647, 565);
		contentPane.add(imagem);
	}
}
