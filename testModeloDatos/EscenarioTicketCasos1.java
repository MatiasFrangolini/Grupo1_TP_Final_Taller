package testModeloDatos;

import static org.junit.Assert.*;

import org.junit.Test;

import modeloDatos.Ticket;

public class EscenarioTicketCasos1 {

	private Ticket t = new Ticket("HOME_OFFICE",1000,"JORNADA_MEDIA","JUNIOR","EXP_NADA", "PRIMARIOS");
	
	
	
	public Ticket getTicket() {
		return t;
	}

}
