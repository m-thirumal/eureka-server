/**
 * 
 */
package in.thirumal.event;

import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceCanceledEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author Thirumal
 *
 */
@Component
public class InstanceCancelledEvent implements ApplicationListener<EurekaInstanceCanceledEvent> {

	@Override
	public void onApplicationEvent(EurekaInstanceCanceledEvent event) {
		System.out.println("Instance canceled: " + event.getAppName());
		//InstanceRegistry 
	}

}
