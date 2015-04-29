/*  finbin - Hi-speed search byte[] data from big byte[]
 *
 *  Copyright (c) 2015 Tom Misawa<riversun.org@gmail.com>
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

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

public class TestBigBinarySearcher extends TestBase {
	@Rule
	public TestName name = new TestName();

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSearchBytes_64K() {
		BinarySearcher bs = new BinarySearcher();

		// Test binary size is 3 mega-bytes.
		byte[] srcBytes = BinaryUtil.loadBytesFromFile(new File("src/test/resources/finbin_test_064kbyte.bin"));

		String searchText = "hello world";

		byte[] searchBytes = getBytes(searchText);

		Integer[] expectedArray = new Integer[] { 0, 5000, 10000, 15000, 20000, 25000, 30000, 35000, 40000, 45000, 50000, 55000, 60000, 65000 };

		startTimer();
		List<Integer> resultList = bs.searchBytes(srcBytes, searchBytes);
		long ellapsedTimeInMillis = stopTimer();

		Integer[] resultArray = resultList.toArray(new Integer[] {});

		assertTrue(Arrays.equals(expectedArray, resultArray));

		System.out.println("[" + name.getMethodName() + "] ellapsed " + ellapsedTimeInMillis + " millis for " + srcBytes.length / 1024 + " kbytes");

	}

	@Test
	public void testSearchBytes_500K() {
		BinarySearcher bs = new BinarySearcher();

		// Test binary size is 3 mega-bytes.
		byte[] srcBytes = BinaryUtil.loadBytesFromFile(new File("src/test/resources/finbin_test_500kbyte.bin"));

		String searchText = "hello world";

		byte[] searchBytes = getBytes(searchText);

		Integer[] expectedArray = new Integer[] { 0, 50000, 100000, 150000, 200000, 250000, 300000, 350000, 400000, 450000, 500000 };

		startTimer();
		List<Integer> resultList = bs.searchBytes(srcBytes, searchBytes);
		long ellapsedTimeInMillis = stopTimer();

		Integer[] resultArray = resultList.toArray(new Integer[] {});

		assertTrue(Arrays.equals(expectedArray, resultArray));

		System.out.println("[" + name.getMethodName() + "] ellapsed " + ellapsedTimeInMillis + " millis for " + srcBytes.length / 1024 + " kbytes");

	}

	@Test
	public void testSearchBigBytes_64K() {

		BigBinarySearcher bbs = new BigBinarySearcher();

		// Test binary size is 3 mega-bytes.
		byte[] srcBytes = BinaryUtil.loadBytesFromFile(new File("src/test/resources/finbin_test_064kbyte.bin"));

		String searchText = "hello world";

		byte[] searchBytes = getBytes(searchText);

		Integer[] expectedArray = new Integer[] { 0, 5000, 10000, 15000, 20000, 25000, 30000, 35000, 40000, 45000, 50000, 55000, 60000, 65000 };

		startTimer();
		List<Integer> resultList = bbs.searchBigBytes(srcBytes, searchBytes);
		long ellapsedTimeInMillis = stopTimer();

		Integer[] resultArray = resultList.toArray(new Integer[] {});

		assertTrue(Arrays.equals(expectedArray, resultArray));

		System.out.println("[" + name.getMethodName() + "] ellapsed " + ellapsedTimeInMillis + " millis for " + srcBytes.length / 1024 + " kbytes");

	}

	@Test
	public void testSearchBigBytes_500K() {
		BigBinarySearcher bbs = new BigBinarySearcher();

		// Test binary size is 3 mega-bytes.
		byte[] srcBytes = BinaryUtil.loadBytesFromFile(new File("src/test/resources/finbin_test_500kbyte.bin"));

		String searchText = "hello world";

		byte[] searchBytes = getBytes(searchText);

		Integer[] expectedArray = new Integer[] { 0, 50000, 100000, 150000, 200000, 250000, 300000, 350000, 400000, 450000, 500000 };

		startTimer();
		List<Integer> resultList = bbs.searchBigBytes(srcBytes, searchBytes);
		long ellapsedTimeInMillis = stopTimer();

		Integer[] resultArray = resultList.toArray(new Integer[] {});

		assertTrue(Arrays.equals(expectedArray, resultArray));

		System.out.println("[" + name.getMethodName() + "] ellapsed " + ellapsedTimeInMillis + " millis for " + srcBytes.length / 1024 + " kbytes");

	}

	@Test
	public void testSearchBigBytes_1000K() {
		BigBinarySearcher bbs = new BigBinarySearcher();

		// Test binary size is 3 mega-bytes.
		byte[] srcBytes = BinaryUtil.loadBytesFromFile(new File("src/test/resources/finbin_test_1mbyte.bin"));

		String searchText = "hello world";

		byte[] searchBytes = getBytes(searchText);

		Integer[] expectedArray = new Integer[] { 0, 100000, 200000, 300000, 400000, 500000, 600000, 700000, 800000, 900000, 1000000 };

		startTimer();
		List<Integer> resultList = bbs.searchBigBytes(srcBytes, searchBytes);
		long ellapsedTimeInMillis = stopTimer();

		Integer[] resultArray = resultList.toArray(new Integer[] {});

		assertTrue(Arrays.equals(expectedArray, resultArray));

		System.out.println("[" + name.getMethodName() + "] ellapsed " + ellapsedTimeInMillis + " millis for " + srcBytes.length / 1024 + " kbytes");

	}

	@Test
	public void testSearchBigBytes_3000K() {
		BigBinarySearcher bbs = new BigBinarySearcher();

		// Test binary size is 3 mega-bytes.
		byte[] srcBytes = BinaryUtil.loadBytesFromFile(new File("src/test/resources/finbin_test_3mbyte.bin"));

		String searchText = "hello world";

		byte[] searchBytes = getBytes(searchText);

		Integer[] expectedArray = new Integer[] { 0, 200000, 400000, 600000, 800000, 1000000, 1200000, 1400000, 1600000, 1800000, 2000000, 2200000, 2400000, 2600000, 2800000, 3000000 };

		startTimer();
		List<Integer> resultList = bbs.searchBigBytes(srcBytes, searchBytes);
		long ellapsedTimeInMillis = stopTimer();

		Integer[] resultArray = resultList.toArray(new Integer[] {});

		assertTrue(Arrays.equals(expectedArray, resultArray));

		System.out.println("[" + name.getMethodName() + "] ellapsed " + ellapsedTimeInMillis + " millis for " + srcBytes.length / 1024 + " kbytes");

	}

}
