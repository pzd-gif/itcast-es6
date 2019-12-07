package com.zs.lianxi.vo;
/**
 * 
* @ClassName: ReusltVo
* @Description: 异步提交时返回的结果
* @author Alex Lu
* @date 2019年9月16日 下午3:48:51
*
 */
public class ResultVo {
	
	/**
	 * 业务状态标识。0表示业务处理失败，1表示业务处理成功
	 */
	private Integer status;
	
	/**
	 * 描述业务状态的文本消息
	 */
	private String message;

	public ResultVo() {
		super();
	}

	public ResultVo(Integer status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
