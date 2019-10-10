import slice
import sort
import reverse
import remove
import appendpop
import insert

if __name__ == '__main__':
    tests = {
        'slice': slice.test_slice,
        'sort':  sort.test_sort,
        'reverse': reverse.test_reverse,
        'remove': remove.test_remove,
        'appendpop': appendpop.test_appendpop,
        'insert': insert.test_insert
    }

    width = max([len(a) for a in tests]) + 2

    for name, test in tests.items():
        print('[{{:^{}}}] Duration: {} s'.format(width, test()).format(name))
