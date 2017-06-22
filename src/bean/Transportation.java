package bean;
// Generated 2017-6-22 14:40:54 by Hibernate Tools 3.5.0.Final

import java.util.HashSet;
import java.util.Set;

/**
 * Transportation generated by hbm2java
 */
public class Transportation implements java.io.Serializable {

	private String transportationId;
	private String departure;
	private String destintion;
	private Set transportationManagements = new HashSet(0);

	public Transportation() {
	}

	public Transportation(String transportationId, String departure, String destintion) {
		this.transportationId = transportationId;
		this.departure = departure;
		this.destintion = destintion;
	}

	public Transportation(String transportationId, String departure, String destintion, Set transportationManagements) {
		this.transportationId = transportationId;
		this.departure = departure;
		this.destintion = destintion;
		this.transportationManagements = transportationManagements;
	}

	public String getTransportationId() {
		return this.transportationId;
	}

	public void setTransportationId(String transportationId) {
		this.transportationId = transportationId;
	}

	public String getDeparture() {
		return this.departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public String getDestintion() {
		return this.destintion;
	}

	public void setDestintion(String destintion) {
		this.destintion = destintion;
	}

	public Set getTransportationManagements() {
		return this.transportationManagements;
	}

	public void setTransportationManagements(Set transportationManagements) {
		this.transportationManagements = transportationManagements;
	}

}
