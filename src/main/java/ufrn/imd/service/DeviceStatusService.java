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
	public DeviceStatus createDevice(DeviceStatus deviceStatus) {
        return deviceStatusRepository.save(deviceStatus);
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
	public Optional<DeviceStatus> updateDeviceStatus(Long id, DeviceStatus deviceStatus) {
        return deviceStatusRepository.findById(id).map(device -> {
        	device.setLightStatus(deviceStatus.isLightStatus());
        	device.setThermostat(deviceStatus.getThermostat());
            return deviceStatusRepository.save(device);
        });
    }
	
	//Delete
	public void deleteDevice(Long id) {
		deviceStatusRepository.deleteById(id);
	}
}