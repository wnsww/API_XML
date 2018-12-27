from pymongo import MongoClient
from flask import Flask
from flask import render_template
from flask import request
from flask import redirect
app = Flask(__name__)

@app.route('/')
def intro():
    return 'hi'

@app.route('/MemberInfo.do')
def info():

    return render_template("Member.html")

if __name__ == '__main__':
    app.run(host="203.236.209.139",port=9050)