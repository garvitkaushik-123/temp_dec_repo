package com.bytedance.sdk.openadsdk.core.model;

import java.util.HashSet;
import java.util.Set;

/* loaded from: classes3.dex */
public class aGH {
    private com.bytedance.sdk.openadsdk.core.du.aGH eli = new com.bytedance.sdk.openadsdk.core.du.aGH();
    private Set<com.bytedance.sdk.openadsdk.core.du.aAs> DbA = new HashSet();

    public com.bytedance.sdk.openadsdk.core.du.aGH eli() {
        return this.eli;
    }

    public void eli(com.bytedance.sdk.openadsdk.core.du.aGH agh) {
        if (agh == null) {
            agh = new com.bytedance.sdk.openadsdk.core.du.aGH();
        }
        this.eli = agh;
    }

    public Set<com.bytedance.sdk.openadsdk.core.du.aAs> DbA() {
        return this.DbA;
    }

    public void eli(Set<com.bytedance.sdk.openadsdk.core.du.aAs> set) {
        this.DbA = set;
    }

    public void eli(ev evVar) {
        com.bytedance.sdk.openadsdk.core.du.aGH agh = this.eli;
        if (agh != null) {
            agh.eli(evVar);
        }
    }

    public void DbA(Set<com.bytedance.sdk.openadsdk.core.du.aAs> set) {
        if (set == null || set.isEmpty()) {
            return;
        }
        this.DbA.addAll(set);
    }
}
