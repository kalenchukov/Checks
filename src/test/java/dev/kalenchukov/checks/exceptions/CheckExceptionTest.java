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

package dev.kalenchukov.checks.exceptions;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Класс проверки методов класса {@link CheckException}.
 *
 * @author Алексей Каленчуков
 */
public class CheckExceptionTest
{
	/**
	 * Класс проверки метода {@link CheckException#getCulprit()}.
	 *
	 * @author Алексей Каленчуков
	 */
	@Nested
	public class GetCulprit
	{
		/**
		 * Проверка метода {@link CheckException#getCulprit()} с корректным значением.
		 */
		@Test
		public void getCulpritValid()
		{
			String object = "Доброе утро, последний герой...";
			CheckException checkException = new CheckException(object);

			String actual = (String) checkException.getCulprit();

			assertThat(actual).isSameAs(object);
		}
	}

	/**
	 * Класс проверки метода {@link CheckException#getMessage()}.
	 *
	 * @author Алексей Каленчуков
	 */
	@Nested
	public class GetMessage
	{
		/**
		 * Проверка метода {@link CheckException#getMessage()} с корректным значением.
		 */
		@Test
		public void getMessageValid()
		{
			String object = "Доброе утро, последний герой...";
			String message = "Перемен, требуют наши сердца...";
			CheckException checkException = new CheckException(object, message);

			String actual = checkException.getMessage();

			assertThat(actual).isSameAs(message);
		}
	}
}