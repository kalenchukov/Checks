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

import dev.kalenchukov.checks.exceptions.BlankObjectCheckException;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

/**
 * Класс проверки методов класса {@link StringCheck}.
 *
 * @author Алексей Каленчуков
 */
public class StringCheckTest
{
	/**
	 * Класс проверки метода {@link StringCheck#notBlank()}.
	 *
	 * @author Алексей Каленчуков
	 */
	@Nested
	public class NotBlank
	{
		/**
		 * Проверка метода {@link StringCheck#notBlank()}.
		 */
		@Test
		public void notBlank()
		{
			String object = "Красно-жёлтые дни";
			StringCheck stringCheck = new StringCheck(object);

			StringCheck actual = stringCheck.notBlank();

			assertThat(actual).isSameAs(stringCheck);
		}

		/**
		 * Проверка метода {@link StringCheck#notBlank()} с некорректным значением.
		 */
		@Test
		public void notBlankWithValueInvalid()
		{
			String object = "\t";
			StringCheck stringCheck = new StringCheck(object);

			assertThatExceptionOfType(BlankObjectCheckException.class)
				.isThrownBy(stringCheck::notBlank);
		}

		/**
		 * Проверка метода {@link StringCheck#notBlank()} с некорректным значением в виде {@code null}.
		 */
		@Test
		public void notBlankWithNull()
		{
			String object = null;
			StringCheck stringCheck = new StringCheck(object);

			assertThatExceptionOfType(BlankObjectCheckException.class)
				.isThrownBy(stringCheck::notBlank);
		}
	}

	/**
	 * Класс проверки метода {@link StringCheck#notBlank(String)}.
	 *
	 * @author Алексей Каленчуков
	 */
	@Nested
	public class NotBlankWithMessage
	{
		/**
		 * Проверка метода {@link StringCheck#notBlank(String)}.
		 */
		@Test
		public void notBlank()
		{
			String object = "Красно-жёлтые дни";
			String message = "...Завтра скажут - прощай навсегда. Заалеет сердечная рана...";
			StringCheck stringCheck = new StringCheck(object);

			StringCheck actual = stringCheck.notBlank(message);

			assertThat(actual).isSameAs(stringCheck);
		}

		/**
		 * Проверка метода {@link StringCheck#notBlank(String)} с некорректным значением.
		 */
		@Test
		public void notBlankWithValueInvalid()
		{
			String object = " ";
			String message = "...Завтра скажут - прощай навсегда. Заалеет сердечная рана...";
			StringCheck stringCheck = new StringCheck(object);

			assertThatExceptionOfType(BlankObjectCheckException.class)
				.isThrownBy(() -> stringCheck.notBlank(message))
				.withMessage(message);
		}

		/**
		 * Проверка метода {@link StringCheck#notBlank(String)} с некорректным значением в виде {@code null}.
		 */
		@Test
		public void notBlankWithNull()
		{
			String object = null;
			String message = "...Завтра скажут - прощай навсегда. Заалеет сердечная рана...";
			StringCheck stringCheck = new StringCheck(object);

			assertThatExceptionOfType(BlankObjectCheckException.class)
				.isThrownBy(() -> stringCheck.notBlank(message))
				.withMessage(message);
		}
	}
}