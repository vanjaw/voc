# Conjectures
## Remove
### The times
![Profiler for original](ProfilerRemoveArrayList.png)
The the workload was two steps, first adding 50.000 numbers and then removing them one by one from the first index. The second step was adding 50.000 new numbers and the removing them in the reverse order i.e. from the last index. The time we got was around 1.192 seconds for our remove operations, where in the List implementation around 500ms was using the ArrayList.remove, 400ms using the cmp and 200ms was selftime. 

### What to improve
The most time was spent just removing the elements from the list. Since we cant change the datatypes, the compare have to stay. If we look at different List types, ArrayList has a `O(n)` for removes in the list except for remvoing the last element where it is `O(1)`. LinkedList also has a `O(n)` complexity for removing in the list, however removing first OR last element from the list results in a `O(1)` complexity. Since removing the first element is a common operation it might be worth changing to.

### Our new results
![Profiler for Updated](ProfilerRemoveLinkedList.png)
After changing the List type we got a slight improvement, going down to ~950ms. The improvement was in the remove (compare and self-time staying the same), going from ~500ms to ~250ms cutting the times in half.  


## Slice
The workload for slice tests for head truncation, tail truncation, head and tail truncation, reversed head truncation, reversed tail truncation, slice given a step size and finally reversed step size slice. 

### 
Testing the python implentation of the workload gave an average of 0.722780s after 10 test runs.

Testing the java implementation of the workload gave an average of 3.0007s after 10 test runs. 

### Times

Using a profiler, the following image highlights where most time is spent: 

![Profile for original implementation](ProfilerSlice.png)

The addition of elements is the most time consuming part of the slice operation, with retrieving elements being in second place. Both operations are part of the construction of the new sliced list.

### Alternate implementation

The current implementation of `__getitem__` builds a new list each time a slice operation is performed. To enhance performance, a proposed alternative implementation would be to add start, stop and step as fields in the list class. The fields `start` and `stop` will have the value `-1` (invalid) when the list is a normal list. When a slice operation is performed, the same underlying `ArrayList` is used and the fields `start`, `stop` and `step` are assigned to the provided slice values. The `ArrayList` is only copied when the sliced list is written to. This should improve the performance significantly since the copying of the `ArrayList`s is removed or at least delayed until necessary.

### Results

The average time using the alternate implementation was 0.7993s over 10 test runs. Therefore, the performance of slice operations are significantly faster.

## Sort (proposal)
https://docs.google.com/document/d/1pNwL3n_IthYPKy0fBVM3L3VbA_JCZk1P8WWnoLRhXmE/edit?usp=sharing
