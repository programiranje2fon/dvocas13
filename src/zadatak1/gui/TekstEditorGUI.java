package zadatak1.gui;

import zadatak1.poslovna_logika.TekstDemo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class TekstEditorGUI extends JFrame {
    private JPanel mojPanel;
    private JTextField textFieldIme;
    private JButton ucitajButton;
    private JButton obrisiButton;
    private JButton sacuvajButton;
    private JPanel panel2;
    private JButton izadjiButton;
    private JTextArea textArea1;
    private JTextField replaceField;
    private JTextField replaceWithField;
    private JButton zameniButton;
    private JButton analizaButton;

    //Ovako se povezuje TekstEditorGUI sa klasom TekstDemo
    private TekstDemo tekstDemo = new TekstDemo();

    public TekstEditorGUI(){
        setContentPane(mojPanel);
        setTitle("Tekst Editor");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Istovremeno podesavanje lokacije prozora (x,y) i
        //dimenzija prozora
        setBounds(100, 100, 720, 290);
        ucitajButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ime = textFieldIme.getText();
                try {
                    String tekst = tekstDemo.ucitajTekst(ime);
                    textArea1.setText(tekst);
                } catch (IOException e1) {
                    JOptionPane.showMessageDialog(null, "Greska prilikom ucitavanja teksta.", "Greska", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        obrisiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea1.setText("");
            }
        });
        sacuvajButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tekst = textArea1.getText();
                String ime = textFieldIme.getText();
                try {
                    tekstDemo.upisiTekst(ime, tekst);
                } catch (IOException e1) {
                    JOptionPane.showMessageDialog(null, "Greska prilikom upisivanja teksta.", "Greska", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        izadjiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int response = JOptionPane.showConfirmDialog(null, "Da li zelite da izadjete iz programa?",
                        "Potvrda", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (response == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
        zameniButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String staSeMenja= replaceField.getText().trim();
                String zamena = replaceWithField.getText().trim();

                String tekst = textArea1.getText();
                String noviTekst = tekst.replaceAll(staSeMenja, zamena);
                textArea1.setText(noviTekst);
            }
        });
        analizaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tekst = textArea1.getText();
                int brojSlova = tekst.length();
                int brojReci = tekst.replace('\n', ' ').split(" ").length;

                JOptionPane.showMessageDialog(null,
                        "Broj znakova u tekstu: " + brojSlova + ". Broj reci: " + brojReci, "Analiza teksta",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }

    public static void main(String[] args) {
        new TekstEditorGUI().setVisible(true);
    }
}
