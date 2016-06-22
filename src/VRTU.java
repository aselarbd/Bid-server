public class VRTU extends Item{
	
	public static double price;

	public VRTU(String n, String s, double p){
		super(n,s);
		VRTU.price = p;
	}

	public static void setPrice(double p){
		VRTU.price = p;
	}

	public static synchronized double getPrice (){
		return VRTU.price;
	}

	public static synchronized void bid (double p){
		VRTU.setPrice(p);
		Data.priceMap.put("VRTU",new Double(p));
	}

}