package com.manager;

import com.provider.BadgeProvider;
import com.service.Badge;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by paozi on 2016/10/24.
 */
public class BadgeManager {

    // a private constructor
    private BadgeManager() {
    }

    // Maps service names to service
    private static final Map<String, BadgeProvider> providers = new ConcurrentHashMap<>();

    /**
     * <b>provider registration API.<b/>
     *
     * @param name     service name
     * @param provider service provider
     */
    public static void registerProvider(String name, BadgeProvider provider) {
        providers.put(name, provider);
    }

    public static Badge getBadge(String name) {
        BadgeProvider provider = providers.get(name);
        if (provider == null) {
            throw new IllegalArgumentException("No provider registered with name " + name);
        }
        return provider.getBadge();
    }
}
