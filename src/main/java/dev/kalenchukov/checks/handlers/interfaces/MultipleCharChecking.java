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

import dev.kalenchukov.checks.exceptions.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Интерфейс для реализации проверяющего объекты типов содержащие множество символов.
 *
 * @param <SELF> тип проверяющего объекта.
 * @param <T> тип проверяемого объекта.
 * @author Алексей Каленчуков
 */
public interface MultipleCharChecking<SELF, T>
{
	/**
	 * Проверяет, не является ли значение объекта пустым.
	 *
	 * @return объект проверяющего.
	 * @throws EmptyObjectCheckException если значение объекта пусто.
	 */
	@NotNull
	SELF notEmpty();

	/**
	 * Проверяет, не является ли значение объекта пустым.
	 *
	 * @param message сообщение.
	 * @return объект проверяющего.
	 * @throws EmptyObjectCheckException если значение объекта пусто.
	 */
	@NotNull
	SELF notEmpty(@Nullable String message);

	/**
	 * Проверяет, не является ли количество символов объекта равным.
	 *
	 * @param length количество символов.
	 * @return объект проверяющего.
	 * @throws LengthObjectCheckException если значение равно количеству символов.
	 */
	@NotNull
	SELF notLength(int length);

	/**
	 * Проверяет, не является ли количество символов объекта равным.
	 *
	 * @param length количество символов.
	 * @param message сообщение.
	 * @return объект проверяющего.
	 * @throws LengthObjectCheckException если значение равно количеству символов.
	 */
	@NotNull
	SELF notLength(int length, @Nullable String message);

	/**
	 * Проверяет, не входит ли в диапазон количество символов объекта.
	 *
	 * @param from минимальное количество символов (включительно).
	 * @param to максимальное количество символов (включительно).
	 * @return объект проверяющего.
	 * @throws RangeLengthObjectCheckException если значение входит в диапазон количества символов.
	 */
	@NotNull
	SELF notRangeLength(int from, int to);

	/**
	 * Проверяет, не входит ли в диапазон количество символов объекта.
	 *
	 * @param from минимальное количество символов (включительно).
	 * @param to максимальное количество символов (включительно).
	 * @param message сообщение.
	 * @return объект проверяющего.
	 * @throws RangeLengthObjectCheckException если значение входит в диапазон количества символов.
	 */
	@NotNull
	SELF notRangeLength(int from, int to, @Nullable String message);

	/**
	 * Проверяет, не превышается ли количество символов объекта.
	 *
	 * @param length максимальное количество символов (включительно).
	 * @return объект проверяющего.
	 * @throws MoreLengthObjectCheckException если значение превышает количество символов.
	 */
	@NotNull
	SELF notMoreLength(int length);

	/**
	 * Проверяет, не превышается ли количество символов объекта.
	 *
	 * @param length максимальное количество символов (включительно).
	 * @param message сообщение.
	 * @return объект проверяющего.
	 * @throws MoreLengthObjectCheckException если значение превышает количество символов.
	 */
	@NotNull
	SELF notMoreLength(int length, @Nullable String message);

	/**
	 * Проверяет, не принижается ли количество символов объекта.
	 *
	 * @param length минимальное количество символов (включительно).
	 * @return объект проверяющего.
	 * @throws LessLengthObjectCheckException если значение меньше количества символов.
	 */
	@NotNull
	SELF notLessLength(int length);

	/**
	 * Проверяет, не принижается ли количество символов объекта.
	 *
	 * @param length минимальное количество символов (включительно).
	 * @param message сообщение.
	 * @return объект проверяющего.
	 * @throws LessLengthObjectCheckException если значение меньше количества символов.
	 */
	@NotNull
	SELF notLessLength(int length, @Nullable String message);
}
