package com.fyber.inneractive.sdk.click;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.fyber.inneractive.sdk.activities.InneractiveInternalBrowserActivity;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.b0;
import com.fyber.inneractive.sdk.util.c0;
import com.fyber.inneractive.sdk.util.d0;
import com.fyber.inneractive.sdk.util.e0;
import com.fyber.inneractive.sdk.util.f0;
import java.util.List;

/* loaded from: classes4.dex */
public final class i implements a {

    /* renamed from: a, reason: collision with root package name */
    public final String f1062a;
    public final boolean b;
    public boolean c = false;

    public i(boolean z, String str) {
        this.f1062a = str;
        this.b = z;
    }

    @Override // com.fyber.inneractive.sdk.click.a
    public final boolean a(Uri uri, r rVar) {
        if (this.c) {
            return false;
        }
        return "fybernativebrowser".equalsIgnoreCase(uri.getScheme()) || "fybernativebrowser".equalsIgnoreCase(this.f1062a) || this.b || uri.toString().contains("FYBER_OPEN_BROWSER");
    }

    @Override // com.fyber.inneractive.sdk.click.a
    public final void cancel() {
        this.c = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0035 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.fyber.inneractive.sdk.click.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final b a(Context context, Uri uri, List list) {
        String str;
        b0 b0Var;
        String uri2 = uri.toString();
        if (!TextUtils.isEmpty(uri2)) {
            Uri parse = Uri.parse(uri2);
            String scheme = parse.getScheme();
            String host = parse.getHost();
            if (scheme != null && scheme.equals("fybernativebrowser") && host != null && host.equals("navigate")) {
                str = parse.getQueryParameter("url");
                if (str != null) {
                    try {
                        uri = Uri.parse(str);
                    } catch (Exception unused) {
                        IAlog.a("IAJavaUtil: getValidUri: Invalid url %s", str);
                        uri = null;
                    }
                    uri2 = str;
                }
                if (!this.c) {
                    return r.a(uri.toString(), null, "The process was cancelled");
                }
                d0 d0Var = d0.OPEN_EVERYTHING;
                try {
                    context.getClass();
                } catch (Throwable unused2) {
                }
                try {
                    IAlog.a("IAJavaUtil - valid url found: '%s' opening browser", uri2);
                    try {
                        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(uri2));
                        if (!(context instanceof Activity)) {
                            intent.setFlags(268435456);
                        }
                        context.startActivity(intent);
                        b0Var = new b0(e0.OPEN_IN_EXTERNAL_BROWSER, null);
                    } catch (ActivityNotFoundException unused3) {
                        if (f0.a(context, uri2)) {
                            b0Var = new b0(e0.OPENED_USING_CHROME_NAVIGATE, null);
                        } else {
                            b0Var = new b0(e0.FAILED, new c0("tryOpeningChromeGracefully has failed and couldn't open the url"));
                        }
                    } catch (Throwable unused4) {
                        if (!f0.d(uri2) && !f0.c(uri2) && d0Var != d0.DO_NOT_OPEN_IN_INTERNAL_BROWSER) {
                            Intent intent2 = new Intent(context, (Class<?>) InneractiveInternalBrowserActivity.class);
                            intent2.putExtra(InneractiveInternalBrowserActivity.URL_EXTRA, uri2);
                            intent2.putExtra("spotId", (String) null);
                            if (!(context instanceof Activity)) {
                                intent2.setFlags(268435456);
                            }
                            context.startActivity(intent2);
                            b0Var = new b0(e0.OPENED_IN_INTERNAL_BROWSER, null);
                        } else {
                            b0Var = new b0(e0.FAILED, new c0("canOpenInExternalBrowser has decided it cant be opened and shouldUseInternalBrowser was set to true"));
                        }
                    }
                } catch (Throwable th) {
                    IAlog.a("IAJavaUtil - could not open a browser for url: %s", uri2);
                    b0Var = new b0(e0.FAILED, th);
                }
                if (list != null) {
                    Throwable th2 = b0Var.b;
                    if (th2 != null) {
                        list.add(new j(uri2, false, null, th2.toString()));
                    } else {
                        list.add(new j(uri2, true, q.OPENED_IN_EXTERNAL_BROWSER, null));
                    }
                }
                return new b(uri.toString(), q.OPENED_IN_EXTERNAL_BROWSER, "FyberNativeBrowser", null);
            }
        }
        str = null;
        if (str != null) {
        }
        if (!this.c) {
        }
    }
}
