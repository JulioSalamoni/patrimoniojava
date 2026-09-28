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

import br.com.exemplo.dao.DAOLocais;

import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListarLocais extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTextField txtIdLocal;
	private JTable tableLocais;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarLocais frame = new ListarLocais();
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
	public ListarLocais() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ListarLocais.class.getResource("/br/com/imagemcadastro/janela/cadicon8.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 432, 377);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Listar Locais");
		lblNewLabel.setForeground(new Color(231, 231, 126));
		lblNewLabel.setFont(new Font("Sylfaen", Font.PLAIN, 24));
		lblNewLabel.setBounds(20, 11, 131, 31);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 53, 513, 2);
		contentPane.add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("Código do Local:");
		lblNewLabel_1.setForeground(new Color(231, 231, 126));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(10, 66, 102, 21);
		contentPane.add(lblNewLabel_1);
		
		txtIdLocal = new JTextField();
		txtIdLocal.setForeground(new Color(255, 255, 255));
		txtIdLocal.setBackground(new Color(0, 0, 0));
		txtIdLocal.setBounds(110, 66, 154, 21);
		contentPane.add(txtIdLocal);
		txtIdLocal.setColumns(10);
		
		
		
		JButton btnListarLocais = new JButton("Listar Local");
		btnListarLocais.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String cx = txtIdLocal.getText();
				if(cx.equals("")|| cx==null) {
					carregarLocais(0);
				}
				else {
					carregarLocais(Integer.parseInt(cx));
				}
				
			}
		});
		btnListarLocais.setBackground(new Color(231, 231, 126));
		btnListarLocais.setFont(new Font("Tempus Sans ITC", Font.BOLD, 16));
		btnListarLocais.setBounds(274, 61, 132, 29);
		contentPane.add(btnListarLocais);

		carregarLocais(0);
		
	}
	
	public void carregarLocais(Integer id) {
		scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 98, 380, 229);
		contentPane.add(scrollPane);
		//Montar o cabeçalho da tabela
		String colunas[] = {"Id", "Nome do Local", "Descriçao", "Criado Por", "Criado Em"};
	
		//Vamos criar um modelo de dados para apresentar as colunas e os dados do banco
		//de dadis ba bissa JTable. O Modelo de dados organiza as informações que
		//serão apresentadas
		DefaultTableModel model = new DefaultTableModel(colunas,0);
		
		//Instância da classe DAOLocais
		DAOLocais dl = new DAOLocais();
		//Receber a lista de todos os locais do banco de dados em uma lista
		List<br.com.exemplo.pojo.Locais> lc = dl.listar();
		br.com.exemplo.pojo.Locais cs;
		
		if( id == 0) {
			lc = dl.listar();
			for(br.com.exemplo.pojo.Locais cr : lc) {
				Object[] dados = {
						cr.getId(),
						cr.getNome(),
						cr.getDescricao(),
						cr.getCriado_por(),
						cr.getCriado_em()
				};
				model.addRow(dados);
			}
		}
		else {
			cs = dl.listarID(id);
			Object[] dados = {
					cs.getId(),
					cs.getNome(),
					cs.getDescricao(),
					cs.getCriado_por(),
					cs.getCriado_em()
			};
			model.addRow(dados);
		}
		
		
		
		
		
		//adicionar o modelo de dados com colunas a JTable
		tableLocais = new JTable(model);
		scrollPane.setViewportView(tableLocais);
		
		
		
		
// IMAGEM ----------------------------------------------------------------------------
		JLabel imagem = new JLabel("");
		imagem.setIcon(new ImageIcon(ListarLocais.class.getResource("/br/com/imagemcadastro/janela/carcosaicon5.jpg")));
		imagem.setBounds(0, -157, 647, 565);
		contentPane.add(imagem);
	}
}
