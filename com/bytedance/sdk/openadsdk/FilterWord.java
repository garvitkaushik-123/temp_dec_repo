package com.bytedance.sdk.openadsdk;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class FilterWord {
    private String DbA;
    private boolean Os;
    private List<FilterWord> aGH;
    private String eli;

    public FilterWord(String str, String str2) {
        this.eli = str;
        this.DbA = str2;
    }

    public FilterWord() {
    }

    public String getId() {
        return this.eli;
    }

    public void setId(String str) {
        this.eli = str;
    }

    public String getName() {
        return this.DbA;
    }

    public void setName(String str) {
        this.DbA = str;
    }

    public boolean getIsSelected() {
        return this.Os;
    }

    public void setIsSelected(boolean z) {
        this.Os = z;
    }

    public List<FilterWord> getOptions() {
        return this.aGH;
    }

    public void addOption(FilterWord filterWord) {
        if (filterWord == null) {
            return;
        }
        if (this.aGH == null) {
            this.aGH = new ArrayList();
        }
        this.aGH.add(filterWord);
    }

    public boolean isValid() {
        return (TextUtils.isEmpty(this.eli) || TextUtils.isEmpty(this.DbA)) ? false : true;
    }

    public boolean hasSecondOptions() {
        List<FilterWord> list = this.aGH;
        return (list == null || list.isEmpty()) ? false : true;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof FilterWord)) {
            return false;
        }
        FilterWord filterWord = (FilterWord) obj;
        return filterWord.getId().equals(getId()) && filterWord.getName().equals(getName());
    }
}
