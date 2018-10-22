package com.nihongo.data.dao.impl;

import org.springframework.stereotype.Repository;

import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.nihongo.data.converter.UserConverter;
import com.nihongo.data.dao.UserDAO;
import com.nihongo.data.entity.user.User;
import com.nihongo.support.constant.mongo.MongoConfigInfo;

/**
 * 
 * @author DoanhNV Sep 23, 2018 - 4:59:43 PM
 *
 */
@Repository
public class UserDAOImpl implements UserDAO {
	
	private final DBCollection userCollection = USER_DATABASE.getCollection(MongoConfigInfo.USER.USER_COLLECTION);
	
	@Override
	public User createUser(User user) {
		DBObject insertUserObject = UserConverter.prepareCreateUserObject(user);
		userCollection.insert(insertUserObject);
		return UserConverter.toBasicUser(insertUserObject);
	}

	@Override
	public boolean existUser(String userName, String gmail, String facebookId) {
		DBObject queryObject = UserConverter.prepareIsExistUser(userName, gmail, facebookId);
		long recordNumber = userCollection.count(queryObject);
		return recordNumber > 0;
	}

	@Override
	public User login(String loginAlias, String password, int loginType) {
		DBObject loginObject = UserConverter.prepareLoginObject(loginAlias, password, loginType);
		DBCursor cursor = userCollection.find(loginObject);
		if (cursor.hasNext()) {
			DBObject loginDBOjbect = cursor.next();
			return UserConverter.toBasicUser(loginDBOjbect);
		}
		return null;
	}

	@Override
	public User getBasicUserInfo(String requestUserId) {
		final DBObject query = UserConverter.prepareObjectId(requestUserId);
		DBCursor cursor = userCollection.find(query);
		if (cursor.hasNext()) {
			DBObject loginDBOjbect = cursor.next();
			return UserConverter.toBasicUser(loginDBOjbect);
		}
		return null;
	}

}
