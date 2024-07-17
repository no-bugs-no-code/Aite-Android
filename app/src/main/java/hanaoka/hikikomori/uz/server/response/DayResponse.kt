package hanaoka.hikikomori.uz.server.response

data class DayResponse(
    val menus : List<MenuResponse>? = listOf(MenuResponse(), MenuResponse(), MenuResponse())
)
