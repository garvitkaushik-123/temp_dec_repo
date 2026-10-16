package com.bytedance.sdk.component.ui.DbA;

import com.bytedance.sdk.component.ui.MGA;
import com.bytedance.sdk.component.ui.kb;
import java.util.Map;

/* loaded from: classes3.dex */
public class Os<T> implements MGA {
    private int DbA;
    private T Os;
    private String aGH;
    Map<String, String> eli;
    private kb ui;

    public Os(int i, T t, String str) {
        this.DbA = i;
        this.Os = t;
        this.aGH = str;
    }

    public Os(int i, T t, String str, Map<String, String> map) {
        this(i, t, str);
        this.eli = map;
    }

    @Override // com.bytedance.sdk.component.ui.MGA
    public kb eli() {
        return this.ui;
    }

    public void eli(kb kbVar) {
        this.ui = kbVar;
    }

    @Override // com.bytedance.sdk.component.ui.MGA
    public int DbA() {
        return this.DbA;
    }

    @Override // com.bytedance.sdk.component.ui.MGA
    public T Os() {
        return this.Os;
    }

    @Override // com.bytedance.sdk.component.ui.MGA
    public String aGH() {
        return this.aGH;
    }

    @Override // com.bytedance.sdk.component.ui.MGA
    public Map<String, String> ui() {
        return this.eli;
    }
}
