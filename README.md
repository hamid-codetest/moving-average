# Coding Solution

Moving Average library consists of two interfaces and two classes as bellow:
* **Interfaces:**
    * [MovingAverage](src/main/java/com/hamidgh/demo/util/MovingAverage.java)
    * [Element](src/main/java/com/hamidgh/demo/util/Element.java)
* **Classes:**
    * [IntegerMovingAverageImpl](src/main/java/com/hamidgh/demo/util/IntegerMovingAverageImpl.java)
    * [GenericMovingAverageImpl](src/main/java/com/hamidgh/demo/util/GenericMovingAverageImpl.java)

*MovingAverage* is the main interface and two classes *GenericMovingAverageImpl* and *IntegerMovingAverageImpl* implement it. *GenericMovingAverageImpl* is the generic implementation and is implemented against *Element* interface: it stores objects implementing *Element* interface. *IntegerMovingAverageImpl* is the implementation of the *MovingAverage* for Integers.

## MovingAverage
This interface declares four methods:
* **add:** Adds an element to the structure.
* **getElement:** Returns the element at the specified index.
* **getSize:** Returns the number of element inside the structure.
* **getMovingAverage:** Returns the moving average of the last N numbers added to this data structure by the *add* method.


The two implementations of the the above interface are almost the same. However, *GenericMovingAverageImpl* abstracts out the elements to *Element* interface. It also maintains the moving average list and we can get not only the latest average but also up-to N previously calculated averages.


## IntegerMovingAverageImpl
The implementation maintains a list holding the integer values added to the structure. The moving average is calculated whenever a new element added to the list. This will make the average retrieval efficient as both *add* and *getMovingAverage* will have the computation complexity of O(1).

## GenericMovingAverageImpl
The implementation maintains two lists: one for holding the elements added to the list, and one for holding the moving average list. This implementation accept elements implementing the *Element* interface. The *getValue* method of *Element* is used to retrieve the value used in average calculation. Aside from these differences, the implementation is the same as *IntegerMovingAverageImpl*.

## Tests
Tests are added to verify the correctness of both *IntegerMovingAverageImpl* and *GenericMovingAverageImpl* implementations.

