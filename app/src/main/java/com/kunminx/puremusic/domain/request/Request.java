package com.kunminx.puremusic.domain.request;

import androidx.lifecycle.LiveData;

import com.kunminx.puremusic.data.bean.DownloadFile;
import com.kunminx.puremusic.data.bean.GridItem;
import com.kunminx.puremusic.data.bean.LibraryInfo;
import com.kunminx.puremusic.data.bean.User;

import java.util.List;

/**
 * Create by KunMinX at 2020/5/21
 */
public class Request {

    public interface IAccountRequest {

        LiveData<String> getTokenLiveData();

        void requestLogin(User user);
    }

    public interface IDownloadRequest {

        LiveData<DownloadFile> getDownloadFileLiveData();

        LiveData<DownloadFile> getDownloadFileCanBeStoppedLiveData();

        void requestDownloadFile();

        void requestCanBeStoppedDownloadFile();
    }

    public interface IInfoRequest {

        LiveData<List<LibraryInfo>> getLibraryLiveData();

        void requestLibraryInfo();
    }

    public interface IMusicRequest {

        LiveData<List<GridItem>> getJavaItemsLiveData();

        LiveData<List<GridItem>> getKotlinItemsLiveData();

        void requestJavaItems();

        void requestKotlinItems();
    }
}
