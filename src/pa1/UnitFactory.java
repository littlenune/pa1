package pa1;

/**
 * 
 * @author Tunya Wittayasiripaiboon 5810546676
 * UnitFactory class include all units that is known.
 *
 */
public class UnitFactory {

	private static UnitFactory unitFactory;
	private UnitType[] type = new UnitType[4];

	/**
	 *  Constructor of UnitFactory class.
	 */
	
	public UnitFactory() {
		this.type = new UnitType[4];
	}
	/**
	 * Create unitfactory.
	 * @return unitfactory
	 */
	public static UnitFactory getInstance(){
		if ( unitFactory == null)
			return unitFactory = new UnitFactory();
		else return unitFactory;

	}
	
	/**
	 * Type of all units.
	 * @return values of all units.
	 */
	public UnitType[] getUnitTypes(){
		return UnitType.values();
	}
	
	/**
	 * If type of unit is the same as unit type it will return the values of that unit.
	 * @param utype is type of unit.
	 * @return values of each unit.
	 */
	public Unit[] getUnits (UnitType utype){
		if ( utype.equals(UnitType.Length))
			return Length.values();
		else if ( utype.equals(UnitType.Area))
			return Area.values();
		else if ( utype.equals(UnitType.Weight))
			return Weight.values();
		else if ( utype.equals(UnitType.Volume))
			return Volume.values();
		return null;
	}
}
