package com.example.composedesign.utils

import com.example.composedesign.models.City
import com.example.composedesign.models.Hotel

object DataDummy {

    fun generateCityList(): List<City> {
        val city = arrayListOf<City>()

        city.add(
            City(
                "1",
                "Bandung",
                "300 + Penginapan",
                "https://images.unsplash.com/photo-1636490153430-5fccec87023e?ixid=MnwxMjA3fDB8MHxlZGl0b3JpYWwtZmVlZHw0fHx8ZW58MHx8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60"
            )
        )


        city.add(
            City(
                "2",
                "Pekalongan",
                "399 + Penginapan",
                "https://images.unsplash.com/photo-1600177421426-6547bcb21ef1?ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8cGVrYWxvbmdhbnxlbnwwfHwwfHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60"
            )
        )

        city.add(
            City(
                "3",
                "Magelang",
                "399 + Penginapan",
                "https://images.unsplash.com/photo-1622635231200-259e6d0e0abb?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTJ8fG1hZ2VsYW5nfGVufDB8fDB8fA%3D%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60"
            )
        )

        return city
    }

    fun generateHotel(): List<Hotel> {
        val hotel = arrayListOf<Hotel>()

        hotel.add(
            Hotel(
                "1",
                "Holbox",
                "Kecamatan Denmark",
                "Rp1.000.300",
                "https://images.unsplash.com/photo-1563911302283-d2bc129e7570?ixid=MnwxMjA3fDB8MHxzZWFyY2h8Nnx8aG90ZWx8ZW58MHx8MHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60"
            )
        )

        hotel.add(
            Hotel(
                "2",
                "Guadalajara",
                "Kecamatan Ciamis",
                "Rp3.000.300",
                "https://images.unsplash.com/photo-1522798514-97ceb8c4f1c8?ixid=MnwxMjA3fDB8MHxzZWFyY2h8NXx8aG90ZWx8ZW58MHx8MHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60"
            )
        )

        hotel.add(
            Hotel(
                "2",
                "Bali Beach",
                "Kecamatan Bali",
                "Rp2.000.300",
                "https://images.unsplash.com/photo-1582719508461-905c673771fd?ixid=MnwxMjA3fDB8MHxzZWFyY2h8N3x8aG90ZWx8ZW58MHx8MHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60"
            )
        )

        return hotel
    }

}
