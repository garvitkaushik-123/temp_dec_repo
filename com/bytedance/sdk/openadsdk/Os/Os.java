package com.bytedance.sdk.openadsdk.Os;

import android.app.Activity;
import android.content.Context;
import com.bytedance.sdk.component.utils.Xb;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.Os.aGH;
import com.bytedance.sdk.openadsdk.Os.nlS;
import com.bytedance.sdk.openadsdk.core.KM;
import com.bytedance.sdk.openadsdk.core.model.ev;
import java.util.List;

/* loaded from: classes3.dex */
public class Os implements KM {
    private final Context DbA;
    private aGH Os;
    private boolean aGH;
    public nlS eli;
    private KM.eli ui;

    public Os(Context context, String str, List<FilterWord> list, String str2, ev evVar) {
        this.DbA = context;
        eli(str, list, str2, evVar);
    }

    private void eli(String str, List<FilterWord> list, String str2, ev evVar) {
        this.Os = new aGH(this.DbA, str, list);
        nlS nls = new nlS(this.DbA, this.Os.getDislikeManager());
        this.eli = nls;
        nls.eli(str2, evVar);
        this.eli.eli(new nlS.eli() { // from class: com.bytedance.sdk.openadsdk.Os.Os.1
            @Override // com.bytedance.sdk.openadsdk.Os.nlS.eli
            public void eli() {
            }

            @Override // com.bytedance.sdk.openadsdk.Os.nlS.eli
            public void DbA() {
                Os.this.eli();
            }

            @Override // com.bytedance.sdk.openadsdk.Os.nlS.eli
            public void Os() {
                Os.this.eli();
            }

            @Override // com.bytedance.sdk.openadsdk.Os.nlS.eli
            public void eli(int i, FilterWord filterWord, String str3) {
                Os.this.Os.onSuggestionSubmit(str3);
                Os.this.eli();
            }
        });
        this.Os.eli(new aGH.eli() { // from class: com.bytedance.sdk.openadsdk.Os.Os.2
            @Override // com.bytedance.sdk.openadsdk.Os.aGH.eli
            public void eli() {
                Os.this.eli(true);
                if (Os.this.Os != null && Os.this.Os.isShowing()) {
                    Os.this.Os.hide();
                }
                Os.this.aGH();
            }

            @Override // com.bytedance.sdk.openadsdk.Os.aGH.eli
            public void eli(int i, FilterWord filterWord) {
                try {
                    if (!filterWord.hasSecondOptions() && Os.this.ui != null) {
                        Os.this.ui.eli(i, filterWord.getName());
                    }
                    filterWord.getName();
                } catch (Throwable unused) {
                }
            }

            @Override // com.bytedance.sdk.openadsdk.Os.aGH.eli
            public void DbA() {
                try {
                    if (Os.this.ui != null) {
                        Os.this.ui.eli();
                    }
                } catch (Throwable th) {
                    Xb.eli("TTAdDislikeImpl", "dislike callback cancel error: ", th);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.KM
    public void eli() {
        Context context = this.DbA;
        if (!(context instanceof Activity) || ((Activity) context).isFinishing() || this.Os.isShowing()) {
            return;
        }
        this.Os.show();
    }

    @Override // com.bytedance.sdk.openadsdk.core.KM
    public void eli(KM.eli eliVar) {
        this.ui = eliVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.KM
    public void DbA() {
        aGH agh = this.Os;
        if (agh != null) {
            agh.destroy();
        }
    }

    public void eli(String str) {
        aGH agh = this.Os;
        if (agh != null) {
            agh.eli(str);
        }
    }

    public boolean Os() {
        return this.aGH;
    }

    public void eli(boolean z) {
        this.aGH = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGH() {
        Context context = this.DbA;
        if (!(context instanceof Activity) || ((Activity) context).isFinishing() || this.eli.isShowing()) {
            return;
        }
        this.eli.show();
    }
}
