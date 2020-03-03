/**
 * 
 */
package in.thirumal.event;

import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceRegisteredEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.netflix.discovery.shared.Applications;
import com.netflix.eureka.EurekaServerContextHolder;
import com.netflix.eureka.registry.PeerAwareInstanceRegistry;

/**
 * @author Thirumal
 *
 */
@Component
public class InstanceRegisteredEvent implements ApplicationListener<EurekaInstanceRegisteredEvent>{

	@Override
	public void onApplicationEvent(EurekaInstanceRegisteredEvent event) {
		System.out.println(event.getInstanceInfo());
	}

	
	public void listInstance() {
		PeerAwareInstanceRegistry registry = EurekaServerContextHolder.getInstance().getServerContext().getRegistry();
	    Applications applications = registry.getApplications();	
	    applications.getRegisteredApplications().forEach(registeredApplication -> 
	        registeredApplication.getInstances().forEach(instance -> 
	            System.out.println(instance.getAppName() + " (" + instance.getInstanceId() + ") : " )));
	}
}
