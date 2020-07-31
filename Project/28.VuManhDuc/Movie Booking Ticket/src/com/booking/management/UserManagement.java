package com.booking.management;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.booking.entity.BookingEntity;
import com.booking.model.ShowListMovieModel;
import com.booking.repository.BookingRepository;
import com.booking.repositoryimpl.BookingRepositoryImpl;
import com.booking.services.BookingDetailServices;
import com.booking.services.ShowListMovieServices;
import com.booking.servicesimpl.BookingDetailServicesImpl;
import com.booking.servicesimpl.ShowListMovieServicesImpl;

public class UserManagement {
	Scanner scanner = new Scanner(System.in);
	
	public UserManagement() {}
	public void userInterface(int idUser, int age) {
		ShowListMovieServices showListMovieServices = new ShowListMovieServicesImpl();
		List<ShowListMovieModel> listMovie = new ArrayList<>();
		List<String> listSeat = new ArrayList<>();
		String seatPosition;
		BookingRepository bookingRepository = new BookingRepositoryImpl();
		BookingDetailServices bookingDetailServices = new BookingDetailServicesImpl();
		String function;
		boolean transaction = true;
		while (transaction) {
			boolean flag;
			System.out.println("=======================================================");
			System.out.println("1.Booking || 2. Change pass || 3.View history || 4.Exit");
			do {
				System.out.print("Choose: ");
				function = scanner.next();
				String digit = "\\d";
				flag = function.matches(digit);
				if (!flag)
					System.out.println("You must enter a number!");
			} while (!flag || Integer.parseInt(function) < 1 || Integer.parseInt(function) > 4);
			switch (Integer.parseInt(function)) {
			case 1:
				int idBooking = 0;
				listMovie = showListMovieServices.showListMovie();
				System.out.print("Choose film with compatible number: ");
				int film = scanner.nextInt();
				System.out.println(listMovie.get(film-1).getIdMovie());
				System.out.println(listMovie.get(film-1).getEmpty());
				if(listMovie.get(film-1).getEmpty() == 0)
					System.out.println("That movie is currently full of seat. Choose another movie.");
				else {
					seatPosition = showListMovieServices.showSeatPosition(listMovie.get(film - 1).getIdMovie());
					BookingEntity bookingEntity = new BookingEntity();
					bookingEntity.setIdUser(idUser);
					bookingEntity.setIdMovie(listMovie.get(film - 1).getIdMovie());
					bookingEntity.setSeatPosition(seatPosition);
					if (age > 20)
						bookingEntity.setIdPrice(2);
					else if (age < 20)
						bookingEntity.setIdPrice(1);
					idBooking = bookingRepository.addBooking(bookingEntity);
					bookingDetailServices.printReceipt(idBooking);
				}
				
				break;
			case 2:
				break;
			case 3:
				System.out.println("Your list booking history!");
				bookingDetailServices.showListBookingHistory(idUser);
				break;
			case 4:
				System.exit(0);
				break;
			}
			System.out.println("Continue? Y/N");
			String cont = scanner.next();
			if (cont.equalsIgnoreCase("Y")) {
				transaction = true;
			} else {
				transaction = false;
			}
		}

		scanner.close();
	}
	
}
