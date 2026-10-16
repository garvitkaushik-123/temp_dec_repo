package com.ironsource.sdk.controller;

import android.content.Context;
import android.content.Intent;
import com.ironsource.InterfaceC3086g;
import com.ironsource.InterfaceC3103h;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public interface k {

    public static final class a implements InterfaceC3086g {
        @Override // com.ironsource.InterfaceC3086g
        public Intent a() {
            return new Intent("android.intent.action.VIEW");
        }
    }

    public static final class b implements InterfaceC3103h {
        @Override // com.ironsource.InterfaceC3103h
        public Intent a(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return new Intent(context, (Class<?>) OpenUrlActivity.class);
        }
    }
}
