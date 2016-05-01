package pa1;

/**
 * 
 * @author Tunya Wittayasiripaiboon 5810546676
 * Weight that cna be used.
 *
 */
public enum Weight implements Unit {
	
	KILOGRAM("Kilogram",1),
	GRAM("Gram",0.001),
	POUND("Pound",0.453592),
	OUNCE("Oounce",0.0283495),
	MILLIGRAM("Milligram",Math.pow(10, 6)),
	CHOUNG("Choung",1),
	HARBLUANG("Harb Luang",60);
	public final String name;
	public final double value;
	
	/**
	 * Constructor of Volumn 
	 * @param name is name of the unit.
	 * @param value is the value of the unit.
	 */
	
	Weight (String name ,double value){
		this.name = name;
		this.value = value;
	}
	
	/**
	 * Get value of the unit.
	 * @return value of the unit.
	 */
	public double getValue(){
		return value;
	}
	/**
	 * Get print name of unit.
	 * @return print name of unit.
	 */
	public String toString (){
		return name;
	}	

}

