package com.example.repository.remote.http.models.responses

import com.example.entities.Cat
import com.example.entities.Weight


data class CatResponseItem(
    val weight: Weight,
    val id: String,
    val name: String,
    val cfa_url: String?,
    val vetstreet_url: String?,
    val vcahospitals_url: String?,
    val temperament: String,
    val origin: String,
    val country_codes: String,
    val country_code: String,
    val description: String,
    val life_span: String?,
    val indoor: Int?,
    val lap: Int?,
    val alt_names: String?,
    val adaptability: Int,
    val affection_level: Int?,
    val child_friendly: Int,
    val dog_friendly: Int,
    val energy_level: Int,
    val grooming: Int?,
    val health_issues: Int?,
    val intelligence: Int,
    val shedding_level: Int?,
    val social_needs: Int?,
    val stranger_friendly: Int?,
    val vocalisation: Int?,
    val experimental: Int?,
    val hairless: Int?,
    val natural: Int?,
    val rare: Int?,
    val rex: Int?,
    val suppressed_tail: Int?,
    val short_legs: Int?,
    val wikipedia_url: String?,
    val hypoallergenic: Int?,
    val reference_image_id: String?
){
    fun toCatsResponse(): Cat = Cat(
        this.weight,
        this.id,
        this.name,
        this.cfa_url,
        this.vetstreet_url,
        this.vcahospitals_url,
        this.temperament,
        this.origin,
        this.country_codes,
        this.country_code,
        this.description,
        this.life_span,
        this.indoor,
        this.lap,
        this.alt_names,
        this.adaptability,
        this.affection_level,
        this.child_friendly,
        this.dog_friendly,
        this.energy_level,
        this.grooming,
        this.health_issues,
        this.intelligence,
        this.shedding_level,
        this.social_needs,
        this.stranger_friendly,
        this.vocalisation,
        this.experimental,
        this.hairless,
        this.natural,
        this.rare,
        this.rex,
        this.suppressed_tail,
        this.short_legs,
        this.wikipedia_url,
        this.hypoallergenic,
        this.reference_image_id,
    )
}

fun List<CatResponseItem>.toCatsList(): List<Cat> = this.map {
    it.toCatsResponse()
}


