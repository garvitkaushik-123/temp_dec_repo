package io.bidmachine.utils.data;

import java.util.List;
import java.util.Map;

/* loaded from: classes8.dex */
public interface DataConverter {
    Boolean toBooleanOrNull(Object object, Boolean fallback);

    Double toDoubleOrNull(Object object, Double fallback);

    Float toFloatOrNull(Object object, Float fallback);

    Integer toIntegerOrNull(Object object, Integer fallback);

    List<Object> toListOrNull(Object object);

    Map<Object, Object> toMapOrNull(Object object);

    <T> T toOrNull(Object object, T fallback) throws Exception;

    String toStringOrNull(Object object, String fallback);

    default String toStringOrNull(Object object) {
        return toStringOrNull(object, null);
    }

    default boolean toBoolean(Object object, boolean fallback) {
        Boolean booleanOrNull = toBooleanOrNull(object);
        return booleanOrNull != null ? booleanOrNull.booleanValue() : fallback;
    }

    default Boolean toBooleanOrNull(Object object) {
        return toBooleanOrNull(object, null);
    }

    default int toInteger(Object object, int fallback) {
        Integer integerOrNull = toIntegerOrNull(object);
        return integerOrNull != null ? integerOrNull.intValue() : fallback;
    }

    default Integer toIntegerOrNull(Object object) {
        return toIntegerOrNull(object, null);
    }

    default float toFloat(Object object, float fallback) {
        Float floatOrNull = toFloatOrNull(object);
        return floatOrNull != null ? floatOrNull.floatValue() : fallback;
    }

    default Float toFloatOrNull(Object object) {
        return toFloatOrNull(object, null);
    }

    default double toDouble(Object object, double fallback) {
        Double doubleOrNull = toDoubleOrNull(object);
        return doubleOrNull != null ? doubleOrNull.doubleValue() : fallback;
    }

    default Double toDoubleOrNull(Object object) {
        return toDoubleOrNull(object, null);
    }

    default <T> T toOrNull(Object obj) throws Exception {
        return (T) toOrNull(obj, null);
    }
}
