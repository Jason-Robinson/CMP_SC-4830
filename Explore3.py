#No type casting required for variables
meal = 44.50
tax = 0.0675
tip = 0.15

#arithmetic is the same as C
meal = meal + meal * tax

total = meal + meal * tip
print("%.2f" % total)
