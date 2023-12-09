package ddinggeunmarket_service.BoardDao;

import java.util.List;

import ddinggeunmarket_service.BoardDto.ReplyDto;
import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface IReplyDao {
	public List<ReplyDto> reply_list(String reply_board_idx);
	public int reply_write(String reply_name, String reply_content, String reply_board_index);
	public int reply_deleteDto(String reply_idx);
    public int reply_update(String reply_idx, String reply_content);
	
	
}
