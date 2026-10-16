package com.bytedance.sdk.openadsdk.common;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.core.model.bf;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.utils.KM;

/* loaded from: classes3.dex */
public class nlS extends com.bytedance.sdk.openadsdk.core.ui.Os {
    protected boolean DbA;
    private Runnable MGA;
    private int Os;
    private long aGH;
    protected du eli;
    private boolean kb;
    private Runnable ui;
    private int wC;

    public nlS(Context context) {
        super(context);
        this.aGH = 10L;
        this.DbA = true;
        this.kb = false;
        this.wC = 1;
        Os();
    }

    private void Os() {
        setBackgroundColor(Color.parseColor("#2E2E2E"));
        setVisibility(8);
    }

    public void setOnlyLoading(boolean z) {
        this.kb = z;
    }

    public void eli(ev evVar) {
        bf QX;
        if (evVar != null && (QX = evVar.QX()) != null) {
            this.aGH = QX.eli();
        }
        du duVar = new du(getContext());
        this.eli = duVar;
        View eli = duVar.eli();
        if (eli.getParent() instanceof ViewGroup) {
            ((ViewGroup) eli.getParent()).removeView(eli);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        eli.setLayoutParams(layoutParams);
        if (evVar != null) {
            boolean OJ = evVar.OJ();
            com.bytedance.sdk.openadsdk.core.widget.dV DbA = this.eli.DbA();
            if (DbA != null) {
                if (this.kb || OJ) {
                    DbA.setVisibility(8);
                } else {
                    com.bytedance.sdk.openadsdk.core.model.nGm SjY = (evVar.SjY() == null || TextUtils.isEmpty(evVar.SjY().eli())) ? null : evVar.SjY();
                    if (SjY != null && !TextUtils.isEmpty(SjY.eli())) {
                        try {
                            com.bytedance.sdk.openadsdk.FC.aGH.eli(SjY).Os(1).eli(new com.bytedance.sdk.openadsdk.FC.DbA(evVar, SjY.eli(), new KM(DbA)));
                        } catch (Throwable unused) {
                        }
                    }
                    DbA.setVisibility(8);
                }
            }
            com.bytedance.sdk.openadsdk.core.ui.wC Os = this.eli.Os();
            if (Os != null) {
                if (this.kb || OJ) {
                    Os.setText("Loading");
                } else if (!TextUtils.isEmpty(evVar.Pf())) {
                    Os.setText(evVar.Pf());
                } else {
                    Os.setVisibility(8);
                }
            }
        }
        addView(eli);
        Os(getResources().getConfiguration().orientation);
    }

    public du getLoadingStyle() {
        return this.eli;
    }

    public void eli() {
        post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.common.nlS.1
            @Override // java.lang.Runnable
            public void run() {
                if (nlS.this.eli != null) {
                    nlS.this.setVisibility(0);
                }
            }
        });
        if (this.ui == null) {
            this.ui = new Runnable() { // from class: com.bytedance.sdk.openadsdk.common.nlS.2
                @Override // java.lang.Runnable
                public void run() {
                    nlS.this.DbA();
                }
            };
        }
        postDelayed(this.ui, this.aGH * 1000);
    }

    public void eli(int i) {
        if (i == 100 || Math.abs(i - this.Os) >= 7) {
            this.Os = i;
            if (com.bykv.vk.openvk.eli.eli.DbA.DbA.eli.eli()) {
                DbA(this.Os);
                return;
            }
            if (this.MGA == null) {
                this.MGA = new Runnable() { // from class: com.bytedance.sdk.openadsdk.common.nlS.3
                    @Override // java.lang.Runnable
                    public void run() {
                        nlS nls = nlS.this;
                        nls.DbA(nls.Os);
                    }
                };
            }
            post(this.MGA);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DbA(int i) {
        du duVar = this.eli;
        if (duVar != null) {
            duVar.eli(i);
        }
        if (i == 100 && this.DbA) {
            DbA();
        }
    }

    public void DbA() {
        this.Os = 0;
        du duVar = this.eli;
        if (duVar != null) {
            removeView(duVar.eli);
            this.eli.aGH();
        }
        setVisibility(8);
        this.eli = null;
        Runnable runnable = this.ui;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        Runnable runnable2 = this.MGA;
        if (runnable2 != null) {
            removeCallbacks(runnable2);
        }
        this.MGA = null;
        this.ui = null;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable runnable = this.ui;
        if (runnable != null) {
            removeCallbacks(runnable);
            this.ui = null;
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Os(configuration.orientation);
    }

    private void Os(int i) {
        if (this.wC != i) {
            this.wC = i;
        }
    }
}
