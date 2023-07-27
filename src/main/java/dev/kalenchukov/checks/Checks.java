/*
 * Copyright © 2023 Алексей Каленчуков
 * GitHub: https://github.com/kalenchukov
 * E-mail: mailto:aleksey.kalenchukov@yandex.ru
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package dev.kalenchukov.checks;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;

/**
 * Класс проверки объектов по заданным критериям.
 *
 * @author Алексей Каленчуков
 */
public final class Checks
{
	/**
	 * Конструктор для {@code Checks}.
	 */
	private Checks() {}

	/**
	 * Проверяет, не является ли объект {@code null}.
	 *
	 * @param obj проверяемый объект.
	 * @param <O> тип проверяемого объекта.
	 * @return проверяемый объект.
	 * @throws NullPointerException если {@code obj} является {@code null}.
	 */
	@NotNull
	public static <O> O requireNotNull(@Nullable final O obj)
	{
		return Checks.requireNotNull(obj, "");
	}

	/**
	 * Проверяет, не является ли объект {@code null}.
	 *
	 * @param obj проверяемый объект.
	 * @param message сообщение вызываемого исключения.
	 * @param <O> тип проверяемого объекта.
	 * @return проверяемый объект.
	 * @throws NullPointerException если {@code obj} является {@code null}.
	 */
	@NotNull
	public static <O> O requireNotNull(@Nullable final O obj, @Nullable final String message)
	{
		if (obj == null) {
			throw new NullPointerException(message);
		}

		return obj;
	}

	/**
	 * Проверяет, не является ли объект {@code null} и пустым значением.
	 *
	 * @param obj проверяемый объект.
	 * @param <O> тип проверяемого объекта.
	 * @return проверяемый объект.
	 * @throws NullPointerException если {@code obj} является {@code null}.
	 * @throws IllegalArgumentException если {@code obj} является {@code null} или пустым значением.
	 */
	@NotNull
	public static <O extends CharSequence> O requireNotNullAndNotEmpty(@Nullable final O obj)
	{
		return Checks.requireNotNullAndNotEmpty(obj, "");
	}

	/**
	 * Проверяет, не является ли объект {@code null} и пустым значением.
	 *
	 * @param obj проверяемый объект.
	 * @param message сообщение вызываемого исключения.
	 * @param <O> тип проверяемого объекта.
	 * @return проверяемый объект.
	 * @throws NullPointerException если {@code obj} является {@code null}.
	 * @throws IllegalArgumentException если {@code obj} является {@code null} или пустым значением.
	 */
	@NotNull
	public static <O extends CharSequence> O requireNotNullAndNotEmpty(@Nullable final O obj,
																	   @Nullable final String message)
	{
		if (obj == null) {
			throw new NullPointerException(message);
		}

		if (obj.isEmpty()) {
			throw new IllegalArgumentException(message);
		}

		return obj;
	}

	/**
	 * Проверяет, не является ли объект {@code null} и пустым массивом.
	 *
	 * @param obj проверяемый объект.
	 * @param <O> тип проверяемого объекта.
	 * @return проверяемый объект.
	 * @throws NullPointerException если {@code obj} является {@code null}.
	 * @throws IllegalArgumentException если {@code obj} является {@code null} или пустым массивом.
	 */
	@Nullable
	public static <O> O @NotNull [] requireNotNullAndNotEmpty(@Nullable final O @Nullable [] obj)
	{
		return Checks.requireNotNullAndNotEmpty(obj, "");
	}

	/**
	 * Проверяет, не является ли объект {@code null} и пустым массивом.
	 *
	 * @param obj проверяемый объект.
	 * @param message сообщение вызываемого исключения.
	 * @param <O> тип проверяемого объекта.
	 * @return проверяемый объект.
	 * @throws NullPointerException если {@code obj} является {@code null}.
	 * @throws IllegalArgumentException если {@code obj} является {@code null} или пустым массивом.
	 */
	@Nullable
	public static <O> O @NotNull [] requireNotNullAndNotEmpty(@Nullable final O @Nullable [] obj,
															  @Nullable final String message)
	{
		if (obj == null) {
			throw new NullPointerException(message);
		}

		if (obj.length == 0) {
			throw new IllegalArgumentException(message);
		}

		return obj;
	}

	/**
	 * Проверяет, не является ли объект {@code null} и пустой коллекцией.
	 *
	 * @param obj проверяемый объект.
	 * @param <O> тип проверяемого объекта.
	 * @return проверяемый объект.
	 * @throws NullPointerException если {@code obj} является {@code null}.
	 * @throws IllegalArgumentException если {@code obj} является {@code null} или пустой коллекцией.
	 */
	@NotNull
	public static <O extends Collection<?>> O requireNotNullAndNotEmpty(@Nullable final O obj)
	{
		return Checks.requireNotNullAndNotEmpty(obj, "");
	}

	/**
	 * Проверяет, не является ли объект {@code null} и пустой коллекцией.
	 *
	 * @param obj проверяемый объект.
	 * @param message сообщение вызываемого исключения.
	 * @param <O> тип проверяемого объекта.
	 * @return проверяемый объект.
	 * @throws NullPointerException если {@code obj} является {@code null}.
	 * @throws IllegalArgumentException если {@code obj} является {@code null} или пустой коллекцией.
	 */
	@NotNull
	public static <O extends Collection<?>> O requireNotNullAndNotEmpty(@Nullable final O obj,
																		@Nullable final String message)
	{
		if (obj == null) {
			throw new NullPointerException(message);
		}

		if (obj.isEmpty()) {
			throw new IllegalArgumentException(message);
		}

		return obj;
	}

	/**
	 * Проверяет, не является ли объект {@code null} и имеет указанное количество символов.
	 *
	 * @param obj проверяемый объект.
	 * @param length количество символов.
	 * @param <O> тип проверяемого объекта.
	 * @return проверяемый объект.
	 * @throws NullPointerException если {@code obj} является {@code null}.
	 * @throws IllegalArgumentException если {@code obj} является {@code null} или
	 * не имеет указанного количества символов.
	 */
	@NotNull
	public static <O extends CharSequence> O requireNotNullAndLength(@Nullable final O obj,
																	 final int length)
	{
		return Checks.requireNotNullAndLength(obj, length, "");
	}

	/**
	 * Проверяет, не является ли объект {@code null} и имеет указанное количество символов.
	 *
	 * @param obj проверяемый объект.
	 * @param length количество символов.
	 * @param message сообщение вызываемого исключения.
	 * @param <O> тип проверяемого объекта.
	 * @return проверяемый объект.
	 * @throws NullPointerException если {@code obj} является {@code null}.
	 * @throws IllegalArgumentException если {@code obj} является {@code null} или
	 * не имеет указанного количества символов.
	 */
	@NotNull
	public static <O extends CharSequence> O requireNotNullAndLength(@Nullable final O obj,
																	 final int length,
																	 @Nullable final String message)
	{
		if (obj == null) {
			throw new NullPointerException(message);
		}

		if (obj.length() != length) {
			throw new IllegalArgumentException(message);
		}

		return obj;
	}

	/**
	 * Проверяет, не является ли объект {@code null} и имеет количество символов из диапазона.
	 *
	 * @param obj проверяемый объект.
	 * @param fromLength нижняя граница диапазона количества символов.
	 * @param toLength верхняя граница диапазона количества символов.
	 * @param <O> тип проверяемого объекта.
	 * @return проверяемый объект.
	 * @throws NullPointerException если {@code obj} является {@code null}.
	 * @throws IndexOutOfBoundsException если {@code obj} является {@code null} или
	 * не имеет количества символов из диапазона.
	 */
	@NotNull
	public static <O extends CharSequence> O requireNotNullAndLengthRange(@Nullable final O obj,
																		  final int fromLength,
																		  final int toLength)
	{
		return Checks.requireNotNullAndLengthRange(obj, fromLength, toLength, "");
	}

	/**
	 * Проверяет, не является ли объект {@code null} и имеет количество символов из диапазона.
	 *
	 * @param obj проверяемый объект.
	 * @param fromLength нижняя граница диапазона количества символов.
	 * @param toLength верхняя граница диапазона количества символов.
	 * @param message сообщение вызываемого исключения.
	 * @param <O> тип проверяемого объекта.
	 * @return проверяемый объект.
	 * @throws NullPointerException если {@code obj} является {@code null}.
	 * @throws IndexOutOfBoundsException если {@code obj} является {@code null} или
	 * не имеет количества символов из диапазона.
	 */
	@NotNull
	public static <O extends CharSequence> O requireNotNullAndLengthRange(@Nullable final O obj,
																		  final int fromLength,
																		  final int toLength,
																		  @Nullable final String message)
	{
		if (obj == null) {
			throw new NullPointerException(message);
		}

		if (obj.length() < fromLength || obj.length() > toLength) {
			throw new IndexOutOfBoundsException(message);
		}

		return obj;
	}

	/**
	 * Проверяет, не является ли объект {@code null} и имеет указанное количество элементов.
	 *
	 * @param obj проверяемый объект.
	 * @param size количество элементов.
	 * @param <O> тип проверяемого объекта.
	 * @return проверяемый объект.
	 * @throws NullPointerException если {@code obj} является {@code null}.
	 * @throws IndexOutOfBoundsException если {@code obj} является {@code null} или
	 * не имеет указанного количества элементов.
	 */
	@NotNull
	public static <O extends Collection<?>> O requireNotNullAndSize(@Nullable final O obj,
																	final int size)
	{
		return Checks.requireNotNullAndSize(obj, size, "");
	}

	/**
	 * Проверяет, не является ли объект {@code null} и имеет указанное количество элементов.
	 *
	 * @param obj проверяемый объект.
	 * @param size количество элементов.
	 * @param message сообщение вызываемого исключения.
	 * @param <O> тип проверяемого объекта.
	 * @return проверяемый объект.
	 * @throws NullPointerException если {@code obj} является {@code null}.
	 * @throws IndexOutOfBoundsException если {@code obj} является {@code null} или
	 * не имеет указанного количества элементов.
	 */
	@NotNull
	public static <O extends Collection<?>> O requireNotNullAndSize(@Nullable final O obj,
																	final int size,
																	@Nullable final String message)
	{
		if (obj == null) {
			throw new NullPointerException(message);
		}

		if (obj.size() != size) {
			throw new IndexOutOfBoundsException(message);
		}

		return obj;
	}

	/**
	 * Проверяет, не является ли объект {@code null} и имеет количество элементов из диапазона.
	 *
	 * @param obj проверяемый объект.
	 * @param fromSize нижняя граница диапазона количества элементов.
	 * @param toSize верхняя граница диапазона количества элементов.
	 * @param <O> тип проверяемого объекта.
	 * @return проверяемый объект.
	 * @throws NullPointerException если {@code obj} является {@code null}.
	 * @throws IndexOutOfBoundsException если {@code obj} является {@code null} или
	 * не имеет количества элементов из диапазона.
	 */
	@NotNull
	public static <O extends Collection<?>> O requireNotNullAndSizeRange(@Nullable final O obj,
																		 final int fromSize,
																		 final int toSize)
	{
		return Checks.requireNotNullAndSizeRange(obj, fromSize, toSize, "");
	}

	/**
	 * Проверяет, не является ли объект {@code null} и имеет количество элементов из диапазона.
	 *
	 * @param obj проверяемый объект.
	 * @param fromSize нижняя граница диапазона количества элементов.
	 * @param toSize верхняя граница диапазона количества элементов.
	 * @param message сообщение вызываемого исключения.
	 * @param <O> тип проверяемого объекта.
	 * @return проверяемый объект.
	 * @throws NullPointerException если {@code obj} является {@code null}.
	 * @throws IndexOutOfBoundsException если {@code obj} является {@code null} или
	 * не имеет количества элементов из диапазона.
	 */
	@NotNull
	public static <O extends Collection<?>> O requireNotNullAndSizeRange(@Nullable final O obj,
																		 final int fromSize,
																		 final int toSize,
																		 @Nullable final String message)
	{
		if (obj == null) {
			throw new NullPointerException(message);
		}

		if (obj.size() < fromSize || obj.size() > toSize) {
			throw new IndexOutOfBoundsException(message);
		}

		return obj;
	}

	/**
	 * Проверяет, не является ли объект {@code null} и имеет количество элементов из диапазона.
	 *
	 * @param obj проверяемый объект.
	 * @param fromSize нижняя граница диапазона количества элементов.
	 * @param toSize верхняя граница диапазона количества элементов.
	 * @param <O> тип проверяемого объекта.
	 * @return проверяемый объект.
	 * @throws NullPointerException если {@code obj} является {@code null}.
	 * @throws IndexOutOfBoundsException если {@code obj} является {@code null} или
	 * не имеет количества элементов из диапазона.
	 */
	@NotNull
	public static <O extends Map<?, ?>> O requireNotNullAndSizeRange(@Nullable final O obj,
																	 final int fromSize,
																	 final int toSize)
	{
		return Checks.requireNotNullAndSizeRange(obj, fromSize, toSize, "");
	}

	/**
	 * Проверяет, не является ли объект {@code null} и имеет количество элементов из диапазона.
	 *
	 * @param obj проверяемый объект.
	 * @param fromSize нижняя граница диапазона количества элементов.
	 * @param toSize верхняя граница диапазона количества элементов.
	 * @param message сообщение вызываемого исключения.
	 * @param <O> тип проверяемого объекта.
	 * @return проверяемый объект.
	 * @throws NullPointerException если {@code obj} является {@code null}.
	 * @throws IndexOutOfBoundsException если {@code obj} является {@code null} или
	 * не имеет количества элементов из диапазона.
	 */
	@NotNull
	public static <O extends Map<?, ?>> O requireNotNullAndSizeRange(@Nullable final O obj,
																	 final int fromSize,
																	 final int toSize,
																	 @Nullable final String message)
	{
		if (obj == null) {
			throw new NullPointerException(message);
		}

		if (obj.size() < fromSize || obj.size() > toSize) {
			throw new IndexOutOfBoundsException(message);
		}

		return obj;
	}
}
