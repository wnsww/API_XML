package ino.web.freeBoard.dto;

import org.apache.ibatis.type.Alias;

@Alias("dto")
public class FreeBoardDto {
	//
	private int num;
	private String name;
	private String title;
	private String content;
	private String regdate;
	//페이징 
	private int firstpage;//page
	private int lastpage;//page
	private int curpage;//page
	private int totalpage;//page
	
	private int fowardpage;//sql
	private int endpage;//sql
	
	private String keyOption;//sql
	private String keyword;//sql
	private int keyWordInt;//sql
	
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public int getKeyWordInt() {
		return keyWordInt;
	}
	public void setKeyWordInt(int keyWordInt) {
		this.keyWordInt = keyWordInt;
	}
	public String getKeyOption() {
		return keyOption;
	}
	public void setKeyOption(String keyOption) {
		this.keyOption = keyOption;
	}
	public int getFirstpage() {
		return firstpage;
	}
	public void setFirstpage(int firstpage) {
		this.firstpage = firstpage;
	}
	public int getLastpage() {
		return lastpage;
	}
	public void setLastpage(int lastpage) {
		this.lastpage = lastpage;
	}
	public int getCurpage() {
		return curpage;
	}
	public void setCurpage(int curpage) {
		this.curpage = curpage;
	}
	public int getFowardpage() {
		return fowardpage;
	}
	public void setFowardpage(int fowardpage) {
		this.fowardpage = fowardpage;
	}
	public int getEndpage() {
		return endpage;
	}
	public void setEndpage(int endpage) {
		this.endpage = endpage;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public int getTotalpage() {
		return totalpage;
	}
	public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}

}