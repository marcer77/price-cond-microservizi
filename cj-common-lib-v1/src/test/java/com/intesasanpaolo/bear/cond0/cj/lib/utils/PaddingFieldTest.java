package com.intesasanpaolo.bear.cond0.cj.lib.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class PaddingFieldTest {

	@Test
	public void test() {
		
		String field = "test di prova";
		
		int length = 4;

		PaddingField.left(field, length);
		
		PaddingField.leftPadZeroOrTruncate(field, length);
		
		PaddingField.leftPadZeroOrTruncate(null, length);
		
		PaddingField.paddingZeros(123456, length);
		
		PaddingField.paddingZeros(5L, length);

		PaddingField.paddingZeros((short) 5, length);
		
		PaddingField.right(field, length);
		
		PaddingField.rightPadSpaceOrTruncate(field, length);
		
		PaddingField.rightPadSpaceOrTruncate(null, length);
	}

}
