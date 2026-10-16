package com.fyber.inneractive.sdk.protobuf;

/* loaded from: classes4.dex */
public final class b4 extends IllegalArgumentException {
    public b4(int i, int i2) {
        super("Unpaired surrogate at index " + i + " of " + i2);
    }
}
