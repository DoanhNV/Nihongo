package com.nihongo.dto.httpdto.response;

import java.util.List;

import com.nihongo.dto.httpdto.AbstractDTO;

public class HistoryExamResponse extends AbstractNihongoResponse {
	
	private List<AbstractDTO> datas;

	public List<AbstractDTO> getDatas() {
		return datas;
	}

	public void setDatas(List<AbstractDTO> datas) {
		this.datas = datas;
	}
}
