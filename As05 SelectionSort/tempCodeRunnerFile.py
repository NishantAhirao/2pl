ls1 = []
print((ls1))
for j in range(len(ls1)):
    for i in range(0 , len(ls1)-1):
        temp = ls1[i]
        if (temp > ls1[i+1]):
            temp2 = ls1[i+1]
        else:
            continue
        
        ls1[i]= ls1[i+1]
        ls1[i+1]= temp 
    
        print(ls1)

print(ls1)