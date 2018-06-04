package board.model;

public class FileVo {
	private String file_seq;
	private String file_board_seq;
	private String file_path;
	
	public FileVo(){
		
	}
	
	public String getFile_seq() {
		return file_seq;
	}
	public String getFile_board_seq() {
		return file_board_seq;
	}
	public String getFile_path() {
		return file_path;
	}
	public void setFile_seq(String file_seq) {
		this.file_seq = file_seq;
	}
	public void setFile_board_seq(String file_board_seq) {
		this.file_board_seq = file_board_seq;
	}
	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}
	public FileVo(String file_seq, String file_board_seq, String file_path) {
		super();
		this.file_seq = file_seq;
		this.file_board_seq = file_board_seq;
		this.file_path = file_path;
	}
	
}
