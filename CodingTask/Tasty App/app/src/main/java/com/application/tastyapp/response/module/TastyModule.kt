package com.application.tastyapp.response.module

import android.content.Context
import androidx.room.Room
import com.application.tastyapp.response.api.TastyApi
import com.application.tastyapp.response.model.data.favdata.FavDao
import com.application.tastyapp.response.model.data.favdata.FavRoomDataBase
import com.application.tastyapp.response.model.data.logindata.LoginDao
import com.application.tastyapp.response.model.data.logindata.LoginRoomDataBase
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
object TastyModule {

    @Singleton
    @Provides
    fun ProvidesAPi(): TastyApi {
        val builder = Retrofit.Builder()
            .baseUrl("https://tasty.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return builder.create(TastyApi::class.java)
    }

    @Singleton
    @Provides
    fun ProvidesRoomDataBase(@ApplicationContext context: Context): LoginRoomDataBase {
        val builder = Room.databaseBuilder(
            context,
            LoginRoomDataBase::class.java,
            "loginTable"
        )
        builder.fallbackToDestructiveMigration()
        return builder.build()
    }

    @Singleton
    @Provides
    fun ProvidesDatatoDb(db: LoginRoomDataBase) : LoginDao {
        return db.getDao()
    }

    @Singleton
    @Provides
    fun ProvidesRoomDataBaseFav(@ApplicationContext context: Context): FavRoomDataBase {
        val builder = Room.databaseBuilder(
            context,
            FavRoomDataBase::class.java,
            "loginTable"
        )
        builder.fallbackToDestructiveMigration()
        return builder.build()
    }

    @Singleton
    @Provides
    fun ProvidesDatatoDbFav(db: FavRoomDataBase) : FavDao {
        return db.getDaoFav()
    }
}