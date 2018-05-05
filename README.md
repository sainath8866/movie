## Application
- Rest API to perform CRUD operations on movies.
- Supported Operations : GetAll, GetOne, Add, Update, Delete

##Json for POST/PUT  (http://localhost:8080/movies   || http://localhost:8080/movies/{movieName}
- [
    {
        "name": "The Matrix",
        "language": null,
        "rating": "8.7",
        "directors": [
            "Lana Wachowski",
            "Lilly Wachowski"
        ],
        "releaseDate": "1999-03-31T00:00:00.000+0000",
        "cast": [
            {
                "role": "Neo",
                "name": "Keanu Reaves"
            },
            {
                "role": "Morpheus",
                "name": "Laurence Fishburne"
            }
        ]
    }
]
