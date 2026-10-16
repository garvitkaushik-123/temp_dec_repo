package com.bytedance.adsdk.ugeno.wC;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes3.dex */
public abstract class DbA {
    private DataSetObserver DbA;
    private final DataSetObservable eli = new DataSetObservable();

    public Parcelable DbA() {
        return null;
    }

    public float eli(int i) {
        return 1.0f;
    }

    public abstract int eli();

    public int eli(Object obj) {
        return -1;
    }

    public abstract boolean eli(View view, Object obj);

    public Object eli(ViewGroup viewGroup, int i) {
        return eli((View) viewGroup, i);
    }

    public void eli(ViewGroup viewGroup, int i, Object obj) {
        eli((View) viewGroup, i, obj);
    }

    @Deprecated
    public Object eli(View view, int i) {
        throw new UnsupportedOperationException("Required method instantiateItem was not overridden");
    }

    @Deprecated
    public void eli(View view, int i, Object obj) {
        throw new UnsupportedOperationException("Required method destroyItem was not overridden");
    }

    public void Os() {
        synchronized (this) {
            DataSetObserver dataSetObserver = this.DbA;
            if (dataSetObserver != null) {
                dataSetObserver.onChanged();
            }
        }
        this.eli.notifyChanged();
    }

    void eli(DataSetObserver dataSetObserver) {
        synchronized (this) {
            this.DbA = dataSetObserver;
        }
    }
}
