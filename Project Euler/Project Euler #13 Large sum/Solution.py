# Enter your code here. Read input from STDIN. Print output to STDOUT
n=int(input())
sum=0;
for i in range(n):
    sum += int(input())
k = str(sum)
print(k[:10])
