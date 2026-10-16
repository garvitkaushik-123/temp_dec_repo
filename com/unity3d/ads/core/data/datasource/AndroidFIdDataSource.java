package com.unity3d.ads.core.data.datasource;

import android.content.Context;
import com.google.android.gms.tasks.Task;
import com.unity3d.services.core.fid.FIdBridge;
import com.unity3d.services.core.fid.FIdStaticBridge;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__BuildersKt;

/* compiled from: AndroidFIdDataSource.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0096\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/unity3d/ads/core/data/datasource/AndroidFIdDataSource;", "Lcom/unity3d/ads/core/data/datasource/FIdDataSource;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "bridge", "Lcom/unity3d/services/core/fid/FIdStaticBridge;", "invoke", "", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class AndroidFIdDataSource implements FIdDataSource {
    private FIdStaticBridge bridge;
    private final Context context;

    public AndroidFIdDataSource(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.bridge = new FIdStaticBridge();
    }

    @Override // com.unity3d.ads.core.data.datasource.FIdDataSource
    public String invoke() {
        Task<String> appInstanceId;
        Object runBlocking$default;
        try {
            Result.Companion companion = Result.INSTANCE;
            AndroidFIdDataSource androidFIdDataSource = this;
            FIdBridge fIdStaticBridge = this.bridge.getInstance(this.context);
            if (fIdStaticBridge != null && (appInstanceId = fIdStaticBridge.getAppInstanceId()) != null) {
                runBlocking$default = BuildersKt__BuildersKt.runBlocking$default(null, new AndroidFIdDataSource$invoke$1$1(appInstanceId, null), 1, null);
                return (String) runBlocking$default;
            }
            return null;
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Object m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
            return (String) (Result.m10247isFailureimpl(m10241constructorimpl) ? null : m10241constructorimpl);
        }
    }
}
