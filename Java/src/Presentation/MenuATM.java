package Presentation;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.TexturePaint;

import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JMenu;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Point;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import Bussiness.CardBIZ;
import Bussiness.CardReaderBIZ;
import DAO.TransferHistoryDAO;
import Entities.Card;
import Entities.TransferHistory;

import java.awt.Button;
import java.awt.GridBagLayout;
import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;

public class MenuATM extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JMenuBar jJMenuBar = null;
	private JMenu mnfile = null;
	private JMenuItem mnLogin = null;
	private JMenuItem mnExit = null;
	private JMenu help = null;
	private JMenuItem mnAbout = null;
	private JButton btnReset = null;
	private JButton btnExit = null;
	private JButton btn2 = null;
	private JButton btn3 = null;
	private JButton btn4 = null;
	private JButton btn1 = null;
	private JButton btnClear = null;
	private JButton btn5 = null;
	private JButton btn6 = null;
	private JButton btn7 = null;
	private JButton btn8 = null;
	private JButton btn9 = null;
	private JButton btn0 = null;
	private JButton btnInsert = null;
	private JButton btnPrint = null;
	private JPanel jPanel1 = null;
	private JButton btnselect1 = null;
	private JButton btnselect2 = null;
	private JButton btnselect3 = null;
	private JButton btnselect4 = null;
	private JButton btnselect5 = null;
	private JButton btnselect6 = null;
	private JLabel jlb1 = null;
	private JComboBox jComboBox = null;
	/**
	 * This is the default constructor
	 */
	public MenuATM() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(760, 580);
		this.setJMenuBar(getJJMenuBar());
		this.setContentPane(getJContentPane());
		this.setTitle("3HATM");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getBtnReset(), null);
			jContentPane.add(getBtnExit(), null);
			jContentPane.add(getBtn2(), null);
			jContentPane.add(getBtn3(), null);
			jContentPane.add(getBtn4(), null);
			jContentPane.add(getBtn1(), null);
			jContentPane.add(getBtnClear(), null);
			jContentPane.add(getBtn5(), null);
			jContentPane.add(getBtn6(), null);
			jContentPane.add(getBtn7(), null);
			jContentPane.add(getBtn8(), null);
			jContentPane.add(getBtn9(), null);
			jContentPane.add(getBtn0(), null);
			jContentPane.add(getBtnInsert(), null);
			jContentPane.add(getBtnPrint(), null);
			jContentPane.add(getJPanel1(), null);
			jContentPane.add(getBtnselect1(), null);
			jContentPane.add(getBtnselect2(), null);
			jContentPane.add(getBtnselect3(), null);
			jContentPane.add(getBtnselect4(), null);
			jContentPane.add(getBtnselect5(), null);
			jContentPane.add(getBtnselect6(), null);
			jContentPane.add(getJComboBox(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jJMenuBar	
	 * 	
	 * @return javax.swing.JMenuBar	
	 */
	private JMenuBar getJJMenuBar() {
		if (jJMenuBar == null) {
			jJMenuBar = new JMenuBar();
			jJMenuBar.add(getMnfile());
			jJMenuBar.add(getHelp());
		}
		return jJMenuBar;
	}

	/**
	 * This method initializes mnfile	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getMnfile() {
		if (mnfile == null) {
			mnfile = new JMenu();
			mnfile.setText("File");
			mnfile.add(getMnLogin());
			mnfile.add(getMnExit());
		}
		return mnfile;
	}

	/**
	 * This method initializes mnLogin	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getMnLogin() {
		if (mnLogin == null) {
			mnLogin = new JMenuItem();
			mnLogin.setText("Login");
		}
		return mnLogin;
	}

	/**
	 * This method initializes mnExit	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getMnExit() {
		if (mnExit == null) {
			mnExit = new JMenuItem();
			mnExit.setText("Exit");
			mnExit.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					MenuATM.this.dispose();
				}
			});
		}
		return mnExit;
	}

	/**
	 * This method initializes help	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getHelp() {
		if (help == null) {
			help = new JMenu();
			help.setText("Help");
			help.add(getMnAbout());
		}
		return help;
	}

	/**
	 * This method initializes mnAbout	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getMnAbout() {
		if (mnAbout == null) {
			mnAbout = new JMenuItem();
			mnAbout.setText("About");
		}
		return mnAbout;
	}

	/**
	 * This method initializes btnReset	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnReset() {
		if (btnReset == null) {
			btnReset = new JButton();
			btnReset.setText("Enter");
			btnReset.setSize(new Dimension(80, 57));
			btnReset.setLocation(new Point(408, 387));
			btnReset.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					
				}
			});
		}
		return btnReset;
	}

	/**
	 * This method initializes btnExit	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnExit() {
		if (btnExit == null) {
			btnExit = new JButton();
			btnExit.setLocation(new Point(407, 326));
			btnExit.setText("Cancel");
			btnExit.setSize(new Dimension(80, 57));
			btnExit.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					MenuATM.this.dispose();
				}
			});
		}
		return btnExit;
	}

	/**
	 * This method initializes btn2	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtn2() {
		if (btn2 == null) {
			btn2 = new JButton();
			btn2.setLocation(new Point(255, 266));
			btn2.setText("2");
			btn2.setSize(new Dimension(70, 43));
			btn2.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
				}
			});
		}
		return btn2;
	}

	/**
	 * This method initializes btn3	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtn3() {
		if (btn3 == null) {
			btn3 = new JButton();
			btn3.setLocation(new Point(328, 266));
			btn3.setText("3");
			btn3.setSize(new Dimension(70, 43));
			btn3.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
				}
			});
		}
		return btn3;
	}

	/**
	 * This method initializes btn4	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtn4() {
		if (btn4 == null) {
			btn4 = new JButton();
			btn4.setLocation(new Point(182, 312));
			btn4.setText("4");
			btn4.setSize(new Dimension(70, 43));
			btn4.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					
				}
			});
		}
		return btn4;
	}

	/**
	 * This method initializes btn1	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtn1() {
		if (btn1 == null) {
			btn1 = new JButton();
			btn1.setLocation(new Point(181, 265));
			btn1.setText("1");
			btn1.setSize(new Dimension(70, 43));
			btn1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					
				}
			});
		}
		return btn1;
	}

	/**
	 * This method initializes btnClear	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnClear() {
		if (btnClear == null) {
			btnClear = new JButton();
			btnClear.setLocation(new Point(405, 267));
			btnClear.setText("Clear");
			btnClear.setSize(new Dimension(80, 57));
			btnClear.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					
				}
			});
		}
		return btnClear;
	}

	/**
	 * This method initializes btn5	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtn5() {
		if (btn5 == null) {
			btn5 = new JButton();
			btn5.setLocation(new Point(255, 312));
			btn5.setText("5");
			btn5.setSize(new Dimension(70, 43));
			btn5.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					
				}
			});
		}
		return btn5;
	}

	/**
	 * This method initializes btn6	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtn6() {
		if (btn6 == null) {
			btn6 = new JButton();
			btn6.setLocation(new Point(328, 313));
			btn6.setText("6");
			btn6.setSize(new Dimension(70, 43));
			btn6.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					
				}
			});
		}
		return btn6;
	}

	/**
	 * This method initializes btn7	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtn7() {
		if (btn7 == null) {
			btn7 = new JButton();
			btn7.setLocation(new Point(183, 358));
			btn7.setText("7");
			btn7.setSize(new Dimension(70, 43));
			btn7.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					
				}
			});
		}
		return btn7;
	}

	/**
	 * This method initializes btn8	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtn8() {
		if (btn8 == null) {
			btn8 = new JButton();
			btn8.setLocation(new Point(256, 359));
			btn8.setText("8");
			btn8.setSize(new Dimension(70, 43));
			btn8.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					
				}
			});
		}
		return btn8;
	}

	/**
	 * This method initializes btn9	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtn9() {
		if (btn9 == null) {
			btn9 = new JButton();
			btn9.setLocation(new Point(329, 361));
			btn9.setText("9");
			btn9.setSize(new Dimension(70, 43));
			btn9.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					
				}
			});
		}
		return btn9;
	}

	/**
	 * This method initializes btn0	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtn0() {
		if (btn0 == null) {
			btn0 = new JButton();
			btn0.setLocation(new Point(256, 406));
			btn0.setText("0");
			btn0.setSize(new Dimension(70, 43));
			btn0.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					
				}
			});
		}
		return btn0;
	}

	/**
	 * This method initializes btnInsert	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnInsert() {
		if (btnInsert == null) {
			btnInsert = new JButton();
			btnInsert.setBounds(new Rectangle(629, 370, 106, 26));
			btnInsert.setText("Insert Card");
			btnInsert.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					try {
					String cardID=(String) jComboBox.getSelectedItem();
					CardReaderBIZ cardReaderBiz = new CardReaderBIZ();
					CardBIZ cardBiz = new CardBIZ();
					List<Card>listCard = new ArrayList<Card>();
					listCard = cardBiz.getListCard();
					if(cardReaderBiz.checkExists(listCard, cardID))
					{		
						if (cardReaderBiz.checkExpires(listCard, cardID))
						{
							if (cardReaderBiz.checkLocked(listCard, cardID))
							{
								MenuATM.this.dispose();
								InputPIN loginCard = new InputPIN(cardID);
								loginCard.setDefaultCloseOperation(EXIT_ON_CLOSE);
								loginCard.setVisible(true);
							} else
								JOptionPane.showMessageDialog(null,"Account has been LOCKED");
						} else 
							JOptionPane.showMessageDialog(null,"This Card is EXPIRED");
					
					} else
					{
						//GOI DEN FORM BAO KO CO ID NHAP SAI
						JOptionPane.showMessageDialog(null,"This Card does not belong to our bank");
					}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
		}
		return btnInsert;
	}

	/**
	 * This method initializes btnPrint	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnPrint() {
		if (btnPrint == null) {
			btnPrint = new JButton();
			btnPrint.setLocation(new Point(634, 30));
			btnPrint.setText("PrintBill");
			btnPrint.setSize(new Dimension(106, 26));
		}
		return btnPrint;
	}

	/**
	 * This method initializes jPanel1	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel1() {
		if (jPanel1 == null) {
			jlb1 = new JLabel();
			jlb1.setBounds(new Rectangle(45, 52, 258, 85));
			jlb1.setFont(new Font("Dialog", Font.BOLD, 24));
			jlb1.setText("Well Come To 3HATM");
			jPanel1 = new JPanel();
			jPanel1.setLayout(null);
			jPanel1.setBounds(new Rectangle(177, 15, 453, 229));
			jPanel1.setBackground(Color.lightGray);
			jPanel1.add(jlb1, null);
		}
		return jPanel1;
	}

	/**
	 * This method initializes btnselect1	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnselect1() {
		if (btnselect1 == null) {
			btnselect1 = new JButton();
			btnselect1.setBounds(new Rectangle(84, 93, 88, 38));
			btnselect1.setText(">>");
		}
		return btnselect1;
	}

	/**
	 * This method initializes btnselect2	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnselect2() {
		if (btnselect2 == null) {
			btnselect2 = new JButton();
			btnselect2.setLocation(new Point(84, 142));
			btnselect2.setText(">>");
			btnselect2.setSize(new Dimension(88, 38));
		}
		return btnselect2;
	}

	/**
	 * This method initializes btnselect3	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnselect3() {
		if (btnselect3 == null) {
			btnselect3 = new JButton();
			btnselect3.setLocation(new Point(84, 191));
			btnselect3.setText(">>");
			btnselect3.setSize(new Dimension(88, 38));
		}
		return btnselect3;
	}

	/**
	 * This method initializes btnselect4	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnselect4() {
		if (btnselect4 == null) {
			btnselect4 = new JButton();
			btnselect4.setLocation(new Point(634, 106));
			btnselect4.setText("<<");
			btnselect4.setSize(new Dimension(88, 38));
		}
		return btnselect4;
	}

	/**
	 * This method initializes btnselect5	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnselect5() {
		if (btnselect5 == null) {
			btnselect5 = new JButton();
			btnselect5.setLocation(new Point(635, 149));
			btnselect5.setText("<<");
			btnselect5.setSize(new Dimension(88, 38));
		}
		return btnselect5;
	}

	/**
	 * This method initializes btnselect6	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnselect6() {
		if (btnselect6 == null) {
			btnselect6 = new JButton();
			btnselect6.setLocation(new Point(636, 195));
			btnselect6.setText("<<");
			btnselect6.setSize(new Dimension(88, 38));
		}
		return btnselect6;
	}
	
	/**
	 * This method initializes jComboBox	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBox() {
		if (jComboBox == null) {
			jComboBox = new JComboBox();
			jComboBox.setBounds(new Rectangle(498, 269, 237, 25));
			List<String> list=new ArrayList<String>();
		    list.add("9704230011069013");
		    list.add("9704230011069014");
		    list.add("9704230011069015");
		    list.add("9704230011069016");
		    list.add("9704230011069017");
		    list.add("9704230011069010");
		    list.add("9704230011069020");
		    list.add("97042300110690");
		    for(int i=0;i<list.size();++i)
		    	jComboBox.addItem(list.get(i));
		}
		return jComboBox;
	}

	public static void main(String[] args) {
	
	      MenuATM menu = new MenuATM();
	      menu.setDefaultCloseOperation(EXIT_ON_CLOSE);
	      menu.setVisible(true);
		

	}

}  //  @jve:decl-index=0:visual-constraint="49,9"
