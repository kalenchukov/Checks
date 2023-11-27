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
import dev.kalenchukov.checks.handlers.interfaces.AbstractChecking;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;
import java.util.function.Predicate;

/**
 * Класс частичной реализации проверяющего объекты любых типов.
 *
 * @param <SELF> тип проверяющего объекта.
 * @param <T> тип проверяемого объекта.
 * @author Алексей Каленчуков
 */
abstract class AbstractCheck<SELF extends AbstractCheck<SELF, T>, T>
	implements AbstractChecking<SELF, T>
{
	/**
	 * Проверяемый объект.
	 */
	@Nullable
	protected final T target;

	/**
	 * Проверяющий объект.
	 */
	@NotNull
	protected final SELF self;

	/**
	 * Конструирует проверяющего.
	 *
	 * @param target проверяемый объект.
	 */
	protected AbstractCheck(@Nullable final T target)
	{
		this.target = target;
		this.self = this.initSelf();
	}

	/**
	 * {@inheritDoc}
	 *
	 * @return {@inheritDoc}
	 */
	@NotNull
	@Override
	public SELF notNull()
	{
		this.notNull(null);

		return this.self;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @param message {@inheritDoc}
	 * @return {@inheritDoc}
	 * @throws NullObjectCheckException {@inheritDoc}
	 */
	@NotNull
	@Override
	public SELF notNull(@Nullable final String message)
	{
		if (this.target == null) {
			throw new NullObjectCheckException(this.target, message);
		}

		return this.self;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @param value {@inheritDoc}
	 * @return {@inheritDoc}
	 */
	@NotNull
	@Override
	public SELF notEquals(@NotNull final T value)
	{
		Objects.requireNonNull(value);

		this.notEquals(value, null);

		return this.self;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @param value {@inheritDoc}
	 * @param message {@inheritDoc}
	 * @return {@inheritDoc}
	 * @throws EqualsObjectCheckException {@inheritDoc}
	 */
	@NotNull
	@Override
	public SELF notEquals(@Nullable final T value, @Nullable final String message)
	{
		if (this.target == null || this.target.equals(value)) {
			throw new EqualsObjectCheckException(this.target, message);
		}

		return this.self;
	}

	@NotNull
	@Override
	public SELF not(@NotNull final Predicate<T> predicate)
	{
		Objects.requireNonNull(predicate);

		this.not(predicate, null);

		return this.self;
	}

	@NotNull
	@Override
	public SELF not(@NotNull final Predicate<T> predicate, @Nullable final String message)
	{
		Objects.requireNonNull(predicate);

		if (this.target == null || predicate.test(this.target)) {
			throw new IllegalObjectCheckException(this.target, message);
		}

		return this.self;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @return {@inheritDoc}
	 */
	@Override
	public T get()
	{
		return this.target;
	}

	/**
	 * Инициализирует объект проверяющего.
	 *
	 * @return объект проверяющего.
	 */
	@NotNull
	protected abstract SELF initSelf();

	/**
	 * Возвращает представление объекта в виде числа.
	 *
	 * @return представление объекта в виде числа.
	 */
	@Override
	public int hashCode()
	{
		int result = 0;

		result = 31 * result + ((this.target != null) ? this.target.hashCode() : 0);

		return result;
	}

	/**
	 * Проверяет равенство объектов.
	 *
	 * @param obj сравниваемый объект.
	 * @return {@code true}, если объекты равны, иначе {@code false}.
	 */
	@Override
	public boolean equals(final Object obj)
	{
		if (obj == null) {
			return false;
		}

		if (obj == this.self) {
			return true;
		}

		if (!this.self.getClass().equals(obj.getClass())) {
			return false;
		}

		@SuppressWarnings("unchecked")
		SELF abstractCheck = (SELF) obj;

		if (this.target == null && abstractCheck.target != null) {
			return false;
		}

		if (this.target != null && !this.target.equals(abstractCheck.target)) {
			return false;
		}

		return true;
	}
}
