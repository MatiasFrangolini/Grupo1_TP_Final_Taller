package testModeloDatos;

import static org.junit.Assert.*;

import org.junit.Test;

import modeloDatos.Ticket;
import modeloNegocio.Agencia;
import util.Constantes;

public class EscenarioTicketCasos1 {

	private Ticket t = new Ticket(Constantes.HOME_OFFICE,1000, Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_NADA, Constantes.PRIMARIOS);
	
	
	
	public Ticket getTicket() {
		return t;
	}
	
	

}
