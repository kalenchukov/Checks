/*
 * Copyright © 2023 Алексей Каленчуков
 * GitHub: https://github.com/kalenchukov
 * E-mail: mailto:aleksey.kalenchukov@yandex.ru
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dev.kalenchukov.checks.handlers;

import dev.kalenchukov.checks.exceptions.*;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Класс проверки методов класса {@link AbstractCharSequenceCheck}.
 *
 * @author Алексей Каленчуков
 */
public class AbstractCharSequenceCheckTest
{
	/**
	 * Класс проверки метода {@link AbstractCharSequenceCheck#notEmpty()}.
	 *
	 * @author Алексей Каленчуков
	 */
	@Nested
	public class NotEmpty
	{
		/**
		 * Проверка метода {@link AbstractCharSequenceCheck#notEmpty()}.
		 */
		@Test
		public void notEmpty()
		{
			StringBuilder object = new StringBuilder(
				"Сосны на морском берегу"
			);
			StringBuilderCheck stringBuilderCheck = new StringBuilderCheck(object);

			StringBuilderCheck actual = stringBuilderCheck.notEmpty();

			assertThat(actual).isSameAs(stringBuilderCheck);
		}

		/**
		 * Проверка метода {@link AbstractCharSequenceCheck#notEmpty()} с некорректным значением.
		 */
		@Test
		public void notEmptyWithValueInvalid()
		{
			StringBuilder object = new StringBuilder();
			StringBuilderCheck stringBuilderCheck = new StringBuilderCheck(object);

			assertThatExceptionOfType(EmptyObjectCheckException.class)
				.isThrownBy(stringBuilderCheck::notEmpty);
		}

		/**
		 * Проверка метода {@link AbstractCharSequenceCheck#notEmpty()} с некорректным значением в виде {@code null}.
		 */
		@Test
		public void notEmptyWithNull()
		{
			StringBuilder object = null;
			StringBuilderCheck stringBuilderCheck = new StringBuilderCheck(object);

			assertThatExceptionOfType(EmptyObjectCheckException.class)
				.isThrownBy(stringBuilderCheck::notEmpty);
		}
	}

	/**
	 * Класс проверки метода {@link AbstractCharSequenceCheck#notEmpty(String)}.
	 *
	 * @author Алексей Каленчуков
	 */
	@Nested
	public class NotEmptyWithMessage
	{
		/**
		 * Проверка метода {@link AbstractCharSequenceCheck#notEmpty(String)}.
		 */
		@Test
		public void notEmpty()
		{
			StringBuilder object = new StringBuilder(
				"Сосны на морском берегу"
			);
			String message = "Мне не долго осталось ждать, чтобы снова увидеть сосны на морском берегу...";
			StringBuilderCheck stringBuilderCheck = new StringBuilderCheck(object);

			StringBuilderCheck actual = stringBuilderCheck.notEmpty(message);

			assertThat(actual).isSameAs(stringBuilderCheck);
		}

		/**
		 * Проверка метода {@link AbstractCharSequenceCheck#notEmpty(String)} с некорректным значением.
		 */
		@Test
		public void notEmptyWithValueInvalid()
		{
			StringBuilder object = new StringBuilder();
			String message = "Мне не долго осталось ждать, чтобы снова увидеть сосны на морском берегу...";
			StringBuilderCheck stringBuilderCheck = new StringBuilderCheck(object);

			assertThatExceptionOfType(EmptyObjectCheckException.class)
				.isThrownBy(() -> stringBuilderCheck.notEmpty(message))
				.withMessage(message);
		}

		/**
		 * Проверка метода {@link AbstractCharSequenceCheck#notEmpty(String)} с некорректным значением в виде {@code null}.
		 */
		@Test
		public void notEmptyWithNull()
		{
			StringBuilder object = null;
			String message = "Мне не долго осталось ждать, чтобы снова увидеть сосны на морском берегу...";
			StringBuilderCheck stringBuilderCheck = new StringBuilderCheck(object);

			assertThatExceptionOfType(EmptyObjectCheckException.class)
				.isThrownBy(() -> stringBuilderCheck.notEmpty(message))
				.withMessage(message);
		}
	}

	/**
	 * Класс проверки метода {@link AbstractCharSequenceCheck#notLength(int)}.
	 *
	 * @author Алексей Каленчуков
	 */
	@Nested
	public class NotLength
	{
		/**
		 * Проверка метода {@link AbstractCharSequenceCheck#notLength(int)}.
		 */
		@Test
		public void notLength()
		{
			StringBuilder object = new StringBuilder(
				"Без десяти"
			);
			StringBuilderCheck stringBuilderCheck = new StringBuilderCheck(object);

			StringBuilderCheck actual = stringBuilderCheck.notLength(5);

			assertThat(actual).isSameAs(stringBuilderCheck);
		}

		/**
		 * Проверка метода {@link AbstractCharSequenceCheck#notLength(int)} с некорректным значением.
		 */
		@Test
		public void notLengthWithValueInvalid()
		{
			StringBuilder object = new StringBuilder(
				"Без десяти"
			);
			StringBuilderCheck stringBuilderCheck = new StringBuilderCheck(object);

			assertThatExceptionOfType(LengthObjectCheckException.class)
				.isThrownBy(() -> stringBuilderCheck.notLength(10));
		}

		/**
		 * Проверка метода {@link AbstractCharSequenceCheck#notLength(int)} с некорректным значением в виде {@code null}.
		 */
		@Test
		public void notLengthWithNull()
		{
			StringBuilder object = null;
			StringBuilderCheck stringBuilderCheck = new StringBuilderCheck(object);

			assertThatExceptionOfType(LengthObjectCheckException.class)
				.isThrownBy(() -> stringBuilderCheck.notLength(10));
		}
	}

	/**
	 * Класс проверки метода {@link AbstractCharSequenceCheck#notLength(int, String)}.
	 *
	 * @author Алексей Каленчуков
	 */
	@Nested
	public class NotLengthWithMessage
	{
		/**
		 * Проверка метода {@link AbstractCharSequenceCheck#notLength(int, String)}.
		 */
		@Test
		public void notLength()
		{
			StringBuilder object = new StringBuilder(
				"Без десяти"
			);
			String message = "В городе мне жить или на выселках?";
			StringBuilderCheck stringBuilderCheck = new StringBuilderCheck(object);

			StringBuilderCheck actual = stringBuilderCheck.notLength(5, message);

			assertThat(actual).isSameAs(stringBuilderCheck);
		}

		/**
		 * Проверка метода {@link AbstractCharSequenceCheck#notLength(int, String)} с некорректным значением.
		 */
		@Test
		public void notLengthWithValueInvalid()
		{
			StringBuilder object = new StringBuilder(
				"Без десяти"
			);
			String message = "В городе мне жить или на выселках?";
			StringBuilderCheck stringBuilderCheck = new StringBuilderCheck(object);

			assertThatExceptionOfType(LengthObjectCheckException.class)
				.isThrownBy(() -> stringBuilderCheck.notLength(10, message))
				.withMessage(message);
		}

		/**
		 * Проверка метода {@link AbstractCharSequenceCheck#notLength(int, String)} с некорректным значением в виде {@code null}.
		 */
		@Test
		public void notLengthWithNull()
		{
			StringBuilder object = null;
			String message = "В городе мне жить или на выселках?";
			StringBuilderCheck stringBuilderCheck = new StringBuilderCheck(object);

			assertThatExceptionOfType(LengthObjectCheckException.class)
				.isThrownBy(() -> stringBuilderCheck.notLength(10, message))
				.withMessage(message);
		}
	}

	/**
	 * Класс проверки метода {@link AbstractCharSequenceCheck#notRangeLength(int, int)}.
	 *
	 * @author Алексей Каленчуков
	 */
	@Nested
	public class NotRangeLength
	{
		/**
		 * Проверка метода {@link AbstractCharSequenceCheck#notRangeLength(int, int)}.
		 */
		@Test
		public void notRangeLength()
		{
			StringBuilder object = new StringBuilder(
				"Без десяти"
			);
			StringBuilderCheck stringBuilderCheck = new StringBuilderCheck(object);

			StringBuilderCheck actual = stringBuilderCheck.notRangeLength(20, 50);

			assertThat(actual).isSameAs(stringBuilderCheck);
		}

		/**
		 * Проверка метода {@link AbstractCharSequenceCheck#notRangeLength(int, int)} с некорректным значением.
		 */
		@Test
		public void notRangeLengthWithValueInvalid()
		{
			StringBuilder object = new StringBuilder(
				"Без десяти"
			);
			StringBuilderCheck stringBuilderCheck = new StringBuilderCheck(object);

			assertThatExceptionOfType(RangeLengthObjectCheckException.class)
				.isThrownBy(() -> stringBuilderCheck.notRangeLength(2, 10));
		}

		/**
		 * Проверка метода {@link AbstractCharSequenceCheck#notRangeLength(int, int)} с некорректным значением в виде {@code null}.
		 */
		@Test
		public void notRangeLengthWithNull()
		{
			StringBuilder object = null;
			StringBuilderCheck stringBuilderCheck = new StringBuilderCheck(object);

			assertThatExceptionOfType(RangeLengthObjectCheckException.class)
				.isThrownBy(() -> stringBuilderCheck.notRangeLength(2, 10));
		}
	}

	/**
	 * Класс проверки метода {@link AbstractCharSequenceCheck#notRangeLength(int, int, String)}.
	 *
	 * @author Алексей Каленчуков
	 */
	@Nested
	public class NotRangeLengthWithMessage
	{
		/**
		 * Проверка метода {@link AbstractCharSequenceCheck#notRangeLength(int, int, String)}.
		 */
		@Test
		public void notRangeLength()
		{
			StringBuilder object = new StringBuilder(
				"Без десяти"
			);
			String message = "Голову да плечи терпеливые под плеть...";
			StringBuilderCheck stringBuilderCheck = new StringBuilderCheck(object);

			StringBuilderCheck actual = stringBuilderCheck.notRangeLength(11, 15, message);

			assertThat(actual).isSameAs(stringBuilderCheck);
		}

		/**
		 * Проверка метода {@link AbstractCharSequenceCheck#notRangeLength(int, int, String)} с некорректным значением.
		 */
		@Test
		public void notRangeLengthWithValueInvalid()
		{
			StringBuilder object = new StringBuilder(
				"Без десяти"
			);
			String message = "Голову да плечи терпеливые под плеть...";
			StringBuilderCheck stringBuilderCheck = new StringBuilderCheck(object);

			assertThatExceptionOfType(RangeLengthObjectCheckException.class)
				.isThrownBy(() -> stringBuilderCheck.notRangeLength(2, 10, message))
				.withMessage(message);
		}

		/**
		 * Проверка метода {@link AbstractCharSequenceCheck#notRangeLength(int, int, String)} с некорректным значением в виде {@code null}.
		 */
		@Test
		public void notRangeLengthWithNull()
		{
			StringBuilder object = null;
			String message = "Голову да плечи терпеливые под плеть...";
			StringBuilderCheck stringBuilderCheck = new StringBuilderCheck(object);

			assertThatExceptionOfType(RangeLengthObjectCheckException.class)
				.isThrownBy(() -> stringBuilderCheck.notRangeLength(2, 10, message))
				.withMessage(message);
		}
	}

	/**
	 * Класс проверки метода {@link AbstractCharSequenceCheck#notMoreLength(int)}.
	 *
	 * @author Алексей Каленчуков
	 */
	@Nested
	public class NotMoreLength
	{
		/**
		 * Проверка метода {@link AbstractCharSequenceCheck#notMoreLength(int)}.
		 */
		@Test
		public void notMoreLength()
		{
			StringBuilder object = new StringBuilder(
				"Без десяти"
			);
			StringBuilderCheck stringBuilderCheck = new StringBuilderCheck(object);

			StringBuilderCheck actual = stringBuilderCheck.notMoreLength(10);

			assertThat(actual).isSameAs(stringBuilderCheck);
		}

		/**
		 * Проверка метода {@link AbstractCharSequenceCheck#notMoreLength(int)} с некорректным значением.
		 */
		@Test
		public void notMoreLengthWithValueInvalid()
		{
			StringBuilder object = new StringBuilder(
				"Без десяти"
			);
			StringBuilderCheck stringBuilderCheck = new StringBuilderCheck(object);

			assertThatExceptionOfType(MoreLengthObjectCheckException.class)
				.isThrownBy(() -> stringBuilderCheck.notMoreLength(7));
		}

		/**
		 * Проверка метода {@link AbstractCharSequenceCheck#notMoreLength(int)} с некорректным значением в виде {@code null}.
		 */
		@Test
		public void notMoreLengthWithNull()
		{
			StringBuilder object = null;
			StringBuilderCheck stringBuilderCheck = new StringBuilderCheck(object);

			assertThatExceptionOfType(MoreLengthObjectCheckException.class)
				.isThrownBy(() -> stringBuilderCheck.notMoreLength(7));
		}
	}

	/**
	 * Класс проверки метода {@link AbstractCharSequenceCheck#notMoreLength(int, String)}.
	 *
	 * @author Алексей Каленчуков
	 */
	@Nested
	public class NotMoreLengthWithMessage
	{
		/**
		 * Проверка метода {@link AbstractCharSequenceCheck#notMoreLength(int, String)}.
		 */
		@Test
		public void notMoreLength()
		{
			StringBuilder object = new StringBuilder(
				"Без десяти"
			);
			String message = "Я сижу и смотрю в чужое небо из чужого окна...";
			StringBuilderCheck stringBuilderCheck = new StringBuilderCheck(object);

			StringBuilderCheck actual = stringBuilderCheck.notMoreLength(10, message);

			assertThat(actual).isSameAs(stringBuilderCheck);
		}

		/**
		 * Проверка метода {@link AbstractCharSequenceCheck#notMoreLength(int, String)} с некорректным значением.
		 */
		@Test
		public void notMoreLengthWithValueInvalid()
		{
			StringBuilder object = new StringBuilder(
				"Без десяти"
			);
			String message = "Я сижу и смотрю в чужое небо из чужого окна...";
			StringBuilderCheck stringBuilderCheck = new StringBuilderCheck(object);

			assertThatExceptionOfType(MoreLengthObjectCheckException.class)
				.isThrownBy(() -> stringBuilderCheck.notMoreLength(7, message))
				.withMessage(message);
		}

		/**
		 * Проверка метода {@link AbstractCharSequenceCheck#notMoreLength(int, String)} с некорректным значением в виде {@code null}.
		 */
		@Test
		public void notMoreLengthWithNull()
		{
			StringBuilder object = null;
			String message = "Я сижу и смотрю в чужое небо из чужого окна...";
			StringBuilderCheck stringBuilderCheck = new StringBuilderCheck(object);

			assertThatExceptionOfType(MoreLengthObjectCheckException.class)
				.isThrownBy(() -> stringBuilderCheck.notMoreLength(7, message))
				.withMessage(message);
		}
	}

	/**
	 * Класс проверки метода {@link AbstractCharSequenceCheck#notLessLength(int)}.
	 *
	 * @author Алексей Каленчуков
	 */
	@Nested
	public class NotLessLength
	{
		/**
		 * Проверка метода {@link AbstractCharSequenceCheck#notLessLength(int)}.
		 */
		@Test
		public void notLessLength()
		{
			StringBuilder object = new StringBuilder(
				"Без десяти"
			);
			StringBuilderCheck stringBuilderCheck = new StringBuilderCheck(object);

			StringBuilderCheck actual = stringBuilderCheck.notLessLength(6);

			assertThat(actual).isSameAs(stringBuilderCheck);
		}

		/**
		 * Проверка метода {@link AbstractCharSequenceCheck#notLessLength(int)} с некорректным значением.
		 */
		@Test
		public void notLessLengthWithValueInvalid()
		{
			StringBuilder object = new StringBuilder(
				"Без десяти"
			);
			StringBuilderCheck stringBuilderCheck = new StringBuilderCheck(object);

			assertThatExceptionOfType(LessLengthObjectCheckException.class)
				.isThrownBy(() -> stringBuilderCheck.notLessLength(16));
		}

		/**
		 * Проверка метода {@link AbstractCharSequenceCheck#notLessLength(int)} с некорректным значением в виде {@code null}.
		 */
		@Test
		public void notLessLengthWithNull()
		{
			StringBuilder object = null;
			StringBuilderCheck stringBuilderCheck = new StringBuilderCheck(object);

			assertThatExceptionOfType(LessLengthObjectCheckException.class)
				.isThrownBy(() -> stringBuilderCheck.notLessLength(16));
		}
	}

	/**
	 * Класс проверки метода {@link AbstractCharSequenceCheck#notLessLength(int, String)}.
	 *
	 * @author Алексей Каленчуков
	 */
	@Nested
	public class NotLessLengthWithMessage
	{
		/**
		 * Проверка метода {@link AbstractCharSequenceCheck#notLessLength(int, String)}.
		 */
		@Test
		public void notLessLength()
		{
			StringBuilder object = new StringBuilder(
				"Без десяти"
			);
			String message = "Но если есть в кармане пачка сигарет...";
			StringBuilderCheck stringBuilderCheck = new StringBuilderCheck(object);

			StringBuilderCheck actual = stringBuilderCheck.notLessLength(6, message);

			assertThat(actual).isSameAs(stringBuilderCheck);
		}

		/**
		 * Проверка метода {@link AbstractCharSequenceCheck#notLessLength(int, String)} с некорректным значением.
		 */
		@Test
		public void notLessLengthWithValueInvalid()
		{
			StringBuilder object = new StringBuilder(
				"Без десяти"
			);
			String message = "Но если есть в кармане пачка сигарет...";
			StringBuilderCheck stringBuilderCheck = new StringBuilderCheck(object);

			assertThatExceptionOfType(LessLengthObjectCheckException.class)
				.isThrownBy(() -> stringBuilderCheck.notLessLength(16, message))
				.withMessage(message);
		}

		/**
		 * Проверка метода {@link AbstractCharSequenceCheck#notLessLength(int, String)} с некорректным значением в виде {@code null}.
		 */
		@Test
		public void notLessLengthWithNull()
		{
			StringBuilder object = null;
			String message = "Но если есть в кармане пачка сигарет...";
			StringBuilderCheck stringBuilderCheck = new StringBuilderCheck(object);

			assertThatExceptionOfType(LessLengthObjectCheckException.class)
				.isThrownBy(() -> stringBuilderCheck.notLessLength(16, message))
				.withMessage(message);
		}
	}
}