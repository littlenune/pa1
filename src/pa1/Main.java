package pa1;

import java.awt.EventQueue;

/**
 * 
 * @author Tunya Wittayasiripaiboon 5810546676
 *	The application class.
 */
public class Main {
	public static void main ( String [] args){
		
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						UnitConverter uc = new UnitConverter();
						ConverterUI frame = new ConverterUI(uc);
						frame.setSize(900,100);
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});	
	}
}
