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

import dev.kalenchukov.checks.exceptions.ZeroNumberObjectCheckException;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * Класс проверки методов класса {@link AbstractNumberCheck}.
 *
 * @author Алексей Каленчуков
 */
public class AbstractNumberCheckTest
{
	/**
	 * Класс проверки метода {@link AbstractNumberCheck#notZero()}.
	 *
	 * @author Алексей Каленчуков
	 */
	@Nested
	public class NotZero
	{
		/**
		 * Проверка метода {@link AbstractNumberCheck#notZero()}.
		 */
		@Test
		public void notZero()
		{
			Integer object = 17;
			IntegerCheck integerCheck = new IntegerCheck(object);

			IntegerCheck actual = integerCheck.notZero();

			assertThat(actual).isSameAs(integerCheck);
		}

		/**
		 * Проверка метода {@link AbstractNumberCheck#notZero()} с некорректным значением.
		 */
		@Test
		public void notZeroWithValueInvalid()
		{
			Integer object = 0;
			IntegerCheck integerCheck = new IntegerCheck(object);

			assertThatExceptionOfType(ZeroNumberObjectCheckException.class)
				.isThrownBy(integerCheck::notZero);
		}

		/**
		 * Проверка метода {@link AbstractNumberCheck#notZero()} с некорректным значением в виде {@code null}.
		 */
		@Test
		public void notZeroWithNull()
		{
			Integer object = null;
			IntegerCheck integerCheck = new IntegerCheck(object);

			assertThatExceptionOfType(ZeroNumberObjectCheckException.class)
				.isThrownBy(integerCheck::notZero);
		}
	}

	/**
	 * Класс проверки метода {@link AbstractNumberCheck#notZero(String)}.
	 *
	 * @author Алексей Каленчуков
	 */
	@Nested
	public class NotZeroWithMessage
	{
		/**
		 * Проверка метода {@link AbstractNumberCheck#notZero(String)}.
		 */
		@Test
		public void notZero()
		{
			Integer object = 17;
			String message = "В толпе я, как иголка в сене";
			IntegerCheck integerCheck = new IntegerCheck(object);

			IntegerCheck actual = integerCheck.notZero(message);

			assertThat(actual).isSameAs(integerCheck);
		}

		/**
		 * Проверка метода {@link AbstractNumberCheck#notZero(String)} с некорректным значением.
		 */
		@Test
		public void notZeroWithValueInvalid()
		{
			Integer object = 0;
			String message = "В толпе я, как иголка в сене";
			IntegerCheck integerCheck = new IntegerCheck(object);

			assertThatExceptionOfType(ZeroNumberObjectCheckException.class)
				.isThrownBy(() -> integerCheck.notZero(message))
				.withMessage(message);
		}

		/**
		 * Проверка метода {@link AbstractNumberCheck#notZero(String)} с некорректным значением в виде {@code null}.
		 */
		@Test
		public void notZeroWithNull()
		{
			Integer object = null;
			String message = "В толпе я, как иголка в сене";
			IntegerCheck integerCheck = new IntegerCheck(object);

			assertThatExceptionOfType(ZeroNumberObjectCheckException.class)
				.isThrownBy(() -> integerCheck.notZero(message))
				.withMessage(message);
		}
	}
}