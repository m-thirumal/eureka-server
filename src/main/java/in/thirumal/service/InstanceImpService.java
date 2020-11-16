/**
 * 
 */
package in.thirumal.service;

import org.springframework.stereotype.Service;

import in.thirumal.model.ShutdownResource;

/**
 * @author Thirumal
 *
 */
@Service
public class InstanceImpService implements InstanceService {

	@Override
	public ShutdownResource shutdowInstance(String instanceId) {
		System.out.println("Instance Id: " + instanceId);
		
		return new ShutdownResource();
	}

}
