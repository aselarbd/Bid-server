public class MSFT extends Item{
	
	public static double price;

	public MSFT(String n, String s, double p){
		super(n,s);
		MSFT.price = p;
	}

	public static void setPrice(double p){
		MSFT.price = p;
	}

	public static synchronized double getPrice (){
		return MSFT.price;
	}

	public static synchronized void bid (double p){
		MSFT.setPrice(p);
		Data.priceMap.put("MSFT",new Double(p));
	}

}