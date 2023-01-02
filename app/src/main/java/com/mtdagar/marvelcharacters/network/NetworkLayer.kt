package com.mtdagar.marvelcharacters.network

object NetworkLayer {

//    val moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()
//    val retrofit: Retrofit = Retrofit.Builder()
//        .client(getLoggingHttpClient())
//        .baseUrl("https://rickandmortyapi.com/api/")
//        .addConverterFactory(MoshiConverterFactory.create(moshi))
//        .build()
//
//    val marvelService: MarvelService by lazy {
//        retrofit.create(MarvelService::class.java)
//    }
//
//    val apiClient = ApiClient(marvelService)
//
//    private fun getLoggingHttpClient(): OkHttpClient {
//        val builder = OkHttpClient.Builder()
//        builder.addInterceptor(HttpLoggingInterceptor().apply {
//            setLevel(HttpLoggingInterceptor.Level.BODY)
//        })
//
//        builder.addInterceptor(
//            ChuckerInterceptor.Builder(SimpleMortyApplication.context)
//                .collector(ChuckerCollector(SimpleMortyApplication.context))
//                .maxContentLength(250000L)
//                .redactHeaders(emptySet())
//                .alwaysReadResponseBody(false)
//                .build()
//        )
//
//        return builder.build()
//    }

}