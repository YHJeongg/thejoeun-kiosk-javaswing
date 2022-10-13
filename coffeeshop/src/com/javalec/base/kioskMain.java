package com.javalec.base;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class kioskMain {

	private JFrame frmKiosk;
	private Image background = new ImageIcon(kioskMain.class.getResource("../images/advertisement.png")).getImage();
	private JLabel lblAdvertisement;
	private JLabel lblExplanation;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					kioskMain window = new kioskMain();
					window.frmKiosk.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public kioskMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmKiosk = new JFrame();
		frmKiosk.setTitle("Kiosk");
		frmKiosk.setBounds(100, 100, 400, 600);
		frmKiosk.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmKiosk.getContentPane().setLayout(null);
		frmKiosk.getContentPane().add(getLblExplanation());
		frmKiosk.getContentPane().add(getLblAdvertisement());
	}
	private JLabel getLblAdvertisement() {
		if (lblAdvertisement == null) {
			lblAdvertisement = new JLabel("");
			lblAdvertisement.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					kioskOrder.main(null);
					frmKiosk.setVisible(false);
				}
			});
			lblAdvertisement.setIcon(new ImageIcon(kioskMain.class.getResource("/com/javalec/images/advertisement.png")));
			lblAdvertisement.setBounds(0, 0, 400, 572);
		}
		return lblAdvertisement;
	}
	private JLabel getLblExplanation() {
		if (lblExplanation == null) {
			lblExplanation = new JLabel("화면터치 > 상품선택 > 결제 / 주문서확인 > 주문완료");
			lblExplanation.setForeground(new Color(254, 255, 255));
			lblExplanation.setBackground(new Color(121, 121, 121));
			lblExplanation.setHorizontalAlignment(SwingConstants.CENTER);
			lblExplanation.setBounds(0, 532, 400, 40);
			lblExplanation.setOpaque(true);
		}
		return lblExplanation;
	}
}
