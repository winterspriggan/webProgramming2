package ddinggeunmarket_service.controller;

import java.io.IOException;
import java.util.List;

import ddinggeunmarket_service.BoardDao.IBoardDao;
import ddinggeunmarket_service.BoardDao.IReplyDao;
import ddinggeunmarket_service.BoardDao.ISubReplyDao;
import ddinggeunmarket_service.BoardDto.BoardDto;
import ddinggeunmarket_service.BoardDto.ReplyDto;
import ddinggeunmarket_service.BoardDto.SubReplyDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;



import jakarta.servlet.http.HttpServletRequest;

@Controller
public class BoardController {
	
	@Autowired
	IBoardDao boardDao;
	@Autowired
	IReplyDao replyDao;
	@Autowired
	ISubReplyDao subReplyDao;

	

	
/**	@RequestMapping("/")
	//@ResponseBody
	public String root() {
		
		return "redirect:listForm";
	}*/
	
	@RequestMapping("/listForm")
	public String listForm(Model model) {
		List<BoardDto> list = boardDao.list();
		model.addAttribute("list", list);
		System.out.println( list );
		return "listForm";
	}
	
	@RequestMapping("/writeForm")
	public String writeForm() {
		return "writeForm";
	}
	@RequestMapping("/writeAction")
	@ResponseBody
	public String writeAction(@RequestParam("board_name") String board_name, 
			@RequestParam("board_title") String board_title,
			@RequestParam("board_content") String board_content,
			HttpServletRequest request)
	{
		int result = boardDao.write(board_name, board_title, board_content);
		if (result == 1) {
			System.out.println("글쓰기 성공!");
			
		//	return "redirect:listForm";
			return "<script>alert('글쓰기 성공!'); location.href='/listForm';</script>";
		}else {
			System.out.println("글쓰기 실패!");
			
			//return "redirect:writeForm";
			return "<script>alert('글쓰기 실패!'); location.href='/writeForm';</script>";
		}
		
	}
	@RequestMapping("/writeReplyAction")
	@ResponseBody
	public String writeReplyAction(@RequestParam("reply_content") String reply_content,
			@RequestParam("reply_name") String reply_name, 
			@RequestParam("reply_board_index") String reply_board_index, 
			HttpServletRequest request)
	{
		int result = replyDao.reply_write(reply_name, reply_content, reply_board_index);
		if (result == 1) {
			System.out.println("댓글달기 성공!");
			
		
			return "<script>alert('댓글달기 성공!'); location.href='/contentForm?board_idx=" + reply_board_index + "';</script>";
		}else {
			System.out.println("댓글달기 실패!");
			

			return "<script>alert('댓글달기 실패!'); location.href='/contentForm?board_idx=" + reply_board_index + "';</script>";
		}
		
	}
	
	@RequestMapping("/contentForm")
	public String contentForm(@RequestParam("board_idx") String board_idx, Model model, HttpServletRequest request) {
		boardDao.hit(board_idx); // 조회수 증가
		
		//게시글 보기
		BoardDto dto = boardDao.viewDto( board_idx);
		model.addAttribute("dto", dto); 
		
		//댓글 리스트 가져오기
		List<ReplyDto> reply_list = replyDao.reply_list( board_idx);
		model.addAttribute("reply_list", reply_list);
		
		 List<SubReplyDto> sub_reply_list = subReplyDao.sub_reply_list(board_idx); // 대댓글 목록 가져오기
		    model.addAttribute("sub_reply_list", sub_reply_list);
		
		    
		return "contentForm";
		
	}
	@RequestMapping("/updateAction")
	@ResponseBody
	public String updateAction (@RequestParam("board_idx") String board_idx,
								@RequestParam("board_name") String board_name,
								@RequestParam("board_title") String board_title,
								@RequestParam("board_content") String board_content,
								HttpServletRequest request) {
								
			int result = boardDao.updateDto(board_idx, board_name, board_title, board_content);
			if ( result ==1) {
				System.out.println("글수정 성공!");
				
			//	return "redirect:listForm";
				return "<script>alert('글수정 성공!'); location.href='/listForm';</script>";
			}else {
				System.out.println("글수정 실패!");
				
			//	return "redirect:contentForm?board_idx=" + board_idx;
				return "<script>alert('글수정 실패!'); location.href='/contentForm?board_idx=" + board_idx + "';</script>";
			}
	}
	@RequestMapping("/deleteAction")
	@ResponseBody
	public String deleteAction(@RequestParam("board_idx") String board_idx, HttpServletRequest request) {
		int result = boardDao.deleteDto(board_idx);
		if ( result ==1) {
			System.out.println("글삭제 성공!");
			
			//return "redirect:listForm";
			return "<script>alert('글삭제 성공!'); location.href='/listForm';</script>";
		}else {
			System.out.println("글삭제 실패!");
			
			//return "redirect:contentForm?board_idx=" + board_idx;
			return "<script>alert('글삭제 실패!'); location.href='/contentForm?board_idx=" + board_idx + "';</script>";
		}
		
	}
	@RequestMapping("/deleteReplyAction")
	@ResponseBody
	public String deleteReplyAction(@RequestParam("reply_idx") String reply_idx, 
									@RequestParam("board_idx") String board_idx, 
								HttpServletRequest request) {
		int result = replyDao.reply_deleteDto(reply_idx);
		if ( result ==1) {
			System.out.println("댓글삭제 성공!");
			
			
			return "<script>alert('댓글삭제 성공!'); location.href='/contentForm?board_idx=" + board_idx + "';</script>";
		}else {
			System.out.println("댓글삭제 실패!");
			
			
			return "<script>alert('댓글삭제 실패!'); location.href='/contentForm?board_idx=" + board_idx + "';</script>";
		}
		
	}
	@RequestMapping("/likeAction")
	@ResponseBody
	public String likeAction(@RequestParam("board_idx") String board_idx, HttpServletRequest request) {
	    int result = boardDao.likes(board_idx); // 게시글에 좋아요 추가하는 메서드
	    if (result == 1) {
	        return "<script>alert('좋아요를 눌렀습니다!'); location.href='/contentForm?board_idx=" + board_idx + "';</script>";
	    } else {
	        return "<script>alert('이미 좋아요를 누르셨습니다!'); location.href='/contentForm?board_idx=" + board_idx + "';</script>";
	    }
	}
	@RequestMapping("/updateReplyAction")
	@ResponseBody
	public String updateReplyAction(@RequestParam("reply_idx") String reply_idx,
	                                @RequestParam("reply_content") String reply_content,
	                                @RequestParam("board_idx") String board_idx,
	                                HttpServletRequest request) {
	    int result = replyDao.reply_update(reply_idx, reply_content);
	    if (result == 1) {
	        System.out.println("댓글 수정 성공!");
	        return "<script>alert('댓글 수정 성공!'); location.href='/contentForm?board_idx=" + board_idx + "';</script>";
	    } else {
	        System.out.println("댓글 수정 실패!");
	        return "<script>alert('댓글 수정 실패!'); location.href='/contentForm?board_idx=" + board_idx + "';</script>";
	    }
	}
	@RequestMapping("/writeSubReplyAction")
	@ResponseBody
	public String writeSubReplyAction(@RequestParam("sub_reply_content") String sub_reply_content,@RequestParam("board_idx") String board_idx,
	        @RequestParam("sub_reply_name") String sub_reply_name,
	        @RequestParam("reply_idx") String reply_idx, HttpServletRequest request) {
	    int result = subReplyDao.sub_reply_write(sub_reply_name, sub_reply_content, reply_idx);
	    if (result == 1) {
	        System.out.println("대댓글 작성 성공!");
	        return "<script>alert('대댓글 작성 성공!'); location.href='/contentForm?board_idx=" + board_idx + "';</script>";
	    } else {
	        System.out.println("대댓글 작성 실패!");
	        return "<script>alert('대댓글 작성 실패!'); location.href='/contentForm?board_idx=" + board_idx + "';</script>";
	    }
	}
	@RequestMapping(value = "/uploadImage", method = RequestMethod.POST)
	@ResponseBody
	public String uploadImage(@RequestParam("imageFile") MultipartFile file,@RequestParam("board_idx") String board_idx, HttpServletRequest request) {
	    // 파일이 비어있지 않은지 확인
	    if (!file.isEmpty()) {
	        try {
	            
	            byte[] bytes = file.getBytes();
	           

	            return "<script>alert('이미지 업로드 성공!'); location.href='/contentForm?board_idx=" + board_idx + "';</script>";
	        } catch (IOException e) {
	            e.printStackTrace();
	            return "이미지 업로드 실패: " + e.getMessage();
	        }
	    } else {
	        return "선택된 이미지가 없습니다!";
	    }
	}
	@RequestMapping("/search")
	public String search(@RequestParam("query") String query, Model model) {
	    List<BoardDto> searchResults = boardDao.search(query);
	    model.addAttribute("searchResults", searchResults);
	    return "searchResults";
	}
}

