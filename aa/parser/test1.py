file=open('C:\\Users\\USK\\Desktop\\aa\\parser\\out.txt','r',encoding='UTF-8')
e=list()
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

print(type(d['q']))
