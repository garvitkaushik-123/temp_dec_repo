package com.sourcepoint.cmplibrary.util;

import androidx.core.app.NotificationCompat;
import com.ironsource.C3040d4;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/* compiled from: OkHttpCallbackExtension.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J>\u0010\u000f\u001a\u00020\u000b26\u0010\u0010\u001a2\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0004J\u0018\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\tH\u0016J>\u0010\u0012\u001a\u00020\u000b26\u0010\u0010\u001a2\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000b0\u0004J\u0018\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0016R@\u0010\u0003\u001a4\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R@\u0010\f\u001a4\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/sourcepoint/cmplibrary/util/OkHttpCallbackImpl;", "Lokhttp3/Callback;", "()V", "onFailure_", "Lkotlin/Function2;", "Lokhttp3/Call;", "Lkotlin/ParameterName;", "name", NotificationCompat.CATEGORY_CALL, "Ljava/io/IOException;", "exception", "", "onResponse_", "Lokhttp3/Response;", "r", "onFailure", C3040d4.a.f, "e", "onResponse", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class OkHttpCallbackImpl implements Callback {
    private Function2<? super Call, ? super IOException, Unit> onFailure_;
    private Function2<? super Call, ? super Response, Unit> onResponse_;

    public final void onFailure(Function2<? super Call, ? super IOException, Unit> init) {
        Intrinsics.checkNotNullParameter(init, "init");
        this.onFailure_ = init;
    }

    public final void onResponse(Function2<? super Call, ? super Response, Unit> init) {
        Intrinsics.checkNotNullParameter(init, "init");
        this.onResponse_ = init;
    }

    @Override // okhttp3.Callback
    public void onFailure(Call call, IOException e) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(e, "e");
        Function2<? super Call, ? super IOException, Unit> function2 = this.onFailure_;
        if (function2 != null) {
            function2.invoke(call, e);
        }
    }

    @Override // okhttp3.Callback
    public void onResponse(Call call, Response r) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(r, "r");
        Function2<? super Call, ? super Response, Unit> function2 = this.onResponse_;
        if (function2 != null) {
            function2.invoke(call, r);
        }
    }
}
