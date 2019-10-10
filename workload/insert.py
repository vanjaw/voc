import time

def test_insert():
    start = time.time()

    L = []

    for x in range(72000):
        L.insert(0,x)

    finish = time.time()

    return finish - start

if __name__ == '__main__':
    print('Duration: {} s'.format(test_insert()))