package com.ironsource;

import androidx.lifecycle.ProcessLifecycleOwner;

/* loaded from: classes6.dex */
public final class T5 implements E7 {
    @Override // com.ironsource.E7
    public boolean a() {
        try {
            ProcessLifecycleOwner.INSTANCE.get();
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }
}
