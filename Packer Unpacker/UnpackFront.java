package temp;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;

public class UnpackFront extends JFrame {

	private JPanel contentPane;
	private JTextField tf_packfilename;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UnpackFront frame = new UnpackFront();
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
	public UnpackFront() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLUE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblPackedFileName = new JLabel("Packed File Name : ");
		lblPackedFileName.setForeground(Color.WHITE);
		lblPackedFileName.setFont(new Font("Calibri", Font.BOLD, 16));
		
		tf_packfilename = new JTextField();
		tf_packfilename.setColumns(10);
		
		JLabel lblMessage = new JLabel("New label");
		lblMessage.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 17));
		lblMessage.setForeground(Color.WHITE);
		
		JButton btnUnpack = new JButton("Unpack");
		
		btnUnpack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String str=tf_packfilename.getText();
				Unpacker unpack=new Unpacker();
				try 
				{
					switch(unpack.Unpacking(str))
					{
					case 1:
						lblMessage.setText("Successfully Unpacked...");
						break;
					
					case -1:
						lblMessage.setText("Wrong destination file !");
						break;
					case -2:
						lblMessage.setText("invalid file name !");
						break;
					case -3:
						lblMessage.setText("invalid Packed file !");
						break;
					}
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
				tf_packfilename.setText("");
			}
		});
		
		JButton button_1 = new JButton("BACK");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try 
				{
					dispose();
					PackUnpackFront frame = new PackUnpackFront();
					frame.setVisible(true);
				} 
				catch (Exception ex) 
				{
					ex.printStackTrace();
				}
			}
		});
		
		JButton btnNewButton = new JButton("...");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JFileChooser chooser = new JFileChooser();
				chooser.showOpenDialog(null);
				
				File f=chooser.getSelectedFile();
				String filename=f.getAbsolutePath();
				filename=filename;
				tf_packfilename.setText(filename);
			}
		});
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(136)
					.addComponent(lblPackedFileName, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
					.addGap(44)
					.addComponent(tf_packfilename, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(84, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(214, Short.MAX_VALUE)
					.addComponent(btnUnpack, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblMessage)
						.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE))
					.addGap(268))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(169)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPackedFileName, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(tf_packfilename, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addGap(80)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnUnpack, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_1))
					.addGap(40)
					.addComponent(lblMessage)
					.addContainerGap(97, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
