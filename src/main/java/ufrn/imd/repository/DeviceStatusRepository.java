package ufrn.imd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ufrn.imd.model.DeviceStatus;

public interface DeviceStatusRepository extends JpaRepository<DeviceStatus, Long> {

}
