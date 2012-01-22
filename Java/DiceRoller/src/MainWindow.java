import java.awt.Button;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 * @author Twenty Codes, LLC
 * @author ricky barrette
 * @date Dec 19, 2010
 */

/**
 * this is the main window of the dice roller application
 * @author ricky barrette
 */
public class MainWindow extends JFrame implements ActionListener {

	private static final long serialVersionUID = -382484290158631244L;
	private Button mRollButton;
	private JTextField mRolls;
	private JRadioButton mD2;
	private JRadioButton mD3;
	private JRadioButton mD4;
	private JRadioButton mD6;
	private JRadioButton mD10;
	private JRadioButton mD8;
	private JRadioButton mD20;
	private JRadioButton mD100;
	private int mSides = 2;
	private JLabel mRolled;
	
	/**
	 * Creates a new MainWindow
	 * @author ricky barrette
	 */
	public MainWindow(){
		setTitle("Dice Roller");
		this.setMinimumSize(new Dimension(190,310));
		
		initializedButtonsAndSuch();	
	}

	/**
	 * initializes everything 
	 * @author ricky barrette
	 */
	private void initializedButtonsAndSuch() {
		//lets create the main window
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		JLabel label = new JLabel("Number of dice: ");
		label.setBounds(12, 7, 115, 15);
		panel.add(label);
		mRolls = new JTextField();
		mRolls.setBounds(135, 5, 48, 19);
		mRolls.setColumns(4);
		panel.add(mRolls);
		
		//create radio buttons and group them
		ButtonGroup group = new ButtonGroup();
		
		mRollButton = new Button("Roll!");
		mRollButton.setBounds(10, 219, 173, 23);

		//set action listeners
		mRollButton.addActionListener(this);
		setVisible(true);
		mD2 = new JRadioButton("D2");
		mD3 = new JRadioButton("D3");
		mD4 = new JRadioButton("D4");
		mD6 = new JRadioButton("D6");
		mD8 = new JRadioButton("D8");
		mD10 = new JRadioButton("D10");
		mD20 = new JRadioButton("D20");
		mD100 = new JRadioButton("D100");
		group.add(mD2);
		group.add(mD3);
		group.add(mD4);
		group.add(mD6);
		group.add(mD8);
		group.add(mD10);
		group.add(mD20);
		group.add(mD100);
		mD2.setSelected(true);
		
		//Put the radio buttons in a column in a panel.
        JPanel radioPanel = new JPanel(new GridLayout(0, 1));
        radioPanel.setBounds(44, 29, 59, 184);
        radioPanel.add(mD2);
        radioPanel.add(mD3);
        radioPanel.add(mD4);
        radioPanel.add(mD6);
        radioPanel.add(mD8);
        radioPanel.add(mD10);
        radioPanel.add(mD20);
        radioPanel.add(mD100);
        mD2.addActionListener(this);
        mD3.addActionListener(this);
        mD4.addActionListener(this);
        mD6.addActionListener(this);
        mD8.addActionListener(this);
        mD10.addActionListener(this);
        mD20.addActionListener(this);
        mD100.addActionListener(this);
        panel.add(radioPanel);
		
		panel.add(mRollButton);
		this.getContentPane().add(panel);
		
		mRolled = new JLabel();
		mRolled.setBounds(12, 248, 171, 15);
		panel.add(mRolled);
	}

	/**
	 * (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 * @author ricky barrette
	 */
	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == mRollButton){
			try{
				mRolled.setText(DiceRoller.rollDice(Integer.parseInt(mRolls.getText()), mSides));
			} catch (Exception e){
				mRolled.setText("FAIL");
			}
		}
		if(event.getSource() == mD2){
			mSides = 2;
		}
		if(event.getSource() == mD3){
			mSides = 3; 
		}
		if(event.getSource() == mD4){
			mSides = 4;
		}
		if(event.getSource() == mD6){
			mSides = 6;
		}
		if(event.getSource() == mD8){
			mSides = 8;
		}
		if(event.getSource() == mD10){
			mSides = 10;
		}
		if(event.getSource() == mD20){
			mSides = 20;
		}
		if(event.getSource() == mD100){
			mSides  =100;
		}
		
	}

	/**
	 * main method, called when the application starts
	 * @param args
	 * @author ricky barrette
	 */
	public static void main(String[] args) {
		new MainWindow();
	}
}
