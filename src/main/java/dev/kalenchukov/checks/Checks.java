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
}
