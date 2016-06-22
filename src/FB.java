public class FB extends Item{
	
	public static double price;

	public FB(String n, String s, double p){
		super(n,s);
		FB.price = p;
	}

	public static void setPrice(double p){
		FB.price = p;
	}

	public static synchronized  double getPrice (){
		return FB.price;
	}

	public static synchronized void bid (double p){
		FB.setPrice(p);
		Data.priceMap.put("FB",new Double(p));
	}

}