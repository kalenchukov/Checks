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

import dev.kalenchukov.checks.exceptions.EqualsObjectCheckException;
import dev.kalenchukov.checks.exceptions.IllegalObjectCheckException;
import dev.kalenchukov.checks.exceptions.NullObjectCheckException;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

/**
 * Класс проверки методов класса {@link AbstractCheck}.
 *
 * @author Алексей Каленчуков
 */
public class AbstractCheckTest
{
	/**
	 * Класс проверки метода {@link AbstractCheck#notNull()}.
	 *
	 * @author Алексей Каленчуков
	 */
	@Nested
	public class NotNull
	{
		/**
		 * Проверка метода {@link AbstractCheck#notNull()}.
		 */
		@Test
		public void notNull()
		{
			Object object = new Object();
			ObjectCheck<Object> objectCheck = new ObjectCheck<>(object);

			ObjectCheck<Object> actual = objectCheck.notNull();

			assertThat(actual).isSameAs(objectCheck);
		}

		/**
		 * Проверка метода {@link AbstractCheck#notNull()} с некорректным значением.
		 */
		@Test
		public void notNullWithValueInvalid()
		{
			Object object = null;
			ObjectCheck<Object> objectCheck = new ObjectCheck<>(object);

			assertThatExceptionOfType(NullObjectCheckException.class)
				.isThrownBy(() -> objectCheck.notNull());
		}
	}

	/**
	 * Класс проверки метода {@link AbstractCheck#notNull(String)}.
	 *
	 * @author Алексей Каленчуков
	 */
	@Nested
	public class NotNullWithMessage
	{
		/**
		 * Проверка метода {@link AbstractCheck#notNull(String)}.
		 */
		@Test
		public void notNull()
		{
			Object object = new Object();
			String message = "Ты идёшь в магазин, чтобы купить вино...";
			ObjectCheck<Object> objectCheck = new ObjectCheck<>(object);

			ObjectCheck<Object> actual = objectCheck.notNull(message);

			assertThat(actual).isSameAs(objectCheck);
		}

		/**
		 * Проверка метода {@link AbstractCheck#notNull(String)} с некорректным значением.
		 */
		@Test
		public void notNullWithValueInvalid()
		{
			Object object = null;
			String message = "Я искал здесь вино, а нашёл третий глаз...";
			ObjectCheck<Object> objectCheck = new ObjectCheck<>(object);

			assertThatExceptionOfType(NullObjectCheckException.class)
				.isThrownBy(() -> objectCheck.notNull(message))
				.withMessage(message);
		}
	}

	/**
	 * Класс проверки метода {@link AbstractCheck#notEquals(Object)}.
	 *
	 * @author Алексей Каленчуков
	 */
	@Nested
	public class NotEquals
	{
		/**
		 * Проверка метода {@link AbstractCheck#notEquals(Object)}.
		 */
		@Test
		public void notEquals()
		{
			File object1 = new File("/dev/kalenchukov/README.MD");
			File object2 = new File("/dev/kalenchukov/TODO.MD");
			ObjectCheck<File> objectCheck = new ObjectCheck<>(object1);

			ObjectCheck<File> actual = objectCheck.notEquals(object2);

			assertThat(actual).isSameAs(objectCheck);
		}

		/**
		 * Проверка метода {@link AbstractCheck#notEquals(Object)} с некорректным значением.
		 */
		@Test
		public void notEqualsWithValueInvalid()
		{
			File object1 = new File("/dev/kalenchukov/README.MD");
			File object2 = new File("/dev/kalenchukov/README.MD");
			ObjectCheck<File> objectCheck = new ObjectCheck<>(object1);

			assertThatExceptionOfType(EqualsObjectCheckException.class)
				.isThrownBy(() -> objectCheck.notEquals(object2));
		}

		/**
		 * Проверка метода {@link AbstractCheck#notEquals(Object)} с некорректным значением в виде {@code null}.
		 */
		@Test
		public void notEqualsWithNull()
		{
			File object1 = null;
			File object2 = new File("/dev/kalenchukov/README.MD");
			ObjectCheck<File> objectCheck = new ObjectCheck<>(object1);

			assertThatExceptionOfType(EqualsObjectCheckException.class)
				.isThrownBy(() -> objectCheck.notEquals(object2));
		}
	}


	/**
	 * Класс проверки метода {@link AbstractCheck#notEquals(Object, String)}.
	 *
	 * @author Алексей Каленчуков
	 */
	@Nested
	public class NotEqualsWithMessage
	{
		/**
		 * Проверка метода {@link AbstractCheck#notEquals(Object, String)}.
		 */
		@Test
		public void notEquals()
		{
			File object1 = new File("/dev/kalenchukov/README.MD");
			File object2 = new File("/dev/kalenchukov/TODO.MD");
			String message = "Всё в своё время, зима и весна...";
			ObjectCheck<File> objectCheck = new ObjectCheck<>(object1);

			ObjectCheck<File> actual = objectCheck.notEquals(object2, message);

			assertThat(actual).isSameAs(objectCheck);
		}

		/**
		 * Проверка метода {@link AbstractCheck#notEquals(Object, String)} с некорректным значением.
		 */
		@Test
		public void notEqualsWithValueInvalid()
		{
			File object1 = new File("/dev/kalenchukov/README.MD");
			File object2 = new File("/dev/kalenchukov/README.MD");
			String message = "Каждому яблоку - место упасть, каждому вору - возможность украсть...";
			ObjectCheck<File> objectCheck = new ObjectCheck<>(object1);

			assertThatExceptionOfType(EqualsObjectCheckException.class)
				.isThrownBy(() -> objectCheck.notEquals(object2, message))
				.withMessage(message);
		}

		/**
		 * Проверка метода {@link AbstractCheck#notEquals(Object, String)} с некорректным значением в виде {@code null}.
		 */
		@Test
		public void notEqualsWithNull()
		{
			File object1 = null;
			File object2 = new File("/dev/kalenchukov/README.MD");
			String message = "Каждому яблоку - место упасть, каждому вору - возможность украсть...";
			ObjectCheck<File> objectCheck = new ObjectCheck<>(object1);

			assertThatExceptionOfType(EqualsObjectCheckException.class)
				.isThrownBy(() -> objectCheck.notEquals(object2, message))
				.withMessage(message);
		}
	}

	/**
	 * Класс проверки метода {@link AbstractCheck#not(Predicate)}.
	 *
	 * @author Алексей Каленчуков
	 */
	@Nested
	public class Not
	{
		/**
		 * Проверка метода {@link AbstractCheck#not(Predicate)}.
		 */
		@Test
		public void not()
		{
			String object = "Hello, world!";
			Predicate<String> predicate = (value) -> (value.matches("[0-9]+"));
			ObjectCheck<String> objectCheck = new ObjectCheck<>(object);

			ObjectCheck<String> actual = objectCheck.not(predicate);

			assertThat(actual).isSameAs(objectCheck);
		}

		/**
		 * Проверка метода {@link AbstractCheck#not(Predicate)} с некорректным значением.
		 */
		@Test
		public void notWithValueInvalid()
		{
			String object = "123434576760";
			Predicate<String> predicate = (value) -> (value.matches("[0-9]+"));
			ObjectCheck<String> objectCheck = new ObjectCheck<>(object);

			assertThatExceptionOfType(IllegalObjectCheckException.class)
				.isThrownBy(() -> objectCheck.not(predicate));
		}

		/**
		 * Проверка метода {@link AbstractCheck#not(Predicate)} с некорректным значением в виде {@code null}.
		 */
		@Test
		public void notWithNull()
		{
			String object = null;
			Predicate<String> predicate = (value) -> (value.matches("[0-9]+"));
			ObjectCheck<String> objectCheck = new ObjectCheck<>(object);

			assertThatExceptionOfType(IllegalObjectCheckException.class)
				.isThrownBy(() -> objectCheck.not(predicate));
		}
	}

	/**
	 * Класс проверки метода {@link AbstractCheck#not(Predicate, String)}.
	 *
	 * @author Алексей Каленчуков
	 */
	@Nested
	public class NotWithMessage
	{
		/**
		 * Проверка метода {@link AbstractCheck#not(Predicate, String)}.
		 */
		@Test
		public void not()
		{
			String object = "Hello, world!";
			Predicate<String> predicate = (value) -> (value.matches("[0-9]+"));
			String message = "И упасть опаленным звездой по имени Солнце";
			ObjectCheck<String> objectCheck = new ObjectCheck<>(object);

			ObjectCheck<String> actual = objectCheck.not(predicate, message);

			assertThat(actual).isSameAs(objectCheck);
		}

		/**
		 * Проверка метода {@link AbstractCheck#not(Predicate, String)} с некорректным значением.
		 */
		@Test
		public void notWithValueInvalid()
		{
			String object = "123434576760";
			Predicate<String> predicate = (value) -> (value.matches("[0-9]+"));
			String message = "И упасть опаленным звездой по имени Солнце";
			ObjectCheck<String> objectCheck = new ObjectCheck<>(object);

			assertThatExceptionOfType(IllegalObjectCheckException.class)
				.isThrownBy(() -> objectCheck.not(predicate, message));
		}

		/**
		 * Проверка метода {@link AbstractCheck#not(Predicate, String)} с некорректным значением в виде {@code null}.
		 */
		@Test
		public void notWithNull()
		{
			String object = null;
			Predicate<String> predicate = (value) -> (value.matches("[0-9]+"));
			String message = "И упасть опаленным звездой по имени Солнце";
			ObjectCheck<String> objectCheck = new ObjectCheck<>(object);

			assertThatExceptionOfType(IllegalObjectCheckException.class)
				.isThrownBy(() -> objectCheck.not(predicate, message));
		}
	}

	/**
	 * Класс проверки метода {@link AbstractCheck#get()}.
	 *
	 * @author Алексей Каленчуков
	 */
	@Nested
	public class Get
	{
		/**
		 * Проверка метода {@link AbstractCheck#get()}.
		 */
		@Test
		public void get()
		{
			Object object = new Object();
			ObjectCheck<Object> objectCheck = new ObjectCheck<>(object);

			Object actual = objectCheck.get();

			assertThat(actual).isSameAs(object);
		}

		/**
		 * Проверка метода {@link AbstractCheck#get()} с значением в виде {@code null}.
		 */
		@Test
		public void getWithNull()
		{
			Object object = null;
			ObjectCheck<Object> objectCheck = new ObjectCheck<>(object);

			Object actual = objectCheck.get();

			assertThat(actual).isSameAs(object);
		}
	}

	/**
	 * Класс проверки метода {@link AbstractCheck#hashCode()}.
	 *
	 * @author Алексей Каленчуков
	 */
	@Nested
	public class HashCode
	{
		/**
		 * Проверка метода {@link AbstractCheck#hashCode()} с равными объектами.
		 */
		@Test
		public void hashCodeWithEqualsValue()
		{
			IntegerCheck object1 = new IntegerCheck(1);
			IntegerCheck object2 = new IntegerCheck(1);

			int actual = object1.hashCode();
			int expected = object2.hashCode();

			assertThat(actual).isEqualTo(expected);
		}

		/**
		 * Проверка метода {@link AbstractCheck#hashCode()} с разными значениями.
		 */
		@Test
		public void hashCodeWithDifferentTarget()
		{
			IntegerCheck object1 = new IntegerCheck(1);
			IntegerCheck object2 = new IntegerCheck(2);

			int actual = object1.hashCode();
			int expected = object2.hashCode();

			assertThat(actual).isNotEqualTo(expected);
		}

		/**
		 * Проверка метода {@link AbstractCheck#hashCode()} с разными объектами.
		 */
		@Test
		public void hashCodeWithDifferentTypeClass()
		{
			IntegerCheck object1 = new IntegerCheck(1);
			StringCheck object2 = new StringCheck("1");

			int actual = object1.hashCode();
			int expected = object2.hashCode();

			assertThat(actual).isNotEqualTo(expected);
		}
	}

	/**
	 * Класс проверки метода {@link AbstractCheck#equals(Object)}.
	 *
	 * @author Алексей Каленчуков
	 */
	@Nested
	public class Equals
	{
		/**
		 * Проверка метода {@link AbstractCheck#equals(Object)} с равными объектами.
		 */
		@Test
		public void equalsWithEqualsValue()
		{
			IntegerCheck object1 = new IntegerCheck(1);
			IntegerCheck object2 = new IntegerCheck(1);

			boolean actual = object1.equals(object2);

			assertThat(actual).isTrue();
		}

		/**
		 * Проверка метода {@link AbstractCheck#equals(Object)} с разными значениями.
		 */
		@Test
		public void equalsWithDifferentTarget()
		{
			IntegerCheck object1 = new IntegerCheck(1);
			IntegerCheck object2 = new IntegerCheck(2);

			boolean actual = object1.equals(object2);

			assertThat(actual).isFalse();
		}

		/**
		 * Проверка метода {@link AbstractCheck#equals(Object)} с объектом {@code null}.
		 */
		@Test
		public void equalsWithNull()
		{
			IntegerCheck object1 = new IntegerCheck(1);
			IntegerCheck object2 = null;

			boolean actual = object1.equals(object2);

			assertThat(actual).isFalse();
		}

		/**
		 * Проверка метода {@link AbstractCheck#equals(Object)} с разными объектами.
		 */
		@Test
		public void equalsWithDifferentTypeClass()
		{
			IntegerCheck object1 = new IntegerCheck(1);
			StringCheck object2 = new StringCheck("1");

			boolean actual = object1.equals(object2);

			assertThat(actual).isFalse();
		}
	}
}