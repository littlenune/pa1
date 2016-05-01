package pa1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.InputMismatchException;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/*
 * @author Tunya Wittayasiripaiboon 5810546676
 *  The UI of the unitConverter.
 */
public class ConverterUI extends JFrame{

	private JButton convertButton;
	private JButton clearButton;
	private UnitConverter unitconverter;
	private JPanel contentPane;
	private JTextField inputField1;
	private JTextField inputField2;
	private JComboBox <Unit> unit1ComboBox;
	private JComboBox <Unit> unit2ComboBox;
	private JLabel label;
	private JPanel pane;
	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem exit;

	/*
	 * Constructor receives references to UnitConverter also set JFrame.
	 * @param UnitConverter 
	 */

	public ConverterUI ( UnitConverter uc){

		this.unitconverter = uc;
		this.setTitle("Length Converter");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.initComponents();

	}
	/**
	 * Create the menu with menu items inside.
	 * @return the created menu.
	 */
	private JMenu makeMenu( ) {
		menu = new JMenu("Unit Types");
		UnitType [] unittypes = UnitFactory.getInstance().getUnitTypes();
		for(UnitType utype : unittypes ) {
			JMenuItem menuItem = new JMenuItem( utype.toString() );
			menuItem.addActionListener( new UnitAction( utype ) );
			menu.add( menuItem );
		}
		menu.add(new JSeparator());
		exit = new JMenuItem("EXIT");
		menu.add(exit);

		exit.addActionListener(new ExitAction());
		return menu;
	}
	/*
	 * Create components for the UI and position them using a layout manager.
	 */
	private void initComponents(){

		pane = new JPanel();
		pane.setLayout(new BorderLayout());
		contentPane = new JPanel();
		pane.add(contentPane, BorderLayout.CENTER);
		setContentPane(pane);
		contentPane.setLayout(new FlowLayout());

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		menuBar.add(makeMenu());

		inputField1 = new JTextField();
		contentPane.add(inputField1);
		inputField1.setColumns(10);
		inputField1.addKeyListener(new ConvertButtonListener());

		unit1ComboBox = new JComboBox<Unit>(Length.values());
		unit1ComboBox.addActionListener(new ConvertButtonListener());
		contentPane.add(unit1ComboBox);

		label = new JLabel("=");
		contentPane.add(label);

		inputField2 = new JTextField();
		contentPane.add(inputField2);
		inputField2.setColumns(10);
		inputField2.addKeyListener(new ConvertButtonListener());

		unit2ComboBox = new JComboBox<Unit>(Length.values());
		unit2ComboBox.addActionListener(new ConvertButtonListener());
		contentPane.add(unit2ComboBox);

		convertButton = new JButton("Convert!");
		contentPane.add(convertButton);

		clearButton = new JButton("Clear");
		contentPane.add(clearButton);

		convertButton.addActionListener(new ConvertButtonListener());
		clearButton.addActionListener(new ClearButtonListener());
		this.pack();

	}
	/*
	 * 
	 * @ author Tunya Wittayasiripaiboon 5810546676
	 * ActionListener related to the button when pressed or clicked will perform an action which is unitConverter to convert and result 
	 * values in another textField.
	 * KeyListener which related to the key typing it will automatically perform an action which is unitConverter to convert and result
	 * values in another textField instantly. 
	 */
	class ConvertButtonListener implements ActionListener , KeyListener{

		/*
		 * Convert value from selected to another selected unit by using unitConverter also detected the direction 
		 * to convert and result the value. 
		 */
		public void conversion (){
			inputField1.setForeground(Color.black);
			inputField2.setForeground(Color.black);
			String s = inputField1.getText().trim();
			String s2 = inputField2.getText().trim();
			if ( s.length() > 0 || s2.length() > 0){
				try {
					Unit unit1 = (Unit) unit1ComboBox.getSelectedItem();
					Unit unit2 = (Unit) unit2ComboBox.getSelectedItem();
					if ( inputField2.isEditable() == false || inputField1.hasFocus()  ){
						double value = Double.valueOf(s);
						inputField2.setText(String.format("%.10g",unitconverter.convert(value,unit1,unit2)));
					}
					else if ( inputField1.isEditable() == false || inputField2.hasFocus() ) {
						double value = Double.valueOf(s2);
						inputField1.setText(String.format("%.10g",unitconverter.convert(value,unit2,unit1)));
					}
				}
				catch ( NumberFormatException illegalInput){
					if (  inputField1.hasFocus()  ){
						inputField1.setForeground (Color.red);
					}
					else if ( inputField2.hasFocus() ){
						inputField2.setForeground(Color.red);
					}

				}
			}
		}



		/*
		 * Perform an action conversion when click on the button.
		 */
		public void actionPerformed( ActionEvent evt){
			this.conversion();

		}
		/*
		 * Perform an action when delete the text from the text field and also empty both of the text fields.
		 */
		@Override
		public void keyTyped(KeyEvent e) {

			if ( inputField1.hasFocus() && inputField1.getText().equals("")){
				inputField2.setText("");
			}
			else if ( inputField2.hasFocus() && inputField2.getText().equals("")){
				inputField1.setText("");
			}

		}
		/*
		 * Perform an action after pressed enter will convert the value.
		 */
		@Override
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode()==KeyEvent.VK_ENTER){
				this.conversion();
			}

		}
		/*
		 * Perform an action after input the value in text field.
		 */
		@Override
		public void keyReleased(KeyEvent e) {
			this.conversion();
		}


	}
	/**
	 * 
	 * @author Tunya Wittayasiripaiboon 5810546676 
	 * Clear input in both text fields.
	 */
	class ClearButtonListener implements ActionListener {

		public void actionPerformed( ActionEvent evt){

			inputField1.setText("");
			inputField2.setText("");
		}

	}
	/**
	 * 
	 * @author Tunya Wittayasiripaiboon 5810546676
	 * Perform action exit the program.
	 *
	 */
	class ExitAction implements ActionListener {

		/**
		 * Close program.
		 */
		public void actionPerformed(ActionEvent evt) {
			System.exit(JFrame.EXIT_ON_CLOSE);

		}
	}
	/**
	 * @author Tunya Wittayasiriapiboon 5810546676
	 * Add value of the unit into JCombo boxes.
	 */
	class UnitAction implements ActionListener {
		private UnitType type;
		/**
		 * Constructor of UnitAction
		 * @param utype is the unit type.
		 */
		public UnitAction(UnitType utype) {
			type = utype;
		}
		/**
		 * Change the unit in both combo boxes.
		 * @param utype is the unit type
		 */
		public void changeUnits(UnitType utype ){
			Unit[] units = unitconverter.getUnits(utype);
			unit1ComboBox.removeAllItems();
			unit2ComboBox.removeAllItems();
			for ( Unit u : units ) {
				unit1ComboBox.addItem(u);
				unit2ComboBox.addItem(u);
			}
		}

		@Override
		/**
		 * If the type is the same as unit type it will change the unit into its type.
		 */
		public void actionPerformed(ActionEvent e) {
			if ( type == UnitType.Length){
				changeUnits(UnitType.Length);
			}
			else if ( type == UnitType.Area){
				changeUnits(UnitType.Area);
			}
			else if ( type == UnitType.Weight){
				changeUnits(UnitType.Weight);
			}
			else if ( type == UnitType.Volume){
				changeUnits(UnitType.Volume);
			}
			else {
				changeUnits(UnitType.Length);
			}

		}
	}
}
