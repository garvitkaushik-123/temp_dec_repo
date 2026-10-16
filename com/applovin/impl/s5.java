package com.applovin.impl;

import android.text.TextUtils;
import android.webkit.URLUtil;
import com.applovin.impl.b0;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public class s5 extends g5 {
    private final b g;

    public interface b {
        void a(b0.b bVar);

        void a(String str);
    }

    public s5(com.applovin.impl.sdk.k kVar, b bVar) {
        super("TaskFetchDeveloperUri", kVar);
        this.g = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        String valueOf = String.valueOf(this.f464a.B().E().get("package_name"));
        if (com.applovin.impl.sdk.o.a()) {
            this.c.a(this.b, "Looking up developer URI for package name: " + valueOf);
        }
        this.f464a.r0().a(new a(com.applovin.impl.sdk.network.a.a(this.f464a).c("GET").b("https://play.google.com/store/apps/details?id=" + valueOf).a((Object) "").a(false).a(), this.f464a));
    }

    class a extends j6 {
        a(com.applovin.impl.sdk.network.a aVar, com.applovin.impl.sdk.k kVar) {
            super(aVar, kVar);
        }

        @Override // com.applovin.impl.j6, com.applovin.impl.q0.e
        public void a(String str, String str2, int i) {
            if (TextUtils.isEmpty(str2)) {
                if (com.applovin.impl.sdk.o.a()) {
                    this.c.b(this.b, "No developer URI found - response from the Play Store is empty");
                }
                s5.this.g.a(b0.b.APP_DETAILS_NOT_FOUND);
                return;
            }
            Matcher matcher = Pattern.compile("(?<=\"appstore:developer_url\" content=\").*?(?=\">)").matcher(str2);
            if (!matcher.find()) {
                if (com.applovin.impl.sdk.o.a()) {
                    this.c.b(this.b, "No developer URI found - unable to find the developer_url meta tag from the Play Store listing");
                }
                s5.this.g.a(b0.b.INVALID_DEVELOPER_URI);
                return;
            }
            String group = matcher.group();
            if (!URLUtil.isValidUrl(group)) {
                if (com.applovin.impl.sdk.o.a()) {
                    this.c.b(this.b, "Developer URI (" + group + ") is not valid");
                }
                s5.this.g.a(b0.b.INVALID_DEVELOPER_URI);
            } else {
                if (com.applovin.impl.sdk.o.a()) {
                    this.c.a(this.b, "Found developer URI: " + group);
                }
                s5.this.g.a(group);
            }
        }

        @Override // com.applovin.impl.j6, com.applovin.impl.q0.e
        public void a(String str, int i, String str2, String str3) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.b(this.b, "Unable to fetch app details due to: " + str2 + ", and received error code: " + i);
            }
            s5.this.g.a(b0.b.APP_DETAILS_NOT_FOUND);
        }
    }
}
