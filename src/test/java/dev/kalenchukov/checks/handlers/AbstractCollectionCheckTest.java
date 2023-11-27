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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Класс проверки методов класса {@link AbstractCollectionCheck}.
 *
 * @author Алексей Каленчуков
 */
public class AbstractCollectionCheckTest
{
	/**
	 * Класс проверки метода {@link AbstractCollectionCheck#notEmpty()}.
	 *
	 * @author Алексей Каленчуков
	 */
	@Nested
	public class NotEmpty
	{
		/**
		 * Проверка метода {@link AbstractCollectionCheck#notEmpty()} с корректным значением.
		 */
		@Test
		public void notEmptyValid()
		{
			Collection<String> object = List.of(
				"Безъядерная зона"
			);
			CollectionCheck<String> collectionCheck = new CollectionCheck<>(object);

			CollectionCheck<String> actual = collectionCheck.notEmpty();

			assertThat(actual).isSameAs(collectionCheck);
		}

		/**
		 * Проверка метода {@link AbstractCollectionCheck#notEmpty()} с некорректным значением.
		 */
		@Test
		public void notEmptyInvalid()
		{
			Collection<String> object = List.of();
			CollectionCheck<String> collectionCheck = new CollectionCheck<>(object);

			assertThatExceptionOfType(EmptyObjectCheckException.class)
				.isThrownBy(collectionCheck::notEmpty);
		}

		/**
		 * Проверка метода {@link AbstractCollectionCheck#notEmpty()} с некорректным значением в виде {@code null}.
		 */
		@Test
		public void notEmptyWithNull()
		{
			Collection<String> object = null;
			CollectionCheck<String> collectionCheck = new CollectionCheck<>(object);

			assertThatExceptionOfType(EmptyObjectCheckException.class)
				.isThrownBy(collectionCheck::notEmpty);
		}
	}

	/**
	 * Класс проверки метода {@link AbstractCollectionCheck#notEmpty(String)}.
	 *
	 * @author Алексей Каленчуков
	 */
	@Nested
	public class NotEmptyWithMessage
	{
		/**
		 * Проверка метода {@link AbstractCollectionCheck#notEmpty(String)} с корректным значением.
		 */
		@Test
		public void notEmptyValid()
		{
			Collection<String> object = List.of(
				"Безъядерная зона"
			);
			String message = "Я не вижу реки, я не вижу моста, ну и пусть...";
			CollectionCheck<String> collectionCheck = new CollectionCheck<>(object);

			CollectionCheck<String> actual = collectionCheck.notEmpty(message);

			assertThat(actual).isSameAs(collectionCheck);
		}

		/**
		 * Проверка метода {@link AbstractCollectionCheck#notEmpty(String)} с некорректным значением.
		 */
		@Test
		public void notEmptyInvalid()
		{
			Collection<String> object = List.of();
			String message = "Я не вижу реки, я не вижу моста, ну и пусть...";
			CollectionCheck<String> collectionCheck = new CollectionCheck<>(object);

			assertThatExceptionOfType(EmptyObjectCheckException.class)
				.isThrownBy(() -> collectionCheck.notEmpty(message))
				.withMessage(message);
		}

		/**
		 * Проверка метода {@link AbstractCollectionCheck#notEmpty(String)} с некорректным значением в виде {@code null}.
		 */
		@Test
		public void notEmptyWithNull()
		{
			Collection<String> object = null;
			String message = "Я не вижу реки, я не вижу моста, ну и пусть...";
			CollectionCheck<String> collectionCheck = new CollectionCheck<>(object);

			assertThatExceptionOfType(EmptyObjectCheckException.class)
				.isThrownBy(() -> collectionCheck.notEmpty(message))
				.withMessage(message);
		}
	}

	/**
	 * Класс проверки метода {@link AbstractCollectionCheck#notSize(int)}.
	 *
	 * @author Алексей Каленчуков
	 */
	@Nested
	public class NotSize
	{
		/**
		 * Проверка метода {@link AbstractCollectionCheck#notSize(int)} с корректным значением.
		 */
		@Test
		public void notSizeValid()
		{
			Collection<String> object = List.of(
				"Кукушка"
			);
			CollectionCheck<String> collectionCheck = new CollectionCheck<>(object);

			CollectionCheck<String> actual = collectionCheck.notSize(2);

			assertThat(actual).isSameAs(collectionCheck);
		}

		/**
		 * Проверка метода {@link AbstractCollectionCheck#notSize(int)} с некорректным значением.
		 */
		@Test
		public void notSizeInvalid()
		{
			Collection<String> object = List.of(
				"Кукушка"
			);
			CollectionCheck<String> collectionCheck = new CollectionCheck<>(object);

			assertThatExceptionOfType(SizeObjectCheckException.class)
				.isThrownBy(() -> collectionCheck.notSize(1));
		}

		/**
		 * Проверка метода {@link AbstractCollectionCheck#notSize(int)} с некорректным значением в виде {@code null}.
		 */
		@Test
		public void notSizeWithNull()
		{
			Collection<String> object = null;
			CollectionCheck<String> collectionCheck = new CollectionCheck<>(object);

			assertThatExceptionOfType(SizeObjectCheckException.class)
				.isThrownBy(() -> collectionCheck.notSize(1));
		}
	}

	/**
	 * Класс проверки метода {@link AbstractCollectionCheck#notSize(int, String)}.
	 *
	 * @author Алексей Каленчуков
	 */
	@Nested
	public class NotSizeWithMessage
	{
		/**
		 * Проверка метода {@link AbstractCollectionCheck#notSize(int, String)} с корректным значением.
		 */
		@Test
		public void notSizeValid()
		{
			Collection<String> object = List.of(
				"Кукушка"
			);
			String message = "Кода ещё не написано, сколько? скажи, кукушка, пропой...";
			CollectionCheck<String> collectionCheck = new CollectionCheck<>(object);

			CollectionCheck<String> actual = collectionCheck.notSize(2, message);

			assertThat(actual).isSameAs(collectionCheck);
		}

		/**
		 * Проверка метода {@link AbstractCollectionCheck#notSize(int, String)} с некорректным значением.
		 */
		@Test
		public void notSizeInvalid()
		{
			Collection<String> object = List.of(
				"Белый день"
			);
			String message = "Сесть на электрический стул или трон...";
			CollectionCheck<String> collectionCheck = new CollectionCheck<>(object);

			assertThatExceptionOfType(SizeObjectCheckException.class)
				.isThrownBy(() -> collectionCheck.notSize(1, message))
				.withMessage(message);
		}

		/**
		 * Проверка метода {@link AbstractCollectionCheck#notSize(int, String)} с некорректным значением в виде {@code null}.
		 */
		@Test
		public void notSizeWithNull()
		{
			Collection<String> object = null;
			String message = "Сесть на электрический стул или трон...";
			CollectionCheck<String> collectionCheck = new CollectionCheck<>(object);

			assertThatExceptionOfType(SizeObjectCheckException.class)
				.isThrownBy(() -> collectionCheck.notSize(1, message))
				.withMessage(message);
		}
	}

	/**
	 * Класс проверки метода {@link AbstractCollectionCheck#notRangeSize(int, int)}.
	 *
	 * @author Алексей Каленчуков
	 */
	@Nested
	public class NotRangeSize
	{
		/**
		 * Проверка метода {@link AbstractCollectionCheck#notRangeSize(int, int)} с корректным значением.
		 */
		@Test
		public void notRangeSizeValid()
		{
			Collection<String> object = List.of(
				"Бездельник"
			);
			CollectionCheck<String> collectionCheck = new CollectionCheck<>(object);

			CollectionCheck<String> actual = collectionCheck.notRangeSize(2, 5);

			assertThat(actual).isSameAs(collectionCheck);
		}

		/**
		 * Проверка метода {@link AbstractCollectionCheck#notRangeSize(int, int)} с некорректным значением.
		 */
		@Test
		public void notRangeSizeInvalid()
		{
			Collection<String> object = List.of(
				"Бездельник"
			);
			CollectionCheck<String> collectionCheck = new CollectionCheck<>(object);

			assertThatExceptionOfType(RangeSizeObjectCheckException.class)
				.isThrownBy(() -> collectionCheck.notRangeSize(1, 5));
		}

		/**
		 * Проверка метода {@link AbstractCollectionCheck#notRangeSize(int, int)} с некорректным значением в виде {@code null}.
		 */
		@Test
		public void notRangeSizeWithNull()
		{
			Collection<String> object = null;
			CollectionCheck<String> collectionCheck = new CollectionCheck<>(object);

			assertThatExceptionOfType(RangeSizeObjectCheckException.class)
				.isThrownBy(() -> collectionCheck.notRangeSize(1, 5));
		}
	}

	/**
	 * Класс проверки метода {@link AbstractCollectionCheck#notRangeSize(int, int, String)}.
	 *
	 * @author Алексей Каленчуков
	 */
	@Nested
	public class NotRangeSizeWithMessage
	{
		/**
		 * Проверка метода {@link AbstractCollectionCheck#notRangeSize(int, int, String)} с корректным значением.
		 */
		@Test
		public void notRangeSizeValid()
		{
			Collection<String> object = List.of(
				"Бездельник"
			);
			String message = "Я бездельник уууууууууу... Мама, Мама, уууууу...";
			CollectionCheck<String> collectionCheck = new CollectionCheck<>(object);

			CollectionCheck<String> actual = collectionCheck.notRangeSize(5, 10, message);

			assertThat(actual).isSameAs(collectionCheck);
		}

		/**
		 * Проверка метода {@link AbstractCollectionCheck#notRangeSize(int, int, String)} с некорректным значением.
		 */
		@Test
		public void notRangeSizeInvalid()
		{
			Collection<String> object = List.of(
				"Бездельник"
			);
			String message = "Я бездельник уууууууууу... Мама, Мама, уууууу...";
			CollectionCheck<String> collectionCheck = new CollectionCheck<>(object);

			assertThatExceptionOfType(RangeSizeObjectCheckException.class)
				.isThrownBy(() -> collectionCheck.notRangeSize(1, 5, message))
				.withMessage(message);
		}

		/**
		 * Проверка метода {@link AbstractCollectionCheck#notRangeSize(int, int, String)} с некорректным значением в виде {@code null}.
		 */
		@Test
		public void notRangeSizeWithNull()
		{
			Collection<String> object = null;
			String message = "Я бездельник уууууууууу... Мама, Мама, уууууу...";
			CollectionCheck<String> collectionCheck = new CollectionCheck<>(object);

			assertThatExceptionOfType(RangeSizeObjectCheckException.class)
				.isThrownBy(() -> collectionCheck.notRangeSize(1, 5, message))
				.withMessage(message);
		}
	}

	/**
	 * Класс проверки метода {@link AbstractCollectionCheck#notMoreSize(int)}.
	 *
	 * @author Алексей Каленчуков
	 */
	@Nested
	public class NotMoreSize
	{
		/**
		 * Проверка метода {@link AbstractCollectionCheck#notMoreSize(int)} с корректным значением.
		 */
		@Test
		public void notMoreSizeValid()
		{
			Collection<String> object = List.of(
				"Бошетунмай"
			);
			CollectionCheck<String> collectionCheck = new CollectionCheck<>(object);

			CollectionCheck<String> actual = collectionCheck.notMoreSize(1);

			assertThat(actual).isSameAs(collectionCheck);
		}

		/**
		 * Проверка метода {@link AbstractCollectionCheck#notMoreSize(int)} с некорректным значением.
		 */
		@Test
		public void notMoreSizeInvalid()
		{
			Collection<String> object = List.of(
				"Бошетунмай",
				"Время есть а денег нет"
			);
			CollectionCheck<String> collectionCheck = new CollectionCheck<>(object);

			assertThatExceptionOfType(MoreSizeObjectCheckException.class)
				.isThrownBy(() -> collectionCheck.notMoreSize(1));
		}

		/**
		 * Проверка метода {@link AbstractCollectionCheck#notMoreSize(int)} с некорректным значением в виде {@code null}.
		 */
		@Test
		public void notMoreSizeWithNull()
		{
			Collection<String> object = null;
			CollectionCheck<String> collectionCheck = new CollectionCheck<>(object);

			assertThatExceptionOfType(MoreSizeObjectCheckException.class)
				.isThrownBy(() -> collectionCheck.notMoreSize(1));
		}
	}

	/**
	 * Класс проверки метода {@link AbstractCollectionCheck#notMoreSize(int, String)}.
	 *
	 * @author Алексей Каленчуков
	 */
	@Nested
	public class NotMoreSizeWithMessage
	{
		/**
		 * Проверка метода {@link AbstractCollectionCheck#notMoreSize(int, String)} с корректным значением.
		 */
		@Test
		public void notMoreSizeValid()
		{
			Collection<String> object = List.of(
				"Дождь"
			);
			String message = "Я смотрю в окно, мне дождь помыл окно...";
			CollectionCheck<String> collectionCheck = new CollectionCheck<>(object);

			CollectionCheck<String> actual = collectionCheck.notMoreSize(1, message);

			assertThat(actual).isSameAs(collectionCheck);
		}

		/**
		 * Проверка метода {@link AbstractCollectionCheck#notMoreSize(int, String)} с некорректным значением.
		 */
		@Test
		public void notMoreSizeInvalid()
		{
			Collection<String> object = List.of(
				"Дождь",
				"Время есть а денег нет"
			);
			String message = "Я смотрю в окно, мне дождь помыл окно...";
			CollectionCheck<String> collectionCheck = new CollectionCheck<>(object);

			assertThatExceptionOfType(MoreSizeObjectCheckException.class)
				.isThrownBy(() -> collectionCheck.notMoreSize(1, message))
				.withMessage(message);
		}

		/**
		 * Проверка метода {@link AbstractCollectionCheck#notMoreSize(int, String)} с некорректным значением в виде {@code null}.
		 */
		@Test
		public void notMoreSizeWithNull()
		{
			Collection<String> object = null;
			String message = "Я смотрю в окно, мне дождь помыл окно...";
			CollectionCheck<String> collectionCheck = new CollectionCheck<>(object);

			assertThatExceptionOfType(MoreSizeObjectCheckException.class)
				.isThrownBy(() -> collectionCheck.notMoreSize(1, message))
				.withMessage(message);
		}
	}

	/**
	 * Класс проверки метода {@link AbstractCollectionCheck#notLessSize(int)}.
	 *
	 * @author Алексей Каленчуков
	 */
	@Nested
	public class NotLessSize
	{
		/**
		 * Проверка метода {@link AbstractCollectionCheck#notLessSize(int)} с корректным значением.
		 */
		@Test
		public void notLessSizeValid()
		{
			Collection<String> object = List.of(
				"Дождь",
				"Электричка",
				"Ситар играл"
			);
			CollectionCheck<String> collectionCheck = new CollectionCheck<>(object);

			CollectionCheck<String> actual = collectionCheck.notLessSize(2);

			assertThat(actual).isSameAs(collectionCheck);
		}

		/**
		 * Проверка метода {@link AbstractCollectionCheck#notLessSize(int)} с некорректным значением.
		 */
		@Test
		public void notLessSizeInvalid()
		{
			Collection<String> object = List.of(
				"Дождь",
				"Электричка",
				"Ситар играл"
			);
			CollectionCheck<String> collectionCheck = new CollectionCheck<>(object);

			assertThatExceptionOfType(LessSizeObjectCheckException.class)
				.isThrownBy(() -> collectionCheck.notLessSize(4));
		}

		/**
		 * Проверка метода {@link AbstractCollectionCheck#notLessSize(int)} с некорректным значением в виде {@code null}.
		 */
		@Test
		public void notLessSizeWithNull()
		{
			Collection<String> object = null;
			CollectionCheck<String> collectionCheck = new CollectionCheck<>(object);

			assertThatExceptionOfType(LessSizeObjectCheckException.class)
				.isThrownBy(() -> collectionCheck.notLessSize(4));
		}
	}

	/**
	 * Класс проверки метода {@link AbstractCollectionCheck#notLessSize(int, String)}.
	 *
	 * @author Алексей Каленчуков
	 */
	@Nested
	public class NotLessSizeWithMessage
	{
		/**
		 * Проверка метода {@link AbstractCollectionCheck#notLessSize(int, String)} с корректным значением.
		 */
		@Test
		public void notLessSizeValid()
		{
			Collection<String> object = List.of(
				"Музыка волн",
				"Электричка",
				"Ситар играл"
			);
			String message = "Я вижу как волны смывают следы на песке";
			CollectionCheck<String> collectionCheck = new CollectionCheck<>(object);

			CollectionCheck<String> actual = collectionCheck.notLessSize(2, message);

			assertThat(actual).isSameAs(collectionCheck);
		}

		/**
		 * Проверка метода {@link AbstractCollectionCheck#notLessSize(int, String)} с некорректным значением.
		 */
		@Test
		public void notLessSizeInvalid()
		{
			Collection<String> object = List.of(
				"Музыка волн",
				"Электричка",
				"Ситар играл"
			);
			String message = "Здесь нужно руками кидать воду вверх";
			CollectionCheck<String> collectionCheck = new CollectionCheck<>(object);

			assertThatExceptionOfType(LessSizeObjectCheckException.class)
				.isThrownBy(() -> collectionCheck.notLessSize(4, message))
				.withMessage(message);
		}

		/**
		 * Проверка метода {@link AbstractCollectionCheck#notLessSize(int, String)} с некорректным значением в виде {@code null}.
		 */
		@Test
		public void notLessSizeWithNull()
		{
			Collection<String> object = null;
			String message = "Здесь нужно руками кидать воду вверх";
			CollectionCheck<String> collectionCheck = new CollectionCheck<>(object);

			assertThatExceptionOfType(LessSizeObjectCheckException.class)
				.isThrownBy(() -> collectionCheck.notLessSize(4, message))
				.withMessage(message);
		}
	}
}