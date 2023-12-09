package ddinggeunmarket_service.BoardDto;

import java.util.Date;

import lombok.Data;

@Data
public class SubReplyDto {
    private int sub_reply_idx;
    private String sub_reply_name;
    private String sub_reply_content;
    private Date sub_reply_date;
    private int sub_reply_reply_idx;
    
    public SubReplyDto() {
		
	} 
   
    public SubReplyDto(int sub_reply_idx, String sub_reply_name, String sub_reply_content, Date sub_reply_date, int sub_reply_reply_idx) {
		super();
		this.sub_reply_idx = sub_reply_idx;
		this.sub_reply_name = sub_reply_name;
		this.sub_reply_content = sub_reply_content;
		this.sub_reply_date = sub_reply_date;
		this.sub_reply_reply_idx = sub_reply_reply_idx;
	}

	public Date getSub_reply_date() {
		return sub_reply_date;
	}

	public void setSub_reply_date(Date sub_reply_date) {
		this.sub_reply_date = sub_reply_date;
	}

	public String getSub_reply_content() {
		return sub_reply_content;
	}

	public void setSub_reply_content(String sub_reply_content) {
		this.sub_reply_content = sub_reply_content;
	}

	public String getSub_reply_name() {
		return sub_reply_name;
	}

	public void setSub_reply_name(String sub_reply_name) {
		this.sub_reply_name = sub_reply_name;
	}

	public int getSub_reply_idx() {
		return sub_reply_idx;
	}

	public void setSub_reply_idx(int sub_reply_idx) {
		this.sub_reply_idx = sub_reply_idx;
	}

	

	public int getSub_reply_reply_idx() {
		return sub_reply_reply_idx;
	}

	public void setSub_reply_reply_idx(int sub_reply_reply_idx) {
		this.sub_reply_reply_idx = sub_reply_reply_idx;
	}
	
}
