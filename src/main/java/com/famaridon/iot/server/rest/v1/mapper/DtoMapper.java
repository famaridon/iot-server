package com.famaridon.iot.server.rest.v1.mapper;

import com.famaridon.iot.server.domain.entities.User;
import com.famaridon.iot.server.rest.v1.dto.UserDto;
import org.mapstruct.Mapper;

/**
 * Created by famaridon on 25/08/2016.
 */
@Mapper
public interface DtoMapper
{
	UserDto userToUserDto(User user);
	
}
