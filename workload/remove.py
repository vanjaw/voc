import time

my_list = list()

for i in range(30000000):
    my_list.append(1)

my_list.append(2)

start = time.time()
my_list.remove(2)
finish = time.time()
print("Time: ", finish - start)

