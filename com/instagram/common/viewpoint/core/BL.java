package com.instagram.common.viewpoint.core;

import com.google.common.collect.ParametricNullness;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* loaded from: assets/audience_network/classes2.dex */
public class BL<K, V> extends AbstractC06441d<Map.Entry<K, V>, K> {
    public BL(Iterator backingIterator) {
        super(backingIterator);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.instagram.common.viewpoint.core.AbstractC06441d
    @ParametricNullness
    /* renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final K A01(Map.Entry<K, V> entry) {
        return entry.getKey();
    }
}
