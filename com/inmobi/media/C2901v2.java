package com.inmobi.media;

import com.inmobi.commons.core.configs.RootConfig;
import java.util.LinkedHashMap;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* renamed from: com.inmobi.media.v2, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2901v2 extends Lambda implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    public static final C2901v2 f2728a = new C2901v2();

    public C2901v2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        LinkedHashMap linkedHashMap = O2.f2380a;
        return Boolean.valueOf(!((RootConfig) AbstractC2808p5.a("root", "null cannot be cast to non-null type com.inmobi.commons.core.configs.RootConfig", null)).getMonetizationDisabled());
    }
}
