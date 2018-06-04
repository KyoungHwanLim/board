package board.model;

import java.util.Date;

public class BoardPageVo {
	private String bp_seq;
	private String bp_title;
	private Date bp_dt;
	private String del_yn;
	
	public BoardPageVo(){
		
	}

	public String getBp_seq() {
		return bp_seq;
	}

	public String getBp_title() {
		return bp_title;
	}

	public Date getBp_dt() {
		return bp_dt;
	}

	public String getDel_yn() {
		return del_yn;
	}

	public void setBp_seq(String bp_seq) {
		this.bp_seq = bp_seq;
	}

	public void setBp_title(String bp_title) {
		this.bp_title = bp_title;
	}

	public void setBp_dt(Date bp_dt) {
		this.bp_dt = bp_dt;
	}

	public void setDel_yn(String del_yn) {
		this.del_yn = del_yn;
	}

	public BoardPageVo(String bp_seq, String bp_title, Date bp_dt, String del_yn) {
		super();
		this.bp_seq = bp_seq;
		this.bp_title = bp_title;
		this.bp_dt = bp_dt;
		this.del_yn = del_yn;
	}
	
	
}
