package MainPackage;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class MorgageEstimator {

	
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MorgageEstimator window = new MorgageEstimator();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MorgageEstimator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTotalGrossIncome = new JLabel("Total Gross Income");
		lblTotalGrossIncome.setBounds(32, 19, 128, 16);
		frame.getContentPane().add(lblTotalGrossIncome);
		
		textField = new JTextField();
		textField.setBounds(194, 13, 134, 28);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblTotalMonthlyDebt = new JLabel("Total Monthly Debt");
		lblTotalMonthlyDebt.setBounds(32, 59, 128, 16);
		frame.getContentPane().add(lblTotalMonthlyDebt);
		
		textField_1 = new JTextField();
		textField_1.setBounds(194, 53, 134, 28);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblMorgageInterestRate = new JLabel("Morgage Interest Rate");
		lblMorgageInterestRate.setBounds(23, 97, 137, 16);
		frame.getContentPane().add(lblMorgageInterestRate);
		
		textField_2 = new JTextField();
		textField_2.setBounds(194, 93, 134, 28);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblTerm = new JLabel("Term");
		lblTerm.setBounds(121, 137, 61, 16);
		frame.getContentPane().add(lblTerm);
		
		final JComboBox<Object> comboBox = new JComboBox();
		comboBox.setBounds(194, 133, 52, 27);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"10", "15", "30"}));
		frame.getContentPane().add(comboBox);
		
		
		JLabel lblDownPaymentoptional = new JLabel("Down Payment (Optional)");
		lblDownPaymentoptional.setBounds(6, 178, 176, 16);
		frame.getContentPane().add(lblDownPaymentoptional);
		
		textField_3 = new JTextField();
		textField_3.setText("0");
		textField_3.setBounds(194, 172, 134, 28);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		
		
		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				double GrossIncome = Double.parseDouble(textField.getText());
				double monthlyDebt = Double.parseDouble(textField_1.getText());
				double years = Double.parseDouble((String) comboBox.getSelectedItem());
				double rate = Double.parseDouble(textField_2.getText());
				double housePayment = Engine.HousePayment(GrossIncome);
				double debtPayment = Engine.DebtPayment(GrossIncome, monthlyDebt);
				double Payment= Engine.Payment(debtPayment, housePayment);
				double interest = (rate/100/12);
				double totalPayments= (years *12);
				double pv = Engine.pv(interest, totalPayments, Payment, 0, false);
				textField_4.setText("$" + Payment);
				textField_5.setText("$"+ pv);
				
	
			}
		});
		btnCalculate.setBounds(6, 221, 117, 29);
		frame.getContentPane().add(btnCalculate);
		
		textField_4 = new JTextField();
		textField_4.setBounds(121, 244, 134, 28);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblMaxPayment = new JLabel("Max Payment");
		lblMaxPayment.setBounds(135, 226, 94, 16);
		frame.getContentPane().add(lblMaxPayment);
		
		textField_5 = new JTextField();
		textField_5.setBounds(274, 244, 134, 28);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblMaxMorgage = new JLabel("Max Morgage");
		lblMaxMorgage.setBounds(296, 226, 99, 16);
		frame.getContentPane().add(lblMaxMorgage);
	}

	
}
