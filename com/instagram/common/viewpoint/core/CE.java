package com.instagram.common.viewpoint.core;

import android.util.Log;

/* loaded from: assets/audience_network/classes2.dex */
public abstract class CE implements InterfaceC1979hW {
    public int A00;

    @Override // com.instagram.common.viewpoint.core.InterfaceC1979hW
    public final void A9t(String str, String str2) {
        Log.i(str, str2);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1979hW
    public final void A9u(String str, String str2, Throwable th) {
        Log.i(str, str2, th);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1979hW
    public final boolean AAY(int i) {
        return this.A00 <= i;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1979hW
    public final void AJY(int i) {
        this.A00 = i;
    }
}
