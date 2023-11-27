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
import dev.kalenchukov.checks.handlers.interfaces.NumberChecking;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Класс частичной реализации проверяющего объекты типа {@code Number}.
 *
 * @param <SELF> тип проверяющего объекта.
 * @param <T> тип проверяемого объекта.
 * @author Алексей Каленчуков
 */
abstract class AbstractNumberCheck<SELF extends AbstractNumberCheck<SELF, T>, T extends Number>
	extends AbstractCheck<SELF, T>
	implements NumberChecking<SELF, T>
{
	/**
	 * Конструирует проверяющего.
	 *
	 * @param target проверяемый объект.
	 */
	protected AbstractNumberCheck(@Nullable final T target)
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
	public SELF notZero()
	{
		this.notZero(null);

		return this.self;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @param message {@inheritDoc}
	 * @return {@inheritDoc}
	 * @throws ZeroNumberObjectCheckException {@inheritDoc}
	 */
	@NotNull
	@Override
	public SELF notZero(@Nullable final String message)
	{
		if (this.target == null || this.target.equals(0)) {
			throw new ZeroNumberObjectCheckException(this.target, message);
		}

		return this.self;
	}
}
