package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import model.entities.Reserva;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Entre com os dados solicitados");
		System.out.println("------------------------------------------");
		System.out.print("Número do quarto            : ");
		int nrQuarto = sc.nextInt();
		System.out.print("Data de entrada(dd/MM/yyyy) : ");
		Date dataEnt = sdf.parse(sc.next());
		System.out.print("Data de saída(dd/MM/yyyy)   : ");
		Date dataSai = sdf.parse(sc.next());
		System.out.println("========================================");

		if (!dataSai.after(dataEnt)) {
			System.out.println("Erro de reserva...");
			System.out.println("Data de saída não pode ser menor que data de entrada");
		} else {
			Reserva res = new Reserva(nrQuarto, dataEnt, dataSai);
			System.out.println("Reservas: ");
			System.out.println("--------");
			System.out.println(res.toString());
			System.out.println("===========================================");

			System.out.println("Entre com os dados para atualizar a reserva");
			System.out.print("Data de entrada(dd/MM/yyyy) : ");
			dataEnt = sdf.parse(sc.next());
			System.out.print("Data de saída(dd/MM/yyyy)   : ");
			dataSai = sdf.parse(sc.next());

			System.out.println("===========================================");
			System.out.println("Reservas: ");
			System.out.println("--------");

			String error = res.attDatas(dataEnt, dataSai);
			if (error != null) {
				System.out.println("Erro de reserva...");
				System.out.println(error);

			} else {
				System.out.println(res.toString());
			}
		}
		System.out.println("===========================================");

		sc.close();

	}
}
