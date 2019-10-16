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

### Times

![Profile for original implementation](ProfilerSlice.png)
...

### Alternate implementation
...

### Results
...




## Sort (proposal)
https://docs.google.com/document/d/1pNwL3n_IthYPKy0fBVM3L3VbA_JCZk1P8WWnoLRhXmE/edit?usp=sharing
