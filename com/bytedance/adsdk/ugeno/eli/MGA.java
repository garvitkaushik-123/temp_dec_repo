package com.bytedance.adsdk.ugeno.eli;

import android.content.Context;
import android.graphics.Canvas;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class MGA {
    private List<eli> DbA;
    private Context Os;
    private com.bytedance.adsdk.ugeno.DbA.Os aGH;
    private List<Os> eli;

    public MGA(Context context, com.bytedance.adsdk.ugeno.DbA.Os os, List<Os> list) {
        this.aGH = os;
        this.Os = context;
        this.eli = list;
        aGH();
    }

    private void aGH() {
        this.DbA = new ArrayList();
        List<Os> list = this.eli;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i = 0; i < this.eli.size(); i++) {
            Os os = this.eli.get(i);
            if (os != null) {
                this.DbA.add(new eli(this.Os, this.aGH, os));
            }
        }
    }

    public void eli() {
        List<eli> list = this.DbA;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (eli eliVar : this.DbA) {
            if (eliVar != null) {
                eliVar.aGH();
            }
        }
    }

    public void DbA() {
        List<eli> list = this.DbA;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (eli eliVar : this.DbA) {
            if (eliVar != null) {
                eliVar.eli();
            }
        }
    }

    public void Os() {
        List<eli> list = this.DbA;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (eli eliVar : this.DbA) {
            if (eliVar != null) {
                eliVar.Os();
            }
        }
    }

    public void eli(Canvas canvas) {
        List<eli> list = this.DbA;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (eli eliVar : this.DbA) {
            if (eliVar != null) {
                eliVar.eli(canvas);
            }
        }
    }

    public void DbA(Canvas canvas) {
        List<eli> list = this.DbA;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (eli eliVar : this.DbA) {
            if (eliVar != null) {
                eliVar.DbA(canvas);
            }
        }
    }

    public void eli(int i, int i2) {
        List<eli> list = this.DbA;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (eli eliVar : this.DbA) {
            if (eliVar != null) {
                eliVar.eli(i, i2);
            }
        }
    }

    public eli eli(String str) {
        List<eli> list = this.DbA;
        if (list != null && !list.isEmpty()) {
            for (eli eliVar : this.DbA) {
                if (eliVar != null && TextUtils.equals(eliVar.ui(), str)) {
                    return eliVar;
                }
            }
        }
        return null;
    }
}
