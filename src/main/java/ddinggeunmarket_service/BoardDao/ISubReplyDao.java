package ddinggeunmarket_service.BoardDao;

import java.util.List;

import ddinggeunmarket_service.BoardDto.SubReplyDto;
import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface ISubReplyDao {
	public List<SubReplyDto> sub_reply_list(String sub_reply_reply_idx);
    public int sub_reply_write(String sub_reply_name, String sub_reply_content, String sub_reply_reply_idx);
    public int sub_reply_deleteDto(String sub_reply_idx);
    public int sub_reply_update(String sub_reply_idx, String sub_reply_content);
}
