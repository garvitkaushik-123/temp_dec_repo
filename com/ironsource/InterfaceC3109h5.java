package com.ironsource;

import com.ironsource.sdk.utils.IronSourceStorageUtils;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* renamed from: com.ironsource.h5, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public interface InterfaceC3109h5<T> extends InterfaceC3386xc {
    void b(C3382x8 c3382x8);

    String c();

    Y5 d();

    Function1<Result<? extends T>, Unit> i();

    default boolean j() {
        return k().exists();
    }

    C3382x8 k();

    InterfaceC3398y7 l();

    default void m() {
        l().a(this);
        if (k().exists()) {
            IronSourceStorageUtils.deleteFile(k());
        }
        try {
            l().a(k(), d().value(), 5, 5);
        } catch (Exception e) {
            C3260q4.d().a(e);
            Function1<Result<? extends T>, Unit> i = i();
            Result.Companion companion = Result.INSTANCE;
            i.invoke(Result.m10240boximpl(Result.m10241constructorimpl(ResultKt.createFailure(e))));
        }
    }
}
