package second;

public class Train {
	public String destination;
	public int number;
	public int departure;
	public int general;
	public int coupe;
	public int plazkart;
	public int luxe;
	
	
	//конструктор
	public Train(String destination, int number, int departure, int general, 
			int coupe, int plazkart, int luxe) {
		
		this.destination = destination;
		this.number = number;
		this.departure = departure;
		this.general = general;
		this.coupe = coupe;
		this.plazkart = plazkart;
		this.luxe = luxe;
		
	}
	
	//пампампарам
	public String getDestination() {return this.destination;}
	public int getNumber() {return this.number;}
	public int getDeparture() {return this.departure;}
	public int getGeneral() {return this.general;}
	public int getCoupe() {return this.coupe;}
	public int getPlazkart() {return this.plazkart;}
	public int getLuxe() {return this.luxe;}

	public void printTrain() {
		System.out.print("\n\t------------------------------------------------------");
		System.out.print("\n\tПункт призначення: " + this.destination);
		System.out.print("\n\tНомер поїзда: " + this.number);
		System.out.print("\n\tГодина відправлення: " + this.departure);
		System.out.print("\n\tКількість місць:\n\t  Загальних: " + this.general);
		System.out.print("\n\t  Купе: " + this.coupe);
		System.out.print("\n\t  Плацкарт: " + this.plazkart);
		System.out.print("\n\t  Люкс: " + this.luxe);
	}

}
