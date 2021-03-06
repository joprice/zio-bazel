package dev.nhyne.tictactoe.parser

import dev.nhyne.tictactoe.domain.MenuCommand
import zio.ZIO

trait MenuCommandParser {
    val menuCommandParser: MenuCommandParser.Service[Any]
}

object MenuCommandParser {
    trait Service[R] {
        def parse(input: String): ZIO[R, Nothing, MenuCommand]
    }
    object > extends MenuCommandParser.Service[MenuCommandParser] {
        def parse(input: String) =
            ZIO.accessM(_.menuCommandParser.parse(input))
    }
}

