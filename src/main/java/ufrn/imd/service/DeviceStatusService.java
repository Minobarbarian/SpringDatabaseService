package ufrn.imd.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ufrn.imd.model.DeviceStatus;
import ufrn.imd.repository.DeviceStatusRepository;

@Service
public class DeviceStatusService {
	
	@Autowired
	private final DeviceStatusRepository deviceStatusRepository;
	
    public DeviceStatusService(DeviceStatusRepository deviceStatusRepository) {
        this.deviceStatusRepository = deviceStatusRepository;
    }
	
    //Create
	public DeviceStatus createDevice(boolean lightStatus, Double thermostat) {
        return deviceStatusRepository.save(new DeviceStatus(lightStatus, thermostat));
    }
	
	//Read
	public List<DeviceStatus> getAllDeviceStatuses() {
        return deviceStatusRepository.findAll();
    }
	
	//Read
	public Optional<DeviceStatus> getDeviceStatusById(Long id) {
		return deviceStatusRepository.findById(id);
	}
	
	//Update
	public Optional<DeviceStatus> updateDeviceStatus(Long id, boolean lightStatus, Double thermostat) {
        return deviceStatusRepository.findById(id).map(device -> {
        	device.setLightStatus(lightStatus);
        	device.setThermostat(thermostat);
            return deviceStatusRepository.save(device);
        });
    }
	
	//Delete
	public void deleteDevice(Long id) {
		deviceStatusRepository.deleteById(id);
	}
}