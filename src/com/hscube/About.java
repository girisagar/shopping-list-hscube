package com.hscube;
<<<<<<< HEAD

=======
>>>>>>> 036c6a53973759be002754dd76269dfe56d0ef57
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;


public class About extends JFrame {
	public About() {
		initComponents();
	}

	private void btnCloseActionPerformed(ActionEvent e) {
		this.setVisible(false);
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - s s
		label3 = new JLabel();
		label4 = new JLabel();
		label5 = new JLabel();
		label6 = new JLabel();
		label7 = new JLabel();
		btnClose = new JButton();
		label8 = new JLabel();
		label2 = new JLabel();

		//======== this ========
		setTitle("About Shopping List");
		setResizable(false);
		Container contentPane = getContentPane();

		//---- label3 ----
		label3.setText("Developers (HSCube):");
		label3.setForeground(Color.red);

		//---- label4 ----
		label4.setText("Hari Krishna Chaudhary");

		//---- label5 ----
		label5.setText("Sagar Giri");

		//---- label6 ----
		label6.setText("Saugat Ligal");

		//---- label7 ----
		label7.setText("Sudeep Bagale");

		//---- btnClose ----
		btnClose.setText("Close");
		btnClose.addActionListener(e -> btnCloseActionPerformed(e));

		//---- label8 ----
		label8.setIcon(new ImageIcon("src/res/icons/AddList-64.png"));
		label8.setText("Shopping List");
		label8.setFont(new Font("Lucida Grande", Font.PLAIN, 26));

		//---- label2 ----
		label2.setText("v1.0.0");

		GroupLayout contentPaneLayout = new GroupLayout(contentPane);
		contentPane.setLayout(contentPaneLayout);
		contentPaneLayout.setHorizontalGroup(
			contentPaneLayout.createParallelGroup()
				.addGroup(contentPaneLayout.createSequentialGroup()
					.addGap(8, 8, 8)
					.addGroup(contentPaneLayout.createParallelGroup()
						.addGroup(contentPaneLayout.createSequentialGroup()
							.addComponent(label8)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(label2)
							.addGap(0, 14, Short.MAX_VALUE))
						.addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
							.addComponent(label3, GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
							.addGap(7, 7, 7))
						.addGroup(contentPaneLayout.createSequentialGroup()
							.addGap(24, 24, 24)
							.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
								.addComponent(label4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(label5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(label6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(label7, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE))
							.addGap(18, 18, 18)
							.addComponent(btnClose)
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
		);
		contentPaneLayout.setVerticalGroup(
			contentPaneLayout.createParallelGroup()
				.addGroup(contentPaneLayout.createSequentialGroup()
					.addGap(16, 16, 16)
					.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(label8)
						.addComponent(label2, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addGap(18, 18, 18)
					.addComponent(label3)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(label4)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(label5)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(label6)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(label7)
						.addComponent(btnClose))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - s s
	private JLabel label3;
	private JLabel label4;
	private JLabel label5;
	private JLabel label6;
	private JLabel label7;
	private JButton btnClose;
	private JLabel label8;
	private JLabel label2;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
