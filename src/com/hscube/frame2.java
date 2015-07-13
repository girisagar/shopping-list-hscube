package com.hscube;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;
/*
 * Created by JFormDesigner on Sun Jul 12 14:29:45 CDT 2015
 */



/**
 * @author s s
 */
public class frame2 extends JFrame {
	public frame2() {
		initComponents();
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - s s
		button1 = new JButton();

		//======== this ========
		Container contentPane = getContentPane();

		//---- button1 ----
		button1.setText("text");

		GroupLayout contentPaneLayout = new GroupLayout(contentPane);
		contentPane.setLayout(contentPaneLayout);
		contentPaneLayout.setHorizontalGroup(
			contentPaneLayout.createParallelGroup()
				.addGroup(contentPaneLayout.createSequentialGroup()
					.addGap(87, 87, 87)
					.addComponent(button1)
					.addContainerGap(236, Short.MAX_VALUE))
		);
		contentPaneLayout.setVerticalGroup(
			contentPaneLayout.createParallelGroup()
				.addGroup(contentPaneLayout.createSequentialGroup()
					.addGap(80, 80, 80)
					.addComponent(button1)
					.addContainerGap(167, Short.MAX_VALUE))
		);
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - s s
	private JButton button1;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
