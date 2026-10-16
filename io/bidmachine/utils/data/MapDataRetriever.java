package io.bidmachine.utils.data;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes8.dex */
public class MapDataRetriever<K> implements DataRetriever<K> {
    private final DataConverter dataConverter;
    private final Map<K, Object> params;

    public MapDataRetriever() {
        this(new ConcurrentHashMap(), new SmartDataConverter());
    }

    public MapDataRetriever(Map<K, Object> params, DataConverter dataConverter) {
        this.params = params;
        this.dataConverter = dataConverter;
    }

    public Map<K, Object> getParams() {
        return this.params;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setParams(Map<K, Object> params) {
        clear();
        if (params != 0) {
            getParams().putAll(params);
        }
    }

    public void put(K key, Object value) {
        getParams().put(key, value);
    }

    public void clear() {
        getParams().clear();
    }

    @Override // io.bidmachine.utils.data.DataRetriever
    public boolean contains(K key) {
        return getParams().containsKey(key);
    }

    @Override // io.bidmachine.utils.data.DataRetriever
    public String getStringOrNull(K key, String fallback) {
        return this.dataConverter.toStringOrNull(getObjectOrNull(key, fallback), fallback);
    }

    @Override // io.bidmachine.utils.data.DataRetriever
    public boolean getBoolean(K key, boolean fallback) {
        return this.dataConverter.toBoolean(getObjectOrNull(key, Boolean.valueOf(fallback)), fallback);
    }

    @Override // io.bidmachine.utils.data.DataRetriever
    public Boolean getBooleanOrNull(K key, Boolean fallback) {
        return this.dataConverter.toBooleanOrNull(getObjectOrNull(key, fallback), fallback);
    }

    @Override // io.bidmachine.utils.data.DataRetriever
    public int getInteger(K key, int fallback) {
        return this.dataConverter.toInteger(getObjectOrNull(key, Integer.valueOf(fallback)), fallback);
    }

    @Override // io.bidmachine.utils.data.DataRetriever
    public Integer getIntegerOrNull(K key, Integer fallback) {
        return this.dataConverter.toIntegerOrNull(getObjectOrNull(key, fallback), fallback);
    }

    @Override // io.bidmachine.utils.data.DataRetriever
    public float getFloat(K key, float fallback) {
        return this.dataConverter.toFloat(getObjectOrNull(key, Float.valueOf(fallback)), fallback);
    }

    @Override // io.bidmachine.utils.data.DataRetriever
    public Float getFloatOrNull(K key, Float fallback) {
        return this.dataConverter.toFloatOrNull(getObjectOrNull(key, fallback), fallback);
    }

    @Override // io.bidmachine.utils.data.DataRetriever
    public double getDouble(K key, double fallback) {
        return this.dataConverter.toDouble(getObjectOrNull(key, Double.valueOf(fallback)), fallback);
    }

    @Override // io.bidmachine.utils.data.DataRetriever
    public Double getDoubleOrNull(K key, Double fallback) {
        return this.dataConverter.toDoubleOrNull(getObjectOrNull(key, fallback), fallback);
    }

    @Override // io.bidmachine.utils.data.DataRetriever
    public List<Object> getListOrNull(K key) {
        return this.dataConverter.toListOrNull(getObjectOrNull(key, null));
    }

    @Override // io.bidmachine.utils.data.DataRetriever
    public Map<Object, Object> getMapOrNull(K key) {
        return this.dataConverter.toMapOrNull(getObjectOrNull(key, null));
    }

    @Override // io.bidmachine.utils.data.DataRetriever
    public <T> T getOrNull(K k, T t) throws Exception {
        return (T) this.dataConverter.toOrNull(getObjectOrNull(k, t), t);
    }

    @Override // io.bidmachine.utils.data.DataRetriever
    public Object getObjectOrNull(K key, Object fallback) {
        return contains(key) ? getParams().get(key) : fallback;
    }
}
