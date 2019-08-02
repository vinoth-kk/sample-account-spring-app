package com.anz.sample.repo.model.enums;

public enum SampleResponseStatus {
	INVALID_ACCOUNT(701, "Invalid Account");

	private final int value;

	private final String reasonPhrase;

	SampleResponseStatus(int value, String reasonPhrase) {
		this.value = value;
		this.reasonPhrase = reasonPhrase;
	}

	/**
	 * Return the integer value of this status code.
	 */
	public int value() {
		return this.value;
	}

	/**
	 * Return the reason phrase of this status code.
	 */
	public String getReasonPhrase() {
		return this.reasonPhrase;
	}

}
