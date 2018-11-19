package com.qingruihappy1.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qingruihappy1.service.UserService;
import com.qingruihappy2.dao.UserDaob;

//user 服务层
@Service
public class UserServiceImpla implements UserService {
	@Autowired
	private UserDaob userDao;
	public void add() {
		// 注意在这里没有事物的话，执行完userDao.add("test001", 20);就会把数据插入到数据库中去的。
			userDao.add("test001", 20);
			int a=1/0;
			//因为这里没有事物所以当报错的时候tes001会插入到数据库中，而test002不会插入到数据库中。
			System.out.println("################");
			userDao.add("test002", 21);
	}

}
