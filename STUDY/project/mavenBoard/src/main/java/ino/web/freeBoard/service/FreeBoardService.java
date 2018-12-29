package ino.web.freeBoard.service;

import ino.web.freeBoard.dto.FreeBoardDto;

import java.util.List;

public interface FreeBoardService {
		/** 자유게시판 리스트 */
		public List<FreeBoardDto> selectList(FreeBoardDto freeBoardDto);
		
		/** 자유게시판 상세 */
		public FreeBoardDto selectOne(int num);
		
		/** 마지막 게시물 가져오기 */
		public int getMaxCount();
		
		/** 총 게시물 수 가져오기 */
		public int getCount(FreeBoardDto freeBoardDto);
		
		/** 자유게시판 글쓰기 */
		public int insert(FreeBoardDto freeBoardDto);
		
		/** 자유게시판 수정하기 */
		public int update(FreeBoardDto freeBoardDto);
		
		/** 자유게시판 삭제하기 */
		public int delete(int num);
}