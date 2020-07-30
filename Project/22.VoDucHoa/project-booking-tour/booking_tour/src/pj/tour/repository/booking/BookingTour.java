package pj.tour.repository.booking;

import java.util.List;

import pj.tour.entity.TourEntity;
import pj.tour.entity.UserEntity;

public interface BookingTour {
	String bookingTour();
	List<TourEntity> findAll();
	String findById();
	int addInfo();
	List<TourEntity> showListTour(String location);
	void plusNumberMember(TourEntity tour);
}
