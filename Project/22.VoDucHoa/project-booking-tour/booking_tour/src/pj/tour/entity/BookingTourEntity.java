package pj.tour.entity;

public class BookingTourEntity {
	private String id;
	private String user_id;
	private String tour_id;
	private String time_booking;
		
	public BookingTourEntity() {
		super();
	}
	
	public BookingTourEntity(String id, String user_id, String tour_id, String time_booking) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.tour_id = tour_id;
		this.time_booking = time_booking;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getTour_id() {
		return tour_id;
	}
	public void setTour_id(String tour_id) {
		this.tour_id = tour_id;
	}
	public String getTime_booking() {
		return time_booking;
	}
	public void setTime_booking(String time_booking) {
		this.time_booking = time_booking;
	}
}
