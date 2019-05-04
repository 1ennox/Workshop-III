package brewDay;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.FlowLayout;

public class AddRecipePage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddRecipePage frame = new AddRecipePage();
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
	public AddRecipePage() {
		setTitle("Add Recipe");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("<html>Please complete the table with your new recipe information then press \"Finish\" button to submit it.</html>");
		label.setBackground(Color.GREEN);
		label.setBounds(19, 6, 379, 49);
		contentPane.add(label);
		
		JButton button = new JButton("Back");
		button.setForeground(Color.BLUE);
		button.setBounds(19, 56, 75, 36);
		contentPane.add(button);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(151, 87, 195, 26);
		contentPane.add(textField);
		
		JLabel label_1 = new JLabel("Recipe name:");
		label_1.setBounds(67, 92, 83, 16);
		contentPane.add(label_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(67, 117, 159, 27);
		contentPane.add(comboBox);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(227, 116, 52, 26);
		contentPane.add(spinner);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(280, 117, 66, 27);
		contentPane.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(280, 143, 66, 27);
		contentPane.add(comboBox_2);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(227, 142, 52, 26);
		contentPane.add(spinner_1);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(67, 143, 159, 27);
		contentPane.add(comboBox_3);
	}
}
