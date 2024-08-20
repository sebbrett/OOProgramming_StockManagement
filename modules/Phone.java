package modules;

public class Phone extends Product{
	private String phoneBrand, phoneModel;
	private int phoneRAM;
	
	public Phone() {
		super();
		this.phoneBrand = this.phoneModel = "NA";
		this.phoneRAM = 0;
	}
	
	public Phone(String prodNum, String prodName, int prodStockQuan,
			double prodPrice, String phoneBrand, String phoneModel,
			int phoneRAM) {
		super(prodNum,prodName,prodStockQuan,prodPrice);	
		this.phoneBrand = phoneBrand;
		this.phoneModel = phoneModel;
		this.phoneRAM = phoneRAM;
	}

	public String getPhoneBrand() {
		return phoneBrand;
	}

	public void setPhoneBrand(String phoneBrand) {
		this.phoneBrand = phoneBrand;
	}

	public String getPhoneModel() {
		return phoneModel;
	}

	public void setPhoneModel(String phoneModel) {
		this.phoneModel = phoneModel;
	}

	public int getPhoneRAM() {
		return phoneRAM;
	}

	public void setPhoneRAM(int phoneRAM) {
		this.phoneRAM = phoneRAM;
	}

	public double getPhoneValue() {
		return getProdStockQuan() * getProdPrice();
	}
	@Override
	public String toString() {
		String PhoneStr;
		PhoneStr ="Item Number\t\t\t:\t"  + getProdNum() 
				+  "\nProduct Name\t\t\t:\t" + getProdName()
				+ "\nPhone brand\t\t\t:\t" + getPhoneBrand()
				+ "\nPhone model\t\t\t:\t" + getPhoneModel()
				+ "\nRAM size\t\t\t\t:\t" + getPhoneRAM()
				+ "\nQuantity Available\t\t:\t" + getProdStockQuan()
				+ "\nPrice (RM)\t\t\t: \t" + getProdPrice()
				+ "\nInventory Value (RM)\t:\t" + getPhoneValue()
				+ "\nProduct status\t\t\t: \t" + (getProdStat()?"Active":"Discontinued");
		return PhoneStr;
	}
	
}
