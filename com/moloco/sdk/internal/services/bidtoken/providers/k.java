package com.moloco.sdk.internal.services.bidtoken.providers;

import com.moloco.sdk.internal.services.AbstractC3439c;
import com.moloco.sdk.publisher.privacy.MolocoPrivacy;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class k {
    public static final int l = 8;

    /* renamed from: a, reason: collision with root package name */
    public final boolean f5648a;
    public final MolocoPrivacy.PrivacySettings b;
    public final r c;
    public final d d;
    public final t e;
    public final h f;
    public final AbstractC3439c g;
    public final n h;
    public final f i;
    public final a j;
    public final p k;

    public k(boolean z, MolocoPrivacy.PrivacySettings privacySettings, r memoryInfo, d appDirInfo, t networkInfoSignal, h batteryInfoSignal, AbstractC3439c adDataSignal, n deviceSignal, f audioSignal, a accessibilitySignal, p ilrdSignal) {
        Intrinsics.checkNotNullParameter(privacySettings, "privacySettings");
        Intrinsics.checkNotNullParameter(memoryInfo, "memoryInfo");
        Intrinsics.checkNotNullParameter(appDirInfo, "appDirInfo");
        Intrinsics.checkNotNullParameter(networkInfoSignal, "networkInfoSignal");
        Intrinsics.checkNotNullParameter(batteryInfoSignal, "batteryInfoSignal");
        Intrinsics.checkNotNullParameter(adDataSignal, "adDataSignal");
        Intrinsics.checkNotNullParameter(deviceSignal, "deviceSignal");
        Intrinsics.checkNotNullParameter(audioSignal, "audioSignal");
        Intrinsics.checkNotNullParameter(accessibilitySignal, "accessibilitySignal");
        Intrinsics.checkNotNullParameter(ilrdSignal, "ilrdSignal");
        this.f5648a = z;
        this.b = privacySettings;
        this.c = memoryInfo;
        this.d = appDirInfo;
        this.e = networkInfoSignal;
        this.f = batteryInfoSignal;
        this.g = adDataSignal;
        this.h = deviceSignal;
        this.i = audioSignal;
        this.j = accessibilitySignal;
        this.k = ilrdSignal;
    }

    public final boolean a() {
        return this.f5648a;
    }

    public final a b() {
        return this.j;
    }

    public final p c() {
        return this.k;
    }

    public final MolocoPrivacy.PrivacySettings d() {
        return this.b;
    }

    public final r e() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return this.f5648a == kVar.f5648a && Intrinsics.areEqual(this.b, kVar.b) && Intrinsics.areEqual(this.c, kVar.c) && Intrinsics.areEqual(this.d, kVar.d) && Intrinsics.areEqual(this.e, kVar.e) && Intrinsics.areEqual(this.f, kVar.f) && Intrinsics.areEqual(this.g, kVar.g) && Intrinsics.areEqual(this.h, kVar.h) && Intrinsics.areEqual(this.i, kVar.i) && Intrinsics.areEqual(this.j, kVar.j) && Intrinsics.areEqual(this.k, kVar.k);
    }

    public final d f() {
        return this.d;
    }

    public final t g() {
        return this.e;
    }

    public final h h() {
        return this.f;
    }

    public int hashCode() {
        return (((((((((((((((((((Boolean.hashCode(this.f5648a) * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + this.h.hashCode()) * 31) + this.i.hashCode()) * 31) + this.j.hashCode()) * 31) + this.k.hashCode();
    }

    public final AbstractC3439c i() {
        return this.g;
    }

    public final n j() {
        return this.h;
    }

    public final f k() {
        return this.i;
    }

    public final a l() {
        return this.j;
    }

    public final AbstractC3439c m() {
        return this.g;
    }

    public final d n() {
        return this.d;
    }

    public final f o() {
        return this.i;
    }

    public final h p() {
        return this.f;
    }

    public final n q() {
        return this.h;
    }

    public final p r() {
        return this.k;
    }

    public final r s() {
        return this.c;
    }

    public final t t() {
        return this.e;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ClientSignals(sdkInitialized=");
        sb.append(this.f5648a).append(", privacySettings=").append(this.b).append(", memoryInfo=").append(this.c).append(", appDirInfo=").append(this.d).append(", networkInfoSignal=").append(this.e).append(", batteryInfoSignal=").append(this.f).append(", adDataSignal=").append(this.g).append(", deviceSignal=").append(this.h).append(", audioSignal=").append(this.i).append(", accessibilitySignal=").append(this.j).append(", ilrdSignal=").append(this.k).append(')');
        return sb.toString();
    }

    public final MolocoPrivacy.PrivacySettings u() {
        return this.b;
    }

    public final boolean v() {
        return this.f5648a;
    }

    public final k a(boolean z, MolocoPrivacy.PrivacySettings privacySettings, r memoryInfo, d appDirInfo, t networkInfoSignal, h batteryInfoSignal, AbstractC3439c adDataSignal, n deviceSignal, f audioSignal, a accessibilitySignal, p ilrdSignal) {
        Intrinsics.checkNotNullParameter(privacySettings, "privacySettings");
        Intrinsics.checkNotNullParameter(memoryInfo, "memoryInfo");
        Intrinsics.checkNotNullParameter(appDirInfo, "appDirInfo");
        Intrinsics.checkNotNullParameter(networkInfoSignal, "networkInfoSignal");
        Intrinsics.checkNotNullParameter(batteryInfoSignal, "batteryInfoSignal");
        Intrinsics.checkNotNullParameter(adDataSignal, "adDataSignal");
        Intrinsics.checkNotNullParameter(deviceSignal, "deviceSignal");
        Intrinsics.checkNotNullParameter(audioSignal, "audioSignal");
        Intrinsics.checkNotNullParameter(accessibilitySignal, "accessibilitySignal");
        Intrinsics.checkNotNullParameter(ilrdSignal, "ilrdSignal");
        return new k(z, privacySettings, memoryInfo, appDirInfo, networkInfoSignal, batteryInfoSignal, adDataSignal, deviceSignal, audioSignal, accessibilitySignal, ilrdSignal);
    }

    public static /* synthetic */ k a(k kVar, boolean z, MolocoPrivacy.PrivacySettings privacySettings, r rVar, d dVar, t tVar, h hVar, AbstractC3439c abstractC3439c, n nVar, f fVar, a aVar, p pVar, int i, Object obj) {
        if ((i & 1) != 0) {
            z = kVar.f5648a;
        }
        if ((i & 2) != 0) {
            privacySettings = kVar.b;
        }
        if ((i & 4) != 0) {
            rVar = kVar.c;
        }
        if ((i & 8) != 0) {
            dVar = kVar.d;
        }
        if ((i & 16) != 0) {
            tVar = kVar.e;
        }
        if ((i & 32) != 0) {
            hVar = kVar.f;
        }
        if ((i & 64) != 0) {
            abstractC3439c = kVar.g;
        }
        if ((i & 128) != 0) {
            nVar = kVar.h;
        }
        if ((i & 256) != 0) {
            fVar = kVar.i;
        }
        if ((i & 512) != 0) {
            aVar = kVar.j;
        }
        if ((i & 1024) != 0) {
            pVar = kVar.k;
        }
        a aVar2 = aVar;
        p pVar2 = pVar;
        n nVar2 = nVar;
        f fVar2 = fVar;
        h hVar2 = hVar;
        AbstractC3439c abstractC3439c2 = abstractC3439c;
        t tVar2 = tVar;
        r rVar2 = rVar;
        return kVar.a(z, privacySettings, rVar2, dVar, tVar2, hVar2, abstractC3439c2, nVar2, fVar2, aVar2, pVar2);
    }
}
