package br.com.patrimonio.janela;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

import br.com.exemplo.dao.DAOCurso;
import br.com.exemplo.dao.DAOLocais;
import br.com.exemplo.dao.DAOMovimentacoes;
import br.com.exemplo.dao.DAOPatrimonio;
import br.com.exemplo.dao.DAOUsuario;
import br.com.exemplo.pojo.Tipo_Movimentacao;
import br.com.exemplo.pojo.Usuarios;

public class Movimentacoes extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtResponsavelDestino;
	private JTextField txtDocumentoResponsavel;
	private JTextField txtDataPrevistaRetorno;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Movimentacoes frame = new Movimentacoes();
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
	public Movimentacoes() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Movimentacoes.class.getResource("/br/com/imagemcadastro/janela/carcosaicon5.png")));
		setTitle("Cadastrar Movimentações");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 394, 554);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(168, 168, 0));
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
// -----------------------------------------------------------------------------------------------------------------
		DAOUsuario dauUsuario = new DAOUsuario();
		
		JComboBox cbxUsuario = new JComboBox();
		cbxUsuario.setBackground(new Color(27, 27, 27));
		cbxUsuario.setForeground(new Color(234, 199, 0));
		cbxUsuario.setBounds(10, 80, 358, 22);
		contentPane.add(cbxUsuario);
		
		List<Usuarios> lstu = dauUsuario.listaAtivos();
		for(Usuarios us : lstu) {
			cbxUsuario.addItem(us);

		}		
// -----------------------------------------------------------------------------------------------------------------		
		JLabel lblUsurio = new JLabel("Usuário:");
		lblUsurio.setForeground(new Color(234, 199, 0));
		lblUsurio.setFont(new Font("Sylfaen", Font.BOLD, 15));
		lblUsurio.setBounds(10, 61, 160, 22);
		contentPane.add(lblUsurio);
// -----------------------------------------------------------------------------------------------------------------	
		DAOPatrimonio dauPatrimonio = new DAOPatrimonio();	
		
		JComboBox cbxPatrimonio = new JComboBox();
		cbxPatrimonio.setBackground(new Color(27, 27, 27));
		cbxPatrimonio.setForeground(new Color(234, 199, 0));
		cbxPatrimonio.setBounds(10, 28, 358, 22);
		contentPane.add(cbxPatrimonio);
		
		List<br.com.exemplo.pojo.Patrimonio> lstp = dauPatrimonio.listar();
		for(br.com.exemplo.pojo.Patrimonio pa : lstp) {
			cbxPatrimonio.addItem(pa);
		}
		
// -----------------------------------------------------------------------------------------------------------------
		JLabel lblNewLabel = new JLabel("Patrimônio:");
		lblNewLabel.setForeground(new Color(234, 199, 0));
		lblNewLabel.setFont(new Font("Sylfaen", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 11, 160, 22);
		contentPane.add(lblNewLabel);
		
		JLabel lblTipoMovimentao = new JLabel("Tipo Movimentação:");
		lblTipoMovimentao.setForeground(new Color(234, 199, 0));
		lblTipoMovimentao.setFont(new Font("Sylfaen", Font.BOLD, 15));
		lblTipoMovimentao.setBounds(10, 148, 160, 22);
		contentPane.add(lblTipoMovimentao);
		
		JComboBox cbxTipoMovimentacao = new JComboBox();
		cbxTipoMovimentacao.setModel(new DefaultComboBoxModel(Tipo_Movimentacao.values()));
		cbxTipoMovimentacao.setBackground(new Color(27, 27, 27));
		cbxTipoMovimentacao.setForeground(new Color(234, 199, 0));
		cbxTipoMovimentacao.setBounds(10, 166, 358, 22);
		contentPane.add(cbxTipoMovimentacao);
		
		JLabel lblResponsvelDestino = new JLabel("Responsável Destino:");
		lblResponsvelDestino.setForeground(new Color(234, 199, 0));
		lblResponsvelDestino.setFont(new Font("Sylfaen", Font.BOLD, 15));
		lblResponsvelDestino.setBounds(10, 210, 160, 22);
		contentPane.add(lblResponsvelDestino);
		
		txtResponsavelDestino = new JTextField();
		txtResponsavelDestino.setBackground(new Color(27, 27, 27));
		txtResponsavelDestino.setForeground(new Color(234, 199, 0));
		txtResponsavelDestino.setColumns(10);
		txtResponsavelDestino.setBounds(10, 232, 358, 22);
		contentPane.add(txtResponsavelDestino);
		
		JLabel lblDocumentoResponsvel = new JLabel("Documento Responsável:");
		lblDocumentoResponsvel.setForeground(new Color(234, 199, 0));
		lblDocumentoResponsvel.setFont(new Font("Sylfaen", Font.BOLD, 15));
		lblDocumentoResponsvel.setBounds(10, 257, 186, 22);
		contentPane.add(lblDocumentoResponsvel);
		
		txtDocumentoResponsavel = new JTextField();
		txtDocumentoResponsavel.setBackground(new Color(27, 27, 27));
		txtDocumentoResponsavel.setForeground(new Color(234, 199, 0));
		txtDocumentoResponsavel.setColumns(10);
		txtDocumentoResponsavel.setBounds(10, 276, 358, 22);
		contentPane.add(txtDocumentoResponsavel);
		
		txtDataPrevistaRetorno = new JTextField();
		txtDataPrevistaRetorno.setBackground(new Color(27, 27, 27));
		txtDataPrevistaRetorno.setForeground(new Color(234, 199, 0));
		txtDataPrevistaRetorno.setColumns(10);
		txtDataPrevistaRetorno.setBounds(10, 323, 358, 22);
		contentPane.add(txtDataPrevistaRetorno);
		
		JLabel lblDataPrevistaRetorno = new JLabel("Data Prevista Retorno:");
		lblDataPrevistaRetorno.setForeground(new Color(234, 199, 0));
		lblDataPrevistaRetorno.setFont(new Font("Sylfaen", Font.BOLD, 15));
		lblDataPrevistaRetorno.setBounds(10, 305, 186, 22);
		contentPane.add(lblDataPrevistaRetorno);
		
		JLabel lblObservaes = new JLabel("Observações:");
		lblObservaes.setForeground(new Color(234, 199, 0));
		lblObservaes.setFont(new Font("Sylfaen", Font.BOLD, 15));
		lblObservaes.setBounds(10, 356, 186, 22);
		contentPane.add(lblObservaes);
		
		JTextArea txtObservacoes = new JTextArea();
		txtObservacoes.setBackground(new Color(27, 27, 27));
		txtObservacoes.setForeground(new Color(234, 199, 0));
		txtObservacoes.setBounds(10, 380, 358, 63);
		contentPane.add(txtObservacoes);
		
		JButton btnCadastrar = new JButton("CADASTRAR");

		btnCadastrar.setBackground(new Color(27, 27, 27));
		btnCadastrar.setForeground(new Color(234, 199, 0));
		btnCadastrar.setFont(new Font("Sylfaen", Font.PLAIN, 16));
		btnCadastrar.setBounds(10, 454, 358, 50);
		contentPane.add(btnCadastrar);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Movimentacoes.class.getResource("/br/com/imagemcadastro/janela/carcosaicon2.jpg")));
		lblNewLabel_1.setBounds(-463, -254, 1254, 1313);
		contentPane.add(lblNewLabel_1);
	
		
		
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Instância da classe Locais e Instância da classe DAO
				br.com.exemplo.pojo.Movimentacoes mo = new br.com.exemplo.pojo.Movimentacoes();
				DAOMovimentacoes dm = new DAOMovimentacoes();
			
				br.com.exemplo.pojo.Patrimonio p = (br.com.exemplo.pojo.Patrimonio)cbxPatrimonio.getSelectedItem();
				mo.setPatrimonio_id(p.getId());
				
				Usuarios us = (Usuarios)cbxUsuario.getSelectedItem();
				mo.setUsuario_registro_id(us.getId());
				
				mo.setTipo_movimentacao((br.com.exemplo.pojo.Tipo_Movimentacao) cbxTipoMovimentacao.getSelectedItem());
				
				mo.setResponsavel_destino(txtResponsavelDestino.getText());
				mo.setDocumento_responsavel(txtDocumentoResponsavel.getText());
				mo.setData_prevista_retorno(Date.valueOf(txtDataPrevistaRetorno.getText()));
				mo.setObservacoes(txtObservacoes.getText());
			
				String m = dm.cadastrar(mo);
				JOptionPane.showMessageDialog(null, m);
				
			}
		});
		

	}
}
