package modules;

public abstract class Product {
	private String prodNum;
	private String prodName;
	private double prodPrice;
	private int prodStockQuan;
	private boolean prodStat;
	
	public Product() {
		prodNum = "999999";
		prodName = "NA";
		prodPrice = 0.00;
		prodStockQuan = 0;
		prodStat = true;
	}
	
	public Product(String prodNum, String prodName, int prodStockQuan, double prodPrice) {
		this.prodNum = prodNum;
		this.prodName = prodName;
		this.prodStockQuan = prodStockQuan;
		this.prodPrice = prodPrice;
		this.prodStat = true;
	}
	
	public String getProdName() {
		return prodName;
	}
	
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	
	public double getProdPrice() {
		return prodPrice;
	}
	
	public void setProdPrice(double prodPrice) {
		this.prodPrice = prodPrice;
	}
	
	public int getProdStockQuan() {
		return prodStockQuan;
	}
	
	public void setProdStockQuan(int prodStockQuan) {
		this.prodStockQuan = prodStockQuan;
	}
	
	public String getProdNum() {
		return prodNum;
	}
	
	public void setProdNum(String prodNum) {
		this.prodNum = prodNum;
	}
	
	public boolean getProdStat() {
		return prodStat;
	}
	
	public void setProdStat(boolean prodStat) {
		this.prodStat = prodStat;
	}
	
	public  double getTotalInventoryValue() {
		return getProdPrice() * getProdStockQuan();
	}
	
	public  void addProdQuan(int addQuan) {
		// add 
		if(prodStat) 
			prodStockQuan += addQuan;
		else 
			// fail insertion
			System.out.print("Item is not available at the moment");
		
	}
	
	public  void dedProdQuan(int dedQuan) {
		// deductible only if item is UP
		if(prodStat) 
			prodStockQuan -= dedQuan;
		else
			System.out.print("Item is not available at the moment");
	}
	
	public  String toString() {
		
		String prodStr;
		prodStr = 
		"Item Number\t\t: \t"  + getProdNum()
		+ "\nProduct Name : \t" + getProdName()
		+ "\nQuantity Available\t:\t" + getProdStockQuan()
		+ "\nPrice (RM)\t\t:\t" + String.format("%.2f",getProdPrice())
		+ "\nInventory Value (RM)\t:\t" + String.format("%.2f", getTotalInventoryValue())
		+ "\nProduct status\t\t:\t" + (getProdStat()? "Active":"Discontinued");
		return prodStr;
	}
	
}
