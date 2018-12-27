package com.bit.java;

import org.springframework.stereotype.Repository;

@Repository
//주식정보서비스(StockSvc)
public class StockSvc{
	

	//페이지 출력 결과값
	private int numOfRows = 50;
	//*Service Key*/
	private StringBuilder Key = new StringBuilder("JxtMZygjNXGZXV0NjqtD1Lpx56R%2F39ryIh2Akp998cATtP8coB6FDp0%2BtaAKKslq2EL1CWjWIDSJJZ4ZkRKbjw%3D%3D");
	
	
	
	/*		1)	종목명칭으로 주식종목코드 및 기본정보 조회
	 
	   주식 종목명칭을 기준으로 종목번호와 단축코드, 
	   주식종류 등 주식의 기본정보 조회*/
	public StringBuilder getStkIsinByNmN1(int pageNo,String secnNm) {
		 StringBuilder urlBuilder = new StringBuilder("http://api.seibro.or.kr/openapi/service/StockSvc/getStkIsinByNmN1?");
			
	     urlBuilder.append("ServiceKey="+Key);
	     //종목명
		 urlBuilder.append("&secnNm="+secnNm);
		 urlBuilder.append("&numOfRows="+numOfRows);
		 urlBuilder.append("&pageNo="+pageNo);
		 //json형식변환
		 urlBuilder.append("&__type=json");
		 
		  return urlBuilder;
	}
	
	/* 	2)	단축번호로 주식종목코드(풀코드) 조회
	  
	   단축번호를 기준으로 주식종목코드(풀코드) 및 종목명, 
	   발행일 등 주식 기본정보 조회 */
	public StringBuilder getStkIsinByShortIsin(int shortIsin) {
		StringBuilder urlBuilder = new StringBuilder("http://api.seibro.or.kr/openapi/service/StockSvc/getStkIsinByShortIsin?");
		  urlBuilder.append("ServiceKey="+Key);
		//단축코드
		urlBuilder.append("&shortIsin="+shortIsin);
	    
	        return urlBuilder;
	}
	
	/* 	3)	배당순위조회
	  
	   단축번호를 기준으로 주식종목코드(풀코드) 및 종목명, 
	   발행일 등 주식 기본정보 조회 */
	public StringBuilder getDividendRank(int pageNo,int stkTpcd,int listTpcd,int rankTpcd,int year) {
		StringBuilder urlBuilder = new StringBuilder("http://api.seibro.or.kr/openapi/service/StockSvc/getDividendRank?");
		/*Service Key*/
        urlBuilder.append("ServiceKey="+Key);
		//기준년도
		urlBuilder.append("&year="+year);
		//순위구분
		urlBuilder.append("&rankTpcd="+rankTpcd);
		//상장구분
		urlBuilder.append("&stkTpcd"+stkTpcd);
		//주식종류
		urlBuilder.append("&listTpcd="+listTpcd);
		//페이지번호
		urlBuilder.append("&pageNo="+pageNo);
		//결과값수
		urlBuilder.append("&numOfRows="+numOfRows);
		
		return urlBuilder;
	}
	
	/* 	4)	의무보호예수전체현황 전체현황표 조회
	  
	   조회기준일과 상장구분을 기준으로 의무보호예수주식주, 
	   보호예수비율 등 의무보호예수 전체현황 조회 */
	public StringBuilder getSafeDpDutyDepoStatus(int pageNo,int listTpcd,String stdDt) {
		StringBuilder urlBuilder = new StringBuilder("http://api.seibro.or.kr/openapi/service/StockSvc/getSafeDpDutyDepoStatus?");
		urlBuilder.append("ServiceKey="+Key);
		//기준일
		urlBuilder.append("&stdDt="+stdDt);
		//상장구분
		urlBuilder.append("&listTpcd="+listTpcd);
		//페이지번호
		urlBuilder.append("&pageNo="+pageNo);
		//결과값수
		urlBuilder.append("&numOfRows="+numOfRows);
		  return urlBuilder;
	}
	
	/* 	5)	의무보호예수전체현황 사유별 조회
	  
	   상장구분과 기준일을 이용하여 의무보호예수 사유, 
	   기업수, 종목수 등 의무보호예수 정보 조회 */
	public StringBuilder getSafeDpDutyDepoRgtStatus(int listTpcd,String stdDt) {
		StringBuilder urlBuilder = new StringBuilder("http://api.seibro.or.kr/openapi/service/StockSvc/getSafeDpDutyDepoRgtStatus?");
		urlBuilder.append("ServiceKey="+Key);
		//기준일
		urlBuilder.append("&stdDt="+stdDt);
		//상장구분
		urlBuilder.append("&listTpcd="+listTpcd);
		
		  return urlBuilder;
	}
	
	/* 	6)	신규예탁지정종목조회
	  
	   예탁지정 여부와 조회기준연월을 기준으로 예탁지정(취소)일자, 
	   해당 종목코드 등 예탁지정(취소)종목 조회 */
	public StringBuilder getNewDepoSecnList(String yyyymm,int searchType,int issucoCustno,int pageNo) {
		StringBuilder urlBuilder = new StringBuilder("http://api.seibro.or.kr/openapi/service/StockSvc/getNewDepoSecnList?");
		urlBuilder.append("ServiceKey="+Key);
		//조회년월
		urlBuilder.append("&yyyymm="+yyyymm);
		//조회구분
		urlBuilder.append("&searchType="+searchType);
		//발행회사번호
		urlBuilder.append("&issucoCustno="+issucoCustno);
		urlBuilder.append("&numOfRows="+numOfRows);
		urlBuilder.append("&pageNo="+pageNo);
		
		return urlBuilder;
	}
	
	/* 	7)	상장구분별 현황조회
	  
	   조회 기준일자를 기준으로 시장별, 증권구분별 발행주식수, 
	   시가총액 등 주식 발행 현황조회 */
	public StringBuilder getListStatN1(String stdDt,int pageNo) {
		StringBuilder urlBuilder = new StringBuilder("http://api.seibro.or.kr/openapi/service/StockSvc/getListStatN1?");
		urlBuilder.append("ServiceKey="+Key);
		//조회 기준일자
		urlBuilder.append("&stdDt="+stdDt);
		 urlBuilder.append("&numOfRows="+numOfRows);
		 urlBuilder.append("&pageNo="+pageNo);
		return urlBuilder;
	}
	
	/*		8)	주식상장정보 조회
	  
	   종목번호를 기준으로 상장(폐지)일자, 
	   종목번호 등 주식상장정보 조회 */
	public StringBuilder getStkListInfoN1(String isin,int pageNo) {
		StringBuilder urlBuilder = new StringBuilder("http://api.seibro.or.kr/openapi/service/StockSvc/getStkListInfoN1?");
		urlBuilder.append("ServiceKey="+Key);
		//표준코드
		urlBuilder.append("&isin="+isin);
		 urlBuilder.append("&numOfRows="+numOfRows);
		 urlBuilder.append("&pageNo="+pageNo);
		return urlBuilder;
	}
	
	/*		9)	주식관련사채정보 조회
	  
	   채권 종목번호를 기준으로 신주인수권 행사가격, 행사비율, 
	   행사주식종목명 등 주식관련사채 정보 조회*/
	public StringBuilder getXrcStkStatInfoN1(String bondIsin,int pageNo) {
		StringBuilder urlBuilder = new StringBuilder("http://api.seibro.or.kr/openapi/service/StockSvc/getXrcStkStatInfoN1?");
		urlBuilder.append("ServiceKey="+Key);
		//표준코드
		urlBuilder.append("&bondIsin="+bondIsin);
		urlBuilder.append("&numOfRows="+numOfRows);
		urlBuilder.append("&pageNo="+pageNo);
		return urlBuilder;
	}
	
	/*		10)	주식관련사채 행사조건정보 조회
	  
	   채권 종목번호를 기준으로 대행기관, 단주대금계산, 
	   주권교부일 등 주식관련사채 행사조건정보 조회*/
	public StringBuilder getXrcStkOptionXrcInfoN1(String bondIsin,int pageNo) {
		StringBuilder urlBuilder = new StringBuilder("http://api.seibro.or.kr/openapi/service/StockSvc/getXrcStkOptionXrcInfoN1?");
		urlBuilder.append("ServiceKey="+Key);
		//표준코드
		urlBuilder.append("&bondIsin="+bondIsin);
		urlBuilder.append("&numOfRows="+numOfRows);
		urlBuilder.append("&pageNo="+pageNo);
		return urlBuilder;
	}
	
	/*		11)	신주인수권증서 정보 조회
	  
	   시장구분을 기준으로 대행기관, 증서발행기간, 상장일, 
	   신주발행가격 등 신주인수권증서 정보 조회*/
	public StringBuilder getDocInfoN1(int martTpcd,int pageNo) {
		StringBuilder urlBuilder = new StringBuilder("http://api.seibro.or.kr/openapi/service/StockSvc/getDocInfoN1?");
		urlBuilder.append("ServiceKey="+Key);
		//표준코드
		urlBuilder.append("&martTpcd="+martTpcd);
		urlBuilder.append("&numOfRows="+numOfRows);
		urlBuilder.append("&pageNo="+pageNo);
		return urlBuilder;
	}
	/*	12)	신주인수권증권 정보 조회
	  
	   조회기준일을 이용하여 기준일 시점에서 유효한 신주인수권증권 종목번호, 
	   발행일자 등 신주인수권증권 정보 조회*/
	public StringBuilder getWrtInfoN1(int stdDt,int pageNo) {
		StringBuilder urlBuilder = new StringBuilder("http://api.seibro.or.kr/openapi/service/StockSvc/getWrtInfoN1?");
		urlBuilder.append("ServiceKey="+Key);
		//표준코드
		urlBuilder.append("&stdDt="+stdDt);
		urlBuilder.append("&numOfRows="+numOfRows);
		urlBuilder.append("&pageNo="+pageNo);
		return urlBuilder;
	}
	
	/*	13)	시장별 단축코드 전체 조회
	  
	   시장구분을 기준으로 단축종목번호와 종목명 조회*/
	public StringBuilder getShotnByMartN1(int martTpcd,int pageNo) {
		StringBuilder urlBuilder = new StringBuilder("http://api.seibro.or.kr/openapi/service/StockSvc/getShotnByMartN1?");
		urlBuilder.append("ServiceKey="+Key);
		//표준코드
		urlBuilder.append("&martTpcd="+martTpcd);
		urlBuilder.append("&numOfRows="+numOfRows);
		urlBuilder.append("&pageNo="+pageNo);
		//시작페이지 지정
		urlBuilder.append("&startPage="+1);
		return urlBuilder;
	}
}
