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

	private JFrame frame;
	private JTextField txtfDesiredDose;
	private JLabel lblWelcome;
	private JLabel lblDesiredDose;
	private JLabel lblCalcResult;
	private JLabel lblAmtOnHand;
	private JTextField txtfAmtOnHand;
	private JLabel lblNumTab;
	private JTextField txtfNumTab;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DisplayProgram window = new DisplayProgram();
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
	public DisplayProgram() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 320, 377);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBackground(SystemColor.inactiveCaption);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
					.addGap(11))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
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
		
		lblAmtOnHand = new JLabel("Amount On Hand");
		lblAmtOnHand.setHorizontalAlignment(SwingConstants.LEFT);
		lblAmtOnHand.setFont(new Font("SansSerif", Font.BOLD, 12));
		
		txtfAmtOnHand = new JTextField();
		txtfAmtOnHand.setToolTipText("Enter amount on hand");
		txtfAmtOnHand.setHorizontalAlignment(SwingConstants.LEFT);
		txtfAmtOnHand.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtfAmtOnHand.setColumns(10);
		
		lblNumTab = new JLabel("Number of tablets");
		lblNumTab.setHorizontalAlignment(SwingConstants.LEFT);
		lblNumTab.setFont(new Font("SansSerif", Font.BOLD, 12));
		
		txtfNumTab = new JTextField();
		txtfNumTab.setToolTipText("Enter number of tablets");
		txtfNumTab.setHorizontalAlignment(SwingConstants.LEFT);
		txtfNumTab.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtfNumTab.setColumns(10);
		
		JButton btnOK = new JButton("OK");
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double desiredDose = Double.parseDouble(txtfDesiredDose.getText());
				double amtOnHand = Double.parseDouble(txtfAmtOnHand.getText());
				double numTab = Double.parseDouble(txtfNumTab.getText());
				lblCalcResult.setText( Double.toString((desiredDose/amtOnHand)*numTab) );
			}
		});
		btnOK.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblWelcome, GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblAmtOnHand, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDesiredDose, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(txtfDesiredDose, Alignment.LEADING)
								.addComponent(txtfAmtOnHand, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(btnOK, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
							.addGap(21)
							.addComponent(btnCancel, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE))
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
							.addGroup(gl_panel.createSequentialGroup()
								.addComponent(lblResult)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(lblCalcResult, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
								.addComponent(lblNumTab, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(txtfNumTab, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(lblWelcome, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDesiredDose)
						.addComponent(txtfDesiredDose, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(8)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAmtOnHand)
						.addComponent(txtfAmtOnHand, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addGap(8)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNumTab, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtfNumTab, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 123, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblResult)
						.addComponent(lblCalcResult))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnOK, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCancel))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		frame.getContentPane().setLayout(groupLayout);
	}
}
