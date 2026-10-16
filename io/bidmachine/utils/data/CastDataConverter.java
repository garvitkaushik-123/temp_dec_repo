package io.bidmachine.utils.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes8.dex */
public class CastDataConverter implements DataConverter {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.bidmachine.utils.data.DataConverter
    public <T> T toOrNull(Object object, T fallback) throws Exception {
        return object != 0 ? object : fallback;
    }

    @Override // io.bidmachine.utils.data.DataConverter
    public String toStringOrNull(Object object, String fallback) {
        return object instanceof String ? (String) object : fallback;
    }

    @Override // io.bidmachine.utils.data.DataConverter
    public Boolean toBooleanOrNull(Object object, Boolean fallback) {
        return object instanceof Boolean ? (Boolean) object : fallback;
    }

    @Override // io.bidmachine.utils.data.DataConverter
    public Integer toIntegerOrNull(Object object, Integer fallback) {
        return object instanceof Integer ? (Integer) object : fallback;
    }

    @Override // io.bidmachine.utils.data.DataConverter
    public Float toFloatOrNull(Object object, Float fallback) {
        return object instanceof Float ? (Float) object : fallback;
    }

    @Override // io.bidmachine.utils.data.DataConverter
    public Double toDoubleOrNull(Object object, Double fallback) {
        return object instanceof Double ? (Double) object : fallback;
    }

    @Override // io.bidmachine.utils.data.DataConverter
    public List<Object> toListOrNull(Object object) {
        if (!(object instanceof List)) {
            return null;
        }
        List list = (List) object;
        if (list.isEmpty()) {
            return null;
        }
        return new ArrayList(list);
    }

    @Override // io.bidmachine.utils.data.DataConverter
    public Map<Object, Object> toMapOrNull(Object object) {
        if (!(object instanceof Map)) {
            return null;
        }
        Map map = (Map) object;
        if (map.isEmpty()) {
            return null;
        }
        return new HashMap(map);
    }
}
