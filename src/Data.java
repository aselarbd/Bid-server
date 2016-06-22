import java.io.*;
import java.util.*;
/*
* All Data handling is done throug this class
*
*
*/
public class Data{

	public static HashMap<String, Double> priceMap = new HashMap<String, Double>();
	public static HashMap<String, String> tmpPriceMap = new HashMap<String, String>();
	public static HashMap<String, String> tmpNameMap = new HashMap<String, String>();
	public static HashMap<String, String> nameMap = new HashMap<String, String>();
	public static ArrayList<His> fb = new ArrayList<His>();
	public static ArrayList<His> vrtu = new ArrayList<His>();
	public static ArrayList<His> msft = new ArrayList<His>();
	public static ArrayList<His> googl = new ArrayList<His>();
	public static ArrayList<His> yhoo = new ArrayList<His>();
	public static ArrayList<His> xlnx = new ArrayList<His>();
	public static ArrayList<His> tsla = new ArrayList<His>();
	public static ArrayList<His> txn = new ArrayList<His>();
	public static String [] fields;

	public static void getData(String cvsFile, String key, String val){
		FileReader fileRd=null; 
		BufferedReader reader=null; 

				try { 			
			    fileRd = new FileReader(cvsFile); 
			    reader = new BufferedReader(fileRd); 

			    /* read the CSV file's first line which has 
			     * the names of fields. 
			     */
			    String header = reader.readLine(); 
			    Data.fields = header.split(",");// keep field names 

			    // find where the key and the value are 
			    int keyIndex = Data.findIndexOf(key); 
			    //System.out.println(" dfdgdfg");  
			    int valIndex = Data.findIndexOf(val);

			    //System.out.println(" Key Ind : "+keyIndex);
			   	   // System.out.println(" Val Ind : "+valIndex);  
			      
			    if(keyIndex == -1 || valIndex == -1) 
				throw new IOException("CVS file does not have data"); 
			    // note how you can throw a new exception 

			    /* read each line, getting it split by , 
			     * use the indexes to get the key and value 
			     */
			    String [] tokens; 
			    for(String line = reader.readLine();line != null;line = reader.readLine()) { 
					//System.out.println("got val  ");
					tokens = line.split(","); 
					if (valIndex == 6 ) {
						//double dbl = Double.parseDouble(tokens[valIndex]);
						Data.tmpPriceMap.put(tokens[keyIndex], tokens[valIndex]); 
					}else if (valIndex == 1) {
						Data.tmpNameMap.put(tokens[keyIndex], tokens[valIndex]);
					}
					
			    }
			    
			    if(fileRd != null) fileRd.close();
			    if(reader != null) reader.close();
			    
		    // I can catch more than one exceptions 
		} catch (IOException e) { 
		    System.out.println(e);
		    System.exit(-1); 
		} catch (ArrayIndexOutOfBoundsException e) { 
		    System.out.println("Malformed CSV file");
		    System.out.println(e);
	}

	}

	public static int findIndexOf(String key) {
			int i;
		for( i=0; i < Data.fields.length; i++){
			//System.out.println("come "+i+" val for : "+Data.fields[i]);
			if(Data.fields[i].equals(key)){
				//System.out.println("got val  "+i);	
					return i;
			} 		    		   
		} 
		return -1; 
    }
	
	public static double findPrice(String key) { 
			double d = Double.parseDouble(Data.tmpPriceMap.get(key));
		return  d;
    }

    public static String findName(String key) { 
		
		return Data.tmpNameMap.get(key); 
    }
        
    public static void putData(String [] keys,String type){

    	if (type.equals("price")){
    		for (int i =0;i< keys.length ;i++ ) {
    		double p = Data.findPrice(keys[i]);
    		Data.priceMap.put(keys[i], new Double(p));
    		}
    	}else if (type.equals("name")){
    		for (int i =0;i< keys.length ;i++ ) {
    		Data.nameMap.put(keys[i],Data.findName(keys[i]));
    		}
    	}
    }
    	

    public static  void initialData(){
    	Data.getData("stocks.csv", "Symbol","Price"); 
    	Data.getData("stocks.csv", "Symbol","Security Name");
		String[] s = {"FB","VRTU","MSFT","GOOGL","YHOO","XLNX","TSLA","TXN"};  
		Data.putData(s,"name");
		Data.putData(s,"price");
    }
}
