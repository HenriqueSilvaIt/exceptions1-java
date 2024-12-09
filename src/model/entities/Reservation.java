package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	// ele fica como estático para não precisar ser instanciado
	// um novo SimpleDateFormat, para cada objeto que a classe Reservation tiver
	private static SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
	
	// Contrutores
	
	public Reservation() {
		
	}
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	// G
	public Integer getRoomNuber() {
		return roomNumber;
	}
	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}
	public Date getCheckIn(){
		return checkIn;
	}
	
	public Date getCheckOut() {
		return checkOut;
	}

	//Método operador
	
	// long é utilizado quando é numeros inteiros longo, como milisegundo e etc
	public long duration() {
		
		long diff = checkOut.getTime() - checkIn.getTime();// o .gettime devolve a qtd de milisegundo da data
		// convertendo esse milisegundo para dia
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS); // isso vai converter
		// esse valor diff que está em milisegundo para dia
	}
<<<<<<< HEAD
	public String updateDates(Date checkIn, Date checkOut) {
		
		Date now = new Date();
		if (checkIn.before(now) || checkOut.before(now)) {
			return "Error in reservation: Reservation dates for update must be future dates";
		}
		if (!checkOut.after(checkIn)) {
			return "Erro in reservation: Check-out date must be after check-in date";
		} 
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		return null;
=======
	public void updateDates(Date checkIn, Date checkOut) {
		this.checkIn = checkIn;
		this.checkOut = checkOut;
>>>>>>> 4358be2cbfe5c22173bd435dc0e92f621d69e081
	}
	
	@Override
	public String toString () {
		return "Room: " 
				+ roomNumber
				+ ", check-in: "
				+ data.format(checkIn)
				+ ", check-out: "
				+ data.format(checkOut)
				+ ", "
				+ duration() // esse método tem que colocar o ( parentese
				+ " nights";
	
	}
}	
