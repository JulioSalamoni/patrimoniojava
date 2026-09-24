package br.com.patrimonio.janela;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;

public class CarcosaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CarcosaPrincipal frame = new CarcosaPrincipal();
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
	public CarcosaPrincipal() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(CarcosaPrincipal.class.getResource("/br/com/imagemcadastro/janela/CarcosaSplash.png")));
		setTitle("Sistema Gestão de Patrimônio Carcosa");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(100, 100, 2000, 1100);
		// Abrir a tela sempre maximizada
		setExtendedState(MAXIMIZED_BOTH);

		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnCadstrar = new JMenu("Cadastrar");
		mnCadstrar.setIcon(null);
		mnCadstrar.setMnemonic('c');
		menuBar.add(mnCadstrar);
		
		JMenuItem ItemUsuario = new JMenuItem("Usuario");
		ItemUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				br.com.patrimonio.janela.patrimoniojanela formUsuarios= new br.com.patrimonio.janela.patrimoniojanela();
				formUsuarios.setVisible(true);
				
			}
		});
		ItemUsuario.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, InputEvent.CTRL_DOWN_MASK | InputEvent.SHIFT_DOWN_MASK));
		ItemUsuario.setBackground(new Color(255, 254, 210));
		ItemUsuario.setIcon(null);
		mnCadstrar.add(ItemUsuario);
		
		JMenuItem ItemCurso = new JMenuItem("Curso");
		ItemCurso.setIcon(null);
		ItemCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Cursos formCursos = new Cursos();
				formCursos.setVisible(true);
				
			}
		});
		ItemCurso.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK | InputEvent.SHIFT_DOWN_MASK));
		ItemCurso.setBackground(new Color(255, 253, 168));
		mnCadstrar.add(ItemCurso);
		
		JMenuItem ItemLocais = new JMenuItem("Locais");
		ItemLocais.setIcon(null);
		ItemLocais.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Locais formLocais = new Locais();
				formLocais.setVisible(true);
				
			}
		});
		ItemLocais.setBackground(new Color(255, 252, 138));
		mnCadstrar.add(ItemLocais);
		
		JMenuItem ItemCategoria = new JMenuItem("Categoria");
		ItemCategoria.setIcon(null);
		ItemCategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Categorias formCategorias = new Categorias();
				formCategorias.setVisible(true);
				
			}
		});
		ItemCategoria.setBackground(new Color(255, 251, 83));
		mnCadstrar.add(ItemCategoria);
		
		JMenuItem ItemPatrimonio = new JMenuItem("Patrimônio");
		ItemPatrimonio.setIcon(null);
		ItemPatrimonio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Patrimonio formPatrimonio = new Patrimonio();
				formPatrimonio.setVisible(true);
				
			}
		});
		
		ItemPatrimonio.setBackground(new Color(255, 249, 0));
		mnCadstrar.add(ItemPatrimonio);
		
		JMenuItem ItemMovimentacao = new JMenuItem("Movimentação");
		ItemMovimentacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Movimentacoes formPatrimonio = new Movimentacoes();
				formPatrimonio.setVisible(true);
			}
		});
		ItemMovimentacao.setBackground(new Color(221, 216, 0));
		mnCadstrar.add(ItemMovimentacao);
		
		
		
		JMenuItem ItemBaixarPatrimonio = new JMenuItem("Baixar Patrimônio");
		ItemBaixarPatrimonio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				BaixaPatrimonio formPatrimonio = new BaixaPatrimonio();
				formPatrimonio.setVisible(true);
			}
		});
		ItemBaixarPatrimonio.setBackground(new Color(176, 172, 0));
		mnCadstrar.add(ItemBaixarPatrimonio);
		
		JMenu mnConsulta = new JMenu("Consulta");
		mnConsulta.setMnemonic('s');
		menuBar.add(mnConsulta);
		
		JMenu ItemListarTudo = new JMenu("Listar Tudo");
		mnConsulta.add(ItemListarTudo);
		
		JMenuItem ItemLstUsuario = new JMenuItem("Usuário");
		ItemListarTudo.add(ItemLstUsuario);
		
		JMenuItem ItemLstCursos = new JMenuItem("Cursos");
		ItemLstCursos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new ListarCursos().setVisible(true);
			}
		});
		ItemListarTudo.add(ItemLstCursos);
		
		JMenuItem ItemLstLocais = new JMenuItem("Locais");
		ItemListarTudo.add(ItemLstLocais);
		
		JMenuItem ItemLstPatrimonio = new JMenuItem("Patrimônio");
		ItemListarTudo.add(ItemLstPatrimonio);
		
		JMenu ItemPesquisarPorID = new JMenu("Pesquisar Por ID");
		mnConsulta.add(ItemPesquisarPorID);
		
		JMenuItem ItemPorIDMovientacao = new JMenuItem("Movimentação");
		ItemPesquisarPorID.add(ItemPorIDMovientacao);
		
		JMenuItem ItemPorIDBaixarPatrimonio = new JMenuItem("Baixar Patrimônio");
		ItemPesquisarPorID.add(ItemPorIDBaixarPatrimonio);
		
		JSeparator separator = new JSeparator();
		mnConsulta.add(separator);
		
		JMenu ItemConsultaUsuário = new JMenu("Usuário Por...");
		mnConsulta.add(ItemConsultaUsuário);
		
		JMenuItem ItemConsultaPerfil = new JMenuItem("Perfil");
		ItemConsultaUsuário.add(ItemConsultaPerfil);
		
		JMenuItem ItemConsultaEmail = new JMenuItem("E-Mail");
		ItemConsultaUsuário.add(ItemConsultaEmail);
		
		JSeparator separator_1 = new JSeparator();
		mnConsulta.add(separator_1);
		
		JMenu ItemConsultaMovimentacao = new JMenu("Movimentação");
		mnConsulta.add(ItemConsultaMovimentacao);
		
		JMenuItem ItemConsultaTipo = new JMenuItem("Tipo");
		ItemConsultaMovimentacao.add(ItemConsultaTipo);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBounds(0,0,getWidth(),getHeight());
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);
		toolBar.setForeground(new Color(0, 0, 0));
		toolBar.setBackground(new Color(255, 254, 213));
		toolBar.setBounds(0, 0, 2000, 29);
		contentPane.add(toolBar);
		
		JButton brnAbrirUsuario = new JButton("");
		brnAbrirUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				br.com.patrimonio.janela.patrimoniojanela formUsuarios= new br.com.patrimonio.janela.patrimoniojanela();
				formUsuarios.setVisible(true);
				
			}
		});
		brnAbrirUsuario.setToolTipText("Abrir formulário de Usuário.");
		brnAbrirUsuario.setIcon(new ImageIcon(CarcosaPrincipal.class.getResource("/br/com/imagemcadastro/janela/produicon.png")));
		toolBar.add(brnAbrirUsuario);
		
		JButton btnAbrirCursos = new JButton("");
		btnAbrirCursos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Cursos formCursos = new Cursos();
				formCursos.setVisible(true);
				
			}
		});
		btnAbrirCursos.setIcon(new ImageIcon(CarcosaPrincipal.class.getResource("/br/com/imagemcadastro/janela/cadicon.png")));
		btnAbrirCursos.setToolTipText("Abrir formulário de Cursos");
		toolBar.add(btnAbrirCursos);
		
		JButton btnAbrirLocais = new JButton("");
		btnAbrirLocais.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Locais formLocais = new Locais();
				formLocais.setVisible(true);
				
			}
		});
		btnAbrirLocais.setToolTipText("Abrir formulário de Locais");
		btnAbrirLocais.setIcon(new ImageIcon(CarcosaPrincipal.class.getResource("/br/com/imagemcadastro/janela/carcosaicon4.png")));
		toolBar.add(btnAbrirLocais);
		
		JButton btnAbrirCategorias = new JButton("");
		btnAbrirCategorias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Categorias formCategorias = new Categorias();
				formCategorias.setVisible(true);
				
			}
		});
		btnAbrirCategorias.setToolTipText("Abrir formulário de Categorias");
		btnAbrirCategorias.setIcon(new ImageIcon(CarcosaPrincipal.class.getResource("/br/com/imagemcadastro/janela/cadicon2.png")));
		toolBar.add(btnAbrirCategorias);
		
		JButton btnAbrirPatrimonios = new JButton("");
		btnAbrirPatrimonios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Patrimonio formPatrimonio = new Patrimonio();
				formPatrimonio.setVisible(true);
				
			}
		});
		btnAbrirPatrimonios.setToolTipText("Abrir formulário de Patrimonio");
		btnAbrirPatrimonios.setIcon(new ImageIcon(CarcosaPrincipal.class.getResource("/br/com/imagemcadastro/janela/cadicon3.png")));
		toolBar.add(btnAbrirPatrimonios);
		
		JButton btnAbrirMovimentacoes = new JButton("");
		btnAbrirMovimentacoes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Movimentacoes formPatrimonio = new Movimentacoes();
				formPatrimonio.setVisible(true);
				
			}
		});
		btnAbrirMovimentacoes.setIcon(new ImageIcon(CarcosaPrincipal.class.getResource("/br/com/imagemcadastro/janela/carcosaicon5.png")));
		toolBar.add(btnAbrirMovimentacoes);
		
		JButton btnAbrirBaixas = new JButton("");
		btnAbrirBaixas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				BaixaPatrimonio formPatrimonio = new BaixaPatrimonio();
				formPatrimonio.setVisible(true);
				
			}
		});
		btnAbrirBaixas.setIcon(new ImageIcon(CarcosaPrincipal.class.getResource("/br/com/imagemcadastro/janela/carcosaicon6.png")));
		toolBar.add(btnAbrirBaixas);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(CarcosaPrincipal.class.getResource("/br/com/imagemcadastro/janela/CarcosaPrincipal.jpg")));
		lblNewLabel.setBounds(0, -605, 2132, 2224);
		contentPane.add(lblNewLabel);

	}
}
