package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal;

import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.i;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.k, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3461k implements InterfaceC3460j {

    /* renamed from: a, reason: collision with root package name */
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.i f5849a;
    public final com.moloco.sdk.internal.error.b b;

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.DECLoaderImpl", f = "DECLoader.kt", i = {0, 0, 0, 0}, l = {31}, m = "load", n = {"this", "decToLoad", "mtid", "appIconUri"}, s = {"L$0", "L$1", "L$2", "L$3"})
    /* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.k$a */
    public static final class a extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        public Object f5850a;
        public Object b;
        public Object c;
        public Object d;
        public /* synthetic */ Object e;
        public int g;

        public a(Continuation<? super a> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.e = obj;
            this.g |= Integer.MIN_VALUE;
            return C3461k.this.a(null, null, this);
        }
    }

    public C3461k(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.i mediaCacheRepository, com.moloco.sdk.internal.error.b errorReportingService) {
        Intrinsics.checkNotNullParameter(mediaCacheRepository, "mediaCacheRepository");
        Intrinsics.checkNotNullParameter(errorReportingService, "errorReportingService");
        this.f5849a = mediaCacheRepository;
        this.b = errorReportingService;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00d4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00d5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002d  */
    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.InterfaceC3460j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object a(C3459i c3459i, String str, Continuation<? super C3459i> continuation) {
        a aVar;
        int i;
        C3459i c3459i2;
        String str2;
        C3461k c3461k;
        i.a aVar2;
        C3459i c3459i3;
        String str3 = str;
        if (continuation instanceof a) {
            aVar = (a) continuation;
            int i2 = aVar.g;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                aVar.g = i2 - Integer.MIN_VALUE;
                Object obj = aVar.e;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = aVar.g;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    String h = c3459i.h();
                    if (h == null) {
                        this.b.a(C3462l.b, str3 != null ? new com.moloco.sdk.internal.error.a(str3) : new com.moloco.sdk.internal.error.a("UNKNOWN_MTID"));
                        C3462l.b("can't precache DEC: appIconUri is null");
                        return c3459i;
                    }
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.i iVar = this.f5849a;
                    aVar.f5850a = this;
                    aVar.b = c3459i;
                    aVar.c = str3;
                    aVar.d = h;
                    aVar.g = 1;
                    Object a2 = iVar.a(h, aVar);
                    if (a2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    c3459i2 = c3459i;
                    str2 = h;
                    obj = a2;
                    c3461k = this;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    str2 = (String) aVar.d;
                    str3 = (String) aVar.c;
                    C3459i c3459i4 = (C3459i) aVar.b;
                    c3461k = (C3461k) aVar.f5850a;
                    ResultKt.throwOnFailure(obj);
                    c3459i2 = c3459i4;
                }
                aVar2 = (i.a) obj;
                if (aVar2 instanceof i.a.b) {
                    c3461k.b.a(C3462l.f5851a, str3 != null ? new com.moloco.sdk.internal.error.a(str3) : new com.moloco.sdk.internal.error.a("UNKNOWN_MTID"));
                    C3462l.b("dec loading error: " + aVar2 + ": `Not found` for " + str2);
                    c3459i3 = null;
                } else {
                    c3459i3 = C3459i.a(c3459i2, ((i.a.b) aVar2).a().getAbsolutePath(), null, null, null, null, null, null, 126, null);
                }
                return c3459i3 != null ? c3459i2 : c3459i3;
            }
        }
        aVar = new a(continuation);
        Object obj2 = aVar.e;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = aVar.g;
        if (i != 0) {
        }
        aVar2 = (i.a) obj2;
        if (aVar2 instanceof i.a.b) {
        }
        if (c3459i3 != null) {
        }
    }
}
