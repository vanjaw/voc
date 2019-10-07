import time

def test_slice():
    test_list = list(range(8000))

    start = time.time()

    # Head truncation
    for i in range(len(test_list)):
        test_list[i:]

    # Tail truncation
    for i in range(len(test_list)):
        test_list[:-i]

    # Head and tail trunction
    for i in range(len(test_list) // 2):
        test_list[i:-i]

    # Reversed head truncation
    for i in range(len(test_list)):
        test_list[i::-1]

    # Reversed tail truncation
    for i in range(len(test_list)):
        test_list[:-i:-1]

    # Step size
    for i in range(1, len(test_list)):
        test_list[::i]

    # Reversed step size
    for i in range(1, len(test_list)):
        test_list[::-i]

    end = time.time()

    return end - start

if __name__ == '__main__':
    print("Duration:", test_slice(), "s")