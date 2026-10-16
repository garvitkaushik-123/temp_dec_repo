package com.ironsource;

import android.content.Context;
import com.ironsource.mediationsdk.logger.IronLog;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.ironsource.z4, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3412z4 implements N8, M8 {

    /* renamed from: a, reason: collision with root package name */
    private final InterfaceC3364w7 f3958a;

    /* JADX WARN: Multi-variable type inference failed */
    public C3412z4() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // com.ironsource.M8
    public void a(Context context, EnumC3395y4 source, String key, String value) {
        Unit unit;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        E4 a2 = this.f3958a.a(context, source);
        if (a2 != null) {
            a2.b(key, value);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            IronLog.INTERNAL.error("Shared storage does not exist for source: " + source);
        }
    }

    public C3412z4(InterfaceC3364w7 sharedSignalsStorageFactory) {
        Intrinsics.checkNotNullParameter(sharedSignalsStorageFactory, "sharedSignalsStorageFactory");
        this.f3958a = sharedSignalsStorageFactory;
    }

    @Override // com.ironsource.N8
    public String a(Context context, EnumC3395y4 source, String key) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(key, "key");
        E4 a2 = this.f3958a.a(context, source);
        if (a2 != null) {
            return E4.a(a2, key, null, 2, null);
        }
        IronLog.INTERNAL.error("Shared storage does not exist for source: " + source);
        return null;
    }

    public /* synthetic */ C3412z4(InterfaceC3364w7 interfaceC3364w7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new C4() : interfaceC3364w7);
    }
}
