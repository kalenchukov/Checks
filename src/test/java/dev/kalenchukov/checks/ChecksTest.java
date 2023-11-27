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

package dev.kalenchukov.checks;

import dev.kalenchukov.checks.handlers.*;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

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
		 * Класс проверки метода {@link Checks#require(Integer)}.
		 *
		 * @author Алексей Каленчуков
		 */
		@Nested
		public class RequireWithInteger
		{
			/**
			 * Проверка метода {@link Checks#require(Integer)} с корректным значением.
			 */
			@Test
			public void checkValid()
			{
				Integer object = 1;
				IntegerCheck expected = new IntegerCheck(object);

				IntegerCheck actual = Checks.require(object);

				assertThat(actual).isEqualTo(expected);
			}

			/**
			 * Проверка метода {@link Checks#require(Integer)} с корректным значением в виде {@code null}.
			 */
			@Test
			public void checkWithNull()
			{
				Integer object = null;
				IntegerCheck expected = new IntegerCheck(object);

				IntegerCheck actual = Checks.require(object);

				assertThat(actual).isEqualTo(expected);
			}
		}

		/**
		 * Класс проверки метода {@link Checks#require(String)}.
		 *
		 * @author Алексей Каленчуков
		 */
		@Nested
		public class RequireWithString
		{
			/**
			 * Проверка метода {@link Checks#require(String)} с корректным значением.
			 */
			@Test
			public void checkValid()
			{
				String object = "Когда твоя девушка больна";
				StringCheck expected = new StringCheck(object);

				StringCheck actual = Checks.require(object);

				assertThat(actual).isEqualTo(expected);
			}

			/**
			 * Проверка метода {@link Checks#require(String)} с корректным значением в виде {@code null}.
			 */
			@Test
			public void checkWithNull()
			{
				String object = null;
				StringCheck expected = new StringCheck(object);

				StringCheck actual = Checks.require(object);

				assertThat(actual).isEqualTo(expected);
			}
		}

		/**
		 * Класс проверки метода {@link Checks#require(StringBuilder)}.
		 *
		 * @author Алексей Каленчуков
		 */
		@Nested
		public class RequireWithStringBuilder
		{
			/**
			 * Проверка метода {@link Checks#require(StringBuilder)} с корректным значением.
			 */
			@Test
			public void checkValid()
			{
				StringBuilder object = new StringBuilder("Когда твоя девушка больна");
				StringBuilderCheck expected = new StringBuilderCheck(object);

				StringBuilderCheck actual = Checks.require(object);

				assertThat(actual).isEqualTo(expected);
			}

			/**
			 * Проверка метода {@link Checks#require(StringBuilder)} с корректным значением в виде {@code null}.
			 */
			@Test
			public void checkWithNull()
			{
				StringBuilder object = null;
				StringBuilderCheck expected = new StringBuilderCheck(object);

				StringBuilderCheck actual = Checks.require(object);

				assertThat(actual).isEqualTo(expected);
			}
		}

		/**
		 * Класс проверки метода {@link Checks#require(CharSequence)}.
		 *
		 * @author Алексей Каленчуков
		 */
		@Nested
		public class RequireWithCharSequence
		{
			/**
			 * Проверка метода {@link Checks#require(CharSequence)} с корректным значением.
			 */
			@Test
			public void checkValid()
			{
				CharSequence object = "Когда твоя девушка больна";
				CharSequenceCheck expected = new CharSequenceCheck(object);

				CharSequenceCheck actual = Checks.require(object);

				assertThat(actual).isEqualTo(expected);
			}

			/**
			 * Проверка метода {@link Checks#require(CharSequence)} с корректным значением в виде {@code null}.
			 */
			@Test
			public void checkWithNull()
			{
				CharSequence object = null;
				CharSequenceCheck expected = new CharSequenceCheck(object);

				CharSequenceCheck actual = Checks.require(object);

				assertThat(actual).isEqualTo(expected);
			}
		}

		/**
		 * Класс проверки метода {@link Checks#require(List)}.
		 *
		 * @author Алексей Каленчуков
		 */
		@Nested
		public class RequireWithList
		{
			/**
			 * Проверка метода {@link Checks#require(List)} с корректным значением.
			 */
			@Test
			public void checkValid()
			{
				List<String> object = List.of("Весна", "Сосны на морском берегу");
				ListCheck<String> expected = new ListCheck<>(object);

				ListCheck<String> actual = Checks.require(object);

				assertThat(actual).isEqualTo(expected);
			}

			/**
			 * Проверка метода {@link Checks#require(List)} с корректным значением в виде {@code null}.
			 */
			@Test
			public void checkWithNull()
			{
				List<String> object = null;
				ListCheck<String> expected = new ListCheck<>(object);

				ListCheck<String> actual = Checks.require(object);

				assertThat(actual).isEqualTo(expected);
			}

			/**
			 * Проверка метода {@link Checks#require(List)} с корректным значением содержащим {@code null}.
			 */
			@Test
			public void checkWithValueNull()
			{
				List<String> object = new ArrayList<>();
				object.add("Весна");
				object.add(null);
				ListCheck<String> expected = new ListCheck<>(object);

				ListCheck<String> actual = Checks.require(object);

				assertThat(actual).isEqualTo(expected);
			}
		}

		/**
		 * Класс проверки метода {@link Checks#require(Set)}.
		 *
		 * @author Алексей Каленчуков
		 */
		@Nested
		public class RequireWithSet
		{
			/**
			 * Проверка метода {@link Checks#require(Set)} с корректным значением.
			 */
			@Test
			public void checkValid()
			{
				Set<Integer> object = Set.of(13, 11);
				SetCheck<Integer> expected = new SetCheck<>(object);

				SetCheck<Integer> actual = Checks.require(object);

				assertThat(actual).isEqualTo(expected);
			}

			/**
			 * Проверка метода {@link Checks#require(Set)} с корректным значением в виде {@code null}.
			 */
			@Test
			public void checkWithNull()
			{
				Set<Integer> object = null;
				SetCheck<Integer> expected = new SetCheck<>(object);

				SetCheck<Integer> actual = Checks.require(object);

				assertThat(actual).isEqualTo(expected);
			}

			/**
			 * Проверка метода {@link Checks#require(Set)} с корректным значением содержащим {@code null}.
			 */
			@Test
			public void checkWithValueNull()
			{
				Set<Integer> object = new HashSet<>();
				object.add(13);
				object.add(null);
				SetCheck<Integer> expected = new SetCheck<>(object);

				SetCheck<Integer> actual = Checks.require(object);

				assertThat(actual).isEqualTo(expected);
			}
		}

		/**
		 * Класс проверки метода {@link Checks#require(Collection)}.
		 *
		 * @author Алексей Каленчуков
		 */
		@Nested
		public class RequireWithCollection
		{
			/**
			 * Проверка метода {@link Checks#require(Collection)} с корректным значением.
			 */
			@Test
			public void checkValid()
			{
				Collection<String> object = List.of("Бездельник", "Муравейник");
				CollectionCheck<String> expected = new CollectionCheck<>(object);

				CollectionCheck<String> actual = Checks.require(object);

				assertThat(actual).isEqualTo(expected);
			}

			/**
			 * Проверка метода {@link Checks#require(Collection)} с корректным значением в виде {@code null}.
			 */
			@Test
			public void checkWithNull()
			{
				Collection<String> object = null;
				CollectionCheck<String> expected = new CollectionCheck<>(object);

				CollectionCheck<String> actual = Checks.require(object);

				assertThat(actual).isEqualTo(expected);
			}

			/**
			 * Проверка метода {@link Checks#require(Collection)} с корректным значением содержащим {@code null}.
			 */
			@Test
			public void checkWithValueNull()
			{
				Collection<String> object = new ArrayList<>();
				object.add(null);
				object.add("Муравейник");
				CollectionCheck<String> expected = new CollectionCheck<>(object);

				CollectionCheck<String> actual = Checks.require(object);

				assertThat(actual).isEqualTo(expected);
			}
		}

		/**
		 * Класс проверки метода {@link Checks#require(Map)}.
		 *
		 * @author Алексей Каленчуков
		 */
		@Nested
		public class RequireWithMap
		{
			/**
			 * Проверка метода {@link Checks#require(Map)} с корректным значением.
			 */
			@Test
			public void checkValid()
			{
				Map<Integer, String> object = new HashMap<>();
				MapCheck<Integer, String> expected = new MapCheck<>(object);

				MapCheck<Integer, String> actual = Checks.require(object);

				assertThat(actual).isEqualTo(expected);
			}

			/**
			 * Проверка метода {@link Checks#require(Map)} с корректным значением в виде {@code null}.
			 */
			@Test
			public void checkWithNull()
			{
				Map<Integer, String> object = null;
				MapCheck<Integer, String> expected = new MapCheck<>(object);

				MapCheck<Integer, String> actual = Checks.require(object);

				assertThat(actual).isEqualTo(expected);
			}

			/**
			 * Проверка метода {@link Checks#require(Map)} с корректным значением содержащим {@code null}.
			 */
			@Test
			public void checkWithValueNull()
			{
				Map<Integer, String> object = new HashMap<>();
				object.put(1, null);
				object.put(null, "test");
				MapCheck<Integer, String> expected = new MapCheck<>(object);

				MapCheck<Integer, String> actual = Checks.require(object);

				assertThat(actual).isEqualTo(expected);
			}
		}

		/**
		 * Класс проверки метода {@link Checks#require(Object[])}.
		 *
		 * @author Алексей Каленчуков
		 */
		@Nested
		public class RequireWithArray
		{
			/**
			 * Проверка метода {@link Checks#require(Object[])} с корректным значением.
			 */
			@Test
			public void checkValid()
			{
				Integer[] object = new Integer[]{1, 2};
				ArrayCheck<Integer> expected = new ArrayCheck<>(object);

				ArrayCheck<Integer> actual = Checks.require(object);

				assertThat(actual).isEqualTo(expected);
			}

			/**
			 * Проверка метода {@link Checks#require(Object[])} с корректным значением в виде {@code null}.
			 */
			@Test
			public void checkWithNull()
			{
				Integer[] object = null;
				ArrayCheck<Integer> expected = new ArrayCheck<>(object);

				ArrayCheck<Integer> actual = Checks.require(object);

				assertThat(actual).isEqualTo(expected);
			}

			/**
			 * Проверка метода {@link Checks#require(Object[])} с корректным значением содержащим {@code null}.
			 */
			@Test
			public void checkWithValueNull()
			{
				Integer[] object = new Integer[]{null, 2};
				ArrayCheck<Integer> expected = new ArrayCheck<>(object);

				ArrayCheck<Integer> actual = Checks.require(object);

				assertThat(actual).isEqualTo(expected);
			}
		}

		/**
		 * Класс проверки метода {@link Checks#require(Object)}.
		 *
		 * @author Алексей Каленчуков
		 */
		@Nested
		public class RequireWithObject
		{
			/**
			 * Проверка метода {@link Checks#require(Object)} с корректным значением.
			 */
			@Test
			public void checkValid()
			{
				Object object = new Object();
				ObjectCheck<Object> expected = new ObjectCheck<>(object);

				ObjectCheck<Object> actual = Checks.require(object);

				assertThat(actual).isEqualTo(expected);
			}

			/**
			 * Проверка метода {@link Checks#require(Object)} с корректным значением в виде {@code null}.
			 */
			@Test
			public void checkWithNull()
			{
				File object = null;
				ObjectCheck<Object> expected = new ObjectCheck<>(object);

				ObjectCheck<Object> actual = Checks.require(object);

				assertThat(actual).isEqualTo(expected);
			}
		}
	}
}