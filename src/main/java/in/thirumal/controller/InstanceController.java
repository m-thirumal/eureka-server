/**
 * 
 */
package in.thirumal.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.shared.Application;
import com.netflix.discovery.shared.Applications;
import com.netflix.eureka.EurekaServerContextHolder;
import com.netflix.eureka.registry.PeerAwareInstanceRegistry;

import in.thirumal.model.ShutdownResource;
import in.thirumal.service.InstanceService;

/**
 * @author Thirumal
 * @since 26/09/2019
 * @version 1.0
 */
@RestController
@RequestMapping("/eureka-instance")
public class InstanceController {

	private InstanceService instanceService;
	
	public InstanceController(InstanceService instanceService) {
		super();
		this.instanceService = instanceService;
	}

	@GetMapping()
	public Applications listAllInstance() {
		PeerAwareInstanceRegistry registry = EurekaServerContextHolder.getInstance().getServerContext().getRegistry();
	    Applications applications = registry.getApplications();

	    applications.getRegisteredApplications().forEach(registeredApplication -> 
	        registeredApplication.getInstances().forEach(instance -> 
	            System.out.println(instance.getAppName() + " (" + instance.getInstanceId() + ") : ")));
	    return applications;
	}
	
	@GetMapping("/{app}")
	public Application listAppInstance(@PathVariable String app) throws Exception {
		PeerAwareInstanceRegistry registry = EurekaServerContextHolder.getInstance().getServerContext().getRegistry();
	    Application application = registry.getApplications().getRegisteredApplications(app);
	    if (application == null) {
	    	return null;
	    }
	    application.getInstances().stream().filter(a->a.getAppName().equalsIgnoreCase(app)).forEach(instance -> 
	            System.out.println(instance.getAppName() + " (" + instance.getInstanceId() + ") : "));
	    return application;
	}
	
	@GetMapping("/instance/{instanceId}")
	public List<InstanceInfo> getInstance(@PathVariable String instanceId) throws Exception {
		PeerAwareInstanceRegistry registry = EurekaServerContextHolder.getInstance().getServerContext().getRegistry();
	    return registry.getInstancesById(instanceId);
	}
	
	@GetMapping("/shutdown/{instanceId}")
	public ShutdownResource shutdownInstance(@PathVariable String instanceId) {
		return instanceService.shutdowInstance(instanceId);
	}
	
}
