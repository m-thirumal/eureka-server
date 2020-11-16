/**
 * 
 */
package in.thirumal.service;

import in.thirumal.model.ShutdownResource;

/**
 * @author Thirumal
 *
 */
public interface InstanceService {

	ShutdownResource shutdowInstance(String instanceId);
}
