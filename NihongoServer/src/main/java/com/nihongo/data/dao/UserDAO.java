package com.nihongo.data.dao;

import com.mongodb.DB;
import com.nihongo.config.mongo.MongoDBConnection;
import com.nihongo.data.entity.user.User;
import com.nihongo.support.constant.mongo.MongoConfigInfo;

/**
 * 
 * @author DoanhNV Sep 23, 2018 - 4:59:10 PM
 *
 */
public interface UserDAO {
	
	public static final DB USER_DATABASE = MongoDBConnection.getDatabase(MongoConfigInfo.USER_DB);
	
	public User createUser(User user);
	
	public User login(String loginAlias, String password, int loginType);
	
	public User getBasicUserInfo(String requestUserId);
	
	public boolean existUser(String userName,  String gmail, String facebookId);
	
	public boolean isExistLoginSystemUser();
}
