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

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Класс проверки методов класса {@link MapCheck}.
 *
 * @author Алексей Каленчуков
 */
public class MapCheckTest
{
	/**
	 * Класс проверки метода {@link MapCheck#notEmpty()}.
	 *
	 * @author Алексей Каленчуков
	 */
	@Nested
	public class NotEmpty
	{
		/**
		 * Проверка метода {@link MapCheck#notEmpty()}.
		 */
		@Test
		public void notEmpty()
		{
			Map<Integer, String> object = Map.of(
				1, "Там за окном, сказка с несчастливым концом..."
			);
			MapCheck<Integer, String> mapCheck = new MapCheck<>(object);

			MapCheck<Integer, String> actual = mapCheck.notEmpty();

			assertThat(actual).isSameAs(mapCheck);
		}

		/**
		 * Проверка метода {@link MapCheck#notEmpty()} с некорректным значением.
		 */
		@Test
		public void notEmptyWithValueInvalid()
		{
			Map<Integer, String> object = Map.of();
			MapCheck<Integer, String> mapCheck = new MapCheck<>(object);

			assertThatExceptionOfType(EmptyObjectCheckException.class)
				.isThrownBy(mapCheck::notEmpty);
		}

		/**
		 * Проверка метода {@link MapCheck#notEmpty()} с некорректным значением в виде {@code null}.
		 */
		@Test
		public void notEmptyWithNull()
		{
			Map<Integer, String> object = null;
			MapCheck<Integer, String> mapCheck = new MapCheck<>(object);

			assertThatExceptionOfType(EmptyObjectCheckException.class)
				.isThrownBy(mapCheck::notEmpty);
		}
	}

	/**
	 * Класс проверки метода {@link MapCheck#notEmpty(String)}.
	 *
	 * @author Алексей Каленчуков
	 */
	@Nested
	public class NotEmptyWithMessage
	{
		/**
		 * Проверка метода {@link MapCheck#notEmpty(String)}.
		 */
		@Test
		public void notEmpty()
		{
			Map<Integer, String> object = Map.of(
				1, "Там за окном, сказка с несчастливым концом..."
			);
			String message = "А один из них как-нибудь утром придумает порох...";
			MapCheck<Integer, String> mapCheck = new MapCheck<>(object);

			MapCheck<Integer, String> actual = mapCheck.notEmpty(message);

			assertThat(actual).isSameAs(mapCheck);
		}

		/**
		 * Проверка метода {@link MapCheck#notEmpty(String)} с некорректным значением.
		 */
		@Test
		public void notEmptyWithValueInvalid()
		{
			Map<Integer, String> object = Map.of();
			String message = "А один из них как-нибудь утром придумает порох...";
			MapCheck<Integer, String> mapCheck = new MapCheck<>(object);

			assertThatExceptionOfType(EmptyObjectCheckException.class)
				.isThrownBy(() -> mapCheck.notEmpty(message))
				.withMessage(message);
		}

		/**
		 * Проверка метода {@link MapCheck#notEmpty(String)} с некорректным значением в виде {@code null}.
		 */
		@Test
		public void notEmptyWithNull()
		{
			Map<Integer, String> object = null;
			String message = "А один из них как-нибудь утром придумает порох...";
			MapCheck<Integer, String> mapCheck = new MapCheck<>(object);

			assertThatExceptionOfType(EmptyObjectCheckException.class)
				.isThrownBy(() -> mapCheck.notEmpty(message))
				.withMessage(message);
		}
	}

	/**
	 * Класс проверки метода {@link MapCheck#notSize(int)}.
	 *
	 * @author Алексей Каленчуков
	 */
	@Nested
	public class NotSize
	{
		/**
		 * Проверка метода {@link MapCheck#notSize(int)}.
		 */
		@Test
		public void notSize()
		{
			Map<Integer, String> object = Map.of(
				1, "У меня есть вопрос, на который ты не дашь мне ответ..."
			);
			MapCheck<Integer, String> mapCheck = new MapCheck<>(object);

			MapCheck<Integer, String> actual = mapCheck.notSize(0);

			assertThat(actual).isSameAs(mapCheck);
		}

		/**
		 * Проверка метода {@link MapCheck#notSize(int)} с некорректным значением.
		 */
		@Test
		public void notSizeWithValueInvalid()
		{
			Map<Integer, String> object = Map.of(
				1, "У меня есть вопрос, на который ты не дашь мне ответ..."
			);
			MapCheck<Integer, String> mapCheck = new MapCheck<>(object);

			assertThatExceptionOfType(SizeObjectCheckException.class)
				.isThrownBy(() -> mapCheck.notSize(1));
		}

		/**
		 * Проверка метода {@link MapCheck#notSize(int)} с некорректным значением в виде {@code null}.
		 */
		@Test
		public void notSizeWithNull()
		{
			Map<Integer, String> object = null;
			MapCheck<Integer, String> mapCheck = new MapCheck<>(object);

			assertThatExceptionOfType(SizeObjectCheckException.class)
				.isThrownBy(() -> mapCheck.notSize(1));
		}
	}

	/**
	 * Класс проверки метода {@link MapCheck#notSize(int, String)}.
	 *
	 * @author Алексей Каленчуков
	 */
	@Nested
	public class NotSizeWithMessage
	{
		/**
		 * Проверка метода {@link MapCheck#notSize(int, String)}.
		 */
		@Test
		public void notSize()
		{
			Map<Integer, String> object = Map.of(
				1, "У меня есть вопрос, на который ты не дашь мне ответ..."
			);
			String message = "В последнее время я редко был дома...";
			MapCheck<Integer, String> mapCheck = new MapCheck<>(object);

			MapCheck<Integer, String> actual = mapCheck.notSize(0, message);

			assertThat(actual).isSameAs(mapCheck);
		}

		/**
		 * Проверка метода {@link MapCheck#notSize(int, String)} с некорректным значением.
		 */
		@Test
		public void notSizeWithValueInvalid()
		{
			Map<Integer, String> object = Map.of(
				1, "У меня есть вопрос, на который ты не дашь мне ответ..."
			);
			String message = "В последнее время я редко был дома...";
			MapCheck<Integer, String> mapCheck = new MapCheck<>(object);

			assertThatExceptionOfType(SizeObjectCheckException.class)
				.isThrownBy(() -> mapCheck.notSize(1, message))
				.withMessage(message);
		}

		/**
		 * Проверка метода {@link MapCheck#notSize(int, String)} с некорректным значением в виде {@code null}.
		 */
		@Test
		public void notSizeWithNull()
		{
			Map<Integer, String> object = null;
			String message = "В последнее время я редко был дома...";
			MapCheck<Integer, String> mapCheck = new MapCheck<>(object);

			assertThatExceptionOfType(SizeObjectCheckException.class)
				.isThrownBy(() -> mapCheck.notSize(1, message))
				.withMessage(message);
		}
	}

	/**
	 * Класс проверки метода {@link MapCheck#notRangeSize(int, int)}.
	 *
	 * @author Алексей Каленчуков
	 */
	@Nested
	public class NotRangeSize
	{
		/**
		 * Проверка метода {@link MapCheck#notRangeSize(int, int)}.
		 */
		@Test
		public void notRangeSize()
		{
			Map<Integer, String> object = Map.of(
				1, "А потом будет лето, неизвестно зачем..."
			);
			MapCheck<Integer, String> mapCheck = new MapCheck<>(object);

			MapCheck<Integer, String> actual = mapCheck.notRangeSize(2, 10);

			assertThat(actual).isSameAs(mapCheck);
		}

		/**
		 * Проверка метода {@link MapCheck#notRangeSize(int, int)} с некорректным значением.
		 */
		@Test
		public void notRangeSizeWithValueInvalid()
		{
			Map<Integer, String> object = Map.of(
				1, "А потом будет лето, неизвестно зачем..."
			);
			MapCheck<Integer, String> mapCheck = new MapCheck<>(object);

			assertThatExceptionOfType(RangeSizeObjectCheckException.class)
				.isThrownBy(() -> mapCheck.notRangeSize(1, 3));
		}

		/**
		 * Проверка метода {@link MapCheck#notRangeSize(int, int)} с некорректным значением в виде {@code null}.
		 */
		@Test
		public void notRangeSizeWithNull()
		{
			Map<Integer, String> object = null;
			MapCheck<Integer, String> mapCheck = new MapCheck<>(object);

			assertThatExceptionOfType(RangeSizeObjectCheckException.class)
				.isThrownBy(() -> mapCheck.notRangeSize(1, 3));
		}
	}

	/**
	 * Класс проверки метода {@link MapCheck#notRangeSize(int, int, String)}.
	 *
	 * @author Алексей Каленчуков
	 */
	@Nested
	public class NotRangeSizeWithMessage
	{
		/**
		 * Проверка метода {@link MapCheck#notRangeSize(int, int, String)}.
		 */
		@Test
		public void notRangeSize()
		{
			Map<Integer, String> object = Map.of(
				1, "А потом будет лето, неизвестно зачем..."
			);
			String message = "ночь коротка, цель долека...";
			MapCheck<Integer, String> mapCheck = new MapCheck<>(object);

			MapCheck<Integer, String> actual = mapCheck.notRangeSize(2, 10, message);

			assertThat(actual).isSameAs(mapCheck);
		}

		/**
		 * Проверка метода {@link MapCheck#notRangeSize(int, int, String)} с некорректным значением.
		 */
		@Test
		public void notRangeSizeWithValueInvalid()
		{
			Map<Integer, String> object = Map.of(
				1, "А потом будет лето, неизвестно зачем..."
			);
			String message = "ночь коротка, цель долека...";
			MapCheck<Integer, String> mapCheck = new MapCheck<>(object);

			assertThatExceptionOfType(RangeSizeObjectCheckException.class)
				.isThrownBy(() -> mapCheck.notRangeSize(1, 3, message))
				.withMessage(message);
		}

		/**
		 * Проверка метода {@link MapCheck#notRangeSize(int, int, String)} с некорректным значением в виде {@code null}.
		 */
		@Test
		public void notRangeSizeWithNull()
		{
			Map<Integer, String> object = null;
			String message = "ночь коротка, цель долека...";
			MapCheck<Integer, String> mapCheck = new MapCheck<>(object);

			assertThatExceptionOfType(RangeSizeObjectCheckException.class)
				.isThrownBy(() -> mapCheck.notRangeSize(1, 3, message))
				.withMessage(message);
		}
	}

	/**
	 * Класс проверки метода {@link MapCheck#notMoreSize(int)}.
	 *
	 * @author Алексей Каленчуков
	 */
	@Nested
	public class NotMoreSize
	{
		/**
		 * Проверка метода {@link MapCheck#notMoreSize(int)}.
		 */
		@Test
		public void notMoreSize()
		{
			Map<Integer, String> object = Map.of(
				1, "Ты хотел быть один, но не смог быть один..."
			);
			MapCheck<Integer, String> mapCheck = new MapCheck<>(object);

			MapCheck<Integer, String> actual = mapCheck.notMoreSize(1);

			assertThat(actual).isSameAs(mapCheck);
		}

		/**
		 * Проверка метода {@link MapCheck#notMoreSize(int)} с некорректным значением.
		 */
		@Test
		public void notMoreSizeWithValueInvalid()
		{
			Map<Integer, String> object = Map.of(
				1, "А потом будет лето, неизвестно зачем...",
				2, "Телефонный звонок как команда - вперёд!..."
			);
			MapCheck<Integer, String> mapCheck = new MapCheck<>(object);

			assertThatExceptionOfType(MoreSizeObjectCheckException.class)
				.isThrownBy(() -> mapCheck.notMoreSize(1));
		}

		/**
		 * Проверка метода {@link MapCheck#notMoreSize(int)} с некорректным значением в виде {@code null}.
		 */
		@Test
		public void notMoreSizeWithNull()
		{
			Map<Integer, String> object = null;
			MapCheck<Integer, String> mapCheck = new MapCheck<>(object);

			assertThatExceptionOfType(MoreSizeObjectCheckException.class)
				.isThrownBy(() -> mapCheck.notMoreSize(1));
		}
	}

	/**
	 * Класс проверки метода {@link MapCheck#notMoreSize(int, String)}.
	 *
	 * @author Алексей Каленчуков
	 */
	@Nested
	public class NotMoreSizeWithMessage
	{
		/**
		 * Проверка метода {@link MapCheck#notMoreSize(int, String)}.
		 */
		@Test
		public void notMoreSize()
		{
			Map<Integer, String> object = Map.of(
				1, "Ты хотел быть один, но не смог быть один..."
			);
			String message = "Каждой звезде - свой неба кусок...";
			MapCheck<Integer, String> mapCheck = new MapCheck<>(object);

			MapCheck<Integer, String> actual = mapCheck.notMoreSize(1, message);

			assertThat(actual).isSameAs(mapCheck);
		}

		/**
		 * Проверка метода {@link MapCheck#notMoreSize(int, String)} с некорректным значением.
		 */
		@Test
		public void notMoreSizeWithValueInvalid()
		{
			Map<Integer, String> object = Map.of(
				1, "А потом будет лето, неизвестно зачем...",
				2, "Телефонный звонок как команда - вперёд!..."
			);
			String message = "Каждой звезде - свой неба кусок...";
			MapCheck<Integer, String> mapCheck = new MapCheck<>(object);

			assertThatExceptionOfType(MoreSizeObjectCheckException.class)
				.isThrownBy(() -> mapCheck.notMoreSize(1, message))
				.withMessage(message);
		}

		/**
		 * Проверка метода {@link MapCheck#notMoreSize(int, String)} с некорректным значением в виде {@code null}.
		 */
		@Test
		public void notMoreSizeWithNull()
		{
			Map<Integer, String> object = null;
			String message = "Каждой звезде - свой неба кусок...";
			MapCheck<Integer, String> mapCheck = new MapCheck<>(object);

			assertThatExceptionOfType(MoreSizeObjectCheckException.class)
				.isThrownBy(() -> mapCheck.notMoreSize(1, message))
				.withMessage(message);
		}
	}

	/**
	 * Класс проверки метода {@link MapCheck#notLessSize(int)}.
	 *
	 * @author Алексей Каленчуков
	 */
	@Nested
	public class NotLessSize
	{
		/**
		 * Проверка метода {@link MapCheck#notLessSize(int)}.
		 */
		@Test
		public void notLessSize()
		{
			Map<Integer, String> object = Map.of(
				1, "Если есть стадо, значит есть постух..."
			);
			MapCheck<Integer, String> mapCheck = new MapCheck<>(object);

			MapCheck<Integer, String> actual = mapCheck.notLessSize(1);

			assertThat(actual).isSameAs(mapCheck);
		}

		/**
		 * Проверка метода {@link MapCheck#notLessSize(int)} с некорректным значением.
		 */
		@Test
		public void notLessSizeWithValueInvalid()
		{
			Map<Integer, String> object = Map.of(
				1, "Если есть стадо, значит есть постух..."
			);
			MapCheck<Integer, String> mapCheck = new MapCheck<>(object);

			assertThatExceptionOfType(LessSizeObjectCheckException.class)
				.isThrownBy(() -> mapCheck.notLessSize(2));
		}

		/**
		 * Проверка метода {@link MapCheck#notLessSize(int)} с некорректным значением в виде {@code null}.
		 */
		@Test
		public void notLessSizeWithNull()
		{
			Map<Integer, String> object = null;
			MapCheck<Integer, String> mapCheck = new MapCheck<>(object);

			assertThatExceptionOfType(LessSizeObjectCheckException.class)
				.isThrownBy(() -> mapCheck.notLessSize(2));
		}
	}

	/**
	 * Класс проверки метода {@link MapCheck#notLessSize(int, String)}.
	 *
	 * @author Алексей Каленчуков
	 */
	@Nested
	public class NotLessSizeWithMessage
	{
		/**
		 * Проверка метода {@link MapCheck#notLessSize(int, String)}.
		 */
		@Test
		public void notLessSize()
		{
			Map<Integer, String> object = Map.of(
				1, "Если есть стадо, значит есть постух..."
			);
			String message = "Кто ваша Мама ребята? спросил у ребят солдат...";
			MapCheck<Integer, String> mapCheck = new MapCheck<>(object);

			MapCheck<Integer, String> actual = mapCheck.notLessSize(1, message);

			assertThat(actual).isSameAs(mapCheck);
		}

		/**
		 * Проверка метода {@link MapCheck#notLessSize(int, String)} с некорректным значением.
		 */
		@Test
		public void notLessSizeWithValueInvalid()
		{
			Map<Integer, String> object = Map.of(
				1, "Если есть стадо, значит есть постух..."
			);
			String message = "Кто ваша Мама ребята? спросил у ребят солдат...";
			MapCheck<Integer, String> mapCheck = new MapCheck<>(object);

			assertThatExceptionOfType(LessSizeObjectCheckException.class)
				.isThrownBy(() -> mapCheck.notLessSize(2, message))
				.withMessage(message);
		}

		/**
		 * Проверка метода {@link MapCheck#notLessSize(int, String)} с некорректным значением в виде {@code null}.
		 */
		@Test
		public void notLessSizeWithNull()
		{
			Map<Integer, String> object = null;
			String message = "Кто ваша Мама ребята? спросил у ребят солдат...";
			MapCheck<Integer, String> mapCheck = new MapCheck<>(object);

			assertThatExceptionOfType(LessSizeObjectCheckException.class)
				.isThrownBy(() -> mapCheck.notLessSize(2, message))
				.withMessage(message);
		}
	}
}