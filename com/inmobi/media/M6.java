package com.inmobi.media;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.SparseArray;
import android.webkit.URLUtil;
import androidx.browser.customtabs.CustomTabsIntent;
import com.bytedance.sdk.component.pglcrypt.PglCryptUtils;
import com.google.android.gms.nearby.connection.ConnectionsStatusCodes;
import com.inmobi.ads.rendering.InMobiAdActivity;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.UUID;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes4.dex */
public final class M6 {
    public static final /* synthetic */ int i = 0;

    /* renamed from: a, reason: collision with root package name */
    public final Context f2360a;
    public final N6 b;
    public final InterfaceC2624e2 c;
    public final Ub d;
    public final X1 e;
    public final S6 f;
    public final InterfaceC2971z5 g;
    public int h;

    /* JADX WARN: Multi-variable type inference failed */
    public M6(Context context, N6 landingPageState, InterfaceC2624e2 interfaceC2624e2, Ub ub, InterfaceC2961yb redirectionValidator, S6 s6, InterfaceC2971z5 interfaceC2971z5) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(landingPageState, "landingPageState");
        Intrinsics.checkNotNullParameter(redirectionValidator, "redirectionValidator");
        this.f2360a = context;
        this.b = landingPageState;
        this.c = interfaceC2624e2;
        this.d = ub;
        this.e = (X1) redirectionValidator;
        this.f = s6;
        this.g = interfaceC2971z5;
    }

    /* JADX WARN: Code restructure failed: missing block: B:119:0x01df, code lost:
    
        if (r6.equals("DEFAULT") == false) goto L115;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0140, code lost:
    
        if (r6.equals("IN_NATIVE") == false) goto L115;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x01f4, code lost:
    
        r5 = r16.g;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x01f6, code lost:
    
        if (r5 == null) goto L122;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x01f8, code lost:
    
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue("M6", "TAG");
        ((com.inmobi.media.A5) r5).c("M6", "default - internal native");
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0202, code lost:
    
        r7 = r16.c(r17, r18, r19, r4);
     */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01e5  */
    /* JADX WARN: Type inference failed for: r13v5, types: [com.inmobi.media.X1, com.inmobi.media.yb] */
    /* JADX WARN: Type inference failed for: r14v4, types: [com.inmobi.media.X1, com.inmobi.media.yb] */
    /* JADX WARN: Type inference failed for: r15v1, types: [com.inmobi.media.X1, com.inmobi.media.yb] */
    /* JADX WARN: Type inference failed for: r7v5, types: [com.inmobi.media.X1, com.inmobi.media.yb] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static K6 a(M6 m6, String api, String str, String str2, R6 r6, boolean z, int i2) {
        InterfaceC2971z5 interfaceC2971z5;
        InterfaceC2971z5 interfaceC2971z52;
        R6 r62 = (i2 & 8) != 0 ? null : r6;
        int i3 = 0;
        boolean z2 = (i2 & 16) != 0 ? false : z;
        m6.getClass();
        Intrinsics.checkNotNullParameter(api, "api");
        InterfaceC2971z5 interfaceC2971z53 = m6.g;
        if (interfaceC2971z53 != null) {
            ((A5) interfaceC2971z53).c("M6", I6.a("M6", "TAG", "processing URL - ", str2));
        }
        if (r62 == null) {
            S6 s6 = m6.f;
            if (s6 == null || m6.b.f2371a || z2) {
                r62 = null;
            } else {
                String a2 = J6.a(str2);
                int i4 = m6.h + 1;
                m6.h = i4;
                r62 = new R6(s6, a2, i4, 8);
            }
        }
        F6 f6 = F6.d;
        J6.a(f6, r62, (Integer) null, G6.a(f6, "funnelState", m6));
        if (str2 == null || str2.length() == 0) {
            InterfaceC2971z5 interfaceC2971z54 = m6.g;
            if (interfaceC2971z54 != null) {
                Intrinsics.checkNotNullExpressionValue("M6", "TAG");
                ((A5) interfaceC2971z54).c("M6", "url is empty");
            }
            F6 f62 = F6.e;
            J6.a(f62, r62, (Integer) 2, (Function2) G6.a(f62, "funnelState", m6));
            m6.b(api, str, str2);
            return new K6(3, 2);
        }
        Uri parse = Uri.parse(str2);
        String scheme = parse.getScheme();
        if (scheme == null || scheme.length() == 0) {
            InterfaceC2971z5 interfaceC2971z55 = m6.g;
            if (interfaceC2971z55 != null) {
                Intrinsics.checkNotNullExpressionValue("M6", "TAG");
                ((A5) interfaceC2971z55).c("M6", "url scheme is empty");
            }
            F6 f63 = F6.e;
            J6.a(f63, r62, (Integer) 4, (Function2) G6.a(f63, "funnelState", m6));
            m6.b(api, str, str2);
            return new K6(3, 4);
        }
        if (Intrinsics.areEqual(parse.getScheme(), "inmobinativebrowser")) {
            InterfaceC2971z5 interfaceC2971z56 = m6.g;
            if (interfaceC2971z56 != null) {
                Intrinsics.checkNotNullExpressionValue("M6", "TAG");
                ((A5) interfaceC2971z56).c("M6", "inmobi native browser scheme");
            }
            return m6.b(api, str, str2, r62);
        }
        if (Intrinsics.areEqual(parse.getScheme(), "inmobideeplink")) {
            InterfaceC2971z5 interfaceC2971z57 = m6.g;
            if (interfaceC2971z57 != null) {
                Intrinsics.checkNotNullExpressionValue("M6", "TAG");
                ((A5) interfaceC2971z57).c("M6", "inmobi deeplink scheme");
            }
            return m6.a(api, str, str2, r62);
        }
        if (AbstractC2739l1.a(m6.f2360a, str2, m6.e, api, m6.g) || C3.a(str2, m6.f2360a, m6.e, m6.g)) {
            InterfaceC2971z5 interfaceC2971z58 = m6.g;
            if (interfaceC2971z58 != null) {
                Intrinsics.checkNotNullExpressionValue("M6", "TAG");
                ((A5) interfaceC2971z58).c("M6", "appstore link");
            }
            m6.c(api, str, str2);
            if (r62 != null) {
                r62.g = "EX_NATIVE";
            }
            F6 f64 = F6.f;
            J6.a(f64, r62, (Integer) null, G6.a(f64, "funnelState", m6));
            return new K6(1);
        }
        Intrinsics.checkNotNull(parse);
        if (!AbstractC2968z2.a(parse)) {
            int a3 = C3.a(m6.f2360a, str2, m6.e, api, m6.g);
            if (r62 != null) {
                r62.g = "EX_NATIVE";
            }
            if (a3 == 0 || a3 == 1) {
                F6 f65 = F6.f;
                J6.a(f65, r62, (Integer) null, G6.a(f65, "funnelState", m6));
                m6.c(api, str, str2);
                InterfaceC2971z5 interfaceC2971z59 = m6.g;
                if (interfaceC2971z59 != null) {
                    Intrinsics.checkNotNullExpressionValue("M6", "TAG");
                    ((A5) interfaceC2971z59).c("M6", "Deeplink url handled successfully");
                }
                return new K6(1);
            }
            InterfaceC2971z5 interfaceC2971z510 = m6.g;
            if (interfaceC2971z510 != null) {
                Intrinsics.checkNotNullExpressionValue("M6", "TAG");
                ((A5) interfaceC2971z510).c("M6", "In processOpenRequest else");
            }
            m6.b(api, str, str2);
            F6 f66 = F6.g;
            J6.a(f66, r62, Integer.valueOf(a3), G6.a(f66, "funnelState", m6));
            return new K6(2, Integer.valueOf(a3));
        }
        InterfaceC2971z5 interfaceC2971z511 = m6.g;
        if (interfaceC2971z511 != null) {
            Intrinsics.checkNotNullExpressionValue("M6", "TAG");
            ((A5) interfaceC2971z511).c("M6", "http link");
        }
        N6 n6 = m6.b;
        if (n6.f2371a) {
            return new K6(0);
        }
        String str3 = n6.b;
        int hashCode = str3.hashCode();
        if (hashCode != -2032180703) {
            if (hashCode != -702637789) {
                if (hashCode != 112775115) {
                    if (hashCode == 409244785) {
                    }
                } else if (str3.equals("IN_CUSTOM")) {
                    InterfaceC2971z5 interfaceC2971z512 = m6.g;
                    if (interfaceC2971z512 != null) {
                        Intrinsics.checkNotNullExpressionValue("M6", "TAG");
                        ((A5) interfaceC2971z512).c("M6", "open internal custom");
                    }
                    InterfaceC2971z5 interfaceC2971z513 = m6.g;
                    if (interfaceC2971z513 != null) {
                        Intrinsics.checkNotNullExpressionValue("M6", "TAG");
                        ((A5) interfaceC2971z513).a("M6", "In processOpenInternalCustomRequest");
                    }
                    i3 = m6.a(str2, api, r62);
                    if ((i3 == 0 || i3 == 1) && (interfaceC2971z52 = m6.g) != null) {
                        Intrinsics.checkNotNullExpressionValue("M6", "TAG");
                        ((A5) interfaceC2971z52).c("M6", "Internal Custom handled successfully");
                    }
                }
                interfaceC2971z5 = m6.g;
                if (interfaceC2971z5 != null) {
                    Intrinsics.checkNotNullExpressionValue("M6", "TAG");
                    ((A5) interfaceC2971z5).c("M6", "invalid scheme - open internal native");
                }
                i3 = m6.c(api, str, str2, r62);
            } else {
                if (str3.equals("EX_NATIVE")) {
                    InterfaceC2971z5 interfaceC2971z514 = m6.g;
                    if (interfaceC2971z514 != null) {
                        Intrinsics.checkNotNullExpressionValue("M6", "TAG");
                        ((A5) interfaceC2971z514).c("M6", "open external native");
                    }
                    InterfaceC2971z5 interfaceC2971z515 = m6.g;
                    if (interfaceC2971z515 != null) {
                        Intrinsics.checkNotNullExpressionValue("M6", "TAG");
                        ((A5) interfaceC2971z515).a("M6", "In processOpenExternalNativeRequest");
                    }
                    int a4 = C3.a(m6.f2360a, str2, m6.e, api, m6.g);
                    if (a4 == 0 || a4 == 1) {
                        if (r62 != null) {
                            r62.g = "EX_NATIVE";
                        }
                        F6 f67 = F6.f;
                        J6.a(f67, r62, (Integer) null, G6.a(f67, "funnelState", m6));
                        m6.c(api, str, str2);
                        InterfaceC2971z5 interfaceC2971z516 = m6.g;
                        if (interfaceC2971z516 != null) {
                            Intrinsics.checkNotNullExpressionValue("M6", "TAG");
                            ((A5) interfaceC2971z516).c("M6", "External Native handled successfully");
                        }
                    } else {
                        i3 = m6.d(api, str, str2, r62);
                    }
                }
                interfaceC2971z5 = m6.g;
                if (interfaceC2971z5 != null) {
                }
                i3 = m6.c(api, str, str2, r62);
            }
        }
        if (i3 == 0 || i3 == 1) {
            return new K6(1);
        }
        if (r62 != null) {
            r62.g = m6.b.b;
        }
        F6 f68 = F6.g;
        J6.a(f68, r62, Integer.valueOf(i3), G6.a(f68, "funnelState", m6));
        return new K6(2, Integer.valueOf(i3));
    }

    /* JADX WARN: Type inference failed for: r11v0, types: [com.inmobi.media.X1, com.inmobi.media.yb] */
    /* JADX WARN: Type inference failed for: r15v0, types: [com.inmobi.media.X1, com.inmobi.media.yb] */
    public final K6 b(String str, String str2, String str3, R6 r6) {
        InterfaceC2971z5 interfaceC2971z5 = this.g;
        if (interfaceC2971z5 != null) {
            Intrinsics.checkNotNullExpressionValue("M6", "TAG");
            ((A5) interfaceC2971z5).c("M6", "In processInMobiNativeBrowserScheme");
        }
        String queryParameter = Uri.parse(str3).getQueryParameter("url");
        if (queryParameter == null || queryParameter.length() == 0) {
            Ub ub = this.d;
            if (ub != null) {
                Intrinsics.checkNotNullParameter("Invalid URL", PglCryptUtils.KEY_MESSAGE);
                ub.f2452a.a(str2, "Invalid URL", str);
            }
            InterfaceC2971z5 interfaceC2971z52 = this.g;
            if (interfaceC2971z52 != null) {
                Intrinsics.checkNotNullExpressionValue("M6", "TAG");
                ((A5) interfaceC2971z52).c("M6", "InMobiNativeBrowserScheme url is Empty or null");
            }
            F6 f6 = F6.e;
            J6.a(f6, r6, Integer.valueOf(ConnectionsStatusCodes.STATUS_ALREADY_ADVERTISING), G6.a(f6, "funnelState", this));
            return new K6(3, Integer.valueOf(ConnectionsStatusCodes.STATUS_ALREADY_ADVERTISING));
        }
        if (r6 != null) {
            r6.g = "EX_NATIVE";
        }
        if (C3.a(str3, this.f2360a, this.e, this.g)) {
            F6 f62 = F6.f;
            J6.a(f62, r6, (Integer) null, G6.a(f62, "funnelState", this));
            c(str, str2, str3);
            InterfaceC2971z5 interfaceC2971z53 = this.g;
            if (interfaceC2971z53 != null) {
                Intrinsics.checkNotNullExpressionValue("M6", "TAG");
                ((A5) interfaceC2971z53).c("M6", "InmobiNativeBrowser scheme url handled successfully");
            }
            return new K6(1);
        }
        int a2 = C3.a(this.f2360a, queryParameter, this.e, str, this.g);
        if (a2 == 0 || a2 == 1) {
            F6 f63 = F6.f;
            J6.a(f63, r6, (Integer) null, G6.a(f63, "funnelState", this));
            c(str, str2, str3);
            InterfaceC2971z5 interfaceC2971z54 = this.g;
            if (interfaceC2971z54 != null) {
                Intrinsics.checkNotNullExpressionValue("M6", "TAG");
                ((A5) interfaceC2971z54).c("M6", "InmobiNativeBrowser scheme url handled successfully");
            }
            return new K6(1);
        }
        Ub ub2 = this.d;
        if (ub2 != null) {
            Intrinsics.checkNotNullParameter("Invalid URL", PglCryptUtils.KEY_MESSAGE);
            ub2.f2452a.a(str2, "Invalid URL", str);
        }
        InterfaceC2971z5 interfaceC2971z55 = this.g;
        if (interfaceC2971z55 != null) {
            Intrinsics.checkNotNullExpressionValue("M6", "TAG");
            ((A5) interfaceC2971z55).c("M6", "InmobiNativeBrowser scheme url handling failed");
        }
        F6 f64 = F6.g;
        J6.a(f64, r6, Integer.valueOf(a2), G6.a(f64, "funnelState", this));
        return new K6(2, Integer.valueOf(a2));
    }

    public final int c(String str, String str2, String str3, R6 r6) {
        InterfaceC2971z5 interfaceC2971z5 = this.g;
        if (interfaceC2971z5 != null) {
            Intrinsics.checkNotNullExpressionValue("M6", "TAG");
            ((A5) interfaceC2971z5).a("M6", "In processInternalNativeRequest");
        }
        try {
            return d(str, str2, str3, r6);
        } catch (Exception e) {
            Ub ub = this.d;
            if (ub != null) {
                Intrinsics.checkNotNullParameter("Unexpected error", PglCryptUtils.KEY_MESSAGE);
                ub.f2452a.a(str2, "Unexpected error", "open");
            }
            AbstractC2680h7.a((byte) 1, "InMobi", "Failed to open URL SDK encountered unexpected error");
            InterfaceC2971z5 interfaceC2971z52 = this.g;
            if (interfaceC2971z52 == null) {
                return 9;
            }
            ((A5) interfaceC2971z52).b("M6", rf.a(e, H6.a("M6", "TAG", "SDK encountered unexpected error in handling open() request from creative ")));
            return 9;
        }
    }

    /* JADX WARN: Type inference failed for: r2v6, types: [com.inmobi.media.X1, com.inmobi.media.yb] */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.inmobi.media.X1, com.inmobi.media.yb] */
    public final int d(String api, String str, String str2, R6 r6) {
        Intrinsics.checkNotNullParameter(api, "api");
        InterfaceC2971z5 interfaceC2971z5 = this.g;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).c("M6", I6.a("M6", "TAG", "processOpenCCTRequest - url - ", str2));
        }
        if (r6 != null) {
            r6.g = "IN_NATIVE";
        }
        if (str2 == null || (StringsKt.startsWith$default(str2, "http", false, 2, (Object) null) && !URLUtil.isValidUrl(str2))) {
            InterfaceC2971z5 interfaceC2971z52 = this.g;
            if (interfaceC2971z52 != null) {
                Intrinsics.checkNotNullExpressionValue("M6", "TAG");
                ((A5) interfaceC2971z52).c("M6", api + " called with invalid url (" + str2 + ')');
            }
            Ub ub = this.d;
            if (ub != null) {
                Intrinsics.checkNotNullParameter("Invalid URL", PglCryptUtils.KEY_MESSAGE);
                ub.f2452a.a(str, "Invalid URL", api);
            }
            F6 f6 = F6.e;
            J6.a(f6, r6, (Integer) 3, (Function2) G6.a(f6, "funnelState", this));
            return 3;
        }
        String a2 = AbstractC2934x3.a(this.f2360a);
        try {
            try {
                boolean z = this.b.c;
                if (a2 != null && z) {
                    new C2724k2(str2, null, this.f2360a, this.c, this.e, r6, api).a();
                    InterfaceC2971z5 interfaceC2971z53 = this.g;
                    if (interfaceC2971z53 != null) {
                        Intrinsics.checkNotNullExpressionValue("M6", "TAG");
                        ((A5) interfaceC2971z53).c("M6", "Default and Internal Native handled successfully");
                    }
                    return 0;
                }
                InterfaceC2971z5 interfaceC2971z54 = this.g;
                if (interfaceC2971z54 != null) {
                    Intrinsics.checkNotNullExpressionValue("M6", "TAG");
                    ((A5) interfaceC2971z54).a("M6", "ChromeCustomTab fallback to Embedded");
                }
                if (r6 != null) {
                    r6.g = "IN_CUSTOM";
                }
                return a(str2, api, r6);
            } catch (Exception e) {
                InterfaceC2971z5 interfaceC2971z55 = this.g;
                if (interfaceC2971z55 != null) {
                    Intrinsics.checkNotNullExpressionValue("M6", "TAG");
                    ((A5) interfaceC2971z55).a("M6", "Exception occurred while opening External ", e);
                }
                return 9;
            }
        } catch (Exception unused) {
            int a3 = AbstractC2968z2.a(this.f2360a, str2, (InterfaceC2961yb) this.e, api);
            if (a3 != 0 && a3 != 1) {
                return a3;
            }
            c(api, str, str2);
            if (r6 != null) {
                r6.g = "EX_NATIVE";
            }
            F6 funnelState = F6.f;
            Intrinsics.checkNotNullParameter(funnelState, "funnelState");
            J6.a(funnelState, r6, (Integer) null, new L6(this));
            return a3;
        }
    }

    /* JADX WARN: Type inference failed for: r3v7, types: [com.inmobi.media.X1, com.inmobi.media.yb] */
    public final void e(String str, String str2, String str3, R6 r6) {
        String str4;
        String str5;
        String str6;
        R6 r62;
        M6 m6;
        String str7;
        String str8;
        String str9;
        R6 r63;
        M6 m62;
        try {
            try {
                try {
                    AbstractC2968z2.a(this.f2360a, str2, (InterfaceC2961yb) this.e, "openExternal");
                    F6 f6 = F6.f;
                    J6.a(f6, r6, (Integer) null, G6.a(f6, "funnelState", this));
                    c("openExternal", str, str2);
                } catch (ActivityNotFoundException e) {
                    e = e;
                    m62 = this;
                    str7 = str;
                    str8 = str2;
                    str9 = str3;
                    r63 = r6;
                    a(m62, str7, str8, str9, r63, e);
                } catch (URISyntaxException e2) {
                    e = e2;
                    m6 = this;
                    str4 = str;
                    str5 = str2;
                    str6 = str3;
                    r62 = r6;
                    a(m6, str4, str5, str6, r62, e);
                }
            } catch (ActivityNotFoundException e3) {
                e = e3;
                str7 = str;
                str8 = str2;
                str9 = str3;
                r63 = r6;
                m62 = this;
            } catch (URISyntaxException e4) {
                e = e4;
                str4 = str;
                str5 = str2;
                str6 = str3;
                r62 = r6;
                m6 = this;
            }
        } catch (NullPointerException e5) {
            a(this, str, str2, str3, r6, e5);
        } catch (Exception e6) {
            F6 f62 = F6.g;
            J6.a(f62, r6, (Integer) 9, (Function2) G6.a(f62, "funnelState", this));
            Ub ub = this.d;
            if (ub != null) {
                Intrinsics.checkNotNullParameter("Unexpected error", PglCryptUtils.KEY_MESSAGE);
                ub.f2452a.a(str, "Unexpected error", "openExternal");
            }
            Intrinsics.checkNotNullExpressionValue("M6", "TAG");
            AbstractC2680h7.a((byte) 1, "M6", "Could not open URL SDK encountered an unexpected error");
            InterfaceC2971z5 interfaceC2971z5 = this.g;
            if (interfaceC2971z5 != null) {
                ((A5) interfaceC2971z5).b("M6", rf.a(e6, H6.a("M6", "TAG", "SDK encountered unexpected error in handling openExternal() request from creative ")));
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:47:0x014e A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0132  */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r10v9 */
    /* JADX WARN: Type inference failed for: r2v4, types: [com.inmobi.media.X1, com.inmobi.media.yb] */
    /* JADX WARN: Type inference failed for: r2v8, types: [com.inmobi.media.X1, com.inmobi.media.yb] */
    /* JADX WARN: Type inference failed for: r4v1, types: [com.inmobi.media.X1, com.inmobi.media.yb] */
    /* JADX WARN: Type inference failed for: r7v5, types: [com.inmobi.media.X1, com.inmobi.media.yb] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int a(String api, String str, String str2, R6 r6, C2691i2 c2691i2) {
        String str3;
        int i2;
        int i3;
        String str4;
        InterfaceC2971z5 interfaceC2971z5;
        String str5;
        Intrinsics.checkNotNullParameter(api, "api");
        ?? r10 = 2;
        if (str2 != null && str2.length() != 0) {
            Uri parse = Uri.parse(str2);
            String scheme = parse.getScheme();
            if (scheme != null && scheme.length() != 0) {
                if (Intrinsics.areEqual(parse.getScheme(), "inmobinativebrowser")) {
                    b(api, str, str2, r6);
                    return 2;
                }
                if (Intrinsics.areEqual(parse.getScheme(), "inmobideeplink")) {
                    if (a(api, str, str2, r6).f2337a != 1) {
                        i3 = 4;
                        return i3;
                    }
                    i2 = 2;
                } else if (AbstractC2739l1.a(this.f2360a, str2, this.e, api, this.g) | C3.a(str2, this.f2360a, this.e, this.g)) {
                    c(api, str, str2);
                    if (r6 != null) {
                        r6.g = "EX_NATIVE";
                    }
                    F6 f6 = F6.f;
                    J6.a(f6, r6, (Integer) null, G6.a(f6, "funnelState", this));
                    i2 = 2;
                } else {
                    Intrinsics.checkNotNull(parse);
                    if (AbstractC2968z2.a(parse)) {
                        try {
                        } catch (Exception e) {
                            e = e;
                            str3 = "M6";
                            i2 = 2;
                        }
                        if (this.b.d && c2691i2 != null) {
                            String a2 = AbstractC2934x3.a(this.f2360a);
                            try {
                                if (a2 != null) {
                                    try {
                                        try {
                                            if (AbstractC2829qa.b(AbstractC2829qa.a(U3.g()))) {
                                                i2 = 2;
                                                CustomTabsIntent.Builder.class.getDeclaredMethod("setInitialActivityWidthPx", Integer.TYPE);
                                            } else {
                                                i2 = 2;
                                                CustomTabsIntent.Builder.class.getDeclaredMethod("setInitialActivityHeightPx", Integer.TYPE);
                                            }
                                            try {
                                                try {
                                                } catch (Exception e2) {
                                                    e = e2;
                                                    r10 = "TAG";
                                                    str3 = "M6";
                                                }
                                            } catch (Exception e3) {
                                                e = e3;
                                                r10 = "TAG";
                                                str3 = "M6";
                                            }
                                        } catch (Error | Exception unused) {
                                            str5 = "TAG";
                                            str3 = "M6";
                                            i3 = 4;
                                        }
                                    } catch (Error | Exception unused2) {
                                    }
                                    try {
                                        try {
                                            new C2724k2(str2, c2691i2, this.f2360a, this.c, this.e, r6, api).a();
                                            return 5;
                                        } catch (Exception e4) {
                                            e = e4;
                                            str3 = "M6";
                                            i3 = 4;
                                            r10 = "TAG";
                                            interfaceC2971z5 = this.g;
                                            str4 = r10;
                                            if (interfaceC2971z5 != null) {
                                                ((A5) interfaceC2971z5).c(str3, rf.a(e, H6.a(str3, r10, "Error while opening partial tab: ")));
                                                str4 = r10;
                                            }
                                            if (!AbstractC2968z2.a(parse)) {
                                            }
                                        }
                                    } catch (Exception e5) {
                                        e = e5;
                                        r10 = "TAG";
                                        str3 = "M6";
                                        i3 = 4;
                                        interfaceC2971z5 = this.g;
                                        str4 = r10;
                                        if (interfaceC2971z5 != null) {
                                        }
                                        if (!AbstractC2968z2.a(parse)) {
                                        }
                                    }
                                }
                                str3 = "M6";
                                i2 = 2;
                                i3 = 4;
                                str5 = "TAG";
                                InterfaceC2971z5 interfaceC2971z52 = this.g;
                                str4 = str5;
                                if (interfaceC2971z52 != null) {
                                    Intrinsics.checkNotNullExpressionValue(str3, str5);
                                    ((A5) interfaceC2971z52).c(str3, "Partial tabs not supported: packageName - " + a2);
                                    str4 = str5;
                                }
                            } catch (Exception e6) {
                                e = e6;
                            }
                            if (!AbstractC2968z2.a(parse)) {
                                return 3;
                            }
                            int a3 = C3.a(this.f2360a, str2, this.e, api, this.g);
                            if (r6 != null) {
                                r6.g = "EX_NATIVE";
                            }
                            if (a3 != 0 && a3 != 1) {
                                InterfaceC2971z5 interfaceC2971z53 = this.g;
                                if (interfaceC2971z53 != null) {
                                    Intrinsics.checkNotNullExpressionValue(str3, str4);
                                    ((A5) interfaceC2971z53).b(str3, "CustomExpand handling failed");
                                }
                                F6 f62 = F6.j;
                                J6.a(f62, r6, (Integer) null, G6.a(f62, "funnelState", this));
                                return i3;
                            }
                            c(api, str, str2);
                            F6 f63 = F6.f;
                            J6.a(f63, r6, (Integer) null, G6.a(f63, "funnelState", this));
                            InterfaceC2971z5 interfaceC2971z54 = this.g;
                            if (interfaceC2971z54 != null) {
                                Intrinsics.checkNotNullExpressionValue(str3, str4);
                                ((A5) interfaceC2971z54).c(str3, "Deeplink url handled successfully");
                            }
                        }
                    }
                    str3 = "M6";
                    i2 = 2;
                    i3 = 4;
                    str4 = "TAG";
                    if (!AbstractC2968z2.a(parse)) {
                    }
                }
                return i2;
            }
            b(api, str, str2);
            F6 f64 = F6.e;
            J6.a(f64, r6, (Integer) 4, (Function2) G6.a(f64, "funnelState", this));
            return 1;
        }
        b(api, str, str2);
        F6 f65 = F6.e;
        J6.a(f65, r6, (Integer) 2, (Function2) G6.a(f65, "funnelState", this));
        return 1;
    }

    public final void c(String str, String str2, String str3) {
        Ub ub = this.d;
        if (ub != null) {
            ub.f2452a.getListener().a();
        }
        Ub ub2 = this.d;
        if (ub2 != null) {
            GestureDetectorOnGestureListenerC2634ec.a(ub2.f2452a, str, str2, str3);
        }
    }

    public final K6 a(String str, String str2, String str3, R6 r6) {
        InterfaceC2971z5 interfaceC2971z5 = this.g;
        if (interfaceC2971z5 != null) {
            Intrinsics.checkNotNullExpressionValue("M6", "TAG");
            ((A5) interfaceC2971z5).a("M6", "In processInMobiDeepLinkScheme");
        }
        Uri parse = Uri.parse(str3);
        int a2 = a(str, parse.getQueryParameter("primaryUrl"), parse.getQueryParameter("primaryTrackingUrl"));
        if (a2 != 0 && a2 != 1) {
            int a3 = a(str, parse.getQueryParameter("fallbackUrl"), parse.getQueryParameter("fallbackTrackingUrl"));
            if (r6 != null) {
                r6.g = "EX_NATIVE";
            }
            if (a3 != 0 && a3 != 1) {
                Ub ub = this.d;
                if (ub != null) {
                    Intrinsics.checkNotNullParameter("Invalid URL", PglCryptUtils.KEY_MESSAGE);
                    ub.f2452a.a(str2, "Invalid URL", str);
                }
                InterfaceC2971z5 interfaceC2971z52 = this.g;
                if (interfaceC2971z52 != null) {
                    Intrinsics.checkNotNullExpressionValue("M6", "TAG");
                    ((A5) interfaceC2971z52).c("M6", "InMobiDeepLinkScheme Fallback Url handling failed");
                }
                F6 f6 = F6.g;
                J6.a(f6, r6, Integer.valueOf(a3), G6.a(f6, "funnelState", this));
                return new K6(2, Integer.valueOf(a3));
            }
            InterfaceC2971z5 interfaceC2971z53 = this.g;
            if (interfaceC2971z53 != null) {
                Intrinsics.checkNotNullExpressionValue("M6", "TAG");
                ((A5) interfaceC2971z53).c("M6", "InMobiDeepLinkScheme Fallback Url handled successfully");
            }
            F6 f62 = F6.f;
            J6.a(f62, r6, (Integer) null, G6.a(f62, "funnelState", this));
            c(str, str2, str3);
            return new K6(1);
        }
        InterfaceC2971z5 interfaceC2971z54 = this.g;
        if (interfaceC2971z54 != null) {
            Intrinsics.checkNotNullExpressionValue("M6", "TAG");
            ((A5) interfaceC2971z54).c("M6", "InMobiDeepLinkScheme Primary Url handled successfully");
        }
        if (r6 != null) {
            r6.g = "EX_NATIVE";
        }
        F6 f63 = F6.f;
        J6.a(f63, r6, (Integer) null, G6.a(f63, "funnelState", this));
        c(str, str2, str3);
        return new K6(1);
    }

    public final void b(String str, String str2, String str3) {
        InterfaceC2971z5 interfaceC2971z5 = this.g;
        if (interfaceC2971z5 != null) {
            Intrinsics.checkNotNullExpressionValue("M6", "TAG");
            ((A5) interfaceC2971z5).c("M6", str + " called with invalid url (" + str3 + ')');
        }
        Ub ub = this.d;
        if (ub != null) {
            Intrinsics.checkNotNullParameter("Invalid URL", PglCryptUtils.KEY_MESSAGE);
            ub.f2452a.a(str2, "Invalid URL", str);
        }
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [com.inmobi.media.X1, com.inmobi.media.yb] */
    /* JADX WARN: Type inference failed for: r7v0, types: [com.inmobi.media.X1, com.inmobi.media.yb] */
    public final int a(String str, String str2, String str3) {
        InterfaceC2971z5 interfaceC2971z5 = this.g;
        if (interfaceC2971z5 != null) {
            Intrinsics.checkNotNullExpressionValue("M6", "TAG");
            ((A5) interfaceC2971z5).c("M6", "inMobiDeepLinkSchemeUrlHandled - url - " + str2 + " trackingUrl " + str3);
        }
        if (str2 != null && str2.length() != 0) {
            if (C3.a(str2, this.f2360a, this.e, this.g)) {
                if (B2.a(str3)) {
                    C2933x2 c2933x2 = C2933x2.f2748a;
                    Intrinsics.checkNotNull(str3);
                    c2933x2.a(str3, true, this.g);
                } else {
                    InterfaceC2971z5 interfaceC2971z52 = this.g;
                    if (interfaceC2971z52 != null) {
                        Intrinsics.checkNotNullExpressionValue("M6", "TAG");
                        ((A5) interfaceC2971z52).b("M6", "InMobiDeepLinkScheme scheme tracking url handling is invalid ");
                    }
                }
                InterfaceC2971z5 interfaceC2971z53 = this.g;
                if (interfaceC2971z53 != null) {
                    Intrinsics.checkNotNullExpressionValue("M6", "TAG");
                    ((A5) interfaceC2971z53).c("M6", "InMobiDeepLinkScheme scheme applink/http url handled successfully");
                }
                return 0;
            }
            int a2 = C3.a(this.f2360a, str2, this.e, str, this.g);
            if (a2 != 0 && a2 != 1) {
                InterfaceC2971z5 interfaceC2971z54 = this.g;
                if (interfaceC2971z54 != null) {
                    Intrinsics.checkNotNullExpressionValue("M6", "TAG");
                    ((A5) interfaceC2971z54).c("M6", "InMobiDeepLinkScheme scheme applink/http url handling failed");
                }
                return a2;
            }
            if (B2.a(str3)) {
                C2933x2 c2933x22 = C2933x2.f2748a;
                Intrinsics.checkNotNull(str3);
                c2933x22.a(str3, true, this.g);
            } else {
                InterfaceC2971z5 interfaceC2971z55 = this.g;
                if (interfaceC2971z55 != null) {
                    Intrinsics.checkNotNullExpressionValue("M6", "TAG");
                    ((A5) interfaceC2971z55).b("M6", "InMobiDeepLinkScheme scheme tracking url handling is invalid ");
                }
            }
            InterfaceC2971z5 interfaceC2971z56 = this.g;
            if (interfaceC2971z56 != null) {
                Intrinsics.checkNotNullExpressionValue("M6", "TAG");
                ((A5) interfaceC2971z56).c("M6", "InMobiDeepLinkScheme scheme applink/http url handled successfully");
            }
            return 0;
        }
        InterfaceC2971z5 interfaceC2971z57 = this.g;
        if (interfaceC2971z57 == null) {
            return 2;
        }
        Intrinsics.checkNotNullExpressionValue("M6", "TAG");
        ((A5) interfaceC2971z57).b("M6", "InMobiDeepLinkScheme url is Empty or null");
        return 2;
    }

    /* JADX WARN: Type inference failed for: r4v5, types: [com.inmobi.media.X1, com.inmobi.media.yb] */
    public final int a(String url, String api, R6 r6) {
        R6 r62;
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(api, "api");
        if (r6 != null) {
            r6.g = "IN_CUSTOM";
        }
        if (url.length() == 0) {
            InterfaceC2971z5 interfaceC2971z5 = this.g;
            if (interfaceC2971z5 != null) {
                Intrinsics.checkNotNullExpressionValue("M6", "TAG");
                ((A5) interfaceC2971z5).b("M6", "processOpenEmbeddedRequest failed due to empty URL");
            }
            F6 f6 = F6.e;
            J6.a(f6, r6, (Integer) null, G6.a(f6, "funnelState", this));
            return 2;
        }
        Uri parse = Uri.parse(url);
        Intrinsics.checkNotNullExpressionValue(parse, "Uri.parse(this)");
        if (AbstractC2968z2.a(parse)) {
            Intent intent = new Intent(this.f2360a, (Class<?>) InMobiAdActivity.class);
            intent.putExtra("com.inmobi.ads.rendering.InMobiAdActivity.EXTRA_AD_ACTIVITY_TYPE", 100);
            intent.putExtra("com.inmobi.ads.rendering.InMobiAdActivity.IN_APP_BROWSER_URL", url);
            intent.putExtra("viewTouchTimestamp", this.e.getViewTouchTimestamp());
            if (r6 != null) {
                S6 landingPageTelemetryMetaData = r6.f2415a;
                String urlType = r6.b;
                int i2 = r6.c;
                long j = r6.d;
                Intrinsics.checkNotNullParameter(landingPageTelemetryMetaData, "landingPageTelemetryMetaData");
                Intrinsics.checkNotNullParameter(urlType, "urlType");
                r62 = new R6(landingPageTelemetryMetaData, urlType, i2, j);
                F6 f62 = F6.d;
                r62.f = 2;
                Unit unit = Unit.INSTANCE;
            } else {
                r62 = null;
            }
            intent.putExtra("lpTelemetryControlInfo", r62);
            InterfaceC2971z5 obj = this.g;
            if (obj != null) {
                String uuid = UUID.randomUUID().toString();
                Intrinsics.checkNotNullExpressionValue(uuid, "toString(...)");
                HashMap hashMap = AbstractC2759m5.f2639a;
                String key = uuid.toString();
                Intrinsics.checkNotNullParameter(key, "key");
                Intrinsics.checkNotNullParameter(obj, "obj");
                AbstractC2759m5.f2639a.put(key, new WeakReference(obj));
                intent.putExtra("loggerCacheKey", uuid.toString());
            }
            Ub ub = this.d;
            if (ub != null) {
                Intrinsics.checkNotNullParameter(intent, "intent");
                intent.putExtra("creativeId", ub.f2452a.getCreativeId());
                intent.putExtra("impressionId", ub.f2452a.getImpressionId());
                intent.putExtra("placementId", ub.f2452a.getPlacementId());
                SparseArray sparseArray = InMobiAdActivity.k;
                GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec = ub.f2452a;
                InMobiAdActivity.l = gestureDetectorOnGestureListenerC2634ec;
                Uc.f2453a.a(gestureDetectorOnGestureListenerC2634ec.getContainerContext(), intent);
            }
            F6 f63 = F6.f;
            J6.a(f63, r6, (Integer) null, G6.a(f63, "funnelState", this));
            Ub ub2 = this.d;
            if (ub2 == null) {
                return 1;
            }
            GestureDetectorOnGestureListenerC2634ec.a(ub2.f2452a, null, null, url);
            return 1;
        }
        InterfaceC2971z5 interfaceC2971z52 = this.g;
        if (interfaceC2971z52 == null) {
            return 10;
        }
        Intrinsics.checkNotNullExpressionValue("M6", "TAG");
        ((A5) interfaceC2971z52).b("M6", "Embedded request unable to handle ".concat(url));
        return 10;
    }

    public static final void a(M6 m6, String str, String str2, String str3, R6 r6, Exception exc) {
        InterfaceC2971z5 interfaceC2971z5 = m6.g;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).b("M6", rf.a(exc, H6.a("M6", "TAG", "Error message in processing openExternal: ")));
        }
        Ub ub = m6.d;
        if (ub != null) {
            StringBuilder sb = new StringBuilder("Cannot resolve URI (");
            try {
                String encode = URLEncoder.encode(str2, "UTF-8");
                Intrinsics.checkNotNull(encode);
                str2 = encode;
            } catch (UnsupportedEncodingException unused) {
            }
            String message = sb.append(str2).append(')').toString();
            Intrinsics.checkNotNullParameter(message, "message");
            ub.f2452a.a(str, message, "openExternal");
        }
        if (str3 != null) {
            m6.e(str, str3, null, r6);
        }
    }
}
