package io.bidmachine.utils;

/* loaded from: classes8.dex */
public class Tag {
    private final String name;
    private String tag;

    public Tag(String name) {
        this.name = name;
    }

    public String toString() {
        if (this.tag == null) {
            this.tag = this.name + " @" + Integer.toHexString(hashCode());
        }
        return this.tag;
    }
}
