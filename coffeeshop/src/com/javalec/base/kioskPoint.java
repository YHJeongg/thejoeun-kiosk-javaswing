package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;

import com.javalec.util.RoundedButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class kioskPoint {

	private JFrame frmPoint;
	private RoundedButton btnNewButton;
	private RoundedButton btnNewButton_1;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					kioskPoint window = new kioskPoint();
					window.frmPoint.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public kioskPoint() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPoint = new JFrame();
		frmPoint.getContentPane().setBackground(new Color(254, 255, 255));
		frmPoint.setTitle("Point 적립");
		frmPoint.setBounds(100, 100, 300, 170);
		frmPoint.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPoint.getContentPane().setLayout(null);
		frmPoint.getContentPane().add(getBtnNewButton());
		frmPoint.getContentPane().add(getBtnNewButton_1());
		frmPoint.getContentPane().add(getLblNewLabel());
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new RoundedButton("예");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					kioskTelNo.main(null);
					frmPoint.setVisible(false);
				}
			});
			btnNewButton.setBounds(26, 77, 117, 29);
		}
		return btnNewButton;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new RoundedButton("아니오");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					kioskPayment.main(null);
					frmPoint.setVisible(false);
					for (int i = 0; i < kioskOrder.qTxt2.length; i++ ) {
//						System.out.println(kioskOrder.qTxt2[i]);
					}
					
				}
			});
			btnNewButton_1.setBounds(159, 77, 117, 29);
		}
		return btnNewButton_1;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("포인트를 적립하시겠습니까?");
			lblNewLabel.setBounds(75, 31, 167, 16);
		}
		return lblNewLabel;
	}
}
