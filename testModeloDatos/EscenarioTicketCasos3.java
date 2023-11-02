package testModeloDatos;

import static org.junit.Assert.*;

import org.junit.Test;

import modeloDatos.Ticket;

public class EscenarioTicketCasos3 {

	private Ticket t = new Ticket("INDISTINTO",5000,"JORNADA_EXTENDIDA","MANAGMENT","EXP_MUCHA", "TERCIARIOS");
	
	
	
	public Ticket getTicket() {
		return t;
	}
}
