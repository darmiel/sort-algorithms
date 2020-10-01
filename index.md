To sort a list up/down, there are some sorting algorithms.  
You can find a list here: [Wikipedia](https://en.wikipedia.org/wiki/Category:Sorting_algorithms)

We would like to introduce two sorting methods:
* [Radix Sort](https://en.wikipedia.org/wiki/Radix_sort)
* [Insertion Sort](https://en.wikipedia.org/wiki/Insertion_sort)

---

### Radix-Sort
With the radix-sort algorithm there is **no comparison of the values**.  
Instead, the values are divided into so-called "buckets", depending on the n-th digit of the number.  
* LSD (**L**east **S**ignificant **D**igit) starts from the **back** 
* MSD (**M**ost **S**ignificant **D**igit) from the **front**

👉 In this example we'll use the **LSD** method.

Let's assume the following array of random numbers:
```java
int[] array = new int[] {
    270, 76, 29, 31, 690, 62, 73, 38, 6, 72, 100
};
```

Now we think of 10 "buckets":
![img](assets/images/buckets.png)

In the **1**st round we start now with the **1st digit** (*from the back*) of the numbers and put these numbers into the respective bucket.  
The number of rounds is limited to the greatest number of places of all numbers in the array.

-> So the number 27***0*** is in bucket **0**

```java
final int[][] buckets = new int[10][];
buckets[0] = new int[] {270, 690, 100};
buckets[1] = new int[] {31};
buckets[2] = new int[] {62, 72};
buckets[3] = new int[] {73};
buckets[4] = new int[0];
buckets[5] = new int[0];
buckets[6] = new int[] {76, 6};
buckets[7] = new int[0];
buckets[8] = new int[] {38};
buckets[9] = new int[] {29};
```

Now we go from **top to bottom**, **left to right** in the two-dimensional array, and set the array in this order.
```java
array = new int[] {
    270, 690, 100, 31, 62, 72, 73, 76, 6, 38, 29
};
```

Now we repeat the whole thing, only this time with the 2nd digit:
If a number has not enough digits, a 0 is placed in front.

> So the number 2***7***0 is in bucket **7**

```java
final int[][] buckets = new int[10][];
buckets[0] = new int[] {100, 06};
buckets[1] = new int[0];
buckets[2] = new int[] {29};
buckets[3] = new int[] {31, 38};
buckets[4] = new int[0];
buckets[5] = new int[0];
buckets[6] = new int[] {62};
buckets[7] = new int[] {270, 72, 73, 76};
buckets[8] = new int[0];
buckets[9] = new int[] {690};

array = new int[] {
    100, 06, 29, 31, 38, 62, 270, 72, 73, 76, 690
};
```

And finally round three, this time the third place from behind.
If a number has not enough digits, *x times 0* is placed in front.

```java
final int[][] buckets = new int[10][];
buckets[0] = new int[] {006, 029, 031, 038, 062, 077, 073, 076};
buckets[1] = new int[] {100};
buckets[2] = new int[] {270};
buckets[3] = new int[] {};
buckets[4] = new int[] {};
buckets[5] = new int[] {};
buckets[6] = new int[] {690};
buckets[7] = new int[] {};
buckets[8] = new int[] {};
buckets[9] = new int[] {};

array = new int[] {
    006, 029, 031, 038, 062, 077, 073, 076, 100, 270, 690
};
```

**🎉 The array is now sorted!  
And this without any comparisons.**

```
array = [6, 66, 43, 123, 98, 291, 20, 21, 21, 22, 911]
n = 1
|0| |1| |2| |3| |4| |5| |6| |7| |8| |9|
20 291  22  43                  98
    21     123
    21
   911
array = [20, 291, 21, 21, 911, 22, 43, 123, 98]
n = 2
|0| |1| |2| |3| |4| |5| |6| |7| |8| |9|
    911  20      43                 291
         21                          98
         21
         22
        123
array = [911, 20, 21, 21, 22, 123, 43, 291, 98]
n = 3
|0| |1| |2| |3| |4| |5| |6| |7| |8| |9|
  20 123 291
  21
  21
  22
  43
  98
array = [20, 21, 21, 22, 43, 98, 123, 291] <- sorted
```

#### Java Code example
```java
// an (signed) 32-bit integers' max length is 10
// 2^31-1 = 2 147 483 647 = 10 digits
for (int n = 1; n <= 10; n++) {
  // this array holds every value for each n^th digit
  final int[][] digits = new int[10][];

  // first, find frequency of every digit for array initialization
  final int[] frequency = new int[10];
  for (final Integer integer : array) {
    frequency[getDigit(integer, n)]++; // get digit returns the n^th digit of a number
  }

  // now create the arrays of every digit
  for (int i = 0; i < frequency.length; i++) {
    digits[i] = new int[frequency[i]];
    // reset frequency for later use
    frequency[i] = 0;
  }

  // iterate through every object in array
  for (final int integer : array) {
    int digit = getDigit(integer, n);

    // Add digit to array
    digits[digit][frequency[digit]++] = integer;
  }

  // overwrite current array
  // start from the top left to the bottom right
  int i = 0;
  for (final int[] digitsb : digits) {
    for (final int digit : digitsb) {
      array[i++] = digit;
    }
  }
  // break loop if there were no more digits found
  if (/* noMoreDigitFound */) {
    break;
  }
}
```