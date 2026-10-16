package com.fyber.inneractive.sdk.mraid;

/* loaded from: classes4.dex */
public abstract class y {
    public abstract String a();

    public final String toString() {
        String a2 = a();
        return a2 != null ? a2.replaceAll("[^a-zA-Z0-9_,:\\s\\{\\}\\'\\\"]", "") : "";
    }
}
