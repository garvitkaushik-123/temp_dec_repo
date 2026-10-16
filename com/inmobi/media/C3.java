package com.inmobi.media;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import com.inmobi.commons.core.configs.TelemetryConfig;
import java.net.URISyntaxException;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public abstract class C3 {
    public static int a(Context context, String url, InterfaceC2961yb redirectionValidator, String api, InterfaceC2971z5 interfaceC2971z5) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(redirectionValidator, "redirectionValidator");
        Intrinsics.checkNotNullParameter(api, "api");
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).c("DeeplinkHandler", "In appLinkOrDeepLinkHandled");
        }
        if (url.length() == 0) {
            if (interfaceC2971z5 == null) {
                return 2;
            }
            ((A5) interfaceC2971z5).c("DeeplinkHandler", "AppLink url is Empty or null");
            return 2;
        }
        try {
            List b = AbstractC2968z2.b(context, url);
            if (!b.isEmpty()) {
                if (interfaceC2971z5 != null) {
                    ((A5) interfaceC2971z5).c("DeeplinkHandler", "Resolve Info " + ((ResolveInfo) b.get(0)).activityInfo.name);
                }
                return a(context, url, (ResolveInfo) b.get(0), redirectionValidator, api, interfaceC2971z5);
            }
            if (interfaceC2971z5 != null) {
                ((A5) interfaceC2971z5).c("DeeplinkHandler", " Resolve Info Empty");
            }
            try {
                return AbstractC2968z2.a(context, url, redirectionValidator, api);
            } catch (ActivityNotFoundException unused) {
                return a(context, url, null, redirectionValidator, api, interfaceC2971z5);
            } catch (NullPointerException unused2) {
                return a(context, url, null, redirectionValidator, api, interfaceC2971z5);
            } catch (SecurityException unused3) {
                if (interfaceC2971z5 != null) {
                    ((A5) interfaceC2971z5).b("DeeplinkHandler", "SecurityException");
                }
                return 12;
            } catch (URISyntaxException unused4) {
                if (interfaceC2971z5 != null) {
                    ((A5) interfaceC2971z5).b("DeeplinkHandler", "uriSyntaxException");
                }
                return 5;
            } catch (Exception e) {
                if (interfaceC2971z5 != null) {
                    ((A5) interfaceC2971z5).b("DeeplinkHandler", "Exception: " + e);
                }
                return 9;
            }
        } catch (URISyntaxException unused5) {
            if (interfaceC2971z5 != null) {
                ((A5) interfaceC2971z5).b("DeeplinkHandler", "URISyntaxException for url: ".concat(url));
            }
            return 5;
        }
    }

    public static boolean a(String url, Context context, InterfaceC2961yb redirectionValidator, InterfaceC2971z5 interfaceC2971z5) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(redirectionValidator, "redirectionValidator");
        if (!L3.f2348a.z() || !redirectionValidator.a()) {
            return false;
        }
        LinkedHashMap linkedHashMap = O2.f2380a;
        if (!((TelemetryConfig) AbstractC2808p5.a("telemetry", "null cannot be cast to non-null type com.inmobi.commons.core.configs.TelemetryConfig", null)).getLpConfig().getUniversalLinkEnabled()) {
            return false;
        }
        try {
            Uri parse = Uri.parse(url);
            Intrinsics.checkNotNullExpressionValue(parse, "Uri.parse(this)");
            Intent intent = new Intent("android.intent.action.VIEW", parse);
            Intrinsics.checkNotNullParameter(intent, "<this>");
            intent.addCategory("android.intent.category.BROWSABLE");
            Intrinsics.checkNotNullParameter(intent, "<this>");
            intent.setFlags(268436992);
            Intrinsics.checkNotNullParameter(intent, "<this>");
            Intrinsics.checkNotNullParameter(context, "context");
            context.startActivity(intent);
            if (interfaceC2971z5 == null) {
                return true;
            }
            ((A5) interfaceC2971z5).a("DeeplinkHandler", "openDefaultApplication: SUCCESS");
            return true;
        } catch (ActivityNotFoundException unused) {
            if (interfaceC2971z5 != null) {
                ((A5) interfaceC2971z5).b("DeeplinkHandler", "openDefaultApplication: ActivityNotFoundException");
            }
            return false;
        } catch (NullPointerException unused2) {
            if (interfaceC2971z5 != null) {
                ((A5) interfaceC2971z5).b("DeeplinkHandler", "openDefaultApplication: NullPointerException");
            }
            return false;
        }
    }

    public static int a(Context context, String str, ResolveInfo resolveInfo, InterfaceC2961yb interfaceC2961yb, String str2, InterfaceC2971z5 interfaceC2971z5) {
        try {
            return AbstractC2968z2.a(context, str, resolveInfo, interfaceC2961yb, str2);
        } catch (ActivityNotFoundException unused) {
            if (interfaceC2971z5 != null) {
                ((A5) interfaceC2971z5).b("DeeplinkHandler", AbstractC2673h0.a("ActivityNotFoundException for url: ", str));
            }
            return 6;
        } catch (NullPointerException unused2) {
            if (interfaceC2971z5 != null) {
                ((A5) interfaceC2971z5).b("DeeplinkHandler", AbstractC2673h0.a("NullPointerException for url: ", str));
            }
            return 13;
        } catch (SecurityException unused3) {
            if (interfaceC2971z5 != null) {
                ((A5) interfaceC2971z5).b("DeeplinkHandler", AbstractC2673h0.a("SecurityException for url: ", str));
            }
            return 12;
        } catch (URISyntaxException unused4) {
            if (interfaceC2971z5 != null) {
                ((A5) interfaceC2971z5).b("DeeplinkHandler", AbstractC2673h0.a("URISyntaxException for url: ", str));
            }
            return 5;
        } catch (Exception e) {
            if (interfaceC2971z5 != null) {
                ((A5) interfaceC2971z5).b("DeeplinkHandler", "Exception: " + e);
            }
            return 9;
        }
    }
}
