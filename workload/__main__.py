import slice
import sort
import reverse
import remove

if __name__ == '__main__':
    tests = {
        'slice': slice.test_slice,
        'sort':  sort.test_sort,
        'reverse': reverse.test_reverse,
        'remove': remove.test_remove
    }

    width = max([len(a) for a in tests]) + 2

    for name, test in tests.items():
        print('[{{:^{}}}] Duration: {} s'.format(width, test()).format(name))
