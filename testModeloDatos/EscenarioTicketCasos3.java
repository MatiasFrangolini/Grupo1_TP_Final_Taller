package testModeloDatos;

import static org.junit.Assert.*;

import org.junit.Test;

import modeloDatos.Ticket;
import util.Constantes;

public class EscenarioTicketCasos3 {

	private Ticket t = new Ticket(Constantes.INDISTINTO,5000, Constantes.JORNADA_EXTENDIDA,Constantes.MANAGMENT,Constantes.EXP_MUCHA, Constantes.TERCIARIOS);
	
	
	
	public Ticket getTicket() {
		return t;
	}
}
