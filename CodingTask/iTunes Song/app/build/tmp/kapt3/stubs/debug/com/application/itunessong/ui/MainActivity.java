package com.application.itunessong.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0012\u0010\u001a\u001a\u00020\u00172\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"Lcom/application/itunessong/ui/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "activityMainBinding", "Lcom/application/itunessong/databinding/ActivityMainBinding;", "list", "", "Lcom/application/itunessong/responsemodel/Result;", "songDao", "Lcom/application/itunessong/roomdatabase/SongDao;", "getSongDao", "()Lcom/application/itunessong/roomdatabase/SongDao;", "setSongDao", "(Lcom/application/itunessong/roomdatabase/SongDao;)V", "songDataBase", "Lcom/application/itunessong/roomdatabase/SongDataBase;", "getSongDataBase", "()Lcom/application/itunessong/roomdatabase/SongDataBase;", "setSongDataBase", "(Lcom/application/itunessong/roomdatabase/SongDataBase;)V", "songViewModel", "Lcom/application/itunessong/data/SongViewModel;", "loadapi", "", "query", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint
public final class MainActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.application.itunessong.databinding.ActivityMainBinding activityMainBinding;
    private java.util.List<com.application.itunessong.responsemodel.Result> list;
    private com.application.itunessong.data.SongViewModel songViewModel;
    public com.application.itunessong.roomdatabase.SongDao songDao;
    public com.application.itunessong.roomdatabase.SongDataBase songDataBase;
    
    public MainActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.application.itunessong.roomdatabase.SongDao getSongDao() {
        return null;
    }
    
    public final void setSongDao(@org.jetbrains.annotations.NotNull
    com.application.itunessong.roomdatabase.SongDao p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.application.itunessong.roomdatabase.SongDataBase getSongDataBase() {
        return null;
    }
    
    public final void setSongDataBase(@org.jetbrains.annotations.NotNull
    com.application.itunessong.roomdatabase.SongDataBase p0) {
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void loadapi(java.lang.String query) {
    }
}