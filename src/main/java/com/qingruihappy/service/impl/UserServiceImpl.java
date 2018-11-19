package com.qingruihappy.service.impl;

import org.springframework.stereotype.Service;

import com.qingruihappy.service.UserService;
/**
 * 注意事物出异常的话一定不要吃掉（try cath ，而是要throw往外抛，否则事物是不起作用的。原因我们后面讲）
 * @author qingruihappy
 * @data   2018年11月19日 上午12:21:21
 * @说明:
 */
//user 服务层
@Service
public class UserServiceImpl implements UserService {
	// spring 事务封装呢？ aop技术
	public void add() {
      System.out.println("往数据库添加数据.........");
	}

}
