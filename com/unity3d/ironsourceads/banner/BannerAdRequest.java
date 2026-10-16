package com.unity3d.ironsourceads.banner;

import android.content.Context;
import android.os.Bundle;
import com.ironsource.C3099gc;
import com.ironsource.InterfaceC3100gd;
import com.ironsource.L9;
import com.ironsource.mediationsdk.logger.IronLog;
import com.unity3d.ironsourceads.AdSize;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class BannerAdRequest {

    /* renamed from: a, reason: collision with root package name */
    private final Context f6427a;
    private final String b;
    private final String c;
    private final AdSize d;
    private final Bundle e;
    private final InterfaceC3100gd f;
    private final String g;

    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        private final Context f6428a;
        private final String b;
        private final String c;
        private final AdSize d;
        private Bundle e;

        public Builder(Context context, String instanceId, String adm, AdSize size) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(instanceId, "instanceId");
            Intrinsics.checkNotNullParameter(adm, "adm");
            Intrinsics.checkNotNullParameter(size, "size");
            this.f6428a = context;
            this.b = instanceId;
            this.c = adm;
            this.d = size;
        }

        public final BannerAdRequest build() {
            IronLog.API.info("instanceId: " + this.b + ", size: " + this.d.getSizeDescription());
            return new BannerAdRequest(this.f6428a, this.b, this.c, this.d, this.e, null);
        }

        public final String getAdm() {
            return this.c;
        }

        public final Context getContext() {
            return this.f6428a;
        }

        public final String getInstanceId() {
            return this.b;
        }

        public final AdSize getSize() {
            return this.d;
        }

        public final Builder withExtraParams(Bundle extraParams) {
            Intrinsics.checkNotNullParameter(extraParams, "extraParams");
            this.e = extraParams;
            return this;
        }
    }

    public /* synthetic */ BannerAdRequest(Context context, String str, String str2, AdSize adSize, Bundle bundle, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, str, str2, adSize, bundle);
    }

    public final String getAdId$mediationsdk_release() {
        return this.g;
    }

    public final String getAdm() {
        return this.c;
    }

    public final Context getContext() {
        return this.f6427a;
    }

    public final Bundle getExtraParams() {
        return this.e;
    }

    public final String getInstanceId() {
        return this.b;
    }

    public final InterfaceC3100gd getProviderName$mediationsdk_release() {
        return this.f;
    }

    public final AdSize getSize() {
        return this.d;
    }

    private BannerAdRequest(Context context, String str, String str2, AdSize adSize, Bundle bundle) {
        this.f6427a = context;
        this.b = str;
        this.c = str2;
        this.d = adSize;
        this.e = bundle;
        this.f = new C3099gc(str);
        String b = L9.b();
        Intrinsics.checkNotNullExpressionValue(b, "generateMultipleUniqueInstanceId()");
        this.g = b;
    }
}
