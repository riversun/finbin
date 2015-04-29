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

/**
 * Unit test base class provides TEST VALUEs<br>
 * 
 * Tom Misawa <riversun.org@gmail.com>
 *
 */
public class TestBase {
	public static final byte[] SMALL_SIZE_TEST_BYTES;
	public static final String SMALL_SIZE_TEST_TEXT = // small size
	"Hello I'm so happy.Hello world.I love this world.It's a small world.";

	public static final byte[] MID_SIZE_TEST_BYTES;

	public static final String MID_SIZE_TEST_TEXT = // mid size
	"Though yet of Hamlet our dear brother’s death The" + // L00
			" memory be green, and that it us befitted To bear " + // L01
			"our hearts in grief and our whole kingdom To be co" + // L02
			"ntracted in one brow of woe, Yet so far hath discr" + // L03
			"etion fought with nature That we with wisest sorro" + // L04
			"w think on him Together with remembrance of oursel" + // L05
			"ves. Therefore our sometime sister, now our queen," + // L06
			" Th' imperial jointress to this warlike state, Hav" + // L07
			"e we?as ’twere with a defeated joy, With an auspi" + // L08
			"cious and a dropping eye, With mirth in funeral an" + // L09
			"d with dirge in marriage, In equal scale weighing " + // L11
			"delight and dole? Taken to wife. Nor have we herei" + // L12
			"n barred Your better wisdoms, which have freely go" + // L13
			"ne With this affair along. For all, our thanks. No" + // L14
			"w follows that you know. Young Fortinbras, Holding" + // L15
			" a weak supposal of our worth Or thinking by our l" + // L16
			"ate dear brother’s death Our state to be disjoint" + // L17
			" and out of frame, Colleagued with the dream of hi" + // L18
			"s advantage, He hath not failed to pester us with " + // L19
			"message Importing the surrender of those lands Los" + // L20
			"t by his father, with all bonds of law, To our mos" + // L21
			"t valiant brother. So much for him.";// L22

	static {
		MID_SIZE_TEST_BYTES = getBytes(MID_SIZE_TEST_TEXT);
		SMALL_SIZE_TEST_BYTES = getBytes(SMALL_SIZE_TEST_TEXT);
	}

	static byte[] getBytes(String text) {
		return BinaryUtil.getBytes(text);
	}

	static long startTime = 0;
	static long stopTime = 0;

	static void startTimer() {
		startTime = System.currentTimeMillis();
	}

	static long stopTimer() {
		stopTime = System.currentTimeMillis();
		return (stopTime - startTime);
	}

}
