public class GOOGL extends Item{
	
	public static double price;

	public GOOGL(String n, String s, double p){
		super(n,s);
		GOOGL.price = p;
	}

	public static void setPrice(double p){
		GOOGL.price = p;
	}

	public static synchronized double getPrice (){
		return GOOGL.price;
	}
	public static synchronized void bid (double p){
		GOOGL.setPrice(p);
		Data.priceMap.put("GOOGL",new Double(p));
	}

}