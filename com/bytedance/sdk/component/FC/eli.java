package com.bytedance.sdk.component.FC;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import com.bytedance.sdk.component.utils.FC;
import com.bytedance.sdk.component.utils.KM;
import com.bytedance.sdk.component.utils.Ue;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class eli extends Os implements Ue.eli {
    private final int DbA;
    private final Context MGA;
    private int NU;
    private final int Os;
    private String QX;
    private View.OnTouchListener Xb;
    private final List<Integer> aGH;
    private boolean aqO;
    private float dV;
    private long du;
    private volatile float kb;
    private float nGm;
    private long nlS;
    private final int ui;
    private volatile float wC;
    private float FC = -1.0f;
    private float aAs = -1.0f;
    private final Handler Dfc = new Ue(FC.eli().getLooper(), this);
    InterfaceC0132eli eli = new InterfaceC0132eli() { // from class: com.bytedance.sdk.component.FC.eli.1
        @Override // com.bytedance.sdk.component.FC.eli.InterfaceC0132eli
        public void eli() {
            if (eli.this.FC == -1.0f && eli.this.aAs == -1.0f && eli.this.nlS == -1) {
                new Object[]{"first trigger triggerJump()", ", mTriggerX: ", Float.valueOf(eli.this.FC), ", mTriggerY: ", Float.valueOf(eli.this.aAs)};
                eli eliVar = eli.this;
                eliVar.FC = eliVar.kb;
                eli eliVar2 = eli.this;
                eliVar2.aAs = eliVar2.wC;
                eli eliVar3 = eli.this;
                eliVar3.nlS = eliVar3.du;
                eli.this.aqO = true;
            }
            new Object[]{"everytime trigger triggerJump()", ", mTriggerX: ", Float.valueOf(eli.this.FC), ", mTriggerY: ", Float.valueOf(eli.this.aAs)};
        }

        @Override // com.bytedance.sdk.component.FC.eli.InterfaceC0132eli
        public void eli(int i) {
            eli.this.NU = i;
            eli.this.DbA();
        }
    };
    private int bf = -1;
    private final List<Integer> nn = new ArrayList();

    /* renamed from: com.bytedance.sdk.component.FC.eli$eli, reason: collision with other inner class name */
    public interface InterfaceC0132eli {
        void eli();

        void eli(int i);
    }

    public eli(Context context, int i, int i2, List<Integer> list, int i3) {
        this.MGA = context;
        if (i == -1) {
            this.DbA = KM.eli(context);
        } else {
            this.DbA = KM.eli(context, i);
        }
        this.Os = KM.eli(context, i2);
        this.aGH = list;
        this.ui = i3;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        eli eliVar;
        int action = motionEvent.getAction();
        new Object[]{"action: ", Integer.valueOf(action), ", x: ", Float.valueOf(motionEvent.getX()), ",y: ", Float.valueOf(motionEvent.getY())};
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        this.du = SystemClock.elapsedRealtime();
        this.kb = x;
        this.wC = y;
        if (action == 0) {
            eliVar = this;
            eliVar.dV = x;
            eliVar.nGm = y;
            new Object[]{"ACTION_DOWN: ", "downX: ", Float.valueOf(x), "downY: ", Float.valueOf(eliVar.nGm)};
        } else if (action != 1) {
            eliVar = this;
        } else {
            new Object[]{"ACTION_UP: ", "upX: ", Float.valueOf(x), "upY: ", Float.valueOf(y)};
            eliVar = this;
            if (eliVar.eli(x, y, this.dV, this.nGm, this.MGA)) {
                int eli = eli(eliVar.kb, eliVar.wC, eliVar.du);
                boolean contains = eliVar.nn.contains(Integer.valueOf(eliVar.NU));
                eli(view, motionEvent, eli, !contains);
                if (!contains) {
                    eliVar.nn.add(Integer.valueOf(eliVar.NU));
                }
                if (eli == 0) {
                    motionEvent.setAction(3);
                }
            }
        }
        View.OnTouchListener onTouchListener = eliVar.Xb;
        if (onTouchListener != null) {
            return onTouchListener.onTouch(view, motionEvent);
        }
        return false;
    }

    @Override // com.bytedance.sdk.component.FC.Os
    public void eli(View.OnTouchListener onTouchListener) {
        this.Xb = onTouchListener;
    }

    public InterfaceC0132eli eli() {
        return this.eli;
    }

    private void eli(View view, MotionEvent motionEvent, int i, boolean z) {
        String url;
        JSONObject jSONObject = new JSONObject();
        WebView webView = view instanceof WebView ? (WebView) view : null;
        if (webView != null) {
            try {
                url = webView.getUrl();
            } catch (Throwable unused) {
            }
        } else {
            url = "";
        }
        jSONObject.put("arbi_current_url", url);
        jSONObject.put("click_x", motionEvent.getX());
        jSONObject.put("click_y", motionEvent.getY());
        int i2 = 1;
        if (i != 0) {
            i2 = 0;
        }
        jSONObject.put("is_interceptor", i2);
        jSONObject.put("is_first_click", z ? 1 : 0);
        jSONObject.put("click_timestamp", System.currentTimeMillis());
        jSONObject.put("arbi_interceptor_type", i);
        jSONObject.put("current_url_index", this.NU);
        Message obtain = Message.obtain();
        obtain.what = 100;
        obtain.obj = jSONObject;
        this.Dfc.sendMessageDelayed(obtain, 200L);
    }

    public void eli(String str) {
        this.QX = str;
    }

    private int eli(float f, float f2, long j) {
        if (this.FC == -1.0f && this.aAs == -1.0f && this.nlS == -1) {
            return 1;
        }
        new Object[]{"mInterceptorPageList: ", this.aGH, "mPageIndex:", Integer.valueOf(this.NU)};
        if (!this.aGH.contains(Integer.valueOf(this.NU))) {
            return 2;
        }
        if (j - this.nlS > this.ui) {
            DbA();
            return 3;
        }
        float abs = Math.abs(f - this.FC);
        float abs2 = Math.abs(f2 - this.aAs);
        new Object[]{"mTouchX: ", Float.valueOf(f), ", mTriggerX : ", Float.valueOf(this.FC), " ,x distance：", Float.valueOf(abs)};
        new Object[]{"mTouchY: ", Float.valueOf(f2), ", mTriggerY: ", Float.valueOf(this.aAs), " ,y distance：", Float.valueOf(abs2)};
        new Object[]{"mInterceptorXPx: ", Integer.valueOf(this.DbA), ", mInterceptorYPx: ", Integer.valueOf(this.Os)};
        if (abs <= this.DbA / 2.0f && abs2 <= this.Os / 2.0f) {
            return 0;
        }
        DbA();
        return 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DbA() {
        this.FC = -1.0f;
        this.aAs = -1.0f;
        this.nlS = -1L;
    }

    @Override // com.bytedance.sdk.component.utils.Ue.eli
    public void eli(Message message) {
        int i = message.what;
        Object obj = message.obj;
        JSONObject jSONObject = new JSONObject();
        if (i == 100) {
            if (obj instanceof JSONObject) {
                jSONObject = (JSONObject) obj;
                try {
                    jSONObject.put("is_trigger_jump", this.aqO ? 1 : 0);
                    this.aqO = false;
                } catch (Throwable unused) {
                }
            }
            if (com.bytedance.sdk.component.FC.eli.eli.eli().DbA() != null) {
                com.bytedance.sdk.component.FC.eli.eli.eli().DbA().eli(this.QX, "arbitrage_click_event", jSONObject);
            }
        }
    }
}
