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
 * Интерфейс для реализации проверяющего объекты типа {@code Number}.
 *
 * @param <SELF> тип проверяющего объекта.
 * @param <T> тип проверяемого объекта.
 * @author Алексей Каленчуков
 */
public interface NumberChecking<SELF, T>
{
	/**
	 * Проверяет, не является ли значение объекта равным нулю.
	 *
	 * @return объект проверяющего.
	 * @throws ZeroNumberObjectCheckException если значение равно нулю.
	 */
	@NotNull
	SELF notZero();

	/**
	 * Проверяет, не является ли значение объекта равным нулю.
	 *
	 * @param message сообщение.
	 * @return объект проверяющего.
	 * @throws ZeroNumberObjectCheckException если значение равно нулю.
	 */
	@NotNull
	SELF notZero(@Nullable String message);

	/**
	 * Проверяет, не является ли значение объекта отрицательным числом.
	 *
	 * @return объект проверяющего.
	 * @throws NegativeNumberObjectCheckException если значение является отрицательным числом.
	 */
	@NotNull
	SELF notNegative();

	/**
	 * Проверяет, не является ли значение объекта на отрицательным числом.
	 *
	 * @param message сообщение.
	 * @return объект проверяющего.
	 * @throws NegativeNumberObjectCheckException если значение является отрицательным числом.
	 */
	@NotNull
	SELF notNegative(@Nullable String message);

	/**
	 * Проверяет, не является ли значение объекта положительным числом.
	 *
	 * @return объект проверяющего.
	 * @throws PositiveNumberObjectCheckException если значение является положительным числом.
	 */
	@NotNull
	SELF notPositive();

	/**
	 * Проверяет, не является ли значение объекта положительным числом.
	 *
	 * @param message сообщение.
	 * @return объект проверяющего.
	 * @throws PositiveNumberObjectCheckException если значение является положительным числом.
	 */
	@NotNull
	SELF notPositive(@Nullable String message);

	/**
	 * Проверяет, не является ли значение объекта больше числа.
	 *
	 * @param number число.
	 * @return объект проверяющего.
	 * @throws MoreNumberObjectCheckException если значение больше числа.
	 */
	@NotNull
	SELF notMoreNumber(@NotNull T number);

	/**
	 * Проверяет, не является ли значение объекта больше числа.
	 *
	 * @param number число.
	 * @param message сообщение.
	 * @return объект проверяющего.
	 * @throws MoreNumberObjectCheckException если значение больше числа.
	 */
	@NotNull
	SELF notMoreNumber(@NotNull T number, @Nullable String message);

	/**
	 * Проверяет, не является ли значение объекта меньше числа.
	 *
	 * @param number число.
	 * @return объект проверяющего.
	 * @throws LessNumberObjectCheckException если значение меньше числа.
	 */
	@NotNull
	SELF notLessNumber(@NotNull T number);

	/**
	 * Проверяет, не является ли значение объекта меньше числа.
	 *
	 * @param number число.
	 * @param message сообщение.
	 * @return объект проверяющего.
	 * @throws LessNumberObjectCheckException если значение меньше числа.
	 */
	@NotNull
	SELF notLessNumber(@NotNull T number, @Nullable String message);

	/**
	 * Проверяет, не является ли значение объекта входящим в диапазон чисел.
	 *
	 * @param from минимальное число (включительно).
	 * @param to максимальное число (включительно).
	 * @return объект проверяющего.
	 * @throws RangeNumberObjectCheckException если значение входит в диапазон чисел.
	 */
	@NotNull
	SELF notRangeNumber(@NotNull T from, @NotNull T to);

	/**
	 * Проверяет, не является ли значение объекта входящим в диапазон чисел.
	 *
	 * @param from минимальное число (включительно).
	 * @param to максимальное число (включительно).
	 * @param message сообщение.
	 * @return объект проверяющего.
	 * @throws RangeNumberObjectCheckException если значение входит в диапазон чисел.
	 */
	@NotNull
	SELF notRangeNumber(@NotNull T from, @NotNull T to, @Nullable String message);
}
