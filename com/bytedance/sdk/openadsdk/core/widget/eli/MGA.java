package com.bytedance.sdk.openadsdk.core.widget.eli;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ViewTreeObserver;
import android.webkit.WebBackForwardList;
import android.webkit.WebView;
import com.bytedance.sdk.component.utils.Ue;
import com.bytedance.sdk.component.utils.Xb;
import com.bytedance.sdk.openadsdk.Dfc.eli.eli;
import com.bytedance.sdk.openadsdk.core.dV;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.core.nn;
import com.bytedance.sdk.openadsdk.utils.SSo;
import com.ironsource.C3040d4;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public class MGA implements Ue.eli {
    ev DbA;
    float Dfc;
    String FC;
    private long GB;
    float NU;
    long QX;
    private final boolean Ue;
    int aAs;
    WebView aGH;
    long aqO;
    boolean dV;
    float du;
    Context eli;
    boolean kb;
    boolean nGm;
    float nlS;
    float nn;
    private boolean oWW;
    boolean wC;
    private final Handler ujq = new Ue(nn.DbA().getLooper(), this);
    String Os = "landingpage";
    int MGA = 0;
    private final String KM = ".*\\/serp\\?sc=.*&clkt=\\d+$";
    private final String VM = ".*\\/\\?caf_results=.*&clkt=\\d+$";
    eli Vy = new eli() { // from class: com.bytedance.sdk.openadsdk.core.widget.eli.MGA.1
        @Override // com.bytedance.sdk.openadsdk.core.widget.eli.MGA.eli
        public void eli() {
            MGA.this.wC = true;
            MGA.this.MGA();
            MGA mga = MGA.this;
            mga.eli(2, mga.FC, MGA.this.aAs);
        }
    };
    GestureDetector gG = new GestureDetector(dV.eli(), new GestureDetector.SimpleOnGestureListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.eli.MGA.2
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            MGA.this.dV = true;
            return false;
        }
    });
    int ui = dV.aGH().rH();
    Map<Integer, Long> Xb = new HashMap();
    Map<Integer, Float> bf = new HashMap();
    Map<Integer, Long> CMM = new HashMap();
    List<Integer> ev = new ArrayList();

    public interface eli {
        void eli();
    }

    public MGA(WebView webView, ev evVar, Context context, boolean z) {
        this.DbA = evVar;
        this.aGH = webView;
        this.eli = context;
        this.Ue = z;
    }

    public void eli(String str) {
        this.Os = str;
    }

    public void DbA(String str) {
        this.FC = str;
        wC();
        this.Xb.put(Integer.valueOf(this.aAs), Long.valueOf(SystemClock.elapsedRealtime()));
        this.CMM.put(Integer.valueOf(this.aAs), Long.valueOf(SystemClock.elapsedRealtime()));
        this.oWW = ui();
    }

    public void eli() {
        DbA(this.aAs);
    }

    public void eli(int i) {
        float height = (i + this.aGH.getHeight()) / SSo.DbA(this.eli, this.aGH.getContentHeight());
        Float f = this.bf.get(Integer.valueOf(this.aAs));
        float floatValue = f == null ? 0.0f : f.floatValue();
        new Object[]{"onScrollChange, oldPerUnBox is:", Float.valueOf(floatValue), ", browsingPer is:", Float.valueOf(height), ", index is: ", Integer.valueOf(this.aAs)};
        if (height > floatValue) {
            this.bf.put(Integer.valueOf(this.aAs), Float.valueOf(height));
        }
    }

    public void DbA() {
        this.aGH.getViewTreeObserver().addOnWindowFocusChangeListener(new ViewTreeObserver.OnWindowFocusChangeListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.eli.MGA.3
            @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
            public void onWindowFocusChanged(boolean z) {
                new Object[]{"trigger onWindowFocusChanged: ", Boolean.valueOf(z)};
                if (!z) {
                    if (!MGA.this.wC) {
                        MGA.this.MGA();
                        long elapsedRealtime = SystemClock.elapsedRealtime();
                        if (elapsedRealtime - MGA.this.GB >= 50) {
                            MGA mga = MGA.this;
                            mga.eli(3, mga.FC, MGA.this.aAs);
                            MGA.this.GB = elapsedRealtime;
                            return;
                        }
                        return;
                    }
                    MGA.this.wC = false;
                }
                if (z) {
                    MGA.this.wC();
                    MGA.this.Xb.put(Integer.valueOf(MGA.this.aAs), Long.valueOf(SystemClock.elapsedRealtime()));
                }
            }
        });
    }

    public void Os(String str) {
        if (this.kb) {
            this.nGm = true;
        }
        if (this.aAs == 1 && !TextUtils.isEmpty(str) && str.contains("query=")) {
            int indexOf = str.indexOf("query=") + 6;
            int indexOf2 = str.indexOf(C3040d4.i.c, indexOf);
            if (indexOf < 0 || indexOf2 >= str.length() || indexOf2 <= indexOf) {
                return;
            }
            aGH(str.substring(indexOf, indexOf2));
        }
    }

    public void eli(MotionEvent motionEvent) {
        this.gG.onTouchEvent(motionEvent);
        int action = motionEvent.getAction();
        if (action == 0) {
            this.du = motionEvent.getX();
            this.nlS = motionEvent.getY();
            this.aqO = SystemClock.elapsedRealtime();
        } else if (action != 1) {
            if (action != 3) {
                return;
            }
            Os(2);
        } else {
            this.QX = SystemClock.elapsedRealtime() - this.aqO;
            if (DbA(motionEvent)) {
                aGH();
            } else {
                Os(1);
            }
        }
    }

    public eli Os() {
        return this.Vy;
    }

    private void aGH(String str) {
        if (kb()) {
            return;
        }
        com.bytedance.sdk.openadsdk.aGH.Os.eli(this.DbA, new eli.C0156eli().eli(this.FC).DbA(Uri.decode(str)).eli(), this.Os);
    }

    private void DbA(int i) {
        if (kb() || this.ev.contains(Integer.valueOf(i))) {
            return;
        }
        this.ev.add(Integer.valueOf(i));
        long elapsedRealtime = SystemClock.elapsedRealtime();
        com.bytedance.sdk.openadsdk.aGH.Os.DbA(this.DbA, new eli.C0156eli().eli(this.FC).eli(this.aAs).aAs(elapsedRealtime - (this.CMM.get(Integer.valueOf(i)) != null ? r6.longValue() : elapsedRealtime)).eli(), this.Os);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eli(int i, String str, int i2) {
        if (kb()) {
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Long l = this.Xb.get(Integer.valueOf(i2));
        long longValue = l != null ? l.longValue() : elapsedRealtime;
        Float f = this.bf.get(Integer.valueOf(i2));
        com.bytedance.sdk.openadsdk.aGH.Os.Os(this.DbA, new eli.C0156eli().eli(str).eli(i2).wC(elapsedRealtime - longValue).FC(f == null ? 0.0f : f.floatValue()).DbA(i).eli(), this.Os);
    }

    private void aGH() {
        if (kb()) {
            return;
        }
        com.bytedance.sdk.openadsdk.Dfc.eli.eli eli2 = new eli.C0156eli().eli(this.FC).eli(this.aAs).aGH(this.du).ui(this.nlS).MGA(this.Dfc).kb(this.QX).eli();
        Message obtain = Message.obtain();
        obtain.what = 100;
        obtain.obj = eli2;
        this.ujq.sendMessageDelayed(obtain, 20L);
    }

    private void Os(int i) {
        if (kb()) {
            return;
        }
        MGA();
        this.kb = true;
        com.bytedance.sdk.openadsdk.Dfc.eli.eli eli2 = new eli.C0156eli().eli(this.FC).eli(this.aAs).eli(this.du).DbA(this.nlS).Os(this.QX).Os(i).eli();
        try {
            if (this.oWW) {
                WebView.HitTestResult hitTestResult = this.aGH.getHitTestResult();
                eli2.eli(hitTestResult.getExtra());
                eli2.eli(hitTestResult.getType());
            }
        } catch (Throwable unused) {
        }
        Message obtain = Message.obtain();
        obtain.what = 200;
        obtain.obj = eli2;
        this.ujq.sendMessageDelayed(obtain, 100L);
    }

    private boolean ui() {
        try {
            int i = this.aAs;
            if (i != 2 && i != 3) {
                return false;
            }
            if (Pattern.matches(".*\\/serp\\?sc=.*&clkt=\\d+$", this.FC)) {
                return true;
            }
            return Pattern.matches(".*\\/\\?caf_results=.*&clkt=\\d+$", this.FC);
        } catch (Throwable th) {
            Xb.Os("WebArbitrageBehavior", th.toString());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MGA() {
        if (this.bf.get(Integer.valueOf(this.aAs)) != null) {
            return;
        }
        float height = this.aGH.getHeight() / SSo.DbA(this.eli, this.aGH.getContentHeight());
        if (height < 0.0f || height > 1.0f) {
            height = 0.0f;
        }
        new Object[]{"initBrowsingPer, browsingPer is: ", Float.valueOf(height), "index is: ", Integer.valueOf(this.aAs)};
        this.bf.put(Integer.valueOf(this.aAs), Float.valueOf(height));
    }

    private boolean kb() {
        int i = this.MGA + 1;
        this.MGA = i;
        if (i > this.ui) {
            return true;
        }
        return ("landingpage".equals(this.Os) || "landingpage_endcard".equals(this.Os) || "landingpage_split_screen".equals(this.Os) || "landingpage_direct".equals(this.Os) || "landingpage_split_ceiling".equals(this.Os)) ? false : true;
    }

    private boolean DbA(MotionEvent motionEvent) {
        this.NU = motionEvent.getX();
        float y = motionEvent.getY();
        this.nn = y;
        float f = this.nlS;
        if (y - f == 0.0f) {
            return false;
        }
        this.Dfc = y - f;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wC() {
        WebBackForwardList copyBackForwardList = this.aGH.copyBackForwardList();
        if (copyBackForwardList != null) {
            int currentIndex = copyBackForwardList.getCurrentIndex();
            this.aAs = currentIndex + 1;
            if (this.Ue) {
                this.aAs = currentIndex + 2;
            }
        }
        new Object[]{"trigger onPageStarted, and index is: ", Integer.valueOf(this.aAs)};
    }

    @Override // com.bytedance.sdk.component.utils.Ue.eli
    public void eli(Message message) {
        int i = message.what;
        com.bytedance.sdk.openadsdk.Dfc.eli.eli eliVar = (com.bytedance.sdk.openadsdk.Dfc.eli.eli) message.obj;
        if (i == 100) {
            eliVar.aGH(this.dV ? 2 : 1);
            com.bytedance.sdk.openadsdk.aGH.Os.aGH(this.DbA, eliVar, this.Os);
            this.dV = false;
        } else if (i == 200) {
            if (this.nGm) {
                eli(1, eliVar.Os(), eliVar.aGH());
            }
            eliVar.Os(this.nGm ? 1 : 0);
            com.bytedance.sdk.openadsdk.aGH.Os.ui(this.DbA, eliVar, this.Os);
            this.kb = false;
            this.nGm = false;
        }
    }
}
