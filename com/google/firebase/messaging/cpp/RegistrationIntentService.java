package com.google.firebase.messaging.cpp;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import androidx.core.app.JobIntentService;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.flatbuffers.FlatBufferBuilder;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileLock;

/* loaded from: classes4.dex */
public class RegistrationIntentService extends JobIntentService {
    private static final String TAG = "FirebaseRegService";

    @Override // androidx.core.app.JobIntentService
    protected void onHandleWork(Intent intent) {
        FirebaseMessaging.getInstance().getToken().addOnCompleteListener(new OnCompleteListener<String>() { // from class: com.google.firebase.messaging.cpp.RegistrationIntentService.1
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public void onComplete(Task<String> task) {
                if (!task.isSuccessful()) {
                    Log.w(RegistrationIntentService.TAG, "Fetching FCM registration token failed", task.getException());
                    return;
                }
                String result = task.getResult();
                DebugLogging.log(RegistrationIntentService.TAG, String.format("onHandleWork token=%s", result));
                if (result != null) {
                    RegistrationIntentService.writeTokenToInternalStorage(this, result);
                }
            }
        });
    }

    public static void writeTokenToInternalStorage(Context context, String str) {
        byte[] generateTokenByteBuffer = generateTokenByteBuffer(str);
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.putInt(generateTokenByteBuffer.length);
        try {
            FileOutputStream openFileOutput = context.openFileOutput("FIREBASE_CLOUD_MESSAGING_LOCKFILE", 0);
            try {
                FileLock lock = openFileOutput.getChannel().lock();
                try {
                    FileOutputStream openFileOutput2 = context.openFileOutput("FIREBASE_CLOUD_MESSAGING_LOCAL_STORAGE", 32768);
                    try {
                        openFileOutput2.write(allocate.array());
                        openFileOutput2.write(generateTokenByteBuffer);
                        if (openFileOutput2 != null) {
                            openFileOutput2.close();
                        }
                        if (lock != null) {
                            lock.close();
                        }
                        if (openFileOutput != null) {
                            openFileOutput.close();
                        }
                    } finally {
                    }
                } finally {
                }
            } finally {
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static byte[] generateTokenByteBuffer(String str) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(0);
        if (str == null) {
            str = "";
        }
        int createString = flatBufferBuilder.createString(str);
        SerializedTokenReceived.startSerializedTokenReceived(flatBufferBuilder);
        SerializedTokenReceived.addToken(flatBufferBuilder, createString);
        int endSerializedTokenReceived = SerializedTokenReceived.endSerializedTokenReceived(flatBufferBuilder);
        SerializedEvent.startSerializedEvent(flatBufferBuilder);
        SerializedEvent.addEventType(flatBufferBuilder, (byte) 2);
        SerializedEvent.addEvent(flatBufferBuilder, endSerializedTokenReceived);
        flatBufferBuilder.finish(SerializedEvent.endSerializedEvent(flatBufferBuilder));
        return flatBufferBuilder.sizedByteArray();
    }
}
