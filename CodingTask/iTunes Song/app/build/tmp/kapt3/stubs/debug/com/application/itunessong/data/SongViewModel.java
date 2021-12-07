package com.application.itunessong.data;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0014\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011J\u001a\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u00062\u0006\u0010\u0016\u001a\u00020\u0017R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0018"}, d2 = {"Lcom/application/itunessong/data/SongViewModel;", "Landroidx/lifecycle/ViewModel;", "songRepo", "Lcom/application/itunessong/data/SongRepo;", "(Lcom/application/itunessong/data/SongRepo;)V", "liveData", "Landroidx/lifecycle/LiveData;", "Lcom/application/itunessong/data/MainUiModel;", "getLiveData", "()Landroidx/lifecycle/LiveData;", "mutableLiveData", "Landroidx/lifecycle/MutableLiveData;", "getSongRepo", "()Lcom/application/itunessong/data/SongRepo;", "getAPi", "", "result", "", "Lcom/application/itunessong/responsemodel/Result;", "getData", "Lcom/application/itunessong/data/Resource;", "Lcom/application/itunessong/responsemodel/ResponseDTO;", "query", "", "app_debug"})
public final class SongViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.application.itunessong.data.SongRepo songRepo = null;
    private final androidx.lifecycle.MutableLiveData<com.application.itunessong.data.MainUiModel> mutableLiveData = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.LiveData<com.application.itunessong.data.MainUiModel> liveData = null;
    
    @javax.inject.Inject
    public SongViewModel(@org.jetbrains.annotations.NotNull
    com.application.itunessong.data.SongRepo songRepo) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.application.itunessong.data.SongRepo getSongRepo() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.application.itunessong.data.MainUiModel> getLiveData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.application.itunessong.data.Resource<com.application.itunessong.responsemodel.ResponseDTO>> getData(@org.jetbrains.annotations.NotNull
    java.lang.String query) {
        return null;
    }
    
    public final void getAPi(@org.jetbrains.annotations.NotNull
    java.util.List<com.application.itunessong.responsemodel.Result> result) {
    }
}