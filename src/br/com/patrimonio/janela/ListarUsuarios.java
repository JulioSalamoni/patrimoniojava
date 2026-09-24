package br.com.patrimonio.janela;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import java.awt.Color;

public class ListarUsuarios extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private final JLabel lblNewLabel_2 = new JLabel("");

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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 463, 397);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Listar Usuario");
		lblNewLabel.setForeground(new Color(236, 254, 192));
		lblNewLabel.setFont(new Font("Sylfaen", Font.BOLD, 21));
		lblNewLabel.setBounds(10, 11, 218, 36);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 45, 427, 2);
		contentPane.add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("Código Usuário:");
		lblNewLabel_1.setForeground(new Color(236, 254, 192));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(10, 55, 103, 28);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBackground(new Color(18, 26, 0));
		textField.setForeground(new Color(236, 254, 192));
		textField.setBounds(111, 60, 117, 23);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Listar Usuário");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBackground(new Color(18, 26, 0));
		btnNewButton.setForeground(new Color(236, 254, 192));
		btnNewButton.setBounds(238, 59, 199, 28);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 94, 386, 253);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		lblNewLabel_2.setIcon(new ImageIcon(ListarUsuarios.class.getResource("/br/com/imagemcadastro/janela/carcosaicon4.jpg")));
		lblNewLabel_2.setBounds(-142, -49, 716, 674);
		contentPane.add(lblNewLabel_2);

	}

}
