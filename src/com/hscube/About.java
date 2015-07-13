package com.hscube;
import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;
/*
 * Created by JFormDesigner on Sun Jul 12 22:41:36 CDT 2015
 */



/**
 * @author s s
 */
public class About extends JFrame {
	public About() {
		initComponents();
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - s s
		label1 = new JLabel();
		label2 = new JLabel();
		label3 = new JLabel();
		label4 = new JLabel();
		label5 = new JLabel();
		label6 = new JLabel();
		label7 = new JLabel();
		label8 = new JLabel();

		//======== this ========
		setTitle("About Shopping List");
		Container contentPane = getContentPane();

		//---- label1 ----
		label1.setText("Shopping List");
		label1.setFont(new Font("Lucida Grande", Font.PLAIN, 26));

		//---- label2 ----
		label2.setText("v1.0.0");

		//---- label3 ----
		label3.setText("Developers:");

		//---- label4 ----
		label4.setText("Hari Krishna Chaudhary");

		//---- label5 ----
		label5.setText("Sagar Giri");

		//---- label6 ----
		label6.setText("Saugat Ligal");

		//---- label7 ----
		label7.setText("Sudeep Bagale");

		//---- label8 ----
		label8.setText("aserasdfasdf");
		label8.setBackground(new Color(255, 51, 153));

		GroupLayout contentPaneLayout = new GroupLayout(contentPane);
		contentPane.setLayout(contentPaneLayout);
		contentPaneLayout.setHorizontalGroup(
			contentPaneLayout.createParallelGroup()
				.addGroup(contentPaneLayout.createSequentialGroup()
					.addGroup(contentPaneLayout.createParallelGroup()
						.addGroup(contentPaneLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
								.addComponent(label3, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
								.addComponent(label1, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(label2, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE))
						.addGroup(contentPaneLayout.createSequentialGroup()
							.addGap(45, 45, 45)
							.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
								.addComponent(label4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(label5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(label6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(label7, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(178, Short.MAX_VALUE))
				.addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
					.addGap(0, 206, Short.MAX_VALUE)
					.addComponent(label8, GroupLayout.PREFERRED_SIZE, 232, GroupLayout.PREFERRED_SIZE)
					.addGap(130, 130, 130))
		);
		contentPaneLayout.setVerticalGroup(
			contentPaneLayout.createParallelGroup()
				.addGroup(contentPaneLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(label1, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
						.addComponent(label2, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addGap(41, 41, 41)
					.addComponent(label3)
					.addGap(35, 35, 35)
					.addComponent(label4)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(label5)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(label6)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(label7)
					.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
					.addComponent(label8, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(24, Short.MAX_VALUE))
		);
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - s s
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	private JLabel label5;
	private JLabel label6;
	private JLabel label7;
	private JLabel label8;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
