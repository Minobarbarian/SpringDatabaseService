package ufrn.imd.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class DeviceStatus {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private boolean lightStatus;
	private double thermostat;
	
	public DeviceStatus() {}
	
	public DeviceStatus(boolean lightStatus, double thermostat) {
		this.lightStatus = lightStatus;
		this.thermostat = thermostat;
	}

	public boolean isLightStatus() {
		return lightStatus;
	}

	public double getThermostat() {
		return thermostat;
	}

	public void setLightStatus(boolean lightStatus) {
		this.lightStatus = lightStatus;
	}

	public void setThermostat(double thermostat) {
		this.thermostat = thermostat;
	}
}