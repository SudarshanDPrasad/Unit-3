package com.application.newsbreezeapp.adaptor

import com.application.newsbreezeapp.apicall.remote.Article

interface OnCardClicked {
    fun onCardClicked(article: Article)

}

interface OnSaveClick{
    fun onSaveClick(article: Article)
}
