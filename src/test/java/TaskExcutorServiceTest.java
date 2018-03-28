import com.lxl.service.TaskExcutorService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author lixiaolong
 * @Description:
 * @Date 2018/3/28
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TaskExcutorServiceTest {

    @Autowired
    private TaskExcutorService taskExcutorService;

    @Test
    public void test() {
        for (int x = 0; x < 100; x++) {
            try {
                taskExcutorService.execute1(x);
            } catch (Exception e) {
                try {
                    //TaskRejectedException
                    //Spring ThreadPoolTaskExecutor没有使用阻塞模式将任务加入到对象中，因此对象满的时候会抛出异常，
                    // 对于这种情况，一般的企业执行环境不能无限制的增大内存队列容量，因此不得不阻塞队列的加入，
                    // spring内置提供的异常处理机制不好用，因为ThreadPoolExecutor.CallerRunsPolicy的处理方式是将异常任务放在调用线程中执行，
                    // 这样对于单个执行时间长的任务，即使队列有空闲了，剩下的任务也要等这个任务在主线程执行完了才能继续往队列里面添加。
                    // 有一个处理方法就是捕获executor.execute()的异常，只要发现有异常就等待一段时间，直到没有异常为止，这样就能模仿阻塞队列的效果
                    Thread.sleep(500);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test2() {
        for (int x = 0; x < 100; x++) {
            try {
                taskExcutorService.execute2(x);
            } catch (Exception e) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                e.printStackTrace();
            }
        }
    }
}
