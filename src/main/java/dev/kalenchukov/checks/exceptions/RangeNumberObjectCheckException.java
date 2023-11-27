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
 * Класс исключения при числе не входящем в диапазон.
 *
 * @author Алексей Каленчуков
 */
public class RangeNumberObjectCheckException extends CheckException
{
	/**
	 * Конструирует исключение.
	 *
	 * @param culprit виновник.
	 */
	public RangeNumberObjectCheckException(@Nullable final Object culprit)
	{
		super(culprit);
	}

	/**
	 * Конструирует исключение.
	 *
	 * @param culprit виновник.
	 * @param message сообщение.
	 */
	public RangeNumberObjectCheckException(@Nullable final Object culprit, @Nullable final String message)
	{
		super(culprit, message);
	}
}
