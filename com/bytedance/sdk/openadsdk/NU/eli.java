package com.bytedance.sdk.openadsdk.NU;

import android.R;
import android.app.Activity;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.adjust.sdk.Constants;
import com.bykv.vk.openvk.preload.geckox.model.WebResourceResponseModel;
import com.bytedance.sdk.component.FC.MGA;
import com.bytedance.sdk.openadsdk.aGH.nlS;
import com.bytedance.sdk.openadsdk.core.Dfc;
import com.bytedance.sdk.openadsdk.core.dV;
import com.bytedance.sdk.openadsdk.core.model.QX;
import com.bytedance.sdk.openadsdk.core.model.Xb;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.core.qj;
import com.bytedance.sdk.openadsdk.core.widget.eli.Os;
import com.bytedance.sdk.openadsdk.core.widget.eli.aGH;
import com.bytedance.sdk.openadsdk.core.widget.eli.ui;
import com.bytedance.sdk.openadsdk.kb.DbA;
import com.bytedance.sdk.openadsdk.utils.SSo;
import com.bytedance.sdk.openadsdk.utils.bf;
import com.bytedance.sdk.openadsdk.utils.cyF;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class eli {
    private static int Os = 2;
    private static long aGH = 3600000;
    private static volatile eli eli;
    private final Handler DbA;
    private LinkedHashMap<Integer, SoftReference<MGA>> ui;

    public static eli eli() {
        if (eli == null) {
            synchronized (eli.class) {
                if (eli == null) {
                    eli = new eli();
                }
            }
        }
        return eli;
    }

    public eli() {
        Os = com.bytedance.sdk.openadsdk.bf.eli.eli("pre_render_count", 2);
        long eli2 = com.bytedance.sdk.openadsdk.bf.eli.eli("pre_render_duration", Constants.ONE_HOUR);
        aGH = eli2;
        if (Os <= 0) {
            Os = 2;
        }
        if (eli2 <= 0) {
            aGH = 3600000L;
        }
        this.ui = new LinkedHashMap<>();
        this.DbA = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.bytedance.sdk.openadsdk.NU.eli.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                SoftReference softReference;
                int i = message.what;
                if (eli.this.ui == null || (softReference = (SoftReference) eli.this.ui.get(Integer.valueOf(i))) == null) {
                    return false;
                }
                MGA mga = (MGA) softReference.get();
                eli.this.eli(i, 2, new ev(), mga == null ? "" : mga.getTag());
                return false;
            }
        });
    }

    public void eli(final ev evVar) {
        final String str;
        if (evVar == null || !Os(evVar)) {
            return;
        }
        QX bf = evVar.bf();
        if (bf == null) {
            bf = new QX();
        }
        new Object[]{"open pre render:", Boolean.valueOf(evVar.SE())};
        if (evVar.SE()) {
            String dM = evVar.dM();
            if (TextUtils.isEmpty(dM)) {
                return;
            }
            final int hashCode = dM.hashCode();
            if (Xb.DbA(evVar)) {
                str = "landingpage_split_screen";
            } else if (Xb.aGH(evVar)) {
                str = "landingpage_direct";
            } else if (!Xb.Os(evVar)) {
                str = "";
            } else {
                str = "landingpage_split_ceiling";
            }
            LinkedHashMap<Integer, SoftReference<MGA>> linkedHashMap = this.ui;
            if (linkedHashMap == null || !linkedHashMap.containsKey(Integer.valueOf(hashCode))) {
                HashMap hashMap = new HashMap();
                hashMap.put(evVar.QxD(), evVar);
                if (bf.DbA() == 2) {
                    DbA.eli().eli((Map<String, ev>) hashMap, new DbA.eli() { // from class: com.bytedance.sdk.openadsdk.NU.eli.2
                        @Override // com.bytedance.sdk.openadsdk.kb.DbA.eli
                        public void eli() {
                            eli.this.eli(hashCode, evVar, str, true);
                        }
                    }, true);
                    return;
                }
                if (bf.DbA() == 1) {
                    DbA.eli().eli((Map<String, ev>) hashMap, (DbA.eli) null, true);
                    eli(hashCode, evVar, str, true);
                } else if (bf.DbA() == 0) {
                    eli(hashCode, evVar, str, false);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eli(final int i, final ev evVar, final String str, final boolean z) {
        new Object[]{"begin pre render, useGecko", Boolean.valueOf(z)};
        cyF.eli(new Runnable() { // from class: com.bytedance.sdk.openadsdk.NU.eli.3
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.utils.eli ui;
                Activity DbA;
                if (eli.this.ui != null && eli.this.ui.size() >= eli.Os) {
                    Map.Entry entry = (Map.Entry) eli.this.ui.entrySet().iterator().next();
                    SoftReference softReference = (SoftReference) entry.getValue();
                    if (softReference != null) {
                        MGA mga = (MGA) softReference.get();
                        eli.this.eli(((Integer) entry.getKey()).intValue(), 1, evVar, mga == null ? "" : mga.getTag());
                    }
                }
                if (eli.this.DbA != null) {
                    Message obtain = Message.obtain();
                    obtain.what = i;
                    eli.this.DbA.sendMessageDelayed(obtain, eli.aGH);
                }
                SoftReference softReference2 = new SoftReference(new MGA(dV.eli(), false));
                final MGA mga2 = (MGA) softReference2.get();
                if (mga2 == null) {
                    return;
                }
                qj qjVar = null;
                mga2.setLayerType(2, null);
                SSo.eli((View) mga2, 4);
                mga2.setTag(str);
                mga2.setLandingPage(true);
                QX bf = evVar.bf();
                int eli2 = bf != null ? bf.eli() : 3;
                if (eli2 == 2) {
                    int Os2 = SSo.Os(dV.eli());
                    int ui2 = SSo.ui(dV.eli());
                    int WO = evVar.WO();
                    if (WO == 1) {
                        if (Os2 >= ui2) {
                            mga2.layout(0, 0, ui2, Os2);
                        }
                        mga2.layout(0, 0, Os2, ui2);
                    } else if (WO == 2) {
                        if (Os2 < ui2) {
                            mga2.layout(0, 0, ui2, Os2);
                        }
                        mga2.layout(0, 0, Os2, ui2);
                    }
                } else if (eli2 == 1 && (ui = Dfc.eli().ui()) != null && (DbA = ui.DbA()) != null) {
                    final int hashCode = DbA.hashCode();
                    ui.eli(new com.bytedance.sdk.component.adexpress.eli() { // from class: com.bytedance.sdk.openadsdk.NU.eli.3.1
                        @Override // com.bytedance.sdk.component.adexpress.eli
                        public void eli(Activity activity) {
                            int i2 = hashCode;
                            if (i2 == 0 || activity == null || i2 != activity.hashCode() || mga2.Os()) {
                                return;
                            }
                            eli.this.eli(i, 5, evVar, str);
                        }
                    });
                    FrameLayout frameLayout = (FrameLayout) DbA.findViewById(R.id.content);
                    if (frameLayout != null) {
                        frameLayout.addView(mga2);
                    }
                }
                int eli3 = DbA.eli().eli(DbA.eli().DbA(), evVar.QxD());
                nlS nls = new nlS(evVar, mga2.getWebView());
                nls.eli(eli3 > 0 ? 2 : 0);
                nls.eli(true);
                nls.DbA(true);
                mga2.setWebViewClient(eli(mga2, nls));
                mga2.setWebChromeClient(new aGH(qjVar, nls) { // from class: com.bytedance.sdk.openadsdk.NU.eli.3.2
                    @Override // com.bytedance.sdk.openadsdk.core.widget.eli.aGH, android.webkit.WebChromeClient
                    public void onProgressChanged(WebView webView, int i2) {
                        super.onProgressChanged(webView, i2);
                        if (i2 == 100) {
                            mga2.setPreProgressHundred(true);
                        }
                    }
                });
                eli.this.eli(mga2, evVar.dM());
                eli.eli(evVar, str, Double.valueOf((System.currentTimeMillis() / 1000) - evVar.QP()).floatValue(), "web_start_pre_render");
                if (eli.this.ui != null) {
                    eli.this.ui.put(Integer.valueOf(i), softReference2);
                }
            }

            private ui eli(final MGA mga, nlS nls) {
                ui uiVar = new ui(dV.eli(), null, evVar.umh(), nls, true) { // from class: com.bytedance.sdk.openadsdk.NU.eli.3.3
                    @Override // com.bytedance.sdk.openadsdk.core.widget.eli.ui, android.webkit.WebViewClient
                    public boolean shouldOverrideUrlLoading(WebView webView, String str2) {
                        return super.shouldOverrideUrlLoading(webView, str2);
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.widget.eli.ui, android.webkit.WebViewClient
                    public void onPageFinished(WebView webView, String str2) {
                        MGA mga2 = mga;
                        if (mga2 != null) {
                            mga2.setPreFinish(true);
                        }
                        super.onPageFinished(webView, str2);
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.widget.eli.ui, android.webkit.WebViewClient
                    public void onPageStarted(WebView webView, String str2, Bitmap bitmap) {
                        MGA mga2 = mga;
                        if (mga2 != null) {
                            mga2.setPreStart(true);
                        }
                        super.onPageStarted(webView, str2, bitmap);
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.widget.eli.ui, android.webkit.WebViewClient
                    public void onReceivedError(WebView webView, int i2, String str2, String str3) {
                        String aGH2 = aGH(str3);
                        boolean z2 = aGH2 != null && aGH2.startsWith("image");
                        boolean z3 = aGH2 != null && aGH2.startsWith("mp4");
                        if (!z2 && !z3 && !mga.Os()) {
                            eli.this.eli(i, 4, evVar, str);
                        }
                        super.onReceivedError(webView, i2, str2, str3);
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.widget.eli.ui, android.webkit.WebViewClient
                    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                        if (sslErrorHandler != null) {
                            eli.this.eli(i, 4, evVar, str);
                        }
                        super.onReceivedSslError(webView, sslErrorHandler, sslError);
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.widget.eli.ui, android.webkit.WebViewClient
                    public WebResourceResponse shouldInterceptRequest(WebView webView, String str2) {
                        try {
                            if (!z) {
                                return super.shouldInterceptRequest(webView, str2);
                            }
                            MGA mga2 = mga;
                            if (mga2 != null) {
                                mga2.eli++;
                            }
                            WebResourceResponseModel eli2 = DbA.eli().eli(DbA.eli().DbA(), evVar.QxD(), str2);
                            if (eli2 != null && eli2.getWebResourceResponse() != null) {
                                MGA mga3 = mga;
                                if (mga3 != null) {
                                    mga3.DbA++;
                                }
                                return eli2.getWebResourceResponse();
                            }
                            if (mga != null && eli2 != null && eli2.getMsg() == 2) {
                                mga.Os++;
                            }
                            return super.shouldInterceptRequest(webView, str2);
                        } catch (Throwable unused) {
                            return super.shouldInterceptRequest(webView, str2);
                        }
                    }
                };
                uiVar.eli(evVar);
                uiVar.eli(str);
                return uiVar;
            }
        });
    }

    public MGA DbA(ev evVar) {
        if (evVar == null || TextUtils.isEmpty(evVar.dM())) {
            return null;
        }
        String dM = evVar.dM();
        if (TextUtils.isEmpty(dM)) {
            return null;
        }
        int hashCode = dM.hashCode();
        SoftReference<MGA> softReference = this.ui.get(Integer.valueOf(hashCode));
        if (softReference == null || softReference.get() == null) {
            return null;
        }
        MGA mga = softReference.get();
        eli(evVar, mga.getTag(), Double.valueOf((System.currentTimeMillis() / 1000) - evVar.QP()).floatValue(), "web_use_pre_render");
        eli(hashCode, 3, evVar, mga.getTag());
        return mga;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eli(int i, int i2, ev evVar, String str) {
        LinkedHashMap<Integer, SoftReference<MGA>> linkedHashMap = this.ui;
        if (linkedHashMap != null && linkedHashMap.containsKey(Integer.valueOf(i))) {
            this.ui.remove(Integer.valueOf(i));
        }
        Handler handler = this.DbA;
        if (handler != null) {
            handler.removeMessages(i);
        }
        eli(evVar, str, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eli(MGA mga, String str) {
        if (mga == null) {
            return;
        }
        Os.eli(dV.eli()).eli(false).DbA(false).eli(mga.getWebView());
        mga.setMixedContentMode(0);
        new Object[]{"begin to render,url is", str};
        bf.eli(mga, str);
    }

    public static boolean Os(ev evVar) {
        return Xb.MGA(evVar) || Xb.DbA(evVar) || Xb.Os(evVar);
    }

    public static void eli(ev evVar, String str, final float f, String str2) {
        com.bytedance.sdk.openadsdk.aGH.Os.eli(System.currentTimeMillis(), evVar, str, str2, new com.bytedance.sdk.openadsdk.Dfc.Os.eli() { // from class: com.bytedance.sdk.openadsdk.NU.eli.4
            @Override // com.bytedance.sdk.openadsdk.Dfc.Os.eli
            public JSONObject eli() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("duration", f);
                } catch (Throwable unused) {
                }
                new Object[]{"onWebPreRender", Float.valueOf(f)};
                return jSONObject;
            }
        });
    }

    public static void eli(ev evVar, final String str, final int i) {
        com.bytedance.sdk.openadsdk.aGH.Os.eli(System.currentTimeMillis(), evVar, str, "web_delete_pre_render", new com.bytedance.sdk.openadsdk.Dfc.Os.eli() { // from class: com.bytedance.sdk.openadsdk.NU.eli.5
            @Override // com.bytedance.sdk.openadsdk.Dfc.Os.eli
            public JSONObject eli() {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("reason", i);
                    jSONObject2.put("pag_json_data", jSONObject3.toString());
                    jSONObject.put("ad_extra_data", jSONObject2.toString());
                } catch (Throwable unused) {
                }
                new Object[]{"onDeletePreRenderWeb", jSONObject2.toString(), str};
                return jSONObject;
            }
        });
    }
}
