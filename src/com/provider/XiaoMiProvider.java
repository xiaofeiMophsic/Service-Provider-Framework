package com.provider;

import com.manager.BadgeManager;
import com.service.Badge;
import com.service.XiaoMiBadge;

/**
 * Created by paozi on 2016/10/24.
 */
public class XiaoMiProvider implements BadgeProvider{

    static {
        BadgeManager.registerProvider(XiaoMiProvider.class.getCanonicalName(), new XiaoMiProvider());
    }

    private XiaoMiProvider(){}

    @Override
    public Badge getBadge() {
        return new XiaoMiBadge();
    }
}
