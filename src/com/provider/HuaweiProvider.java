package com.provider;

import com.manager.BadgeManager;
import com.service.Badge;
import com.service.HuaWeiBadge;

/**
 * Created by paozi on 2016/10/24.
 */
public class HuaweiProvider implements BadgeProvider{

    static {
        BadgeManager.registerProvider(HuaweiProvider.class.getCanonicalName(), new HuaweiProvider());
    }

    private HuaweiProvider(){}

    @Override
    public Badge getBadge() {
        return new HuaWeiBadge();
    }
}
