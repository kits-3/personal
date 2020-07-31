package dto;

public class ReceiptDTO extends CommonDTO {
	private int userId;
	private int total;
	private int status;
	
	public ReceiptDTO() {
	}

	public ReceiptDTO(int userId, int total, int status) {
		this.userId = userId;
		this.total = total;
		this.status = status;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
