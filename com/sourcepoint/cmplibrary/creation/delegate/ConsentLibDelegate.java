package com.sourcepoint.cmplibrary.creation.delegate;

import com.sourcepoint.cmplibrary.SpConsentLib;
import com.sourcepoint.cmplibrary.creation.SpCmpBuilder;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ConsentLibDelegate.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001e\u0012\u0017\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007¢\u0006\u0002\u0010\bJ\b\u0010\r\u001a\u00020\u000eH\u0016R\u001f\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/sourcepoint/cmplibrary/creation/delegate/ConsentLibDelegate;", "Lkotlin/Lazy;", "Lcom/sourcepoint/cmplibrary/SpConsentLib;", "cmpDsl", "Lkotlin/Function1;", "Lcom/sourcepoint/cmplibrary/creation/SpCmpBuilder;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function1;)V", "libSp", "value", "getValue", "()Lcom/sourcepoint/cmplibrary/SpConsentLib;", "isInitialized", "", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ConsentLibDelegate implements Lazy<SpConsentLib> {
    private final Function1<SpCmpBuilder, Unit> cmpDsl;
    private SpConsentLib libSp;

    /* JADX WARN: Multi-variable type inference failed */
    public ConsentLibDelegate(Function1<? super SpCmpBuilder, Unit> cmpDsl) {
        Intrinsics.checkNotNullParameter(cmpDsl, "cmpDsl");
        this.cmpDsl = cmpDsl;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.Lazy
    public SpConsentLib getValue() {
        SpConsentLib spConsentLib = this.libSp;
        if (spConsentLib != null) {
            return spConsentLib;
        }
        SpCmpBuilder spCmpBuilder = new SpCmpBuilder();
        this.cmpDsl.invoke(spCmpBuilder);
        SpConsentLib build$cmplibrary_release = spCmpBuilder.build$cmplibrary_release();
        this.libSp = build$cmplibrary_release;
        Intrinsics.checkNotNull(build$cmplibrary_release);
        return build$cmplibrary_release;
    }

    @Override // kotlin.Lazy
    public boolean isInitialized() {
        return this.libSp != null;
    }
}
