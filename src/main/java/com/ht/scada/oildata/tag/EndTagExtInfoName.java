package com.ht.scada.oildata.tag;

/**
 * 油井属性
 * @author 赵磊
 *
 */
public enum EndTagExtInfoName {
	/**
	 * 油井阶段(自喷、注汽、焖井、抽油)
	 * @see EndTagExtInfoStageType
	 */
	STAGE("油井阶段"),
	/**
	 * 油井工艺(稀油、稠油等暂不明确)
	 */
	TECHNOLOGY("油井工艺"),
	BENGJING("泵径");
	
	private String value;
	
	private EndTagExtInfoName(String value) {
		this.value = value;
	}
	private EndTagExtInfoName() {
		this(null);
	}
	public String getValue() {
		return value;
	}

}
