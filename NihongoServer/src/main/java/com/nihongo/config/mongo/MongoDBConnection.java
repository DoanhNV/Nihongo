package com.nihongo.config.mongo;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import static com.nihongo.support.constant.mongo.MongoConfig.*;

/**
 * 
 * @author DoanhNV Jul 7, 2018 10:34:21 AM
 */

public class MongoDBConnection {

	@SuppressWarnings({ "deprecation", "resource" })
	public static DB getDatabase(String dbName) {
		DB database = null;
		try {
			MongoClient mongoClient = new MongoClient(HOST, PORT);
			database = mongoClient.getDB(dbName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return database;
	}
	
}
