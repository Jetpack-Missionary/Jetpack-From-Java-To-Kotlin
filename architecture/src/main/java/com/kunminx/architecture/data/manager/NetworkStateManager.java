

package com.kunminx.architecture.data.manager;

import android.content.IntentFilter;
import android.net.ConnectivityManager;

import androidx.annotation.NonNull;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;

import com.kunminx.architecture.ui.callback.ProtectedUnPeekLiveData;
import com.kunminx.architecture.ui.callback.UnPeekLiveData;
import com.kunminx.architecture.utils.Utils;

/**
 * Create by KunMinX at 19/10/11
 */
public class NetworkStateManager implements DefaultLifecycleObserver {

    private static final NetworkStateManager S_MANAGER = new NetworkStateManager();
    private UnPeekLiveData<NetState> networkStateCallback;
    private NetworkStateReceive mNetworkStateReceive;

    private NetworkStateManager() {
    }

    public static NetworkStateManager getInstance() {
        return S_MANAGER;
    }

    public ProtectedUnPeekLiveData<NetState> getNetworkStateCallback() {
        if (networkStateCallback == null) networkStateCallback = new UnPeekLiveData<>();
        return networkStateCallback;
    }

    @Override
    public void onResume(@NonNull LifecycleOwner owner) {
        mNetworkStateReceive = new NetworkStateReceive();
        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        Utils.getApp().getApplicationContext().registerReceiver(mNetworkStateReceive, filter);
    }

    @Override
    public void onPause(@NonNull LifecycleOwner owner) {
        if (mNetworkStateReceive != null) {
            Utils.getApp().getApplicationContext().unregisterReceiver(mNetworkStateReceive);
        }
    }
}
