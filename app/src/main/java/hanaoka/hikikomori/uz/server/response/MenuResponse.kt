package hanaoka.hikikomori.uz.server.response

data class MenuResponse(
    val timeLine : String? = "아침",
    val menuList : List<String>? = listOf("카레", "생강절임", "가라아게")
)
