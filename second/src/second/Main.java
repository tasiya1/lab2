package second;

import second.Train;
import java.util.Scanner;

public class Main {	
	
	static int ByDestination(String destination, int amount, Train[] arr) {
		System.out.print("\n\n\tПоїзди із заданим пунктом призначення:");

		int flag = 0; //маркер наявности поїздів
		for (int i = 0; i < amount; i++) {
			if (arr[i].getDestination().equals(destination)) {
				arr[i].printTrain();
				flag = 1;
			}
		}
		if (flag == 1) 
			return 1;

		System.out.print("\n\n\t\tНе знайдено.");
		return 0;
	}
	
	static void ByDeparture(int departure, String destination, int amount, Train[] arr) {
		System.out.print("\n\n\tПоїзди із заданим пунктом призначення та які вирушають після " + departure + "-ї години:");

		int flag = 0;
		for (int i = 0; i < amount; i++) {
			if (arr[i].getDestination().equals(destination) && (arr[i].getDeparture() > departure)) {
				arr[i].printTrain();
				flag = 1;
			}
		}
		if (flag == 0) 
			System.out.print("\n\n\t\tНе знайдено.");
	}
	
	static void ByGeneralSeats(String destination, int amount, Train[] arr) {
		System.out.print("\n\n\tПоїзди із заданим пунктом призначення та які маєть загальні місця:");

		int flag = 0;

		for (int i = 0; i < amount; i++) {
			if (arr[i].getDestination().equals(destination) && (arr[i].getGeneral() != 0)) {
				arr[i].printTrain();
				flag = 1;
			}
		}
		if (flag == 0) 
			System.out.print("\n\n\t\tНе знайдено.");
	}
	
	//----------------------------------------------------------------------------------
	
	static void Filter(int amount, Train [] array) {
		
		Scanner sc = new Scanner(System.in);
		
		String inp_dest = ""; //заданий пункт призначення
		int inp_depart = 0; //задана година
		int op1, op2, op3;
		
		System.out.print("\n\tПоказати поїзди за заданим критерієм: 1 - так, 0 - ні.\n\n\tЗа заданим маршрутом->"); op1 = sc.nextInt();
		System.out.print("\n\tЗа заданим маршрутом та після заданої години->"); op2 = sc.nextInt();
		System.out.print("\n\tЗа заданим маршрутом та із загальними місцями->"); op3 = sc.nextInt();
		sc.nextLine(); //забирання зайвого \n
		
		if (op1 == 1) {
			System.out.print("\n\n\tПункт призначення-> ");
			inp_dest = sc.nextLine();
		}
		if (op2 == 1) {
			System.out.print("\n\tГодина-> ");
			inp_depart = sc.nextInt();
		}
		
		sc.close(); //закриваю сканер
		
		if (op1 == 1)
			if (ByDestination(inp_dest, amount, array) == 0)
				return; //якщо немає потягів з заданим маршрутом, 
						//то наступні умови повністю не виконаються
		if (op2 == 1)
			ByDeparture(inp_depart, inp_dest, amount, array);
		if (op3 == 1)
			ByGeneralSeats(inp_dest, amount, array);
		
	}
	
	//----------------------------------------------------------------------------------

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int amount;
		Scanner sc = new Scanner(System.in);

		System.out.print("\n\tВведіть кількість поїздів: ");
		amount = sc.nextInt();
		Train [] array = new Train [amount];
		sc.nextLine(); //забираю зайвий \n
		
		/*буфери*/
		String _dest;
		int _num, _dep = 0, _gen, _coupe, _pl, _luxe;
		
		System.out.println("\n\tВведіть дані:");
		//sc.reset();
		for (int i = 1; i <= amount; i++) {
			System.out.println("\n\t" + i + ".");
			System.out.print("\tПункт призначення-> ");
			_dest = sc.nextLine();
			System.out.print("\n\tНомер поїзда-> ");
			_num = sc.nextInt();
			while (true) { //захист від неправильно введеного часу
				System.out.print("\n\tГодина відправлення-> ");
				_dep = sc.nextInt();
				if (_dep >=0 && _dep <24)
					break;
				else System.out.print("\n\tНеправильно введений час. Спробуйте знову.\n\tГодина відправлення-> ");
			}
			System.out.print("\n\tКількість місць:\n\tЗагальних-> ");
			_gen = sc.nextInt();
			System.out.print("\n\tКупе-> ");
			_coupe = sc.nextInt();
			System.out.print("\n\tПлацкарт-> ");
			_pl = sc.nextInt();
			System.out.print("\n\tЛюкс-> ");
			_luxe = sc.nextInt();
			sc.nextLine();
			
			array[i-1] = new Train(_dest, _num, _dep, _gen, _coupe, _pl, _luxe);
		}

		Filter(amount, array);
		
		sc.close();//закриваю сканер
	}
}
