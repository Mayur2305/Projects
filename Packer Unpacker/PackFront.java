package temp;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PackFront extends JFrame {

	private JPanel contentPane;
	private JTextField tf_dirname;
	private JTextField tf_destname;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					PackFront frame = new PackFront();
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
	public PackFront(){
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLUE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Directory Path  :");
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 16));
		lblNewLabel.setForeground(Color.WHITE);
		
		JLabel lblDestinationName = new JLabel("Destination name : ");
		lblDestinationName.setForeground(Color.WHITE);
		lblDestinationName.setFont(new Font("Calibri", Font.BOLD, 16));
		
		tf_dirname = new JTextField();
		tf_dirname.setColumns(10);
		
		tf_destname = new JTextField();
		tf_destname.setColumns(10);
		
		JButton btnNewButton = new JButton("Pack");
		JLabel lblMessage = new JLabel("");
		lblMessage.setForeground(Color.WHITE);
		lblMessage.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 18));
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Packer pack=new Packer();
				String str=tf_dirname.getText();
				String str1=tf_destname.getText();
				try 
				{						
					if(pack.Packing(str,str1) && !(tf_dirname.getText().equals("") && tf_destname.getText().equals("")))
					{
						lblMessage.setText("Successfully packed...");
					}
					else
					{
						lblMessage.setText("Invalid Directory Path or Invalid destination !");
					}
				} 
				catch (Exception e1) 
				{
					e1.printStackTrace();
				}
			}	
		});
		
		JButton btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
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
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(176)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(lblNewLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblDestinationName, Alignment.LEADING))
								.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
								.addComponent(tf_dirname, GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
								.addComponent(tf_destname)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(297)
							.addComponent(lblMessage)))
					.addContainerGap(111, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(125)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
						.addComponent(tf_dirname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(39)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDestinationName, GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
						.addComponent(tf_destname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(56)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1))
					.addGap(46)
					.addComponent(lblMessage)
					.addGap(102))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
