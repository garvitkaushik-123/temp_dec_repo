package com.ironsource;

import android.content.Context;
import com.ironsource.InterfaceC3246p7;
import com.ironsource.InterfaceC3293s4;
import com.ironsource.environment.ContextProvider;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class L3 implements InterfaceC3246p7, InterfaceC3246p7.a {

    /* renamed from: a, reason: collision with root package name */
    private final Hc f2935a;
    private final Ue b;

    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f2936a;

        static {
            int[] iArr = new int[P3.values().length];
            try {
                iArr[P3.Pacing.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[P3.ShowCount.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[P3.Delivery.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f2936a = iArr;
        }
    }

    public L3() {
        this(null, null, null, 7, null);
    }

    @Override // com.ironsource.InterfaceC3246p7
    public synchronized N3 a(String identifier) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        N3 a2 = this.f2935a.a(identifier);
        if (a2.d()) {
            return a2;
        }
        return this.b.a(identifier);
    }

    @Override // com.ironsource.InterfaceC3246p7.a
    public synchronized void b(String identifier) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        this.f2935a.b(identifier);
        this.b.b(identifier);
    }

    public L3(InterfaceC3293s4 currentTimeProvider, I7 pacingDataRepository, O8 showCountDataRepository) {
        Intrinsics.checkNotNullParameter(currentTimeProvider, "currentTimeProvider");
        Intrinsics.checkNotNullParameter(pacingDataRepository, "pacingDataRepository");
        Intrinsics.checkNotNullParameter(showCountDataRepository, "showCountDataRepository");
        this.f2935a = new Hc(currentTimeProvider, pacingDataRepository);
        this.b = new Ue(currentTimeProvider, showCountDataRepository);
    }

    @Override // com.ironsource.InterfaceC3246p7.a
    public synchronized Object a(String identifier, P3 cappingType, InterfaceC3212n7 cappingConfig) {
        Object a2;
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        Intrinsics.checkNotNullParameter(cappingType, "cappingType");
        Intrinsics.checkNotNullParameter(cappingConfig, "cappingConfig");
        int i = a.f2936a[cappingType.ordinal()];
        if (i == 1) {
            a2 = this.f2935a.a(identifier, cappingType, cappingConfig);
        } else if (i == 2) {
            a2 = this.b.a(identifier, cappingType, cappingConfig);
        } else {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            Result.Companion companion = Result.INSTANCE;
            a2 = Result.m10241constructorimpl(Unit.INSTANCE);
        }
        return a2;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ L3(InterfaceC3293s4 interfaceC3293s4, I7 i7, O8 o8, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(interfaceC3293s4, i7, o8);
        interfaceC3293s4 = (i & 1) != 0 ? new InterfaceC3293s4.a() : interfaceC3293s4;
        if ((i & 2) != 0) {
            Context applicationContext = ContextProvider.getInstance().getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "getInstance().applicationContext");
            i7 = new Ic(new Pe(applicationContext, "pacing_service", null, 4, null));
        }
        if ((i & 4) != 0) {
            Context applicationContext2 = ContextProvider.getInstance().getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext2, "getInstance().applicationContext");
            o8 = new Se(new Pe(applicationContext2, "capping_service", null, 4, null));
        }
    }
}
