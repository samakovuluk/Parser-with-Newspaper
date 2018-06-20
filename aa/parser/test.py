import os
import sys
import csv
pathname = os.path.dirname(sys.argv[0])+chr(92)
print(pathname)
sys.path.insert(0, pathname)
from newsapi import NewsApiClient
newsapi = NewsApiClient(api_key='8100b53ae7ac4e5f97fd4d053b6487b5')

file=open('C:\\Users\\USK\\Desktop\\aa\\parser\\out.txt','r',encoding='UTF-8')
e=list()
for i in file:
    e.append(i.strip('\n'))
if('1'=='1'):
    a=list()
    #q=e[1][2:]
    q="banan"
    print(q)
    #ad=(newsapi.get_everything(q='метод',from_param='2018-06-14',to='2018-03-05',page=i,page_size=100))
    for i in range(1,9999990):
        try:
            ad=newsapi.get_top_headlines(q='bitcoin',
                                          
                                          category='business',
                                          language='en',
                                          country='us',
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
        fieldnames = ['publishedAt','title', 'author','url','urlToImage','description']
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
            
            writer.writerow({'publishedAt': i['publishedAt'], 'title': i['title'], 'author': i['author'], 'url': i['url'], 'urlToImage': i['urlToImage'], 'description': i['description']})
            
        
    print(c)
