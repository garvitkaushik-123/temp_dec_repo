package io.bidmachine.rendering.internal;

import io.bidmachine.rendering.model.MethodParams;

/* loaded from: classes8.dex */
public class p extends y {
    private final MethodParams c;

    public p(MethodParams methodParams, io.bidmachine.rendering.internal.event.b eventCallback) {
        super(eventCallback);
        this.c = methodParams;
    }

    @Override // io.bidmachine.rendering.internal.y
    public String p() {
        return this.c.getName();
    }

    public MethodParams q() {
        return this.c;
    }
}
