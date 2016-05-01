package pa1;
/**
 * 
 * @author Tunya Wittayasiriapiboon 5810546676
 *	Area that can be used.
 */
public enum Area implements Unit{

	METER("Square Meter",1.0),
	KILOMETER("Square Kilometer", Math.pow(10, 6)),
	CENTIMETER("Square Centimeter", Math.pow(10, -6)),
	ACRE("Acre",4046.86),
	FOOT("Square Foot",0.092903),
	WA("Wa",4);
	public final String name;
	public final double value;

	/**
	 * Constructor of Area.
	 * @param name is name of each Area Unit.
	 * @param value is value of each Area Unit.
	 */
	Area (String name ,double value){
		this.name = name;
		this.value = value;

	}
	/**
	 * Implements from Unit interface get value of the length.
	 * @return value of the area.
	 * 
	 */
	public double getValue(){

		return value;

	}
	/**
	 * Implements from Unit interface get name of the length.
	 * @return name of the area.
	 */
	public String toString (){
		
		return name;
	}	
}


