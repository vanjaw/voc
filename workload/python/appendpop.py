import time

def test_appendpop():
    test_list = list(range(100))

    start_time = time.time()

    for i in range(10000000):
        test_list.append(i)

    for i in range(10000000):
        test_list.pop()

    end_time = time.time()

    return end_time - start_time

if __name__ == '__main__':
    print('Duration: {} s'.format(test_appendpop()))
