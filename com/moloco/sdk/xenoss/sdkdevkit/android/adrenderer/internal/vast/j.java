package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast;

import android.util.Xml;
import com.moloco.sdk.internal.v;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.w;
import java.io.Closeable;
import java.io.StringReader;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes6.dex */
public final class j implements i {

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserImpl", f = "VastParser.kt", i = {}, l = {65}, m = "invoke", n = {}, s = {})
    public static final class a extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        public Object f6080a;
        public /* synthetic */ Object b;
        public int d;

        public a(Continuation<? super a> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return j.this.a(null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0061 A[Catch: all -> 0x002d, TryCatch #3 {all -> 0x002d, blocks: (B:11:0x0029, B:12:0x005d, B:14:0x0061, B:19:0x0067), top: B:10:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0067 A[Catch: all -> 0x002d, TRY_LEAVE, TryCatch #3 {all -> 0x002d, blocks: (B:11:0x0029, B:12:0x005d, B:14:0x0061, B:19:0x0067), top: B:10:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object a(String str, Continuation<? super v<w, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k>> continuation) {
        a aVar;
        int i;
        Throwable th;
        Closeable closeable;
        Object S;
        if (continuation instanceof a) {
            aVar = (a) continuation;
            int i2 = aVar.d;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                aVar.d = i2 - Integer.MIN_VALUE;
                Object obj = aVar.b;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = aVar.d;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    try {
                        StringReader stringReader = new StringReader(str);
                        try {
                            XmlPullParser newPullParser = Xml.newPullParser();
                            newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", false);
                            newPullParser.setInput(stringReader);
                            Intrinsics.checkNotNull(newPullParser);
                            aVar.f6080a = stringReader;
                            aVar.d = 1;
                            S = k.S(newPullParser, aVar);
                            if (S == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            obj = S;
                            closeable = stringReader;
                        } catch (Throwable th2) {
                            th = th2;
                            closeable = stringReader;
                            throw th;
                        }
                    } catch (Exception unused) {
                        return new v.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k.b);
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    closeable = (Closeable) aVar.f6080a;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (Throwable th3) {
                        th = th3;
                        try {
                            throw th;
                        } catch (Throwable th4) {
                            CloseableKt.closeFinally(closeable, th);
                            throw th4;
                        }
                    }
                }
                w wVar = (w) obj;
                Object bVar = wVar == null ? new v.b(wVar) : new v.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k.c);
                CloseableKt.closeFinally(closeable, null);
                return bVar;
            }
        }
        aVar = new a(continuation);
        Object obj2 = aVar.b;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = aVar.d;
        if (i != 0) {
        }
        w wVar2 = (w) obj2;
        if (wVar2 == null) {
        }
        CloseableKt.closeFinally(closeable, null);
        return bVar;
    }
}
