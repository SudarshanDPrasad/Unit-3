package com.application.newsapi.clickinterface

import com.application.newsapi.response.Article

interface Onclicking {

    fun OnClick(article: Article)
}