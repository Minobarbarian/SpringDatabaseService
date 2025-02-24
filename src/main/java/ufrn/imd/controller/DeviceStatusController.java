package ufrn.imd.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ufrn.imd.model.DeviceStatus;
import ufrn.imd.service.DeviceStatusService;

@RestController
@RequestMapping("/device-status/devices")
public class DeviceStatusController {
	@Autowired
	private final DeviceStatusService deviceStatusService;

	public DeviceStatusController(DeviceStatusService deviceStatusService) {
		this.deviceStatusService = deviceStatusService;	
	}
	
	//Create
	@PostMapping
	public ResponseEntity<DeviceStatus> createDevice(@RequestParam boolean lightStatus, @RequestParam double thermostat) {
		DeviceStatus created = deviceStatusService.createDevice(lightStatus, thermostat);
        return ResponseEntity.ok(created);
    }
	
	//Read
	@GetMapping
	public ResponseEntity<List<DeviceStatus>> getAllDevicesStatuses() {
        List<DeviceStatus> devices = deviceStatusService.getAllDeviceStatuses();
        return ResponseEntity.ok(devices);
    }
	
	//Read
	@GetMapping("/{id}")
    public ResponseEntity<DeviceStatus> getDeviceStatusById(@PathVariable Long id) {
        Optional<DeviceStatus> device = deviceStatusService.getDeviceStatusById(id);
        return device.map(ResponseEntity::ok)
                       .orElseGet(() -> ResponseEntity.notFound().build());
    }
	
	//Update
	@PutMapping("/{id}")
    public ResponseEntity<DeviceStatus> updateDeviceStatus(@PathVariable Long id, @RequestParam boolean lightStatus, @RequestParam double thermostat) {
        Optional<DeviceStatus> updated = deviceStatusService.updateDeviceStatus(id, lightStatus, thermostat);
        return updated.map(ResponseEntity::ok)
                      .orElseGet(() -> ResponseEntity.notFound().build());
    }
	
	//Delete
	@DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDevice(@PathVariable Long id) {
		deviceStatusService.deleteDevice(id);
        return ResponseEntity.noContent().build();
    }
}
