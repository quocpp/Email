import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Date;
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
import javax.swing.JSplitPane;
import com.toedter.calendar.JDateChooser;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
public class EmailList extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane_1;
	private DefaultTableModel tableModel;
	private JSplitPane splitPane;
	private JSplitPane splitPane_1;
	private JDateChooser dateChooser;
	private JLabel lblTo;
	private JLabel lblFrom;
	private JDateChooser dateChooser_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
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
		setBounds(100, 100, 452, 403);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 212, 0, 212, 0, 0};
		gbl_contentPane.rowHeights = new int[] {59, 0, 0, 200, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		btnNewButton_3 = new JButton("By Date");
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.fill = GridBagConstraints.VERTICAL;
		gbc_btnNewButton_3.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_3.gridx = 0;
		gbc_btnNewButton_3.gridy = 0;
		contentPane.add(btnNewButton_3, gbc_btnNewButton_3);
		
		JButton btnNewButton = new JButton("+");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.VERTICAL;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 0;
		contentPane.add(btnNewButton, gbc_btnNewButton);
		
		JButton btnNewButton_1 = new JButton("-");
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.fill = GridBagConstraints.VERTICAL;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 3;
		gbc_btnNewButton_1.gridy = 0;
		contentPane.add(btnNewButton_1, gbc_btnNewButton_1);
		
		btnNewButton.setActionCommand("+");
		btnNewButton_1.setActionCommand("-");
		btnNewButton_3.setActionCommand("ByDate");
		
		btnNewButton_4 = new JButton("By Both");
		GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
		gbc_btnNewButton_4.fill = GridBagConstraints.VERTICAL;
		gbc_btnNewButton_4.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_4.gridx = 4;
		gbc_btnNewButton_4.gridy = 0;
		contentPane.add(btnNewButton_4, gbc_btnNewButton_4);
		
		btnNewButton_4.setActionCommand("ByBoth");
		
		splitPane = new JSplitPane();
		GridBagConstraints gbc_splitPane = new GridBagConstraints();
		gbc_splitPane.gridwidth = 2;
		gbc_splitPane.insets = new Insets(0, 0, 5, 5);
		gbc_splitPane.fill = GridBagConstraints.BOTH;
		gbc_splitPane.gridx = 0;
		gbc_splitPane.gridy = 1;
		contentPane.add(splitPane, gbc_splitPane);
		
		dateChooser = new JDateChooser();
		splitPane.setRightComponent(dateChooser);
		
		lblFrom = new JLabel("FROM");
		splitPane.setLeftComponent(lblFrom);
		
		btnNewButton_2 = new JButton("Fillter");
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.fill = GridBagConstraints.VERTICAL;
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_2.gridx = 2;
		gbc_btnNewButton_2.gridy = 1;
		contentPane.add(btnNewButton_2, gbc_btnNewButton_2);
		
		btnNewButton_2.setActionCommand("fillter");
		
		splitPane_1 = new JSplitPane();
		GridBagConstraints gbc_splitPane_1 = new GridBagConstraints();
		gbc_splitPane_1.gridwidth = 2;
		gbc_splitPane_1.insets = new Insets(0, 0, 5, 5);
		gbc_splitPane_1.fill = GridBagConstraints.BOTH;
		gbc_splitPane_1.gridx = 3;
		gbc_splitPane_1.gridy = 1;
		contentPane.add(splitPane_1, gbc_splitPane_1);
		
		lblTo = new JLabel("TO");
		splitPane_1.setLeftComponent(lblTo);
		
		dateChooser_1 = new JDateChooser();
		splitPane_1.setRightComponent(dateChooser_1);
		
		scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane_1.gridheight = 2;
		gbc_scrollPane_1.gridwidth = 5;
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 0;
		gbc_scrollPane_1.gridy = 2;
		contentPane.add(scrollPane_1, gbc_scrollPane_1);
		String[] listColumns = new String[] {"Title","TimeStamp","Priority","Class"};
		String[][] listRows = MyEmailCtrl.GetEmailList(null,null);
		tableModel = new DefaultTableModel(listRows,listColumns);
		table = new JTable(tableModel);
		scrollPane_1.setViewportView(table);
		
		btnNewButton.addActionListener(new ButtonClickListener());
		btnNewButton_1.addActionListener(new ButtonClickListener());
		btnNewButton_2.addActionListener(new ButtonClickListener());
		btnNewButton_3.addActionListener(new ButtonClickListener());
		btnNewButton_4.addActionListener(new ButtonClickListener());
		
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
	            	String[][] listRows = MyEmailCtrl.GetEmailList(null,null);
	            	for(int i = 0; i < listRows.length; i++)
	            	{
	            		tableModel.addRow(listRows[i]);
	            	}
	            //}
	         }
	         else if (command.equals("fillter"))
	         {
	        	 Date fromDate = dateChooser.getDate();
	        	 Date toDate = dateChooser_1.getDate();
	            	tableModel.setRowCount(0);
	            	String[][] listRows = MyEmailCtrl.GetEmailList(fromDate,toDate);
	            	for(int i = 0; i < listRows.length; i++)
	            	{
	            		tableModel.addRow(listRows[i]);
	            	}
	        	 
	         }
	         else if (command.equals("ByDate"))
	         {
	        	EmailStatic.ctype = 0;
            	tableModel.setRowCount(0);
            	String[][] listRows = MyEmailCtrl.GetEmailList(dateChooser.getDate(),dateChooser_1.getDate());
            	for(int i = 0; i < listRows.length; i++)
            	{
            		tableModel.addRow(listRows[i]);
            	}
	         }
	         else if (command.equals("ByBoth"))
	         {
	        	EmailStatic.ctype = 1;	 
	        	tableModel.setRowCount(0);
            	String[][] listRows = MyEmailCtrl.GetEmailList(dateChooser.getDate(),dateChooser_1.getDate());
            	for(int i = 0; i < listRows.length; i++)
            	{
            		tableModel.addRow(listRows[i]);
            	}
	         }
	      }
	}

}
