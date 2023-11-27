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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Класс статических методов для вызова проверяющих.
 *
 * @author Алексей Каленчуков
 */
public final class Checks
{
	/**
	 * Конструирует вызовы проверяющих.
	 */
	private Checks() {}

	/**
	 * Вызывает проверяющего объекты типа {@code Integer} для предъявления требований.
	 *
	 * @param target проверяемый объект.
	 * @return объект проверяющего.
	 */
	@NotNull
	public static IntegerCheck require(@Nullable final Integer target)
	{
		return new IntegerCheck(target);
	}

	/**
	 * Вызывает проверяющего объекты типа {@code String} для предъявления требований.
	 *
	 * @param target проверяемый объект.
	 * @return объект проверяющего.
	 */
	@NotNull
	public static StringCheck require(@Nullable final String target)
	{
		return new StringCheck(target);
	}

	/**
	 * Вызывает проверяющего объекты типа {@code StringBuilder} для предъявления требований.
	 *
	 * @param target проверяемый объект.
	 * @return объект проверяющего.
	 */
	@NotNull
	public static StringBuilderCheck require(@Nullable final StringBuilder target)
	{
		return new StringBuilderCheck(target);
	}

	/**
	 * Вызывает проверяющего объекты типа {@code List} для предъявления требований.
	 *
	 * @param target проверяемый объект.
	 * @return объект проверяющего.
	 * @param <T> тип проверяемого объекта.
	 */
	@NotNull
	public static <T> ListCheck<T> require(@Nullable final List<T> target)
	{
		return new ListCheck<>(target);
	}

	/**
	 * Вызывает проверяющего объекты типа {@code Set} для предъявления требований.
	 *
	 * @param target проверяемый объект.
	 * @return объект проверяющего.
	 * @param <T> тип проверяемого объекта.
	 */
	@NotNull
	public static <T> SetCheck<T> require(@Nullable final Set<T> target)
	{
		return new SetCheck<>(target);
	}

	/**
	 * Вызывает проверяющего объекты типа {@code Object[]} для предъявления требований.
	 *
	 * @param target проверяемый объект.
	 * @return объект проверяющего.
	 * @param <T> тип проверяемого объекта.
	 */
	@NotNull
	public static <T> ArrayCheck<T> require(final T @Nullable [] target)
	{
		return new ArrayCheck<>(target);
	}

	/**
	 * Вызывает проверяющего объекты типа {@code Collection} для предъявления требований.
	 *
	 * @param target проверяемый объект.
	 * @return объект проверяющего.
	 * @param <T> тип проверяемого объекта.
	 */
	@NotNull
	public static <T> CollectionCheck<T> require(@Nullable final Collection<T> target)
	{
		return new CollectionCheck<>(target);
	}

	/**
	 * Вызывает проверяющего объекты типа {@code Map} для предъявления требований.
	 *
	 * @param target проверяемый объект.
	 * @return объект проверяющего.
	 * @param <K> тип ключей проверяемого объекта.
	 * @param <V> тип значений проверяемого объекта.
	 */
	@NotNull
	public static <K, V> MapCheck<K, V> require(@Nullable final Map<K, V> target)
	{
		return new MapCheck<>(target);
	}

	/**
	 * Вызывает проверяющего объектов типа {@code CharSequence} для предъявления требований.
	 *
	 * @param target проверяемый объект.
	 * @return объект проверяющего.
	 */
	@NotNull
	public static CharSequenceCheck require(@Nullable final CharSequence target)
	{
		return new CharSequenceCheck(target);
	}

	/**
	 * Вызывает проверяющего объектов типа {@code Object} для предъявления требований.
	 *
	 * @param target проверяемый объект.
	 * @return объект проверяющего.
	 * @param <T> тип проверяемого объекта.
	 */
	@NotNull
	public static <T> ObjectCheck<T> require(@Nullable final T target)
	{
		return new ObjectCheck<>(target);
	}
}
