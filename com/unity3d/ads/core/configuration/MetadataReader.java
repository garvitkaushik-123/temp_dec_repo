package com.unity3d.ads.core.configuration;

import com.ironsource.C3040d4;
import com.unity3d.services.core.misc.JsonStorage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MetadataReader.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J$\u0010\f\u001a\u0004\u0018\u0001H\u0001\"\u0006\b\u0001\u0010\u0001\u0018\u00012\n\b\u0002\u0010\r\u001a\u0004\u0018\u0001H\u0001H\u0086\b¢\u0006\u0002\u0010\u000eJ$\u0010\u000f\u001a\u0004\u0018\u0001H\u0001\"\u0006\b\u0001\u0010\u0001\u0018\u00012\n\b\u0002\u0010\r\u001a\u0004\u0018\u0001H\u0001H\u0086\b¢\u0006\u0002\u0010\u000eR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/unity3d/ads/core/configuration/MetadataReader;", "T", "", "jsonStorage", "Lcom/unity3d/services/core/misc/JsonStorage;", C3040d4.h.W, "", "(Lcom/unity3d/services/core/misc/JsonStorage;Ljava/lang/String;)V", "getJsonStorage", "()Lcom/unity3d/services/core/misc/JsonStorage;", "getKey", "()Ljava/lang/String;", "read", "defaultValue", "(Ljava/lang/Object;)Ljava/lang/Object;", "readAndDelete", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes7.dex */
public abstract class MetadataReader<T> {
    private final JsonStorage jsonStorage;
    private final String key;

    public MetadataReader(JsonStorage jsonStorage, String key) {
        Intrinsics.checkNotNullParameter(jsonStorage, "jsonStorage");
        Intrinsics.checkNotNullParameter(key, "key");
        this.jsonStorage = jsonStorage;
        this.key = key;
    }

    public final JsonStorage getJsonStorage() {
        return this.jsonStorage;
    }

    public final String getKey() {
        return this.key;
    }

    public static /* synthetic */ Object read$default(MetadataReader metadataReader, Object obj, int i, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: read");
        }
        if ((i & 1) != 0) {
            obj = null;
        }
        Object obj3 = metadataReader.getJsonStorage().get(metadataReader.getKey());
        if (obj3 != null) {
            Intrinsics.reifiedOperationMarker(3, "T");
            if (!(obj3 instanceof Object)) {
                obj3 = obj;
            }
            if (obj3 != null) {
                return obj3;
            }
        }
        return obj;
    }

    public final /* synthetic */ <T> T read(T defaultValue) {
        T t = (T) getJsonStorage().get(getKey());
        if (t != null) {
            Intrinsics.reifiedOperationMarker(3, "T");
            if (!(t instanceof Object)) {
                t = defaultValue;
            }
            if (t != null) {
                return t;
            }
        }
        return defaultValue;
    }

    public static /* synthetic */ Object readAndDelete$default(MetadataReader metadataReader, Object obj, int i, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: readAndDelete");
        }
        if ((i & 1) != 0) {
            obj = null;
        }
        Object obj3 = metadataReader.getJsonStorage().get(metadataReader.getKey());
        if (obj3 != null) {
            Intrinsics.checkNotNullExpressionValue(obj3, "get(key)");
            Intrinsics.reifiedOperationMarker(3, "T");
            if (!(obj3 instanceof Object)) {
                obj3 = obj;
            }
            if (obj3 != null) {
                obj = obj3;
            }
        }
        Object obj4 = metadataReader.getJsonStorage().get(metadataReader.getKey());
        if (obj4 != null) {
            Intrinsics.checkNotNullExpressionValue(obj4, "get(key)");
            metadataReader.getJsonStorage().delete(metadataReader.getKey());
        }
        return obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final /* synthetic */ <T> T readAndDelete(T defaultValue) {
        Object obj = getJsonStorage().get(getKey());
        if (obj != 0) {
            Intrinsics.checkNotNullExpressionValue(obj, "get(key)");
            Intrinsics.reifiedOperationMarker(3, "T");
            boolean z = obj instanceof Object;
            T t = obj;
            if (!z) {
                t = defaultValue;
            }
            if (t != null) {
                defaultValue = t;
            }
        }
        Object obj2 = getJsonStorage().get(getKey());
        if (obj2 != null) {
            Intrinsics.checkNotNullExpressionValue(obj2, "get(key)");
            getJsonStorage().delete(getKey());
        }
        return defaultValue;
    }
}
