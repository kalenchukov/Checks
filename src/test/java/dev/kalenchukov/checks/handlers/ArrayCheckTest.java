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

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Класс проверки методов класса {@link ArrayCheck}.
 *
 * @author Алексей Каленчуков
 */
public class ArrayCheckTest
{
	/**
	 * Класс проверки метода {@link ArrayCheck#notEmpty()}.
	 *
	 * @author Алексей Каленчуков
	 */
	@Nested
	public class NotEmpty
	{
		/**
		 * Проверка метода {@link ArrayCheck#notEmpty()} с корректным значением.
		 */
		@Test
		public void notEmptyValid()
		{
			String[] object = {
				"Я вчера слишком поздно лёг, сегодня рано встал..."
			};
			ArrayCheck<String> arrayCheck = new ArrayCheck<>(object);

			ArrayCheck<String> actual = arrayCheck.notEmpty();

			assertThat(actual).isSameAs(arrayCheck);
		}

		/**
		 * Проверка метода {@link ArrayCheck#notEmpty()} с некорректным значением.
		 */
		@Test
		public void notEmptyInvalid()
		{
			String[] object = {};
			ArrayCheck<String> arrayCheck = new ArrayCheck<>(object);

			assertThatExceptionOfType(EmptyObjectCheckException.class)
				.isThrownBy(arrayCheck::notEmpty);
		}
	}

	/**
	 * Класс проверки метода {@link ArrayCheck#notEmpty(String)}.
	 *
	 * @author Алексей Каленчуков
	 */
	@Nested
	public class NotEmptyWithMessage
	{
		/**
		 * Проверка метода {@link ArrayCheck#notEmpty(String)} с корректным значением.
		 */
		@Test
		public void notEmptyValid()
		{
			String[] object = {
				"Я вчера слишком поздно лёг, сегодня рано встал..."
			};
			String message = "Электричка везёт меня туда, куда я не хочу...";
			ArrayCheck<String> arrayCheck = new ArrayCheck<>(object);

			ArrayCheck<String> actual = arrayCheck.notEmpty(message);

			assertThat(actual).isSameAs(arrayCheck);
		}

		/**
		 * Проверка метода {@link ArrayCheck#notEmpty(String)} с некорректным значением.
		 */
		@Test
		public void notEmptyInvalid()
		{
			String[] object = {};
			String message = "Электричка везёт меня туда, куда я не хочу...";
			ArrayCheck<String> arrayCheck = new ArrayCheck<>(object);

			assertThatExceptionOfType(EmptyObjectCheckException.class)
				.isThrownBy(() -> arrayCheck.notEmpty(message))
				.withMessage(message);
		}
	}

	/**
	 * Класс проверки метода {@link ArrayCheck#notSize(int)}.
	 *
	 * @author Алексей Каленчуков
	 */
	@Nested
	public class NotSize
	{
		/**
		 * Проверка метода {@link ArrayCheck#notSize(int)} с корректным значением.
		 */
		@Test
		public void notSizeValid()
		{
			String[] object = {
				"Заголосуют тысячи рук..."
			};
			ArrayCheck<String> arrayCheck = new ArrayCheck<>(object);

			ArrayCheck<String> actual = arrayCheck.notSize(2);

			assertThat(actual).isSameAs(arrayCheck);
		}

		/**
		 * Проверка метода {@link ArrayCheck#notSize(int)} с некорректным значением.
		 */
		@Test
		public void notSizeInvalid()
		{
			String[] object = {
				"Заголосуют тысячи рук..."
			};
			ArrayCheck<String> arrayCheck = new ArrayCheck<>(object);

			assertThatExceptionOfType(SizeObjectCheckException.class)
				.isThrownBy(() -> arrayCheck.notSize(1));
		}

		/**
		 * Проверка метода {@link ArrayCheck#notSize(int)} с некорректным значением в виде {@code null}.
		 */
		@Test
		public void notSizeWithNull()
		{
			String[] object = null;
			ArrayCheck<String> arrayCheck = new ArrayCheck<>(object);

			assertThatExceptionOfType(SizeObjectCheckException.class)
				.isThrownBy(() -> arrayCheck.notSize(1));
		}
	}

	/**
	 * Класс проверки метода {@link ArrayCheck#notSize(int, String)}.
	 *
	 * @author Алексей Каленчуков
	 */
	@Nested
	public class NotSizeWithMessage
	{
		/**
		 * Проверка метода {@link ArrayCheck#notSize(int, String)} с корректным значением.
		 */
		@Test
		public void notSizeValid()
		{
			String[] object = {
				"Заголосуют тысячи рук..."
			};
			String message = "Эх заедает меня тоска, верная подруга моя";
			ArrayCheck<String> arrayCheck = new ArrayCheck<>(object);

			ArrayCheck<String> actual = arrayCheck.notSize(2, message);

			assertThat(actual).isSameAs(arrayCheck);
		}

		/**
		 * Проверка метода {@link ArrayCheck#notSize(int, String)} с некорректным значением.
		 */
		@Test
		public void notSizeInvalid()
		{
			String[] object = {
				"Заголосуют тысячи рук..."
			};
			String message = "Эх заедает меня тоска, верная подруга моя";
			ArrayCheck<String> arrayCheck = new ArrayCheck<>(object);

			assertThatExceptionOfType(SizeObjectCheckException.class)
				.isThrownBy(() -> arrayCheck.notSize(1, message))
				.withMessage(message);
		}

		/**
		 * Проверка метода {@link ArrayCheck#notSize(int, String)} с некорректным значением в виде {@code null}.
		 */
		@Test
		public void notSizeWithNull()
		{
			String[] object = null;
			String message = "Эх заедает меня тоска, верная подруга моя";
			ArrayCheck<String> arrayCheck = new ArrayCheck<>(object);

			assertThatExceptionOfType(SizeObjectCheckException.class)
				.isThrownBy(() -> arrayCheck.notSize(1, message))
				.withMessage(message);
		}
	}

	/**
	 * Класс проверки метода {@link ArrayCheck#notRangeSize(int, int)}.
	 *
	 * @author Алексей Каленчуков
	 */
	@Nested
	public class NotRangeSize
	{
		/**
		 * Проверка метода {@link ArrayCheck#notRangeSize(int, int)} с корректным значением.
		 */
		@Test
		public void notRangeSizeValid()
		{
			String[] object = {
				"Это сладкое слово Камчатка..."
			};
			ArrayCheck<String> arrayCheck = new ArrayCheck<>(object);

			ArrayCheck<String> actual = arrayCheck.notRangeSize(2, 10);

			assertThat(actual).isSameAs(arrayCheck);
		}

		/**
		 * Проверка метода {@link ArrayCheck#notRangeSize(int, int)} с некорректным значением.
		 */
		@Test
		public void notRangeSizeInvalid()
		{
			String[] object = {
				"Это сладкое слово Камчатка..."
			};
			ArrayCheck<String> arrayCheck = new ArrayCheck<>(object);

			assertThatExceptionOfType(RangeSizeObjectCheckException.class)
				.isThrownBy(() -> arrayCheck.notRangeSize(1, 3));
		}

		/**
		 * Проверка метода {@link ArrayCheck#notRangeSize(int, int)} с некорректным значением в виде {@code null}.
		 */
		@Test
		public void notRangeSizeWithNull()
		{
			String[] object = null;
			ArrayCheck<String> arrayCheck = new ArrayCheck<>(object);

			assertThatExceptionOfType(RangeSizeObjectCheckException.class)
				.isThrownBy(() -> arrayCheck.notRangeSize(1, 3));
		}
	}

	/**
	 * Класс проверки метода {@link ArrayCheck#notRangeSize(int, int, String)}.
	 *
	 * @author Алексей Каленчуков
	 */
	@Nested
	public class NotRangeSizeWithMessage
	{
		/**
		 * Проверка метода {@link ArrayCheck#notRangeSize(int, int, String)} с корректным значением.
		 */
		@Test
		public void notRangeSizeValid()
		{
			String[] object = {
				"Это сладкое слово Камчатка..."
			};
			String message = "Я искал здесь вино, а нашёл только квас...";
			ArrayCheck<String> arrayCheck = new ArrayCheck<>(object);

			ArrayCheck<String> actual = arrayCheck.notRangeSize(2, 10, message);

			assertThat(actual).isSameAs(arrayCheck);
		}

		/**
		 * Проверка метода {@link ArrayCheck#notRangeSize(int, int, String)} с некорректным значением.
		 */
		@Test
		public void notRangeSizeInvalid()
		{
			String[] object = {
				"Это сладкое слово Камчатка..."
			};
			String message = "Я искал здесь вино, а нашёл только квас...";
			ArrayCheck<String> arrayCheck = new ArrayCheck<>(object);

			assertThatExceptionOfType(RangeSizeObjectCheckException.class)
				.isThrownBy(() -> arrayCheck.notRangeSize(1, 3, message))
				.withMessage(message);
		}

		/**
		 * Проверка метода {@link ArrayCheck#notRangeSize(int, int, String)} с некорректным значением в виде {@code null}.
		 */
		@Test
		public void notRangeSizeWithNull()
		{
			String[] object = null;
			String message = "Я искал здесь вино, а нашёл только квас...";
			ArrayCheck<String> arrayCheck = new ArrayCheck<>(object);

			assertThatExceptionOfType(RangeSizeObjectCheckException.class)
				.isThrownBy(() -> arrayCheck.notRangeSize(1, 3, message))
				.withMessage(message);
		}
	}

	/**
	 * Класс проверки метода {@link ArrayCheck#notMoreSize(int)}.
	 *
	 * @author Алексей Каленчуков
	 */
	@Nested
	public class NotMoreSize
	{
		/**
		 * Проверка метода {@link ArrayCheck#notMoreSize(int)} с корректным значением.
		 */
		@Test
		public void notMoreSizeValid()
		{
			String[] object = {
				"Моё настроение зависит от количества выпитого пива...",
				"Просто хочешь ты знать"
			};
			ArrayCheck<String> arrayCheck = new ArrayCheck<>(object);

			ArrayCheck<String> actual = arrayCheck.notMoreSize(3);

			assertThat(actual).isSameAs(arrayCheck);
		}

		/**
		 * Проверка метода {@link ArrayCheck#notMoreSize(int)} с некорректным значением.
		 */
		@Test
		public void notMoreSizeInvalid()
		{
			String[] object = {
				"Моё настроение зависит от количества выпитого пива...",
				"Просто хочешь ты знать"
			};
			ArrayCheck<String> arrayCheck = new ArrayCheck<>(object);

			assertThatExceptionOfType(MoreSizeObjectCheckException.class)
				.isThrownBy(() -> arrayCheck.notMoreSize(1));
		}

		/**
		 * Проверка метода {@link ArrayCheck#notMoreSize(int)} с некорректным значением в виде {@code null}.
		 */
		@Test
		public void notMoreSizeWithNull()
		{
			String[] object = null;
			ArrayCheck<String> arrayCheck = new ArrayCheck<>(object);

			assertThatExceptionOfType(MoreSizeObjectCheckException.class)
				.isThrownBy(() -> arrayCheck.notMoreSize(1));
		}
	}

	/**
	 * Класс проверки метода {@link ArrayCheck#notMoreSize(int, String)}.
	 *
	 * @author Алексей Каленчуков
	 */
	@Nested
	public class NotMoreSizeWithMessage
	{
		/**
		 * Проверка метода {@link ArrayCheck#notMoreSize(int, String)} с корректным значением.
		 */
		@Test
		public void notMoreSizeValid()
		{
			String[] object = {
				"Моё настроение зависит от количества выпитого пива...",
				"Просто хочешь ты знать"
			};
			String message = "Ты просишь свежих новостей...";
			ArrayCheck<String> arrayCheck = new ArrayCheck<>(object);

			ArrayCheck<String> actual = arrayCheck.notMoreSize(3, message);

			assertThat(actual).isSameAs(arrayCheck);
		}

		/**
		 * Проверка метода {@link ArrayCheck#notMoreSize(int, String)} с некорректным значением.
		 */
		@Test
		public void notMoreSizeInvalid()
		{
			String[] object = {
				"Моё настроение зависит от количества выпитого пива...",
				"Просто хочешь ты знать"
			};
			String message = "Ты просишь свежих новостей...";
			ArrayCheck<String> arrayCheck = new ArrayCheck<>(object);

			assertThatExceptionOfType(MoreSizeObjectCheckException.class)
				.isThrownBy(() -> arrayCheck.notMoreSize(1, message))
				.withMessage(message);
		}

		/**
		 * Проверка метода {@link ArrayCheck#notMoreSize(int, String)} с некорректным значением в виде {@code null}.
		 */
		@Test
		public void notMoreSizeWithNull()
		{
			String[] object = {
				"Моё настроение зависит от количества выпитого пива...",
				"Просто хочешь ты знать"
			};
			String message = "Ты просишь свежих новостей...";
			ArrayCheck<String> arrayCheck = new ArrayCheck<>(object);

			assertThatExceptionOfType(MoreSizeObjectCheckException.class)
				.isThrownBy(() -> arrayCheck.notMoreSize(1, message))
				.withMessage(message);
		}
	}

	/**
	 * Класс проверки метода {@link ArrayCheck#notLessSize(int)}.
	 *
	 * @author Алексей Каленчуков
	 */
	@Nested
	public class NotLessSize
	{
		/**
		 * Проверка метода {@link ArrayCheck#notLessSize(int)} с корректным значением.
		 */
		@Test
		public void notLessSizeValid()
		{
			String[] object = {
				"Тебя зовут туда, где пьют...",
				"Просто хочешь ты знать, где и что происходит..."
			};
			ArrayCheck<String> arrayCheck = new ArrayCheck<>(object);

			ArrayCheck<String> actual = arrayCheck.notLessSize(1);

			assertThat(actual).isSameAs(arrayCheck);
		}

		/**
		 * Проверка метода {@link ArrayCheck#notLessSize(int)} с некорректным значением.
		 */
		@Test
		public void notLessSizeInvalid()
		{
			String[] object = {
				"Тебя зовут туда, где пьют...",
				"Просто хочешь ты знать, где и что происходит..."
			};
			ArrayCheck<String> arrayCheck = new ArrayCheck<>(object);

			assertThatExceptionOfType(LessSizeObjectCheckException.class)
				.isThrownBy(() -> arrayCheck.notLessSize(3));
		}

		/**
		 * Проверка метода {@link ArrayCheck#notLessSize(int)} с некорректным значением в виде {@code null}.
		 */
		@Test
		public void notLessSizeWithNull()
		{
			String[] object = null;
			ArrayCheck<String> arrayCheck = new ArrayCheck<>(object);

			assertThatExceptionOfType(LessSizeObjectCheckException.class)
				.isThrownBy(() -> arrayCheck.notLessSize(3));
		}
	}

	/**
	 * Класс проверки метода {@link ArrayCheck#notLessSize(int, String)}.
	 *
	 * @author Алексей Каленчуков
	 */
	@Nested
	public class NotLessSizeWithMessage
	{
		/**
		 * Проверка метода {@link ArrayCheck#notLessSize(int, String)} с корректным значением.
		 */
		@Test
		public void notLessSizeValid()
		{
			String[] object = {
				"Тебя зовут туда, где пьют...",
				"Просто хочешь ты знать, где и что происходит..."
			};
			String message = "Снова новый начинается день. Снова утро прожектором бьёт из окна...";
			ArrayCheck<String> arrayCheck = new ArrayCheck<>(object);

			ArrayCheck<String> actual = arrayCheck.notLessSize(1, message);

			assertThat(actual).isSameAs(arrayCheck);
		}

		/**
		 * Проверка метода {@link ArrayCheck#notLessSize(int, String)} с некорректным значением.
		 */
		@Test
		public void notLessSizeInvalid()
		{
			String[] object = {
				"Тебя зовут туда, где пьют...",
				"Просто хочешь ты знать, где и что происходит..."
			};
			String message = "Снова новый начинается день. Снова утро прожектором бьёт из окна...";
			ArrayCheck<String> arrayCheck = new ArrayCheck<>(object);

			assertThatExceptionOfType(LessSizeObjectCheckException.class)
				.isThrownBy(() -> arrayCheck.notLessSize(3, message))
				.withMessage(message);
		}

		/**
		 * Проверка метода {@link ArrayCheck#notLessSize(int, String)} с некорректным значением в виде {@code null}.
		 */
		@Test
		public void notLessSizeWithNull()
		{
			String[] object = null;
			String message = "Снова новый начинается день. Снова утро прожектором бьёт из окна...";
			ArrayCheck<String> arrayCheck = new ArrayCheck<>(object);

			assertThatExceptionOfType(LessSizeObjectCheckException.class)
				.isThrownBy(() -> arrayCheck.notLessSize(3, message))
				.withMessage(message);
		}
	}
}