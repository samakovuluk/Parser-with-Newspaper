from bs4 import BeautifulSoup
from bs4.element import Comment
import urllib.request

class Com:

    def __init__(self,url):
        self.url=url
    def get_comment(self):
        html = urllib.request.urlopen(self.url)
        soup = BeautifulSoup(html,'lxml')
        try:
            soup=(soup.find('div', {'id':'comments'}))
            data = soup.findAll(text=True)
            p=""
            for i in (data):
                if(len(i.strip())>0):
                    print(i.strip())
                    p+=i.strip()+":"
            return (p)
        except:
            return ("None")

p=Com('https://habr.com/post/127584/')
print(p.get_comment())
        
