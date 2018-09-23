package com.nihongo.dto.httpdto.request;

import java.util.List;

import com.nihongo.dto.httpdto.AbstractDTO;
import com.nihongo.dto.httpdto.response.AbstractNihongoResponse;

/**
 * 
 * @author DoanhNV Sep 22, 2018 - 5:27:08 PM
 *
 */
public class ListExamResponse extends AbstractNihongoResponse {

	private List<AbstractDTO> datas;

	public List<AbstractDTO> getDatas() {
		return datas;
	}

	public void setDatas(List<AbstractDTO> datas) {
		this.datas = datas;
	}
}
