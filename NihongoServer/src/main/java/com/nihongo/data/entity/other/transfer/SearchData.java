package com.nihongo.data.entity.other.transfer;

import java.util.List;

import com.nihongo.data.entity.AbstractEntity;

/**
 * 
 * @author DoanhNV Jul 29, 2018 10:33:46 PM
 */
public class SearchData {

	private int total;
	private List<AbstractEntity> datas;

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<AbstractEntity> getDatas() {
		return datas;
	}

	public void setDatas(List<AbstractEntity> datas) {
		this.datas = datas;
	}
}
