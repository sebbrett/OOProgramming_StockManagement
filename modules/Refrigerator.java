package modules;

public class Refrigerator extends Product{
	private String fridgeDoorDesign, fridgeColor;
	private double fridgeCapacity;
	
	public Refrigerator() {
		super();
		setProdName("Refrigerator");
		this.fridgeDoorDesign = this.fridgeColor = "NA";
		this.fridgeCapacity = 0;
	}
	
	public Refrigerator(String prodNum, String prodName, 
			int prodStockQuan, double prodPrice, String fridgeDoorDesign, 
			String fridgeColor, double fridgeCapacity)
	{
		super(prodNum,prodName,prodStockQuan,prodPrice);
		this.fridgeDoorDesign = fridgeDoorDesign;
		this.fridgeColor = fridgeColor;
		this.fridgeCapacity = fridgeCapacity;
	}
	
	public String getFridgeDoorDesign() {
		return fridgeDoorDesign;
	}

	public void setFridgeDoorDesign(String fridgeDoorDesign) {
		this.fridgeDoorDesign = fridgeDoorDesign;
	}

	public String getFridgeColor() {
		return fridgeColor;
	}

	public void setFridgeColor(String fridgeColor) {
		this.fridgeColor = fridgeColor;
	}

	public double getFridgeCapacity() {
		return fridgeCapacity;
	}

	public void setFridgeCapacity(double fridgeCapacity) {
		this.fridgeCapacity = fridgeCapacity;
	}
	public double getRefrigeratorValue() {
		return getProdStockQuan() * getProdPrice();
	}
	
	@Override
	public String toString() {
		String fridgeStr;
		fridgeStr = "Item Number\t\t\t:\t"  + getProdNum()
		+ "\nProduct Name\t\t\t:\t" + getProdName()
		+ "\nDoor design \t\t\t:\t" + getFridgeDoorDesign() 
		+ "\nColor \t\t\t\t:\t" + getFridgeColor() 
		+ "\nCapacity (in Litres)\t\t:\t" + String.format("%.2f", getFridgeCapacity()) 
		+ "\nQuantity Available\t\t:\t" + getProdStockQuan()
		+ "\nPrice (RM)\t\t\t:\t" + String.format("%.2f",getProdPrice())
		+ "\nInventory Value (RM)\t:\t" + String.format("%.2f",getRefrigeratorValue())
		+ "\nProduct status\t\t\t:\t" + (getProdStat()? "Active":"Discontinued");
		return fridgeStr;
	}
	
	
}
