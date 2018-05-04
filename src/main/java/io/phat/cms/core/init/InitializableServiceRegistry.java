package io.phat.cms.core.init;

public interface InitializableServiceRegistry {
    void exec();
    void registerService(InitializableService service);
    void registerBefore(Class<? extends InitializableService> serviceType, InitializableService service);
    void registerAfter(Class<? extends InitializableService> serviceType, InitializableService service);
}
