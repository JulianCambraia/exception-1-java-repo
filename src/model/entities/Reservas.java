package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.sql.rowset.spi.TransactionalWriter;

import model.exceptions.DomainException;

public class Reservas {
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private Integer numeroQuarto;
	private Date checkIn;
	private Date checkOut;

	public Reservas() {
		super();
	}

	public Reservas(Integer numeroQuarto, Date checkIn, Date checkOut) {
		super();
		if (!checkOut.after(checkIn)) {
			throw new DomainException("Data de saída deve ser posterior a Data de entrada");
		}
		this.numeroQuarto = numeroQuarto;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getNumeroQuarto() {
		return numeroQuarto;
	}

	public void setNumeroQuarto(Integer numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public Long duracaoEmDias() {
		Long diff = checkOut.getTime() - checkIn.getTime(); // devolve a quantidade em milessegundos da data;
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS); // converte o milessegundos em dias.
	}

	public void atualizarDatas(Date checkIn, Date checkOut) {
		Date now = new Date();
		if (checkIn.before(now) || checkOut.before(now)) {
			throw new DomainException("As datas para atualização devem ser datas futuras.");
		}

		if (!checkOut.after(checkIn)) {
			throw new DomainException("Data de saída deve ser posterior a Data de entrada");
		}

		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	@Override
	public String toString() {
		return "Quarto " + numeroQuarto + ", check-in: " + sdf.format(checkIn) + ", check-out: " + sdf.format(checkOut)
				+ ", " + duracaoEmDias() + " noites";
	}
}
