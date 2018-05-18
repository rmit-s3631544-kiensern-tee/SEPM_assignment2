package main.java.view.menu;

import java.io.IOException;
import java.util.Calendar;

import asg.cliche.Command;
import asg.cliche.ShellFactory;
import main.java.controller.ConsoleController;
import main.java.controller.ConsoleController.Menu;
import main.java.model.BookingManager;
import main.java.model.object.Movie;
import main.java.model.object.Seat;
import main.java.model.object.Session;
import main.java.view.ConsoleView;

public class BookingSeatSelectionMenu extends ConsoleView {
	public BookingSeatSelectionMenu() {
		DrawView();
	}
	
	public void DrawView() {
		DrawTitle("New Booking");
		DrawLineBreak(1);
		System.out.println("Select seats:");
		DrawSeatMap(BookingManager.GetInstance().GetSelectedSession());
		DrawLineBreak(1);
		if (BookingManager.GetInstance().GetPendingBookingSeats() != null && BookingManager.GetInstance().GetPendingBookingSeats().size() != 0) {
			String seatsSelected = "Seats Selected: ";
			for (Integer seat : BookingManager.GetInstance().GetPendingBookingSeats()) {
				if (seat < 5) {
					seatsSelected += "A"+(seat+1)+" ";
				}
				else if (seat < 10) {
					seatsSelected += "B"+((seat+1)-5)+" ";
				}
				else if (seat < 15) {
					seatsSelected += "C"+((seat+1)-10)+" ";
				}
				else if (seat < 20) {
					seatsSelected += "D"+((seat+1)-15)+" ";
				} 
			}
			System.out.println(seatsSelected);
		}
		System.out.println("Seats Selected: "+BookingManager.GetInstance().GetPendingBookingSeatString());
		DrawLineBreak(1);
		System.out.println("Functions");
		System.out.println("(s <A-D> <1-5>) Toggle seat");
		if (BookingManager.GetInstance().GetPendingBookingSeats() != null && BookingManager.GetInstance().GetPendingBookingSeats().size() != 0) {
			System.out.println("(c) Continue");
		}
		System.out.println("(m) Main Menu");
		DrawLineBreak(1);
		
		try {
			ShellFactory.createConsoleShell("jMoSS:", "", this).commandLoop();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void DrawSeatMap(Session s0) {
		int iterationCount = 0;
		int totalRow = 0;
		int currentRow = 0;
		System.out.println("    1 2 3 4 5");
		String lineString = "A | ";
		for (Seat seat : s0.getSessionSeats()) {
			if (BookingManager.GetInstance().IsSeatBooked(s0.getSessionId(), iterationCount,true)) {
				lineString += "Ø ";
			} else {
				lineString += "O ";
			}
			
			if (currentRow == 4) {
				System.out.println(lineString+"|");
				switch (totalRow) {
					case 0: {
						lineString = "B | ";
						break;
					}
					case 1: {
						lineString = "C | ";
						break;
					}
					case 2: {
						lineString = "D | ";
						break;
					}
				}
				currentRow=0;
				totalRow++;
			} else {
				currentRow++;
			}
			
			iterationCount++;
		}
		//BookingManager.GetInstance().IsSeatBooked(sessionId, seatId)
	}
	
	@Command(name="seat", abbrev="s") // List,
	public void seatToggle(String row, int seat) {
		if (seat < 1 || seat > 5) {
			DrawAlert("Invalid seat number: "+seat);
			return;
		}
		
		String lowercaseRow = row.toLowerCase();
		
		int seatId = 0;
		if (lowercaseRow.equals("a")) {
			seatId = seat-1;
		}
		else if (lowercaseRow.equals("b")) {
			seatId = (seat-1)+5;
		}
		else if (lowercaseRow.equals("c")) {
			seatId = (seat-1)+10;	
		}
		else if (lowercaseRow.equals("d")) {
			seatId = (seat-1)+15;
		} 
		else {
			DrawAlert("Invalid row: "+row);
			return;
		}
		
		if (BookingManager.GetInstance().IsSeatBooked(BookingManager.GetInstance().GetSelectedSession().getSessionId(),seatId,false)) {
			DrawAlert("Seat not available for booking.");
		} else {
			if (BookingManager.GetInstance().IsSeatBooked(BookingManager.GetInstance().GetSelectedSession().getSessionId(),seatId,true)) {
				BookingManager.GetInstance().RemovePendingBookingSeats(seatId);
			} else {
				BookingManager.GetInstance().AddPendingBookingSeats(seatId);
			}
			
			// Redraw View
			DrawView();
		}
	}
	
	@Command(name="continue", abbrev="c") // Back,
	public void continueBooking() {
		if (BookingManager.GetInstance().GetPendingBookingSeats() != null && BookingManager.GetInstance().GetPendingBookingSeats().size() == 0) {
			System.out.println("You must select seats first!");
		}
		DrawLineBreak(1);
        ConsoleController.GotoMenu(Menu.BookingPaymentMenu);
    }
	
	@Command(name="menu", abbrev="m") // Back,
	public void back() {
		DrawLineBreak(1);
        ConsoleController.GotoMenu(Menu.MainMenu);
    }
}
