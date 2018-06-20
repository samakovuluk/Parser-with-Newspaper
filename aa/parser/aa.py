import os
import sys
import csv
pathname = os.path.dirname(sys.argv[0])+chr(92)
print(pathname)
sys.path.insert(0, pathname)
from newsapi import NewsApiClient
import re
import urllib.request
from bs4 import BeautifulSoup
 


from Com import Com
newsapi = NewsApiClient(api_key='8100b53ae7ac4e5f97fd4d053b6487b5')
#1 simple ever
#2 ever
#3 top
file=open('C:\\Users\\USK\\Desktop\\aa\\parser\\out.txt','r',encoding='UTF-8')
e=list()
for i in file:
    e.append(i.strip('\n'))


def comment(url):
    
    try:
        p=Com(url)
        print('-=-=-=-=-=-=-=-=-=-')
        return p.get_comment()
        print(p.get_comment())
    except:
        return ("None")
    return ""
if(e[0]=='1'):
    a=list()
    q=e[1][2:]
    #ad=(newsapi.get_everything(q='метод',from_param='2018-06-14',to='2018-03-05',page=i,page_size=100))
    for i in range(1,9999990):
        try:
            ad=(newsapi.get_everything(q,page=i,page_size=100))
            ad=ad['articles']
            for i in ad:
                if(i not in a):
                    a.append(i)
        except:
            break
        

    #a=filter(lambda x: x < 5, numbers)


    c=0

    with open('C:\\Users\\USK\\Desktop\\aa\\results.csv', 'w',encoding="utf-8") as csvfile:
        fieldnames = ['publishedAt','title', 'author','url','urlToImage','description','comment']
        writer = csv.DictWriter(csvfile, fieldnames=fieldnames)

        writer.writeheader()
        for i in a:
            c+=1
            '''print(i['publishedAt'])
            print(i['title'])
            print(i['author'])
            print(i['url'])
            print(i['urlToImage'])
            print(i['description'])
            print('-----------')
            print('-----------')'''
            try:
                html = urllib.request.urlopen(i['url'])
                soup = BeautifulSoup(html,'lxml')
                soup=(soup.find('div', {'id':'comments'}))
                data = soup.findAll(text=True)
                p=""
                for j in (data):
                    if(len(j)>80):
                        p=j
                        break
                print(p)
            except:
                print('--------')
            writer.writerow({'publishedAt': i['publishedAt'], 'title': i['title'], 'author': i['author'], 'url': i['url'], 'urlToImage': i['urlToImage'], 'description': i['description'],'comment':',m,'})
            
        
    print(c)

elif(e[0]=='3'):
    for i in file:
        e.append(i.strip('\n'))
    e.pop(0)
    d=dict()
    for i in e:
        t=i.split(':')
        if(t[1]=='None'):
            d[t[0]]=None
        else:
            d[t[0]]=t[1]

    print(d)
    
    a=list()
    #q=e[1][2:]
    q="banan"
    print(q)
    #ad=(newsapi.get_everything(q='метод',from_param='2018-06-14',to='2018-03-05',page=i,page_size=100))
    for i in range(1,9999990):
        try:
            ad=newsapi.get_top_headlines(q=d['q'],category=d['category'],language=d['language'],country=d['country'],page_size=100,page=i)

            ad=ad['articles']
            print(i)
            for i in ad:
                if(i not in a):
                    a.append(i)
        except:
            break
        

    #a=filter(lambda x: x < 5, numbers)


    c=0

    with open('C:\\Users\\USK\\Desktop\\aa\\parser\\names.csv', 'w',encoding="utf-8") as csvfile:
        fieldnames = ['publishedAt','title', 'author','url','urlToImage','description','comment']
        writer = csv.DictWriter(csvfile, fieldnames=fieldnames)

        writer.writeheader()
        for i in a:
            c+=1
            print(i['publishedAt'])
            print(i['title'])
            print(i['author'])
            print(i['url'])
            print(i['urlToImage'])
            print(i['description'])
            print('-----------')
            print('-----------')
            html = urllib.request.urlopen(i['url'])
            writer.writerow({'publishedAt': i['publishedAt'], 'title': i['title'], 'author': i['author'], 'url': i['url'], 'urlToImage': i['urlToImage'], 'description': i['description'],'comment':comment(html)})
            
        
    print(c)

elif(e[0]=='2'):
    for i in file:
        e.append(i.strip('\n'))
    e.pop(0)
    d=dict()
    for i in e:
        t=i.split(':')
        if(t[1]=='None'):
            d[t[0]]=None
        else:
            d[t[0]]=t[1]

    print(d)
    print("--------------")
    
    a=list()
    #q=e[1][2:]
    q="banan"
    print(q)
    #ad=(newsapi.get_everything(q='метод',from_param='2018-06-14',to='2018-03-05',page=i,page_size=100))
    for i in range(1,9999990):
        try:
            ad=newsapi.get_everything(q=d['q'],
                                      sources=d['sources'],
                                      domains=d['domain'],
                                      #from_parameter=d['date'],
                                      to=d['date'],
                                      language=d['language'],
                                      page_size=100,
                                      page=i)

            ad=ad['articles']
            print(i)
            for i in ad:
                if(i not in a):
                    a.append(i)
        except:
            break
        

    #a=filter(lambda x: x < 5, numbers)


    c=0

    with open('C:\\Users\\USK\\Desktop\\aa\\parser\\names.csv', 'w',encoding="utf-8") as csvfile:
        fieldnames = ['publishedAt','title', 'author','url','urlToImage','description','comment']
        writer = csv.DictWriter(csvfile, fieldnames=fieldnames)

        writer.writeheader()
        for i in a:
            c+=1
            print(i['publishedAt'])
            print(i['title'])
            print(i['author'])
            print(i['url'])
            print(i['urlToImage'])
            print(i['description'])
            print('-----------')
            print('-----------')
            html = urllib.request.urlopen(i['url'])
            writer.writerow({'publishedAt': i['publishedAt'], 'title': i['title'], 'author': i['author'], 'url': i['url'], 'urlToImage': i['urlToImage'], 'description': i['description'],'comment':comment(html)})
            
        
    print(c)


