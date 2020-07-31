package atm.entity;

public class History {
	private int id;
	private int account_id;
	private int type;
	private double money;
	private int transfer_id;
	private String create_at;
	private int status;
	
	public History() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAccount_id() {
		return account_id;
	}

	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public int getTransfer_id() {
		return transfer_id;
	}

	public void setTransfer_id(int transfer_id) {
		this.transfer_id = transfer_id;
	}

	public String getCreate_at() {
		return create_at;
	}

	public void setCreate_at(String create_at) {
		this.create_at = create_at.substring(0,19);
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	public String get_NameType() {
		String nameType = "";
		if(this.type == 1) {
			nameType =  "Withdraw";
		}else if(this.type == 2) {
			nameType =  "Transfer";
		}else if(this.type == 3) {
			nameType =  "Deposit";
		}else if(this.type == 4) {
			nameType =  "Change password";
		}
		return nameType;
	}
	
	
}
