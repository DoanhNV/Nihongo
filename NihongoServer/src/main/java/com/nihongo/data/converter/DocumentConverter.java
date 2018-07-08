package com.nihongo.data.converter;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.nihongo.data.entity.questiondocument.Document;
import static com.nihongo.support.constant.mongo.MongoDBKey.DocumentKey.*;

import java.util.List;

/**
 * 
 * @author DoanhNV Jul 8, 2018 11:10:55 AM
 */
public class DocumentConverter {
		
	public static DBObject toInsertDBObject(Document document) {
		BasicDBObject desObject = new BasicDBObject();
		desObject.append(CONTENT, document.getContent());
		desObject.append(TOPIC, document.getTopic());
		desObject.append(LEVEL, document.getLevel());
		List<String> questionIds = document.getQuestionIds();
		BasicDBList questionIdList = new BasicDBList();
		for (String questionId : questionIds) {
			questionIdList.add(questionId);
		}
		desObject.append(QUESTION_IDS, questionIdList);
		desObject.append(TYPE, document.getType());
		return desObject;
	}
}
