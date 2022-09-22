package com.example.movieapp.networking

import com.google.gson.annotations.SerializedName
import lombok.Data
import lombok.NoArgsConstructor

@NoArgsConstructor
@Data
class favResult {
    @SerializedName("adult")
    val adult: Boolean? = null

    @SerializedName("backdrop_path")
    val backdropPath: String? = null

    @SerializedName("belongs_to_collection")
    val belongsToCollection: Any? = null

    @SerializedName("budget")
    val budget: Int? = null

    @SerializedName("genres")
    val genres: List<GenresDTO>? = null

    @SerializedName("homepage")
    val homepage: String? = null

    @SerializedName("id")
    val id: Int? = null

    @SerializedName("imdb_id")
    val imdbId: String? = null

    @SerializedName("original_language")
    val originalLanguage: String? = null

    @SerializedName("original_title")
    val originalTitle: String? = null

    @SerializedName("overview")
    val overview: String? = null

    @SerializedName("popularity")
    val popularity: Double? = null

    @SerializedName("poster_path")
    val posterPath: String? = null

    @SerializedName("production_companies")
    val productionCompanies: List<ProductionCompaniesDTO>? = null

    @SerializedName("production_countries")
    val productionCountries: List<ProductionCountriesDTO>? = null

    @SerializedName("release_date")
    val releaseDate: String? = null

    @SerializedName("revenue")
    val revenue: Int? = null

    @SerializedName("runtime")
    val runtime: Int? = null

    @SerializedName("spoken_languages")
    val spokenLanguages: List<SpokenLanguagesDTO>? = null

    @SerializedName("status")
    val status: String? = null

    @SerializedName("tagline")
    val tagline: String? = null

    @SerializedName("title")
    val title: String? = null

    @SerializedName("video")
    val video: Boolean? = null

    @SerializedName("vote_average")
    val voteAverage: Double? = null

    @SerializedName("vote_count")
    val voteCount: Int? = null

    @NoArgsConstructor
    @Data
    class GenresDTO {
        @SerializedName("id")
        val id: Int? = null

        @SerializedName("name")
        val name: String? = null
    }

    @NoArgsConstructor
    @Data
    class ProductionCompaniesDTO {
        @SerializedName("id")
        val id: Int? = null

        @SerializedName("logo_path")
        val logoPath: String? = null

        @SerializedName("name")
        val name: String? = null

        @SerializedName("origin_country")
        val originCountry: String? = null
    }

    @NoArgsConstructor
    @Data
    class ProductionCountriesDTO {
        @SerializedName("iso_3166_1")
        val iso31661: String? = null

        @SerializedName("name")
        val name: String? = null
    }

    @NoArgsConstructor
    @Data
    class SpokenLanguagesDTO {
        @SerializedName("iso_639_1")
        val iso6391: String? = null

        @SerializedName("name")
        val name: String? = null
    }
}