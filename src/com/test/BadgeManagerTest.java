package com.test;

import com.manager.BadgeManager;
import com.service.Badge;
import org.junit.Test;

/**
 * Created by paozi on 2016/10/24.
 */
public class BadgeManagerTest {

    @Test
    public void testGetBadge() throws ClassNotFoundException {

        // reference from JDBC.
        // For example, use JDBC to connect MySQL DB, a general code as follow:
        // Class.forName("com.mysql.jdbc.Driver");
        // Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "username", "password");

        Class.forName("com.provider.XiaoMiProvider"); // test for xiaomi provider
        Badge badge = BadgeManager.getBadge("com.provider.XiaoMiProvider");
        badge.showBadge();

        Class.forName("com.provider.HuaweiProvider");
        Badge hBadge = BadgeManager.getBadge("com.provider.HuaweiProvider");
        hBadge.showBadge();
    }
}
