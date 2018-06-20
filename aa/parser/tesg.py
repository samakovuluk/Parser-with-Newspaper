import os
from bs4 import BeautifulSoup
from bs4.element import Comment
import urllib.request
import sys
import csv
pathname = os.path.dirname(sys.argv[0])+chr(92)
print(pathname)
sys.path.insert(0, pathname)
from newsapi import NewsApiClient
import re
import urllib.request
from bs4 import BeautifulSoup
url="https://habr.com/post/127584/"
html = urllib.request.urlopen(url)
soup = BeautifulSoup(html,'lxml')
p=""
try:
    soup=(soup.find('div', {'id':'comments'}))
    data = soup.findAll(text=True)
                
    for i in (data):
        p+=(i.strip())+':'

except:
    p= ("None")
            
print(p.strip())
