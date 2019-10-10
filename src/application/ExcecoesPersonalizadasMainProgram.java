package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservas;

/**
 * Exemplo Didático
 * 
 * Lógica Ruim más ainda não tão Boa pois mesmo tendo delegado parte da
 * validação para a classe responsável ou seja Resevas ainda há regras
 * implementadas no programa principal.
 * 
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

			String error = reservas.atualizarDatas(pDataCheckIn, pDataCheckOut);
			if (error != null) {
				System.out.println("Erro ao incluir reserva: " + error);
			} else {
				System.out.println("Reserva: " + reservas);
			}
		}

		sc.close();

	}

}
