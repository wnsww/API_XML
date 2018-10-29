class Api_XML():
    #DB연결
    conn = MongoClient(“몽고DB 포트”)
    
    db = conn.get_database('stockData')
    
    #공공데이터 url
    url = 'http://api.seibro.or.kr/openapi/service/StockSvc/getShotnByMartN1'
    serviceKey = “인증키” 
    re = 999
    martTpcd = [11,12,13,14,50]
    nameTpcd = ['유가증권시장','코스닥','K-OTC','코넥스','기타시장']

    for no in range(len(martTpcd)):
        targetXML = url+serviceKey+'&martTpcd='+str(martTpcd[no])
        #db collection 생성,추가 
        
        if(db.get_collection(nameTpcd[no]) == None):
            db.create_collection(nameTpcd[no])
        else:
            Tpcdpath= db.get_collection(nameTpcd[no])
            Tpcdpath.find()
        
        
        #총결과 값
        xml = urlopen(targetXML)
        soup = BeautifulSoup(xml,  "html.parser")
        res = soup.find("response")
        body = res.find("body")
        totalCount = int(body.find("totalcount").text)
        print(totalCount)
        
        #totalCount만큼 결과값 받아오기
        
        van = 1
        numOfRows = 999 #페이지 결과값
        if(totalCount > numOfRows):
            van = totalCount//numOfRows+1
        for pageNo in range(van):
            Curl = url+serviceKey+'&martTpcd='+str(martTpcd[no])+'&pageNo='+str(pageNo+1)+'&numOfRows='+str(numOfRows)
            xml = urlopen(Curl)
            soup = BeautifulSoup(xml,  "html.parser")
            res = soup.find("response")
            body = res.find("body")
            print(nameTpcd[no])
            print(pageNo+1)
            
            for item in soup.find_all('item'):
                if(item.find('korsecnnm') == None or item.find('shotnisin') == None):
                    pass
                else:
                    print(str(item.find('korsecnnm').text).replace('.','')+"/"+item.find('shotnisin').text)
                    
                    result =Tpcdpath.insert_one({'korsecnnm':str(item.find('korsecnnm').text).replace('.',''),'shotnisin':item.find('shotnisin').text})

                    if(result.inserted_id == None):
                        print('저장되지않은 종목'+str(result))
                    else:
                        pass
