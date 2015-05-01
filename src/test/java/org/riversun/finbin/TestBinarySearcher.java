/*  finbin - Hi-speed search byte[] data from big byte[]
 *
 *  Copyright (c) 2015 Tom Misawa(riversun.org@gmail.com)
 *  
 *  Permission is hereby granted, free of charge, to any person obtaining a
 *  copy of this software and associated documentation files (the "Software"),
 *  to deal in the Software without restriction, including without limitation
 *  the rights to use, copy, modify, merge, publish, distribute, sublicense,
 *  and/or sell copies of the Software, and to permit persons to whom the
 *  Software is furnished to do so, subject to the following conditions:
 *  
 *  The above copyright notice and this permission notice shall be included in
 *  all copies or substantial portions of the Software.
 *  
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 *  FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 *  DEALINGS IN THE SOFTWARE.
 *  
 */
package org.riversun.finbin;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit tests for BinarySearcher<br>
 * 
 * Tom Misawa (riversun.org@gmail.com)
 *
 */
public class TestBinarySearcher extends TestBase {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testIndexOf_01_TinyData() {
		BinarySearcher bs = new BinarySearcher();

		byte[] srcBytes = getBytes("hello world");

		String searchText = "hello";
		byte[] searchBytes = getBytes(searchText);

		final int expected = 0;
		final int resultVal = bs.indexOf(srcBytes, searchBytes);

		assertEquals(expected, resultVal);
	}

	@Test
	public void testIndexOf_02_TinyData() {
		BinarySearcher bs = new BinarySearcher();

		byte[] srcBytes = getBytes("hello world");

		String searchText = "world";
		byte[] searchBytes = getBytes(searchText);

		final int expected = 6;
		final int resultVal = bs.indexOf(srcBytes, searchBytes);

		assertEquals(expected, resultVal);
	}

	// test empty bytes
	@Test
	public void testIndexOf_03_TinyData() {
		BinarySearcher bs = new BinarySearcher();

		byte[] srcBytes = getBytes("hello world");

		byte[] searchBytes = new byte[] {};

		final int expected = -1;
		final int resultVal = bs.indexOf(srcBytes, searchBytes);

		assertEquals(expected, resultVal);
	}

	@Test
	public void testIndexOf_04_TinyData() {
		BinarySearcher bs = new BinarySearcher();

		byte[] srcBytes = getBytes("hello world");

		String searchText = "worlds";
		byte[] searchBytes = getBytes(searchText);

		final int expected = -1;
		final int resultVal = bs.indexOf(srcBytes, searchBytes);

		assertEquals(expected, resultVal);
	}

	@Test
	public void testIndexOf_01_SmallData() {
		BinarySearcher bs = new BinarySearcher();

		// "Hello I'm so happy.Hello world.I love this world.It's a small world.";
		byte[] srcBytes = SMALL_SIZE_TEST_BYTES;

		String searchText = "world";
		byte[] searchBytes = getBytes(searchText);

		final int expected = 25;
		final int resultVal = bs.indexOf(srcBytes, searchBytes);

		assertEquals(expected, resultVal);
	}

	// with startIndex
	@Test
	public void testIndexOf_02_SmallData() {
		BinarySearcher bs = new BinarySearcher();

		// "Hello I'm so happy.Hello world.I love this world.It's a small world.";

		byte[] srcBytes = SMALL_SIZE_TEST_BYTES;

		String searchText = "world";
		byte[] searchBytes = getBytes(searchText);

		final int startIndex = 5;
		final int expected = 25;
		final int resultVal = bs.indexOf(srcBytes, searchBytes, startIndex);

		assertEquals(expected, resultVal);
	}

	// start after first occurrence
	@Test
	public void testIndexOf_03_SmallData() {
		BinarySearcher bs = new BinarySearcher();

		// "Hello I'm so happy.Hello world.I love this world.It's a small world.";

		byte[] srcBytes = SMALL_SIZE_TEST_BYTES;

		String searchText = "world";
		byte[] searchBytes = getBytes(searchText);

		final int startIndex = 26;
		final int expected = 43;
		final int resultVal = bs.indexOf(srcBytes, searchBytes, startIndex);

		assertEquals(expected, resultVal);
	}

	// search startIndex to endIndex
	@Test
	public void testIndexOf_04_SmallData() {
		BinarySearcher bs = new BinarySearcher();

		// "Hello I'm so happy.Hello world.I love this world.It's a small world.";

		byte[] srcBytes = SMALL_SIZE_TEST_BYTES;

		String searchText = "world";
		byte[] searchBytes = getBytes(searchText);

		final int startIndex = 0;
		final int endIndex = 29;
		final int expected = 25;
		final int resultVal = bs.indexOf(srcBytes, searchBytes, startIndex, endIndex);

		assertEquals(expected, resultVal);
	}

	// boundary test failure pattern(didn't go to the last char of world)
	@Test
	public void testIndexOf_05_SmallData() {
		BinarySearcher bs = new BinarySearcher();

		// "Hello I'm so happy.Hello world.I love this world.It's a small world.";
		byte[] srcBytes = SMALL_SIZE_TEST_BYTES;

		String searchText = "world";
		byte[] searchBytes = getBytes(searchText);

		final int startIndex = 0;
		final int endIndex = 28;
		final int expected = -1;
		final int resultVal = bs.indexOf(srcBytes, searchBytes, startIndex, endIndex);

		assertEquals(expected, resultVal);
	}

	// boundary test ok pattern
	@Test
	public void testIndexOf_06_SmallData() {
		BinarySearcher bs = new BinarySearcher();

		// "Hello I'm so happy.Hello world.I love this world.It's a small world.";
		byte[] srcBytes = SMALL_SIZE_TEST_BYTES;

		String searchText = "world";
		byte[] searchBytes = getBytes(searchText);

		final int startIndex = 0;
		final int endIndex = 29;
		final int expected = 25;
		final int resultVal = bs.indexOf(srcBytes, searchBytes, startIndex, endIndex);

		assertEquals(expected, resultVal);
	}

	@Test
	public void testIndexOf_01_MidData() {
		BinarySearcher bs = new BinarySearcher();

		byte[] srcBytes = MID_SIZE_TEST_BYTES;

		String searchText = "with";
		byte[] searchBytes = getBytes(searchText);

		final int expected = 214;
		final int resultVal = bs.indexOf(srcBytes, searchBytes);

		assertEquals(expected, resultVal);
	}

	// with startIndex
	@Test
	public void testIndexOf_02_MidData() {
		BinarySearcher bs = new BinarySearcher();

		byte[] srcBytes = MID_SIZE_TEST_BYTES;

		String searchText = "with";
		byte[] searchBytes = getBytes(searchText);

		final int startIndex = 220;
		final int expected = 234;
		final int resultVal = bs.indexOf(srcBytes, searchBytes, startIndex);

		assertEquals(expected, resultVal);
	}

	// searchText placed in start position of the byte array.
	@Test
	public void testSearchBytes_01_TinyData() {
		BinarySearcher bs = new BinarySearcher();

		byte[] srcBytes = getBytes("hello world");

		String searchText = "hello";
		byte[] searchBytes = getBytes(searchText);

		Integer[] expectedArray = new Integer[] { 0 };
		List<Integer> resultList = bs.searchBytes(srcBytes, searchBytes);
		Integer[] resultArray = resultList.toArray(new Integer[] {});

		assertTrue(Arrays.equals(expectedArray, resultArray));
	}

	// searchText placed in start position of the byte array.
	@Test
	public void testSearchBytes_02_TinyData() {
		BinarySearcher bs = new BinarySearcher();

		byte[] srcBytes = getBytes("hello world");

		String searchText = "world";
		byte[] searchBytes = getBytes(searchText);

		Integer[] expectedArray = new Integer[] { 6 };
		List<Integer> resultList = bs.searchBytes(srcBytes, searchBytes);
		Integer[] resultArray = resultList.toArray(new Integer[] {});

		assertTrue(Arrays.equals(expectedArray, resultArray));
	}

	// test searchBytes method
	@Test
	public void testSearchBytes_01_SmallData() {
		BinarySearcher bs = new BinarySearcher();

		// "Hello I'm so happy.Hello world.I love this world.It's a small world.";
		byte[] srcBytes = SMALL_SIZE_TEST_BYTES;

		String searchText = "world";
		byte[] searchBytes = getBytes(searchText);

		Integer[] expectedArray = new Integer[] { 25, 43, 62 };

		List<Integer> resultList = bs.searchBytes(srcBytes, searchBytes);
		Integer[] resultArray = resultList.toArray(new Integer[] {});

		assertTrue(Arrays.equals(expectedArray, resultArray));
	}

	// with start index
	@Test
	public void testSearchBytes_02_SmallData() {
		BinarySearcher bs = new BinarySearcher();

		// "Hello I'm so happy.Hello world.I love this world.It's a small world.";
		byte[] srcBytes = SMALL_SIZE_TEST_BYTES;

		String searchText = "world";
		byte[] searchBytes = getBytes(searchText);

		final int startIndex = 26;

		Integer[] expectedArray = new Integer[] { 43, 62 };

		List<Integer> resultList = bs.searchBytes(srcBytes, searchBytes, startIndex);
		Integer[] resultArray = resultList.toArray(new Integer[] {});

		assertTrue(Arrays.equals(expectedArray, resultArray));
	}

	// with start index and end index
	@Test
	public void testSearchBytes_03_SmallData() {
		BinarySearcher bs = new BinarySearcher();

		// "Hello I'm so happy.Hello world.I love this world.It's a small world.";
		byte[] srcBytes = SMALL_SIZE_TEST_BYTES;

		String searchText = "world";
		byte[] searchBytes = getBytes(searchText);

		final int startIndex = 26;
		final int endIndex = 50;

		Integer[] expectedArray = new Integer[] { 43 };

		List<Integer> resultList = bs.searchBytes(srcBytes, searchBytes, startIndex, endIndex);
		Integer[] resultArray = resultList.toArray(new Integer[] {});

		assertTrue(Arrays.equals(expectedArray, resultArray));
	}
}