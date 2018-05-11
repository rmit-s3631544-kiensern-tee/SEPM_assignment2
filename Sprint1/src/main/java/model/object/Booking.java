package main.java.model.object;

public class Booking {
	private int bookingId;
	public int getBookingId() {
		return bookingId;
	}
	
	public void setBookingId(int id) {
		this.bookingId = id;
	}
	
	private String bookingName;
	public String getBookingName() {
		return bookingName;
	}
	
	private Movie movie;
	public Movie getMovie() {
		return movie;
	}
	
	private Session session;
	public Session getSession() {
		return session;
	}
	
	private Seat seats;
	public Seat getSeats() {
		return seats;
	}
	
	public static void main(String args[]) {
	boolean PaymentMade = true;
	String payment;
	Scanner scan = new Scanner(System.in);

	System.out.println("Payment confirmed?");
		  
         payment = scan.nextLine();
         if(payment.equals("yes"))
         PaymentMade = true;
         System.out.println("Payment successful");
         
         if(payment.equals("no"))
         {
         PaymentMade = false;
         System.out.println("Payment unsuccessful");
         }
	
   }
}
