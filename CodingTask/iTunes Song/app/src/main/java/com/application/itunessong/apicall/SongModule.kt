package com.application.itunessong.apicall

import android.content.Context
import androidx.room.Room
import com.application.itunessong.roomdatabase.SongDao
import com.application.itunessong.roomdatabase.SongDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SongModule {

    @Singleton
    @Provides
    fun provideApiService() : ApiSong{
        val builder = Retrofit.Builder()
            .baseUrl("https://itunes.apple.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return builder.create(ApiSong::class.java)
    }

    @Singleton
    @Provides
    fun provideRoomDB(@ApplicationContext context: Context): SongDataBase {
        val builder = Room.databaseBuilder(
            context,
            SongDataBase::class.java,
            "song_db"
        )
        builder.fallbackToDestructiveMigration()
        return builder.build()
    }

    @Singleton
    @Provides
    fun provideTaskDAO(db:SongDataBase) : SongDao{
        return db.getSongDao()
    }
}