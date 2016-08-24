package com.famaridon.iot.server.domain.repositories;

import com.famaridon.iot.server.domain.entities.Device;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

/**
 * Created by famaridon on 23/05/2016.
 */
@Repository
public interface DevicesRepository extends EntityRepository<Device, String>
{
	
}
