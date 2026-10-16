package com.instagram.common.viewpoint.core;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* renamed from: com.facebook.ads.redexgen.X.gj, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C1930gj implements T1 {
    public final Map<String, Set<String>> A00 = new HashMap();

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 4 out of bounds for length 4
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:147)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:636)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    @Override // com.instagram.common.viewpoint.core.T1
    public final synchronized boolean AAM(String str, String str2) {
        boolean z;
        Set<String> set = this.A00.get(str2);
        if (set != null) {
            z = set.contains(str);
        }
        return z;
    }

    @Override // com.instagram.common.viewpoint.core.T1
    public final synchronized void A4z(String str) {
        this.A00.remove(str);
    }

    @Override // com.instagram.common.viewpoint.core.T1
    public final synchronized void AJE(String str, String str2) {
        Set<String> set = this.A00.get(str2);
        if (set == null) {
            set = new HashSet<>();
            this.A00.put(str2, set);
        }
        set.add(str);
    }
}
