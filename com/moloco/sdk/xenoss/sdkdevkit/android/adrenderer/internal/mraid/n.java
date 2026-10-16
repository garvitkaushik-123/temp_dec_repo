package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid;

import android.net.Uri;
import android.text.TextUtils;
import com.moloco.sdk.internal.v;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes6.dex */
public abstract class n {
    public static final b b = new b(null);
    public static final int c = 0;
    public static final String d = "close";
    public static final String e = "expand";
    public static final String f = "open";
    public static final String g = "resize";
    public static final String h = "setOrientationProperties";

    /* renamed from: a, reason: collision with root package name */
    public final String f5905a;

    public static final class a extends n {
        public static final a i = new a();
        public static final int j = 0;

        public a() {
            super("close", null);
        }
    }

    public static final class b {

        public static final class a {
            public static final int c = 0;

            /* renamed from: a, reason: collision with root package name */
            public final boolean f5906a;
            public final String b;

            public a(boolean z, String description) {
                Intrinsics.checkNotNullParameter(description, "description");
                this.f5906a = z;
                this.b = description;
            }

            public final String a() {
                return this.b;
            }

            public final boolean b() {
                return this.f5906a;
            }
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final e a() {
            return null;
        }

        public final d b(Map<String, String> map) {
            Object m10241constructorimpl;
            String str = map.get("url");
            if (str == null) {
                return null;
            }
            try {
                Result.Companion companion = Result.INSTANCE;
                Uri parse = Uri.parse(str);
                Intrinsics.checkNotNullExpressionValue(parse, "parse(...)");
                m10241constructorimpl = Result.m10241constructorimpl(new d(parse));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
            }
            return (d) (Result.m10247isFailureimpl(m10241constructorimpl) ? null : m10241constructorimpl);
        }

        public final f c(Map<String, String> map) {
            Boolean booleanStrictOrNull;
            String str = map.get("allowOrientationChange");
            if (str == null || (booleanStrictOrNull = StringsKt.toBooleanStrictOrNull(str)) == null) {
                return null;
            }
            boolean booleanValue = booleanStrictOrNull.booleanValue();
            p a2 = p.f5907a.a(map.get("forceOrientation"));
            if (a2 == null) {
                return null;
            }
            return new f(booleanValue, a2);
        }

        public b() {
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
        java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
        	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
        	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
         */
        public final com.moloco.sdk.internal.v<n, a> a(String str) {
            Object m10241constructorimpl;
            try {
                Result.Companion companion = Result.INSTANCE;
                m10241constructorimpl = Result.m10241constructorimpl(Uri.parse(str));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
            }
            Object obj = null;
            if (Result.m10247isFailureimpl(m10241constructorimpl)) {
                m10241constructorimpl = null;
            }
            Uri uri = (Uri) m10241constructorimpl;
            if (uri == null) {
                return new v.a(new a(false, "Invalid url: " + str));
            }
            if (!Intrinsics.areEqual(uri.getScheme(), "mraid")) {
                return new v.a(new a(false, "Non-mraid url scheme: " + str));
            }
            Map<String, String> a2 = a(uri);
            String host = uri.getHost();
            if (host != null) {
                switch (host.hashCode()) {
                    case -1289167206:
                        if (host.equals(n.e)) {
                            obj = a(a2);
                            break;
                        }
                        break;
                    case -934437708:
                        if (host.equals(n.g)) {
                            obj = a();
                            break;
                        }
                        break;
                    case 3417674:
                        if (host.equals("open")) {
                            obj = b(a2);
                            break;
                        }
                        break;
                    case 94756344:
                        if (host.equals("close")) {
                            obj = a.i;
                            break;
                        }
                        break;
                    case 133423073:
                        if (host.equals("setOrientationProperties")) {
                            obj = c(a2);
                            break;
                        }
                        break;
                }
            }
            return obj != null ? new v.b(obj) : new v.a(new a(true, "Unknown/unsupported mraid command " + uri.getHost()));
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final c a(Map<String, String> map) {
            Uri uri;
            String str = map.get("url");
            if (str != null) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    uri = Result.m10241constructorimpl(Uri.parse(str));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    uri = Result.m10241constructorimpl(ResultKt.createFailure(th));
                }
                r0 = Result.m10247isFailureimpl(uri) ? null : uri;
            }
            return new c(r0);
        }

        public final Map<String, String> a(Uri uri) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (String str : uri.getQueryParameterNames()) {
                linkedHashMap.put(str, TextUtils.join(",", uri.getQueryParameters(str)));
            }
            return linkedHashMap;
        }
    }

    public static final class c extends n {
        public static final int j = 8;
        public final Uri i;

        public c(Uri uri) {
            super(n.e, null);
            this.i = uri;
        }

        public final Uri b() {
            return this.i;
        }
    }

    public static final class d extends n {
        public static final int j = 8;
        public final Uri i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Uri uri) {
            super("open", null);
            Intrinsics.checkNotNullParameter(uri, "uri");
            this.i = uri;
        }

        public final Uri b() {
            return this.i;
        }
    }

    public static final class e extends n {
        public static final int n = 0;
        public final int i;
        public final int j;
        public final int k;
        public final int l;
        public final boolean m;

        public e(int i, int i2, int i3, int i4, boolean z) {
            super(n.g, null);
            this.i = i;
            this.j = i2;
            this.k = i3;
            this.l = i4;
            this.m = z;
        }

        public final boolean b() {
            return this.m;
        }

        public final int c() {
            return this.j;
        }

        public final int d() {
            return this.k;
        }

        public final int e() {
            return this.l;
        }

        public final int f() {
            return this.i;
        }
    }

    public static final class f extends n {
        public static final int k = 0;
        public final boolean i;
        public final p j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(boolean z, p forceOrientation) {
            super("setOrientationProperties", null);
            Intrinsics.checkNotNullParameter(forceOrientation, "forceOrientation");
            this.i = z;
            this.j = forceOrientation;
        }

        public final boolean b() {
            return this.i;
        }

        public final p c() {
            return this.j;
        }
    }

    public /* synthetic */ n(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    public final String a() {
        return this.f5905a;
    }

    public n(String str) {
        this.f5905a = str;
    }

    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.ad.orientation.b a(f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "<this>");
        return new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.ad.orientation.b(q.a(fVar.c()), fVar.b());
    }
}
