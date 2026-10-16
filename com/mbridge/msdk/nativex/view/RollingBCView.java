package com.mbridge.msdk.nativex.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.viewpager.widget.ViewPager;
import com.mbridge.msdk.nativex.adapter.RollingAdapter;
import com.mbridge.msdk.nativex.listener.RollingPagerListenrt;
import com.mbridge.msdk.nativex.view.MBNativeRollView;
import com.mbridge.msdk.out.Frame;
import com.mbridge.msdk.out.NativeListener;
import java.util.List;

/* loaded from: classes6.dex */
public class RollingBCView extends ViewPager {
    private NativeListener.FilpListener FilpListening;
    private boolean isReport;
    private RollingPagerListenrt listenrt;
    private MBNativeRollView.a mvinterface;

    private RollingBCView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isReport = true;
        this.listenrt = new RollingPagerListenrt();
        setOffscreenPageLimit(1);
        setClipChildren(false);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    protected void onMeasure(int i, int i2) {
        if (View.MeasureSpec.getMode(i2) == Integer.MIN_VALUE) {
            int i3 = 0;
            for (int i4 = 0; i4 < getChildCount(); i4++) {
                View childAt = getChildAt(i4);
                childAt.measure(i, View.MeasureSpec.makeMeasureSpec(0, 0));
                int measuredHeight = childAt.getMeasuredHeight();
                if (measuredHeight > i3) {
                    i3 = measuredHeight;
                }
                if (measuredHeight > 10 && this.isReport) {
                    this.listenrt.reportRollBC(0);
                    this.isReport = false;
                }
            }
            i2 = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
        }
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
    }

    public void setData(List<Frame> list, Context context, String str, MBNativeRollView.a aVar) {
        if (list == null || list.size() == 0) {
            throw new NegativeArraySizeException("ad date is null or size is 0");
        }
        RollingAdapter rollingAdapter = new RollingAdapter(list);
        if (aVar != null) {
            rollingAdapter.setMvinterface(aVar);
        }
        setAdapter(rollingAdapter);
        this.listenrt.setCampList(list, context, str);
        NativeListener.FilpListener filpListener = this.FilpListening;
        if (filpListener != null) {
            this.listenrt.setFilpListening(filpListener);
        }
        setOnPageChangeListener(this.listenrt);
        if (this.isReport) {
            this.listenrt.reportRollBC(0);
            this.isReport = false;
        }
    }

    public void setFilpListening(NativeListener.FilpListener filpListener) {
        this.FilpListening = filpListener;
    }

    public RollingBCView(Context context) {
        super(context);
        this.isReport = true;
        this.listenrt = new RollingPagerListenrt();
    }
}
