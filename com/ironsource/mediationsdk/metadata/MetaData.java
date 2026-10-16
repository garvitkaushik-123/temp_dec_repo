package com.ironsource.mediationsdk.metadata;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes6.dex */
public class MetaData {

    /* renamed from: a, reason: collision with root package name */
    private String f3549a;
    private List<String> b;
    private List<MetaDataValueTypes> c;

    public enum MetaDataValueTypes {
        META_DATA_VALUE_STRING,
        META_DATA_VALUE_BOOLEAN,
        META_DATA_VALUE_INT,
        META_DATA_VALUE_LONG,
        META_DATA_VALUE_DOUBLE,
        META_DATA_VALUE_FLOAT
    }

    public MetaData(String str, List<String> list, List<MetaDataValueTypes> list2) {
        this.f3549a = str;
        this.b = list;
        this.c = list2;
    }

    public String getMetaDataKey() {
        return this.f3549a;
    }

    public List<String> getMetaDataValue() {
        return this.b;
    }

    public List<MetaDataValueTypes> getMetaDataValueType() {
        return this.c;
    }

    public MetaData(String str, List<String> list) {
        this.f3549a = str;
        this.b = list;
        this.c = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            this.c.add(MetaDataValueTypes.META_DATA_VALUE_STRING);
        }
    }
}
