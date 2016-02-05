package me.laudukang.persistence.service;

import me.laudukang.persistence.model.OsLog;
import me.laudukang.spring.config.AsyncConfig;
import me.laudukang.spring.config.PersistenceJPAConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import javax.transaction.Transactional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * <p>Created with IDEA
 * <p>Author: laudukang
 * <p>Date: 2016/1/31
 * <p>Time: 16:50
 * <p>Version: 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersistenceJPAConfig.class, AsyncConfig.class}, loader = AnnotationConfigContextLoader.class)
@Transactional
@Rollback(false)
public class LogServiceTest {
    @Autowired
    private ILogService logService;

    @Test
    public void saveWithJPA() {
        OsLog osLog = new OsLog();
        // osLog.setTime(new Timestamp(new Date().getTime()));
        osLog.setContent("content_" + System.currentTimeMillis());
        logService.save(osLog);
    }

    @Test
    public void findByContent() {
        Pageable pageable = new PageRequest(0, 10);
        System.out.println(logService.findByContent("content_20160131174836", pageable));
    }

    @Test
    public void findAll() {
        Pageable pageable = new PageRequest(0,
                10, new Sort(Sort.Direction.DESC, "time").and(new Sort(Sort.Direction.ASC, "content")));
        Page<OsLog> result = logService.findAll(pageable);
        System.out.println(result.getSize());
    }

    @Test
    public void findByUserOrAdminName() {
        Pageable pageable = new PageRequest(0,
                10, new Sort(Sort.Direction.DESC, "time").and(new Sort(Sort.Direction.ASC, "content")));

        System.out.println(logService.findByUserOrAdminName("au", pageable));
    }


    @Test
    public void deleteById() {
        //Pageable pageable = new PageRequest(page, size, sort);

        //logService.deleteById(1);
        try {
            logService.deleteById(32);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void deleteByEntity() {
        OsLog osLog = new OsLog();
        osLog.setId(33);
        try {
            logService.deleteByEntity(osLog);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void asyncMethodWithReturnType() {
        Future<String> future = logService.asyncMethodWithReturnType();
        while (true) {  ///这里使用了循环判断，等待获取结果信息
            if (future.isDone()) {  //判断是否执行完毕
                try {
                    System.out.println("Result from asynchronous process - " + future.get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
                break;
            }
            System.out.println("Continue doing something else. ");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("async done");
    }

    //@Test
    //public void saveWithEM() {
    //    OsLog osLog = new OsLog();
    //    //osLog.setTime(new Timestamp(new Date().getTime()));
    //    osLog.setContent("content_" + System.currentTimeMillis());
    //    logService.saveWithEM(osLog);
    //}

}