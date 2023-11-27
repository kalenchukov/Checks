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
import dev.kalenchukov.checks.handlers.interfaces.MultipleObjectChecking;
import dev.kalenchukov.checks.handlers.interfaces.MapChecking;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.Objects;

/**
 * Класс проверяющего объекты типа {@code Map}.
 *
 * @param <K> тип ключей проверяемого объекта.
 * @param <V> тип значений проверяемого объекта.
 * @author Алексей Каленчуков
 */
public class MapCheck<K, V>
	extends AbstractCheck<MapCheck<K, V>, Map<K, V>>
	implements MapChecking<MapCheck<K, V>, Map<K, V>>, MultipleObjectChecking<MapCheck<K, V>, Map<K, V>>
{
	/**
	 * Конструирует проверяющего.
	 *
	 * @param target проверяемый объект.
	 */
	public MapCheck(@Nullable final Map<K, V> target)
	{
		super(target);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @return {@inheritDoc}
	 */
	@NotNull
	@Override
	public MapCheck<K, V> notEmpty()
	{
		this.notEmpty(null);

		return this.self;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @param message {@inheritDoc}
	 * @return {@inheritDoc}
	 * @throws EmptyObjectCheckException {@inheritDoc}
	 */
	@NotNull
	@Override
	public MapCheck<K, V> notEmpty(@Nullable final String message)
	{
		if (this.target == null || this.target.isEmpty()) {
			throw new EmptyObjectCheckException(this.target, message);
		}

		return this.self;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @param size {@inheritDoc}
	 * @return {@inheritDoc}
	 */
	@NotNull
	@Override
	public MapCheck<K, V> notSize(final int size)
	{
		this.notSize(size, null);

		return this.self;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @param size {@inheritDoc}
	 * @param message {@inheritDoc}
	 * @return {@inheritDoc}
	 * @throws SizeObjectCheckException {@inheritDoc}
	 */
	@NotNull
	@Override
	public MapCheck<K, V> notSize(final int size, @Nullable final String message)
	{
		if (this.target == null || this.target.size() == size) {
			throw new SizeObjectCheckException(this.target, message);
		}

		return this.self;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @param from {@inheritDoc}
	 * @param to {@inheritDoc}
	 * @return {@inheritDoc}
	 */
	@NotNull
	@Override
	public MapCheck<K, V> notRangeSize(final int from, final int to)
	{
		this.notRangeSize(from, to, null);

		return this.self;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @param from {@inheritDoc}
	 * @param to {@inheritDoc}
	 * @param message {@inheritDoc}
	 * @return {@inheritDoc}
	 * @throws RangeSizeObjectCheckException {@inheritDoc}
	 */
	@NotNull
	@Override
	public MapCheck<K, V> notRangeSize(final int from, final int to, @Nullable final String message)
	{
		if (this.target == null || (this.target.size() >= from && this.target.size() <= to)) {
			throw new RangeSizeObjectCheckException(this.target, message);
		}

		return this.self;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @param size {@inheritDoc}
	 * @return {@inheritDoc}
	 */
	@NotNull
	@Override
	public MapCheck<K, V> notMoreSize(final int size)
	{
		this.notMoreSize(size, null);

		return this.self;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @param size {@inheritDoc}
	 * @return {@inheritDoc}
	 * @throws MoreSizeObjectCheckException {@inheritDoc}
	 */
	@NotNull
	@Override
	public MapCheck<K, V> notMoreSize(final int size, @Nullable final String message)
	{
		if (this.target == null || this.target.size() > size) {
			throw new MoreSizeObjectCheckException(this.target, message);
		}

		return this.self;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @param size {@inheritDoc}
	 * @return {@inheritDoc}
	 */
	@NotNull
	@Override
	public MapCheck<K, V> notLessSize(final int size)
	{
		this.notLessSize(size, null);

		return this.self;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @param size {@inheritDoc}
	 * @return {@inheritDoc}
	 * @throws LessSizeObjectCheckException {@inheritDoc}
	 */
	@NotNull
	@Override
	public MapCheck<K, V> notLessSize(final int size, @Nullable final String message)
	{
		if (this.target == null || this.target.size() < size) {
			throw new LessSizeObjectCheckException(this.target, message);
		}

		return this.self;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @return {@inheritDoc}
	 */
	@NotNull
	@Override
	protected MapCheck<K, V> initSelf()
	{
		return this;
	}
}
