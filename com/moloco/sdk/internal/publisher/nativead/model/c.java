package com.moloco.sdk.internal.publisher.nativead.model;

import android.net.Uri;
import com.moloco.sdk.internal.publisher.nativead.model.b;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public abstract class c {
    public static final int d = 0;

    /* renamed from: a, reason: collision with root package name */
    public final b.a f5552a;
    public final int b;
    public final boolean c;

    public static final class a extends c {
        public static final int f = 0;
        public final String e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(b.a.C0447a originAsset) {
            super(originAsset, null);
            Intrinsics.checkNotNullParameter(originAsset, "originAsset");
            this.e = originAsset.e();
        }

        public final String d() {
            return this.e;
        }
    }

    public static final class b extends c {
        public static final int f = 8;
        public final Uri e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(b.a.C0448b originAsset, Uri precachedAssetUri) {
            super(originAsset, null);
            Intrinsics.checkNotNullParameter(originAsset, "originAsset");
            Intrinsics.checkNotNullParameter(precachedAssetUri, "precachedAssetUri");
            this.e = precachedAssetUri;
        }

        public final Uri d() {
            return this.e;
        }
    }

    /* renamed from: com.moloco.sdk.internal.publisher.nativead.model.c$c, reason: collision with other inner class name */
    public static final class C0450c extends c {
        public static final int f = 0;
        public final String e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0450c(b.a.c originAsset) {
            super(originAsset, null);
            Intrinsics.checkNotNullParameter(originAsset, "originAsset");
            this.e = originAsset.d();
        }

        public final String d() {
            return this.e;
        }
    }

    public static final class d extends c {
        public static final int f = 8;
        public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(b.a.d originAsset, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a vastAd) {
            super(originAsset, null);
            Intrinsics.checkNotNullParameter(originAsset, "originAsset");
            Intrinsics.checkNotNullParameter(vastAd, "vastAd");
            this.e = vastAd;
        }

        public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a d() {
            return this.e;
        }
    }

    public /* synthetic */ c(b.a aVar, DefaultConstructorMarker defaultConstructorMarker) {
        this(aVar);
    }

    public final int a() {
        return this.b;
    }

    public final b.a b() {
        return this.f5552a;
    }

    public final boolean c() {
        return this.c;
    }

    public c(b.a aVar) {
        this.f5552a = aVar;
        this.b = aVar.a();
        this.c = aVar.b();
    }
}
