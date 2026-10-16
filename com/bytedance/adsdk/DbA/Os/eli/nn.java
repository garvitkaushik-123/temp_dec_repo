package com.bytedance.adsdk.DbA.Os.eli;

import java.util.Arrays;
import java.util.List;

/* loaded from: classes3.dex */
abstract class nn<V, O> implements NU<V, O> {
    final List<com.bytedance.adsdk.DbA.kb.eli<V>> eli;

    nn(List<com.bytedance.adsdk.DbA.kb.eli<V>> list) {
        this.eli = list;
    }

    @Override // com.bytedance.adsdk.DbA.Os.eli.NU
    public List<com.bytedance.adsdk.DbA.kb.eli<V>> Os() {
        return this.eli;
    }

    @Override // com.bytedance.adsdk.DbA.Os.eli.NU
    public boolean DbA() {
        return this.eli.isEmpty() || (this.eli.size() == 1 && this.eli.get(0).ui());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.eli.isEmpty()) {
            sb.append("values=").append(Arrays.toString(this.eli.toArray()));
        }
        return sb.toString();
    }
}
