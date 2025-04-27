### Issue 1: Reordering of instrunctions 
- As we know, internally CPU can re-order the machine instrunctions
- AS per class `DBConnectionWithMultiThreading`, instunctions are as follows:
    - Allocation of memory
    - Initialization of member variables
    - assign memory address to `instance` variable

- But, if CPU reorder them and interchange step 2 with step 3. Now one thread reach till step 2 (after interchange) and one thread comes and check if object is null or not, it is not null (as initialized by thread 1). IT will be returned without having initialization in member variable

### Issue 2: L1 caching
- As we know to achieve parallelism, CPU uses multiple cores. Each core has its own cache (L1).
- Each write operation is done to core's L1 cache, then dumped to disk (memory).

- For ex: Thread t1 running in core 1 with its own L1 cache, Thread t2 running in core 2 with its own L1 cache.
```
    Core1                           Core2
      |                               |
      |                               |
    Cache                            Cache
        |                             |
        -------------------------------
                        |
                    Disk Storage
```
- Thread t1: created object, and it's in core1 cache, not dumped to disk yet.
- Thread t2: (synch up between both core cache not done yet), 
    - Checks object in its cache, not found -> its null 
    - Creates new object in its own cache 

- Thus, Thread t2 will create a new object, even though thread t1 has already created an object.


### Fixes of above issues
- Use `volatile` keyword to prevent reordering of instructions
```
    private static volatile DBConnectionWithMultiThreading instance;
```
- using volatile keyword means:
    - read/write happens from disk directly, not from cache.

