package com.instagram.common.viewpoint.core;

import java.util.AbstractMap;
import java.util.Map;
import java.util.Objects;
import javax.annotation.CheckForNull;

/* renamed from: com.facebook.ads.redexgen.X.2C, reason: invalid class name */
/* loaded from: assets/audience_network/classes2.dex */
public class C2C<K, V> extends BO<Map.Entry<K, V>> {
    public final transient int A00;
    public final transient int A01;
    public final transient AbstractC2381oX<K, V> A02;
    public final transient Object[] A03;

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2C != com.google.common.collect.RegularImmutableMap$EntrySet<K, V> */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.oX != com.google.common.collect.ImmutableMap<K, V> */
    public C2C(AbstractC2381oX<K, V> map, Object[] alternatingKeysAndValues, int keyOffset, int size) {
        this.A02 = map;
        this.A03 = alternatingKeysAndValues;
        this.A00 = keyOffset;
        this.A01 = size;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2C != com.google.common.collect.RegularImmutableMap$EntrySet<K, V> */
    @Override // com.instagram.common.viewpoint.core.AbstractC2372oO
    public final int A0I(Object[] dst, int offset) {
        return A0J().A0I(dst, offset);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2C != com.google.common.collect.RegularImmutableMap$EntrySet<K, V> */
    @Override // com.instagram.common.viewpoint.core.AbstractC2372oO
    public final boolean A0K() {
        return true;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2C != com.google.common.collect.RegularImmutableMap$EntrySet<K, V> */
    @Override // com.instagram.common.viewpoint.core.BO
    public final BP<Map.Entry<K, V>> A0M() {
        return new BP<Map.Entry<K, V>>() { // from class: com.facebook.ads.redexgen.X.2D
            /* JADX INFO: Access modifiers changed from: private */
            @Override // java.util.List
            /* renamed from: A00, reason: merged with bridge method [inline-methods] */
            public final Map.Entry<K, V> get(int index) {
                int i;
                Object[] objArr;
                int i2;
                Object[] objArr2;
                int i3;
                i = C2C.this.A01;
                AbstractC2159ki.A00(index, i);
                objArr = C2C.this.A03;
                i2 = C2C.this.A00;
                Object requireNonNull = Objects.requireNonNull(objArr[(index * 2) + i2]);
                objArr2 = C2C.this.A03;
                i3 = C2C.this.A00;
                return new AbstractMap.SimpleImmutableEntry(requireNonNull, Objects.requireNonNull(objArr2[(index * 2) + (i3 ^ 1)]));
            }

            @Override // com.instagram.common.viewpoint.core.AbstractC2372oO
            public final boolean A0K() {
                return true;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public final int size() {
                int i;
                i = C2C.this.A01;
                return i;
            }
        };
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2C != com.google.common.collect.RegularImmutableMap$EntrySet<K, V> */
    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* renamed from: A0N */
    public final C4C<Map.Entry<K, V>> iterator() {
        return A0J().iterator();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2C != com.google.common.collect.RegularImmutableMap$EntrySet<K, V> */
    @Override // com.instagram.common.viewpoint.core.AbstractC2372oO, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(@CheckForNull Object object) {
        if (!(object instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) object;
        Object k = entry.getKey();
        Object value = entry.getValue();
        return value != null && value.equals(this.A02.get(k));
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2C != com.google.common.collect.RegularImmutableMap$EntrySet<K, V> */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.A01;
    }
}
