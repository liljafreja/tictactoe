@startuml

' hide the spot
hide circle

' avoid problems with angled crows feet
skinparam linetype ortho

entity "TicTacToe" as e01 {
*id : UUID <<generated>>
--
*firstTurnPlayerX: Boolean
}

entity "Turn" as e02 {
*id : Integer <<generated>>
--
*playerX : Boolean
*xPosition : Integer
*yPosition: Integer
}


e01 ||..o{ e02

@enduml
