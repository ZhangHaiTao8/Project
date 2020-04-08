package com.shisizu.domain;

/**
 * 通用的返回的类
 * @author ASUS
 *
 */

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Msg {
	// 状态码
	private int code;
	// 提示信息
	private String msg;

	// 用户要返回给浏览器的数据
	private Map<String, Object> extend = new HashMap<String, Object>();

	public static Msg success() {
		Msg result = new Msg();
		result.setCode(100);
		result.setMsg("处理成功");
		return result;
	}

	public static Msg fail() {
		Msg result = new Msg();
		result.setCode(200);
		result.setMsg("处理失败");
		return result;
	}

	public Msg add(String key, Object value) {
		this.getExtend().put(key, value);
		return this;
	}
}
