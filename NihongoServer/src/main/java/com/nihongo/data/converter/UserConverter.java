package com.nihongo.data.converter;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.nihongo.data.entity.user.User;
import com.nihongo.support.constant.Constant;
import com.nihongo.support.constant.LoginSystemUserTemplate;
import com.nihongo.support.constant.mongo.MongoOperator;

import static com.nihongo.support.constant.mongo.MongoDBKey.USER.*;

import org.bson.types.ObjectId;

/**
 * 
 * @author DoanhNV Sep 23, 2018 - 5:06:17 PM
 *
 */
public class UserConverter {
	
	public static DBObject prepareCreateUserObject(User user) {
		BasicDBObject insertObject = new BasicDBObject();
		insertObject.append(USER_NAME, user.getUserName());
		insertObject.append(PASSWORD, user.getPassword());
		insertObject.append(FULL_NAME, user.getFullName());
		insertObject.append(LEVEL, user.getLevel());
		insertObject.append(POINT, user.getPoint());
		insertObject.append(AVATAR_URL, Constant.USER.DEFAULT_AVATAR_URL);
		insertObject.append(GMAIL, user.getGmail());
		insertObject.append(FACEBOOK_ID, user.getFacebookId());
		insertObject.append(BIRTHDAY, user.getBirthday());
		
		if (user instanceof LoginSystemUserTemplate) {
			LoginSystemUserTemplate systemUser = (LoginSystemUserTemplate) user;
			insertObject.append(IS_SYSTEM_USER, systemUser.isSystemUser());
		}
		long currentTimeMillis = System.currentTimeMillis();
		insertObject.append(CREATE_TIME, currentTimeMillis);
		return insertObject;
	}
	
	public static DBObject prepareIsExistUser(String userName, String gmail, String facebookId) {
		BasicDBList conditions = new BasicDBList();
		if(userName != null) {
			conditions.add(new BasicDBObject(USER_NAME, userName));
		}
		if(gmail != null) {
			conditions.add(new BasicDBObject(GMAIL, gmail));
		}
		if(facebookId != null) {
			conditions.add(new BasicDBObject(FACEBOOK_ID, facebookId));
		}
		return new BasicDBObject(MongoOperator.OR, conditions);
	}
	
	public static DBObject prepareLoginObject(String loginAlias, String password, int loginType) {
		String LOGIN_ALIAS_FIELD = USER_NAME;
		
		switch(loginType) {
			case Constant.LOGIN_TYPE.BY_USER_NAME:
				LOGIN_ALIAS_FIELD = USER_NAME;
			break;
			case Constant.LOGIN_TYPE.BY_GMAIL:
				LOGIN_ALIAS_FIELD = GMAIL;
			break;
			case Constant.LOGIN_TYPE.BY_FACEBOOK:
				LOGIN_ALIAS_FIELD = FACEBOOK_ID;
			break;
		}
		BasicDBObject queryObject = new BasicDBObject(LOGIN_ALIAS_FIELD, loginAlias).append(PASSWORD, password);
		return queryObject;
	}
	
	public static DBObject prepareObjectId(String userId) {
		ObjectId objectId = new ObjectId(userId);
		return new BasicDBObject(ID, objectId);
	}
	
	public static DBObject existLoginSystemUserRequest() {
		return new BasicDBObject(IS_SYSTEM_USER, true);
	}

	public static User toBasicUser(DBObject userObject) {
		String userId = userObject.get(ID).toString();
		String fullName = (String) userObject.get(FULL_NAME);
		Integer level = (Integer) userObject.get(LEVEL);
		Integer point = (Integer) userObject.get(POINT);
		String avatarURL = (String) userObject.get(AVATAR_URL);
		String password = (String) userObject.get(PASSWORD);
		Boolean isAdmin = (Boolean) userObject.get(IS_ADMIN);
		isAdmin = isAdmin == null ? false : isAdmin;
		
		User user = new User(userId);
		user.setFullName(fullName);
		user.setLevel(level);
		user.setPoint(point);
		user.setAvatarURL(avatarURL);
		user.setPassword(password);
		user.setAdmin(isAdmin);
		return user;
	}
}
