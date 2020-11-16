/**
 * 
 */
package in.thirumal.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.discovery.shared.Application;
import com.netflix.discovery.shared.Applications;
import com.netflix.eureka.EurekaServerContextHolder;
import com.netflix.eureka.registry.PeerAwareInstanceRegistry;

import in.thirumal.model.ShutdownResource;

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
	
	@GetMapping("/{app}")
	public Application listAppInstance(@PathVariable(value = "app") String app) throws Exception {
		PeerAwareInstanceRegistry registry = EurekaServerContextHolder.getInstance().getServerContext().getRegistry();
	    Application application = registry.getApplications().getRegisteredApplications(app);
	    if (application == null) {
	    	return null;
	    }
	    application.getInstances().stream().filter(a->a.getAppName().equalsIgnoreCase(app)).forEach(instance -> 
	            System.out.println(instance.getAppName() + " (" + instance.getInstanceId() + ") : "));
	    return application;
	}
	
	@PostMapping("/shutdown/{app}/{ip}/{port}")
	public ShutdownResource shutdownInstance(@PathVariable(value = "app") String app, @PathVariable(value= "ip") String ip, @PathVariable(value="port") int port) {
		return new ShutdownResource();
	}
	
}
