package com.sourcepoint.cmplibrary.creation.delegate;

import com.sourcepoint.cmplibrary.SpConsentLib;
import com.sourcepoint.cmplibrary.creation.SpCmpBuilder;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ConsentLibDelegate.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a%\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0017\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007¨\u0006\b"}, d2 = {"spConsentLibLazy", "Lkotlin/Lazy;", "Lcom/sourcepoint/cmplibrary/SpConsentLib;", "dsl", "Lkotlin/Function1;", "Lcom/sourcepoint/cmplibrary/creation/SpCmpBuilder;", "", "Lkotlin/ExtensionFunctionType;", "cmplibrary_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ConsentLibDelegateKt {
    public static final Lazy<SpConsentLib> spConsentLibLazy(Function1<? super SpCmpBuilder, Unit> dsl) {
        Intrinsics.checkNotNullParameter(dsl, "dsl");
        return new ConsentLibDelegate(dsl);
    }
}
