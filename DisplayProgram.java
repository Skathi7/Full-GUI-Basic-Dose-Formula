import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DisplayProgram {

	private JFrame frmUniversalDoseFormula;
	private JTextField txtfDesiredDose;
	private JLabel lblWelcome;
	private JLabel lblDesiredDose;
	private JLabel lblCalcResult;
	private JLabel lblAmtOnHand;
	private JTextField txtfAmtOnHand;
	private JLabel lblNumTab;
	private JTextField txtfNumTab;
	private double desiredDose, amtOnHand, numTab;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DisplayProgram window = new DisplayProgram();
					window.frmUniversalDoseFormula.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DisplayProgram() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmUniversalDoseFormula = new JFrame();
		frmUniversalDoseFormula.setTitle("Universal Dose Formula");
		frmUniversalDoseFormula.setResizable(false);
		frmUniversalDoseFormula.setBounds(100, 100, 330, 394);
		frmUniversalDoseFormula.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBackground(SystemColor.inactiveCaption);
		GroupLayout groupLayout = new GroupLayout(frmUniversalDoseFormula.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 284, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(10))
		);
		
		lblWelcome = new JLabel("Welcome");
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setFont(new Font("Castellar", Font.BOLD, 20));
		
		lblDesiredDose = new JLabel("Desired Dose");
		lblDesiredDose.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblDesiredDose.setHorizontalAlignment(SwingConstants.LEFT);
		
		txtfDesiredDose = new JTextField();
		txtfDesiredDose.setToolTipText("Enter desired dose");
		txtfDesiredDose.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtfDesiredDose.setHorizontalAlignment(SwingConstants.LEFT);
		txtfDesiredDose.setColumns(10);
		
		JLabel lblResult = new JLabel("Result: ");
		lblResult.setHorizontalAlignment(SwingConstants.LEFT);
		lblResult.setFont(new Font("SansSerif", Font.BOLD, 12));
		
		lblCalcResult = new JLabel(" ");
		lblCalcResult.setFont(new Font("SansSerif", Font.BOLD, 12));
		
		lblAmtOnHand = new JLabel("Amount on Hand");
		lblAmtOnHand.setHorizontalAlignment(SwingConstants.LEFT);
		lblAmtOnHand.setFont(new Font("SansSerif", Font.BOLD, 12));
		
		txtfAmtOnHand = new JTextField();
		txtfAmtOnHand.setToolTipText("Enter amount on hand");
		txtfAmtOnHand.setHorizontalAlignment(SwingConstants.LEFT);
		txtfAmtOnHand.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtfAmtOnHand.setColumns(10);
		
		lblNumTab = new JLabel("Number of Tablets");
		lblNumTab.setHorizontalAlignment(SwingConstants.LEFT);
		lblNumTab.setFont(new Font("SansSerif", Font.BOLD, 12));
		
		txtfNumTab = new JTextField();
		txtfNumTab.setToolTipText("Enter number of tablets");
		txtfNumTab.setHorizontalAlignment(SwingConstants.LEFT);
		txtfNumTab.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtfNumTab.setColumns(10);
		
		JButton btnOK = new JButton("OK");//Will use the basic universal dose formula to make the calculation if OK is pressed
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (! (txtfDesiredDose.getText().isEmpty() || txtfAmtOnHand.getText().isEmpty() || txtfNumTab.getText().isEmpty()) ) {
				 desiredDose = Double.parseDouble(txtfDesiredDose.getText());//Getting the users entered desired dose
				 amtOnHand = Double.parseDouble(txtfAmtOnHand.getText());//Getting the users entered amount on hand
				 numTab = Double.parseDouble(txtfNumTab.getText());//Getting the users entered number of tablets
 
				 if ( numTab > 0 ) {//Diving by 0 would be undefined, checking we can do the math
					 lblCalcResult.setText( Double.toString((desiredDose/amtOnHand)*numTab) );
				 }else {
					 lblCalcResult.setText("");
				}//End of if else statement, making sure num of tablets is greater than 0 else set the result to blank
			    }//End of major if statement, making sure the user entered values, note if anything but a number is entered there will be an error - NEEDS TO BE FIXED
				else {//Else clear the results, if there is an old result still and the user forgot to enter the number of tablets(left it empty) this will clear the results. 
					lblCalcResult.setText("");
				}
			}	
		});//End of OK button
		btnOK.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JButton btnClear = new JButton("Clear");//Clear button, if pressed it will clear all text fields
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtfDesiredDose.setText("");//Clearing the user entry
				txtfAmtOnHand.setText("");//Cleaning the user entry
				txtfNumTab.setText("");//Clearing the user entry
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(btnOK, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED, 13, Short.MAX_VALUE)
							.addComponent(btnClear, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
							.addGap(12))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNumTab, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(1)
									.addComponent(lblAmtOnHand, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblDesiredDose, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(txtfNumTab, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(txtfDesiredDose, Alignment.LEADING)
									.addComponent(txtfAmtOnHand, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)))
							.addGap(56))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(4)
							.addComponent(lblResult)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblCalcResult, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 120, Short.MAX_VALUE)))
					.addContainerGap())
				.addComponent(lblWelcome, GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(lblWelcome, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtfDesiredDose, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDesiredDose))
					.addGap(8)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtfAmtOnHand, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblAmtOnHand))
					.addGap(8)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtfNumTab, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNumTab, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 123, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCalcResult)
						.addComponent(lblResult))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnOK, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnClear))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		frmUniversalDoseFormula.getContentPane().setLayout(groupLayout);
	}
}
