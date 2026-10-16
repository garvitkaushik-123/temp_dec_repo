package com.bytedance.sdk.openadsdk.common;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.Os.aAs;
import com.bytedance.sdk.openadsdk.Os.nlS;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.utils.SSo;

/* loaded from: classes3.dex */
public class Dfc extends com.bytedance.sdk.openadsdk.core.ui.Os implements aAs.DbA {
    private ev DbA;
    private boolean MGA;
    private eli Os;
    private Context aGH;
    private View eli;
    private final com.bytedance.sdk.openadsdk.Os.aAs kb;
    private String ui;

    public interface eli {
        void DbA(View view);

        void eli(View view);

        void eli(FilterWord filterWord);
    }

    public Dfc(Context context, ev evVar) {
        this(context.getApplicationContext());
        this.DbA = evVar;
        this.aGH = context;
        aGH();
        ui();
    }

    private void aGH() {
        this.kb.eli(this.DbA.eu());
        this.kb.eli(this);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Dfc(Context context) {
        this(context, (AttributeSet) null);
    }

    public Dfc(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public Dfc(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.MGA = false;
        this.kb = new com.bytedance.sdk.openadsdk.Os.aAs();
        eli(context, attributeSet);
    }

    private void eli(Context context, AttributeSet attributeSet) {
        setClickable(true);
        setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.common.Dfc.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (Dfc.this.kb != null) {
                    Dfc.this.kb.ui();
                } else {
                    Dfc.this.DbA();
                }
            }
        });
        setBackgroundColor(Color.parseColor("#80000000"));
        this.eli = new com.bytedance.sdk.openadsdk.Os.FC(context, this.kb);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        layoutParams.leftMargin = SSo.DbA(getContext(), 20.0f);
        layoutParams.rightMargin = SSo.DbA(getContext(), 20.0f);
        this.eli.setLayoutParams(layoutParams);
        this.eli.setClickable(true);
        ui();
    }

    private void ui() {
        com.bytedance.sdk.openadsdk.Os.aAs aas;
        ev evVar = this.DbA;
        if (evVar == null || (aas = this.kb) == null) {
            return;
        }
        aas.eli(evVar.mS());
    }

    public void setDislikeSource(String str) {
        this.ui = str;
        this.kb.DbA(str);
    }

    public void eli() {
        if (this.eli.getParent() == null) {
            addView(this.eli);
        }
        setVisibility(0);
        this.MGA = true;
        eli eliVar = this.Os;
        if (eliVar != null) {
            eliVar.eli(this);
        }
    }

    public void DbA() {
        setVisibility(8);
        this.MGA = false;
        eli eliVar = this.Os;
        if (eliVar != null) {
            eliVar.DbA(this);
        }
    }

    public void setCallback(eli eliVar) {
        this.Os = eliVar;
    }

    @Override // com.bytedance.sdk.openadsdk.Os.aAs.DbA
    public void eli(int i) {
        if (com.bytedance.sdk.openadsdk.Os.aAs.DbA == i) {
            FilterWord DbA = this.kb.DbA();
            if (DbA == null || com.bytedance.sdk.openadsdk.Os.aAs.eli.equals(DbA)) {
                return;
            }
            eli eliVar = this.Os;
            if (eliVar != null) {
                try {
                    eliVar.eli(DbA);
                } catch (Throwable unused) {
                }
            }
            DbA();
            return;
        }
        if (com.bytedance.sdk.openadsdk.Os.aAs.Os == i) {
            DbA();
        } else if (com.bytedance.sdk.openadsdk.Os.aAs.ui == i) {
            Os();
        }
    }

    public void Os() {
        Context context = this.aGH;
        if (context instanceof Activity) {
            boolean isFinishing = ((Activity) context).isFinishing();
            com.bytedance.sdk.openadsdk.Os.nlS nls = new com.bytedance.sdk.openadsdk.Os.nlS(this.aGH, this.kb);
            nls.eli(MGA());
            nls.eli("", this.DbA);
            if (isFinishing || nls.isShowing()) {
                return;
            }
            nls.show();
        }
    }

    private nlS.eli MGA() {
        return new nlS.eli() { // from class: com.bytedance.sdk.openadsdk.common.Dfc.2
            @Override // com.bytedance.sdk.openadsdk.Os.nlS.eli
            public void eli() {
                Dfc.this.setVisibility(8);
            }

            @Override // com.bytedance.sdk.openadsdk.Os.nlS.eli
            public void DbA() {
                Dfc.this.setVisibility(0);
            }

            @Override // com.bytedance.sdk.openadsdk.Os.nlS.eli
            public void Os() {
                Dfc.this.setVisibility(0);
            }

            @Override // com.bytedance.sdk.openadsdk.Os.nlS.eli
            public void eli(int i, FilterWord filterWord, String str) {
                Dfc.this.kb.Os(str);
                Dfc.this.setVisibility(0);
            }
        };
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.bytedance.sdk.openadsdk.Os.aAs aas = this.kb;
        if (aas != null) {
            aas.eli();
        }
    }
}
