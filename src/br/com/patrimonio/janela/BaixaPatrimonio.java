package br.com.patrimonio.janela;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

import br.com.exemplo.dao.DAOBaixaPatrimonio;
import br.com.exemplo.dao.DAOMovimentacoes;
import br.com.exemplo.dao.DAOPatrimonio;
import br.com.exemplo.dao.DAOUsuario;
import br.com.exemplo.pojo.TipoBaixa;
import br.com.exemplo.pojo.Usuarios;

import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.List;
import java.awt.event.ActionEvent;

public class BaixaPatrimonio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtValorRecuperado;
	private JTextField txtDocumentoComprobatorio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BaixaPatrimonio frame = new BaixaPatrimonio();
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
	public BaixaPatrimonio() {
		setResizable(false);
		setBackground(new Color(255, 255, 128));
		setForeground(new Color(255, 255, 128));
		setIconImage(Toolkit.getDefaultToolkit().getImage(BaixaPatrimonio.class.getResource("/br/com/imagemcadastro/janela/carcosaicon6.png")));
		setTitle("Cadastrar Baixa Patrimonial");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 467, 365);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 128));
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 128), new Color(255, 0, 0), new Color(255, 128, 0), new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Patrimônio:");
		lblNewLabel.setForeground(new Color(248, 199, 177));
		lblNewLabel.setFont(new Font("Sylfaen", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 11, 111, 21);
		contentPane.add(lblNewLabel);
// --------------------------------------------------------------------------------	
		DAOPatrimonio dauPatrimonio = new DAOPatrimonio();	
		
		JComboBox cbxPatrimonio = new JComboBox();
		cbxPatrimonio.setFont(new Font("Sylfaen", Font.PLAIN, 11));
		cbxPatrimonio.setBackground(new Color(53, 0, 0));
		cbxPatrimonio.setForeground(new Color(248, 199, 177));
		cbxPatrimonio.setBounds(10, 28, 222, 21);
		contentPane.add(cbxPatrimonio);
		
		List<br.com.exemplo.pojo.Patrimonio> lstp = dauPatrimonio.listar();
		for(br.com.exemplo.pojo.Patrimonio pa : lstp) {
			cbxPatrimonio.addItem(pa);
		}
// -----------------------------------------------------------------------	
		DAOUsuario dauUsuario = new DAOUsuario();
		
		JComboBox cbxUsuario = new JComboBox();
		cbxUsuario.setFont(new Font("Sylfaen", Font.PLAIN, 11));
		cbxUsuario.setForeground(new Color(248, 199, 177));
		cbxUsuario.setBackground(new Color(53, 0, 0));
		cbxUsuario.setBounds(10, 77, 222, 21);
		contentPane.add(cbxUsuario);
		
		List<Usuarios> lstu = dauUsuario.listaAtivos();
		for(Usuarios us : lstu) {
			cbxUsuario.addItem(us);

		}		
// -------------------------------------------------------------------------------------		
		JLabel lblUsurio = new JLabel("Usuário:");
		lblUsurio.setForeground(new Color(248, 199, 177));
		lblUsurio.setFont(new Font("Sylfaen", Font.BOLD, 15));
		lblUsurio.setBounds(10, 60, 111, 21);
		contentPane.add(lblUsurio);
		
		JLabel lblTipoBaixa = new JLabel("Tipo Baixa:");
		lblTipoBaixa.setForeground(new Color(255, 219, 183));
		lblTipoBaixa.setFont(new Font("Sylfaen", Font.BOLD, 15));
		lblTipoBaixa.setBounds(10, 109, 111, 21);
		contentPane.add(lblTipoBaixa);
		
		JComboBox cbxTipoBaixa = new JComboBox();
		cbxTipoBaixa.setFont(new Font("Sylfaen", Font.PLAIN, 11));
		cbxTipoBaixa.setForeground(new Color(248, 199, 177));
		cbxTipoBaixa.setBackground(new Color(53, 0, 0));
		cbxTipoBaixa.setModel(new DefaultComboBoxModel(TipoBaixa.values()));
		cbxTipoBaixa.setBounds(10, 126, 222, 21);
		contentPane.add(cbxTipoBaixa);
		
		JLabel lblValorRecuperado = new JLabel("Valor Recuperado:");
		lblValorRecuperado.setBackground(new Color(80, 9, 1));
		lblValorRecuperado.setForeground(new Color(80, 9, 1));
		lblValorRecuperado.setFont(new Font("Sylfaen", Font.BOLD, 15));
		lblValorRecuperado.setBounds(255, 11, 152, 21);
		contentPane.add(lblValorRecuperado);
		
		txtValorRecuperado = new JTextField();
		txtValorRecuperado.setForeground(new Color(248, 199, 177));
		txtValorRecuperado.setBackground(new Color(53, 0, 0));
		txtValorRecuperado.setBounds(254, 28, 187, 21);
		contentPane.add(txtValorRecuperado);
		txtValorRecuperado.setColumns(10);
		
		JLabel lblDocumentoComprobatorio = new JLabel("Documento Comprobatorio:");
		lblDocumentoComprobatorio.setForeground(new Color(80, 9, 1));
		lblDocumentoComprobatorio.setFont(new Font("Sylfaen", Font.BOLD, 15));
		lblDocumentoComprobatorio.setBounds(254, 60, 199, 21);
		contentPane.add(lblDocumentoComprobatorio);
		
		txtDocumentoComprobatorio = new JTextField();
		txtDocumentoComprobatorio.setForeground(new Color(248, 199, 177));
		txtDocumentoComprobatorio.setBackground(new Color(53, 0, 0));
		txtDocumentoComprobatorio.setColumns(10);
		txtDocumentoComprobatorio.setBounds(254, 77, 187, 21);
		contentPane.add(txtDocumentoComprobatorio);
		
		JLabel lblMotivo = new JLabel("Motivo:");
		lblMotivo.setForeground(new Color(248, 199, 177));
		lblMotivo.setFont(new Font("Sylfaen", Font.BOLD, 15));
		lblMotivo.setBounds(10, 158, 199, 21);
		contentPane.add(lblMotivo);
		
		JTextArea txtMotivo = new JTextArea();
		txtMotivo.setForeground(new Color(248, 199, 177));
		txtMotivo.setBackground(new Color(53, 0, 0));
		txtMotivo.setBounds(10, 176, 270, 50);
		contentPane.add(txtMotivo);
		
		JButton btnCadastrar = new JButton("CADASTRAR");

		btnCadastrar.setForeground(new Color(248, 199, 177));
		btnCadastrar.setBackground(new Color(53, 0, 0));
		btnCadastrar.setFont(new Font("Sylfaen", Font.BOLD, 16));
		btnCadastrar.setBounds(10, 272, 435, 43);
		contentPane.add(btnCadastrar);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(BaixaPatrimonio.class.getResource("/br/com/imagemcadastro/janela/carcosaicon6.jpg")));
		lblNewLabel_1.setBounds(0, -19, 668, 621);
		contentPane.add(lblNewLabel_1);
		
		
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				//Instância da classe BaixaPatrimonio e Instância da classe DAO
				br.com.exemplo.pojo.BaixaPatrimonio bp = new br.com.exemplo.pojo.BaixaPatrimonio();
				DAOBaixaPatrimonio dbp = new DAOBaixaPatrimonio();
			
				br.com.exemplo.pojo.Patrimonio p = (br.com.exemplo.pojo.Patrimonio)cbxPatrimonio.getSelectedItem();
				bp.setPatrimonio_id(p.getId());
				
				Usuarios us = (Usuarios)cbxUsuario.getSelectedItem();
				bp.setUsuario_registro_id(us.getId());
				
				bp.setTipo_baixa((br.com.exemplo.pojo.TipoBaixa) cbxTipoBaixa.getSelectedItem());
				
				bp.setMotivo(txtMotivo.getText());
				bp.setValor_recuperado(Double.parseDouble(txtValorRecuperado.getText()));
				bp.setDocumento_comprobatorio(txtDocumentoComprobatorio.getText());

		
				String m = dbp.cadastrar(bp);
				JOptionPane.showMessageDialog(null, m);
				
				
			}
		});

	}
}
