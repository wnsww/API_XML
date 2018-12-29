package ino.web.freeBoard.service.impl;

import ino.web.freeBoard.dto.FreeBoardDto;
import ino.web.freeBoard.service.FreeBoardService;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("freeboard")
public class FreeBoardServiceImpl implements FreeBoardService {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public List<FreeBoardDto> selectList(FreeBoardDto freeBoardDto) {
		// TODO Auto-generated method stub
		List<FreeBoardDto> list = sqlSessionTemplate.selectList("selectList" ,freeBoardDto);
		return list;
	}

	@Override
	public FreeBoardDto selectOne(int num) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("selectOne", num);
	}

	@Override
	public int getMaxCount() {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("getMaxCount");
	}
	
	@Override
	public int getCount(FreeBoardDto freeBoardDto) {
		// TODO Auto-generated method stub
		System.out.println(freeBoardDto.getKeyword());
		return sqlSessionTemplate.selectOne("getCount" , freeBoardDto);
	}

	@Override
	public int insert(FreeBoardDto freeBoardDto) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.insert("insert",freeBoardDto);
	}

	@Override
	public int update(FreeBoardDto freeBoardDto) {
		// TODO Auto-generated method stub
		return  sqlSessionTemplate.update("update",freeBoardDto);
	}

	@Override
	public int delete(int num) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.delete("delete" ,num);
	}
}