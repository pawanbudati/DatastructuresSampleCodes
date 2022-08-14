for _ in range(int(input())):
    s=input()
    if(s[-1] in "AEIOUaeiou"):
        print(f'Case #{_+1}: {s} is ruled by Alice.')
    elif(s[-1] in 'yY'):
        print(f'Case #{_+1}: {s} is ruled by nobody.')
    else:
        print(f'Case #{_+1}: {s} is ruled by Bob.')