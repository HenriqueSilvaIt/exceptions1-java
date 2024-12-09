package application;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;
public class CriandoExcecoesPersonalizada {

	public static void main(String[] args) {// throws quer dizer que
		// o método main n tem que tratar essa exceção
		// ai tem 2 opções ou vocÊ trata a execeção usando o try catch
		// ou você coloca a palavra trhows ParseExceptions
		// TODO Auto-generated method stub
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.print("Room number: ");
			Integer number = sc.nextInt();
			System.out.print("Check-in date (dd/MM/yyyy): ");
			Date checkIn = data.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			Date checkOut = data.parse(sc.next());
		
				
			Reservation reserva = new Reservation(number, checkIn, checkOut);
			System.out.print("Reservation: " + reserva);
		
			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = data.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOut = data.parse(sc.next());
			
			reserva.updateDates(checkIn, checkOut);
			System.out.println("Reservation: " + reserva);
		}
		catch (ParseException e) {
			System.out.println("Invalid date format");
		}
		catch (DomainException e) { 
			System.out.println("Error in reservation: " + e.getMessage());
		}
		catch (RuntimeException e) { // trata qualquer exceção que n foi mapeada 
			System.out.println("Unexpected error");
		}
	
		
		sc.close();
}
}
