package pa1;

/**
 * 
 * @author Tunya Wittayasiripaiboon 5810546676
 * The unit of volumns that can be used.
 *
 */
public enum Volume implements Unit {
	LITRE("Litre",1.0),
	CUBICMETRE("Cubic metre",1000),
	MILLITRE("Millitre",0.001),
	GALLON("Gallon",3.78541),
	CUP("Imperial cup",0.24),
	TEASPOON("Teaspoon",0.004929),
	THOUNG("Thoung",20);
	
	
	public final String name;
	public final double value;

	/**
	 * Constructor of Volumn.
	 * @param name is name of the volumn.
	 * @param value is value of the volumn unit.
	 */
	Volume(String name , double value){
		this.name = name;
		this.value = value;

	}
	/**
	 * Get value of unit.
	 * @return value of the unit.
	 */
	public double getValue(){

		return value;

	}
	/**
	 * Get print name of the unit.
	 * @return print name of the unit.
	 */
	public String toString (){

		return name;
	}	
}


