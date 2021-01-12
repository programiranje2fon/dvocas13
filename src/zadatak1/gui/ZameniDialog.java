package zadatak1.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ZameniDialog extends JDialog {

	private static final long serialVersionUID = 1L;

	private final JPanel contentPanel = new JPanel();
	private JTextField replaceField;
	private JTextField replaceWithField;
	
	private TekstEditorGUI glavniProzor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ZameniDialog dialog = new ZameniDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ZameniDialog(TekstEditorGUI glavniProzor) {
		this();
		this.glavniProzor = glavniProzor;
	}
	
	/**
	 * Create the dialog.
	 */
	public ZameniDialog() {
		setTitle("Zamena teksta");
		setBounds(100, 100, 353, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("String koji se menja:");
		lblNewLabel.setBounds(28, 37, 151, 14);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("String kojim se menja:");
		lblNewLabel_1.setBounds(28, 90, 151, 14);
		contentPanel.add(lblNewLabel_1);
		
		replaceField = new JTextField();
		replaceField.setBounds(189, 34, 127, 20);
		contentPanel.add(replaceField);
		replaceField.setColumns(10);
		
		replaceWithField = new JTextField();
		replaceWithField.setBounds(189, 87, 127, 20);
		contentPanel.add(replaceWithField);
		replaceWithField.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						String staSeMenja= replaceField.getText().trim();
						String zamena = replaceWithField.getText().trim();
						glavniProzor.zameniString(staSeMenja, zamena);
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
		