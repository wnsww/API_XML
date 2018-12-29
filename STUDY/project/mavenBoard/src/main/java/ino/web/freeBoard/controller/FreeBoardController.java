package ino.web.freeBoard.controller;

import ino.web.freeBoard.dto.FreeBoardDto;
import ino.web.freeBoard.dto.Pagination;
import ino.web.freeBoard.service.FreeBoardService;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/freeboard")
public class FreeBoardController {
	@Resource(name="freeboard")
	private FreeBoardService board;
	
	@RequestMapping(value="/main.ino")
	public ModelAndView selectList(Pagination pagination, HttpServletRequest request) {
		ModelAndView view = new ModelAndView();
		FreeBoardDto dto =  new FreeBoardDto();
		String url = request.getRequestURI();
		String keyword = pagination.getKeyword();
		String keyOption = pagination.getKeyOption();
		System.out.println("검색 : "+keyword+"/"+keyOption);
		dto.setKeyOption(keyOption);
		dto.setKeyword(keyword);
		
		if(keyOption =="num"){
			dto.setKeyWordInt(Integer.parseInt(keyword));
		}
		
		int totalCount = board.getCount(dto);
		pagination.setEndPage(totalCount);
		pagination.setUrl(url);
		
		view.setViewName("defaultmain");
		int start = pagination.getStart();
		int end = pagination.getEnd();
		dto.setFowardpage(start);
		dto.setEndpage(end);
		List<FreeBoardDto> list = board.selectList(dto);
		view.addObject("list", list);
		view.addObject("page", pagination);
		return view;
	}
	@RequestMapping(value="/detail.ino")//상세
	public ModelAndView detail(int num) {
		FreeBoardDto list = board.selectOne(num);
		return new ModelAndView("detail" ,"dto" ,list);
	}
	@RequestMapping(value="/insertPro.ino")//추가 수행
	public ModelAndView insertPro(FreeBoardDto dto) {
		board.insert(dto);
		int num = board.getMaxCount();
		return new ModelAndView("redirect:/freeboard/detail.ino?num="+num);
	}
	@RequestMapping(value="/insert.ino")//추가 단순이동
	public String insert() {
		return "insert";
	}
	@RequestMapping(value="/update.ino")//수정
	public ModelAndView update(FreeBoardDto dto) {
		board.update(dto);
		return new ModelAndView("redirect:/freeboard/main.ino");
	}
	@RequestMapping(value="/delete.ino")//삭제
	public ModelAndView delete(int num) {
		board.delete(num);
		return new ModelAndView("redirect:/freeboard/main.ino");
	}
}