package com.booking.services;

import java.util.List;

import com.booking.model.TheaterTimeSlotModel;

public interface TheaterTimeSlotServices {
	List<TheaterTimeSlotModel> getAllTimeSlot();//Lấy ra danh sách rạp và các khung thời gian
	List<TheaterTimeSlotModel> getEmptyTimeSlot(String day);//Lấy ra ds các rạp tương ứng với thời gian trống
	List<Integer> getAvailableTheater();//lấy ds rạp còn tgian trống
	List<TheaterTimeSlotModel> getAvailableTimeSlot(int id);//lấy ds thời gian tương ứng với rạp
	List<TheaterTimeSlotModel> getAvailableTheater1();
}
