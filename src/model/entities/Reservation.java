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
	public void updateDates(Date checkIn, Date checkOut) {
		this.checkIn = checkIn;
		this.checkOut = checkOut;
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
