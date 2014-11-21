#No type casting required for variables
meal = 44.50
tax = 0.0675
tip = 0.15

#arithmetic is the same as C
meal = meal + meal * tax

total = meal + meal * tip
print("%.2f" % total)

def counter(n):
#can declare more than one variable of same type
     a, b = 1, 2
     while a < n:
         print(a, end=' ')
         a, b = b, a+b
     print()
counter(500)
