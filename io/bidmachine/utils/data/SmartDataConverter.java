package io.bidmachine.utils.data;

import io.bidmachine.core.Logger;
import java.util.List;
import java.util.Map;

/* loaded from: classes8.dex */
public class SmartDataConverter implements DataConverter {
    private final DataConverter castDataConverter = new CastDataConverter();

    @Override // io.bidmachine.utils.data.DataConverter
    public String toStringOrNull(Object object, String fallback) {
        if (object == null) {
            return fallback;
        }
        String stringOrNull = this.castDataConverter.toStringOrNull(object);
        if (stringOrNull != null) {
            return stringOrNull;
        }
        try {
            return String.valueOf(object);
        } catch (Exception e) {
            Logger.w(e);
            return fallback;
        }
    }

    @Override // io.bidmachine.utils.data.DataConverter
    public Boolean toBooleanOrNull(Object object, Boolean fallback) {
        if (object != null) {
            Boolean booleanOrNull = this.castDataConverter.toBooleanOrNull(object);
            if (booleanOrNull != null) {
                return booleanOrNull;
            }
            String stringOrNull = this.castDataConverter.toStringOrNull(object);
            if (stringOrNull != null) {
                try {
                    return Boolean.valueOf(stringOrNull);
                } catch (Exception e) {
                    Logger.w(e);
                    return fallback;
                }
            }
        }
        return fallback;
    }

    @Override // io.bidmachine.utils.data.DataConverter
    public Integer toIntegerOrNull(Object object, Integer fallback) {
        if (object != null) {
            Integer integerOrNull = this.castDataConverter.toIntegerOrNull(object);
            if (integerOrNull != null) {
                return integerOrNull;
            }
            Double doubleOrNull = this.castDataConverter.toDoubleOrNull(object);
            if (doubleOrNull != null) {
                return Integer.valueOf(doubleOrNull.intValue());
            }
            Float floatOrNull = this.castDataConverter.toFloatOrNull(object);
            if (floatOrNull != null) {
                return Integer.valueOf(floatOrNull.intValue());
            }
            String stringOrNull = this.castDataConverter.toStringOrNull(object);
            if (stringOrNull != null) {
                try {
                    return Integer.valueOf(stringOrNull);
                } catch (Exception e) {
                    Logger.w(e);
                }
            }
        }
        return fallback;
    }

    @Override // io.bidmachine.utils.data.DataConverter
    public Float toFloatOrNull(Object object, Float fallback) {
        if (object != null) {
            Float floatOrNull = this.castDataConverter.toFloatOrNull(object);
            if (floatOrNull != null) {
                return floatOrNull;
            }
            Integer integerOrNull = this.castDataConverter.toIntegerOrNull(object);
            if (integerOrNull != null) {
                return Float.valueOf(integerOrNull.floatValue());
            }
            String stringOrNull = toStringOrNull(object);
            if (stringOrNull != null) {
                try {
                    return Float.valueOf(stringOrNull);
                } catch (Exception e) {
                    Logger.w(e);
                }
            }
        }
        return fallback;
    }

    @Override // io.bidmachine.utils.data.DataConverter
    public Double toDoubleOrNull(Object object, Double fallback) {
        if (object != null) {
            Double doubleOrNull = this.castDataConverter.toDoubleOrNull(object);
            if (doubleOrNull != null) {
                return doubleOrNull;
            }
            Integer integerOrNull = this.castDataConverter.toIntegerOrNull(object);
            if (integerOrNull != null) {
                return Double.valueOf(integerOrNull.doubleValue());
            }
            String stringOrNull = toStringOrNull(object);
            if (stringOrNull != null) {
                try {
                    return Double.valueOf(stringOrNull);
                } catch (Exception e) {
                    Logger.w(e);
                }
            }
        }
        return fallback;
    }

    @Override // io.bidmachine.utils.data.DataConverter
    public List<Object> toListOrNull(Object object) {
        return this.castDataConverter.toListOrNull(object);
    }

    @Override // io.bidmachine.utils.data.DataConverter
    public Map<Object, Object> toMapOrNull(Object object) {
        return this.castDataConverter.toMapOrNull(object);
    }

    @Override // io.bidmachine.utils.data.DataConverter
    public <T> T toOrNull(Object obj, T t) throws Exception {
        return (T) this.castDataConverter.toOrNull(obj, t);
    }
}
