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

import dev.kalenchukov.checks.exceptions.BlankObjectCheckException;
import dev.kalenchukov.checks.exceptions.LessSizeObjectCheckException;
import dev.kalenchukov.checks.handlers.interfaces.StringChecking;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

/**
 * Класс проверяющего объекты типа {@code String}.
 *
 * @author Алексей Каленчуков
 */
public class StringCheck
	extends AbstractCharSequenceCheck<StringCheck, String>
	implements StringChecking<StringCheck, String>
{
	/**
	 * Конструирует проверяющего.
	 *
	 * @param target проверяемый объект.
	 */
	public StringCheck(@Nullable final String target) {
		super(target);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @return {@inheritDoc}
	 */
	@NotNull
	@Override
	public StringCheck notBlank()
	{
		this.notBlank(null);

		return this.self;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @param message {@inheritDoc}
	 * @return {@inheritDoc}
	 * @throws BlankObjectCheckException {@inheritDoc}
	 */
	@NotNull
	@Override
	public StringCheck notBlank(@Nullable final String message)
	{
		if (this.target == null || this.target.isBlank()) {
			throw new BlankObjectCheckException(this.target, message);
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
	protected StringCheck initSelf()
	{
		return this;
	}
}
