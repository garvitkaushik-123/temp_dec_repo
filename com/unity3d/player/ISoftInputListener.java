package com.unity3d.player;

/* loaded from: classes7.dex */
public interface ISoftInputListener {
    void hide();

    boolean isConsumeOutsideTouchesEnabled();

    void setCharacterLimit(int i);

    void setHideInputField(boolean z);

    void setSelection(int i, int i2);

    void setText(String str);

    void show(String str, int i, boolean z, boolean z2, boolean z3, boolean z4, String str2, int i2, boolean z5, boolean z6);
}
