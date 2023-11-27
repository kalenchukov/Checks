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

import dev.kalenchukov.checks.handlers.interfaces.ListChecking;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * Класс проверяющего объекты типа {@code List}.
 *
 * @param <T> тип значений проверяемого объекта.
 * @author Алексей Каленчуков
 */
public class ListCheck<T>
	extends AbstractCollectionCheck<ListCheck<T>, List<T>>
	implements ListChecking<ListCheck<T>, List<T>>
{
	/**
	 * Конструирует проверяющего.
	 *
	 * @param target проверяемый объект.
	 */
	public ListCheck(@Nullable final List<T> target)
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
	protected ListCheck<T> initSelf()
	{
		return this;
	}
}
