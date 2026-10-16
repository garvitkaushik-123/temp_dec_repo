package com.applovin.impl;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.applovin.impl.d0;
import com.applovin.impl.e0;
import com.applovin.impl.s3;
import com.applovin.impl.sdk.ad.AppLovinAdImpl;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinErrorCodes;
import com.applovin.sdk.AppLovinSdkUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.vungle.ads.internal.model.AdPayload;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutorService;

/* loaded from: classes2.dex */
public abstract class j5 extends g5 implements s3.a {
    protected final com.applovin.impl.sdk.ad.b g;
    private AppLovinAdLoadListener h;
    protected final String i;
    private final com.applovin.impl.sdk.m j;
    private final Collection k;
    private boolean l;
    protected ExecutorService m;
    protected ExecutorService n;
    protected List o;
    private d0 p;

    class a implements e0.a {
        a() {
        }

        @Override // com.applovin.impl.e0.a
        public void a(Uri uri) {
            j5.this.g.b(uri);
            com.applovin.impl.sdk.o oVar = j5.this.c;
            if (com.applovin.impl.sdk.o.a()) {
                j5 j5Var = j5.this;
                j5Var.c.a(j5Var.b, "Ad updated with muteImageUri = " + uri);
            }
        }
    }

    class b implements e0.a {
        b() {
        }

        @Override // com.applovin.impl.e0.a
        public void a(Uri uri) {
            j5.this.g.c(uri);
            com.applovin.impl.sdk.o oVar = j5.this.c;
            if (com.applovin.impl.sdk.o.a()) {
                j5 j5Var = j5.this;
                j5Var.c.a(j5Var.b, "Ad updated with unmuteImageUri = " + uri);
            }
        }
    }

    class c implements e0.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ e0.a f505a;

        c(e0.a aVar) {
            this.f505a = aVar;
        }

        @Override // com.applovin.impl.e0.a
        public void a(Uri uri) {
            if (uri != null) {
                com.applovin.impl.sdk.o oVar = j5.this.c;
                if (com.applovin.impl.sdk.o.a()) {
                    j5 j5Var = j5.this;
                    j5Var.c.a(j5Var.b, "Finish caching video for ad #" + j5.this.g.getAdIdNumber() + ". Updating ad with cachedVideoURL = " + uri);
                }
                this.f505a.a(uri);
                return;
            }
            com.applovin.impl.sdk.o oVar2 = j5.this.c;
            if (com.applovin.impl.sdk.o.a()) {
                j5 j5Var2 = j5.this;
                j5Var2.c.b(j5Var2.b, "Failed to cache video");
            }
            j5.this.a(AppLovinErrorCodes.UNABLE_TO_PRECACHE_VIDEO_RESOURCES);
            Bundle bundle = new Bundle();
            bundle.putLong("ad_id", j5.this.g.getAdIdNumber());
            j5.this.f464a.u().a(bundle, "video_caching_failed");
        }
    }

    class d implements d0.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ e f506a;

        d(e eVar) {
            this.f506a = eVar;
        }

        @Override // com.applovin.impl.d0.c
        public void a(String str, boolean z) {
            if (z) {
                j5.this.a(AppLovinErrorCodes.UNABLE_TO_PRECACHE_HTML_RESOURCES);
                return;
            }
            e eVar = this.f506a;
            if (eVar != null) {
                eVar.a(str);
            }
        }
    }

    public interface e {
        void a(String str);
    }

    j5(String str, com.applovin.impl.sdk.ad.b bVar, com.applovin.impl.sdk.k kVar, AppLovinAdLoadListener appLovinAdLoadListener) {
        super(str, kVar);
        this.i = UUID.randomUUID().toString();
        if (bVar == null) {
            throw new IllegalArgumentException("No ad specified.");
        }
        this.g = bVar;
        this.h = appLovinAdLoadListener;
        this.j = kVar.H();
        this.k = h();
        if (((Boolean) kVar.a(v4.I0)).booleanValue()) {
            if (kVar.r0().f()) {
                this.m = kVar.r0().a();
                this.n = kVar.r0().e();
            } else {
                String mediationServeId = StringUtils.isValidString(bVar.getMediationServeId()) ? bVar.getMediationServeId() : UUID.randomUUID().toString();
                this.m = kVar.r0().a("com.applovin.sdk.caching." + mediationServeId, ((Integer) kVar.a(v4.K0)).intValue());
                this.n = kVar.r0().a("com.applovin.sdk.caching.html." + mediationServeId, ((Integer) kVar.a(v4.L0)).intValue());
            }
        }
    }

    private Collection h() {
        HashSet hashSet = new HashSet();
        for (char c2 : ((String) this.f464a.a(v4.D0)).toCharArray()) {
            hashSet.add(Character.valueOf(c2));
        }
        hashSet.add('\"');
        return hashSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i() {
        AppLovinAdLoadListener appLovinAdLoadListener = this.h;
        if (appLovinAdLoadListener != null) {
            appLovinAdLoadListener.adReceived(this.g);
            this.h = null;
        }
    }

    @Override // com.applovin.impl.s3.a
    public void a(v2 v2Var) {
        if (v2Var.P().equalsIgnoreCase(this.g.getMediationServeId())) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.b(this.b, "Updating flag for timeout...");
            }
            g();
        }
        this.f464a.Z().b(this);
    }

    protected e0 b(String str, e0.a aVar) {
        return a(str, this.g.c0(), true, aVar);
    }

    Uri c(String str) {
        return b(str, this.g.c0(), true);
    }

    protected List e() {
        if (com.applovin.impl.sdk.o.a()) {
            this.c.a(this.b, "Caching mute images...");
        }
        ArrayList arrayList = new ArrayList();
        if (this.g.Q() != null) {
            arrayList.add(a(this.g.Q().toString(), new a()));
        }
        if (this.g.i0() != null) {
            arrayList.add(a(this.g.i0().toString(), new b()));
        }
        return arrayList;
    }

    void f() {
        if (com.applovin.impl.sdk.o.a()) {
            this.c.a(this.b, "Rendered new ad:" + this.g);
        }
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.j5$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                j5.this.i();
            }
        });
    }

    protected void g() {
        this.l = true;
        List list = this.o;
        if (list != null && !list.isEmpty()) {
            Iterator it = this.o.iterator();
            while (it.hasNext()) {
                ((c0) it.next()).a(true);
            }
        }
        if (this.f464a.r0().f()) {
            d0 d0Var = this.p;
            if (d0Var != null) {
                d0Var.c();
                return;
            }
            return;
        }
        ExecutorService executorService = this.m;
        if (executorService != null) {
            executorService.shutdown();
            this.m = null;
        }
        ExecutorService executorService2 = this.n;
        if (executorService2 != null) {
            executorService2.shutdown();
            this.n = null;
        }
    }

    void j() {
        if (o0.e()) {
            return;
        }
        if (com.applovin.impl.sdk.o.a()) {
            this.c.a(this.b, "Caching mute images...");
        }
        Uri a2 = a(this.g.Q(), CampaignEx.JSON_NATIVE_VIDEO_MUTE);
        if (a2 != null) {
            this.g.b(a2);
        }
        Uri a3 = a(this.g.i0(), CampaignEx.JSON_NATIVE_VIDEO_UNMUTE);
        if (a3 != null) {
            this.g.c(a3);
        }
        if (com.applovin.impl.sdk.o.a()) {
            this.c.a(this.b, "Ad updated with muteImageFilename = " + this.g.Q() + ", unmuteImageFilename = " + this.g.i0());
        }
    }

    protected void k() {
        this.f464a.Z().b(this);
        if (!this.f464a.r0().f()) {
            ExecutorService executorService = this.m;
            if (executorService != null) {
                executorService.shutdown();
                this.m = null;
            }
            ExecutorService executorService2 = this.n;
            if (executorService2 != null) {
                executorService2.shutdown();
                this.n = null;
            }
        }
        MaxAdFormat d2 = this.g.getAdZone().d();
        if (((Boolean) this.f464a.a(v4.W0)).booleanValue() && d2 != null && d2.isFullscreenAd()) {
            this.f464a.h().b(this.g);
        }
        this.f464a.d0().a(this.i);
    }

    protected boolean l() {
        return this.l;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.g.o1()) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.a(this.b, "Subscribing to timeout events...");
            }
            this.f464a.Z().a(this);
        }
    }

    Uri b(String str, List list, boolean z) {
        if (!StringUtils.isValidString(str)) {
            return null;
        }
        if (com.applovin.impl.sdk.o.a()) {
            this.c.a(this.b, "Caching video " + str + "...");
        }
        int a2 = this.f464a.H().a(str, this.g);
        Map a3 = e2.a((AppLovinAdImpl) this.g);
        String a4 = this.j.a(a(), str, this.g.getCachePrefix(), list, z, a2, this.i, a3);
        if (!StringUtils.isValidString(a4)) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.b(this.b, "Failed to cache video: " + str);
            }
            a(str, "cacheVideo", a3);
            a(AppLovinErrorCodes.UNABLE_TO_PRECACHE_VIDEO_RESOURCES);
            return null;
        }
        File a5 = this.j.a(a4, a());
        if (a5 == null) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.b(this.b, "Unable to retrieve File from cached video filename = " + a4);
            }
            a(a4, "retrieveVideoFile", a3);
            return null;
        }
        Uri fromFile = Uri.fromFile(a5);
        if (fromFile != null) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.a(this.b, "Finish caching video for ad #" + this.g.getAdIdNumber() + ". Updating ad with cachedVideoFilename = " + a4);
            }
            return fromFile;
        }
        if (com.applovin.impl.sdk.o.a()) {
            this.c.b(this.b, "Unable to create URI from cached video file = " + a5);
        }
        a(a4, "extractUriFromVideoFile", a3);
        return null;
    }

    protected String c(String str, List list, boolean z) {
        try {
            InputStream a2 = this.j.a(str, list, z, e2.a((AppLovinAdImpl) this.g));
            if (a2 == null) {
                if (a2 != null) {
                    a2.close();
                }
                return null;
            }
            try {
                String a3 = this.j.a(a2);
                a2.close();
                return a3;
            } finally {
            }
        } catch (Throwable th) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.a(this.b, "Unknown failure to read input stream.", th);
            }
            this.c.a(this.b, th);
            this.f464a.E().a(this.b, "readInputStreamAsString", th);
            return null;
        }
    }

    protected List a(List list) {
        this.o = list;
        return this.f464a.r0().a(list, this.m);
    }

    protected e0 a(String str, e0.a aVar) {
        return new e0(str, this.g, this.i, this.f464a, aVar);
    }

    protected e0 a(String str, List list, boolean z, e0.a aVar) {
        if (TextUtils.isEmpty(str)) {
            if (!com.applovin.impl.sdk.o.a()) {
                return null;
            }
            this.c.a(this.b, "No video to cache, skipping...");
            return null;
        }
        if (com.applovin.impl.sdk.o.a()) {
            this.c.a(this.b, "Caching video " + str + "...");
        }
        return new e0(str, this.g, list, z, this.i, this.f464a, new c(aVar));
    }

    protected d0 a(String str, List list, e eVar) {
        d0 d0Var = new d0(str, this.g, list, this.n, this.i, this.f464a, new d(eVar));
        this.p = d0Var;
        return d0Var;
    }

    protected Uri a(Uri uri, String str) {
        if (uri == null) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.a(this.b, "No " + str + " image to cache");
            }
            return null;
        }
        String uri2 = uri.toString();
        if (TextUtils.isEmpty(uri2)) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.a(this.b, "Failed to cache " + str + " image");
            }
            return null;
        }
        if (com.applovin.impl.sdk.o.a()) {
            this.c.a(this.b, "Caching " + str + " image...");
        }
        return b(uri2);
    }

    Uri a(String str, List list, boolean z) {
        try {
            int a2 = this.f464a.H().a(str, this.g);
            Map a3 = e2.a((AppLovinAdImpl) this.g);
            String a4 = this.j.a(a(), str, this.g.getCachePrefix(), list, z, a2, this.i, a3);
            if (StringUtils.isValidString(a4)) {
                File a5 = this.j.a(a4, a());
                if (a5 != null) {
                    Uri fromFile = Uri.fromFile(a5);
                    if (fromFile != null) {
                        return fromFile;
                    }
                    if (com.applovin.impl.sdk.o.a()) {
                        this.c.b(this.b, "Unable to extract Uri from image file");
                    }
                    a(a4, "extractUriFromImageFile", a3);
                    return null;
                }
                if (com.applovin.impl.sdk.o.a()) {
                    this.c.b(this.b, "Unable to retrieve File from cached image filename = " + a4);
                }
                a(a4, "retrieveImageFile", a3);
                return null;
            }
            if (com.applovin.impl.sdk.o.a()) {
                this.c.b(this.b, "Failed to cache image: " + str);
            }
            a(str, "cacheImageResource", a3);
            return null;
        } catch (Throwable th) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.a(this.b, "Failed to cache image at url = " + str, th);
            }
            Map a6 = e2.a((AppLovinAdImpl) this.g);
            CollectionUtils.putStringIfValid("url", str, a6);
            this.f464a.E().a(this.b, "cacheImageResource", th, a6);
            return null;
        }
    }

    protected Uri b(String str) {
        return a(str, this.g.c0(), true);
    }

    void a(com.applovin.impl.sdk.ad.b bVar) {
        String k0 = bVar.k0();
        if (bVar.V0() && StringUtils.isValidString(k0)) {
            String a2 = a(k0, bVar.c0(), bVar);
            bVar.c(a2);
            this.c.f(this.b, "Ad updated with video button HTML assets cached = " + a2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x0039, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    String a(String str, List list, com.applovin.impl.sdk.ad.b bVar) {
        if (!TextUtils.isEmpty(str)) {
            if (!((Boolean) this.f464a.a(v4.E0)).booleanValue()) {
                if (com.applovin.impl.sdk.o.a()) {
                    this.c.a(this.b, "Resource caching is disabled, skipping cache...");
                    return str;
                }
            } else {
                StringBuilder sb = new StringBuilder(str);
                List a0 = bVar.a0();
                List R = bVar.R();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    String str2 = (String) it.next();
                    int i = 0;
                    int i2 = 0;
                    while (i < sb.length()) {
                        if (!l()) {
                            i = sb.indexOf(str2, i2);
                            if (i == -1) {
                                break;
                            }
                            int length = sb.length();
                            int i3 = i;
                            while (!this.k.contains(Character.valueOf(sb.charAt(i3))) && i3 < length) {
                                i3++;
                            }
                            if (i3 > i && i3 != length) {
                                String substring = sb.substring(str2.length() + i, i3);
                                String str3 = str2 + substring;
                                if (StringUtils.isValidString(substring) && !R.contains(str3)) {
                                    Uri a2 = a(str2, substring);
                                    if (a2 != null) {
                                        sb.replace(i, i3, a2.toString());
                                        bVar.a(a2);
                                    } else {
                                        if (a0.contains(str3)) {
                                            a(AppLovinErrorCodes.UNABLE_TO_PRECACHE_HTML_RESOURCES);
                                            this.l = true;
                                        }
                                        if (com.applovin.impl.sdk.o.a()) {
                                            this.c.b(this.b, "Failed to cache HTML Resource: " + str3);
                                        }
                                        a(str3, "cacheHtmlResource", e2.a((AppLovinAdImpl) bVar));
                                    }
                                } else if (com.applovin.impl.sdk.o.a()) {
                                    this.c.a(this.b, "Skip caching of optional or non-resource: " + substring);
                                }
                                i2 = i3;
                            } else if (com.applovin.impl.sdk.o.a()) {
                                this.c.b(this.b, "Unable to cache resource; ad HTML is invalid.");
                            }
                        }
                    }
                }
                return sb.toString();
            }
        }
        return str;
    }

    private Uri a(String str, String str2) {
        File a2 = this.j.a(k7.a(Uri.parse(str2), this.g.getCachePrefix(), this.f464a), com.applovin.impl.sdk.k.o());
        if (a2 == null) {
            return null;
        }
        if (!((Boolean) this.f464a.a(v4.E6)).booleanValue() && this.j.a(a2)) {
            return Uri.parse(AdPayload.FILE_SCHEME + a2.getAbsolutePath());
        }
        String str3 = str + str2;
        if (this.j.a(a2, str3, Arrays.asList(str), this.f464a.H().a(str3, this.g), this.i, e2.a((AppLovinAdImpl) this.g))) {
            return Uri.parse(AdPayload.FILE_SCHEME + a2.getAbsolutePath());
        }
        return null;
    }

    void a(int i) {
        if (this.h != null) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.a(this.b, "Calling back ad load failed with error code: " + i);
            }
            this.h.failedToReceiveAd(i);
            this.h = null;
        }
        g();
    }

    protected void a(String str, String str2, Map map) {
        HashMap hashMap = new HashMap(map);
        CollectionUtils.putStringIfValid("url", str, hashMap);
        this.f464a.E().a(c2.z0, str2, hashMap);
    }
}
