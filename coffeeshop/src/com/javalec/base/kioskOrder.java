package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ButtonModel;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultCellEditor;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

import com.javalec.dao.kioskOrderDao;
import com.javalec.dto.kioskOrderDto;
import com.javalec.util.ButtonColumn;
import com.javalec.util.RoundedButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;

public class kioskOrder {

	private JFrame frmOrder;
	private JLabel lblHomeButton;
	private JLabel lblEasyKiosk;
	private JScrollPane scrollPane;
	private JTable innerTableOrderList;
	private RoundedButton btnPayment;
	private JLabel lblImage;
	private JLabel lblCoffeeIce;
	private JLabel lblCoffeeHot;
	private JLabel lblSmoothie;
	private JLabel lblAid;
	private JLabel lblTea;
	private JLabel lblJucie;
	private JScrollPane scrollPane_1;
	private JTable innerTableProductList;
	private final DefaultTableModel Outer_Table = new DefaultTableModel();
	private final DefaultTableModel Outer_Table2 = new DefaultTableModel();
	private JLabel lblNewLabel;
	private JLabel lblCountPrice;
	private JComboBox cbCount;
	public static String[] qTxt2;

	public static int sum = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					kioskOrder window = new kioskOrder();
					window.frmOrder.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public kioskOrder() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmOrder = new JFrame();
		frmOrder.setTitle("Kiosk");
		frmOrder.getContentPane().setBackground(new Color(255, 212, 120));
		frmOrder.addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				tableInit();
				tableInit2();
//				searchAction();
				searchActionCoffeeIce();
			}
		});
		frmOrder.getContentPane().setLayout(null);
		frmOrder.getContentPane().add(getLblImage());
		frmOrder.getContentPane().add(getLblHomeButton());
		frmOrder.getContentPane().add(getLblEasyKiosk());
		frmOrder.getContentPane().add(getScrollPane());
		frmOrder.getContentPane().add(getBtnPayment());
		frmOrder.getContentPane().add(getLblCoffeeIce());
		frmOrder.getContentPane().add(getLblCoffeeHot());
		frmOrder.getContentPane().add(getLblSmoothie());
		frmOrder.getContentPane().add(getLblAid());
		frmOrder.getContentPane().add(getLblTea());
		frmOrder.getContentPane().add(getLblJucie());
		frmOrder.getContentPane().add(getScrollPane_1());
		frmOrder.getContentPane().add(getLblNewLabel());
		frmOrder.getContentPane().add(getLblCountPrice());
		frmOrder.getContentPane().add(getCbCount());
		frmOrder.setBackground(new Color(255, 147, 0));
		frmOrder.setBounds(100, 100, 400, 600);
		frmOrder.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private JLabel getLblHomeButton() {
		if (lblHomeButton == null) {
			lblHomeButton = new JLabel("");
			lblHomeButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					kioskMain.main(null);
					frmOrder.setVisible(false);
				}
			});
			lblHomeButton.setHorizontalAlignment(SwingConstants.CENTER);
			lblHomeButton.setIcon(new ImageIcon(kioskOrder.class.getResource("/com/javalec/images/homebutton.png")));
			lblHomeButton.setBounds(6, 6, 40, 42);
		}
		return lblHomeButton;
	}

	private JLabel getLblEasyKiosk() {
		if (lblEasyKiosk == null) {
			lblEasyKiosk = new JLabel("Easy KIOSK");
			lblEasyKiosk.setBounds(161, 6, 74, 16);
		}
		return lblEasyKiosk;
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(6, 404, 278, 162);
			scrollPane.setViewportView(getInnerTableOrderList());
		}
		return scrollPane;
	}

	private JTable getInnerTableOrderList() {
		if (innerTableOrderList == null) {
			innerTableOrderList = new JTable() {
				public Class getColumnClass(int column) {
					return (column == 2) ? ComboBoxModel.class : Object.class;
				}
			};
			innerTableOrderList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			innerTableOrderList.setModel(Outer_Table2);
		}
		return innerTableOrderList;
	}

	private RoundedButton getBtnPayment() {
		if (btnPayment == null) {
			btnPayment = new RoundedButton();
			btnPayment.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (innerTableOrderList.getRowCount() > 0) {
						kioskPoint.main(null);
					} else {
						JOptionPane.showMessageDialog(null, "상품을 선택해주세요.");
					}
				}
			});
			btnPayment.setText("결재하기");
			btnPayment.setForeground(new Color(254, 255, 255));
			btnPayment.setBackground(new Color(121, 121, 121));
			btnPayment.setBounds(296, 511, 98, 55);
		}
		return btnPayment;
	}

	private JLabel getLblImage() {
		if (lblImage == null) {
			lblImage = new JLabel("");
			lblImage.setHorizontalAlignment(SwingConstants.CENTER);
			lblImage.setIcon(new ImageIcon(kioskOrder.class.getResource("/com/javalec/images/pngegg.png")));
			lblImage.setBounds(354, 6, 40, 42);
		}
		return lblImage;
	}

	private JLabel getLblCoffeeIce() {
		if (lblCoffeeIce == null) {
			lblCoffeeIce = new JLabel("커피(ICE)");
			lblCoffeeIce.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					tableInit();
					searchActionCoffeeIce();

					lblCoffeeIce.setBackground(new Color(0, 0, 0));
					lblCoffeeIce.setOpaque(true);
					lblCoffeeIce.setForeground(new Color(255, 255, 255));

					lblCoffeeHot.setOpaque(false);
					lblCoffeeHot.setForeground(new Color(0, 0, 0));
					lblSmoothie.setOpaque(false);
					lblSmoothie.setForeground(new Color(0, 0, 0));
					lblAid.setOpaque(false);
					lblAid.setForeground(new Color(0, 0, 0));
					lblTea.setOpaque(false);
					lblTea.setForeground(new Color(0, 0, 0));
					lblJucie.setOpaque(false);
					lblJucie.setForeground(new Color(0, 0, 0));
				}
			});
			lblCoffeeIce.setHorizontalAlignment(SwingConstants.CENTER);
			lblCoffeeIce.setBounds(6, 60, 65, 16);
		}
		return lblCoffeeIce;
	}

	private JLabel getLblCoffeeHot() {
		if (lblCoffeeHot == null) {
			lblCoffeeHot = new JLabel("커피(HOT)");
			lblCoffeeHot.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					tableInit();
					searchActionCoffeeHot();

					lblCoffeeHot.setBackground(new Color(0, 0, 0));
					lblCoffeeHot.setOpaque(true);
					lblCoffeeHot.setForeground(new Color(255, 255, 255));

					lblCoffeeIce.setOpaque(false);
					lblCoffeeIce.setForeground(new Color(0, 0, 0));
					lblSmoothie.setOpaque(false);
					lblSmoothie.setForeground(new Color(0, 0, 0));
					lblAid.setOpaque(false);
					lblAid.setForeground(new Color(0, 0, 0));
					lblTea.setOpaque(false);
					lblTea.setForeground(new Color(0, 0, 0));
					lblJucie.setOpaque(false);
					lblJucie.setForeground(new Color(0, 0, 0));
				}
			});
			lblCoffeeHot.setHorizontalAlignment(SwingConstants.CENTER);
			lblCoffeeHot.setBounds(72, 60, 65, 16);
		}
		return lblCoffeeHot;
	}

	private JLabel getLblSmoothie() {
		if (lblSmoothie == null) {
			lblSmoothie = new JLabel("스무디");
			lblSmoothie.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					tableInit();
					searchActionSmoothie();

					lblSmoothie.setBackground(new Color(0, 0, 0));
					lblSmoothie.setOpaque(true);
					lblSmoothie.setForeground(new Color(255, 255, 255));

					lblCoffeeIce.setOpaque(false);
					lblCoffeeIce.setForeground(new Color(0, 0, 0));
					lblCoffeeHot.setOpaque(false);
					lblCoffeeHot.setForeground(new Color(0, 0, 0));
					lblAid.setOpaque(false);
					lblAid.setForeground(new Color(0, 0, 0));
					lblTea.setOpaque(false);
					lblTea.setForeground(new Color(0, 0, 0));
					lblJucie.setOpaque(false);
					lblJucie.setForeground(new Color(0, 0, 0));
				}
			});
			lblSmoothie.setHorizontalAlignment(SwingConstants.CENTER);
			lblSmoothie.setBounds(138, 60, 65, 16);
		}
		return lblSmoothie;
	}

	private JLabel getLblAid() {
		if (lblAid == null) {
			lblAid = new JLabel("에이드");
			lblAid.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					tableInit();
					searchActionAid();

					lblAid.setBackground(new Color(0, 0, 0));
					lblAid.setOpaque(true);
					lblAid.setForeground(new Color(255, 255, 255));

					lblCoffeeIce.setOpaque(false);
					lblCoffeeIce.setForeground(new Color(0, 0, 0));
					lblCoffeeHot.setOpaque(false);
					lblCoffeeHot.setForeground(new Color(0, 0, 0));
					lblSmoothie.setOpaque(false);
					lblSmoothie.setForeground(new Color(0, 0, 0));
					lblTea.setOpaque(false);
					lblTea.setForeground(new Color(0, 0, 0));
					lblJucie.setOpaque(false);
					lblJucie.setForeground(new Color(0, 0, 0));
				}
			});
			lblAid.setHorizontalAlignment(SwingConstants.CENTER);
			lblAid.setBounds(202, 60, 65, 16);
		}
		return lblAid;
	}

	private JLabel getLblTea() {
		if (lblTea == null) {
			lblTea = new JLabel("차(TEA)");
			lblTea.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					tableInit();
					searchActionTea();

					lblTea.setBackground(new Color(0, 0, 0));
					lblTea.setOpaque(true);
					lblTea.setForeground(new Color(255, 255, 255));

					lblCoffeeIce.setOpaque(false);
					lblCoffeeIce.setForeground(new Color(0, 0, 0));
					lblCoffeeHot.setOpaque(false);
					lblCoffeeHot.setForeground(new Color(0, 0, 0));
					lblSmoothie.setOpaque(false);
					lblSmoothie.setForeground(new Color(0, 0, 0));
					lblAid.setOpaque(false);
					lblAid.setForeground(new Color(0, 0, 0));
					lblJucie.setOpaque(false);
					lblJucie.setForeground(new Color(0, 0, 0));
				}
			});
			lblTea.setHorizontalAlignment(SwingConstants.CENTER);
			lblTea.setBounds(266, 60, 65, 16);
		}
		return lblTea;
	}

	private JLabel getLblJucie() {
		if (lblJucie == null) {
			lblJucie = new JLabel("주스");
			lblJucie.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					tableInit();
					searchActionJucie();

					lblJucie.setBackground(new Color(0, 0, 0));
					lblJucie.setOpaque(true);
					lblJucie.setForeground(new Color(255, 255, 255));

					lblCoffeeIce.setOpaque(false);
					lblCoffeeIce.setForeground(new Color(0, 0, 0));
					lblCoffeeHot.setOpaque(false);
					lblCoffeeHot.setForeground(new Color(0, 0, 0));
					lblSmoothie.setOpaque(false);
					lblSmoothie.setForeground(new Color(0, 0, 0));
					lblAid.setOpaque(false);
					lblAid.setForeground(new Color(0, 0, 0));
					lblTea.setOpaque(false);
					lblTea.setForeground(new Color(0, 0, 0));
				}
			});
			lblJucie.setHorizontalAlignment(SwingConstants.CENTER);
			lblJucie.setBounds(329, 60, 65, 16);
		}
		return lblJucie;
	}

	private JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(6, 88, 388, 304);
			scrollPane_1.setViewportView(getInnerTableProductList());
		}
		return scrollPane_1;
	}

	private JTable getInnerTableProductList() {
		if (innerTableProductList == null) {
			innerTableProductList = new JTable() {
				public Class getColumnClass(int column) {
					return (column == 0) ? Icon.class : Object.class;
				}
			};
			innerTableProductList.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if (e.getButton() == 1) {
						tableClick();
					}
				}
			});
			innerTableProductList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			innerTableProductList.setBackground(new Color(255, 212, 120));
			innerTableProductList.setRowHeight(120);
			innerTableProductList.setModel(Outer_Table);
		}
		return innerTableProductList;
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("결재 금액");
			lblNewLabel.setBounds(322, 433, 53, 16);
		}
		return lblNewLabel;
	}

	private JLabel getLblCountPrice() {
		if (lblCountPrice == null) {
			lblCountPrice = new JLabel("0");
			lblCountPrice.setHorizontalAlignment(SwingConstants.CENTER);
			lblCountPrice.setBounds(314, 457, 61, 16);
		}
		return lblCountPrice;
	}

	private JComboBox getCbCount() {
		if (cbCount == null) {
			cbCount = new JComboBox();
			cbCount.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
			cbCount.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lblCountPrice.setText(Integer.toString(sum));
				}
			});
			cbCount.setVisible(true);
		}
		return cbCount;

	}

	private void tableInit() {

		Outer_Table.addColumn("상품이미지");
		Outer_Table.addColumn("상품명");
		Outer_Table.addColumn("가격");

		Outer_Table.setColumnCount(3);

		int i = Outer_Table.getRowCount();
		for (int j = 0; j < i; j++) {
			Outer_Table.removeRow(0);
		}

		innerTableProductList.setAutoResizeMode(innerTableProductList.AUTO_RESIZE_OFF);

		int vColIndex = 0;
		TableColumn col = innerTableProductList.getColumnModel().getColumn(vColIndex);
		int width = 180;
		col.setPreferredWidth(width);

		vColIndex = 1;
		col = innerTableProductList.getColumnModel().getColumn(vColIndex);
		width = 130;
		col.setPreferredWidth(width);

		vColIndex = 2;
		col = innerTableProductList.getColumnModel().getColumn(vColIndex);
		width = 80;
		col.setPreferredWidth(width);

	}

	private void tableInit2() {

		Outer_Table2.addColumn("상품명");
		Outer_Table2.addColumn("가격");
		Outer_Table2.addColumn("수량");
		Outer_Table2.addColumn("삭제");

		Outer_Table2.setColumnCount(4);

		int i = Outer_Table2.getRowCount();
		for (int j = 0; j < i; j++) {
			Outer_Table2.removeRow(0);
		}

		innerTableOrderList.setAutoResizeMode(innerTableOrderList.AUTO_RESIZE_OFF);

		int vColIndex = 0;
		TableColumn col = innerTableOrderList.getColumnModel().getColumn(vColIndex);
		int width = 70;
		col.setPreferredWidth(width);

		vColIndex = 1;
		col = innerTableOrderList.getColumnModel().getColumn(vColIndex);
		width = 60;
		col.setPreferredWidth(width);

		vColIndex = 2;
		col = innerTableOrderList.getColumnModel().getColumn(vColIndex);
		width = 100;
		col.setPreferredWidth(width);

		vColIndex = 3;
		col = innerTableOrderList.getColumnModel().getColumn(vColIndex);
		width = 40;
		col.setPreferredWidth(width);

	}

//	private void searchAction() {
//		kioskOrderDao dao = new kioskOrderDao();
//		ArrayList<kioskOrderDto> dtoList = dao.selectList();
//
//		int listCount = dtoList.size();
//
//		for (int index = 0; index < listCount; index++) {
//			ImageIcon icon = new ImageIcon(kioskOrder.class.getResource("/com/javalec/images/americanoHot.png"));
//			Object[] qTxt = { icon, dtoList.get(index).getProductid(),
//					Integer.toString(dtoList.get(index).getProductprice()) };
//			Outer_Table.addRow(qTxt);
//		}
//	}

	private void searchActionCoffeeIce() {
		kioskOrderDao dao = new kioskOrderDao();
		ArrayList<kioskOrderDto> dtoList = dao.selectListCoffeeIce();

		int listCount = dtoList.size();

		for (int index = 0; index < listCount; index++) {
			ImageIcon icon = new ImageIcon(kioskOrder.class.getResource("/com/javalec/images/IceAmericano.png"));
			Object[] qTxt = { icon, dtoList.get(index).getProductid(),
					Integer.toString(dtoList.get(index).getProductprice()) };
			Outer_Table.addRow(qTxt);
		}
	}

	private void searchActionCoffeeHot() {
		kioskOrderDao dao = new kioskOrderDao();
		ArrayList<kioskOrderDto> dtoList = dao.selectListCoffeeHot();

		int listCount = dtoList.size();

		for (int index = 0; index < listCount; index++) {
			ImageIcon icon = new ImageIcon(kioskOrder.class.getResource("/com/javalec/images/HotAmericano.png"));
			Object[] qTxt = { icon, dtoList.get(index).getProductid(),
					Integer.toString(dtoList.get(index).getProductprice()) };
			Outer_Table.addRow(qTxt);
		}
	}

	private void searchActionSmoothie() {
		kioskOrderDao dao = new kioskOrderDao();
		ArrayList<kioskOrderDto> dtoList = dao.selectListSmoothie();

		int listCount = dtoList.size();

		for (int index = 0; index < listCount; index++) {
			ImageIcon icon = new ImageIcon(kioskOrder.class.getResource("/com/javalec/images/MangoSmoothie.png"));
			Object[] qTxt = { icon, dtoList.get(index).getProductid(),
					Integer.toString(dtoList.get(index).getProductprice()) };
			Outer_Table.addRow(qTxt);
		}
	}

	private void searchActionAid() {
		kioskOrderDao dao = new kioskOrderDao();
		ArrayList<kioskOrderDto> dtoList = dao.selectListAid();

		int listCount = dtoList.size();

		for (int index = 0; index < listCount; index++) {
			ImageIcon icon = new ImageIcon(kioskOrder.class.getResource("/com/javalec/images/MangoAid.png"));
			Object[] qTxt = { icon, dtoList.get(index).getProductid(),
					Integer.toString(dtoList.get(index).getProductprice()) };
			Outer_Table.addRow(qTxt);
		}
	}

	private void searchActionTea() {
		kioskOrderDao dao = new kioskOrderDao();
		ArrayList<kioskOrderDto> dtoList = dao.selectListTea();

		int listCount = dtoList.size();

		for (int index = 0; index < listCount; index++) {
			ImageIcon icon = new ImageIcon(kioskOrder.class.getResource("/com/javalec/images/GreenTea.png"));
			Object[] qTxt = { icon, dtoList.get(index).getProductid(),
					Integer.toString(dtoList.get(index).getProductprice()) };
			Outer_Table.addRow(qTxt);
		}
	}

	private void searchActionJucie() {
		kioskOrderDao dao = new kioskOrderDao();
		ArrayList<kioskOrderDto> dtoList = dao.selectListJucie();

		int listCount = dtoList.size();

		for (int index = 0; index < listCount; index++) {
			ImageIcon icon = new ImageIcon(kioskOrder.class.getResource("/com/javalec/images/MangoJuice.png"));
			Object[] qTxt = { icon, dtoList.get(index).getProductid(),
					Integer.toString(dtoList.get(index).getProductprice()) };
			Outer_Table.addRow(qTxt);
		}
	}

	private void tableClick() {
		int i = innerTableProductList.getSelectedRow();
		String productid = (String) innerTableProductList.getValueAt(i, 1);
		kioskOrderDao dao = new kioskOrderDao(productid);
		kioskOrderDto dto = dao.tableClick();

		Action delete = new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				JTable table = (JTable) e.getSource();
				int modelRow = Integer.valueOf(e.getActionCommand());
				((DefaultTableModel) table.getModel()).removeRow(modelRow);
			}
		};

		Object[] qTxt = { dto.getProductid(), dto.getProductprice() , 1, "삭제" };
		qTxt2 = new String[] { dto.getProductid() };
		Outer_Table2.addRow(qTxt);

//		TableColumn column = innerTableOrderList.getColumnModel().getColumn(2);
//		column.setCellEditor(new DefaultCellEditor(cbCount));
		
		sum = Integer.parseInt(String.valueOf(qTxt[1]))
				* Integer.parseInt(String.valueOf(cbCount.getItemAt(cbCount.getSelectedIndex()).toString()));
		
//		TableColumn column2 = innerTableOrderList.getColumnModel().getColumn(1);
//		column.setCellEditor(new DefaultCellEditor(sum);

		ButtonColumn buttonColumn = new ButtonColumn(innerTableOrderList, delete, 3);
		buttonColumn.setMnemonic(KeyEvent.VK_D);
		

		sum = Integer.parseInt(String.valueOf(qTxt[1]))
				* Integer.parseInt(String.valueOf(cbCount.getItemAt(cbCount.getSelectedIndex()).toString()));
		lblCountPrice.setText(Integer.toString(sum + Integer.parseInt(lblCountPrice.getText())));
		

	}
}