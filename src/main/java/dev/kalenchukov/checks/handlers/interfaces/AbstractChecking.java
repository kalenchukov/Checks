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

import dev.kalenchukov.checks.exceptions.EqualsObjectCheckException;
import dev.kalenchukov.checks.exceptions.IllegalObjectCheckException;
import dev.kalenchukov.checks.exceptions.NullObjectCheckException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.Predicate;

/**
 * Интерфейс для реализации проверяющего объекты любых типов.
 *
 * @param <SELF> тип проверяющего объекта.
 * @param <T> тип проверяемого объекта.
 * @author Алексей Каленчуков
 */
public interface AbstractChecking<SELF, T>
{
	/**
	 * Проверяет, не является ли объект {@code null}.
	 *
	 * @return объект проверяющего.
	 * @throws NullObjectCheckException если объект равен {@code null}.
	 */
	@NotNull
	SELF notNull();

	/**
	 * Проверяет, не является ли объект {@code null}.
	 *
	 * @param message сообщение.
	 * @return объект проверяющего.
	 * @throws NullObjectCheckException если объект равен {@code null}.
	 */
	@NotNull
	SELF notNull(@Nullable String message);

	/**
	 * Проверяет, не является ли объект равным.
	 *
	 * @param value значение.
	 * @return объект проверяющего.
	 * @throws EqualsObjectCheckException если объекты равны.
	 */
	@NotNull
	SELF notEquals(@NotNull T value);

	/**
	 * Проверяет, не является ли объект равным.
	 *
	 * @param value значение.
	 * @param message сообщение.
	 * @return объект проверяющего.
	 * @throws EqualsObjectCheckException если объекты равны.
	 */
	@NotNull
	SELF notEquals(@NotNull T value, @Nullable String message);

	/**
	 * Проверяет, не удовлетворяет ли условию.
	 *
	 * @param predicate условие.
	 * @return объект проверяющего.
	 * @throws IllegalObjectCheckException если объект удовлетворяет условию.
	 */
	@NotNull
	SELF not(@NotNull Predicate<T> predicate);

	/**
	 * Проверяет, не удовлетворяет ли условию.
	 *
	 * @param predicate условие.
	 * @param message сообщение.
	 * @return объект проверяющего.
	 * @throws IllegalObjectCheckException если объект удовлетворяет условию.
	 */
	@NotNull
	SELF not(@NotNull Predicate<T> predicate, @Nullable String message);

	/**
	 * Возвращает объект проверяемого.
	 *
	 * @return объект проверяемого.
	 */
	T get();
}
