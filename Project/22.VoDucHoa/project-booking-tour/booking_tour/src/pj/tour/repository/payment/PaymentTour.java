package pj.tour.repository.payment;

import java.util.List;

import pj.tour.entity.PaymentTourEntity;
import pj.tour.entity.TourEntity;

public interface PaymentTour {
	void payTour(String booking);	
	List<PaymentTourEntity> showListTour(String pay_id);
	void updateInfo(int count, String id);
	int findMoney(String id);
}
