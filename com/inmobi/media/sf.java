package com.inmobi.media;

import android.content.Context;
import android.webkit.MimeTypeMap;
import android.webkit.WebResourceResponse;
import com.inmobi.commons.core.configs.AdConfig;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import io.ktor.http.ContentDisposition;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class sf {

    /* renamed from: a, reason: collision with root package name */
    public static final sf f2706a = new sf();
    public static final ConcurrentHashMap b = new ConcurrentHashMap();
    public static final AdConfig.WebAssetCacheConfig c;
    public static final pf d;

    static {
        LinkedHashMap linkedHashMap = O2.f2380a;
        AdConfig.WebAssetCacheConfig webAssetCache = ((AdConfig) AbstractC2808p5.a(com.mbridge.msdk.foundation.entity.b.JSON_KEY_ADS, "null cannot be cast to non-null type com.inmobi.commons.core.configs.AdConfig", null)).getWebAssetCache();
        c = webAssetCache;
        Context d2 = Uc.d();
        d = d2 != null ? new pf(d2, webAssetCache) : null;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(20:25|(4:27|28|29|(1:31)(14:102|38|(1:(1:41))(2:88|(3:(1:91)|92|93)(2:(1:95)|96))|42|43|(3:68|69|(1:71)(6:72|(1:74)(1:80)|75|76|77|78))|45|46|(1:48)(1:63)|49|50|51|52|53))(1:108)|32|33|34|35|(1:37)(1:97)|38|(0)(0)|42|43|(5:64|65|68|69|(0)(0))|45|46|(0)(0)|49|50|51|52|53) */
    /* JADX WARN: Code restructure failed: missing block: B:100:0x01e1, code lost:
    
        r5 = r16;
        r6 = r20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x01dc, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x01de, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x01e6, code lost:
    
        r5 = r16;
        r6 = r20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x01e0, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01c6 A[Catch: TimeoutException -> 0x01be, Exception -> 0x01de, TryCatch #11 {TimeoutException -> 0x01be, Exception -> 0x01de, blocks: (B:46:0x01c2, B:48:0x01c6, B:63:0x01cf, B:77:0x01a7), top: B:43:0x016c }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0228  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01cf A[Catch: TimeoutException -> 0x01be, Exception -> 0x01de, TRY_LEAVE, TryCatch #11 {TimeoutException -> 0x01be, Exception -> 0x01de, blocks: (B:46:0x01c2, B:48:0x01c6, B:63:0x01cf, B:77:0x01a7), top: B:43:0x016c }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x017f A[Catch: Exception -> 0x01b6, TimeoutException -> 0x01bc, TRY_LEAVE, TryCatch #12 {TimeoutException -> 0x01bc, Exception -> 0x01b6, blocks: (B:69:0x017b, B:72:0x017f, B:75:0x019a), top: B:68:0x017b }] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0102 A[Catch: Exception -> 0x01e0, TimeoutException -> 0x01e6, TryCatch #9 {TimeoutException -> 0x01e6, Exception -> 0x01e0, blocks: (B:35:0x00c8, B:37:0x00d6, B:38:0x00e3, B:41:0x00f7, B:42:0x0146, B:64:0x0171, B:74:0x0192, B:88:0x0102, B:91:0x010a, B:92:0x0114, B:95:0x012d, B:96:0x0137, B:97:0x00dd), top: B:34:0x00c8 }] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v17, types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v21 */
    /* JADX WARN: Type inference failed for: r6v22 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v31 */
    /* JADX WARN: Type inference failed for: r6v34 */
    /* JADX WARN: Type inference failed for: r6v35 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v40 */
    /* JADX WARN: Type inference failed for: r6v41 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r6v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final WebResourceResponse a(final String url, final InterfaceC2971z5 interfaceC2971z5) {
        ?? r6;
        Object obj;
        long j;
        String str;
        String str2;
        InputStream a2;
        Object obj2;
        String str3;
        Pair pair;
        boolean booleanValue;
        byte[] bArr;
        Intrinsics.checkNotNullParameter(url, "url");
        pf pfVar = d;
        if (pfVar == null || pfVar.f2674a == null) {
            if (interfaceC2971z5 != null) {
                ((A5) interfaceC2971z5).b("WebResourceHandler", "WebAsset Cache Helper was not Initialized. " + pfVar + " for URL: " + url);
            }
            return null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("url", url);
        long currentTimeMillis = System.currentTimeMillis();
        try {
            String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(url);
            if (B2.a(fileExtensionFromUrl)) {
                j = currentTimeMillis;
                try {
                    str2 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl);
                } catch (TimeoutException unused) {
                    r6 = "ResourceCacheMiss";
                    obj = IronSourceConstants.EVENTS_ERROR_CODE;
                    linkedHashMap.put(obj, (short) 2193);
                    str = r6;
                    if (interfaceC2971z5 != null) {
                    }
                    linkedHashMap.put("latency", Long.valueOf(System.currentTimeMillis() - j));
                    Pd pd = Pd.f2401a;
                    Pd.b(str, linkedHashMap, Td.f2443a);
                    return null;
                } catch (Exception e) {
                    e = e;
                    r6 = "ResourceCacheMiss";
                    obj = IronSourceConstants.EVENTS_ERROR_CODE;
                    linkedHashMap.put(obj, (short) 2195);
                    str = r6;
                    if (interfaceC2971z5 != null) {
                    }
                    linkedHashMap.put("latency", Long.valueOf(System.currentTimeMillis() - j));
                    Pd pd2 = Pd.f2401a;
                    Pd.b(str, linkedHashMap, Td.f2443a);
                    return null;
                }
            } else {
                j = currentTimeMillis;
                str2 = null;
            }
            if (str2 == null || str2.length() == 0) {
                str2 = "text/html";
            }
            if (interfaceC2971z5 != null) {
                ((A5) interfaceC2971z5).a("WebResourceHandler", "mimeType is " + str2 + " for " + url);
            }
            a2 = pfVar.a(url, interfaceC2971z5);
        } catch (TimeoutException unused2) {
            r6 = "ResourceCacheMiss";
            obj = IronSourceConstants.EVENTS_ERROR_CODE;
            j = currentTimeMillis;
        } catch (Exception e2) {
            e = e2;
            r6 = "ResourceCacheMiss";
            obj = IronSourceConstants.EVENTS_ERROR_CODE;
            j = currentTimeMillis;
        }
        if (a2 != null) {
            if (interfaceC2971z5 != null) {
                ((A5) interfaceC2971z5).a("WebResourceHandler", "Found in cache: ".concat(url));
            }
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            linkedHashMap2.put("url", url);
            Pd pd3 = Pd.f2401a;
            Pd.b("ResourceCacheHit", linkedHashMap2, Td.f2443a);
            return B2.a(a2, str2);
        }
        ConcurrentHashMap concurrentHashMap = b;
        FutureTask futureTask = (FutureTask) concurrentHashMap.get(url);
        if (futureTask != null) {
            obj2 = IronSourceConstants.EVENTS_ERROR_CODE;
            try {
                pair = TuplesKt.to(Boolean.TRUE, futureTask);
            } catch (TimeoutException unused3) {
                r6 = "ResourceCacheMiss";
                obj = obj2;
                linkedHashMap.put(obj, (short) 2193);
                str = r6;
                if (interfaceC2971z5 != null) {
                    ((A5) interfaceC2971z5).b("WebResourceHandler", "Timeout exception occurred for url: ".concat(url));
                    str = r6;
                }
                linkedHashMap.put("latency", Long.valueOf(System.currentTimeMillis() - j));
                Pd pd22 = Pd.f2401a;
                Pd.b(str, linkedHashMap, Td.f2443a);
                return null;
            } catch (Exception e3) {
                e = e3;
                r6 = "ResourceCacheMiss";
                obj = obj2;
                linkedHashMap.put(obj, (short) 2195);
                str = r6;
                if (interfaceC2971z5 != null) {
                    ((A5) interfaceC2971z5).b("WebResourceHandler", rf.a(e, new StringBuilder("Unhandled exception occurred: ")));
                    str = r6;
                }
                linkedHashMap.put("latency", Long.valueOf(System.currentTimeMillis() - j));
                Pd pd222 = Pd.f2401a;
                Pd.b(str, linkedHashMap, Td.f2443a);
                return null;
            }
            if (pair != null) {
                str3 = "ResourceCacheMiss";
                booleanValue = ((Boolean) pair.component1()).booleanValue();
                FutureTask futureTask2 = (FutureTask) pair.component2();
                if (booleanValue) {
                    InputStream a3 = pfVar.a(url, interfaceC2971z5);
                    if (a3 != null) {
                        if (interfaceC2971z5 != null) {
                            ((A5) interfaceC2971z5).a("WebResourceHandler", "Found in cache in After FutureTask created: ".concat(url));
                        }
                        concurrentHashMap.remove(url);
                        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
                        linkedHashMap3.put("url", url);
                        Pd pd4 = Pd.f2401a;
                        Pd.b("ResourceCacheHit", linkedHashMap3, Td.f2443a);
                        return B2.a(a3, str2);
                    }
                    if (interfaceC2971z5 != null) {
                        ((A5) interfaceC2971z5).c("WebResourceHandler", "request for ".concat(url));
                    }
                    futureTask2.run();
                    concurrentHashMap.remove(url);
                    linkedHashMap.put("networkType", L3.q());
                } else if (interfaceC2971z5 != null) {
                    ((A5) interfaceC2971z5).c("WebResourceHandler", "waiting for existing request for ".concat(url));
                }
                AdConfig.WebAssetCacheConfig webAssetCacheConfig = c;
                C2962yc response = (C2962yc) futureTask2.get(webAssetCacheConfig.getTimeout() * Math.max(1, webAssetCacheConfig.getMaxRetries()), TimeUnit.MILLISECONDS);
                Intrinsics.checkNotNull(response);
                Intrinsics.checkNotNullParameter(response, "response");
                bArr = response.c;
                r6 = response.d;
                if (r6 != 0 && r6.intValue() == 200 && bArr != null) {
                    try {
                        if (bArr.length == 0) {
                            linkedHashMap.put("latency", Long.valueOf(System.currentTimeMillis() - j));
                            linkedHashMap.put(ContentDisposition.Parameters.Size, Long.valueOf(response.c != null ? r6.length / 1024 : 0L));
                            Pd pd5 = Pd.f2401a;
                            Pd.b(str3, linkedHashMap, Td.f2443a);
                            return B2.a(new ByteArrayInputStream(response.c), str2);
                        }
                    } catch (TimeoutException unused4) {
                        r6 = str3;
                        obj = obj2;
                        linkedHashMap.put(obj, (short) 2193);
                        str = r6;
                        if (interfaceC2971z5 != null) {
                        }
                        linkedHashMap.put("latency", Long.valueOf(System.currentTimeMillis() - j));
                        Pd pd2222 = Pd.f2401a;
                        Pd.b(str, linkedHashMap, Td.f2443a);
                        return null;
                    } catch (Exception e4) {
                        e = e4;
                        r6 = str3;
                        obj = obj2;
                        linkedHashMap.put(obj, (short) 2195);
                        str = r6;
                        if (interfaceC2971z5 != null) {
                        }
                        linkedHashMap.put("latency", Long.valueOf(System.currentTimeMillis() - j));
                        Pd pd22222 = Pd.f2401a;
                        Pd.b(str, linkedHashMap, Td.f2443a);
                        return null;
                    }
                }
                r6 = str3;
                I9 i9 = response.f2765a;
                obj = obj2;
                linkedHashMap.put(obj, i9 == null ? Integer.valueOf(i9.f2315a.f2658a) : (short) 2194);
                str = r6;
                linkedHashMap.put("latency", Long.valueOf(System.currentTimeMillis() - j));
                Pd pd222222 = Pd.f2401a;
                Pd.b(str, linkedHashMap, Td.f2443a);
                return null;
            }
        } else {
            obj2 = IronSourceConstants.EVENTS_ERROR_CODE;
        }
        str3 = "ResourceCacheMiss";
        FutureTask futureTask3 = new FutureTask(new Callable() { // from class: com.inmobi.media.sf$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return sf.a(sf.this, url, interfaceC2971z5);
            }
        });
        FutureTask futureTask4 = (FutureTask) concurrentHashMap.putIfAbsent(url, futureTask3);
        pair = futureTask4 == null ? TuplesKt.to(Boolean.FALSE, futureTask3) : TuplesKt.to(Boolean.TRUE, futureTask4);
        booleanValue = ((Boolean) pair.component1()).booleanValue();
        FutureTask futureTask22 = (FutureTask) pair.component2();
        if (booleanValue) {
        }
        AdConfig.WebAssetCacheConfig webAssetCacheConfig2 = c;
        C2962yc response2 = (C2962yc) futureTask22.get(webAssetCacheConfig2.getTimeout() * Math.max(1, webAssetCacheConfig2.getMaxRetries()), TimeUnit.MILLISECONDS);
        Intrinsics.checkNotNull(response2);
        Intrinsics.checkNotNullParameter(response2, "response");
        bArr = response2.c;
        r6 = response2.d;
        if (r6 != 0) {
            if (bArr.length == 0) {
            }
        }
        r6 = str3;
        I9 i92 = response2.f2765a;
        obj = obj2;
        linkedHashMap.put(obj, i92 == null ? Integer.valueOf(i92.f2315a.f2658a) : (short) 2194);
        str = r6;
        linkedHashMap.put("latency", Long.valueOf(System.currentTimeMillis() - j));
        Pd pd2222222 = Pd.f2401a;
        Pd.b(str, linkedHashMap, Td.f2443a);
        return null;
    }

    public static final C2962yc a(sf this_run, String url, InterfaceC2971z5 interfaceC2971z5) {
        S3 s3;
        C2962yc response;
        I9 i9;
        Intrinsics.checkNotNullParameter(this_run, "$this_run");
        Intrinsics.checkNotNullParameter(url, "$url");
        this_run.getClass();
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).c("WebResourceHandler", AbstractC2673h0.a("downloadResourceFile(): ", url));
        }
        EnumC2846rc method = EnumC2846rc.f2696a;
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(method, "method");
        C2831qc c2831qc = new C2831qc(url, method);
        AdConfig.WebAssetCacheConfig webAssetCacheConfig = c;
        c2831qc.h = Integer.valueOf(webAssetCacheConfig.getTimeout());
        c2831qc.i = Integer.valueOf(webAssetCacheConfig.getTimeout());
        C2879tc retryPolicy = new C2879tc(webAssetCacheConfig.getMaxRetries(), 500);
        Intrinsics.checkNotNullParameter(retryPolicy, "retryPolicy");
        c2831qc.g = retryPolicy;
        C2895uc request = new C2895uc(c2831qc);
        Intrinsics.checkNotNullParameter(request, "request");
        do {
            s3 = null;
            response = H9.a(request, (Function2) null);
            i9 = response.f2765a;
        } while ((i9 != null ? i9.f2315a : null) == EnumC2790o4.m);
        Intrinsics.checkNotNullParameter(response, "response");
        byte[] bArr = response.c;
        Integer num = response.d;
        if (num != null && num.intValue() == 200 && bArr != null && bArr.length != 0) {
            if (interfaceC2971z5 != null) {
                ((A5) interfaceC2971z5).c("WebResourceHandler", "onSuccessfulResponse: ".concat(url));
            }
            pf pfVar = d;
            if (pfVar != null) {
                String data = J9.a(response.c);
                Intrinsics.checkNotNullParameter(url, "url");
                Intrinsics.checkNotNullParameter(data, "data");
                if (pfVar.f2674a != null) {
                    try {
                        String valueOf = String.valueOf(url.hashCode());
                        S3 s32 = pfVar.f2674a;
                        if (s32 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("diskLruCache");
                        } else {
                            s3 = s32;
                        }
                        P3 a2 = s3.a(valueOf);
                        if (a2 != null) {
                            a2.a(url, 0);
                            a2.a(data, 1);
                            if (a2.c) {
                                S3.a(a2.d, a2, false);
                                a2.d.d(a2.f2393a.f2404a);
                                return response;
                            }
                            S3.a(a2.d, a2, true);
                            return response;
                        }
                        if (interfaceC2971z5 != null) {
                            ((A5) interfaceC2971z5).a("WebAssetLRUCacheHelper", "Failed to write to cache diskLruCache with: diskLruCache.editor is null for ".concat(url));
                            return response;
                        }
                    } catch (Exception e) {
                        if (interfaceC2971z5 != null) {
                            ((A5) interfaceC2971z5).a("WebAssetLRUCacheHelper", "Failed to write to cache diskLruCache with: " + e.getMessage() + " for " + url);
                        }
                    }
                } else if (interfaceC2971z5 != null) {
                    ((A5) interfaceC2971z5).a("WebAssetLRUCacheHelper", "Disk Cache Failed to Initialize. Failed writeToCache: ".concat(url));
                }
            }
        }
        return response;
    }
}
