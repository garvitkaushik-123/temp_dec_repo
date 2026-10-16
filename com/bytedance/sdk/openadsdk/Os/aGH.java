package com.bytedance.sdk.openadsdk.Os;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import com.bytedance.sdk.component.utils.ev;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.utils.SSo;
import java.util.List;

/* loaded from: classes3.dex */
public class aGH extends TTDislikeDialogAbstract {
    private eli aGH;
    private String ui;

    public interface eli {
        void DbA();

        void eli();

        void eli(int i, FilterWord filterWord);
    }

    public aGH(Context context, String str, List<FilterWord> list) {
        super(context, ev.MGA(context, "tt_dislikeDialog"));
        this.eli = str;
        this.DbA = list;
    }

    public void eli(eli eliVar) {
        this.aGH = eliVar;
    }

    @Override // com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        try {
            super.onCreate(bundle);
            setCanceledOnTouchOutside(true);
            setCancelable(true);
            eli();
            DbA();
            setMaterialMeta(this.eli, this.DbA);
        } catch (Throwable unused) {
            dismiss();
        }
    }

    public void eli(String str) {
        this.ui = str;
    }

    @Override // com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract
    public View getLayoutView() {
        return new FC(getContext(), this.Os, this.DbA);
    }

    @Override // com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract
    public ViewGroup.LayoutParams getLayoutParams() {
        return new ViewGroup.LayoutParams(SSo.Os(getContext()) - 120, -2);
    }

    @Override // com.bytedance.sdk.openadsdk.Os.aAs.DbA
    public void eli(int i) {
        FilterWord DbA;
        if (aAs.Os == i) {
            dismiss();
            return;
        }
        if (aAs.ui == i) {
            eli eliVar = this.aGH;
            if (eliVar != null) {
                eliVar.eli();
                return;
            }
            return;
        }
        if (aAs.DbA != i || (DbA = this.Os.DbA()) == null || aAs.eli.equals(DbA)) {
            return;
        }
        eli eliVar2 = this.aGH;
        if (eliVar2 != null) {
            try {
                eliVar2.eli(0, DbA);
            } catch (Throwable unused) {
            }
        }
        dismiss();
    }

    @Override // android.app.Dialog
    public void show() {
        try {
            super.show();
        } catch (WindowManager.BadTokenException unused) {
        }
    }

    private void eli() {
        Window window = getWindow();
        if (window == null || window.getAttributes() == null) {
            return;
        }
        window.getAttributes().windowAnimations = 0;
    }

    private void DbA() {
        setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.bytedance.sdk.openadsdk.Os.aGH.1
            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                if (aGH.this.aGH != null) {
                    eli unused = aGH.this.aGH;
                }
            }
        });
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.bytedance.sdk.openadsdk.Os.aGH.2
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (aGH.this.aGH != null) {
                    aGH.this.aGH.DbA();
                }
            }
        });
    }
}
