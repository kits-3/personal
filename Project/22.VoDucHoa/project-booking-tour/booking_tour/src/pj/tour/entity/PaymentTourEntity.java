package pj.tour.entity;

public class PaymentTourEntity {
	private String payId;
	private String tourID;
	private String userID;
	private int moneyNumber;
	
	
	public PaymentTourEntity() {
		super();
	}

	public PaymentTourEntity(String payId, String tourID, String userID, int moneyNumber) {
		super();
		this.payId = payId;
		this.tourID = tourID;
		this.userID = userID;
		this.moneyNumber = moneyNumber;
	}
	
	public String getPayId() {
		return payId;
	}
	public void setPayId(String payId) {
		this.payId = payId;
	}
	public String getTourID() {
		return tourID;
	}
	public void setTourID(String tourID) {
		this.tourID = tourID;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public int getMoneyNumber() {
		return moneyNumber;
	}
	public void setMoneyNumber(int moneyNumber) {
		this.moneyNumber = moneyNumber;
	}
	
	
}
