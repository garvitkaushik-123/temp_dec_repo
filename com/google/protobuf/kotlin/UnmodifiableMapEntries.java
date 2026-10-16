package com.google.protobuf.kotlin;

import androidx.exifinterface.media.ExifInterface;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* compiled from: UnmodifiableCollections.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010&\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010(\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00040\u00032\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00040\u0005B\u001f\u0012\u0018\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00040\u0005¢\u0006\u0002\u0010\u0007J\u001b\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00040\tH\u0096\u0002R \u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00040\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/google/protobuf/kotlin/UnmodifiableMapEntries;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lcom/google/protobuf/kotlin/UnmodifiableCollection;", "", "", "delegate", "(Ljava/util/Set;)V", "iterator", "", "java_kotlin-shared_runtime"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class UnmodifiableMapEntries<K, V> extends UnmodifiableCollection<Map.Entry<? extends K, ? extends V>> implements Set<Map.Entry<? extends K, ? extends V>>, KMappedMarker {
    private final Set<Map.Entry<K, V>> delegate;

    @Override // com.google.protobuf.kotlin.UnmodifiableCollection, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            return contains((Map.Entry<? extends Object, ? extends Object>) obj);
        }
        return false;
    }

    public /* bridge */ boolean contains(Map.Entry<? extends Object, ? extends Object> entry) {
        return super.contains((UnmodifiableMapEntries<K, V>) entry);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public UnmodifiableMapEntries(Set<? extends Map.Entry<? extends K, ? extends V>> delegate) {
        super(delegate);
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.delegate = delegate;
    }

    @Override // com.google.protobuf.kotlin.UnmodifiableCollection, java.util.Collection, java.lang.Iterable
    public Iterator<Map.Entry<K, V>> iterator() {
        return new UnmodifiableMapEntries$iterator$1(this.delegate.iterator());
    }
}
