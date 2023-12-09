package ddinggeunmarket_service.BoardDto;

import java.util.Date;

import lombok.Data;


@Data
public class BoardDto { 
	private int board_idx;
	private String board_name;
	private String board_title;
	private String board_content;
	private Date board_date;
	private int board_hit;
	private int board_likes;
	
	public BoardDto() {
		
	}
	
	public BoardDto(int board_idx, String board_name, String board_title, String board_content, Date board_date,
			int board_hit, int board_likes) {
		super();
		this.board_idx = board_idx;
		this.board_name = board_name;
		this.board_title = board_title;
		this.board_content = board_content;
		this.board_date = board_date;
		this.board_hit = board_hit;
		this.board_likes = board_likes;
	}
	public int getBoard_likes() {
        return board_likes;
    }

    public void setBoard_likes(int board_likes) {
        this.board_likes = board_likes;
    }
		
	
	   public int getBoard_idx() {
	        return board_idx;
	    }

	    public void setBoard_idx(int board_idx) {
	        this.board_idx = board_idx;
	    }

	    public String getBoard_name() {
	        return board_name;
	    }

	    public void setBoard_name(String board_name) {
	        this.board_name = board_name;
	    }

	    public String getBoard_title() {
	        return board_title;
	    }

	    public void setBoard_title(String board_title) {
	        this.board_title = board_title;
	    }

	    public String getBoard_content() {
	        return board_content;
	    }

	    public void setBoard_content(String board_content) {
	        this.board_content = board_content;
	    }

	    public Date getBoard_date() {
	        return board_date;
	    }

	    public void setBoard_date(Date board_date) {
	        this.board_date = board_date;
	    }

	    public int getBoard_hit() {
	        return board_hit;
	    }

	    public void setBoard_hit(int board_hit) {
	        this.board_hit = board_hit;
	    }

}
