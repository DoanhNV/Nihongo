package com.nihongo.data.entity.other.transfer;

import java.util.List;

import com.nihongo.dto.httpdto.AbstractDTO;
import com.nihongo.dto.httpdto.response.AbstractNihongoResponse;

/**
 * 
 * @author DoanhNV Sep 3, 2018 - 8:32:57 PM
 *
 */
public class SearchResult {

	private int total;
	private List<AbstractDTO> datas;

	public SearchResult() {

	}

	public SearchResult(List<AbstractDTO> datas) {
		this.datas = datas;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<AbstractDTO> getDatas() {
		return datas;
	}

	public void setDatas(List<AbstractDTO> datas) {
		this.datas = datas;
	}
}
