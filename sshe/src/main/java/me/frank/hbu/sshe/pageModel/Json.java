package me.frank.hbu.sshe.pageModel;

public class Json implements java.io.Serializable {

	private static final long serialVersionUID = -2073084046088942499L;

	private boolean success = false;

	private String msg = "";

	private Object obj = null;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

}
