package com.unity3d.player.a;

import android.content.Context;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.OutputConfiguration;
import android.hardware.camera2.params.SessionConfiguration;
import com.unity3d.player.C3538o;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/* renamed from: com.unity3d.player.a.n, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C3506n extends C3538o {
    public static HashMap F;
    public String E;

    public C3506n(InterfaceC3509q interfaceC3509q) {
        super(interfaceC3509q);
        this.E = null;
    }

    public static String[] a(Context context) {
        String[] cameraIdList = C3538o.getCameraManager(context).getCameraIdList();
        ArrayList arrayList = new ArrayList();
        F = new HashMap();
        for (String str : cameraIdList) {
            arrayList.add(str);
            F.put(str, str);
        }
        for (String str2 : cameraIdList) {
            CameraCharacteristics cameraCharacteristics = C3538o.getCameraManager(context).getCameraCharacteristics(str2);
            int[] iArr = (int[]) cameraCharacteristics.get(CameraCharacteristics.REQUEST_AVAILABLE_CAPABILITIES);
            int length = iArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    t.Log(4, "Camera2 " + str2 + " is a simple camera");
                    break;
                }
                if (iArr[i] == 11) {
                    t.Log(4, "Camera2 " + str2 + " is a logical camera backed by two or more physical cameras");
                    for (String str3 : cameraCharacteristics.getPhysicalCameraIds()) {
                        if (arrayList.indexOf(str3) == -1) {
                            arrayList.add(str3);
                            F.put(str3, str2);
                        }
                        t.Log(4, "Physical camera2 found : " + str3);
                    }
                } else {
                    i++;
                }
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    @Override // com.unity3d.player.C3538o
    public String getCameraIdToOpen(Context context, int i) {
        String str = C3538o.getCameraIds(context)[i];
        String str2 = (String) F.get(str);
        if (str2.equals(str)) {
            this.E = null;
            return str;
        }
        this.E = str;
        return str2;
    }

    @Override // com.unity3d.player.C3538o
    public CameraCaptureSession.CaptureCallback getCaptureCallback() {
        if (this.s == null) {
            this.s = new C3504l(this);
        }
        return this.s;
    }

    @Override // com.unity3d.player.C3538o
    public void createCaptureSession(CameraCaptureSession.StateCallback stateCallback) {
        OutputConfiguration outputConfiguration = new OutputConfiguration(this.w);
        String str = this.E;
        if (str != null) {
            outputConfiguration.setPhysicalCameraId(str);
        }
        this.b.createCaptureSession(new SessionConfiguration(0, Collections.singletonList(outputConfiguration), new ExecutorC3505m(this.d), stateCallback));
    }
}
