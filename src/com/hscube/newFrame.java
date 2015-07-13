package com.hscube;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;
/*
 * Created by JFormDesigner on Sun Jul 12 16:12:43 CDT 2015
 */



/**
 * @author s s
 */
public class newFrame extends JFrame {
	public newFrame() {
		initComponents();
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - s s
		label1 = new JLabel();
		txtName = new JTextField();
		label2 = new JLabel();
		comboboxCategory = new JComboBox<>();
		comboboxPriority = new JComboBox<>();
		label3 = new JLabel();
		label4 = new JLabel();
		spinner1 = new JSpinner();
		button8 = new JButton();
		button9 = new JButton();

		//======== this ========
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		Container contentPane = getContentPane();

		//---- label1 ----
		label1.setText("Name:");

		//---- label2 ----
		label2.setText("Category:");

		//---- comboboxCategory ----
		comboboxCategory.setModel(new DefaultComboBoxModel<>(new String[] {
			"Electronics",
			"Fashion",
			"Health"
		}));

		//---- comboboxPriority ----
		comboboxPriority.setModel(new DefaultComboBoxModel<>(new String[] {
			"High",
			"Moderate",
			"Low"
		}));

		//---- label3 ----
		label3.setText("Priority:");

		//---- label4 ----
		label4.setText("Quantity:");

		//---- button8 ----
		button8.setText("Add");

		//---- button9 ----
		button9.setText("Cancel");

		GroupLayout contentPaneLayout = new GroupLayout(contentPane);
		contentPane.setLayout(contentPaneLayout);
		contentPaneLayout.setHorizontalGroup(
			contentPaneLayout.createParallelGroup()
				.addGroup(contentPaneLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(contentPaneLayout.createParallelGroup()
						.addGroup(contentPaneLayout.createSequentialGroup()
							.addComponent(label1, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
							.addGap(10, 10, 10)
							.addComponent(txtName, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE))
						.addGroup(contentPaneLayout.createSequentialGroup()
							.addComponent(label2, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
							.addGap(11, 11, 11)
							.addComponent(comboboxCategory, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE))
						.addGroup(contentPaneLayout.createSequentialGroup()
							.addComponent(label3, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
							.addGap(11, 11, 11)
							.addComponent(comboboxPriority, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE))
						.addGroup(contentPaneLayout.createSequentialGroup()
							.addComponent(label4, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
							.addGap(14, 14, 14)
							.addComponent(spinner1, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
						.addGroup(contentPaneLayout.createSequentialGroup()
							.addComponent(button8)
							.addGap(146, 146, 146)
							.addComponent(button9)))
					.addContainerGap(16, Short.MAX_VALUE))
		);
		contentPaneLayout.setVerticalGroup(
			contentPaneLayout.createParallelGroup()
				.addGroup(contentPaneLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(contentPaneLayout.createParallelGroup()
						.addGroup(contentPaneLayout.createSequentialGroup()
							.addGap(6, 6, 6)
							.addComponent(label1))
						.addComponent(txtName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(8, 8, 8)
					.addGroup(contentPaneLayout.createParallelGroup()
						.addGroup(contentPaneLayout.createSequentialGroup()
							.addGap(4, 4, 4)
							.addComponent(label2))
						.addComponent(comboboxCategory, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(4, 4, 4)
					.addGroup(contentPaneLayout.createParallelGroup()
						.addGroup(contentPaneLayout.createSequentialGroup()
							.addGap(4, 4, 4)
							.addComponent(label3))
						.addComponent(comboboxPriority, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(10, 10, 10)
					.addGroup(contentPaneLayout.createParallelGroup()
						.addGroup(contentPaneLayout.createSequentialGroup()
							.addGap(6, 6, 6)
							.addComponent(label4))
						.addComponent(spinner1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(16, 16, 16)
					.addGroup(contentPaneLayout.createParallelGroup()
						.addComponent(button8)
						.addComponent(button9))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - s s
	private JLabel label1;
	private JTextField txtName;
	private JLabel label2;
	private JComboBox<String> comboboxCategory;
	private JComboBox<String> comboboxPriority;
	private JLabel label3;
	private JLabel label4;
	private JSpinner spinner1;
	private JButton button8;
	private JButton button9;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
