package com.nihongo.data.entity.setting;

/**
 * 
 * @author DoanhNV Aug 21, 2018 4:45:45 PM
 *
 */
public class TopicNumber {

	private int topic;
	private int number;
	
	public TopicNumber() {

	}
	
	public TopicNumber(int topic, int number) {
		this.topic = topic;
		this.number = number;
	}

	public int getTopic() {
		return topic;
	}

	public void setTopic(int topic) {
		this.topic = topic;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
}
