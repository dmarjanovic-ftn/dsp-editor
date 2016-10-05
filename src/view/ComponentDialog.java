package view;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class ComponentDialog extends JDialog {
	public JTextField textField;
	public JTextArea textArea;
	public JPanel centralPanel;
	public JButton btnCancel;
	public JButton btnOk;
	
	public ComponentDialog(JFrame frame, String name) {
		super(frame, name, Dialog.ModalityType.DOCUMENT_MODAL);
		
		this.setLocationRelativeTo(frame);
		initialize();
		
		setMinimumSize(new Dimension(370, 190));
	}

	private void closeDialog(){
		this.dispose();
	}
	
	private void initialize(){
		getContentPane().setLayout(new BorderLayout(0, 0));

		centralPanel = new JPanel();
		GridBagLayout gbl_centralPanel = new GridBagLayout();
		gbl_centralPanel.rowWeights = new double[] { 0.0, 1.0 };
		gbl_centralPanel.columnWeights = new double[] { 0.0, 1.0 };
		centralPanel.setLayout(gbl_centralPanel);
		getContentPane().add(centralPanel, BorderLayout.CENTER);

		JLabel lblName = new JLabel("Name :");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.insets = new Insets(5, 7, 5, 10);
		gbc_lblName.anchor = GridBagConstraints.WEST;
		gbc_lblName.gridx = 0;
		gbc_lblName.gridy = 0;
		centralPanel.add(lblName, gbc_lblName);

		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(5, 0, 5, 7);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		gbc_textField.gridwidth = 2;
		gbc_textField.gridheight = 1;
		centralPanel.add(textField, gbc_textField);
		textField.setColumns(10);

		JLabel lblDescription = new JLabel("Description :");
		GridBagConstraints gbc_lblDescription = new GridBagConstraints();
		gbc_lblDescription.anchor = GridBagConstraints.WEST;
		gbc_lblDescription.insets = new Insets(0, 7, 0, 10);
		gbc_lblDescription.gridx = 0;
		gbc_lblDescription.gridy = 1;
		centralPanel.add(lblDescription, gbc_lblDescription);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 0, 7);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 1;
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.gridheight = 1;

		centralPanel.add(scrollPane, gbc_scrollPane);

		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBackground(SystemColor.inactiveCaptionBorder);
		textArea.setAutoscrolls(true);
		scrollPane.setViewportView(textArea);

		JPanel southPanel = new JPanel();
		GridBagLayout gbl_southPanel = new GridBagLayout();
		gbl_southPanel.rowWeights = new double[] { 1.0 };
		gbl_southPanel.columnWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0 };
		southPanel.setLayout(gbl_southPanel);
		getContentPane().add(southPanel, BorderLayout.SOUTH);

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 8;
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		southPanel.add(panel, gbc_panel);

		GridBagConstraints gbc_1 = new GridBagConstraints();
		gbc_1.anchor = GridBagConstraints.EAST;
		gbc_1.insets = new Insets(5, 0, 5, 5);
		gbc_1.gridx = 8;
		gbc_1.gridy = 0;
		btnOk = new JButton("Ok");
		southPanel.add(btnOk, gbc_1);
		

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridy = 0;
		gbc.gridx = 9;
		gbc.insets = new Insets(5, 0, 5, 15);
		gbc.anchor = GridBagConstraints.EAST;
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setHorizontalAlignment(SwingConstants.RIGHT);
		southPanel.add(btnCancel, gbc);

		
		btnCancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				closeDialog();
			}
		});
	}
}
