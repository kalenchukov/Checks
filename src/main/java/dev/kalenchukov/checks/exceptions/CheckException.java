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

package dev.kalenchukov.checks.exceptions;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

/**
 * Класс исключения при некорректном значении.
 *
 * @author Алексей Каленчуков
 */
public class CheckException extends RuntimeException
{
	/**
	 * Виновник.
	 */
	@Nullable
	private final Object culprit;

	/**
	 * Сообщение.
	 */
	@Nullable
	private final String message;

	/**
	 * Конструирует исключение.
	 *
	 * @param culprit виновник.
	 */
	public CheckException(@Nullable final Object culprit)
	{
		super();

		this.culprit = culprit;
		this.message = null;
	}

	/**
	 * Конструирует исключение.
	 *
	 * @param culprit виновник.
	 * @param message сообщение.
	 */
	public CheckException(@Nullable final Object culprit, @Nullable final String message)
	{
		super(message);

		this.culprit = culprit;
		this.message = message;
	}

	/**
	 * Возвращает виновника.
	 *
	 * @return виновника.
	 */
	@Nullable
	public Object getCulprit()
	{
		return this.culprit;
	}

	/**
	 * Возвращает сообщение.
	 *
	 * @return сообщение.
	 */
	@Nullable
	@Override
	public String getMessage()
	{
		return this.message;
	}
}
