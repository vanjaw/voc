# Conjectures

## Remove TODO: fixa bilder från samma dator
### The times
![Profiler for original](ProfilerRemove.png)
The total time for 500.001 removes was 37.653ms where the most time was spent in self time, i.e the actual removal of items from the list. We tested removing the first element of the list 500.000 times and removing an item that didn't exist one time thus looking through the 500.000 elements 1 time.
### What to improve
As the most time spent was in the remove part of the code, implementing a datatype with better preformance there might be a good idea and the compare part isn't as important. If we compare the remove operator between ArrayList and LinkedList we can see that (, at least for our test), LinkedList is better with an complexity of O(1) instead of O(n) that ArrayList has.
### Our new results
![Profiler for Updated](ProfilerRemoveUpdated.png)
After testing the LinkedList the times drastically worsened, the time increased five times, meaning that the switch to LinkedList was not the right choice for us.


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
