package com.kunminx.puremusic.domain.request;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.kunminx.puremusic.data.bean.DownloadFile;
import com.kunminx.puremusic.data.repository.DataRepository;

/**
 * 信息列表 Request
 * <p>
 * TODO tip：Request 通常按业务划分
 * 一个项目中通常存在多个 Request
 * <p>
 * request 的职责仅限于 数据请求，不建议在此处理 UI 逻辑，
 * UI 逻辑只适合在 Activity/Fragment 等视图控制器中完成，是 “数据驱动” 的一部分，
 * 将来升级到 Jetpack Compose 更是如此。
 * <p>
 * 如果这样说还不理解的话，详见 https://xiaozhuanlan.com/topic/6257931840
 * <p>
 * <p>
 * Create by KunMinX at 20/03/18
 */
public class DownloadRequest implements Request.IDownloadRequest {

    private MutableLiveData<DownloadFile> mDownloadFileLiveData;

    private MutableLiveData<DownloadFile> mDownloadFileCanBeStoppedLiveData;

    @Override
    public LiveData<DownloadFile> getDownloadFileLiveData() {
        if (mDownloadFileLiveData == null) {
            mDownloadFileLiveData = new MutableLiveData<>();
        }
        return mDownloadFileLiveData;
    }

    @Override
    public LiveData<DownloadFile> getDownloadFileCanBeStoppedLiveData() {
        if (mDownloadFileCanBeStoppedLiveData == null) {
            mDownloadFileCanBeStoppedLiveData = new MutableLiveData<>();
        }
        return mDownloadFileCanBeStoppedLiveData;
    }

    @Override
    public void requestDownloadFile() {
        DataRepository.getInstance().downloadFile(mDownloadFileLiveData);
    }

    @Override
    public void requestCanBeStoppedDownloadFile() {

    }

}
