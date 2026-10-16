package io.bidmachine.utils.data;

import io.bidmachine.Function;
import java.util.List;
import java.util.Map;

/* loaded from: classes8.dex */
public interface DataRetriever<K> {
    boolean contains(K key);

    boolean getBoolean(K key, boolean fallback);

    Boolean getBooleanOrNull(K key, Boolean fallback);

    double getDouble(K key, double fallback);

    Double getDoubleOrNull(K key, Double fallback);

    float getFloat(K key, float fallback);

    Float getFloatOrNull(K key, Float fallback);

    int getInteger(K key, int fallback);

    Integer getIntegerOrNull(K key, Integer fallback);

    List<Object> getListOrNull(K key);

    Map<Object, Object> getMapOrNull(K key);

    Object getObjectOrNull(K key, Object fallback);

    <T> T getOrNull(K key, T fallback) throws Exception;

    String getStringOrNull(K key, String fallback);

    default String getStringOrNull(K key) {
        return getStringOrNull(key, null);
    }

    default boolean getBoolean(K key) {
        return getBoolean(key, false);
    }

    default Boolean getBooleanOrNull(K key) {
        return getBooleanOrNull(key, false);
    }

    default int getInteger(K key) {
        return getInteger(key, 0);
    }

    default Integer getIntegerOrNull(K key) {
        return getIntegerOrNull(key, null);
    }

    default float getFloat(K key) {
        return getFloat(key, 0.0f);
    }

    default Float getFloatOrNull(K key) {
        return getFloatOrNull(key, null);
    }

    default double getDouble(K key) {
        return getDouble(key, 0.0d);
    }

    default Double getDoubleOrNull(K key) {
        return getDoubleOrNull(key, null);
    }

    default <T> T getOrNull(K k) throws Exception {
        return (T) getOrNull(k, null);
    }

    default <T> T getOrNullSafely(K k, Function<Object, T> function) {
        return (T) getOrNullSafely(k, null, function);
    }

    default <T> T getOrNullSafely(K key, T fallback, Function<Object, T> transform) {
        try {
            Object objectOrNull = getObjectOrNull(key, fallback);
            if (objectOrNull == null) {
                return null;
            }
            return transform.apply(objectOrNull);
        } catch (Exception unused) {
            return fallback;
        }
    }

    default Object getObjectOrNull(K key) {
        return getObjectOrNull(key, null);
    }
}
