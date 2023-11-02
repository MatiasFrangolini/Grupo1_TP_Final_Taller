package testModeloDatos;

import static org.junit.Assert.*;

import org.junit.Test;

import modeloDatos.Ticket;

public class EscenarioTicketCasos2 {

	private Ticket t = new Ticket("PRESENCIAL",3000,"JORNADA_COMPLETA","SENIOR","EXP_MEDIA", "SECUNDARIOS");
	
	
	
	public Ticket getTicket() {
		return t;
	}
}
