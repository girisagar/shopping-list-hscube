package com.hscube;
import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.*;
/*
 * Created by JFormDesigner on Wed Jul 15 10:32:43 CDT 2015
 */



/**
 * @author s s
 */
public class printForm extends JFrame {
	public printForm() {
		initComponents();
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - s s
		scrollPane1 = new JScrollPane();
		tblPrintFinal = new JTable();
		btnPrintFinal = new JButton();

		//======== this ========
		setTitle("Print Table");
		setResizable(false);
		Container contentPane = getContentPane();

		//======== scrollPane1 ========
		{

			//---- tblPrintFinal ----
			tblPrintFinal.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null, null, null},
					{null, null, null, null},
				},
				new String[] {
					"Name", "Category", "Priority", "Quantity"
				}
			) {
				boolean[] columnEditable = new boolean[] {
					false, true, true, true
				};
				@Override
				public boolean isCellEditable(int rowIndex, int columnIndex) {
					return columnEditable[columnIndex];
				}
			});
			{
				TableColumnModel cm = tblPrintFinal.getColumnModel();
				cm.getColumn(0).setResizable(false);
			}
			scrollPane1.setViewportView(tblPrintFinal);
		}

		//---- btnPrintFinal ----
		btnPrintFinal.setText("Print");

		GroupLayout contentPaneLayout = new GroupLayout(contentPane);
		contentPane.setLayout(contentPaneLayout);
		contentPaneLayout.setHorizontalGroup(
			contentPaneLayout.createParallelGroup()
				.addGroup(contentPaneLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(contentPaneLayout.createParallelGroup()
						.addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 743, Short.MAX_VALUE)
						.addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
							.addGap(0, 668, Short.MAX_VALUE)
							.addComponent(btnPrintFinal)))
					.addContainerGap())
		);
		contentPaneLayout.setVerticalGroup(
			contentPaneLayout.createParallelGroup()
				.addGroup(contentPaneLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 393, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(btnPrintFinal)
					.addContainerGap(7, Short.MAX_VALUE))
		);
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - s s
	private JScrollPane scrollPane1;
	private JTable tblPrintFinal;
	private JButton btnPrintFinal;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
