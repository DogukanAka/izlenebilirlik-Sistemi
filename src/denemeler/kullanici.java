package denemeler;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.CardLayout;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;

public class kullanici extends JFrame {

	/* kullanici paneli icin giris yapmamizi saglayan kodlarin tanimlandigi kisim*/
	
	private JPanel contentPane;
	private JTextField txt_ad;
	static String ad;
	static String sifre;
	private JPasswordField txt_sifre;

	/*sistemin donmesini saglayan kod*/
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					kullanici frame = new kullanici();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/*giris panelindeki kullanici ve sifre kisimlarini olustrudugumuz kod kismi*/
	public kullanici() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 604, 349);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txt_ad = new JTextField();
		txt_ad.setBounds(181, 127, 151, 29);
		contentPane.add(txt_ad);
		txt_ad.setColumns(10);
		
		/*giris butonunu olusturdugumuz kod kismi*/
		JButton btnNewButton = new JButton("G\u0130R\u0130\u015E");
		btnNewButton.setFont(new Font("Calibri", Font.BOLD, 16));
		btnNewButton.setForeground(Color.DARK_GRAY);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ad = txt_ad.getText();
				sifre = txt_sifre.getText();
				
				
				
				/*kullanici adi ve sifresini sql den cekmemizi saglayan kod*/
				String sql_sorgu = "select count(idkull) as giris from fifo.giris where kull_ad='"+ad+
						"' and sifre = '"+sifre+"'";
				
				ResultSet myRs = main.yap();
				myRs = main.sorgula(sql_sorgu);
				
				try {
					while(myRs.next()){
						if (myRs.getInt("giris")==1) {
							test tst = new test();
							tst.setVisible(true);
							setVisible(false);
						} else {btnNewButton.setText("hatali giris");}
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		
		/*sistemdeki yazilarin fontunu ve buyuklugunu ayarladigimiz kod*/
		btnNewButton.setBounds(102, 255, 151, 29);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Kullan\u0131c\u0131 Ad\u0131 :");
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 20));
		lblNewLabel.setBounds(31, 121, 126, 44);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u015Eifre :");
		lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD, 20));
		lblNewLabel_1.setBounds(31, 186, 128, 44);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u0130ZLENEB\u0130L\u0130RL\u0130K S\u0130STEM\u0130 ");
		lblNewLabel_2.setForeground(Color.DARK_GRAY);
		lblNewLabel_2.setFont(new Font("Calibri", Font.BOLD, 23));
		lblNewLabel_2.setBounds(31, 24, 247, 98);
		contentPane.add(lblNewLabel_2);
		
		txt_sifre = new JPasswordField();
		txt_sifre.setBounds(181, 193, 151, 29);
		contentPane.add(txt_sifre);
		
		
		/*sifreyi gorunebilir hale getirdigimiz kod*/
		JCheckBox chckbxNewCheckBox = new JCheckBox("\u015Eifreyi G\u00F6ster");
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbxNewCheckBox.isSelected()) {
					txt_sifre.setEchoChar((char)0);
				} else {
					txt_sifre.setEchoChar('*');
				}
			}
		});
		
		/*sifreyi goster kismindaki yazinin fontu ve buyuklugu*/
		chckbxNewCheckBox.setForeground(Color.BLACK);
		chckbxNewCheckBox.setFont(new Font("Calibri", Font.BOLD, 20));
		chckbxNewCheckBox.setBounds(364, 186, 208, 44);
		contentPane.add(chckbxNewCheckBox);
		
		JLabel lblNewLabel_3 = new JLabel("");
		Image img = new ImageIcon(kullanici.class.getResource("/logo4.png")).getImage();
		lblNewLabel_3.setIcon(new ImageIcon(img));
		lblNewLabel_3.setBounds(346, 0, 226, 191);
		contentPane.add(lblNewLabel_3);
		
		
		
	}
}
