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

package dev.kalenchukov.checks.handlers.interfaces;

import dev.kalenchukov.checks.exceptions.BlankObjectCheckException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Интерфейс для реализации проверяющего объекты типа {@code String}.
 *
 * @param <SELF> тип проверяющего объекта.
 * @param <T> тип проверяемого объекта.
 * @author Алексей Каленчуков
 */
public interface StringChecking<SELF, T>
{
	/**
	 * Проверяет, не является ли значение объекта пустым с игнорированием белых символов.
	 *
	 * @return объект проверяющего.
	 * @throws BlankObjectCheckException если значение пусто.
	 */
	@NotNull
	SELF notBlank();

	/**
	 * Проверяет, не является ли значение объекта пустым с игнорированием белых символов.
	 *
	 * @param message сообщение.
	 * @return объект проверяющего.
	 * @throws BlankObjectCheckException если значение пусто.
	 */
	@NotNull
	SELF notBlank(@Nullable String message);
}
