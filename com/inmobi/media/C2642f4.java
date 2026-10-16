package com.inmobi.media;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* renamed from: com.inmobi.media.f4, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2642f4 extends Lambda implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C2677h4 f2566a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2642f4(C2677h4 c2677h4) {
        super(1);
        this.f2566a = c2677h4;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        JSONObject it = (JSONObject) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        this.f2566a.f.invoke(it);
        return Unit.INSTANCE;
    }
}
