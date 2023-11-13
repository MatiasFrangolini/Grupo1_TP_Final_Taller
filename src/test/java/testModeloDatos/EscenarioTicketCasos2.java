package testModeloDatos;

import static org.junit.Assert.*;

import org.junit.Test;

import modeloDatos.Ticket;
import util.Constantes;

public class EscenarioTicketCasos2 {

	private Ticket t = new Ticket(Constantes.PRESENCIAL,3000, Constantes.JORNADA_COMPLETA,Constantes.SENIOR,Constantes.EXP_MEDIA, Constantes.SECUNDARIOS);
	
	
	
	public Ticket getTicket() {
		return t;
	}
}
