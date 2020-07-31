package com.booking.management;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.booking.entity.MovieTimeEntity;
import com.booking.entity.TheaterEntity;
import com.booking.model.ShowListMovieModel;
import com.booking.model.TheaterTimeSlotModel;
import com.booking.repository.MovieRepository;
import com.booking.repository.MovieTimeRepository;
import com.booking.repository.PriceRepository;
import com.booking.repository.TheaterRepository;
import com.booking.repositoryimpl.MovieRepositoryImpl;
import com.booking.repositoryimpl.MovieTimeRepositoryImpl;
import com.booking.repositoryimpl.PriceRepositoryImpl;
import com.booking.repositoryimpl.TheaterRepositoryImpl;
import com.booking.services.ShowListMovieServices;
import com.booking.services.TheaterTimeSlotServices;
import com.booking.servicesimpl.ShowListMovieServicesImpl;
import com.booking.servicesimpl.TheaterTimeSlotServicesImpl;

public class AdminManagement {
	static Scanner scanner = new Scanner(System.in);
	public AdminManagement() {}
	public void adminInterface() {
		boolean transaction = true;
		while (transaction) {
			String function;
			boolean flag;
			System.out.println("==============================================");
			System.out.println("1.Movie || 2. User || 3.Ticket price || 4.Exit");
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
				ShowListMovieServices showListMovieServices = new ShowListMovieServicesImpl();
				TheaterRepository theaterRepository = new TheaterRepositoryImpl();
				MovieTimeRepository movieTimeRepository = new MovieTimeRepositoryImpl();
				TheaterTimeSlotServices theaterTimeSlotServices = new TheaterTimeSlotServicesImpl();
				MovieRepository movieRepository = new MovieRepositoryImpl();
				List<ShowListMovieModel> listMovie = new ArrayList<>();
				List<MovieTimeEntity> listMovieTime = new ArrayList<>();
				List<TheaterTimeSlotModel> listTheaterTimeSlot = new ArrayList<>();
				List<Integer> listTheaterName = new ArrayList<>();
				
				System.out.println("====================Movie========================");
				System.out.println("1.Add || 2. Delete || 3.Edit || 4. View || 5.Exit");
				String movieFunction;
				boolean flagMovie;
				do {
					System.out.print("Choose: ");
					movieFunction = scanner.next();
					String digit = "\\d";
					flagMovie = movieFunction.matches(digit);
					if (!flagMovie)
						System.out.println("You must enter a number!");
				} while (!flagMovie || Integer.parseInt(movieFunction) < 1 || Integer.parseInt(movieFunction) > 6);
				
				switch (Integer.parseInt(movieFunction)) {
				case 1:
					String movieName;
					String movieDay;
					int idTheater;
					int idTimeSlot;

					System.out.print("Input name of movie: ");
					scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
					movieName = scanner.nextLine();

					System.out.print("Input day (YYYY/MM/DD): ");
					movieDay = scanner.next();
					listTheaterTimeSlot = theaterTimeSlotServices.getEmptyTimeSlot(movieDay);
					listTheaterName = theaterTimeSlotServices.getAvailableTheater();

					System.out.print("Input compatible theater number: ");
					idTheater = scanner.nextInt();
					// listMovieTime = movieTimeRepository.findAll();
					listTheaterTimeSlot = theaterTimeSlotServices
							.getAvailableTimeSlot(listTheaterName.get(idTheater - 1));
					System.out.print("Input compatible time number: ");
					idTimeSlot = scanner.nextInt();
					// System.out.println(listTheaterTimeSlot.get(idTimeSlot-1).getIdTimeSlot());
					movieRepository.addMovie(movieDay, idTheater, movieName,
							listTheaterTimeSlot.get(idTimeSlot - 1).getIdTimeSlot());
					break;
				case 2:
					int idMovie;
					listMovie = showListMovieServices.showListMovie();
					System.out.println("Input compatible number to delete: ");
					idMovie = scanner.nextInt();
					movieRepository.deleteMovie(listMovie.get(idMovie-1).getIdMovie());
					break;
				case 3:
					break;
				case 4:
					showListMovieServices.showListMovie();
					break;
				case 5:
					break;
				}
				break;
			case 2:
				break;
			case 3:
				PriceRepository priceRepository = new PriceRepositoryImpl();
				System.out.println("====================Price=========================");
				System.out.println("1.Add || 2. Delete || 3.Edit || 4. Apply || 5.Exit");
				int priceFunction = scanner.nextInt();
				switch (priceFunction) {
				case 1:
					List<TheaterEntity> listTheater = new ArrayList<>();
					priceRepository.findAll();
					for (int i = 1; i <= listTheater.size(); i++) {
						System.out.println(i + ". Theater: " + listTheater.get(i - 1).getTheaterName() + " Seat row: "
								+ listTheater.get(i - 1).getRowQuant() + " Seat col: "
								+ listTheater.get(i - 1).getColQuant());
					}
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					break;
				case 5:
					break;
				}
				break;
			case 4:
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
