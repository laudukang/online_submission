package me.laudukang.persistence.service;

import me.laudukang.persistence.model.OsUser;
import me.laudukang.persistence.util.PrintUtil;
import me.laudukang.spring.config.AsyncConfig;
import me.laudukang.spring.config.PersistenceJPAConfig;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>Created with IDEA
 * <p>Author: laudukang
 * <p>Date: 2016/2/20
 * <p>Time: 22:22
 * <p>Version: 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersistenceJPAConfig.class, AsyncConfig.class}, loader = AnnotationConfigContextLoader.class)
@Transactional
@Rollback(false)
public class UserServiceTest {
    @Autowired
    private IUserService userService;
    private PrintUtil printUtil;
    private Pageable pageable;
    private SimpleDateFormat sdf;

    @Before
    public void initTest() {
        this.sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.printUtil = new PrintUtil();
        this.pageable = new PageRequest(0,
                10, new Sort(Sort.Direction.ASC, "id"));
    }

    @After
    public void endTest() {
        System.out.println("waiting async...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void save() {
        OsUser osUser = new OsUser();
        osUser.setAccount("account_" + sdf.format(new Date()));
        osUser.setPassword("123");
        userService.save(osUser);
    }

    @Test
    public void updateById() {
        OsUser osUser = new OsUser();
        osUser.setId(4);
        osUser.setName("update_" + sdf.format(new Date()));
        osUser.setPassword("123");
        userService.updateById(osUser);
    }

    @Test
    public void deleteById() {
        userService.deleteById(3);
    }

    @Test
    public void findOne() {
        OsUser osUser = userService.findOne("lau", "123");
        try {
            com.google.common.base.Preconditions.checkNotNull(osUser, "Warning:user is null");
            System.out.println("user.name=" + osUser.getName());
        } catch (NullPointerException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
