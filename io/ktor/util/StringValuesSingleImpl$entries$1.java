package io.ktor.util;

import com.ironsource.C3040d4;
import com.ironsource.D5;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* compiled from: StringValues.kt */
@Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0010&\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00030\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0096\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0002H\u0016R\u0014\u0010\u0004\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0011"}, d2 = {"io/ktor/util/StringValuesSingleImpl$entries$1", "", "", "", C3040d4.h.W, "getKey", "()Ljava/lang/String;", "value", "getValue", "()Ljava/util/List;", "equals", "", "other", "", "hashCode", "", "toString", "ktor-utils"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class StringValuesSingleImpl$entries$1 implements Map.Entry<String, List<? extends String>>, KMappedMarker {
    private final String key;
    private final List<String> value;

    @Override // java.util.Map.Entry
    public /* bridge */ /* synthetic */ List<? extends String> setValue(List<? extends String> list) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* renamed from: setValue, reason: avoid collision after fix types in other method */
    public List<String> setValue2(List<String> list) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    StringValuesSingleImpl$entries$1(StringValuesSingleImpl stringValuesSingleImpl) {
        this.key = stringValuesSingleImpl.getName();
        this.value = stringValuesSingleImpl.getValues();
    }

    @Override // java.util.Map.Entry
    public String getKey() {
        return this.key;
    }

    @Override // java.util.Map.Entry
    public List<? extends String> getValue() {
        return this.value;
    }

    public String toString() {
        return getKey() + D5.T + getValue();
    }

    @Override // java.util.Map.Entry
    public boolean equals(Object other) {
        if (!(other instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) other;
        return Intrinsics.areEqual(entry.getKey(), getKey()) && Intrinsics.areEqual(entry.getValue(), getValue());
    }

    @Override // java.util.Map.Entry
    public int hashCode() {
        return getKey().hashCode() ^ getValue().hashCode();
    }
}
