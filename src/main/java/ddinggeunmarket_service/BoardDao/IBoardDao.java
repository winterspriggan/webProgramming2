package ddinggeunmarket_service.BoardDao;

import java.util.List;

import ddinggeunmarket_service.BoardDto.BoardDto;
import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface IBoardDao {
	public List<BoardDto> list();
	public int write(String board_name, String board_title, String board_content);
	public BoardDto viewDto(String board_idx);
	public int updateDto(String board_idx, String board_name, String board_title, String board_content);
	public int deleteDto(String board_idx);
	public int hit(String board_idx);
	public int likes(String board_idx);
    public List<BoardDto> search(String query);

}
