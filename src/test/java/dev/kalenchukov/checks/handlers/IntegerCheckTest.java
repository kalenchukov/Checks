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

/**
 * Класс проверки методов класса {@link IntegerCheck}.
 *
 * @author Алексей Каленчуков
 */
public class IntegerCheckTest
{
	/**
	 * Класс проверки метода {@link IntegerCheck#notNegative()}.
	 *
	 * @author Алексей Каленчуков
	 */
	@Nested
	public class NotNegative
	{
		/**
		 * Проверка метода {@link IntegerCheck#notNegative()}.
		 */
		@Test
		public void notNegative()
		{
			Integer object = 5745;
			IntegerCheck integerCheck = new IntegerCheck(object);

			IntegerCheck actual = integerCheck.notNegative();

			assertThat(actual).isSameAs(integerCheck);
		}

		/**
		 * Проверка метода {@link IntegerCheck#notNegative()} с некорректным значением.
		 */
		@Test
		public void notNegativeWithValueInvalid()
		{
			Integer object = -9754;
			IntegerCheck integerCheck = new IntegerCheck(object);

			assertThatExceptionOfType(NegativeNumberObjectCheckException.class)
				.isThrownBy(integerCheck::notNegative);
		}

		/**
		 * Проверка метода {@link IntegerCheck#notNegative()} с некорректным значением в виде {@code null}.
		 */
		@Test
		public void notNegativeWithNull()
		{
			Integer object = null;
			IntegerCheck integerCheck = new IntegerCheck(object);

			assertThatExceptionOfType(NegativeNumberObjectCheckException.class)
				.isThrownBy(integerCheck::notNegative);
		}
	}

	/**
	 * Класс проверки метода {@link IntegerCheck#notNegative(String)}.
	 *
	 * @author Алексей Каленчуков
	 */
	@Nested
	public class NotNegativeWithMessage
	{
		/**
		 * Проверка метода {@link IntegerCheck#notNegative(String)}.
		 */
		@Test
		public void notNegative()
		{
			Integer object = 5745;
			String message = "Времена меняются";
			IntegerCheck integerCheck = new IntegerCheck(object);

			IntegerCheck actual = integerCheck.notNegative(message);

			assertThat(actual).isSameAs(integerCheck);
		}

		/**
		 * Проверка метода {@link IntegerCheck#notNegative(String)} с некорректным значением.
		 */
		@Test
		public void notNegativeWithValueInvalid()
		{
			Integer object = -9754;
			String message = "Времена меняются";
			IntegerCheck integerCheck = new IntegerCheck(object);

			assertThatExceptionOfType(NegativeNumberObjectCheckException.class)
				.isThrownBy(() -> integerCheck.notNegative(message))
				.withMessage(message);
		}

		/**
		 * Проверка метода {@link IntegerCheck#notNegative(String)} с некорректным значением в виде {@code null}.
		 */
		@Test
		public void notNegativeWithNull()
		{
			Integer object = null;
			String message = "Времена меняются";
			IntegerCheck integerCheck = new IntegerCheck(object);

			assertThatExceptionOfType(NegativeNumberObjectCheckException.class)
				.isThrownBy(() -> integerCheck.notNegative(message))
				.withMessage(message);
		}
	}

	/**
	 * Класс проверки метода {@link IntegerCheck#notPositive()}.
	 *
	 * @author Алексей Каленчуков
	 */
	@Nested
	public class NotPositive
	{
		/**
		 * Проверка метода {@link IntegerCheck#notPositive()}.
		 */
		@Test
		public void notPositive()
		{
			Integer object = -231;
			IntegerCheck integerCheck = new IntegerCheck(object);

			IntegerCheck actual = integerCheck.notPositive();

			assertThat(actual).isSameAs(integerCheck);
		}

		/**
		 * Проверка метода {@link IntegerCheck#notPositive()} с некорректным значением.
		 */
		@Test
		public void notPositiveWithValueInvalid()
		{
			Integer object = 3455;
			IntegerCheck integerCheck = new IntegerCheck(object);

			assertThatExceptionOfType(PositiveNumberObjectCheckException.class)
				.isThrownBy(integerCheck::notPositive);
		}

		/**
		 * Проверка метода {@link IntegerCheck#notPositive()} с некорректным значением в виде {@code null}.
		 */
		@Test
		public void notPositiveWithNull()
		{
			Integer object = null;
			IntegerCheck integerCheck = new IntegerCheck(object);

			assertThatExceptionOfType(PositiveNumberObjectCheckException.class)
				.isThrownBy(integerCheck::notPositive);
		}
	}

	/**
	 * Класс проверки метода {@link IntegerCheck#notPositive(String)}.
	 *
	 * @author Алексей Каленчуков
	 */
	@Nested
	public class NotPositiveWithMessage
	{
		/**
		 * Проверка метода {@link IntegerCheck#notPositive(String)}.
		 */
		@Test
		public void notPositive()
		{
			Integer object = -231;
			String message = "И пойдём мы под постушью свирель, дружным стадом, на бойню...";
			IntegerCheck integerCheck = new IntegerCheck(object);

			IntegerCheck actual = integerCheck.notPositive(message);

			assertThat(actual).isSameAs(integerCheck);
		}

		/**
		 * Проверка метода {@link IntegerCheck#notPositive(String)} с некорректным значением.
		 */
		@Test
		public void notPositiveWithValueInvalid()
		{
			Integer object = 3455;
			String message = "И пойдём мы под постушью свирель, дружным стадом, на бойню...";
			IntegerCheck integerCheck = new IntegerCheck(object);

			assertThatExceptionOfType(PositiveNumberObjectCheckException.class)
				.isThrownBy(() -> integerCheck.notPositive(message))
				.withMessage(message);
		}

		/**
		 * Проверка метода {@link IntegerCheck#notPositive(String)} с некорректным значением в виде {@code null}.
		 */
		@Test
		public void notPositiveWithNull()
		{
			Integer object = null;
			String message = "И пойдём мы под постушью свирель, дружным стадом, на бойню...";
			IntegerCheck integerCheck = new IntegerCheck(object);

			assertThatExceptionOfType(PositiveNumberObjectCheckException.class)
				.isThrownBy(() -> integerCheck.notPositive(message))
				.withMessage(message);
		}
	}

	/**
	 * Класс проверки метода {@link IntegerCheck#notMoreNumber(Integer)}.
	 *
	 * @author Алексей Каленчуков
	 */
	@Nested
	public class NotMoreNumber
	{
		/**
		 * Проверка метода {@link IntegerCheck#notMoreNumber(Integer)}.
		 */
		@Test
		public void notMoreNumber()
		{
			Integer object = 97;
			IntegerCheck integerCheck = new IntegerCheck(object);

			IntegerCheck actual = integerCheck.notMoreNumber(100);

			assertThat(actual).isSameAs(integerCheck);
		}

		/**
		 * Проверка метода {@link IntegerCheck#notMoreNumber(Integer)} с некорректным значением.
		 */
		@Test
		public void notMoreNumberWithValueInvalid()
		{
			Integer object = 101;
			IntegerCheck integerCheck = new IntegerCheck(object);

			assertThatExceptionOfType(MoreNumberObjectCheckException.class)
				.isThrownBy(() -> integerCheck.notMoreNumber(100));
		}

		/**
		 * Проверка метода {@link IntegerCheck#notMoreNumber(Integer)} с некорректным значением в виде {@code null}.
		 */
		@Test
		public void notMoreNumberWithNull()
		{
			Integer object = null;
			IntegerCheck integerCheck = new IntegerCheck(object);

			assertThatExceptionOfType(MoreNumberObjectCheckException.class)
				.isThrownBy(() -> integerCheck.notMoreNumber(100));
		}
	}

	/**
	 * Класс проверки метода {@link IntegerCheck#notMoreNumber(Integer, String)}.
	 *
	 * @author Алексей Каленчуков
	 */
	@Nested
	public class NotMoreNumberWithMessage
	{
		/**
		 * Проверка метода {@link IntegerCheck#notMoreNumber(Integer, String)}.
		 */
		@Test
		public void notMoreNumber()
		{
			Integer object = 97;
			String message = "Так смотри не промахнись, Атаман, чтоб не дрогнула рука невзначай...";
			IntegerCheck integerCheck = new IntegerCheck(object);

			IntegerCheck actual = integerCheck.notMoreNumber(100, message);

			assertThat(actual).isSameAs(integerCheck);
		}

		/**
		 * Проверка метода {@link IntegerCheck#notMoreNumber(Integer, String)} с некорректным значением.
		 */
		@Test
		public void notMoreNumberWithValueInvalid()
		{
			Integer object = 101;
			String message = "Так смотри не промахнись, Атаман, чтоб не дрогнула рука невзначай...";
			IntegerCheck integerCheck = new IntegerCheck(object);

			assertThatExceptionOfType(MoreNumberObjectCheckException.class)
				.isThrownBy(() -> integerCheck.notMoreNumber(100, message))
				.withMessage(message);
		}

		/**
		 * Проверка метода {@link IntegerCheck#notMoreNumber(Integer, String)} с некорректным значением в виде {@code null}.
		 */
		@Test
		public void notMoreNumberWithNull()
		{
			Integer object = null;
			String message = "Так смотри не промахнись, Атаман, чтоб не дрогнула рука невзначай...";
			IntegerCheck integerCheck = new IntegerCheck(object);

			assertThatExceptionOfType(MoreNumberObjectCheckException.class)
				.isThrownBy(() -> integerCheck.notMoreNumber(100, message))
				.withMessage(message);
		}
	}

	/**
	 * Класс проверки метода {@link IntegerCheck#notLessNumber(Integer)}.
	 *
	 * @author Алексей Каленчуков
	 */
	@Nested
	public class NotLessNumber
	{
		/**
		 * Проверка метода {@link IntegerCheck#notLessNumber(Integer)}.
		 */
		@Test
		public void notLessNumber()
		{
			Integer object = 117;
			IntegerCheck integerCheck = new IntegerCheck(object);

			IntegerCheck actual = integerCheck.notLessNumber(100);

			assertThat(actual).isSameAs(integerCheck);
		}

		/**
		 * Проверка метода {@link IntegerCheck#notLessNumber(Integer)} с некорректным значением.
		 */
		@Test
		public void notLessNumberWithValueInvalid()
		{
			Integer object = 74;
			IntegerCheck integerCheck = new IntegerCheck(object);

			assertThatExceptionOfType(LessNumberObjectCheckException.class)
				.isThrownBy(() -> integerCheck.notLessNumber(100));
		}

		/**
		 * Проверка метода {@link IntegerCheck#notLessNumber(Integer)} с некорректным значением в виде {@code null}.
		 */
		@Test
		public void notLessNumberWithNull()
		{
			Integer object = null;
			IntegerCheck integerCheck = new IntegerCheck(object);

			assertThatExceptionOfType(LessNumberObjectCheckException.class)
				.isThrownBy(() -> integerCheck.notLessNumber(100));
		}
	}

	/**
	 * Класс проверки метода {@link IntegerCheck#notLessNumber(Integer, String)}.
	 *
	 * @author Алексей Каленчуков
	 */
	@Nested
	public class NotLessNumberWithMessage
	{
		/**
		 * Проверка метода {@link IntegerCheck#notLessNumber(Integer, String)}.
		 */
		@Test
		public void notLessNumber()
		{
			Integer object = 117;
			String message = "Наши реки бедны водой...";
			IntegerCheck integerCheck = new IntegerCheck(object);

			IntegerCheck actual = integerCheck.notLessNumber(100, message);

			assertThat(actual).isSameAs(integerCheck);
		}

		/**
		 * Проверка метода {@link IntegerCheck#notLessNumber(Integer, String)} с некорректным значением.
		 */
		@Test
		public void notLessNumberWithValueInvalid()
		{
			Integer object = 74;
			String message = "Наши реки бедны водой...";
			IntegerCheck integerCheck = new IntegerCheck(object);

			assertThatExceptionOfType(LessNumberObjectCheckException.class)
				.isThrownBy(() -> integerCheck.notLessNumber(100, message))
				.withMessage(message);
		}

		/**
		 * Проверка метода {@link IntegerCheck#notLessNumber(Integer, String)} с некорректным значением в виде {@code null}.
		 */
		@Test
		public void notLessNumberWithNull()
		{
			Integer object = null;
			String message = "Наши реки бедны водой...";
			IntegerCheck integerCheck = new IntegerCheck(object);

			assertThatExceptionOfType(LessNumberObjectCheckException.class)
				.isThrownBy(() -> integerCheck.notLessNumber(100, message))
				.withMessage(message);
		}
	}

	/**
	 * Класс проверки метода {@link IntegerCheck#notRangeNumber(Integer, Integer)}.
	 *
	 * @author Алексей Каленчуков
	 */
	@Nested
	public class NotRangeNumber
	{
		/**
		 * Проверка метода {@link IntegerCheck#notRangeNumber(Integer, Integer)}.
		 */
		@Test
		public void notRangeNumber()
		{
			Integer object = 6712;
			IntegerCheck integerCheck = new IntegerCheck(object);

			IntegerCheck actual = integerCheck.notRangeNumber(100, 1000);

			assertThat(actual).isSameAs(integerCheck);
		}

		/**
		 * Проверка метода {@link IntegerCheck#notRangeNumber(Integer, Integer)} с некорректным значением.
		 */
		@Test
		public void notRangeNumberWithValueInvalid()
		{
			Integer object = 746;
			IntegerCheck integerCheck = new IntegerCheck(object);

			assertThatExceptionOfType(RangeNumberObjectCheckException.class)
				.isThrownBy(() -> integerCheck.notRangeNumber(100, 1000));
		}

		/**
		 * Проверка метода {@link IntegerCheck#notRangeNumber(Integer, Integer)} с некорректным значением в виде {@code null}.
		 */
		@Test
		public void notRangeNumberWithNull()
		{
			Integer object = null;
			IntegerCheck integerCheck = new IntegerCheck(object);

			assertThatExceptionOfType(RangeNumberObjectCheckException.class)
				.isThrownBy(() -> integerCheck.notRangeNumber(100, 1000));
		}
	}

	/**
	 * Класс проверки метода {@link IntegerCheck#notRangeNumber(Integer, Integer, String)}.
	 *
	 * @author Алексей Каленчуков
	 */
	@Nested
	public class NotRangeNumberWithMessage
	{
		/**
		 * Проверка метода {@link IntegerCheck#notRangeNumber(Integer, Integer, String)}.
		 */
		@Test
		public void notRangeNumber()
		{
			Integer object = 1756;
			String message = "Здесь не понятно, где лицо, а где рыло...";
			IntegerCheck integerCheck = new IntegerCheck(object);

			IntegerCheck actual = integerCheck.notRangeNumber(100, 1000, message);

			assertThat(actual).isSameAs(integerCheck);
		}

		/**
		 * Проверка метода {@link IntegerCheck#notRangeNumber(Integer, Integer, String)} с некорректным значением.
		 */
		@Test
		public void notRangeNumberWithValueInvalid()
		{
			Integer object = 432;
			String message = "Здесь не понятно, где лицо, а где рыло...";
			IntegerCheck integerCheck = new IntegerCheck(object);

			assertThatExceptionOfType(RangeNumberObjectCheckException.class)
				.isThrownBy(() -> integerCheck.notRangeNumber(100, 1000, message))
				.withMessage(message);
		}

		/**
		 * Проверка метода {@link IntegerCheck#notRangeNumber(Integer, Integer, String)} с некорректным значением в виде {@code null}.
		 */
		@Test
		public void notRangeNumberWithNull()
		{
			Integer object = null;
			String message = "Здесь не понятно, где лицо, а где рыло...";
			IntegerCheck integerCheck = new IntegerCheck(object);

			assertThatExceptionOfType(RangeNumberObjectCheckException.class)
				.isThrownBy(() -> integerCheck.notRangeNumber(100, 1000, message))
				.withMessage(message);
		}
	}
}