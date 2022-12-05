package com.example.restaurantstan.MVVM

class Provider {
    companion object {
        fun Plats(): List<ModelPlats> {
            return quotesPlats
        }
        fun Begudes(): List<ModelBegudes> {
            return quotesBegudes
        }

        private var quotesPlats = listOf(
            ModelPlats(
                nomPlat = "Bistec de vedella amb patates",
                preuPlat = 14.50
            ),
            ModelPlats(
                nomPlat = "Llom amb amanida i patates",
                preuPlat = 13.20
            ),
            ModelPlats(
                nomPlat = "Filet de bacalla amb bolets",
                preuPlat = 15.10
            )
        )

        private var quotesBegudes = listOf(
            ModelBegudes(
                nomBeguda = "CocaCola",
                preuBeguda = 2.50
            ),
            ModelBegudes(
                nomBeguda = "Pepsi",
                preuBeguda = 2.75
            ),
            ModelBegudes(
                nomBeguda = "Fanta",
                preuBeguda = 2.20
            )
        )
    }
}