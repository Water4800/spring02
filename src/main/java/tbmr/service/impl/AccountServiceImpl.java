package tbmr.service.impl;

import tbmr.dao.IAccountDao;
import tbmr.dao.impl.AccountDaoImpl;
import tbmr.service.IAccountService;

/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao = new AccountDaoImpl();

    public AccountServiceImpl(){
        System.out.println("AccountServiceImpl 创建了");
    }

    public void saveAccount(){
        accountDao.saveAccount();

    }
}
