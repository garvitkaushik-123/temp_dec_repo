package com.bytedance.sdk.component.adexpress.ui;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.bytedance.sdk.component.FC.MGA;
import com.bytedance.sdk.component.eli.gG;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public class ui {
    private static volatile ui FC = null;
    private static int MGA = 10;
    private static final byte[] ui = new byte[0];
    private static int wC = 10;
    private final AtomicBoolean kb = new AtomicBoolean(false);
    private List<MGA> eli = new ArrayList();
    private List<MGA> DbA = new ArrayList();
    private Map<Integer, Os> Os = new HashMap();
    private Map<Integer, aGH> aGH = new HashMap();

    private ui() {
        com.bytedance.sdk.component.adexpress.eli.eli.Os Os = com.bytedance.sdk.component.adexpress.eli.eli.eli.eli().Os();
        if (Os != null) {
            MGA = Os.aAs();
            wC = Os.du();
        }
    }

    public static ui eli() {
        if (FC == null) {
            synchronized (ui.class) {
                if (FC == null) {
                    FC = new ui();
                }
            }
        }
        return FC;
    }

    public MGA eli(Context context, String str) {
        if (aGH() <= 0) {
            return null;
        }
        if (com.bytedance.sdk.component.adexpress.aGH.ui.eli(str) && aGH() <= 1) {
            new Object[]{"get WebView from newengine pool; but ad type is does not meet the requirement ", Integer.valueOf(aGH())};
            return null;
        }
        MGA remove = this.DbA.remove(0);
        if (remove == null) {
            return null;
        }
        try {
            Context context2 = remove.getContext();
            if (context2 instanceof MutableContextWrapper) {
                ((MutableContextWrapper) context2).setBaseContext(context.getApplicationContext());
                remove.setRecycler(false);
                new Object[]{"get WebView from newengine pool; current available count: ", Integer.valueOf(aGH())};
            }
            return remove;
        } catch (Throwable unused) {
            new Object[]{"get WebView from newengine pool exception; current available count: ", Integer.valueOf(aGH())};
            return null;
        }
    }

    public void eli(MGA mga) {
        if (mga == null) {
            return;
        }
        if (this.DbA.size() >= wC) {
            try {
                Context context = mga.getContext();
                if (context instanceof MutableContextWrapper) {
                    ((MutableContextWrapper) context).setBaseContext(context.getApplicationContext());
                }
                mga.aqO();
                return;
            } catch (Throwable th) {
                new Object[]{"WebView newengine pool is full，destroy webview ", th.getMessage()};
                return;
            }
        }
        if (this.DbA.contains(mga)) {
            return;
        }
        try {
            Context context2 = mga.getContext();
            if (context2 instanceof MutableContextWrapper) {
                ((MutableContextWrapper) context2).setBaseContext(context2.getApplicationContext());
                mga.setRecycler(true);
                this.DbA.add(mga);
                new Object[]{"recycle WebView newengine，current available count: ", Integer.valueOf(aGH())};
            }
        } catch (Throwable th2) {
            new Object[]{"recycle WebView newengine fail，current available count: ", Integer.valueOf(aGH()), "exception is ", th2.getMessage()};
        }
    }

    public void DbA(MGA mga) {
        if (mga == null) {
            return;
        }
        kb(mga);
        mga.b_("SDK_INJECT_GLOBAL");
        MGA(mga);
        eli(mga);
    }

    public MGA DbA(Context context, String str) {
        if (Os() <= 0) {
            return null;
        }
        if (com.bytedance.sdk.component.adexpress.aGH.ui.eli(str) && Os() <= 1) {
            new Object[]{"get WebView from pool; but ad type is does not meet the requirement ", Integer.valueOf(Os())};
            return null;
        }
        MGA remove = this.eli.remove(0);
        if (remove == null) {
            return null;
        }
        try {
            Context context2 = remove.getContext();
            if (context2 instanceof MutableContextWrapper) {
                ((MutableContextWrapper) context2).setBaseContext(context.getApplicationContext());
                remove.setRecycler(false);
                new Object[]{"get WebView from pool; current available count: ", Integer.valueOf(Os())};
            }
            return remove;
        } catch (Throwable unused) {
            new Object[]{"get WebView from pool exception; current available count: ", Integer.valueOf(Os())};
            return null;
        }
    }

    public void Os(MGA mga) {
        if (mga == null) {
            return;
        }
        kb(mga);
        mga.b_("SDK_INJECT_GLOBAL");
        MGA(mga);
        aGH(mga);
    }

    public void aGH(MGA mga) {
        if (mga == null) {
            return;
        }
        if (this.eli.size() >= MGA) {
            try {
                Context context = mga.getContext();
                if (context instanceof MutableContextWrapper) {
                    ((MutableContextWrapper) context).setBaseContext(context.getApplicationContext());
                }
                mga.aqO();
                return;
            } catch (Throwable th) {
                new Object[]{"WebView pool is full，destroy webview ", th.getMessage()};
                return;
            }
        }
        if (this.eli.contains(mga)) {
            return;
        }
        try {
            Context context2 = mga.getContext();
            if (context2 instanceof MutableContextWrapper) {
                ((MutableContextWrapper) context2).setBaseContext(context2.getApplicationContext());
                mga.setRecycler(true);
                this.eli.add(mga);
                new Object[]{"recycle WebView，current available count: ", Integer.valueOf(Os())};
            }
        } catch (Throwable th2) {
            new Object[]{"recycle WebView fail，current available count: ", Integer.valueOf(Os()), "exception is ", th2.getMessage()};
        }
    }

    public boolean ui(MGA mga) {
        if (mga == null) {
            return false;
        }
        try {
            Context context = mga.getContext();
            if (context instanceof MutableContextWrapper) {
                ((MutableContextWrapper) context).setBaseContext(context.getApplicationContext());
            }
            mga.aqO();
            return true;
        } catch (Throwable th) {
            new Object[]{"WebView abandon failed ", th.getMessage()};
            return true;
        }
    }

    public void DbA() {
        for (MGA mga : this.eli) {
            if (mga != null) {
                try {
                    Context context = mga.getContext();
                    if (context instanceof MutableContextWrapper) {
                        ((MutableContextWrapper) context).setBaseContext(context.getApplicationContext());
                    }
                    mga.aqO();
                } catch (Throwable th) {
                    new Object[]{"WebView clear failed ", th.getMessage()};
                }
            }
        }
        this.eli.clear();
        for (MGA mga2 : this.DbA) {
            if (mga2 != null) {
                try {
                    Context context2 = mga2.getContext();
                    if (context2 instanceof MutableContextWrapper) {
                        ((MutableContextWrapper) context2).setBaseContext(context2.getApplicationContext());
                    }
                    mga2.aqO();
                } catch (Throwable th2) {
                    new Object[]{"WebView newengine clear failed ", th2.getMessage()};
                }
            }
        }
        this.DbA.clear();
    }

    public int Os() {
        return this.eli.size();
    }

    public int aGH() {
        return this.DbA.size();
    }

    private void kb(MGA mga) {
        try {
            mga.removeAllViews();
            mga.kb();
            mga.setWebChromeClient(null);
            mga.setWebViewClient(null);
            mga.setDownloadListener(null);
            mga.setJavaScriptEnabled(true);
            mga.setCacheMode(-1);
            mga.setSupportZoom(false);
            mga.setUseWideViewPort(true);
            mga.setJavaScriptCanOpenWindowsAutomatically(true);
            mga.setDomStorageEnabled(true);
            mga.setBuiltInZoomControls(false);
            mga.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);
            mga.setLoadWithOverviewMode(false);
            mga.setDefaultTextEncodingName("UTF-8");
            mga.setDefaultFontSize(16);
        } catch (Throwable unused) {
        }
    }

    public void eli(MGA mga, DbA dbA) {
        if (mga == null || dbA == null) {
            return;
        }
        Os os = this.Os.get(Integer.valueOf(mga.hashCode()));
        if (os != null) {
            os.eli(dbA);
        } else {
            os = new Os(dbA);
            this.Os.put(Integer.valueOf(mga.hashCode()), os);
        }
        mga.eli(os, "SDK_INJECT_GLOBAL");
    }

    public void MGA(MGA mga) {
        if (mga == null) {
            return;
        }
        Os os = this.Os.get(Integer.valueOf(mga.hashCode()));
        if (os != null) {
            os.eli(null);
        }
        mga.b_("SDK_INJECT_GLOBAL");
    }

    public void eli(WebView webView, gG gGVar, String str) {
        if (webView == null || gGVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        aGH agh = this.aGH.get(Integer.valueOf(webView.hashCode()));
        if (agh != null) {
            agh.eli(gGVar);
        } else {
            agh = new aGH(gGVar);
            this.aGH.put(Integer.valueOf(webView.hashCode()), agh);
        }
        webView.addJavascriptInterface(agh, str);
    }

    public void eli(WebView webView, String str) {
        if (webView == null || TextUtils.isEmpty(str)) {
            return;
        }
        aGH agh = this.aGH.get(Integer.valueOf(webView.hashCode()));
        if (agh != null) {
            agh.eli(null);
        }
        webView.removeJavascriptInterface(str);
    }

    public void eli(int i) {
        synchronized (ui) {
            MGA = i;
        }
    }

    public void DbA(int i) {
        synchronized (ui) {
            wC = i;
        }
    }
}
