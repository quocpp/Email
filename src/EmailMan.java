import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class EmailMan extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JComboBox comboBox;


	/**
	 * Create the frame.
	 */
	public EmailMan() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(5, 2, 0, 0));
		
		JLabel lblNewLabel = new JLabel("Title");
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Priority");
		contentPane.add(lblNewLabel_1);
		
		comboBox = new JComboBox(EmailPriority.values());
		contentPane.add(comboBox);

		JButton btnOk = new JButton("OK");
		contentPane.add(btnOk);
		
		JButton btnCancel = new JButton("Cancel");
		contentPane.add(btnCancel);
		
		btnOk.setActionCommand("OK");
		btnCancel.setActionCommand("Cancel");
		
		btnOk.addActionListener(new ButtonClickListener());
		btnCancel.addActionListener(new ButtonClickListener());
	}

	private class ButtonClickListener implements ActionListener{
	      public void actionPerformed(ActionEvent e) {
	         String command = e.getActionCommand();  
	         EmailCrtl MyEmailCrtl = new EmailCrtl();
	         if( command.equals( "OK" ))  {
	        	 try {
	        		    Email newEmail = new Email(textField.getText(),new Date(),
	        		    		(EmailPriority)comboBox.getSelectedItem());
	        		    MyEmailCrtl.addDataToQueue(newEmail);
	        		 	EmailList frame = new EmailList();
						frame.setVisible(true);
						dispose();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
	         }
	         else if( command.equals( "Cancel" ) )  {
	        	 try {
	        		 dispose();
	        		 EmailList frame = new EmailList();
						frame.setVisible(true);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
	         }
	         else  {
	            
	         }  	
	      }
	}
}
