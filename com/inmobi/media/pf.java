package com.inmobi.media;

import android.content.Context;
import coil.disk.DiskLruCache;
import com.inmobi.commons.core.configs.AdConfig;
import com.ironsource.C3040d4;
import io.ktor.http.ContentDisposition;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class pf {

    /* renamed from: a, reason: collision with root package name */
    public S3 f2674a;
    public final of b;

    public pf(final Context context, final AdConfig.WebAssetCacheConfig webAssetCacheConfig) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(webAssetCacheConfig, "webAssetCacheConfig");
        this.b = new of();
        Uc.a(new Runnable() { // from class: com.inmobi.media.pf$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                pf.a(AdConfig.WebAssetCacheConfig.this, this, context);
            }
        });
    }

    public final InputStream a(String url, InterfaceC2971z5 interfaceC2971z5) {
        Intrinsics.checkNotNullParameter(url, "url");
        S3 s3 = this.f2674a;
        if (s3 == null) {
            if (interfaceC2971z5 != null) {
                ((A5) interfaceC2971z5).a("WebAssetLRUCacheHelper", "Disk Cache Failed to Initialize. Failed readFromCache: ".concat(url));
            }
            return null;
        }
        if (s3 == null) {
            try {
                Intrinsics.throwUninitializedPropertyAccessException("diskLruCache");
                s3 = null;
            } catch (Exception e) {
                if (interfaceC2971z5 != null) {
                    ((A5) interfaceC2971z5).a("WebAssetLRUCacheHelper", "Failed to read from cache with: " + e.getMessage() + " for " + url);
                }
            }
        }
        R3 b = s3.b(String.valueOf(url.hashCode()));
        if (b != null && Intrinsics.areEqual(url, Ge.a(new InputStreamReader(b.f2413a[0], Ge.b)))) {
            return b.f2413a[1];
        }
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).a("WebAssetLRUCacheHelper", "did not find any valid cache entry for ".concat(url));
        }
        return null;
    }

    public static final void a(AdConfig.WebAssetCacheConfig webAssetCacheConfig, pf this$0, Context context) {
        Intrinsics.checkNotNullParameter(webAssetCacheConfig, "$webAssetCacheConfig");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(context, "$context");
        try {
            long e = L3.f2348a.e();
            if (e < webAssetCacheConfig.getMinAvailableDiskSpace()) {
                this$0.getClass();
                a(context, e);
                ConcurrentHashMap concurrentHashMap = C6.b;
                C6.a(B6.a(context, "web_asset_file_key"), "cache_enabled", false, false, 4, (Object) null);
                return;
            }
            this$0.a(context, webAssetCacheConfig, e);
            ConcurrentHashMap concurrentHashMap2 = C6.b;
            C6.a(B6.a(context, "web_asset_file_key"), "cache_enabled", true, false, 4, (Object) null);
        } catch (Exception e2) {
            S5 s5 = S5.f2425a;
            S5.d.a(AbstractC2920w5.a(e2, "event"));
        }
    }

    public final void a(Context context, AdConfig.WebAssetCacheConfig webAssetCacheConfig, long j) {
        File file = new File(context.getFilesDir(), "inmobiwebassetcache");
        Intrinsics.checkNotNullParameter(webAssetCacheConfig, "webAssetCacheConfig");
        long min = (j == -1 ? 0 : Math.min(webAssetCacheConfig.getCacheSize(), (int) ((j * webAssetCacheConfig.getCacheSizeToDiskSpaceMaxPercent()) / 100))) * 1024 * 1024;
        of ofVar = this.b;
        Pattern pattern = S3.p;
        if (min > 0) {
            File file2 = new File(file, DiskLruCache.JOURNAL_FILE_BACKUP);
            if (file2.exists()) {
                File file3 = new File(file, DiskLruCache.JOURNAL_FILE);
                if (file3.exists()) {
                    file2.delete();
                } else if (!file2.renameTo(file3)) {
                    throw new IOException();
                }
            }
            S3 s3 = new S3(file, min, ofVar);
            if (s3.b.exists()) {
                try {
                    s3.c();
                    s3.b();
                    s3.j = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(s3.b, true), Ge.f2299a));
                } catch (IOException e) {
                    System.out.println("DiskLruCache " + file + " is corrupt: " + e.getMessage() + ", removing");
                    s3.close();
                    Ge.a(s3.f2423a);
                }
                Intrinsics.checkNotNullExpressionValue(s3, "open(...)");
                this.f2674a = s3;
                return;
            }
            file.mkdirs();
            s3 = new S3(file, min, ofVar);
            s3.d();
            Intrinsics.checkNotNullExpressionValue(s3, "open(...)");
            this.f2674a = s3;
            return;
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    public static void a(Context context, long j) {
        Pair pair = TuplesKt.to(ContentDisposition.Parameters.Size, Long.valueOf(j));
        ConcurrentHashMap concurrentHashMap = C6.b;
        C6 a2 = B6.a(context, "web_asset_file_key");
        Intrinsics.checkNotNullParameter("cache_enabled", C3040d4.h.W);
        Map mutableMapOf = MapsKt.mutableMapOf(pair, TuplesKt.to("state", Boolean.valueOf(a2.f2249a.getBoolean("cache_enabled", false))));
        Pd pd = Pd.f2401a;
        Pd.b("LowAvailableSpaceForCache", mutableMapOf, Td.f2443a);
    }
}
