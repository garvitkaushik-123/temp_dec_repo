package com.bykv.vk.openvk.eli.eli.eli.MGA;

import android.content.Context;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import com.bykv.vk.openvk.eli.eli.eli.MGA.DbA;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class Os extends ui implements SurfaceHolder.Callback, DbA {
    private static final ArrayList<MGA> Os = new ArrayList<>();
    private MGA DbA;
    private DbA.eli aGH;
    private WeakReference<eli> eli;

    @Override // com.bykv.vk.openvk.eli.eli.eli.MGA.DbA
    public View getView() {
        return this;
    }

    public Os(Context context) {
        super(context);
        eli();
    }

    private void eli() {
        MGA mga = new MGA(this);
        this.DbA = mga;
        Os.add(mga);
    }

    @Override // com.bykv.vk.openvk.eli.eli.eli.MGA.DbA
    public void eli(eli eliVar) {
        this.eli = new WeakReference<>(eliVar);
        SurfaceHolder holder = getHolder();
        holder.setFormat(-3);
        Iterator<MGA> it = Os.iterator();
        while (it.hasNext()) {
            MGA next = it.next();
            if (next != null && next.eli() == null) {
                holder.removeCallback(next);
                it.remove();
            }
        }
        holder.addCallback(this.DbA);
    }

    @Override // com.bykv.vk.openvk.eli.eli.eli.MGA.DbA
    public void eli(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = i2;
        layoutParams.width = i;
        setLayoutParams(layoutParams);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        WeakReference<eli> weakReference = this.eli;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.eli.get().eli(surfaceHolder);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        WeakReference<eli> weakReference = this.eli;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.eli.get().eli(surfaceHolder, i, i2, i3);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        WeakReference<eli> weakReference = this.eli;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.eli.get().DbA(surfaceHolder);
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
    }

    public void setWindowVisibilityChangedListener(DbA.eli eliVar) {
        this.aGH = eliVar;
    }
}
