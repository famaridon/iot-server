package com.famaridon.iot.server.domain.repositories;

import com.famaridon.iot.server.domain.entities.Value;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.FirstResult;
import org.apache.deltaspike.data.api.MaxResults;
import org.apache.deltaspike.data.api.Repository;

import java.util.List;

/**
 * Created by famaridon on 23/05/2016.
 */
@Repository
public interface ValuesRepository extends EntityRepository<Value, String>
{
	List<Value> findAll(@FirstResult int start, @MaxResults int pageSize);
}
