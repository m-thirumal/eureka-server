/**
 * 
 */
package in.thirumal.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.discovery.shared.Applications;
import com.netflix.eureka.EurekaServerContextHolder;
import com.netflix.eureka.registry.PeerAwareInstanceRegistry;

/**
 * @author Thirumal
 * @since 26/09/2019
 * @version 1.0
 */
@RestController
@RequestMapping("/eureka-instance")
public class InstanceController {

	@GetMapping()
	public Applications listAllInstance() {
		PeerAwareInstanceRegistry registry = EurekaServerContextHolder.getInstance().getServerContext().getRegistry();
	    Applications applications = registry.getApplications();

	    applications.getRegisteredApplications().forEach(registeredApplication -> 
	        registeredApplication.getInstances().forEach(instance -> 
	            System.out.println(instance.getAppName() + " (" + instance.getInstanceId() + ") : ")));
	    return applications;
	}
	
}
