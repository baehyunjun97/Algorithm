def solution(price, money, count):
    
    answer = 0
    cost = 0
    
    for i in range(1,count+1):
        cost += i * price
    
    answer = cost - money
    
    if answer < 0:
        answer = 0
    
    return answer