package board.model;

public class CommentsVo {
	private String cmt_seq;
	private String cmt_board_seq;
	private String cmt_mem_id   ;
	private String cmt_content  ;
	private String cmt_reg_dt   ;
	private String cmt_del_yn   ;
	
	public CommentsVo(){
		
	}
	
	public String getCmt_seq() {
		return cmt_seq;
	}
	public String getCmt_board_seq() {
		return cmt_board_seq;
	}
	public String getCmt_mem_id() {
		return cmt_mem_id;
	}
	public String getCmt_content() {
		return cmt_content;
	}
	public String getCmt_reg_dt() {
		return cmt_reg_dt;
	}
	public String getCmt_del_yn() {
		return cmt_del_yn;
	}
	public void setCmt_seq(String cmt_seq) {
		this.cmt_seq = cmt_seq;
	}
	public void setCmt_board_seq(String cmt_board_seq) {
		this.cmt_board_seq = cmt_board_seq;
	}
	public void setCmt_mem_id(String cmt_mem_id) {
		this.cmt_mem_id = cmt_mem_id;
	}
	public void setCmt_content(String cmt_content) {
		this.cmt_content = cmt_content;
	}
	public void setCmt_reg_dt(String cmt_reg_dt) {
		this.cmt_reg_dt = cmt_reg_dt;
	}
	public void setCmt_del_yn(String cmt_del_yn) {
		this.cmt_del_yn = cmt_del_yn;
	}

	public CommentsVo(String cmt_board_seq, String cmt_mem_id,
			String cmt_content) {
		super();
		this.cmt_board_seq = cmt_board_seq;
		this.cmt_mem_id = cmt_mem_id;
		this.cmt_content = cmt_content;
	}
	
	
	
}
