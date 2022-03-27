package com.mvvm.module.presentation.mapper

interface IPresentationMapper<PresentationModel, DomainModel> {

    fun mapToPresentation(domain: DomainModel): PresentationModel

}