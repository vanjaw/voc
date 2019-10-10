import time

def test_remove():
    my_list = list()

    for i in range(3000000):
        my_list.append(1)

    start = time.time()
    for i in range(500):
        my_list.remove(1)
    finish = time.time()
    return (finish-start)

if __name__ == '__main__':
    print('Duration: {} s'.format(test_remove()))
