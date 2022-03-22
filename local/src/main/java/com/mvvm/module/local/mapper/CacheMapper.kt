package com.mvvm.module.local.mapper

interface CacheMapper<CachedModel, DataModel> {

    fun mapFromCached(cached: CachedModel): DataModel

    fun mapToCached(entity: DataModel): CachedModel

}