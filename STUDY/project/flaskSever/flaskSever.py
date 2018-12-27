from pymongo import MongoClient
from flask import Flask
from flask import render_template
from flask import request
from flask import redirect
from bson import objectid

app = Flask(__name__)

@app.route('/')
def intro():
    return 'hi'

@app.route('/do')
def re():
    return 'hi'

@app.route('/MemberInfo.do')
def info():
    
        try:
            _id = request.args.get('_id')
            
            client = MongoClient('localhost', 27017)
            db = client.bit
            collection = db.member
            
            result = collection.find_one({'_id':objectid(_id)})
       
            return render_template("Member.html" ,data=result)
    
        except Exception as e:
            return redirect('http://203.236.209.139:9090/hi.do')
        finally:
            client.close()
    
@app.route('/MemberInsert.do',methods=['POST'])
def insert():
    try:
        
        id = request.form['id']
        pwd = request.form['pwd']
        name = request.form['name']
        age = request.form['age']
        tel = request.form['tel']
        
        m = {'id':id,'pwd':pwd,'name':name,'age':age,'tel':tel}
        
        client = MongoClient('localhost', 27017)
        db = client.bit
        collection = db.member
        
        _id = collection.insert_one(m).inserted_id
        
        return redirect('/MemberInfo.do?_id='+_id)
    
    except Exception as e:
        return redirect('http://203.236.209.139:9090/.do')
    finally:
        client.close()
        
@app.route('/MemberFpush.do')
def delete():
    try:
        id = request.args.get('_id')
        
        client = MongoClient('localhost', 27017)
        db = client.bit
        collection = db.member
        
        collection.delete_one({'_id':objectid(id)})
        
        return redirect('http://203.236.209.139:9090/hi.do')
    except Exception as e:
        return redirect('http://203.236.209.139:9090/.do')
    finally:
        client.close()

'''member concern type'''
@app.route('/MemberFpush.do')
def push():
    try:
        uid = request.args.get('_id')
        Isin = request.args.get('Isin')
        
        client = MongoClient('localhost', 27017)
        db = client.bit
        collection = db.member
        
        _id = collection.update_one({'_id':objectid(uid)},{'$push':{'Isin':Isin}}).updated_id
        
        return redirect('/MemberInfo.do?_id='+_id)
    
    except Exception as e:
        return redirect('http://203.236.209.139:9090/.do')
    finally:
        client.close()
    
    
    
''' '''
@app.route('/Memberupdate.do',methods=['POST'])
def set():
    try:
        uid = request.form['_id']
        id = request.form['id']
        pwd = request.form['pwd']
        name = request.form['name']
        age = request.form['age']
        tel = request.form['tel']
        
        client = MongoClient('localhost', 27017)
        db = client.bit
        collection = db.member
        
        m = {'id':id,'pwd':pwd,'name':name,'age':age,'tel':tel}
        
        _id = collection.update_one({{'_id':objectid(uid)},{'$set':m}}).updated_id
        
        return redirect('/MemberInfo.do?_id='+_id)
    
    except Exception as e:
        return redirect('http://203.236.209.139:9090/.do')
    finally:
        client.close()
    

if __name__ == '__main__':
    app.run(host="203.236.209.139",port=9090)