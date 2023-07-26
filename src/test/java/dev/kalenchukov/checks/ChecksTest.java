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
import org.mockito.internal.matchers.Null;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

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
				String expectedObject = "Текст";

				String actualObject = Checks.requireNotNull(object);

				assertThat(actualObject).isSameAs(expectedObject);
			}

			/**
			 * Проверка метода {@link Checks#requireNotNull(Object)} с некорректным значением
			 * из {@code null}.
			 */
			@Test
			public void requireNotNullWithNull()
			{
				String object = null;

				assertThatExceptionOfType(NullPointerException.class).isThrownBy(() -> {
					Checks.requireNotNull(object);
				});
			}

			/**
			 * Проверка метода {@link Checks#requireNotNull(Object, String)} с сообщением
			 * для исключения.
			 */
			@Test
			public void requireNotNullWithMessage()
			{
				String object = null;

				assertThatExceptionOfType(NullPointerException.class).isThrownBy(() -> {
					Checks.requireNotNull(object, "Сообщение");
				}).withMessage("Сообщение");
			}
		}

		/**
		 * Класс проверки метода {@link Checks#requireNotNullAndNotEmpty(CharSequence)}.
		 *
		 * @author Алексей Каленчуков
		 */
		@Nested
		public class RequireNotNullAndNotEmptyWithCharSequence
		{
			/**
			 * Проверка метода {@link Checks#requireNotNullAndNotEmpty(CharSequence)}.
			 */
			@Test
			public void requireNotNullAndNotEmpty()
			{
				String object = "Текст";
				String expectedObject = "Текст";

				String actualObject = Checks.requireNotNullAndNotEmpty(object);

				assertThat(actualObject).isSameAs(expectedObject);
			}

			/**
			 * Проверка метода {@link Checks#requireNotNullAndNotEmpty(CharSequence)} с некорректным значением
			 * из {@code null}.
			 */
			@Test
			public void requireNotNullAndNotEmptyWithNull()
			{
				String object = null;

				assertThatExceptionOfType(NullPointerException.class).isThrownBy(() -> {
					Checks.requireNotNullAndNotEmpty(object);
				});
			}

			/**
			 * Проверка метода {@link Checks#requireNotNullAndNotEmpty(CharSequence)} с некорректным значением
			 * из пустой строки.
			 */
			@Test
			public void requireNotNullAndNotEmptyWithEmpty()
			{
				String object = "";

				assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
					Checks.requireNotNullAndNotEmpty(object);
				});
			}

			/**
			 * Проверка метода {@link Checks#requireNotNullAndNotEmpty(CharSequence, String)} с сообщением
			 * для исключения.
			 */
			@Test
			public void requireNotNullAndNotEmptyWithMessage()
			{
				String object = null;

				assertThatExceptionOfType(NullPointerException.class).isThrownBy(() -> {
					Checks.requireNotNullAndNotEmpty(object, "Сообщение");
				}).withMessage("Сообщение");
			}
		}

		/**
		 * Класс проверки метода {@link Checks#requireNotNullAndNotEmpty(Collection)}.
		 *
		 * @author Алексей Каленчуков
		 */
		@Nested
		public class RequireNotNullAndNotEmptyWithCollection
		{
			/**
			 * Проверка метода {@link Checks#requireNotNullAndNotEmpty(Collection)}.
			 */
			@Test
			public void requireNotNullAndNotEmpty()
			{
				Collection<String> object = List.of("Текст");
				Collection<String> expectedObject = List.of("Текст");

				Collection<String> actualObject = Checks.requireNotNullAndNotEmpty(object);

				assertThat(actualObject).containsSequence(expectedObject);
			}

			/**
			 * Проверка метода {@link Checks#requireNotNullAndNotEmpty(Collection)} с некорректным значением
			 * из {@code null}.
			 */
			@Test
			public void requireNotNullAndNotEmptyWithNull()
			{
				Collection<String> object = null;

				assertThatExceptionOfType(NullPointerException.class).isThrownBy(() -> {
					Checks.requireNotNullAndNotEmpty(object);
				});
			}

			/**
			 * Проверка метода {@link Checks#requireNotNullAndNotEmpty(Collection)} с некорректным значением
			 * из пустой коллекции.
			 */
			@Test
			public void requireNotNullAndNotEmptyWithEmpty()
			{
				Collection<String> object = List.of();

				assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
					Checks.requireNotNullAndNotEmpty(object);
				});
			}

			/**
			 * Проверка метода {@link Checks#requireNotNullAndNotEmpty(Collection, String)} с сообщением
			 * для исключения.
			 */
			@Test
			public void requireNotNullAndNotEmptyWithMessage()
			{
				Collection<String> object = null;

				assertThatExceptionOfType(NullPointerException.class).isThrownBy(() -> {
					Checks.requireNotNullAndNotEmpty(object, "Сообщение");
				}).withMessage("Сообщение");
			}
		}

		/**
		 * Класс проверки метода {@link Checks#requireNotNullAndLength(CharSequence, int)}.
		 *
		 * @author Алексей Каленчуков
		 */
		@Nested
		public class RequireNotNullAndLength
		{
			/**
			 * Проверка метода {@link Checks#requireNotNullAndLength(CharSequence, int)}.
			 */
			@Test
			public void requireNotNullAndLength()
			{
				String object = "Текст";
				String expectedObject = "Текст";

				String actualObject = Checks.requireNotNullAndLength(object, 5);

				assertThat(actualObject).isSameAs(expectedObject);
			}

			/**
			 * Проверка метода {@link Checks#requireNotNullAndLength(CharSequence, int)} с некорректным значением
			 * из {@code null} в первом параметре.
			 */
			@Test
			public void requireNotNullAndLengthWithNull()
			{
				String object = null;

				assertThatExceptionOfType(NullPointerException.class).isThrownBy(() -> {
					Checks.requireNotNullAndLength(object, 5);
				});
			}

			/**
			 * Проверка метода {@link Checks#requireNotNullAndLength(CharSequence, int)} с некорректным значением
			 * из пустой строки в первом параметре.
			 */
			@Test
			public void requireNotNullAndLengthWithEmpty()
			{
				String object = "";

				assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
					Checks.requireNotNullAndLength(object, 5);
				});
			}

			/**
			 * Проверка метода {@link Checks#requireNotNullAndLength(CharSequence, int, String)} с сообщением
			 * для исключения.
			 */
			@Test
			public void requireNotNullAndLengthWithMessage()
			{
				String object = null;

				assertThatExceptionOfType(NullPointerException.class).isThrownBy(() -> {
					Checks.requireNotNullAndLength(object, 5, "Сообщение");
				}).withMessage("Сообщение");
			}
		}

		/**
		 * Класс проверки метода {@link Checks#requireNotNullAndSize(Collection, int)}.
		 *
		 * @author Алексей Каленчуков
		 */
		@Nested
		public class RequireNotNullAndSize
		{
			/**
			 * Проверка метода {@link Checks#requireNotNullAndSize(Collection, int)}.
			 */
			@Test
			public void requireNotNullAndSize()
			{
				Collection<Integer> object = List.of(1, 2, 3);
				Collection<Integer> expectedObject = List.of(1, 2, 3);

				Collection<Integer> actualObject = Checks.requireNotNullAndSize(object, 3);

				assertThat(actualObject).containsSequence(expectedObject);
			}

			/**
			 * Проверка метода {@link Checks#requireNotNullAndSize(Collection, int)} с некорректным значением
			 * из {@code null} в первом параметре.
			 */
			@Test
			public void requireNotNullAndSizeWithNull()
			{
				Collection<Integer> object = null;

				assertThatExceptionOfType(NullPointerException.class).isThrownBy(() -> {
					Checks.requireNotNullAndSize(object, 3);
				});
			}

			/**
			 * Проверка метода {@link Checks#requireNotNullAndSize(Collection, int)} с некорректным значением
			 * из пустой коллекции в первом параметре.
			 */
			@Test
			public void requireNotNullAndSizeWithEmpty()
			{
				Collection<Integer> object = List.of();

				assertThatExceptionOfType(IndexOutOfBoundsException.class).isThrownBy(() -> {
					Checks.requireNotNullAndSize(object, 3);
				});
			}

			/**
			 * Проверка метода {@link Checks#requireNotNullAndSize(Collection, int, String)} с сообщением
			 * для исключения.
			 */
			@Test
			public void requireNotNullAndSizeWithMessage()
			{
				Collection<Integer> object = null;

				assertThatExceptionOfType(NullPointerException.class).isThrownBy(() -> {
					Checks.requireNotNullAndSize(object, 3, "Сообщение");
				}).withMessage("Сообщение");
			}
		}

		/**
		 * Класс проверки метода {@link Checks#requireNotNullAndSizeRange(Collection, int, int)}.
		 *
		 * @author Алексей Каленчуков
		 */
		@Nested
		public class RequireNotNullAndSizeRange
		{
			/**
			 * Проверка метода {@link Checks#requireNotNullAndSizeRange(Collection, int, int)}.
			 */
			@Test
			public void requireNotNullAndSizeRange()
			{
				Collection<Integer> object = List.of(1, 2, 3);
				Collection<Integer> expectedObject = List.of(1, 2, 3);

				Collection<Integer> actualObject = Checks.requireNotNullAndSizeRange(object, 1, 3);

				assertThat(actualObject).containsSequence(expectedObject);
			}

			/**
			 * Проверка метода {@link Checks#requireNotNullAndSizeRange(Collection, int, int)} с некорректным значением
			 * из {@code null} в первом параметре.
			 */
			@Test
			public void requireNotNullAndSizeRangeWithNull()
			{
				Collection<Integer> object = null;

				assertThatExceptionOfType(NullPointerException.class).isThrownBy(() -> {
					Checks.requireNotNullAndSizeRange(object, 1, 3);
				});
			}

			/**
			 * Проверка метода {@link Checks#requireNotNullAndSizeRange(Collection, int, int)} с некорректным значением
			 * из пустой коллекции в первом параметре.
			 */
			@Test
			public void requireNotNullAndSizeRangeWithEmpty()
			{
				Collection<Integer> object = List.of();

				assertThatExceptionOfType(IndexOutOfBoundsException.class).isThrownBy(() -> {
					Checks.requireNotNullAndSizeRange(object, 1, 3);
				});
			}

			/**
			 * Проверка метода {@link Checks#requireNotNullAndSizeRange(Collection, int, int)} с некорректным значением
			 * в виде нарушения нижней границы.
			 */
			@Test
			public void requireNotNullAndSizeRangeWithInvalidFrom()
			{
				Collection<Integer> object = List.of(1);

				assertThatExceptionOfType(IndexOutOfBoundsException.class).isThrownBy(() -> {
					Checks.requireNotNullAndSizeRange(object, 2, 3);
				});
			}

			/**
			 * Проверка метода {@link Checks#requireNotNullAndSizeRange(Collection, int, int)} с некорректным значением
			 * в виде нарушения верхней границы.
			 */
			@Test
			public void requireNotNullAndSizeRangeWithInvalidTo()
			{
				Collection<Integer> object = List.of(1, 2, 3, 4);

				assertThatExceptionOfType(IndexOutOfBoundsException.class).isThrownBy(() -> {
					Checks.requireNotNullAndSizeRange(object, 2, 3);
				});
			}

			/**
			 * Проверка метода {@link Checks#requireNotNullAndSizeRange(Collection, int, int, String)} с сообщением
			 * для исключения.
			 */
			@Test
			public void requireNotNullAndSizeRangeWithMessage()
			{
				Collection<Integer> object = null;

				assertThatExceptionOfType(NullPointerException.class).isThrownBy(() -> {
					Checks.requireNotNullAndSizeRange(object, 1, 3, "Сообщение");
				}).withMessage("Сообщение");
			}
		}

		/**
		 * Класс проверки метода {@link Checks#requireNotNullAndLengthRange(CharSequence, int, int)}.
		 *
		 * @author Алексей Каленчуков
		 */
		@Nested
		public class RequireNotNullAndLengthRange
		{
			/**
			 * Проверка метода {@link Checks#requireNotNullAndLengthRange(CharSequence, int, int)}.
			 */
			@Test
			public void requireNotNullAndLengthRange()
			{
				String object = "Текст";
				String expectedObject = "Текст";

				String actualObject = Checks.requireNotNullAndLengthRange(object, 1, 5);

				assertThat(actualObject).containsSequence(expectedObject);
			}

			/**
			 * Проверка метода {@link Checks#requireNotNullAndLengthRange(CharSequence, int, int)} с некорректным значением
			 * из {@code null} в первом параметре.
			 */
			@Test
			public void requireNotNullAndLengthWithNull()
			{
				String object = null;

				assertThatExceptionOfType(NullPointerException.class).isThrownBy(() -> {
					Checks.requireNotNullAndLengthRange(object, 1, 5);
				});
			}

			/**
			 * Проверка метода {@link Checks#requireNotNullAndLengthRange(CharSequence, int, int)} с некорректным значением
			 * из пустой строки в первом параметре.
			 */
			@Test
			public void requireNotNullAndLengthWithEmpty()
			{
				String object = "";

				assertThatExceptionOfType(IndexOutOfBoundsException.class).isThrownBy(() -> {
					Checks.requireNotNullAndLengthRange(object, 1, 5);
				});
			}

			/**
			 * Проверка метода {@link Checks#requireNotNullAndLengthRange(CharSequence, int, int)} с некорректным значением
			 * в виде нарушения нижней границы.
			 */
			@Test
			public void requireNotNullAndLengthWithInvalidFrom()
			{
				String object = "Т";

				assertThatExceptionOfType(IndexOutOfBoundsException.class).isThrownBy(() -> {
					Checks.requireNotNullAndLengthRange(object, 2, 5);
				});
			}

			/**
			 * Проверка метода {@link Checks#requireNotNullAndLengthRange(CharSequence, int, int)} с некорректным значением
			 * в виде нарушения верхней границы.
			 */
			@Test
			public void requireNotNullAndLengthWithInvalidTo()
			{
				String object = "Тексты";

				assertThatExceptionOfType(IndexOutOfBoundsException.class).isThrownBy(() -> {
					Checks.requireNotNullAndLengthRange(object, 2, 5);
				});
			}

			/**
			 * Проверка метода {@link Checks#requireNotNullAndLengthRange(CharSequence, int, int, String)} с сообщением
			 * для исключения.
			 */
			@Test
			public void requireNotNullAndLengthWithMessage()
			{
				String object = null;

				assertThatExceptionOfType(NullPointerException.class).isThrownBy(() -> {
					Checks.requireNotNullAndLengthRange(object, 1, 5, "Сообщение");
				}).withMessage("Сообщение");
			}
		}
	}
}