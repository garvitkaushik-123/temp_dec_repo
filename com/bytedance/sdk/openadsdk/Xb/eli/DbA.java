package com.bytedance.sdk.openadsdk.Xb.eli;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.nlS.MGA;
import com.bytedance.sdk.openadsdk.utils.SSo;

/* loaded from: classes3.dex */
public class DbA extends eli {
    private volatile boolean DbA;
    private String MGA;
    private MGA Os;
    private final FrameLayout aGH;
    private FrameLayout ui;

    public DbA(Context context, ev evVar, int i, boolean z, FrameLayout frameLayout, String str) {
        super(context, evVar, i, z, frameLayout);
        this.aGH = frameLayout;
        this.MGA = str;
        DbA(false);
        int Os = SSo.Os(context);
        int ui = SSo.ui(context);
        if (i == 1) {
            if (Os <= ui) {
                this.eli.layout(0, 0, Os, ui);
                return;
            }
        } else {
            if (i != 2) {
                return;
            }
            if (Os > ui) {
                this.eli.layout(0, 0, Os, ui);
                return;
            }
        }
        this.eli.layout(0, 0, ui, Os);
    }

    public void kb() {
        super.eli(true, new MGA() { // from class: com.bytedance.sdk.openadsdk.Xb.eli.DbA.1
            @Override // com.bytedance.sdk.openadsdk.nlS.MGA
            public void eli() {
                if (DbA.this.Os != null) {
                    DbA.this.Os.eli();
                } else {
                    DbA.this.DbA = true;
                }
            }
        });
    }

    public void eli(FrameLayout frameLayout, MGA mga) {
        this.ui = frameLayout;
        frameLayout.addView(this.aGH);
        this.Os = mga;
        if (this.DbA) {
            this.Os.eli();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.Xb.eli.eli
    public void eli() {
        this.ui.setVisibility(0);
        super.eli();
    }

    public String wC() {
        return this.MGA;
    }
}
