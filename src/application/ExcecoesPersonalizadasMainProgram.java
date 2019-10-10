package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservas;
import model.exceptions.DomainException;

/**
 * Exemplo Didático
 * 
 * Lógica Boa más ainda não tão Boa pois mesmo tendo delegado parte da validação
 * para a classe responsável ou seja Resevas ainda há regras implementadas no
 * programa principal.
 * 
 * @author julian
 *
 */
public class ExcecoesPersonalizadasMainProgram {

	public static void main(String[] args) {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);

		try {
			System.out.print("Número do Quarto:");
			Integer pNumeroQuarto = sc.nextInt();

			System.out.print("data do Check-in: (dd/MM/yyyy) ");
			Date pDataCheckIn = sdf.parse(sc.next());

			System.out.print("data do Check-out: (dd/MM/yyyy) ");
			Date pDataCheckOut = sdf.parse(sc.next());

			Reservas reservas = new Reservas(pNumeroQuarto, pDataCheckIn, pDataCheckOut);
			System.out.println("Reserva: " + reservas);

			System.out.println();
			System.out.println("Entre com as Datas para atualizar a Reserva:");
			System.out.print("data do Check-in: (dd/MM/yyyy) ");
			pDataCheckIn = sdf.parse(sc.next());

			System.out.print("data do Check-out: (dd/MM/yyyy) ");
			pDataCheckOut = sdf.parse(sc.next());

			reservas.atualizarDatas(pDataCheckIn, pDataCheckOut);

			System.out.println("Reserva: " + reservas);
			
		} catch (ParseException e) {
			System.out.println("Formato de Data inválido!");
			e.printStackTrace();
		} catch (DomainException e) {
			System.out.println("Error na Reserva: " + e.getMessage());
		} catch (RuntimeException e) {
			System.out.println("ERRO INESPERADO");
		} 

		sc.close();

	}

}
