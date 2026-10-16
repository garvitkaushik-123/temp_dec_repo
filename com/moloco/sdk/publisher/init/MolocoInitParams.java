package com.moloco.sdk.publisher.init;

import android.content.Context;
import com.moloco.sdk.publisher.MediationInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÇ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\u0017\u001a\u00020\u0018H×\u0001J\t\u0010\u0019\u001a\u00020\u0005H×\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/moloco/sdk/publisher/init/MolocoInitParams;", "", "appContext", "Landroid/content/Context;", "appKey", "", "mediationInfo", "Lcom/moloco/sdk/publisher/MediationInfo;", "<init>", "(Landroid/content/Context;Ljava/lang/String;Lcom/moloco/sdk/publisher/MediationInfo;)V", "getAppContext", "()Landroid/content/Context;", "getAppKey", "()Ljava/lang/String;", "getMediationInfo", "()Lcom/moloco/sdk/publisher/MediationInfo;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "moloco-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes6.dex */
public final /* data */ class MolocoInitParams {
    public static final int $stable = 8;
    private final Context appContext;
    private final String appKey;
    private final MediationInfo mediationInfo;

    public MolocoInitParams(Context appContext, String appKey, MediationInfo mediationInfo) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(appKey, "appKey");
        Intrinsics.checkNotNullParameter(mediationInfo, "mediationInfo");
        this.appContext = appContext;
        this.appKey = appKey;
        this.mediationInfo = mediationInfo;
    }

    public static /* synthetic */ MolocoInitParams copy$default(MolocoInitParams molocoInitParams, Context context, String str, MediationInfo mediationInfo, int i, Object obj) {
        if ((i & 1) != 0) {
            context = molocoInitParams.appContext;
        }
        if ((i & 2) != 0) {
            str = molocoInitParams.appKey;
        }
        if ((i & 4) != 0) {
            mediationInfo = molocoInitParams.mediationInfo;
        }
        return molocoInitParams.copy(context, str, mediationInfo);
    }

    /* renamed from: component1, reason: from getter */
    public final Context getAppContext() {
        return this.appContext;
    }

    /* renamed from: component2, reason: from getter */
    public final String getAppKey() {
        return this.appKey;
    }

    /* renamed from: component3, reason: from getter */
    public final MediationInfo getMediationInfo() {
        return this.mediationInfo;
    }

    public final MolocoInitParams copy(Context appContext, String appKey, MediationInfo mediationInfo) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(appKey, "appKey");
        Intrinsics.checkNotNullParameter(mediationInfo, "mediationInfo");
        return new MolocoInitParams(appContext, appKey, mediationInfo);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MolocoInitParams)) {
            return false;
        }
        MolocoInitParams molocoInitParams = (MolocoInitParams) other;
        return Intrinsics.areEqual(this.appContext, molocoInitParams.appContext) && Intrinsics.areEqual(this.appKey, molocoInitParams.appKey) && Intrinsics.areEqual(this.mediationInfo, molocoInitParams.mediationInfo);
    }

    public final Context getAppContext() {
        return this.appContext;
    }

    public final String getAppKey() {
        return this.appKey;
    }

    public final MediationInfo getMediationInfo() {
        return this.mediationInfo;
    }

    public int hashCode() {
        return (((this.appContext.hashCode() * 31) + this.appKey.hashCode()) * 31) + this.mediationInfo.hashCode();
    }

    public String toString() {
        return "MolocoInitParams(appContext=" + this.appContext + ", appKey=" + this.appKey + ", mediationInfo=" + this.mediationInfo + ')';
    }
}
