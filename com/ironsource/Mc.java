package com.ironsource;

import com.google.firebase.sessions.settings.RemoteSettings;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes6.dex */
public final class Mc {

    /* renamed from: a, reason: collision with root package name */
    private final String f2952a;

    public Mc(String baseControllerUrl) {
        Intrinsics.checkNotNullParameter(baseControllerUrl, "baseControllerUrl");
        this.f2952a = baseControllerUrl;
    }

    public final String a() {
        String str = this.f2952a;
        String substring = str.substring(0, StringsKt.lastIndexOf$default((CharSequence) str, RemoteSettings.FORWARD_SLASH_STRING, 0, false, 6, (Object) null));
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }
}
