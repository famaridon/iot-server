package com.famaridon.iot.server.rest.v1.mapper;

import com.famaridon.iot.server.domain.entities.Device;
import com.famaridon.iot.server.domain.entities.User;
import com.famaridon.iot.server.domain.entities.Value;
import com.famaridon.iot.server.rest.v1.dto.DeviceDto;
import com.famaridon.iot.server.rest.v1.dto.UserDto;
import com.famaridon.iot.server.rest.v1.dto.ValueDto;
import org.mapstruct.Mapper;

/**
 * Created by famaridon on 25/08/2016.
 */
@Mapper
public interface DtoMapper
{
	UserDto userToUserDto(User user);
	
	DeviceDto deviceToDeviceDto(Device device);
	
	ValueDto valueToValueDto(Value value);
	
}
