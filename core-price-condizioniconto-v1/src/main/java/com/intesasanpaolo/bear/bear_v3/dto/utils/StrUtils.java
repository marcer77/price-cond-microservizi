package com.intesasanpaolo.bear.bear_v3.dto.utils;

import java.util.Arrays;

public final class StrUtils {
	/**
	 * Capitalizes the first letter of the input string.
	 *
	 * @param value
	 *           The string to be capitalized
	 * @return The changed string
	 */
	public static String capitalize(final String value) {
		final char[] chars = value.toCharArray();
		chars[0] = Character.toUpperCase(chars[0]);
		return new String(chars);
	}

	/**
	 * If the input string is empty (or it includes spaces only) {@code null} is returned,
	 * otherwise the (trimmed) original value is returned.
	 * 
	 * @param value
	 *            The string to check
	 * @return The new value
	 */
	public static String emptyToNull(final String value) {
		return value == null || value.trim().isEmpty() ? null : value.trim();
	}

	/**
	 * If the input string is {@code null} an empty string is returned, otherwise the
	 * original value is returned.
	 *
	 * @param value
	 *           The string to check
	 * @return The new value
	 */
	public static String nullToEmpty(final String value) {
		return nullToEmpty(value, 0);
	}

	/**
	 * If the input string is {@code null} an empty string of the specified length is
	 * returned, otherwise the original value is returned.
	 *
	 * @param value
	 *           The string to check
	 * @param length
	 *           The length of the empty string to be returned
	 * @return The new value
	 */
	public static String nullToEmpty(final String value, final int length) {
		if (value != null) {
			return value;
		}

		if (length == 0) {
			return "";
		}

		final char[] charArray = new char[length];
		Arrays.fill(charArray, ' ');

		return new String(charArray);
	}

	/**
	 * Checks if the input string is {@code null} or empty.
	 *
	 * @param value
	 *           The string to check
	 * @return {@code true} if the string is {@code null} or empty, {@code false} otherwise
	 */
	public static boolean isNullOrEmpty(final String value) {
		return value == null || value.isEmpty();
	}
	
	public static String truncate(String s, int maxSize) {
		if (isNullOrEmpty(s))
			return null;
		
		s = s.trim();
		
		// Questo per evitare NullPointerException nel caso in cui la stringa originale
		// contenga solo spazi
		if (isNullOrEmpty(s))
			return null;
		
		if(s.length() > maxSize)
			s = s.substring(0, maxSize).trim();
		
		return s;
	}
}
