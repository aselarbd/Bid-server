public class His{
	private String name;
	private String symbol;
	private double bid;

	public His(String n,String s,double b){
		this.name = n;
		this.symbol = s;
		this.bid = b;
	}

	public String getName(){
		return this.name;
	}

	public String getSymbol(){
		return this.symbol;
	}

	public double getBid(){
		return this.bid;
	}
}