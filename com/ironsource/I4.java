package com.ironsource;

import com.ironsource.mediationsdk.utils.IronSourceAES;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class I4 implements InterfaceC3320te<String> {

    /* renamed from: a, reason: collision with root package name */
    private final String f2907a;
    private final String b;

    public I4(String encryptedResponse, String descriptionKey) {
        Intrinsics.checkNotNullParameter(encryptedResponse, "encryptedResponse");
        Intrinsics.checkNotNullParameter(descriptionKey, "descriptionKey");
        this.f2907a = encryptedResponse;
        this.b = descriptionKey;
    }

    @Override // com.ironsource.InterfaceC3320te
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public String a() {
        String value = IronSourceAES.decode(this.b, this.f2907a);
        if (value == null || value.length() == 0) {
            throw new IllegalArgumentException("Decryption failed");
        }
        Intrinsics.checkNotNullExpressionValue(value, "value");
        return value;
    }
}
