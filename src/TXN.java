public class TXN extends Item{
	
	public static double price;

	public TXN(String n, String s, double p){
		super(n,s);
		TXN.price = p;
	}

	public static void setPrice(double p){
		TXN.price = p;
	}

	public static synchronized double getPrice (){
		return TXN.price;
	}

	public static synchronized void bid (double p){
		TXN.setPrice(p);
		Data.priceMap.put("TXN",new Double(p));
	}

}