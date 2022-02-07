package com.application.tastyapp.response.model.frontScreen


import com.google.gson.annotations.SerializedName

data class RecipeX(
    @SerializedName("approved_at")
    val approvedAt: Int,
    @SerializedName("aspect_ratio")
    val aspectRatio: String,
    @SerializedName("beauty_url")
    val beautyUrl: String,
    @SerializedName("brand")
    val brand: Any,
    @SerializedName("brand_id")
    val brandId: Any,
    @SerializedName("buzz_id")
    val buzzId: Int,
    @SerializedName("canonical_id")
    val canonicalId: String,
    @SerializedName("compilations")
    val compilations: List<CompilationXXX>,
    @SerializedName("cook_time_minutes")
    val cookTimeMinutes: Any,
    @SerializedName("country")
    val country: String,
    @SerializedName("created_at")
    val createdAt: Int,
    @SerializedName("credits")
    val credits: List<CreditXXX>,
    @SerializedName("description")
    val description: Any,
    @SerializedName("draft_status")
    val draftStatus: String,
    @SerializedName("facebook_posts")
    val facebookPosts: List<Any>,
    @SerializedName("_id")
    val id: Int,
    @SerializedName("_index")
    val index: String,
    @SerializedName("inspired_by_url")
    val inspiredByUrl: Any,
    @SerializedName("instructions")
    val instructions: List<InstructionXXX>,
    @SerializedName("is_one_top")
    val isOneTop: Boolean,
    @SerializedName("is_shoppable")
    val isShoppable: Boolean,
    @SerializedName("keywords")
    val keywords: Any,
    @SerializedName("language")
    val language: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("num_servings")
    val numServings: Int,
    @SerializedName("nutrition")
    val nutrition: NutritionXXX,
    @SerializedName("nutrition_visibility")
    val nutritionVisibility: String,
    @SerializedName("_op_type")
    val opType: String,
    @SerializedName("original_video_url")
    val originalVideoUrl: String,
    @SerializedName("prep_time_minutes")
    val prepTimeMinutes: Any,
    @SerializedName("promotion")
    val promotion: String,
    @SerializedName("renditions")
    val renditions: List<RenditionXX>,
    @SerializedName("sections")
    val sections: List<SectionXX>,
    @SerializedName("seo_title")
    val seoTitle: Any,
    @SerializedName("servings_noun_plural")
    val servingsNounPlural: String,
    @SerializedName("servings_noun_singular")
    val servingsNounSingular: String,
    @SerializedName("show")
    val show: ShowXXXXXX,
    @SerializedName("show_id")
    val showId: Int,
    @SerializedName("slug")
    val slug: String,
    @SerializedName("tags")
    val tags: List<TagXX>,
    @SerializedName("thumbnail_alt_text")
    val thumbnailAltText: String,
    @SerializedName("thumbnail_url")
    val thumbnailUrl: String,
    @SerializedName("tips_and_ratings_enabled")
    val tipsAndRatingsEnabled: Boolean,
    @SerializedName("topics")
    val topics: List<TopicXX>,
    @SerializedName("total_time_minutes")
    val totalTimeMinutes: Any,
    @SerializedName("total_time_tier")
    val totalTimeTier: TotalTimeTier,
    @SerializedName("_type")
    val type: String,
    @SerializedName("updated_at")
    val updatedAt: Int,
    @SerializedName("user_ratings")
    val userRatings: UserRatingsXX,
    @SerializedName("video_ad_content")
    val videoAdContent: String,
    @SerializedName("video_id")
    val videoId: Int,
    @SerializedName("video_url")
    val videoUrl: String,
    @SerializedName("yields")
    val yields: String
)