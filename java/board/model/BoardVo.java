package board.model;

import java.util.Date;

public class BoardVo {
	
	private String board_seq    ;
	private String pboard_seq   ;
	private String category_seq ;
	private String rn;
	private String board_group_seq    ;
	private String board_title   ;
	private String board_content ;
	private String board_mem_id  ;
	private Date board_reg_dt  ;
	private String board_del_yn  ;
	
	public BoardVo(){
		
	}

	public String getBoard_seq() {
		return board_seq;
	}

	public String getPboard_seq() {
		return pboard_seq;
	}

	public String getCategory_seq() {
		return category_seq;
	}

	public String getBoard_group_seq() {
		return board_group_seq;
	}

	public String getBoard_title() {
		return board_title;
	}

	public String getBoard_content() {
		return board_content;
	}

	public String getBoard_mem_id() {
		return board_mem_id;
	}

	public Date getBoard_reg_dt() {
		return board_reg_dt;
	}

	public String getBoard_del_yn() {
		return board_del_yn;
	}

	public void setBoard_seq(String board_seq) {
		this.board_seq = board_seq;
	}

	public void setPboard_seq(String pboard_seq) {
		this.pboard_seq = pboard_seq;
	}

	public void setCategory_seq(String category_seq) {
		this.category_seq = category_seq;
	}

	public void setBoard_group_seq(String board_group_seq) {
		this.board_group_seq = board_group_seq;
	}

	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}

	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}

	public void setBoard_mem_id(String board_mem_id) {
		this.board_mem_id = board_mem_id;
	}

	public void setBoard_reg_dt(Date board_reg_dt) {
		this.board_reg_dt = board_reg_dt;
	}

	public void setBoard_del_yn(String board_del_yn) {
		this.board_del_yn = board_del_yn;
	}

	public BoardVo(String board_seq, String pboard_seq, String category_seq,
			String board_group_seq, String board_title, String board_content,
			String board_mem_id, Date board_reg_dt, String board_del_yn) {
		super();
		this.board_seq = board_seq;
		this.pboard_seq = pboard_seq;
		this.category_seq = category_seq;
		this.board_group_seq = board_group_seq;
		this.board_title = board_title;
		this.board_content = board_content;
		this.board_mem_id = board_mem_id;
		this.board_reg_dt = board_reg_dt;
		this.board_del_yn = board_del_yn;
	}

	public String getRn() {
		return rn;
	}

	public void setRn(String rn) {
		this.rn = rn;
	}
	
	
	
	
}