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
 * Интерфейс для реализации проверяющего объекты типов содержащие множество объектов.
 *
 * @param <SELF> тип проверяющего объекта.
 * @param <T> тип проверяемого объекта.
 * @author Алексей Каленчуков
 */
public interface MultipleObjectChecking<SELF, T>
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
	 * Проверяет, не является ли значение объекта равным количеству элементов.
	 *
	 * @param size количество элементов.
	 * @return объект проверяющего.
	 * @throws SizeObjectCheckException если значение равно количеству элементов.
	 */
	@NotNull
	SELF notSize(int size);

	/**
	 * Проверяет, не является ли значение объекта равным количеству элементов.
	 *
	 * @param size количество элементов.
	 * @param message сообщение.
	 * @return объект проверяющего.
	 * @throws SizeObjectCheckException если значение равно количеству элементов.
	 */
	@NotNull
	SELF notSize(int size, @Nullable String message);

	/**
	 * Проверяет, не входит ли в диапазон количество элементов объекта.
	 *
	 * @param from минимальное количество элементов (включительно).
	 * @param to максимальное количество элементов (включительно).
	 * @return объект проверяющего.
	 * @throws RangeSizeObjectCheckException если значение входит в диапазон количества элементов.
	 */
	@NotNull
	SELF notRangeSize(int from, int to);

	/**
	 * Проверяет, не входит ли в диапазон количество элементов объекта.
	 *
	 * @param from минимальное количество элементов (включительно).
	 * @param to максимальное количество элементов (включительно).
	 * @param message сообщение.
	 * @return объект проверяющего.
	 * @throws RangeSizeObjectCheckException если значение входит в диапазон количества элементов.
	 */
	@NotNull
	SELF notRangeSize(int from, int to, @Nullable String message);

	/**
	 * Проверяет, не превышается ли количество элементов объекта.
	 *
	 * @param size максимальное количество элементов (включительно).
	 * @return объект проверяющего.
	 * @throws MoreSizeObjectCheckException если значение превышает количество элементов.
	 */
	@NotNull
	SELF notMoreSize(int size);

	/**
	 * Проверяет, не превышается ли количество элементов объекта.
	 *
	 * @param size максимальное количество элементов (включительно).
	 * @param message сообщение.
	 * @return объект проверяющего.
	 * @throws MoreSizeObjectCheckException если значение превышает количество элементов.
	 */
	@NotNull
	SELF notMoreSize(int size, @Nullable String message);

	/**
	 * Проверяет, не принижается ли количество элементов объекта.
	 *
	 * @param size минимальное количество элементов (включительно).
	 * @return объект проверяющего.
	 * @throws LessSizeObjectCheckException если значение понижает количество элементов.
	 */
	@NotNull
	SELF notLessSize(int size);

	/**
	 * Проверяет, не принижается ли количество элементов объекта.
	 *
	 * @param size минимальное количество элементов (включительно).
	 * @param message сообщение.
	 * @return объект проверяющего.
	 * @throws LessSizeObjectCheckException если значение понижает количество элементов.
	 */
	@NotNull
	SELF notLessSize(int size, @Nullable String message);
}
