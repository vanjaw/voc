import random
import time

# test list
test_list = list()

# list size
list_size = 1000000;

# append list_size number of random values between 1 and 100
for i in range(list_size):
    test_list.append(random.randint(1, 100))

start = time.time()
test_list.sort()
finish = time.time()
print("Time: ", finish - start)
