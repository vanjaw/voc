import time

def test_reverse():
    test_list = list(range(100000000))

    start = time.time()

    test_list.reverse()

    end = time.time()

    return end - start

if __name__ == '__main__':
    print('Duration: {} s'.format(test_reverse()))