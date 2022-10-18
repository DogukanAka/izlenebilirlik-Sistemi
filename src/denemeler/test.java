package denemeler;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import java.util.Date;
import java.text.SimpleDateFormat;

public class test extends JFrame {

	private JPanel contentPane;
	private JTable table;
	public JComboBox comboBox_1, comboBox_2, comboBox_3;
	DefaultTableModel modelim = new DefaultTableModel();
	
	
	/*tasarımdaki isimleri tanımladık*/
	
	Object[] kolonlar = {"kayit_no","urun barkodu","urun adedi","tarih", "girdi/cikti","kalite kontrol","departman"};
	Object[] satirlar = new Object[7];
	private JTextField txt_barkod;
	private JTextField txt_adet;
	private JTextField txt_tarih;
	private JTextField txt_sorgu;
	private JTextField txt_kayit;
	protected AbstractButton jTextFieldl;

	
	
	
	
	/*sistemin donmesini saglayan kod*/
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test frame = new test();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	public test() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 856, 459);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		/*listeleme ekranindaki panonun ve tablonun ebatini saglayan kod*/
		JScrollPane scrollPane = new JScrollPane();
		
		scrollPane.setBounds(0, 11, 552, 365);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, "", null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"kayit_no", "urun_barkodu", "miktar", "tarih", "girdi_cikti", "kalite_kontrol", "departman"
			}
		));
		table.getColumnModel().getColumn(1).setPreferredWidth(89);
		table.getColumnModel().getColumn(4).setPreferredWidth(71);
		table.getColumnModel().getColumn(5).setPreferredWidth(88);
		table.getColumnModel().getColumn(6).setPreferredWidth(88);
		modelim.setColumnIdentifiers(kolonlar);
		
		table.setBounds(143, 219, 260, 143);
		scrollPane.setViewportView(table);
		
		/*listeleme butonunun islem gormesini saglayan kod*/
		
		JButton btnNewButton = new JButton("LİSTELE");
		btnNewButton.setFont(new Font("Calibri", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				modelim.setRowCount(0);
				ResultSet myRs = (ResultSet) main.yap();
				/*tablodaki sutun basliklarini isimlendirdigimiz kod*/
				
				try {
					while(myRs.next()) {
						
						satirlar[0] = myRs.getString("kayit_no");
						satirlar[1] = myRs.getString("urun_barkodu");
						satirlar[2] = myRs.getString("urun_adedi");
						satirlar[3] = myRs.getString("tarih");
						satirlar[4] = myRs.getString("girdi_cikti");
 						satirlar[5] = myRs.getString("kalite_kontrol");
 						satirlar[6] = myRs.getString("departman");
						modelim.addRow(satirlar);	
					}
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
				
			
				table.setModel(modelim);
				
			}
		});
		
		/*veri girisi yaptigimiz yerin ebatlarini saglayan kod*/
		
		btnNewButton.setBounds(700, 303, 115, 31);
		contentPane.add(btnNewButton);
		
		txt_barkod = new JTextField();
		txt_barkod.setBounds(700, 57, 115, 31);
		contentPane.add(txt_barkod);
		txt_barkod.setColumns(10);
		
		txt_adet = new JTextField();
		txt_adet.setBounds(700, 100, 115, 31);
		contentPane.add(txt_adet);
		txt_adet.setColumns(10);
		
		
		txt_tarih = new JTextField();
		txt_tarih.setBounds(700, 142, 115, 31);
		contentPane.add(txt_tarih);
		txt_tarih.setColumns(10);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Calibri", Font.BOLD, 13));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"girdi", "çıktı","bitti"})); 
		comboBox_1.setBounds(700, 185, 115, 22);
		contentPane.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setFont(new Font("Calibri", Font.BOLD, 13));
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"onay", "red "})); 
		comboBox_2.setBounds(700, 218, 115, 22);
		contentPane.add(comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setFont(new Font("Calibri", Font.BOLD, 13));
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"boyahane", "plastik enj", "cnc", "metal enj", "preshane"})); 
		comboBox_3.setBounds(700, 251, 115, 22);
		contentPane.add(comboBox_3);
		
		/*kaydet butonunun calismasini saglayan kod*/
		JButton btnNewButton_1 = new JButton("KAYDET");
		btnNewButton_1.setFont(new Font("Calibri", Font.BOLD, 14));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				/*sql veri tabanina yeni veri girisi yapmamizi saglayan kod*/
				String barkod,adet,tarih,cikis,kalite,departman,kayit,sql_sorgu;
				
				kayit = txt_kayit.getText();
				barkod = txt_barkod.getText();
				adet = txt_adet.getText();
				tarih = txt_tarih.getText();
				cikis = (String)comboBox_1.getSelectedItem();
				kalite =(String)comboBox_2.getSelectedItem();
				departman = (String)comboBox_3.getSelectedItem();
				
				
			if (barkod.length() ==8 || kayit.length() ==6 || adet.length() ==8 || tarih.length() ==6 ) {
				
				JOptionPane.showMessageDialog(null, "Bütün alanları doldurduğunuzdan emin olunuz.", "Hatalı Giriş", JOptionPane.ERROR_MESSAGE);
			}else {
				
				
				
				
				if (barkod.length() ==8 && kayit.length() ==6 ) {  
					sql_sorgu= "INSERT INTO urunler(kayit_no,urun_barkodu,urun_adedi,tarih,girdi_cikti,kalite_kontrol,departman) VALUES ("+kayit+","+barkod+","+adet+",'"+tarih+"','"+cikis+"','"+kalite+"','"+departman+"')";
					//System.out.println(sql_sorgu);
					
				    main.ekle(sql_sorgu);  
					
					
					
				}else {
					JOptionPane.showMessageDialog(null, "Lütfen 8 haneli barkod numarası veya 6 haneli kayıt numarası girdiğinizden emin olunuz.", "Hatalı Giriş", JOptionPane.ERROR_MESSAGE);
				}
			}
				
			}
		});
		
		
		/*tablodaki  yazilarin fontlarini ve boyutlarini ayarladigimiz kod*/
		btnNewButton_1.setBounds(575, 303, 115, 31);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_8 = new JLabel("Kayıt No :");
		lblNewLabel_8.setFont(new Font("Calibri", Font.BOLD, 14));
		lblNewLabel_8.setBounds(578, 11, 96, 35);
		contentPane.add(lblNewLabel_8);
		
		
		JLabel lblNewLabel = new JLabel("Barkod No  :");
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 14));
		lblNewLabel.setBounds(578, 57, 96, 34);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Miktar :");
		lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD, 14));
		lblNewLabel_1.setBounds(578, 102, 96, 31);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Tarih :");
		lblNewLabel_2.setFont(new Font("Calibri", Font.BOLD, 14));
		lblNewLabel_2.setBounds(578, 142, 96, 31);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("AKA-SOFT");
		lblNewLabel_3.setForeground(Color.DARK_GRAY);
		lblNewLabel_3.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_3.setBounds(905, 444, -52, -14);
		contentPane.add(lblNewLabel_3);
		
		
		JLabel lblNewLabel_4 = new JLabel("Durum :");
		lblNewLabel_4.setFont(new Font("Calibri", Font.BOLD, 14));
		lblNewLabel_4.setBounds(578, 184, 96, 24);
		contentPane.add(lblNewLabel_4);
		
		JButton btnNewButton_2 = new JButton("GÜNCELLE");
		btnNewButton_2.setFont(new Font("Calibri", Font.BOLD, 14));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				
				/*veri tabaninda guncelleme yapmamizi saglayan kod*/
				String barkod,adet,tarih,cikis,kalite,departman,kayit,sql_sorgu;
				
				kayit = txt_kayit.getText();
				barkod = txt_barkod.getText();
				adet = txt_adet.getText();
				tarih = txt_tarih.getText();
				cikis = (String)comboBox_1.getSelectedItem();
				kalite = (String)comboBox_2.getSelectedItem();
				departman = (String)comboBox_3.getSelectedItem();
				
				
				sql_sorgu = "UPDATE urunler SET urun_barkodu="+barkod+","+
				"urun_adedi="+adet+",tarih='"+tarih+"',girdi_cikti='"+cikis+
				"',kalite_kontrol='"+kalite+"',departman='"+departman+"',kayit_no='"+kayit+"' WHERE kayit_no="+kayit;
				
						//System.out.println(sql_sorgu);    
				main.update(sql_sorgu);
				          
				            
				
			}
		});
		
		
		/*veri tabanindan urun silmemizi saglayan kod*/
		btnNewButton_2.setBounds(700, 345, 115, 31);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("SİL");
		btnNewButton_3.setFont(new Font("Calibri", Font.BOLD, 14));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int YesOrNo = JOptionPane.showConfirmDialog(null, "Silmek istediginize emin misiniz ?", "Clear Textfiedl", JOptionPane.YES_NO_OPTION ); 
				if(YesOrNo == 0) { String barkod,sql_sorgu;
				
				barkod = txt_barkod.getText();
				
				sql_sorgu = "DELETE FROM urunler WHERE urun_barkodu="+barkod;
				
				main.sil(sql_sorgu); 
				
				}else { }

				
			}
		});
		
		/*urunleri belli bir basliga gore siniflandirmamizi saglayan kod*/
		btnNewButton_3.setBounds(575, 345, 115, 31);
		contentPane.add(btnNewButton_3);
		
		txt_sorgu = new JTextField();
		txt_sorgu.setBounds(205, 385, 96, 31);
		contentPane.add(txt_sorgu);
		txt_sorgu.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Alan Adı :");
		lblNewLabel_5.setFont(new Font("Calibri", Font.BOLD, 16));
		lblNewLabel_5.setBounds(10, 385, 69, 31);
		contentPane.add(lblNewLabel_5);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Calibri", Font.BOLD, 13));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"kayıt no", "barkod no", "ürün adedi", "tarih", "durum", "kalite kontrol", "departman"}));  
		comboBox.setBounds(80, 386, 115, 30);
		contentPane.add(comboBox);
		
		
		JButton btnNewButton_4 = new JButton("SORGULA");
		btnNewButton_4.setFont(new Font("Calibri", Font.BOLD, 14));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modelim.setRowCount(0);
				
				/*siniflandirma yapmak icin sql veri tabanindan verilerli almamizi saglayan kod*/
				
				String sql_sorgu=null;
				
				String alan = txt_sorgu.getText();
				
				ResultSet myRs= null; 
				
				int secilen = comboBox.getSelectedIndex();
				
				if (secilen == 0) {
					 sql_sorgu = "select * from urunler where kayit_no like '"+ alan +"%' order by tarih asc";
					
				} else if (secilen == 1)
					
				{
					 sql_sorgu = "select * from urunler where urun_barkodu like '"+ alan +"%' order by tarih asc";
				}else if (secilen == 2)
					
				{
					 sql_sorgu = "select * from urunler where urun_adedi like '"+ alan +"%' order by tarih asc";
				}else if (secilen == 3)
					
				{
					 sql_sorgu = "select * from urunler where tarih like '"+ alan +"%' order by tarih asc";
					 
                }else if (secilen == 4)
					
				{
					 sql_sorgu = "select * from urunler where girdi_cikti like '"+ alan +"%' order by tarih asc ";
				}else if (secilen == 5)
					
				{
					 sql_sorgu = "select * from urunler where kalite_kontrol like '"+ alan +"%' order by tarih asc";
				}else if (secilen == 6)
					
				{
					 sql_sorgu = "select * from urunler where departman like '"+ alan +"%' order by tarih asc";
				}
				
				
				
				
			    myRs = main.sorgula(sql_sorgu);
				try {
					while(myRs.next()) {
						satirlar[0] = myRs.getString("kayit_no");
						satirlar[1] = myRs.getString("urun_barkodu");
						satirlar[2] = myRs.getString("urun_adedi");
						satirlar[3] = myRs.getString("tarih");
						satirlar[4] = myRs.getString("girdi_cikti");
						satirlar[5] = myRs.getString("kalite_kontrol");
						satirlar[6] = myRs.getString("departman");
						
						modelim.addRow(satirlar);
						
					
						
					}
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
				
			
				table.setModel(modelim);
				
				
				
			}
		});	
		btnNewButton_4.setBounds(313, 385, 96, 31);
		contentPane.add(btnNewButton_4);
		
		/*kalite kontrol bilgisni girdigimiz yerin kodu*/
		
		JLabel lblNewLabel_6 = new JLabel("Kalite Kontrol :");
		lblNewLabel_6.setFont(new Font("Calibri", Font.BOLD, 14));
		lblNewLabel_6.setBounds(578, 217, 115, 24);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Departman :");
		lblNewLabel_7.setFont(new Font("Calibri", Font.BOLD, 14));
		lblNewLabel_7.setBounds(578, 252, 96, 24);
		contentPane.add(lblNewLabel_7);
		
		txt_kayit = new JTextField();
		txt_kayit.setBounds(700, 10, 115, 30);
		contentPane.add(txt_kayit);
		txt_kayit.setColumns(10);
		
		
		
	
		
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txt_barkod.setText((String) modelim.getValueAt(table.getSelectedRow(), 1));
				txt_adet.setText((String) modelim.getValueAt(table.getSelectedRow(), 2));
				txt_tarih.setText((String) modelim.getValueAt(table.getSelectedRow(), 3));
				comboBox_1.setSelectedItem((String) modelim.getValueAt(table.getSelectedRow(), 4));
				comboBox_2.setSelectedItem((String) modelim.getValueAt(table.getSelectedRow(), 5));
				comboBox_3.setSelectedItem((String) modelim.getValueAt(table.getSelectedRow(), 6));
				txt_kayit.setText((String) modelim.getValueAt(table.getSelectedRow(), 0));
			}
		});
		
	
		
		
		//contentPane.add(table);
	}
}
