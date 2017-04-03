package beans;
import services.ConsoleType;
import java.io.Serializable;

@SuppressWarnings("serial")
public class VideoGame implements Serializable {

	private int id; //pkey uuid
	private String title;
	private double price;
	private String buyer;
	private ConsoleType console_type;
	
	/**
	 * @param id
	 * @param title
	 * @param price
	 * @param console_types
	 */
	public VideoGame(int id, String title, double price, ConsoleType console_type) {
		super();
		this.id = id;
		this.title = title;
		this.console_type= console_type;
		this.price = price;
	} 

	// accessors & modifiers
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
