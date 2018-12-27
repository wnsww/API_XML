package com.bit.java;

import org.springframework.stereotype.Repository;

@Repository
//�ֽ���������(StockSvc)
public class StockSvc{
	

	//������ ��� �����
	private int numOfRows = 50;
	//*Service Key*/
	private StringBuilder Key = new StringBuilder("JxtMZygjNXGZXV0NjqtD1Lpx56R%2F39ryIh2Akp998cATtP8coB6FDp0%2BtaAKKslq2EL1CWjWIDSJJZ4ZkRKbjw%3D%3D");
	
	
	
	/*		1)	�����Ī���� �ֽ������ڵ� �� �⺻���� ��ȸ
	 
	   �ֽ� �����Ī�� �������� �����ȣ�� �����ڵ�, 
	   �ֽ����� �� �ֽ��� �⺻���� ��ȸ*/
	public StringBuilder getStkIsinByNmN1(int pageNo,String secnNm) {
		 StringBuilder urlBuilder = new StringBuilder("http://api.seibro.or.kr/openapi/service/StockSvc/getStkIsinByNmN1?");
			
	     urlBuilder.append("ServiceKey="+Key);
	     //�����
		 urlBuilder.append("&secnNm="+secnNm);
		 urlBuilder.append("&numOfRows="+numOfRows);
		 urlBuilder.append("&pageNo="+pageNo);
		 //json���ĺ�ȯ
		 urlBuilder.append("&__type=json");
		 
		  return urlBuilder;
	}
	
	/* 	2)	�����ȣ�� �ֽ������ڵ�(Ǯ�ڵ�) ��ȸ
	  
	   �����ȣ�� �������� �ֽ������ڵ�(Ǯ�ڵ�) �� �����, 
	   ������ �� �ֽ� �⺻���� ��ȸ */
	public StringBuilder getStkIsinByShortIsin(int shortIsin) {
		StringBuilder urlBuilder = new StringBuilder("http://api.seibro.or.kr/openapi/service/StockSvc/getStkIsinByShortIsin?");
		  urlBuilder.append("ServiceKey="+Key);
		//�����ڵ�
		urlBuilder.append("&shortIsin="+shortIsin);
	    
	        return urlBuilder;
	}
	
	/* 	3)	��������ȸ
	  
	   �����ȣ�� �������� �ֽ������ڵ�(Ǯ�ڵ�) �� �����, 
	   ������ �� �ֽ� �⺻���� ��ȸ */
	public StringBuilder getDividendRank(int pageNo,int stkTpcd,int listTpcd,int rankTpcd,int year) {
		StringBuilder urlBuilder = new StringBuilder("http://api.seibro.or.kr/openapi/service/StockSvc/getDividendRank?");
		/*Service Key*/
        urlBuilder.append("ServiceKey="+Key);
		//���س⵵
		urlBuilder.append("&year="+year);
		//��������
		urlBuilder.append("&rankTpcd="+rankTpcd);
		//���屸��
		urlBuilder.append("&stkTpcd"+stkTpcd);
		//�ֽ�����
		urlBuilder.append("&listTpcd="+listTpcd);
		//��������ȣ
		urlBuilder.append("&pageNo="+pageNo);
		//�������
		urlBuilder.append("&numOfRows="+numOfRows);
		
		return urlBuilder;
	}
	
	/* 	4)	�ǹ���ȣ������ü��Ȳ ��ü��Ȳǥ ��ȸ
	  
	   ��ȸ�����ϰ� ���屸���� �������� �ǹ���ȣ�����ֽ���, 
	   ��ȣ�������� �� �ǹ���ȣ���� ��ü��Ȳ ��ȸ */
	public StringBuilder getSafeDpDutyDepoStatus(int pageNo,int listTpcd,String stdDt) {
		StringBuilder urlBuilder = new StringBuilder("http://api.seibro.or.kr/openapi/service/StockSvc/getSafeDpDutyDepoStatus?");
		urlBuilder.append("ServiceKey="+Key);
		//������
		urlBuilder.append("&stdDt="+stdDt);
		//���屸��
		urlBuilder.append("&listTpcd="+listTpcd);
		//��������ȣ
		urlBuilder.append("&pageNo="+pageNo);
		//�������
		urlBuilder.append("&numOfRows="+numOfRows);
		  return urlBuilder;
	}
	
	/* 	5)	�ǹ���ȣ������ü��Ȳ ������ ��ȸ
	  
	   ���屸�а� �������� �̿��Ͽ� �ǹ���ȣ���� ����, 
	   �����, ����� �� �ǹ���ȣ���� ���� ��ȸ */
	public StringBuilder getSafeDpDutyDepoRgtStatus(int listTpcd,String stdDt) {
		StringBuilder urlBuilder = new StringBuilder("http://api.seibro.or.kr/openapi/service/StockSvc/getSafeDpDutyDepoRgtStatus?");
		urlBuilder.append("ServiceKey="+Key);
		//������
		urlBuilder.append("&stdDt="+stdDt);
		//���屸��
		urlBuilder.append("&listTpcd="+listTpcd);
		
		  return urlBuilder;
	}
	
	/* 	6)	�űԿ�Ź����������ȸ
	  
	   ��Ź���� ���ο� ��ȸ���ؿ����� �������� ��Ź����(���)����, 
	   �ش� �����ڵ� �� ��Ź����(���)���� ��ȸ */
	public StringBuilder getNewDepoSecnList(String yyyymm,int searchType,int issucoCustno,int pageNo) {
		StringBuilder urlBuilder = new StringBuilder("http://api.seibro.or.kr/openapi/service/StockSvc/getNewDepoSecnList?");
		urlBuilder.append("ServiceKey="+Key);
		//��ȸ���
		urlBuilder.append("&yyyymm="+yyyymm);
		//��ȸ����
		urlBuilder.append("&searchType="+searchType);
		//����ȸ���ȣ
		urlBuilder.append("&issucoCustno="+issucoCustno);
		urlBuilder.append("&numOfRows="+numOfRows);
		urlBuilder.append("&pageNo="+pageNo);
		
		return urlBuilder;
	}
	
	/* 	7)	���屸�к� ��Ȳ��ȸ
	  
	   ��ȸ �������ڸ� �������� ���庰, ���Ǳ��к� �����ֽļ�, 
	   �ð��Ѿ� �� �ֽ� ���� ��Ȳ��ȸ */
	public StringBuilder getListStatN1(String stdDt,int pageNo) {
		StringBuilder urlBuilder = new StringBuilder("http://api.seibro.or.kr/openapi/service/StockSvc/getListStatN1?");
		urlBuilder.append("ServiceKey="+Key);
		//��ȸ ��������
		urlBuilder.append("&stdDt="+stdDt);
		 urlBuilder.append("&numOfRows="+numOfRows);
		 urlBuilder.append("&pageNo="+pageNo);
		return urlBuilder;
	}
	
	/*		8)	�ֽĻ������� ��ȸ
	  
	   �����ȣ�� �������� ����(����)����, 
	   �����ȣ �� �ֽĻ������� ��ȸ */
	public StringBuilder getStkListInfoN1(String isin,int pageNo) {
		StringBuilder urlBuilder = new StringBuilder("http://api.seibro.or.kr/openapi/service/StockSvc/getStkListInfoN1?");
		urlBuilder.append("ServiceKey="+Key);
		//ǥ���ڵ�
		urlBuilder.append("&isin="+isin);
		 urlBuilder.append("&numOfRows="+numOfRows);
		 urlBuilder.append("&pageNo="+pageNo);
		return urlBuilder;
	}
	
	/*		9)	�ֽİ��û�ä���� ��ȸ
	  
	   ä�� �����ȣ�� �������� �����μ��� ��簡��, ������, 
	   ����ֽ������ �� �ֽİ��û�ä ���� ��ȸ*/
	public StringBuilder getXrcStkStatInfoN1(String bondIsin,int pageNo) {
		StringBuilder urlBuilder = new StringBuilder("http://api.seibro.or.kr/openapi/service/StockSvc/getXrcStkStatInfoN1?");
		urlBuilder.append("ServiceKey="+Key);
		//ǥ���ڵ�
		urlBuilder.append("&bondIsin="+bondIsin);
		urlBuilder.append("&numOfRows="+numOfRows);
		urlBuilder.append("&pageNo="+pageNo);
		return urlBuilder;
	}
	
	/*		10)	�ֽİ��û�ä ����������� ��ȸ
	  
	   ä�� �����ȣ�� �������� ������, ���ִ�ݰ��, 
	   �ֱǱ����� �� �ֽİ��û�ä ����������� ��ȸ*/
	public StringBuilder getXrcStkOptionXrcInfoN1(String bondIsin,int pageNo) {
		StringBuilder urlBuilder = new StringBuilder("http://api.seibro.or.kr/openapi/service/StockSvc/getXrcStkOptionXrcInfoN1?");
		urlBuilder.append("ServiceKey="+Key);
		//ǥ���ڵ�
		urlBuilder.append("&bondIsin="+bondIsin);
		urlBuilder.append("&numOfRows="+numOfRows);
		urlBuilder.append("&pageNo="+pageNo);
		return urlBuilder;
	}
	
	/*		11)	�����μ������� ���� ��ȸ
	  
	   ���屸���� �������� ������, ��������Ⱓ, ������, 
	   ���ֹ��డ�� �� �����μ������� ���� ��ȸ*/
	public StringBuilder getDocInfoN1(int martTpcd,int pageNo) {
		StringBuilder urlBuilder = new StringBuilder("http://api.seibro.or.kr/openapi/service/StockSvc/getDocInfoN1?");
		urlBuilder.append("ServiceKey="+Key);
		//ǥ���ڵ�
		urlBuilder.append("&martTpcd="+martTpcd);
		urlBuilder.append("&numOfRows="+numOfRows);
		urlBuilder.append("&pageNo="+pageNo);
		return urlBuilder;
	}
	/*	12)	�����μ������� ���� ��ȸ
	  
	   ��ȸ�������� �̿��Ͽ� ������ �������� ��ȿ�� �����μ������� �����ȣ, 
	   �������� �� �����μ������� ���� ��ȸ*/
	public StringBuilder getWrtInfoN1(int stdDt,int pageNo) {
		StringBuilder urlBuilder = new StringBuilder("http://api.seibro.or.kr/openapi/service/StockSvc/getWrtInfoN1?");
		urlBuilder.append("ServiceKey="+Key);
		//ǥ���ڵ�
		urlBuilder.append("&stdDt="+stdDt);
		urlBuilder.append("&numOfRows="+numOfRows);
		urlBuilder.append("&pageNo="+pageNo);
		return urlBuilder;
	}
	
	/*	13)	���庰 �����ڵ� ��ü ��ȸ
	  
	   ���屸���� �������� ���������ȣ�� ����� ��ȸ*/
	public StringBuilder getShotnByMartN1(int martTpcd,int pageNo) {
		StringBuilder urlBuilder = new StringBuilder("http://api.seibro.or.kr/openapi/service/StockSvc/getShotnByMartN1?");
		urlBuilder.append("ServiceKey="+Key);
		//ǥ���ڵ�
		urlBuilder.append("&martTpcd="+martTpcd);
		urlBuilder.append("&numOfRows="+numOfRows);
		urlBuilder.append("&pageNo="+pageNo);
		//���������� ����
		urlBuilder.append("&startPage="+1);
		return urlBuilder;
	}
}
