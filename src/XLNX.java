public class XLNX extends Item{
	
	public static double price;

	public XLNX(String n, String s, double p){
		super(n,s);
		XLNX.price = p;
	}

	public static void setPrice(double p){
		XLNX.price = p;
	}

	public static synchronized double getPrice (){
		return XLNX.price;
	}

	public static synchronized void bid (double p){
		XLNX.setPrice(p);
		Data.priceMap.put("XLNX",new Double(p));
	}



}