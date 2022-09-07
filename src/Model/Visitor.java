package Model;

import java.time.LocalDate;
import java.util.Date;
import java.util.PrimitiveIterator;

import Exceptions.DiscountCheckException;
import Exceptions.MaximumCapcityException;
import Utils.Discount;
import Utils.Gender;
import Utils.MyFileLogWriter;
import Utils.TicketType;
import View.Alerts;
import javafx.scene.control.Alert.AlertType;

public class Visitor extends Person{
	private static int idCounter = 1;

	private TicketType ticket;
	private Discount discount;

	public Visitor(String firstName, String lastName, LocalDate date, Gender gender
			, TicketType ticket, Discount discount) {
		super(idCounter++,firstName, lastName, date, gender, null);
		this.ticket = ticket;
		this.discount = discount;
	}

	public Visitor(int id) {
		super(id);
	}

	public TicketType getTicket() {
		return ticket;
	}

	public void setTicket(TicketType ticket) {
		this.ticket = ticket;
	}

	public Discount getDiscount() {
		return discount;
	}

	public void setDiscount(Discount discount) {
		this.discount = discount;
	}
	public static int getIdCounter() {
		return idCounter;
	}
	
	
	public static void setIdCounter(int idCounter) {
		Visitor.idCounter = idCounter;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName()+" Name: "+getFirstName()+" "+getLastName()+", TicketType: "+ticket;
	}

	public void moveVisitorToSection(Section newSection) {
		try {
			

		if(newSection == null || 
				(this.getSection().getMaxCapacity()/2) >= this.getSection().getVisitors().size()-1) {
			System.out.println(this.getSection().getMaxCapacity() +", " + (this.getSection().getVisitors().size()-1));
			throw new MaximumCapcityException();
		}

		this.getSection().getVisitors().remove(this);
		Section s= this.getSection();
		this.setSection(newSection);
		newSection.getVisitors().add(this);

		}
		catch (MaximumCapcityException e) {

			
		}
		
		
	}
	
	public double checkTicketPrice() {
		double perc = 100-getDiscount().getPercentage();
		double price = perc*ticket.getValue()/100;
		return price;
	}

	public String purchaseSnack(Snack s) {
		boolean isValid = true;
		if(s == null)
			isValid = false;
		
	if( s instanceof Drink) {
		
		Drink tmp = (Drink)s;
		 
		if(isValid && tmp.isSprinkel() && this.getSection().getBar().getSnacks().contains(tmp)){
			this.getSection().getBar().setProfit(this.getSection().getBar().getProfit() 
					+ s.getPrice()+5);
			this.getSection().getBar().getSnacks().remove(tmp);
			return "Visitor: "+this+" Purchased Drink: "+tmp;
			
			
		}
		
		else if(isValid && !tmp.isSprinkel() && this.getSection().getBar().getSnacks().contains(tmp)){
			this.getSection().getBar().setProfit(this.getSection().getBar().getProfit() 
					+ s.getPrice());
			this.getSection().getBar().getSnacks().remove(tmp);
			return "Visitor: "+this+" Purchased Drink: "+tmp;
			
			
		}
		else
		{	
		return "Visitor: "+this+" Did Not Purchased any DRINK";
		}
	}
	
	else if( s instanceof Food) {
		
		Food tmp = (Food)s;
		 
		if(isValid && tmp.isPlate() && this.getSection().getBar().getSnacks().contains(tmp)){
			this.getSection().getBar().setProfit(this.getSection().getBar().getProfit() 
					+ s.getPrice()+20);
			this.getSection().getBar().getSnacks().remove(tmp);
			return "Visitor: "+this+" Purchased Food: "+tmp;
			
			
		}
		
		else if(isValid && !tmp.isPlate() && this.getSection().getBar().getSnacks().contains(tmp)){
			this.getSection().getBar().setProfit(this.getSection().getBar().getProfit() 
					+ s.getPrice());
			this.getSection().getBar().getSnacks().remove(tmp);
			return "Visitor: "+this+" Purchased Food: "+tmp;
			
			
		}
		else {
			return "Visitor: "+this+" Did Not Purchased any FOOD";
		}
		
	}
	
		else
		{
			return "Visitor: "+this+" Did Not Purchased Snack";
		}
			
	}
	
	


}
