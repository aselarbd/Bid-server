public abstract class Item{
	
	protected String symbol;
	protected String name ;

	protected Item(String n, String s){
		this.name = n;
		this.symbol = s;
	}

	public void setName(String n){
		this.name = n;
	}

	public void setSymbol (String s){
		this.symbol = s;
	}

	public String getName(){
		return this.name;
	}

	public String getSymbol(){
		return this.symbol;
	}

}