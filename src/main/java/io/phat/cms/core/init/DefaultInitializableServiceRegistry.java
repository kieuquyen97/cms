package io.phat.cms.core.init;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class DefaultInitializableServiceRegistry implements InitializableServiceRegistry {

    private List<InitializableService> services = Collections.synchronizedList(new ArrayList<>());

    @Override
    public void exec() {
        services.forEach(service -> service.init());
    }

    @Override
    public void registerService(InitializableService service) {
        services.add(service);
    }

    @Override
    public void registerBefore(Class<? extends InitializableService> serviceType, InitializableService service) {
        int idx = indexOfService(serviceType) - 1;
        services.add(idx == -1? 0: idx, service);
    }

    @Override
    public void registerAfter(Class<? extends InitializableService> serviceType, InitializableService service) {
        int idx = indexOfService(serviceType) + 1;
        if (idx == services.size()) {
            registerService(service);
        } else {
            services.add(idx, service);
        }
    }

    private int indexOfService(Class<? extends InitializableService> serviceType) {
        int count = 0;
        for (InitializableService service : services) {
            if (service.getClass().equals(serviceType)) {
                return count;
            }
            count++;
        }
        return count;
    }
}
