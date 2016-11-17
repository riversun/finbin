# Overview
'finbin' is a java library for finding the specified sequence of bytes from the big-size sequence of bytes.

You can find out quickly from the big size (like mega-bytes binary) of the binary data.

It is licensed under [Apache License 2.0](http://www.apache.org/licenses/LICENSE-2.0).

# classes & methods
## BigBinarySearcher class
- public List<Integer> searchBigBytes(byte[] srcBytes, byte[] searchBytes)
  - For big byte array binary data, search bytes faster in a concurrent processing.

- and derivation of the method


## Example for big bytes(Multi-Threaded)
### search for a sequence of bytes by using *searchBigBytes*
If you want to search an array of bytes of mega-bytes order of size,try to use *searchBigBytes*.


```java
package org.example;

import java.util.List;

import org.riversun.finbin.BigBinarySearcher;

public class Example {

	public static void main(String[] args) throws Exception {

		BigBinarySearcher bbs = new BigBinarySearcher();

		// UTF-8 without BOM
		byte[] iamBigSrcBytes = "Hello world.It's a small world.".getBytes("utf-8");

		byte[] searchBytes = "world".getBytes("utf-8");

		List<Integer> indexList = bbs.searchBytes(iamBigSrcBytes, searchBytes);

		System.out.println("indexList=" + indexList);
	}
}

```
## BinarySearcher class
- public int indexOf(byte[] srcBytes, byte[] searchBytes)
  - For small byte array binary data, Returns the index within this byte-array of the first occurrence of the specified(search bytes) byte array.

- public List searchBytes(byte[] srcBytes, byte[] searchBytes)
  - For small byte array binary data, Search bytes in byte array returns indexes within this byte-array of all occurrences of the specified(search bytes) byte array.

- and derivation of the method


-----
## Examples for small bytes(Single-Threaded)
### search for a sequence of bytes by using *indexOf*

```java
package org.example;

import org.riversun.finbin.BinarySearcher;

public class Example1 {

	public static void main(String[] args) throws Exception {

		BinarySearcher bs = new BinarySearcher();

		// UTF-8 without BOM
		byte[] srcBytes = "Hello world.It's a small world.".getBytes("utf-8");

		byte[] searchBytes = "world".getBytes("utf-8");

		int index = bs.indexOf(srcBytes, searchBytes);

		System.out.println("index=" + index);
	}
}

```
1. srcBytes is
```
0x48,0x65,0x6C,0x6C,0x6F,0x20,0x77,0x6F,0x72,0x6C,0x64,0x2E,0x49,0x74,0x27,0x73,0x20,0x61,0x20,0x73,0x6D,0x61,0x6C,0x6C,0x20,0x77,0x6F,0x72,0x6C,0x64,0x2E
```

2. searchBytes is
```
0x77,0x6F,0x72,0x6C,0x64
```

so it results in
```
index=6
```

### search for a sequence of bytes by using *searchBytes*
```java
package org.example;

import java.util.List;

import org.riversun.finbin.BinarySearcher;

public class Example2 {

	public static void main(String[] args) throws Exception {

		BinarySearcher bs = new BinarySearcher();

		// UTF-8 without BOM
		byte[] srcBytes = "Hello world.It's a small world.".getBytes("utf-8");

		byte[] searchBytes = "world".getBytes("utf-8");

		List<Integer> indexList = bs.searchBytes(srcBytes, searchBytes);

		System.out.println("indexList=" + indexList);
	}
}
```
so it results in
```
indexList=[6, 25]
```

- Please note

The result is different depending on the environment of the Java ,Java version and compiler or runtime optimization.

#Downloads
## maven
- You can add dependencies to maven pom.xml file.
```xml
<dependency>
  <groupId>org.riversun</groupId>
  <artifactId>finbin</artifactId>
  <version>0.6.1</version>
</dependency>
```
## direct download
- You can download jar from here and add it into your classpath.

  [finbin-0.6.1.jar](http://riversun.org/downloads/finbin-0.6.1.zip)
