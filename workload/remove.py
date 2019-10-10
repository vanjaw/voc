import time

def test_remove():
    my_list = list()

    for i in range(50000000):
        my_list.append(1)

    my_list.append(2)

    start = time.time()
    my_list.remove(2)
    finish = time.time()
    return (finish-start)

if __name__ == '__main__':
    print('Duration: {} s'.format(test_remove()))
