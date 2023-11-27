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
import dev.kalenchukov.checks.handlers.interfaces.MultipleCharChecking;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Класс частичной реализации проверяющего объекты типа {@code CharSequence}.
 *
 * @param <SELF> тип проверяющего объекта.
 * @param <T> тип проверяемого объекта.
 * @author Алексей Каленчуков
 */
abstract class AbstractCharSequenceCheck<SELF extends AbstractCharSequenceCheck<SELF, T>, T extends CharSequence>
	extends AbstractCheck<SELF, T>
	implements MultipleCharChecking<SELF, T>
{
	/**
	 * Конструирует проверяющего.
	 *
	 * @param target проверяемый объект.
	 */
	protected AbstractCharSequenceCheck(@Nullable final T target)
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
	public SELF notEmpty()
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
	public SELF notEmpty(@Nullable final String message)
	{
		if (this.target == null || this.target.isEmpty()) {
			throw new EmptyObjectCheckException(this.target, message);
		}

		return this.self;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @param length {@inheritDoc}
	 * @return {@inheritDoc}
	 */
	@NotNull
	@Override
	public SELF notLength(final int length)
	{
		this.notLength(length, null);

		return this.self;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @param length {@inheritDoc}
	 * @param message {@inheritDoc}
	 * @return {@inheritDoc}
	 * @throws LengthObjectCheckException {@inheritDoc}
	 */
	@NotNull
	@Override
	public SELF notLength(final int length, @Nullable final String message)
	{
		if (this.target == null || this.target.length() == length) {
			throw new LengthObjectCheckException(this.target, message);
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
	public SELF notRangeLength(final int from, final int to)
	{
		this.notRangeLength(from, to, null);

		return this.self;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @param from {@inheritDoc}
	 * @param to {@inheritDoc}
	 * @param message {@inheritDoc}
	 * @return {@inheritDoc}
	 * @throws RangeLengthObjectCheckException {@inheritDoc}
	 */
	@NotNull
	@Override
	public SELF notRangeLength(final int from, final int to, @Nullable final String message)
	{
		if (this.target == null || (this.target.length() >= from && this.target.length() <= to)) {
			throw new RangeLengthObjectCheckException(this.target, message);
		}

		return this.self;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @param length {@inheritDoc}
	 * @return {@inheritDoc}
	 */
	@NotNull
	@Override
	public SELF notMoreLength(final int length)
	{
		this.notMoreLength(length, null);

		return this.self;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @param length {@inheritDoc}
	 * @param message {@inheritDoc}
	 * @return {@inheritDoc}
	 * @throws MoreLengthObjectCheckException {@inheritDoc}
	 */
	@NotNull
	@Override
	public SELF notMoreLength(final int length, @Nullable final String message)
	{
		if (this.target == null || this.target.length() > length) {
			throw new MoreLengthObjectCheckException(this.target, message);
		}

		return this.self;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @param length {@inheritDoc}
	 * @return {@inheritDoc}
	 */
	@NotNull
	@Override
	public SELF notLessLength(final int length)
	{
		this.notLessLength(length, null);

		return this.self;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @param length {@inheritDoc}
	 * @param message {@inheritDoc}
	 * @return {@inheritDoc}
	 * @throws LessLengthObjectCheckException {@inheritDoc}
	 */
	@NotNull
	@Override
	public SELF notLessLength(final int length, @Nullable final String message)
	{
		if (this.target == null || this.target.length() < length) {
			throw new LessLengthObjectCheckException(this.target, message);
		}

		return this.self;
	}
}
