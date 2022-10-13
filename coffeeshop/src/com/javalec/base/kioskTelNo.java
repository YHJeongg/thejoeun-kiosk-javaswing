package com.javalec.base;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.javalec.dao.kioskTelNoDao;
import com.javalec.dto.kioskTelNoDto;
import com.javalec.util.RoundedButton;

public class kioskTelNo implements ActionListener {

	private JFrame frmTelNo;
	private JPanel plInsertTelNo;
	private JPanel panel;
	private JTextField tfTelNo;
	private RoundedButton btnCancel;
	private RoundedButton btnCompletion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					kioskTelNo window = new kioskTelNo();
					window.frmTelNo.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public kioskTelNo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTelNo = new JFrame();
		frmTelNo.getContentPane().setBackground(new Color(254, 255, 255));
		frmTelNo.getContentPane().setLayout(null);
		frmTelNo.setBackground(new Color(254, 255, 255));
		frmTelNo.setTitle("전화번호를 입력하세요.");
		frmTelNo.setBounds(100, 100, 300, 450);
		frmTelNo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(254, 255, 255));
		panel.setBounds(6, 70, 288, 300);
		panel.setLayout(new GridLayout(4, 3, 5, 5));
		frmTelNo.getContentPane().add(panel);
		frmTelNo.getContentPane().add(getTextField());
		frmTelNo.getContentPane().add(getBtnCancel());
		frmTelNo.getContentPane().add(getBtnCompletion());
		
		RoundedButton[] bt = new RoundedButton[12];
		bt[0] = new RoundedButton("7");
		bt[1] = new RoundedButton("8");
		bt[2] = new RoundedButton("9");
		bt[3] = new RoundedButton("4");
		bt[4] = new RoundedButton("5");
		bt[5] = new RoundedButton("6");
		bt[6] = new RoundedButton("1");
		bt[7] = new RoundedButton("2");
		bt[8] = new RoundedButton("3");
		bt[9] = new RoundedButton("C");
		bt[10] = new RoundedButton("0");
		bt[11] = new RoundedButton("<-");

		for (int i = 0; i < 12; i++) {
			panel.add(bt[i]);
			bt[i].addActionListener(this);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();

		if (actionCommand.equals("<-")) {
			int a = tfTelNo.getText().length();
			String b = tfTelNo.getText().substring(0, a - 1);
			tfTelNo.setText(b);
		} else if (actionCommand.equals("C")) {
			String b = tfTelNo.getText().substring(0, 0);
			tfTelNo.setText(b);
		} else {
			tfTelNo.setText(tfTelNo.getText() + actionCommand);
		}
	}

	private JTextField getTextField() {
		if (tfTelNo == null) {
			tfTelNo = new JTextField();
			tfTelNo.setEditable(false);
			tfTelNo.setBounds(6, 6, 288, 52);
			tfTelNo.setColumns(10);
		}
		return tfTelNo;
	}
	private JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new RoundedButton("취소");
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					kioskMain.main(null);
					frmTelNo.setVisible(false);
				}
			});
			btnCancel.setBounds(6, 387, 117, 29);
		}
		return btnCancel;
	}
	private JButton getBtnCompletion() {
		if (btnCompletion == null) {
			btnCompletion = new RoundedButton("완료");
			btnCompletion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					checkTelNo();
				}
			});
			btnCompletion.setBounds(177, 387, 117, 29);
		}
		return btnCompletion;
	}
	
	private void checkTelNo() {
		
		String custphone = tfTelNo.getText();
		kioskTelNoDao dao = new kioskTelNoDao(custphone);
		if (dao.checkCustPhone() == null) {
			JOptionPane.showMessageDialog(null, "등록되지 않은 회원입니다.");
			tfTelNo.setText("");
		} else {
			kioskPayment.main(null);
			frmTelNo.setVisible(false);
		}
		
	}
}
