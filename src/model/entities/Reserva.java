package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	private Integer nrQuarto;
	private Date entrada;
	private Date saida;

	Reserva() {
	}

	public Reserva(Integer nrQuarto, Date entrada, Date saida) {
		this.nrQuarto = nrQuarto;
		this.entrada = entrada;
		this.saida = saida;
	}

	public Integer getNrQuarto() {
		return nrQuarto;
	}

	public void setNrQuarto(Integer nrQuarto) {
		this.nrQuarto = nrQuarto;
	}

	public Date getEntrada() {
		return entrada;
	}

	public Date getSaida() {
		return saida;
	}

	public long duracao() {
		long diff = saida.getTime() - entrada.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);

	}

	public String attDatas(Date entrada, Date saida) {
		Date atual = new Date();
		if (entrada.before(atual) || saida.before(atual)) {
			return "Datas de reserva tem que ser datas futuras!";
		}
		if (entrada.after(saida)) {
			return "Data de entrada não pode ser maior que a data de saida!";
		}
		this.entrada = entrada;
		this.saida = saida;
		return null; // Informa que não deu nenhum erro.

	}

	public String toString() {
		return "Nr Quarto      : " + nrQuarto + "\n" + "Data de entrada: " + sdf.format(entrada) + "\n"
				+ "Data de saída  : " + sdf.format(saida) + "\n" + "Nr de diárias  : " + duracao() + " noites.";
	}
}
