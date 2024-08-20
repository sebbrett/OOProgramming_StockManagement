package modules;

public class TV extends Product{
	private String tvScreenType;
	private String tvResolution;
	private String tvDisplaySize;
	
	public TV() {
		super();
		this.setProdName("TV");
		this.tvScreenType = this.tvResolution = this.tvDisplaySize = "NA";
	}
	
	public TV(String prodNum, String prodName, int prodStockQuan,
			double prodPrice, String tvScreenType, String tvResolution,
			String tvDisplaySize) {
		super(prodNum,prodName,prodStockQuan,prodPrice);		
		this.tvScreenType = tvScreenType;
		this.tvResolution = tvResolution;
		this.tvDisplaySize = tvDisplaySize;
	}
	
	public String getTvScreenType() {
		return tvScreenType;
	}
	
	public void setTvScreenType(String tvScreenType) {
		this.tvScreenType = tvScreenType;
	}
	
	public String getTvResolution() {
		return tvResolution;
	}
	
	public void setTvResolution(String tvResolution) {
		this.tvResolution = tvResolution;
	}
	
	public String getTvDisplaySize() {
		return tvDisplaySize;
	}
	
	public void setTvDisplaySize(String tvDisplaySize) {
		this.tvDisplaySize = tvDisplaySize;
	}
	
	public double getTVValue() {
		return getProdStockQuan() * getProdPrice();
	}
	
	@Override
	public String toString() {
		String tvStr;
		tvStr ="Item Number\t\t\t:\t"  + getProdNum() 
				+  "\nProduct Name\t\t\t:\t" + getProdName()
				+ "\nScreen type\t\t\t:\t" + getTvScreenType()
				+ "\nResolution\t\t\t:\t" + getTvResolution()
				+ "\nDisplay size\t\t\t:\t" + getTvDisplaySize()
				+ "\nQuantity Available\t\t:\t" + getProdStockQuan()
				+ "\nPrice (RM)\t\t\t:\t" + String.format("%.2f",getProdPrice())
				+ "\nInventory Value (RM)\t:\t" + String.format("%.2f",getTVValue())
				+ "\nProduct status\t\t\t:\t" + (getProdStat()?"Active":"Discontinued");
		return tvStr;
	}
	
}
