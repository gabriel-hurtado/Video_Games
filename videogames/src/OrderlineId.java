// default package
// Generated 4 avr. 2017 18:57:40 by Hibernate Tools 5.1.0.Alpha1

/**
 * OrderlineId generated by hbm2java
 */
public class OrderlineId implements java.io.Serializable {

	private int id;
	private int orderId;
	private int videogame;
	private Integer quantity;

	public OrderlineId() {
	}

	public OrderlineId(int id, int orderId, int videogame) {
		this.id = id;
		this.orderId = orderId;
		this.videogame = videogame;
	}

	public OrderlineId(int id, int orderId, int videogame, Integer quantity) {
		this.id = id;
		this.orderId = orderId;
		this.videogame = videogame;
		this.quantity = quantity;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOrderId() {
		return this.orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getVideogame() {
		return this.videogame;
	}

	public void setVideogame(int videogame) {
		this.videogame = videogame;
	}

	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof OrderlineId))
			return false;
		OrderlineId castOther = (OrderlineId) other;

		return (this.getId() == castOther.getId()) && (this.getOrderId() == castOther.getOrderId())
				&& (this.getVideogame() == castOther.getVideogame())
				&& ((this.getQuantity() == castOther.getQuantity()) || (this.getQuantity() != null
						&& castOther.getQuantity() != null && this.getQuantity().equals(castOther.getQuantity())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getId();
		result = 37 * result + this.getOrderId();
		result = 37 * result + this.getVideogame();
		result = 37 * result + (getQuantity() == null ? 0 : this.getQuantity().hashCode());
		return result;
	}

}
