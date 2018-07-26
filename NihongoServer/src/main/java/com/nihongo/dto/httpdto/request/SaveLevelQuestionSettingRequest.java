package com.nihongo.dto.httpdto.request;

import java.util.List;

import com.nihongo.data.entity.setting.LevelQuestionNumberSetting;

/**
 * 
 * @author DoanhNV Jul 19, 2018 5:29:15 PM
 *
 */
public class SaveLevelQuestionSettingRequest extends AbstractRequest {
	
	private List<LevelQuestionNumberSetting> levelQuestionNumberSettings;
	
	public List<LevelQuestionNumberSetting> getLevelQuestionNumberSettings() {
		return levelQuestionNumberSettings;
	}

	public void setLevelQuestionNumberSettings(List<LevelQuestionNumberSetting> levelQuestionNumberSettings) {
		this.levelQuestionNumberSettings = levelQuestionNumberSettings;
	}
}
