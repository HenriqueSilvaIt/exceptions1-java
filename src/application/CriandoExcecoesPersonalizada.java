package application;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;
public class CriandoExcecoesPersonalizada {

	public static void main(String[] args) throws ParseException {// throws quer dizer que
		// o método main n tem que tratar essa exceção
		// ai tem 2 opções ou vocÊ trata a execeção usando o try catch
		// ou você coloca a palavra trhows ParseExceptions
		// TODO Auto-generated method stub
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Room number: ");
		Integer number = sc.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy): ");
		Date checkIn = data.parse(sc.next());
		System.out.print("Check-out date (dd/MM/yyyy): ");
		Date checkOut = data.parse(sc.next());
		if (!checkOut.after(checkIn)) {
			System.out.println("Erro in reservation: Check-out date must be after check-in date");
		}
		else {
			
		Reservation reserva = new Reservation(number, checkIn, checkOut);
		System.out.print("Reservation: " + reserva);
	
		System.out.println();
		System.out.println("Enter data to update the reservation: ");
		System.out.print("Check-in date (dd/MM/yyyy): ");
		checkIn = data.parse(sc.next());
		System.out.print("Check-out date (dd/MM/yyyy): ");
		checkOut = data.parse(sc.next());
		reserva.updateDates(checkIn, checkOut);
	
		
		Date now = new Date();
		if (checkIn.before(now) || checkOut.before(now)) {
			System.out.println("Error in reservation: Reservation dates for update must be future dates");
		}
		else if (!checkOut.after(checkIn)) {
			System.out.println("Erro in reservation: Check-out date must be after check-in date");
		} else {
			reserva.updateDates(checkIn, checkOut);
			System.out.print("Reservation: " + reserva);
		}
		}
		sc.close();
}
}
