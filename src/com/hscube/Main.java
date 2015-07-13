package com.hscube;

import java.awt.EventQueue;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				FrameMain frame;
				frame = new FrameMain();
				frame.setVisible(true);
			}

		});

	}

}
