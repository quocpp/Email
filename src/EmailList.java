import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JScrollBar;
import java.awt.ScrollPane;
import javax.swing.JScrollPane;

public class EmailList extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane_1;
	private DefaultTableModel tableModel;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					EmailList frame = new EmailList();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	/**
	 * Create the frame.
	 */
	public EmailList() {
		EmailCrtl MyEmailCtrl = new EmailCrtl();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{212, 212, 0};
		gbl_contentPane.rowHeights = new int[]{59, 0, 125, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JButton btnNewButton = new JButton("+");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.VERTICAL;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 0;
		contentPane.add(btnNewButton, gbc_btnNewButton);
		
		JButton btnNewButton_1 = new JButton("-");
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.fill = GridBagConstraints.VERTICAL;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_1.gridx = 1;
		gbc_btnNewButton_1.gridy = 0;
		contentPane.add(btnNewButton_1, gbc_btnNewButton_1);
		
		btnNewButton.setActionCommand("+");
		btnNewButton_1.setActionCommand("-");
		
		scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.gridheight = 2;
		gbc_scrollPane_1.gridwidth = 2;
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane_1.gridx = 0;
		gbc_scrollPane_1.gridy = 1;
		contentPane.add(scrollPane_1, gbc_scrollPane_1);
		String[] listColumns = new String[] {"Title","TimeStamp","Priority","Class"};
		String[][] listRows = MyEmailCtrl.GetEmailList();
		tableModel = new DefaultTableModel(listRows,listColumns);
		table = new JTable(tableModel);
		scrollPane_1.setViewportView(table);
		
		btnNewButton.addActionListener(new ButtonClickListener());
		btnNewButton_1.addActionListener(new ButtonClickListener());
		
	}
	
	
	private class ButtonClickListener implements ActionListener{
	      public void actionPerformed(ActionEvent e) {
	         String command = e.getActionCommand();  
	         EmailCrtl MyEmailCtrl = new EmailCrtl();
	         if( command.equals( "+" ))  {
	        	 try {
	        		 dispose();
	        		 EmailMan frame = new EmailMan();
					  frame.setVisible(true);
					  
					} catch (Exception e1) {
						e1.printStackTrace();
					}
	         }
	         else if( command.equals( "-" ) )  {
	            //int selectedRows = 0;
	            //selectedRows = table.getSelectedRow();
	            //if(selectedRows >= 0)
	            //{
	            	MyEmailCtrl.RemoveDataToQueue(EmailStatic.EmailQueueArray.get(0));
	            	tableModel.setRowCount(0);
	            	String[][] listRows = MyEmailCtrl.GetEmailList();
	            	for(int i = 0; i < listRows.length; i++)
	            	{
	            		tableModel.addRow(listRows[i]);
	            	}
	            //}
	         } 	
	      }
	}

}
