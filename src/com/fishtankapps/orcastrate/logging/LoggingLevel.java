package com.fishtankapps.orcastrate.logging;

public enum LoggingLevel {
	VERBOSE("[VERBOSE] "), DEBUG("[DEBUG]   "), INFO("[INFO]    "), WARN("[WARN]    "), ERROR("![ERROR]! ");

	String tag;
	int importance;
	LoggingLevel(String tag) {
		this.tag = tag;
		importance = ordinal();
	}
}