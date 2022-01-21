package com.example.GiftCard.Controller;

import java.util.List;

public class ConstantList {
	public static GiftCardData[] data= {new GiftCardData("amazon", "12345", 987655431, 400),new GiftCardData("DSW","123456",987654321,500),new GiftCardData("ABCD","1233456",98777541,200)};

}


class GiftCardData{
	String companyName;
	String barCode;
	int ISBN;
	int giftPrice;
	public GiftCardData(String companyName, String barCode, int iSBN, int giftPrice) {
		super();
		this.companyName = companyName;
		this.barCode = barCode;
		ISBN = iSBN;
		this.giftPrice = giftPrice;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getBarCode() {
		return barCode;
	}
	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}
	public int getISBN() {
		return ISBN;
	}
	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}
	public int getGiftPrice() {
		return giftPrice;
	}
	public void setGiftPrice(int giftPrice) {
		this.giftPrice = giftPrice;
	}
	@Override
	public String toString() {
		return "GiftCardData [companyName=" + companyName + ", barCode=" + barCode + ", ISBN=" + ISBN + ", giftPrice="
				+ giftPrice + "]";
	}
	
}