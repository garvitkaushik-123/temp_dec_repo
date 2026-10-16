package com.fyber.inneractive.sdk.click;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.fyber.inneractive.sdk.network.x0;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.f0;
import com.fyber.inneractive.sdk.util.i1;
import com.fyber.inneractive.sdk.util.j1;
import java.util.List;
import java.util.Locale;
import java.util.PriorityQueue;

/* loaded from: classes4.dex */
public final class d implements a {

    /* renamed from: a, reason: collision with root package name */
    public boolean f1058a = false;

    @Override // com.fyber.inneractive.sdk.click.a
    public final boolean a(Uri uri, r rVar) {
        return "smartlink".equalsIgnoreCase(uri.getScheme()) && !this.f1058a;
    }

    @Override // com.fyber.inneractive.sdk.click.a
    public final void cancel() {
        this.f1058a = true;
    }

    @Override // com.fyber.inneractive.sdk.click.a
    public final b a(Context context, Uri uri, List list) {
        Uri uri2;
        Uri uri3;
        boolean a2;
        if (!a(uri, null)) {
            return null;
        }
        PriorityQueue priorityQueue = new PriorityQueue();
        String queryParameter = uri.getQueryParameter("primaryUrl");
        List<String> queryParameters = uri.getQueryParameters("primaryTrackingUrl");
        i1 i1Var = i1.Primary;
        try {
            uri2 = Uri.parse(queryParameter);
        } catch (Exception unused) {
            uri2 = null;
        }
        if (uri2 != null) {
            priorityQueue.offer(new j1(i1Var, uri2, queryParameters));
        }
        String queryParameter2 = uri.getQueryParameter("fallbackUrl");
        List<String> queryParameters2 = uri.getQueryParameters("fallbackTrackingUrl");
        i1 i1Var2 = i1.FallBack;
        try {
            uri3 = Uri.parse(queryParameter2);
        } catch (Exception unused2) {
            uri3 = null;
        }
        if (uri3 != null) {
            priorityQueue.offer(new j1(i1Var2, uri3, queryParameters2));
        }
        if (priorityQueue.size() <= 0) {
            String uri4 = uri.toString();
            q qVar = q.DEEP_LINK;
            if (list != null) {
                list.add(new j(uri4, false, qVar, null));
            }
            return r.a(uri.toString(), "FyberDeepLink", "fyberDeepLink is not valid");
        }
        do {
            j1 j1Var = (j1) priorityQueue.poll();
            if (j1Var == null) {
                return r.a(uri.toString(), "FyberDeepLink", "IADeeplinkUtil.tryHandleDeepLinkWithExternalApp has failed");
            }
            Uri uri5 = j1Var.b;
            String scheme = uri5.getScheme();
            q qVar2 = (TextUtils.isEmpty(scheme) || !scheme.toLowerCase(Locale.US).startsWith("http")) ? q.OPEN_IN_EXTERNAL_APPLICATION : q.OPENED_IN_EXTERNAL_BROWSER;
            a2 = f0.a(context, new Intent("android.intent.action.VIEW", uri5));
            String uri6 = uri5.toString();
            if (list != null) {
                list.add(new j(uri6, a2, qVar2, null));
            }
            if (a2) {
                for (String str : j1Var.c) {
                    if (!TextUtils.isEmpty(str)) {
                        IAlog.d("%s %s", "SMART_LINK", str);
                        x0.b(str);
                    }
                }
            }
        } while (!a2);
        return new b(uri.toString(), q.OPEN_IN_EXTERNAL_APPLICATION, "FyberDeepLink", null);
    }
}
