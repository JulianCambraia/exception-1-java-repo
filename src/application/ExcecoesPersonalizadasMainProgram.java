package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservas;

/**
 * Lógica Muito-Ruim pois as regras estão no programa principal
 * @author julian
 *
 */
public class ExcecoesPersonalizadasMainProgram {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);

		System.out.print("Número do Quarto:");
		Integer pNumeroQuarto = sc.nextInt();

		System.out.print("data do Check-in: (dd/MM/yyyy) ");
		Date pDataCheckIn = sdf.parse(sc.next());

		System.out.print("data do Check-out: (dd/MM/yyyy) ");
		Date pDataCheckOut = sdf.parse(sc.next());

		if (!pDataCheckOut.after(pDataCheckIn)) {
			System.out.println("Erro na reserva de quarto, Data de saída deve ser após a Data de entrada");
		} else {
			Reservas reservas = new Reservas(pNumeroQuarto, pDataCheckIn, pDataCheckOut);
			System.out.println("Reserva: " + reservas);

			System.out.println();
			System.out.println("Entre com as Datas para atualizar a Reserva:");
			System.out.print("data do Check-in: (dd/MM/yyyy) ");
			pDataCheckIn = sdf.parse(sc.next());

			System.out.print("data do Check-out: (dd/MM/yyyy) ");
			pDataCheckOut = sdf.parse(sc.next());

			Date now = new Date();
			if (pDataCheckIn.before(now) || pDataCheckOut.before(now)) {
				System.out.println("Erro na reserva: As datas de reserva para atualização devem ser datas futuras.");
			} else if (!pDataCheckOut.after(pDataCheckIn)) {
				System.out.println("Erro na reserva de quarto, Data de saída deve ser após a Data de entrada");
			} else {
				reservas.atualizarDatas(pDataCheckIn, pDataCheckOut);
				System.out.println("Reserva: " + reservas);
			}
		}

		sc.close();

	}

}
