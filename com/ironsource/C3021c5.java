package com.ironsource;

import com.ironsource.mediationsdk.logger.IronSourceError;

/* renamed from: com.ironsource.c5, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3021c5 {

    /* renamed from: a, reason: collision with root package name */
    public static final C3021c5 f3211a = new C3021c5();

    private C3021c5() {
    }

    public final boolean a(IronSourceError ironSourceError) {
        if (ironSourceError == null) {
            return false;
        }
        int errorCode = ironSourceError.getErrorCode();
        return errorCode == 524 || errorCode == 530;
    }
}
