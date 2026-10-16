package com.bytedance.sdk.openadsdk;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.Os.aAs;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class TTDislikeDialogAbstract extends Dialog implements aAs.DbA {
    protected List<FilterWord> DbA;
    protected final aAs Os;
    private View aGH;
    protected String eli;

    public abstract ViewGroup.LayoutParams getLayoutParams();

    public abstract View getLayoutView();

    public TTDislikeDialogAbstract(Context context) {
        super(context);
        aAs aas = new aAs();
        this.Os = aas;
        aas.eli(this);
    }

    public TTDislikeDialogAbstract(Context context, int i) {
        super(context, i);
        aAs aas = new aAs();
        this.Os = aas;
        aas.eli(this);
    }

    public aAs getDislikeManager() {
        return this.Os;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.aGH = getLayoutView();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        View view = this.aGH;
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, -1);
        }
        setContentView(view, layoutParams);
    }

    public void setMaterialMeta(String str, List<FilterWord> list) {
        this.eli = str;
        this.DbA = list;
        this.Os.eli(str);
        this.Os.eli(this.DbA);
    }

    public void onSuggestionSubmit(String str) {
        aAs aas = this.Os;
        if (aas != null) {
            aas.Os(str);
        }
    }

    public void destroy() {
        aAs aas = this.Os;
        if (aas != null) {
            aas.eli();
        }
    }
}
