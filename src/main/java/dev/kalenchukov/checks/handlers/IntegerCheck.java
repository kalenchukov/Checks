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
import dev.kalenchukov.checks.handlers.interfaces.IntegerChecking;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

/**
 * Класс проверяющего объекты типа {@code Integer}.
 *
 * @author Алексей Каленчуков
 */
public class IntegerCheck
	extends AbstractNumberCheck<IntegerCheck, Integer>
	implements IntegerChecking<IntegerCheck, Integer>
{
	/**
	 * Конструирует проверяющего.
	 *
	 * @param target проверяемый объект.
	 */
	public IntegerCheck(@Nullable final Integer target)
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
	public IntegerCheck notNegative()
	{
		this.notNegative(null);

		return this.self;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @param message {@inheritDoc}
	 * @return {@inheritDoc}
	 * @throws NegativeNumberObjectCheckException {@inheritDoc}
	 */
	@NotNull
	@Override
	public IntegerCheck notNegative(@Nullable final String message)
	{
		if (this.target == null || this.target < 0) {
			throw new NegativeNumberObjectCheckException(this.target, message);
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
	public IntegerCheck notPositive()
	{
		this.notPositive(null);

		return this.self;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @param message {@inheritDoc}
	 * @return {@inheritDoc}
	 * @throws PositiveNumberObjectCheckException {@inheritDoc}
	 */
	@NotNull
	@Override
	public IntegerCheck notPositive(@Nullable final String message)
	{
		if (this.target == null || this.target > 0) {
			throw new PositiveNumberObjectCheckException(this.target, message);
		}

		return this.self;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @param number {@inheritDoc}
	 * @return {@inheritDoc}
	 */
	@NotNull
	@Override
	public IntegerCheck notMoreNumber(@NotNull final Integer number)
	{
		Objects.requireNonNull(number);

		this.notMoreNumber(number, null);

		return this.self;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @param number {@inheritDoc}
	 * @param message {@inheritDoc}
	 * @return {@inheritDoc}
	 * @throws MoreNumberObjectCheckException {@inheritDoc}
	 */
	@NotNull
	@Override
	public IntegerCheck notMoreNumber(@NotNull final Integer number, @Nullable final String message)
	{
		Objects.requireNonNull(number);

		if (this.target == null || this.target > number) {
			throw new MoreNumberObjectCheckException(this.target, message);
		}

		return this.self;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @param number {@inheritDoc}
	 * @return {@inheritDoc}
	 */
	@NotNull
	@Override
	public IntegerCheck notLessNumber(@NotNull final Integer number)
	{
		Objects.requireNonNull(number);

		this.notLessNumber(number, null);

		return this.self;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @param number {@inheritDoc}
	 * @param message {@inheritDoc}
	 * @return {@inheritDoc}
	 * @throws LessNumberObjectCheckException {@inheritDoc}
	 */
	@NotNull
	@Override
	public IntegerCheck notLessNumber(@NotNull final Integer number, @Nullable final String message)
	{
		Objects.requireNonNull(number);

		if (this.target == null || this.target < number) {
			throw new LessNumberObjectCheckException(this.target, message);
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
	public IntegerCheck notRangeNumber(@NotNull final Integer from, @NotNull final Integer to)
	{
		Objects.requireNonNull(from);
		Objects.requireNonNull(to);

		this.notRangeNumber(from, to, null);

		return this.self;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @param from {@inheritDoc}
	 * @param to {@inheritDoc}
	 * @param message {@inheritDoc}
	 * @return {@inheritDoc}
	 * @throws RangeNumberObjectCheckException {@inheritDoc}
	 */
	@NotNull
	@Override
	public IntegerCheck notRangeNumber(@NotNull final Integer from, @NotNull final Integer to, @Nullable final String message)
	{
		Objects.requireNonNull(from);
		Objects.requireNonNull(to);

		if (this.target == null || (this.target >= from && this.target <= to)) {
			throw new RangeNumberObjectCheckException(this.target, message);
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
	protected IntegerCheck initSelf()
	{
		return this;
	}
}
