package com.ironsource.sdk.controller;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.ironsource.Bc;
import com.ironsource.C3040d4;
import com.ironsource.C3260q4;
import com.ironsource.Cc;
import com.ironsource.InterfaceC3086g;
import com.ironsource.InterfaceC3103h;
import com.ironsource.sdk.controller.OpenUrlActivity;
import com.ironsource.sdk.controller.k;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public interface p {

    public interface b {

        public static final class a implements b {

            /* renamed from: a, reason: collision with root package name */
            private final Cc f3765a;
            private final InterfaceC3086g b;

            public a(Cc configurations, InterfaceC3086g intentFactory) {
                Intrinsics.checkNotNullParameter(configurations, "configurations");
                Intrinsics.checkNotNullParameter(intentFactory, "intentFactory");
                this.f3765a = configurations;
                this.b = intentFactory;
            }

            @Override // com.ironsource.sdk.controller.p.b
            public c a(Context context, Bc openUrl) {
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(openUrl, "openUrl");
                if (TextUtils.isEmpty(openUrl.d())) {
                    return new c.a("url is empty");
                }
                Intent a2 = this.b.a();
                a2.setData(Uri.parse(openUrl.d()));
                String c = openUrl.c();
                if (c != null && c.length() != 0) {
                    a2 = a2.setPackage(openUrl.c());
                    Intrinsics.checkNotNullExpressionValue(a2, "this.setPackage(openUrl.packageName)");
                }
                if (!(context instanceof Activity)) {
                    a2 = a2.addFlags(this.f3765a.c());
                }
                Intrinsics.checkNotNullExpressionValue(a2, "intentFactory\n          …ations.flags) else this }");
                context.startActivity(a2);
                return c.b.f3770a;
            }
        }

        /* renamed from: com.ironsource.sdk.controller.p$b$b, reason: collision with other inner class name */
        public static final class C0302b implements b {

            /* renamed from: a, reason: collision with root package name */
            private final String f3766a;

            public C0302b(String method) {
                Intrinsics.checkNotNullParameter(method, "method");
                this.f3766a = method;
            }

            @Override // com.ironsource.sdk.controller.p.b
            public c a(Context context, Bc openUrl) {
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(openUrl, "openUrl");
                return new c.a("method " + this.f3766a + " is unsupported");
            }
        }

        public static final class c implements b {

            /* renamed from: a, reason: collision with root package name */
            private final Cc f3767a;
            private final InterfaceC3103h b;

            public c(Cc configurations, InterfaceC3103h intentFactory) {
                Intrinsics.checkNotNullParameter(configurations, "configurations");
                Intrinsics.checkNotNullParameter(intentFactory, "intentFactory");
                this.f3767a = configurations;
                this.b = intentFactory;
            }

            @Override // com.ironsource.sdk.controller.p.b
            public c a(Context context, Bc openUrl) {
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(openUrl, "openUrl");
                context.startActivity(new OpenUrlActivity.e(this.b).a(this.f3767a.c()).a(openUrl.d()).b(true).c(true).a(context));
                return c.b.f3770a;
            }
        }

        public static final class d implements b {

            /* renamed from: a, reason: collision with root package name */
            private final Cc f3768a;
            private final InterfaceC3103h b;

            public d(Cc configurations, InterfaceC3103h intentFactory) {
                Intrinsics.checkNotNullParameter(configurations, "configurations");
                Intrinsics.checkNotNullParameter(intentFactory, "intentFactory");
                this.f3768a = configurations;
                this.b = intentFactory;
            }

            @Override // com.ironsource.sdk.controller.p.b
            public c a(Context context, Bc openUrl) {
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(openUrl, "openUrl");
                context.startActivity(new OpenUrlActivity.e(this.b).a(this.f3768a.c()).a(openUrl.d()).a(this.f3768a.d()).b(true).a(context));
                return c.b.f3770a;
            }
        }

        c a(Context context, Bc bc);
    }

    public static abstract class c {

        public static final class a extends c {

            /* renamed from: a, reason: collision with root package name */
            private final String f3769a;

            /* JADX WARN: Multi-variable type inference failed */
            public a() {
                this(null, 1, 0 == true ? 1 : 0);
            }

            public final String a() {
                return this.f3769a;
            }

            public final String b() {
                return this.f3769a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof a) && Intrinsics.areEqual(this.f3769a, ((a) obj).f3769a);
            }

            public int hashCode() {
                return this.f3769a.hashCode();
            }

            public String toString() {
                return "Error(errorMessage=" + this.f3769a + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(String errorMessage) {
                super(null);
                Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
                this.f3769a = errorMessage;
            }

            public final a a(String errorMessage) {
                Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
                return new a(errorMessage);
            }

            public /* synthetic */ a(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? "" : str);
            }

            public static /* synthetic */ a a(a aVar, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = aVar.f3769a;
                }
                return aVar.a(str);
            }
        }

        public static final class b extends c {

            /* renamed from: a, reason: collision with root package name */
            public static final b f3770a = new b();

            private b() {
                super(null);
            }
        }

        public /* synthetic */ c(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private c() {
        }
    }

    c a(Context context, Bc bc);

    public static final class a implements p {

        /* renamed from: a, reason: collision with root package name */
        private b f3764a;

        public a(String method, Cc openUrlConfigurations, InterfaceC3103h activityIntentFactory, InterfaceC3086g actionIntentFactory) {
            b aVar;
            Intrinsics.checkNotNullParameter(method, "method");
            Intrinsics.checkNotNullParameter(openUrlConfigurations, "openUrlConfigurations");
            Intrinsics.checkNotNullParameter(activityIntentFactory, "activityIntentFactory");
            Intrinsics.checkNotNullParameter(actionIntentFactory, "actionIntentFactory");
            int hashCode = method.hashCode();
            if (hashCode == -1455867212) {
                if (method.equals(C3040d4.h.J)) {
                    aVar = new b.a(openUrlConfigurations, actionIntentFactory);
                }
                aVar = new b.C0302b(method);
            } else if (hashCode != 109770977) {
                if (hashCode == 1224424441 && method.equals(C3040d4.h.K)) {
                    aVar = new b.d(openUrlConfigurations, activityIntentFactory);
                }
                aVar = new b.C0302b(method);
            } else {
                if (method.equals(C3040d4.h.U)) {
                    aVar = new b.c(openUrlConfigurations, activityIntentFactory);
                }
                aVar = new b.C0302b(method);
            }
            this.f3764a = aVar;
        }

        @Override // com.ironsource.sdk.controller.p
        public c a(Context context, Bc openUrl) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(openUrl, "openUrl");
            try {
                return this.f3764a.a(context, openUrl);
            } catch (Exception e) {
                C3260q4.d().a(e);
                String message = e.getMessage();
                String message2 = (message == null || message.length() == 0) ? "" : e.getMessage();
                Intrinsics.checkNotNull(message2);
                return new c.a(message2);
            }
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public a(String method, Cc openUrlConfigurations) {
            this(method, openUrlConfigurations, new k.b(), new k.a());
            Intrinsics.checkNotNullParameter(method, "method");
            Intrinsics.checkNotNullParameter(openUrlConfigurations, "openUrlConfigurations");
        }
    }
}
