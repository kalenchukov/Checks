/*
 * Copyright © 2023 Алексей Каленчуков
 * GitHub: https://github.com/kalenchukov
 * E-mail: mailto:aleksey.kalenchukov@yandex.ru
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package dev.kalenchukov.checks;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * Класс проверки методов класса {@link Checks}.
 *
 * @author Алексей Каленчуков
 */
public class ChecksTest
{
	/**
	 * Класс проверки статических методов.
	 *
	 * @author Алексей Каленчуков
	 */
	@Nested
	public class Static
	{
		/**
		 * Класс проверки метода {@link Checks#requireNotNull(Object)}.
		 *
		 * @author Алексей Каленчуков
		 */
		@Nested
		public class RequireNotNull
		{
			/**
			 * Проверка метода {@link Checks#requireNotNull(Object)}.
			 */
			@Test
			public void requireNotNull()
			{
				String object = "Текст";

				String actualObject = Checks.requireNotNull(object);

				assertThat(actualObject).isEqualTo(object);
			}

			/**
			 * Проверка метода {@link Checks#requireNotNull(Object)} с некорректным значением в виде {@code null}.
			 */
			@Test
			public void requireNotNullWithNull()
			{
				assertThatExceptionOfType(NullPointerException.class).isThrownBy(() -> {
					Checks.requireNotNull(null);
				});
			}

			/**
			 * Проверка метода {@link Checks#requireNotNull(Object, String)}.
			 */
			@Test
			public void requireNotNullWithMessage()
			{
				assertThatExceptionOfType(NullPointerException.class).isThrownBy(() -> {
					Checks.requireNotNull(null, "Сообщение");
				}).withMessage("Сообщение");
			}
		}

		/**
		 * Класс проверки метода {@link Checks#requireNotNullAndNotEmpty(CharSequence)}.
		 *
		 * @author Алексей Каленчуков
		 */
		@Nested
		public class RequireNotNullAndNotEmpty
		{
			/**
			 * Проверка метода {@link Checks#requireNotNullAndNotEmpty(CharSequence)}.
			 */
			@Test
			public void requireNotNullAndNotEmpty()
			{
				String object = "Текст";

				String actualObject = Checks.requireNotNullAndNotEmpty(object);

				assertThat(actualObject).isEqualTo(object);
			}

			/**
			 * Проверка метода {@link Checks#requireNotNullAndNotEmpty(CharSequence)} с некорректным значением
			 * из {@code null} в первом параметре.
			 */
			@Test
			public void requireNotNullAndNotEmptyWithNull()
			{
				assertThatExceptionOfType(NullPointerException.class).isThrownBy(() -> {
					Checks.requireNotNullAndNotEmpty(null);
				});
			}

			/**
			 * Проверка метода {@link Checks#requireNotNullAndNotEmpty(CharSequence)} с некорректным значением
			 * из пустоты в первом параметре.
			 */
			@Test
			public void requireNotNullAndNotEmptyWithEmpty()
			{
				assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
					Checks.requireNotNullAndNotEmpty("");
				});
			}

			/**
			 * Проверка метода {@link Checks#requireNotNullAndNotEmpty(CharSequence, String)} с сообщением.
			 */
			@Test
			public void requireNotNullAndNotEmptyWithMessage()
			{
				assertThatExceptionOfType(NullPointerException.class).isThrownBy(() -> {
					Checks.requireNotNullAndNotEmpty(null, "Сообщение");
				}).withMessage("Сообщение");
			}
		}
	}
}