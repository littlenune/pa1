package pa1;
/*
 * @author Tunya Wittayasiripaiboon 5810546676
 * Converts value from one unit to another.
 */
public class UnitConverter {
	/*
	 * Convert value from wanted unit to another wanted unit.
	 * @return result from the conversion.
	 */
	public double convert ( double amount , Unit fromUnit , Unit toUnit){
		double convertResult = (amount*fromUnit.getValue())/(toUnit.getValue());
		return convertResult;
	}
	/*
	 * Get the values of wanted unit.
	 * @return the array of values of the unit.
	 */
	public Unit [] getUnits(UnitType utype){
		return UnitFactory.getInstance().getUnits(utype);
	}

}
