package com.itheima.test;

import com.itheima.dao.conf.Conf;
import com.itheima.domain.Account;
import com.itheima.service.IAccountService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * 使用Junit单元测试：测试我们的配置
 */
public class AccountServiceTest {
    private IAccountService accountService=null;
    @Before
    public void init(){
        //        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Conf.class);
        accountService = applicationContext.getBean("accountService", IAccountService.class);
    }

    @Test
    public void testFindAll() {

        List<Account> accounts = accountService.findAllAccount();
        for(Account account : accounts){
            System.out.println(account);
        }
    }

    @Test
    public void testFindOne() {
        Account account = accountService.findAccountById(1);
        System.out.println(account);
    }

    @Test
    public void testSave() {
        Account account = new Account();
        account.setName("test");
        account.setMoney(12345f);
        accountService.saveAccount(account);
    }

    @Test
    public void testUpdate() {
        Account account = accountService.findAccountById(3);
        account.setMoney(23456f);
        accountService.updateAccount(account);
    }

    @Test
    public void testDelete() {
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
//        IAccountService accountService = applicationContext.getBean("accountService", IAccountService.class);
        accountService.deleteAccount(4);
    }
}
