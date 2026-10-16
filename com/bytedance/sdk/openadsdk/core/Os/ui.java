package com.bytedance.sdk.openadsdk.core.Os;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.core.Os.MGA;
import com.bytedance.sdk.openadsdk.core.model.CMM;
import com.bytedance.sdk.openadsdk.utils.SSo;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class ui {
    private MGA DbA;
    private final MGA.DbA MGA;
    private CMM eli;
    private final View.OnAttachStateChangeListener kb;
    private final MGA.eli wC;
    private List<eli> Os = new ArrayList();
    private final String aGH = "BannerSwiperManager";
    private int ui = -1;

    public ui(CMM cmm, Context context, int i, int i2) {
        MGA.DbA dbA = new MGA.DbA() { // from class: com.bytedance.sdk.openadsdk.core.Os.ui.1
            @Override // com.bytedance.sdk.openadsdk.core.Os.MGA.DbA
            public void eli(boolean z) {
                try {
                    if (!z) {
                        ui.this.Os();
                    } else {
                        ui.this.aGH();
                    }
                } catch (Throwable unused) {
                }
            }
        };
        this.MGA = dbA;
        View.OnAttachStateChangeListener onAttachStateChangeListener = new View.OnAttachStateChangeListener() { // from class: com.bytedance.sdk.openadsdk.core.Os.ui.2
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                ui.this.ui();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                if (ui.this.Os != null && !ui.this.Os.isEmpty()) {
                    for (int i3 = 0; i3 < ui.this.Os.size(); i3++) {
                        ((eli) ui.this.Os.get(i3)).MGA();
                    }
                }
                ui.this.ui = -1;
                if (ui.this.DbA != null) {
                    ui.this.DbA.aGH();
                }
            }
        };
        this.kb = onAttachStateChangeListener;
        MGA.eli eliVar = new MGA.eli() { // from class: com.bytedance.sdk.openadsdk.core.Os.ui.3
            @Override // com.bytedance.sdk.openadsdk.core.Os.MGA.eli
            public void eli(boolean z) {
                if (!z) {
                    ui.this.Os();
                } else {
                    ui.this.aGH();
                }
            }
        };
        this.wC = eliVar;
        this.eli = cmm;
        MGA mga = new MGA(context);
        this.DbA = mga;
        mga.addOnAttachStateChangeListener(onAttachStateChangeListener);
        this.DbA.setSwiperWindowFocusChangedListener(dbA);
        this.DbA.setSwiperVisibleChangeListener(eliVar);
        eli(context, i, i2);
    }

    protected void eli(Context context, float f, float f2) {
        int DbA = SSo.DbA(context, f);
        int DbA2 = SSo.DbA(context, f2);
        ViewGroup.LayoutParams layoutParams = this.DbA.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(DbA, DbA2);
        }
        layoutParams.width = DbA;
        layoutParams.height = DbA2;
        this.DbA.setLayoutParams(layoutParams);
    }

    public void eli(List<eli> list) {
        this.Os = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Os() {
        MGA mga;
        CMM cmm = this.eli;
        if (cmm != null && cmm.DbA() == 1 && (mga = this.DbA) != null) {
            mga.MGA();
        }
        if (this.ui >= 0) {
            DbA(-1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGH() {
        MGA mga;
        CMM cmm = this.eli;
        if (cmm != null && cmm.DbA() == 1 && (mga = this.DbA) != null) {
            mga.ui();
        }
        int i = this.ui;
        if (i >= 0) {
            eli(i);
            DbA(this.ui);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ui() {
        if (this.eli == null) {
            this.eli = new CMM();
        }
        this.DbA.eli(TextUtils.equals(this.eli.eli(), "vertical") ? 1 : 0).eli("dot").Os(false).aGH(this.eli.aGH() == 1).eli(this.eli.DbA() == 1).Os(this.eli.FC()).ui(this.eli.aAs() == 1).aGH(this.eli.wC()).DbA(this.eli.Os() == 1).wC(this.eli.ui()).FC(this.eli.MGA()).kb(this.eli.kb());
        this.DbA.setOnPageChangeListener(new com.bytedance.adsdk.ugeno.MGA.Os() { // from class: com.bytedance.sdk.openadsdk.core.Os.ui.4
            @Override // com.bytedance.adsdk.ugeno.MGA.Os
            public void eli(boolean z, int i, float f, int i2) {
            }

            @Override // com.bytedance.adsdk.ugeno.MGA.Os
            public void eli(boolean z, int i, int i2, boolean z2, boolean z3) {
                ui.this.Os(i);
                ui.this.ui = i;
                ui.this.eli(i);
                ui.this.DbA(i);
            }

            @Override // com.bytedance.adsdk.ugeno.MGA.Os
            public void eli(boolean z, int i) {
                if (i == 1 || i == 2) {
                    ui.this.DbA(-1);
                } else if (i == 0) {
                    ui uiVar = ui.this;
                    uiVar.eli(uiVar.ui);
                }
            }
        });
        DbA(this.Os);
        this.DbA.Os();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Os(int i) {
        eli eliVar;
        try {
            int i2 = this.ui;
            if (i2 != -1 && i2 != i && (eliVar = this.Os.get(i2)) != null) {
                eliVar.aGH();
                eliVar.wC();
            }
            eli eliVar2 = this.Os.get(i);
            if (eliVar2 != null) {
                eliVar2.ui();
            }
        } catch (Throwable unused) {
        }
    }

    public void eli(final int i) {
        eli eliVar;
        try {
            final int size = this.Os.size();
            if (i < size && (eliVar = this.Os.get(i)) != null) {
                eliVar.eli(new com.bytedance.sdk.openadsdk.eli.eli.DbA() { // from class: com.bytedance.sdk.openadsdk.core.Os.ui.5
                    @Override // com.bytedance.sdk.openadsdk.eli.eli.DbA
                    public void eli() {
                        int i2 = i + 1;
                        if (i2 >= size) {
                            return;
                        }
                        ui.this.eli(i2);
                    }
                });
            }
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    public void DbA(int i) {
        eli eliVar;
        for (int i2 = 0; i2 < this.Os.size(); i2++) {
            try {
                if (i2 != i && (eliVar = this.Os.get(i2)) != null) {
                    eliVar.FC();
                }
            } catch (Throwable th) {
                th.getMessage();
                return;
            }
        }
    }

    private void DbA(List<eli> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            this.DbA.eli((MGA) list.get(i).eli());
        }
    }

    public void eli() {
        if (this.DbA != null) {
            try {
                List<eli> list = this.Os;
                if (list != null && !list.isEmpty()) {
                    for (int i = 0; i < this.Os.size(); i++) {
                        this.Os.get(i).kb();
                    }
                }
                this.ui = -1;
                this.DbA.aGH();
                this.DbA.setSwiperWindowFocusChangedListener(null);
                this.DbA.setSwiperVisibleChangeListener(null);
                this.DbA.removeOnAttachStateChangeListener(this.kb);
                this.DbA = null;
            } catch (Throwable unused) {
            }
        }
    }

    public View DbA() {
        return this.DbA;
    }
}
