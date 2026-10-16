package com.tiktok.appevents.base;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class TTBaseEvent {
    public String eventId;
    public String eventName;
    public JSONObject properties;

    public TTBaseEvent(String eventName, JSONObject properties, String eventId) {
        this.eventName = eventName;
        this.properties = properties;
        this.eventId = eventId;
    }

    public static Builder newBuilder(String eventName) {
        return new Builder(eventName);
    }

    public static Builder newBuilder(String eventName, String eventId) {
        return new Builder(eventName, eventId);
    }

    public static class Builder {
        public String eventId;
        public String eventName;
        public JSONObject properties = new JSONObject();

        public Builder(String eventName) {
            this.eventName = eventName;
        }

        public Builder(String eventName, String eventId) {
            this.eventName = eventName;
            this.eventId = eventId;
        }

        public Builder addProperty(String key, Object value) {
            safeAddProperty(key, value);
            return this;
        }

        public Builder addProperty(String key, String value) {
            safeAddProperty(key, value);
            return this;
        }

        public Builder addProperty(String key, boolean value) {
            safeAddProperty(key, Boolean.valueOf(value));
            return this;
        }

        public Builder addProperty(String key, double value) {
            safeAddProperty(key, Double.valueOf(value));
            return this;
        }

        public Builder addProperty(String key, int value) {
            safeAddProperty(key, Integer.valueOf(value));
            return this;
        }

        public Builder addProperty(String key, long value) {
            safeAddProperty(key, Long.valueOf(value));
            return this;
        }

        private void safeAddProperty(String key, Object value) {
            try {
                this.properties.put(key, value);
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }

        public TTBaseEvent build() {
            return new TTBaseEvent(this.eventName, this.properties, this.eventId);
        }
    }
}
