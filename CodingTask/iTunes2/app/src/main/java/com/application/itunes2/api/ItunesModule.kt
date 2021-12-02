package com.application.itunes2.api

import android.content.Context
import androidx.room.Room
import com.application.itunes2.data.ItunesDao
import com.application.itunes2.data.ItunesRoomDataBase
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
object ItunesModule {

    @Singleton
    @Provides
    fun ProvidesApiService(): ApiCall {
        val builder = Retrofit.Builder()
            .baseUrl("https://itunes.apple.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return builder.create(ApiCall::class.java)
    }

    @Singleton
    @Provides
    fun ProvidesRoomDataBase(@ApplicationContext context: Context): ItunesRoomDataBase {
        val builder = Room.databaseBuilder(
            context,
            ItunesRoomDataBase::class.java,
            "song_db"
        )
        builder.fallbackToDestructiveMigration()
        return builder.build()
    }

    @Singleton
    @Provides
    fun ProvidesDatatoDb(db: ItunesRoomDataBase) : ItunesDao {
        return db.getDao()
    }
}