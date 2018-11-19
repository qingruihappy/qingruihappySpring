package com.qingruihappy3.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.qingruihappy1.dao.UserDao;
import com.qingruihappy3.service.UserService;
import com.qingruihappy3.transaction.TransactionUtilsc;

//user 服务层
@Service
public class UserServiceImplc implements UserService {
	@Autowired
	private UserDao userDao;

	public void add() {
		// 注意事项： 在使用spring事务的时候，service 不要try 最将异常抛出给外层aop 异常通知接受回滚
		try {
			userDao.add("test001", 20);
			int i = 1 / 0;
			System.out.println("################");
			userDao.add("test002", 21);
		} catch (Exception e) {
			e.printStackTrace();
			//TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		//在spring的事物中我们一般不要trycatch 因为一旦吃掉异常的话就不会走到反射类的AopTransaction的afterThrowing()异常方法中去了
		//这个时候假如我们的业务场景必须的try的话，我们在catch的里面加上手动回滚的代码TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		//记住必须每个catch都加的。
/*		userDao.add("test001", 20);
		int i = 1 / 0;
		System.out.println("################");
		userDao.add("test002", 21);*/
	}

}
