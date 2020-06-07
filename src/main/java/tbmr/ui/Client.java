package tbmr.ui;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.Resource;
import tbmr.dao.IAccountDao;
import tbmr.service.IAccountService;


/**
 * 模拟一个表现层，用户调用业务层
 */
public class Client {
    /**
     * 获取spring的Ioc核心容器，并根据ID获取对象
     * ApplicationContext三个常用实现类
     *      ClassPathXMlApplicationContext 加载类路径下的配置文件
     *      FileSystemXmlApplication 可以加载磁盘任意路径下的配置文件(访问权限)
     *
     *      AnnotationConfigApplicationContext 读取注解容器
     *
     * 核心容器的两个接口引发的问题
     *  ApplicationContext
     *      构建核心容器时，创建对象采取的策略时采用立即加载的方式，读取完配置文件，马上创建对象
     *
     *
     * BeanFactory  多例对象适用
     *      构建核心容器，创建对象采用延迟加载的方式，什么时候根据ID获取对象，什么时候创建对象
     * @param args
     */
    public static void main(String[] args) {
        //1.获取核心容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
//        ApplicationContext ac = new FileSystemXmlApplicationContext("D:\\java\\idea\\spring02\\src\\main\\resources\\bean.xml");

        //2.根据id获取Bean对象
        IAccountService as = (IAccountService) ac.getBean("accountService");
        IAccountDao adao = ac.getBean("accountDao",IAccountDao.class);

        System.out.println(as);
        System.out.println(adao);



    }
}
