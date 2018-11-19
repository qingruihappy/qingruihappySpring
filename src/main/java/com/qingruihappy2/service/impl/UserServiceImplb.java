package com.qingruihappy2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;

import com.qingruihappy2.dao.UserDaob;
import com.qingruihappy2.service.UserService;
import com.qingruihappy2.transaction.TransactionUtils;

//user 服务层
@Service
public class UserServiceImplb implements UserService {
	@Autowired
	private UserDaob userDao;
	@Autowired
	private TransactionUtils transactionUtils;

	// spring 事务封装呢？ aop技术
	public void add() {
		TransactionStatus transactionStatus = null;
		try {
			// 开启事务
			transactionStatus = transactionUtils.begin();
			userDao.add("test001", 20);
			System.out.println("开始报错啦!@!!");
			 int i = 1 / 0;
			System.out.println("################");
			userDao.add("test002", 21);
			// 提交事务
			//有错的话就会回滚的，这个时候当执行完userDao.add("test001", 20);，并不会插入到数据库中，只有确保commit的时候才会提交到数据库中去的
			//出错的话就会rollback的。
			if (transactionStatus != null)
				transactionUtils.commit(transactionStatus);
		} catch (Exception e) {
			e.getMessage();
			// 回滚事务
			if (transactionStatus != null)
				transactionUtils.rollback(transactionStatus);
		}
	}

}
