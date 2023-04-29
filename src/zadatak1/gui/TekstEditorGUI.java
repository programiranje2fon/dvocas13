package zadatak1.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import zadatak1.poslovna_logika.TekstDemo;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class TekstEditorGUI extends JFrame {

	private static final long serialVersionUID = 1L;

	private TekstDemo tekstDemo = new TekstDemo();

	private JPanel contentPane;
	private JPanel panel1;
	private JTextArea textAreaEditor;
	private JLabel lblImeFajla;
	private JTextField textFieldUnosImena;
	private JButton btnUcitaj;
	private JButton btnObrisi;
	private JButton btnSacuvaj;
	private JButton btnZameni;
	private JButton btnAnalizaTeksta;
	private JButton btnIzadji;
	private JPanel panel2;
	private JTextField replaceField;
	private JTextField replaceWithField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TekstEditorGUI frame = new TekstEditorGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TekstEditorGUI() {
		setTitle("Tekst Editor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 718, 285);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getPanel1(), BorderLayout.WEST);
		contentPane.add(getTextAreaEditor(), BorderLayout.CENTER);
		contentPane.add(getPanel2(), BorderLayout.EAST);
	}

	private JPanel getPanel1() {
		if (panel1 == null) {
			panel1 = new JPanel();
			panel1.setPreferredSize(new Dimension(120, 10));
			panel1.add(getLblImeFajla());
			panel1.add(getTextFieldUnosImena());
			panel1.add(getBtnUcitaj());
			panel1.add(getBtnObrisi());
			panel1.add(getBtnSacuvaj());
			panel1.add(getBtnAnalizaTeksta());
			panel1.add(getBtnIzadji());
		}
		return panel1;
	}

	private JTextArea getTextAreaEditor() {
		if (textAreaEditor == null) {
			textAreaEditor = new JTextArea();
		}
		return textAreaEditor;
	}

	private JLabel getLblImeFajla() {
		if (lblImeFajla == null) {
			lblImeFajla = new JLabel("Ime fajla:");
		}
		return lblImeFajla;
	}

	private JTextField getTextFieldUnosImena() {
		if (textFieldUnosImena == null) {
			textFieldUnosImena = new JTextField();
			textFieldUnosImena.setPreferredSize(new Dimension(100, 20));
			textFieldUnosImena.setColumns(10);
		}
		return textFieldUnosImena;
	}

	private JButton getBtnUcitaj() {
		if (btnUcitaj == null) {
			btnUcitaj = new JButton("Ucitaj");
			btnUcitaj.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String ime = textFieldUnosImena.getText();
					try {
						String tekst = tekstDemo.ucitajTekst(ime);
						textAreaEditor.setText(tekst);
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(null, "Greska prilikom ucitavanja teksta.", "Greska", JOptionPane.ERROR_MESSAGE);
					}
				}
			});
			btnUcitaj.setPreferredSize(new Dimension(100, 23));
		}
		return btnUcitaj;
	}

	private JButton getBtnObrisi() {
		if (btnObrisi == null) {
			btnObrisi = new JButton("Obrisi");
			btnObrisi.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					textAreaEditor.setText("");
				}
			});
			btnObrisi.setPreferredSize(new Dimension(100, 23));
		}
		return btnObrisi;
	}

	private JButton getBtnSacuvaj() {
		if (btnSacuvaj == null) {
			btnSacuvaj = new JButton("Sacuvaj");
			btnSacuvaj.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String tekst = textAreaEditor.getText();
					String ime = textFieldUnosImena.getText();
					try {
						tekstDemo.upisiTekst(ime, tekst);
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(null, "Greska prilikom upisivanja teksta.", "Greska", JOptionPane.ERROR_MESSAGE);
					}
				}
			});
			btnSacuvaj.setPreferredSize(new Dimension(100, 23));
		}
		return btnSacuvaj;
	}

	private JButton getBtnZameni() {
		if (btnZameni == null) {
			btnZameni = new JButton("Zameni");
			btnZameni.setBounds(82, 155, 100, 23);
			btnZameni.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String staSeMenja= replaceField.getText().trim();
					String zamena = replaceWithField.getText().trim();

					String tekst = textAreaEditor.getText();
					String noviTekst = tekst.replaceAll(staSeMenja, zamena);
					textAreaEditor.setText(noviTekst);
				}
			});
			btnZameni.setPreferredSize(new Dimension(100, 23));
		}
		return btnZameni;
	}

	private JButton getBtnAnalizaTeksta() {
		if (btnAnalizaTeksta == null) {
			btnAnalizaTeksta = new JButton("Analiza");
			btnAnalizaTeksta.setActionCommand("Analiza");
			btnAnalizaTeksta.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String tekst = textAreaEditor.getText();
					int brojSlova = tekst.length();
					int brojReci = tekst.split(" ").length;

					JOptionPane.showMessageDialog(null,
							"Broj znakova u tekstu: " + brojSlova + ". Broj reci: " + brojReci, "Analiza teksta",
							JOptionPane.INFORMATION_MESSAGE);
				}
			});
			btnAnalizaTeksta.setPreferredSize(new Dimension(100, 23));
		}
		return btnAnalizaTeksta;
	}

	private JButton getBtnIzadji() {
		if (btnIzadji == null) {
			btnIzadji = new JButton("Izadji");
			btnIzadji.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int response = JOptionPane.showConfirmDialog(null, "Da li zelite da izadjete iz programa?",
							"Potvrda", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if (response == JOptionPane.YES_OPTION) {
						System.exit(0);
					}
				}
			});
			btnIzadji.setPreferredSize(new Dimension(100, 23));
		}
		return btnIzadji;
	}

	private JPanel getPanel2() {
		if (panel2 == null) {
			panel2 = new JPanel();
			panel2.setPreferredSize(new Dimension(240, 10));
			panel2.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("String koji se menja:");
			lblNewLabel.setBounds(10, 66, 135, 14);
			panel2.add(lblNewLabel);
			
			replaceField = new JTextField();
			replaceField.setColumns(10);
			replaceField.setBounds(140, 63, 85, 20);
			panel2.add(replaceField);
			
			JLabel lblNewLabel_1 = new JLabel("String kojim se menja:");
			lblNewLabel_1.setBounds(10, 116, 135, 14);
			panel2.add(lblNewLabel_1);
			
			replaceWithField = new JTextField();
			replaceWithField.setColumns(10);
			replaceWithField.setBounds(140, 113, 85, 20);
			panel2.add(replaceWithField);
			panel2.add(getBtnZameni());
		}
		return panel2;
	}
}
