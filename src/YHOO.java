public class YHOO extends Item{
	
	public static double price;

	public YHOO(String n, String s, double p){
		super(n,s);
		YHOO.price = p;
	}

	public static void setPrice(double p){
		YHOO.price = p;
	}

	public static synchronized double getPrice (){
		return YHOO.price;
	}

	public static synchronized void bid (double p){
		YHOO.setPrice(p);
		Data.priceMap.put("YHOO",new Double(p));
	}

}