package com.lxl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @Author lixiaolong
 * @Description:
 * @Date 2018/3/28
 */
@Service
public class TaskExcutorService {

    @Autowired //spring配置方式实现异步线程
    private TaskExecutor taskExecutor;

    @Async //自定义配置文件方式实现异步线程
    public void execute1(int x) {
        System.out.println("异步任务:" + x);
    }

    public void execute2(int x) {
        taskExecutor.execute(new print(x));
    }

    class print implements Runnable {
        private int x;

        public print(int x) {
            this.x = x;
        }

        @Override
        public void run() {
            System.out.println("注解方式：" + x);
        }
    }


}
